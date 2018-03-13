package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Balanced_brackets {
	static String isBalanced(String s) {
        // Complete this function
		// Complete this function
        Stack st = new Stack();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            char cm;
            //if((ch == '{') 
            if((ch == '}') || (ch == ')') || (ch == ']')) 
            {
                if(st.size() == 0) { return "NO"; }
                cm = (char)st.pop();
                if(((cm == '{') && (ch == '}')) || ((cm == '(') && (ch == ')')) || ((cm == '[') && (ch == ']')))
                {
                    //do nothing
                }
                else
                {
                    return "NO";
                }
                
            }
            else
            {
                st.push(s.charAt(i));
            }
        }
        if(st.size() == 0)
            return "YES";
        else
            return "NO";
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			    
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
	    
	}

}
