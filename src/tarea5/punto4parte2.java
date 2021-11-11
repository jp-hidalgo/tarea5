package tarea5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class punto4parte2 {

    public void initalize(LinkedList<Integer> arr[], int length)
    {
        for (int i = 0; i < length; i++)
        {
            arr[i] = new LinkedList<Integer>();
        }
    }

    protected void add(int src, int dest, LinkedList<Integer> arr[])
    {
        arr[src].add(dest);
        arr[dest].add(src);
    }

    void dfs(LinkedList<Integer> arr[], int n)
    {
        Stack<Integer> s = new Stack<Integer>();
        boolean v[] = new boolean[6];
        s.push(n);
        v[n] = true;
        while (!s.isEmpty())
        {
            n = s.pop();
            System.out.println(n);

            Iterator<Integer> it = arr[n].iterator();
            while (it.hasNext())
            {
                int k = it.next();
                if (!v[k])
                {
                    s.push(k);
                    v[k] = true;
                }
            }
        }
    }

    public static void main(String args[])
    {
        LinkedList<Integer> arr[] = new LinkedList[6];
        DepthFirstSearch s = new DepthFirstSearch();
        s.initalize(arr, 5);
        s.add(0, 1, arr);
        s.add(0, 4, arr);
        s.add(1, 3, arr);
        s.add(3, 4, arr);
        s.add(3, 2, arr);
        s.dfs(arr, 0);
    }
}
