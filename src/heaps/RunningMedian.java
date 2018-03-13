package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
	PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(200, new MyComparator());
    public class MyComparator implements Comparator<Integer>
    {
        public int compare( Integer x, Integer y )
        {
            return y - x;
        }
    }
    public void insert(int val, PriorityQueue<Integer> minhp, PriorityQueue<Integer> maxhp)
    {
        if((maxhp.size() == 0) || (val < maxhp.peek()))
        {
            maxhp.add(val);
        }
        else
        {
            minhp.add(val);
        }
    }
    public void rebalance(PriorityQueue<Integer> minhp, PriorityQueue<Integer> maxhp)
    {
        PriorityQueue Biggerhp = ((minhp.size() < maxhp.size())? maxhp : minhp);
        PriorityQueue Smallerhp = ((minhp.size() < maxhp.size())? minhp : maxhp);
        if(((Biggerhp.size()-Smallerhp.size()) >= 2))
        {
            Smallerhp.add(Biggerhp.poll());
        }
    }
    public void getMedian(PriorityQueue<Integer> minhp, PriorityQueue<Integer> maxhp)
    {
        PriorityQueue Biggerhp = ((minhp.size() < maxhp.size())? maxhp : minhp);
        PriorityQueue Smallerhp = ((minhp.size() < maxhp.size())? minhp : maxhp);
        if(Biggerhp.size() == Smallerhp.size())
        {
            System.out.println((((double)((Integer) Biggerhp.peek()).intValue()) + ((double)((Integer) Smallerhp.peek()).intValue()))/2);
        }
        else
        {
            System.out.println(Biggerhp.peek());
        }
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	RunningMedian s = new RunningMedian();
        Scanner sc= new Scanner(System.in); 
        int fi = sc.nextInt();
        while(fi > 0)
        {
            s.insert(sc.nextInt(), s.minHeap, s.maxHeap);
            s.rebalance(s.minHeap,s.maxHeap);
            s.getMedian(s.minHeap,s.maxHeap);
            --fi;
        }
    }

}
