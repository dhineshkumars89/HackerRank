package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	void levelOrder(Node root) {
	       Node n;
	      Queue<Node> queue=new LinkedList<Node>();  
	      if(root != null)
	      {
	          queue.add(root);
	      }
	      while((Node)queue.peek() != null)
	      {
	          n = (Node)queue.remove();
	          System.out.print(n.data+" ");
	          if(n.left != null)
	              queue.add(n.left);
	          if(n.right != null)
	              queue.add(n.right);

	      }
	       
	       
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
