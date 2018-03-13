package trees;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Swap_Nodes {
    public static class Node
    {
        int val;
        Node left;
        Node right;
           public Node(int d)
           {
            this.val = d;
           }
        public String toString()
        {
            if(this != null)
                return this.val+" left child:"+ ((this.left != null)? this.left.val: "NULL") + " right child:"+ ((this.right != null) ? this.right.val: "NULL");
//            else if((this != null))
//            	return this.val+"";
            else
                return "NULL";
        }
    }
    public void swapAtKth(Node root, int k, int level )
    {
        Node temp;
        if((root == null) || ((root.left == null) && (root.right == null)))
        {
            return;
        }
        if((level%k) == 0)
        {
            temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        swapAtKth(root.left,k,level+1);
        swapAtKth(root.right,k,level+1);
    }
    public void swapAtKLvl(Node root, int k)
    {
        swapAtKth(root,k,1);
        printInorder(root);
    }
    public void printInorder(Node root)
    {
        if(root != null)
        {
            printInorder(root.left);
            System.out.print(root.val+" ");
            printInorder(root.right);
        }
        
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Queue<Node> queue=new LinkedList<Node>(); 
        Swap_Nodes s = new Swap_Nodes();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Node root = new Node(1);
        Node curr;
        if(root != null)
        {
            queue.add(root);
        }
        while((Node)queue.peek() != null)
        {   
            curr = (Node)queue.remove();
            int l, r;
            l = in.nextInt();
            r = in.nextInt();
            System.out.println(l+"<"+curr.val+">"+r);
            if(l>-1)
            {
                curr.left = new Node(l);
                //add to queue
                queue.add(curr.left);
            }
            else
            {
                curr.left = null;
            }
            if(r>-1)
            {
                curr.right = new Node(r);
                //add to queue
                queue.add(curr.right);
                
            }
            else
            {
                curr.right = null;
            }
            //System.out.println(curr);
        }
        //s.printInorder(root);
         int times = in.nextInt();
         for(int j=0;j<times;j++)
         {
            int level = in.nextInt();
             s.swapAtKLvl(root, level);
             System.out.println();
         }
    }
}
