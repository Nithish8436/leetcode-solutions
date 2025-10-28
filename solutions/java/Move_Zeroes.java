class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int count=0;


        // int[] newarr=new int[n];
        // for(int i=0;i<n;i++)
        // {
        //     if(nums[i]!=0)
        //     {
        //         newarr[j]=nums[i];
        //         j++;
        //     }

        // }
        
        // for(int i=0;i<n;i++)
        // {
        //     nums[i]=newarr[i];
        // }
        
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                count++;
            }
        }

        int index=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0)
            {
                nums[index]=nums[i];
                index++;
            }
        }

        while(count>0)
        {
            nums[index]=0;
            index++;
            count--;
        }

    }
}