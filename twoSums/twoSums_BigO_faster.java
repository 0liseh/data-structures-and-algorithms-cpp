import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class twoSums_BigO_faster {
    public int[] twoSum(int[] nums, int target) {
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
