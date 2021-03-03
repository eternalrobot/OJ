package com.leetcode;

public class LK001 {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==j)continue;
                if(target==nums[i]+nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
