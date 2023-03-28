import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class twoSums_BigO_faster {

    public static void main(String[] args){
        int [] nums = {3,4,5,7,3};
        System.out.println("This is the array: " + Arrays.toString(twoSumv3(nums, 6)));
    }

    //this is the way I wanted to do it, but i didnt do it the right way before. 
    //You are supposed to use a hashmap
    //This is the correct solution
    public static int[] twoSumv3(int[] nums, int target) {
        //create a map
        Map<Integer, Integer> numToIndex = new HashMap<>();

        //loop through the array
        for (int i = 0; i < nums.length; i++) {

            //check if the difference of the target from num[i] exists in the hash map
            //But why? I'll add a breakpoint and check
            if (numToIndex.containsKey(target - nums[i])) {
                //then we break the loop and return the index pair to the user
                return new int[] {numToIndex.get(target - nums[i]), i};
            }

            //if we didn't find the right index pair in the iteration, we just add the current value we are looking at to the hash map
            numToIndex.put(nums[i], i);
        }

        //we return an empty array if we can't find any pairs that add up tot the target
        return new int[] {};
    }

    //stayed within time limit, but is worse than the O(n^2)
    //commented it out becuase .toList() wasn't working
    /*public int[] twoSumv2(int[] nums, int target) {
        int position1 = 0;
        int position2 = -1;
        List<Integer> newList = Arrays.stream(nums).boxed().toList();
        for(int i = 0; i < nums.length; i++){
            //find the difference
            int diff = target - nums[i];

            //look for the difference and get the index
            position2 = newList.indexOf(diff);

            //check if the difference was actually found and if it didnt just pick the index, i
            if(position2 != -1 && position2 != i){
                position1 = i;
                break;
            }            
        }

        int[] array = {position1, position2};

        return array;
    }*/

    //this exceeds the time limit put by leetcode, so its even slower
    public int[] twoSumv1(int[] nums, int target) {
        int position1 = 0;
        int position2 = -1;
        for(int i = 0; i < nums.length; i++){
            //find the difference
            int diff = target - nums[i];

            //look for the difference and get the index
            position2 = IntStream.of(nums).boxed().collect(Collectors.toList()).indexOf(diff);

            //check if the difference was actually found and if it didnt just pick the index, i
            if(position2 != -1 && position2 != i){
                position1 = i;
                break;
            }            
        }

        int[] array = {position1, position2};

        return array;
    }
}
