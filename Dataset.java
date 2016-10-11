

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Dataset {
	
	
	private List<Pair> trainingSet;
	
	public Dataset() {
		
		
		createLearningDataset();
		
	}
	
	private void createLearningDataset() {
		
		trainingSet = new ArrayList<>();
		
//		for (int i = min; i <= max; i++) {
//			for (int j = min; j<= max; j++) {
//				trainingSet.add(new Pair(
//						i,j,function.compute(i, j)
//						)
//				);
//			}
//		}
dbhelper db=new dbhelper();
String st="select * from dataset";
ResultSet res=db.dbcallq(st,"anfis");
 try {
                        res.next();

                       for (int i =0; i <36; i++) {
			int val1=res.getInt(1);
                        int val2=res.getInt(2);
                        int val3=res.getInt(3);
                        System.out.println(val3);
				trainingSet.add(new Pair(
						val1,val2,val3)
						
				);
                                res.next();
			
		}
//                     
//		for (int i = 0; i <36; i++) {
//                     int j=0;
//                    
//		               int val1=res.getInt(1);
//                               int val2=res.getInt(2);
//                               int val3=res.getInt(3);
//                               Learn[i][j]=val1;
//                               Learn[i][j+1]=val2;
//                               preout[i][j]=val3;
//                              
//			res.next();
//			
//		}
                    }         
        catch(Exception e)
        {
         System.out.println(e); 
        }
		
	}
	
	

	public List<Pair> getTrainingSet() {
		return trainingSet;
	}
	
}