//using string but it create the new new object each time.

// class Solution {
//     public String interpret(String command) {
//         int n=command.length();

//         String result="";

//         for(int i=0;i<n;i++)
//         {
//             if(command.charAt(i)=='('&&command.charAt(i+1)==')')
//             {
//                 result=result+"o";
//                   i++;
//             }
//             else if(command.charAt(i)=='('&&command.charAt(i+1)=='a'&&command.charAt(i+2)=='l'&&command.charAt(i+3)==')')
//             {
//                 result=result+"al";
//                 i=i+3;
//             }
//             else if(command.charAt(i)=='G')
//             {
//                 result=result+'G';
//             }
            

//         }

//         return result;
//     }
// }


//using stringbuilder to avoid new new object create for each time.

class Solution {
    public String interpret(String command) {
        int n = command.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (command.charAt(i) == 'G') {
                result.append('G');
            } else if (i+1<n && command.charAt(i) == '(' && command.charAt(i+1) == ')') {
                result.append('o');
                i++; 
            } else if (i+3<n&& command.charAt(i) == '(' 
                       && command.charAt(i+1) == 'a' 
                       && command.charAt(i+2) == 'l' 
                       && command.charAt(i+3) == ')') {
                result.append("al");
                i+=3; 
            }
        }

        return result.toString();
    }
}
