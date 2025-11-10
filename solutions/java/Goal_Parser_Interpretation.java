class Solution {
    public String interpret(String command) {
        int n=command.length();

        String result="";

        for(int i=0;i<n;i++)
        {
            if(command.charAt(i)=='('&&command.charAt(i+1)==')')
            {
                result=result+"o";
            }
            else if(command.charAt(i)=='('&&command.charAt(i+1)=='a'&&command.charAt(i+2)=='l'&&command.charAt(i+3)==')')
            {
                result=result+"al";
            }
            else if(command.charAt(i)=='G')
            {
                result=result+'G';
            }
            

        }

        return result;
    }
}