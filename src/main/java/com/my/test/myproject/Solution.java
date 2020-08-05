package com.my.test.myproject;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Ruixiao.Xu
 * @Date: 21/7/20 3:49 PM
 */
public class Solution {

    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例:
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * 说明:
     *
     * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     * 你算法的时间复杂度应该为 O(n2) 。
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     *
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int[] ans=new int[nums.length];
        Arrays.fill(ans,1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    ans[i]=ans[j]+1;
                }
            }
        }
        int max=0;
        for(int a: ans){
            max=Math.max(max,a);
        }
        return max;
    }

    boolean res=false;
    public boolean exist(char[][] board, String word) {
        if(board.length==0){
            return false;
        }
        //dfs(board,word,0,0,0,new boolean[board.length][board[0].length]);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,word,i,j,0,new boolean[board.length][board[0].length]);
                if(res){
                    return true;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, String word,int i,int j,int index,boolean[][] access){
        if(i<board.length&&i>=0&&j<board[0].length&&j>=0&&index<word.length()){
            //System.out.println(board[i][j]);
            if(access[i][j]){
                return;
            }
            if(word.charAt(index)!=board[i][j]){
                return;
            }
            System.out.println(word.charAt(index)+","+index+", i="+i+", j="+j);
            access[i][j]=true;
            if(index==word.length()-1){
                res=true;
            }

            dfs(board,word,i+1,j,index+1,access);
            dfs(board,word,i-1,j,index+1,access);
            dfs(board,word,i,j+1,index+1,access);
            dfs(board,word,i,j-1,index+1,access);

        }
    }



    @Test
    public void testExist(){
        //char[][] board, String word
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word="ABCESEEEFS";
        exist(board,word);
    }

}
