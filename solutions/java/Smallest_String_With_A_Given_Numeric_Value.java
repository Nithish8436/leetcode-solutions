class Solution {
    public String getSmallestString(int n, int k) {
        

       char[] arr=new char[n];
       int sum=0;
       for(int i=0;i<n;i++)
       {
         arr[i]='a';
         sum=sum+1;
       }

       if(sum==k)
       {
        return new String(arr);
       }

       
          for(int i=n-1;i>=0;i--)
          {
            int result=k-sum;

            if(result==0) break;

            int add=Math.min(25,result);
            arr[i]=(char)('a'+add);
            sum=sum+add;


          }
           return new String(arr);
    }
}