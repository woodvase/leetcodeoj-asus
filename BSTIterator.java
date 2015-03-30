/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingexcercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author yoli
 */
public class BSTIterator {
    private List<Integer> tmp = new ArrayList<>();
    public BSTIterator(TreeNode root) {
        if(root != null)
        {  
            Stack<TreeNode> stk = new Stack<>();
            TreeNode n = root;
            while(n != null)
            {
                while(n.left != null)
                {
                    stk.push(n);
                    n = n.left;
                }
                tmp.add(n.val);
                n = n.right;
                while(n == null && !stk.isEmpty())
                {
                    n = stk.pop();
                    if(n != null)
                    {
                        tmp.add(n.val);
                        n = n.right;
                    }
                }
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        int n = tmp.size();
        return n > 0;
    }

    /** @return the next smallest number */
    public int next() {
        int ret = tmp.get(0);
        tmp.remove(0);
        return ret;
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */