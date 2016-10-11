

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * Stohastički gradijentni spust.
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 *
 */
public class OnlineGradientDescent  {

	private Rule[] rules;
        
        

	private double η;

	private Random rand;

	/**
	 * Constructor.
	 * @param rulesCount
	 * @param norm
	 * @param function
	 * @param mf
	 */
	public OnlineGradientDescent(int rulesCount, double η, Random rand) {

		this.rand = rand;

		this.η = η;
              

		createRules(rulesCount);
	}

	/**
	 * Rule maker.
	 * @param rulesCount
	 */
	private void createRules(int rulesCount) {

		this.rules = new Rule[rulesCount];

		for (int i = 0; i < rules.length; i++) {

			rules[i] = new Rule(
					new MF1(rand), 
					new MF1(rand), 
					new HamacherProduct(), 
					new Conclusion(rand));

		}

	}

	/**
	 * Computing Network Output For Input.
	 * @param x
	 * @param y
	 */
	private double compute(double x, double y) {

		double[] w = new double[rules.length];
		Arrays.fill(w, 0);
		double weightSum = 0;

		//LAYER 1 AND LAYER 2
		for (int i = 0; i < rules.length; i++) {
			w[i] = rules[i].weight(x, y);
                        
			weightSum += w[i];
		}

		//LAYER 3, 4 AND LAYER 5
		double f = 0;
		for (int i = 0; i < rules.length; i++) {
			f += w[i]*rules[i].conclude(x, y)/weightSum;
		}

		return f;
	}

	/**
	 * Online Network Learning.
	 * @param learningDataset
	 * @param error
	 */
	private double learnNetwork(List<Pair> learningDataset) {

		double error = 0.0;

		//Collections.shuffle(learningDataset);

		for (int j = 0; j < learningDataset.size(); j++) {

			double x = learningDataset.get(j).x;
			double y = learningDataset.get(j).y;
			double value = learningDataset.get(j).value;

			//all the same if up or down
			double sumw = sumWeights(x,y);

			//network value
			double z = compute(x, y);

			for (int i = 0; i < rules.length; i++) {

				double weight = rules[i].weight(x, y);
				double μA = rules[i].mfA.compute(x);
				double μB = rules[i].mfB.compute(y);

				//real value
				double o = value;

				double a1 = rules[i].mfA.a;
				double b1 = rules[i].mfA.b;
				double a2 = rules[i].mfB.a;
				double b2 = rules[i].mfB.b;

				double σ = Σ(i, x, y);

				//antecedent learning
				rules[i].mfA.a = a1 + 
						η*(o-z) * 
						σ/Math.pow(sumw,2) * 
						(μB*μB)/Math.pow(μA+μB-μA*μB, 2) *
						b1*μA*(1-μA);

				rules[i].mfA.b = b1 +
						η*(o-z) * 
						σ/Math.pow(sumw,2) * 
						(μB*μB)/Math.pow(μA+μB-μA*μB, 2) *
						(-(x-a1))*μA*(1-μA);

				rules[i].mfB.a = a2 + 
						η*(o-z) * 
						σ/Math.pow(sumw,2) * 
						(μA*μA)/Math.pow(μA+μB-μA*μB, 2) *
						b2*μB*(1-μB);

				rules[i].mfB.b = b2 +
						η*(o-z) * 
						σ/Math.pow(sumw,2) * 
						(μA*μA)/Math.pow(μA+μB-μA*μB, 2) *
						(-(y-a2))*μB*(1-μB);


				//consequent learning
				rules[i].conclusion.p = rules[i].conclusion.p + η*(o-z)*weight/sumw*x;
				rules[i].conclusion.q = rules[i].conclusion.q + η*(o-z)*weight/sumw*y;
				rules[i].conclusion.r = rules[i].conclusion.r + η*(o-z)*weight/sumw;	

			}

			error += 0.5*(compute(x, y)-value)*(compute(x, y)-value);

		}

		return error;

	}

	/**
	 * Sum weights of all rules for sample (x,y).
	 * @param x
	 * @param y
	 * @return
	 */
	private double sumWeights(double x, double y) {

		double sumW = 0;

		for (int i = 0; i < rules.length; i++) {
			sumW += rules[i].weight(x, y);
		}

		return sumW;
	}

	/**
	 * Sum weights of all rules for sample (x,y) 
	 * except rule i.
	 * @param i
	 * @param x
	 * @param y
	 * @return
	 */
	private double Σ(int i, double x, double y) {
		double sum = 0;

		double zi = rules[i].conclusion.compute(x, y);

		for (int j = 0; j < rules.length; j++) {
			if (j != i) {
				sum += rules[j].weight(x, y)*(zi-rules[j].conclusion.compute(x, y));
			}
		}
		return sum;
	}

	/**
	 * Validation.
	 * @param learningDataset
	 */

	public double validateLearned(List<Pair> learningDataset,double x1,double y1) {

		for (int i = 0; i < learningDataset.size(); i++) {
			double x = learningDataset.get(i).x;
			double y = learningDataset.get(i).y;
			double value = learningDataset.get(i).value;
      // System.out.println(x+" "+y+"  "+value);
			double f = compute(x,y);

  System.out.println("Learned: " + f + " Real: " + value + " Error: " + Math.abs(f-value));
		}
                return compute(x1,y1);

	}

	
	public void learnNetworkError(List<Pair> learningDataset, double error) {

		double iterError = 0;

		int epoch = 0;

		do {

			iterError = learnNetwork(learningDataset);

			epoch++;

			System.out.println("Error: " + iterError + " More: " + (iterError - error) + " Epoch: " + epoch);

		} while (iterError > error);

	}

	
	public void learnNetworkEpoch(List<Pair> learningDataset, int epoch) {

		double iterError = 0;

		for (int e = 0; e < epoch; e++) {

			iterError = learnNetwork(learningDataset);

			System.out.println("Error: " + iterError + " Epoch: " + e);

		}

	}

	
	

	
	public void learnNetworkRules(List<Pair> learningDataset, int startRuleNum,
			int endRuleNum, int epochPerRule) {

		double smallestError = 0;
		int bestRuleCount = 0;
                int f=0;

		for (int r = startRuleNum; r <= endRuleNum; r++) {

			createRules(r);
			double iterError = 0;
			
			System.out.println("==========");

			for (int e = 0; e < epochPerRule; e++) {

				iterError = learnNetwork(learningDataset);

				//System.out.println("Rules: " + r + " Epoch: " + e + " Error: " + iterError);

			}
                        if(!Double.isNaN(iterError))
                        {
                            
                        System.out.println(r+"**"+startRuleNum+"**"+iterError+"");
                        if(f==0)
                        {
                            smallestError=iterError;
                            f=1;
                        }
			if ( iterError < smallestError) {
				bestRuleCount = r;
				smallestError = iterError;
			}
                        }

		}

		System.out.println("Best Rule Count: " + bestRuleCount + " Error: " + smallestError);
                System.out.println(rules[bestRuleCount-1].conclusion);

	}

}