package trees;

public class HeightBinaryTree {
	//Option 1
	static int height(Node root) {
      	// Write your code here.
        if(root != null)
        {
            return Math.max(height(root.left)+1,height(root.right)+1);
        }
        else
        {
            return -1;
        }
    }
	//Option 2
	static public int getheight(Node root)
    {
        if(root != null)
        {
            int maxhgt=0;
            int lfthgt = getheight(root.left);
            int rgthgt = getheight(root.right);
            if(lfthgt > rgthgt)
            {
                maxhgt = lfthgt;
            }
            else
            {
                maxhgt = rgthgt;
            }
            return (maxhgt + 1);
        }
        else
        {
            return -1;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
