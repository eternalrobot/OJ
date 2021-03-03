package com.leetcode;

public class JZ04 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n=matrix.length;
        if(n==0)return false;
        int m=matrix[0].length;
        for(int i=0;i<m;i++){
            if(matrix[0][i]>target){
                m=i;
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[i][0]>target){
                n=i;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(target==matrix[j][i])return true;
            }
        }
        return false;
    }
    public static void main(String[] args)  {
        findNumberIn2DArray(new int[0][0],0);
    }
}
