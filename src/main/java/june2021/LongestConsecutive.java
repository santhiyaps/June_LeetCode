package june2021;

import java.util.Arrays;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int count=1;
        int maxCount=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                if(nums[i]-nums[i-1]==1) {
                    count++;
                    maxCount=Math.max(count,maxCount);
                }
                else{
                    count=1;
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutive().longestConsecutive(new int[]{0,3,7}));
    }
}
