/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heart_diseases_classification;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Bhailoo
 */
public class Heart_Diseases_Classification {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        BufferedReader reader ;
        reader = new BufferedReader(new FileReader("src/heart_diseases_training.csv"));
        String line=null;
        Scanner scanner = null;
        int index=0;
        int Recognized_Class=0;
        float []attribute=new float[13];
        int given_class=0;
        /*Intialization of arrays of each cluster*/
        double classified_as_zero[] =new double[2];
        double classified_as_one[]=new double[2];
        double classified_as_two[]=new double[2];
        double classified_as_three[]=new double[2];
        double classified_as_four[]=new double[2];
        
        
        
        
        classified_as_zero[0]=0;
        classified_as_one[0]=0;
        classified_as_two[0]=0;
        classified_as_three[0]=0;
        
        
            
            for(int i=1;i<250;i++)
            {
               
                line=reader.readLine();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                for(int k=0;k<13;k++)
                {
                     attribute[k]=Float.valueOf(scanner.next());
                }
               
                 given_class=Integer.valueOf(scanner.next());

                double node_value;  
            node_value = Give_Value(attribute);
                    switch(given_class)
                    {
                        
                             
                        case 0:
                        {
                           if(classified_as_zero[0]==0)
                           {
                               classified_as_zero[0]=node_value;
                           }
                            classified_as_zero[1]=node_value;
                            classified_as_zero[0]=(classified_as_zero[0]+classified_as_zero[1])/2;
                            break;
                        }
                        case 1:
                        {
                            if(classified_as_one[0]==0)
                            {
                                classified_as_one[0]=node_value;
                            }
                            classified_as_one[1]=node_value;
                           classified_as_one[0]=(classified_as_one[0]+classified_as_one[1])/2;
                           break;
                        }
                        case 2:
                        {
                             if(classified_as_two[0]==0)
                            {
                                classified_as_two[0]=node_value;
                            }
                            classified_as_two[1]=node_value;
                           classified_as_two[0]=(classified_as_two[0]+classified_as_two[1])/2;
                           break;
                        }
                        case 3:
                        {
                             if(classified_as_three[0]==-1)
                            {
                                classified_as_three[0]=node_value;
                            }
                            classified_as_three[1]=node_value;
                           classified_as_three[0]=(classified_as_three[0]+classified_as_three[1])/2;
                           break;
                        }
                            
                    }
                }
            
                /*Assigning the centroid to seperate variable*/
            double Heart_Disease_0_centroid=classified_as_zero[0];
            double Heart_Disease_1_centroid=classified_as_one[0];
            double Heart_Disease_2_centroid=classified_as_two[0];
            double Heart_Disease_3_centroid= classified_as_three[0];
            
           System.out.println("Heart_Disease_0__Centroid:      :"+Heart_Disease_0_centroid);
           System.out.println("Heart_Disease_1_centroid:       :"+Heart_Disease_1_centroid);
           System.out.println("Heart_Disease_2_centroid       :"+Heart_Disease_2_centroid);
           System.out.println("Heart_Disease_3_centroid :"+Heart_Disease_3_centroid);
           Check_Efficiency p;
           
           new Check_Efficiency(Heart_Disease_0_centroid,Heart_Disease_1_centroid,Heart_Disease_2_centroid,Heart_Disease_3_centroid);
           
           
    }
   

    @SuppressWarnings("empty-statement")
    static double Give_Value(float[] attribute) {
               double[] weight_of_attributes = {2.39,14.7,6.9,1.86,0.94,8.54,16.67,2.05,14.86,2.36,6.39,6.49,15.83};
               double node_value;
               
               //weight_of_attributes 
               node_value=0;
               
               for(int k=0;k<13;k++)
               {
                   node_value+=weight_of_attributes[k]*attribute[k];
               }
               return node_value;

};
              
}
               

               

       
    

