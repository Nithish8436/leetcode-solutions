class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String x[]=num1.split("\\+|i");   //it split the + or i and \\ is the escape it skip the x = ["3", "4", ""]

        String y[]=num2.split("\\+|i");

        int r1=Integer.parseInt(x[0]);
        int r2=Integer.parseInt(y[0]);
        int im1=Integer.parseInt(x[1]);
        int im2=Integer.parseInt(y[1]);

        return(r1*r2-im1*im2)+"+"+(r1*im2+r2*im1)+"i";   //(a + bi) * (c + di) = (a*c - b*d) + (a*d + b*c)i 

    }
}