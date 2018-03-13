package trees;

public class OrderTraversal {
	public void preorder(Node root)
	{
		if(root != null)
	    {
		System.out.print(root.data);
	    System.out.print(" ");
	    preorder(root.left);
	    preorder(root.right);
	    }
	}
	public void postorder(Node root)
	{
		if(root != null)
	    {
		postorder(root.left);
		postorder(root.right);
	    System.out.print(root.data);
	    System.out.print(" ");
	    
	    }
	}
	public void inorder(Node root)
	{
		if(root != null)
	    {
		inorder(root.left);
	    System.out.print(root.data);
	    System.out.print(" ");
	    inorder(root.right);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
