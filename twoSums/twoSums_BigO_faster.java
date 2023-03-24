import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class twoSums_BigO_faster {

    //stayed within time limit, but is worse than the O(n^2)
    public int[] twoSumv2(int[] nums, int target) {
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
    }

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
