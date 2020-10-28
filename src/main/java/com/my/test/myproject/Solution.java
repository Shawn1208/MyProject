package com.my.test.myproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Ruixiao.Xu
 * @Date: 21/7/20 3:49 PM
 */
public class Solution {

    public Solution(){

    }

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


    /***
     * 峰值元素是指其值大于左右相邻值的元素。
     *
     * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
     *
     * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
     *
     * 你可以假设 nums[-1] = nums[n] = -∞。
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,1]
     * 输出: 2
     * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
     * 示例 2:
     *
     * 输入: nums = [1,2,1,3,5,6,4]
     * 输出: 1 或 5
     * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
     *      或者返回索引 5， 其峰值元素为 6。
     * 说明:
     *
     * 你的解法应该是 O(logN) 时间复杂度的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-peak-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(true){
            int middle = (start + end) / 2;
            if (middle + 1 < nums.length && nums[middle] < nums[middle + 1]) {
                start = middle + 1;
            } else if (middle - 1 >= 0 && nums[middle] < nums[middle - 1]){
                end = middle - 1;
            }else {
                return middle;
            }
        }
    }

    /**
     * 打乱一个没有重复元素的数组。
     *
     *  
     *
     * 示例:
     *
     * // 以数字集合 1, 2 和 3 初始化数组。
     * int[] nums = {1,2,3};
     * Solution solution = new Solution(nums);
     *
     * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
     * solution.shuffle();
     *
     * // 重设数组到它的初始状态[1,2,3]。
     * solution.reset();
     *
     * // 随机返回数组[1,2,3]打乱后的结果。
     * solution.shuffle();
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shuffle-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    int[] originNums;
//    public Solution(int[] nums) {
//        originNums=nums;
//    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originNums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle(int[] result) {
        //int[] result = new int[originNums.length];
        //System.arraycopy(originNums, 0, result, 0, result.length);
        for (int i = result.length - 1; i > 0; i--) {
            int random = new Random().nextInt(i);
            //System.out.println(random);
            int temp = result[random];
            result[random] = result[i];
            result[i] = temp;
        }
        for(int a: result){
            System.out.println(a);
        }
        return result;
    }

    @Test
    public void test(){
        int[] result = new int[] {
            99,2,3,4,5,6,7
        };
        shuffle(result);

    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */

}
