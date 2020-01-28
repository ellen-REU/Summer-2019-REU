import java.util.HashMap;
import java.util.Map;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BallsinBinsHashMap {
    public static void main(String[] args) {
  
   int overallMaxLoad = 0;
   int overallNum0Bins = 0;
   int expNum0Bins = 0;
    for (int k = 0; k < 1000; k++) {
          
        // Creating a HashMap
        Map<Integer, Integer> ballMapping = new HashMap<>();
                
        // Labeling variables
        int numBalls = 30;
        int numBins = 30;
        int numChoices = 2;
        int sum = 0;
        
        // Setting all values in hashmap to 0
        for (int i = 0; i < numBins; i++) {
            ballMapping.put(i, 0);
         } 
        
        Bin[] arr;
        arr = new Bin[numChoices];

        for (int j = 0; j < numBalls; j++) { //This iterates the process for all the balls.
        // This is the process for one ball.
        // Getting loads of d choices and summing them as well as putting bin numbers into an array
        ArrayList<Integer> choices = new ArrayList<>();
        ArrayList<Integer> loads   = new ArrayList<>();
        
        for (int i = 0; i < numChoices; i++) {
            int binNumber = ThreadLocalRandom.current().nextInt(0, numBins);
            choices.add(binNumber);
            int load = ballMapping.get(binNumber);
            loads.add(load);
            arr[i] = new Bin(binNumber, load);
            sum = sum + load;
         }
        
        for(int i = 0; i < choices.size(); i++){
        // System.out.print(String.format("Choice %d Load %d \n", choices.get(i), loads.get(i)));
         
        }
        
        // Placing ball in bin with average load 
        int average = (int) Math.floor( (float) sum/(float )numChoices);
        sum = 0;
       // System.out.println(String.format("Average load for choices %d, sum %d, numChoices %d", average, sum, numChoices));
        int binWithAverageLoad = -1;
        while (binWithAverageLoad == -1) {
            for (int i = 0; i < numChoices; i++) {
               if (arr[i].loadArray == average ){
                   binWithAverageLoad = arr[i].binArray;
                   break;
               }
            }
            if(binWithAverageLoad == -1) {
            average = average - 1;
            }
        }
         ballMapping.put(binWithAverageLoad, average + 1);
         
       }
       // Printing bin loads and max load
       // System.out.println(ballMapping);
      //  int maxLoad = ballMapping.get(0);
      //  for (int i = 1; i < numBins; i++) {
      //      if (maxLoad < ballMapping.get(i)) {
      //         maxLoad = ballMapping.get(i);
      //      }
      //  }
       
        // Get number of 0 loaded bins
        int num0Bins = 0;
        for (int i = 0; i < numBins; i++) {
            if (ballMapping.get(i) == 0){
               num0Bins = num0Bins + 1;
            }
        }
        overallNum0Bins = overallNum0Bins + num0Bins;
        
       // System.out.println(maxLoad);
    //   if (maxLoad > overallMaxLoad) {
    //        overallMaxLoad = maxLoad;
    //   }
    }
    
    // Get expected number of 0 bins and print
    expNum0Bins = overallNum0Bins/1000;
    System.out.println(expNum0Bins);
    
  //  System.out.println(overallMaxLoad);
    }
}


    // Create variables for bin array
    class Bin     {
        public int binArray;
        public int loadArray;
        Bin(int binArray, int loadArray)
        {
            this.binArray = binArray;
            this.loadArray = loadArray;
        }

   }