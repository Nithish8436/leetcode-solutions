class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1])
            {
              sum=sum+nums[i];
            }
            else
              sum=nums[i];

            if(sum>max)
            {
                max=sum;
            }
        }

        return max;
    }
}