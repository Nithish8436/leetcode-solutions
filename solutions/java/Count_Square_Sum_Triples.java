class Solution {
    public int countTriples(int n) {
      boolean issquare[]=new boolean[n*n+1];

      for(int i=1;i<=n;i++)
      {
        issquare[i*i]=true;
      }

      int count=0;
      for(int a=1;a<=n;a++){
        for(int b=1;b<=n;b++)
        {
            int c2=a*a+b*b;
            if(c2<=n*n&&issquare[c2])
            {
                count++;
            }
        }

      }
      return count;
      
    }
    
}