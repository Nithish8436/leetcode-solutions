class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;

        if(n==0) return 0;

        int count=1;
        int max=1;

        for(int i=1;i<n;i++)    //we start with second value
        {
            if(nums[i]>nums[i-1])  //check current value vs previoys valye
            { 
                count++;
            }
            else
             count=1;     //reset

            max=Math.max(max,count);   //use the max to store the longest count
        }
        return max;
    }
}