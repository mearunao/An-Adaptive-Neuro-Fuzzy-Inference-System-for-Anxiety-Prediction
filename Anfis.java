

import java.sql.ResultSet;
import java.util.Random;



/**
 * ANFIS
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 */
public class Anfis {
    double x,y;
    String id;
    public Anfis()
    {
      this.x=50;
       this.y=40;
       this.id=id;
       int RULES = 9;
		//0.002 INITIAL MU
		//0.006 BIG MU
		//0.00002 SMALL MU
		double η = 0.002;
		
	
		
	       
		Dataset dataset = new Dataset();
		
		OnlineGradientDescent obj = new OnlineGradientDescent(RULES, η, new Random());
		
		//----------------network learning----------------
		obj.learnNetworkEpoch(dataset.getTrainingSet(),100);
                
		
		//obj.learnNetworkRules(dataset.getTrainingSet(),1, 9,1000);
		
		
		Double res=obj.validateLearned(dataset.getTrainingSet(),x,y);
                 System.out.println(x+"  "+y+"    res= "+res);
                
    }
    public Anfis(double x,double y,String id)
    
    {
       this.x=x;
       this.y=y;
       this.id=id;
       int RULES = 9;
		//0.002 INITIAL MU
		//0.006 BIG MU
		//0.00002 SMALL MU
		double η = 0.002;
		
	
		
	       
		Dataset dataset = new Dataset();
		
		OnlineGradientDescent obj = new OnlineGradientDescent(RULES, η, new Random());
		
		//----------------network learning----------------
		obj.learnNetworkEpoch(dataset.getTrainingSet(),1000);
                
		
		//obj.learnNetworkRules(dataset.getTrainingSet(),1, 9,1000);
		
		
		Double res=obj.validateLearned(dataset.getTrainingSet(),x,y);
                System.out.println(x+"  "+y+"    res= "+res);
               
                dbhelper db=new dbhelper();
                String st="select * from evalmark where id='"+id+"'";
                ResultSet chk=db.dbcallq(st,"anfis");
                String ins="insert into evalmark values('"+id+"','"+res+"')";
                try
                {
                 if (chk.next())
                  {
                    ins="update evalmark set mark='"+res+"' where id='"+id+"'" ;        
                   }
                }
                catch(Exception e)
                {
                 System.out.println(e);   
                }
                db.dbcallup(ins,"anfis");
    }
	
	public static void main(String[] args) {
		
		
      Anfis ans=new Anfis();
	}

}
