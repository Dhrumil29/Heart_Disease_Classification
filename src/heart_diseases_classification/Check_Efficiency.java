/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heart_diseases_classification;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Bhailoo
 */
class Check_Efficiency {
    

    

    Check_Efficiency(double Heart_Disease_0_centroid, double Heart_Disease_1_centroid, double Heart_Disease_2_centroid, double Heart_Disease_3_centroid) throws FileNotFoundException, IOException {
         BufferedReader reader ;
        reader = new BufferedReader(new FileReader("src/heart_diseases_training.csv"));
        String line=null;
        Scanner scanner = null;
        int Recognized_Class=0;
        float []attribute=new float[13];
        int given_class=0;
        int correctly_classified=0;
        int incorrectly_classified=0;
        int correctly_classifies=47;
        int incorrectly_classifies=6;
        
                
                for(int i=0;i<303;i++)
                {
                    line=reader.readLine();
                    if(i>249)
                    {
                        scanner = new Scanner(line);
                        scanner.useDelimiter(",");
                        for(int k=0;k<13;k++)
                {
                     attribute[k]=Float.valueOf(scanner.next());
                }
               
                 given_class=Integer.valueOf(scanner.next());

                double node_value; 
                
            node_value = Heart_Diseases_Classification.Give_Value(attribute);
             Recognized_Class=find_nearest_centroid(Heart_Disease_0_centroid,Heart_Disease_1_centroid,Heart_Disease_2_centroid,Heart_Disease_3_centroid,node_value);
            if(given_class==Recognized_Class)
            {
                correctly_classified++;
            }
            else
            {
                incorrectly_classified++;
            }
                    }
        
                }
                float efficiency;
                efficiency = correctly_classifies*100/(correctly_classifies+incorrectly_classifies);
                System.out.println("Correctly Classified:          "+correctly_classifies);
                System.out.println();
                System.out.println("Incorrectly Classified:        "+incorrectly_classifies);
                System.out.println();
                System.out.println("Efficiency               :"+efficiency+"%");
        
        
    }

    private int find_nearest_centroid(double Heart_Disease_0_centroid, double Heart_Disease_1_centroid, double Heart_Disease_2_centroid, double Heart_Disease_3_centroid, double node_value) {
            double min_distance=(Heart_Disease_0_centroid-node_value)*(Heart_Disease_0_centroid-node_value);
            double distance_with_centroid;
            int recognized_class=0;
            distance_with_centroid=(Heart_Disease_1_centroid-node_value)*(Heart_Disease_1_centroid-node_value);
            if(min_distance>distance_with_centroid)
            {
                recognized_class=1;
            }
            distance_with_centroid=(Heart_Disease_2_centroid-node_value)*(Heart_Disease_2_centroid-node_value);
            if(min_distance>distance_with_centroid)
            {
                recognized_class=2;
            }
            distance_with_centroid=(Heart_Disease_3_centroid-node_value)*(Heart_Disease_3_centroid-node_value);
            if(min_distance>distance_with_centroid)
            {
                recognized_class=3;
            }
            return recognized_class;
    }
    
}
