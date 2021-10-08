package oct2021;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List <Integer> list=new ArrayList<>();
        for(int i=0;i < nums.length; i++){
            int index= Math.abs(nums[i]);
            if(nums[index-1] < 0)
                list.add(index);
            else{
                nums[index-1]=nums[index-1] * -1;
            }
        }

        return list;
    }
}
