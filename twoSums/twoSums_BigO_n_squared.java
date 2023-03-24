//Big-O: O(n^2)
class twoSums_BigO_n_squared{
    public int[] twoSum(int[] nums, int target) {
        int position1 = 0;
        int position2 = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j < nums.length - 1; j++){
                if((nums[i] + nums[j]) == target && i!=j){
                    position1 = i;
                    position2 = j;
                }
            }
        }

        int[] array = {position1, position2};

        return array;
    }
}