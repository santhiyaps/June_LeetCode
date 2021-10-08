package may2021;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int count=0;
        int min_value=Integer.MIN_VALUE;;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<=nums[i+1]){
                min_value=nums[i];
            }else{
                if(nums[i+1]<min_value)
                    nums[i+1]=nums[i];
                count++;
                if(count>1)
                    return false;
            }
        }
        return true;
    }
}
