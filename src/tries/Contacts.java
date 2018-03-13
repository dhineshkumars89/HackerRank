package tries;

import java.util.Scanner;

public class Contacts {
	 public static class Trie {
	    //public static int countAll = 0;
	    public static final int ALPHABET_SIZE = 26;
	    boolean isEnd;
	    Trie child[];
	    char data;
	    int count;
	    /** Initialize your data structure here. */
	    public Trie() {
	        
	        this.isEnd = false;
	        this.child = new Trie[ALPHABET_SIZE];
	        this.count = 0;
	        // this.data = data;
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        Trie curr = this;
	        curr.count = curr.count + 1;
	        for(int i=0;i<word.length();i++)
	        {
	            int ind = (int)word.charAt(i) - 'a';
	            if(curr.child[ind] == null)
	            {
	                curr.child[ind] = new Trie();
	            }
	            curr.child[ind].data = word.charAt(i);
	            curr.child[ind].count = curr.child[ind].count + 1;
	            curr = curr.child[ind];
	        }
	        curr.isEnd = true;
	    }
	    
	    //Count number of string
	    public int countString(String prefix)
	    {
	        Trie curr = this;
	        if(prefix.length() == 0) { 
	            return curr.count; 
	        }
	        for(int i=0;i<prefix.length();i++)
	        {
	            int ind = (int)prefix.charAt(i) - 'a';
	            if(curr.child[ind] == null)
	            {
	                return 0;
	            }
	            else if((i != prefix.length()-1) && (curr.child[ind].data == prefix.charAt(i)))
	            {
	                curr = curr.child[ind];
	            }
	            else if((i == prefix.length()-1) && (curr.child[ind].data == prefix.charAt(i)))
	            {
	                return curr.child[ind].count;
	            }
	            else
	            {
	                return 0;
	            }   
	        }
	        return 0;
	        
	        
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        Trie curr = this;
	        for(int i=0;i<word.length();i++)
	        {
	            int ind = (int)word.charAt(i) - 'a';
	            if(curr.child[ind] == null)
	            {
	                return false;
	            }
	            else if((i != word.length()-1) && (curr.child[ind].data == word.charAt(i)))
	            {
	                curr = curr.child[ind];
	            }
	            else if((i == word.length()-1) && (curr.child[ind].isEnd == true) && (curr.child[ind].data == word.charAt(i)))
	            {
	                return true;
	            }
	            else
	            {
	                return false;
	            }   
	        }
	        return true;
	        
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        Trie curr = this;
	        for(int i=0;i<prefix.length();i++)
	        {
	            int ind = (int)prefix.charAt(i) - 'a';
	            if(curr.child[ind] == null)
	            {
	                return false;
	            }
	            else if((i != prefix.length()-1) && (curr.child[ind].data == prefix.charAt(i)))
	            {
	                curr = curr.child[ind];
	            }
	            else if((i == prefix.length()-1) && (curr.child[ind].data == prefix.charAt(i)))
	            {
	                return true;
	            }
	            else
	            {
	                return false;
	            }   
	        }
	        return true;
	    }	
	
	    }
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	         Trie root = new Trie();
	        Scanner sc= new Scanner(System.in); 
			int ops = sc.nextInt();
	        for(int i=0;i < ops; i++)
	        {
	            String oper = sc.next();
	            if(oper.equals("add"))
	            {
	                root.insert(sc.next());
	            }
	            else if(oper.equals("find"))
	            {
	                System.out.println(root.countString(sc.next()));
	            }
	            else
	            {
	                System.out.println("Invalid operation");
	            }
	        }
	        sc.close();
	    }

}
