package lesson3;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayStrings extends ArrayList {
   public void addListOfArrayStrings(String[] arr){
       this.addAll(Arrays.asList(arr));
   }

   public void getUnicsElements(){
       ArrayStrings strArr = new ArrayStrings();
       strArr.addAll(this);
       for (int i = 0; i < this.size(); i++) {
                    int count = 0;
                    while (strArr.contains(this.get(i))){
                         count++;
                         strArr.remove(this.get(i));
                    }
                    if (count > 0){
                       System.out.printf( "%s count %d \n", this.get(i), count);
                    }
                }
             }
   }




