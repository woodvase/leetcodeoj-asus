/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingexcercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author yoli
 */
public class CodingExcercise {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        
        reverseBits(2);
        Heap.heapSort(new int[]{2,3,1,4,5});
        findMedianSortedArrays(new int[]{2,3,4,5,6}, new int[]{1});
        
        largestRectangleArea(new int[]{4,2});
        ListNode tn5 = new ListNode(1);
        ListNode tn6 = new ListNode(2);
        tn5.next = tn6;
        ListNode tn7 = new ListNode(3);
        tn6.next = tn7;
        ListNode tn8 = new ListNode(4);
        tn7.next = tn8;
        ListNode tn9 = new ListNode(5);
        tn8.next = tn9;
        ListNode tn10 = new ListNode(6);
        tn9.next = tn10;
        ListNode tn11 = new ListNode(7);
        tn10.next = tn11;
        
        reorderList(tn5);
        
        buildTree(new int[]{4,1,2,3}, new int[] {1,2,3,4});
        
        TreeNode root = new TreeNode(1);
        root.left = null;
        
        TreeNode rr = new TreeNode(2);
        root.right = rr;
        isSymmetric(root);
        
        System.out.println(simplifyPath("b/abc"));
        
        exist(new char[][]{{'a'}}, "a");
        addBinary("11", "1");        
        getRow(3);        
        restoreIpAddresses("5555");
        
        System.out.println(reverseWords(""));
        
        int[][] tmp = new int[][]{{0,0,0},{1,2,3}};
        System.out.println(tmp.length);
        System.out.println(tmp[0].length);
        
        ListNode tn1 = new ListNode(0);
        ListNode tn2 = new ListNode(1);
        tn1.next = tn2;
        
        ListNode tn3 = new ListNode(1);
        tn2.next = tn3;
        
        ListNode tn4 = new ListNode(2);
        
        tn3.next = tn4;
        /*
        ListNode tn5 = new ListNode(1);
        tn4.next = tn5;
        ListNode tn6 = new ListNode(2);
        tn5.next = tn6;
        ListNode tn7 = new ListNode(3);
        tn6.next = tn7;
        ListNode tn8 = new ListNode(4);
        tn7.next = tn8;
        ListNode tn9 = new ListNode(4);
        tn8.next = tn9;
        /*
        ListNode tn10 = new ListNode(6);
        tn9.next = tn10;
        */
        deleteDuplicates2(tn1);        
        
        System.out.println(compareVersion("0", "1"));
        
        System.out.println(lengthOfLastWord(" a"));
        
        System.out.println(largestNumber(new int[]{0, 0}));
        
        sortColors(new int[]{0,1,0,0,1,2,2,1,0});
        
        System.out.println(jump(new int[]{5,4,3,2,1,1,1,1,1,1}));
        
        System.out.println(trapWater(new int[]{9,6,8,8,5,6,3}));
        
        System.out.println(countAndSay(6));
        
        String p = "))))())()()(()";
        System.out.println(longestValidParentheses(p));
        
        System.out.println(divide(-2147483648, 1));
        System.out.println(strStr("abc","bc"));
        
        int[] a = {1,1};
        System.out.println(removeElement(a, 1));
        System.out.println(removeDuplicatesInSorted(a));
        
        printListOfString(generateParenthesis(3));
        printListOfString(letterCombinations("56"));
    }
    
    //
    public static int reverseBits(int n) {
        int[] tmp = new int[32];
        int i = 0;
        while(n > 0)
        {
            tmp[i ++] = n % 2;
            n = n / 2;
        }
        long ret = 0;
        for(int j = 31; j > 0; j --)
        {
            ret = ret + (long)tmp[j] << (31 - j);
        }
        return ret.;
    }
    
    // https://leetcode.com/problems/median-of-two-sorted-arrays/
    public static double findMedianSortedArrays(int A[], int B[]) {
       int la = A.length;
       int lb = B.length;
       int k = (la + lb) / 2;
       if((la + lb) % 2 > 0)
       {
           return (double)findMedianSortedArraysHelper(A, 0, la -1, B, 0, lb -1, k);
       }
       else
       {
           return (findMedianSortedArraysHelper(A,0, la -1, B, 0, lb - 1, k) + 
                   findMedianSortedArraysHelper(A, 0, la - 1, B, 0, lb - 1, k + 1)) * 0.5;
       }
    }
    private static int findMedianSortedArraysHelper(int A[], int startA, int endA, int B[], int startB, int endB, int k)
    {
        int lena = endA - startA + 1;
        int lenb = endB - startB + 1;
        if(lena == 0) return B[startB + k - 1];
        if(lenb == 0) return A[startA + k - 1];
        if(k == 1) return A[startA] < B[startB] ? A[startA]:B[startB];
        int midA = startA + (endA - startA) / 2;
	int midB = startB + (endB - startB) / 2;
 
        if(A[midA] <= B[midB])
        {
            if(lena / 2 + lenb / 2  + 1 >= k)
            {
                return findMedianSortedArraysHelper(A, startA, endA, B, startB, midB, k);
            }
            else
            {
                return findMedianSortedArraysHelper(A, midA + 1, endA, B, startB, endB, k - lena/ 2 - 1);
            }
        }
        else
        {
            if(lena / 2 + lenb / 2  + 1 >= k)
            {
                return findMedianSortedArraysHelper(A, startA, midA, B, startB, endB, k);
            }
            else
            {
                return findMedianSortedArraysHelper(A, startA, endA, B, midB + 1, endB, k - lenb / 2 - 1);
            }
        }
    }
    
    // https://leetcode.com/problems/combinations/
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if(k > n) return ret;
        List<Integer> c = new ArrayList<>();
        combineHelper(n,k,1,ret, c);
        return ret;
    }
    
    public void combineHelper(int n, int k, int start, List<List<Integer>> set, List<Integer> conbination)
    {
        if(k == 1)
        {
            for(int i = start; i <= n; i ++)
            {
                conbination.add(i);
                set.add(new ArrayList(conbination));
                conbination.remove(conbination.size() - 1);
            }
        }
        else
        {
            for(int i = start; i <= n -k + 1; i ++)
            {
                conbination.add(i);
                combineHelper(n, k -1, i + 1, set, conbination);
                conbination.remove(conbination.size() - 1);
            }
        }
    }
    
    // https://leetcode.com/problems/largest-rectangle-in-histogram/
    public static int largestRectangleArea(int[] height) {
        if(height.length == 0) return 0;
        Stack<Integer> stk = new Stack<>();
        int ret = 0;
        int i = 0;
        while(i < height.length)
        {
            if(stk.isEmpty() || height[i] > height[stk.peek()])
            {
                stk.add(i ++);
            }
            else
            {
                int tmp = stk.pop();
                tmp = height[tmp] * (stk.isEmpty() ? i: i - stk.peek() - 1);
                if(tmp > ret)
                    ret = tmp;
            }
        }
        while(!stk.isEmpty())
        {
            int tmp = stk.pop();
                tmp = height[tmp] * (stk.isEmpty() ? i: i - stk.peek() - 1);
                if(tmp > ret)
                    ret = tmp;
        }
        return ret;
    }
    
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        if(n == 0) return ret;
        
        for(int i = 0; i < n; i ++)
        {
            ret.add(ret.get(ret.size() - 1) + 1 << i);
        }
        for(int i = 0; i < n - 1; i ++)
        {
            ret.add(ret.get(ret.size() - 1) - 1 << i);
        }
        
        return ret;
    }
    
    // https://oj.leetcode.com/problems/rotate-image/
    public void rotate(int[][] matrix) {
        if(matrix.length <= 1) return;
        int n = matrix.length;
        for(int i = 0; i < n; i ++)
        {
           int j = 0; 
           int k = n - 1;
           while(j < k)
           {
                int tmp = matrix[k][i];
                matrix[k][i] = matrix[j][i];
                matrix[j][i] = tmp;
                j ++;
                k --;
           }
        }
       
        for(int i = 0; i < n; i ++)
        {
            for(int j = i; j < n; j ++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;               
            }
        }
    }

    
     public int numDecodings(String s) {
        if(s.isEmpty() || s.startsWith("0")) return 0;
         int r1 = 1;
         int r2 = 1;
         for(int i = 1; i < s.length(); i ++)
        {
            if(s.charAt(i) == '0') r1 = 0;
            char c = s.charAt(i-1);
            if(c == '1' || c == '2' && s.charAt(i) <= '6')
            {
                r1 = r1 + r2;
                r2 = r1 - r2;
            }
            else
            {
                r2 = r1;
            }
        }
        return r1;
    }
    
    // https://oj.leetcode.com/problems/reorder-list/
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != null && p2.next != null)
        {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode secondHead = p1.next;
        p1.next = null;
        p2 = secondHead.next;
        secondHead.next = null;
        while(p2 != null)
        {
            ListNode tmp = p2.next;
            p2.next = secondHead;
            secondHead = p2;
            p2 = tmp;
        }
        p1 = head;
        while(p1 != null && secondHead != null)
        {
            p2 = secondHead.next;
            secondHead.next = p1.next;
            p1.next = secondHead;
            p1 = p1.next.next;
            secondHead = p2; 
        }
    }
    
    // https://oj.leetcode.com/problems/word-break-ii/
    public List<String> wordBreak2(String s, Set<String> dict) {
        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        wordBreakHelper(s, 0, dict, ret, sb);
        return ret;
    }
    
    public boolean wordBreakDP(String s, Set<String> dict) {
        boolean[] flags = new boolean[s.length()];
        for(int i = 0; i < s.length(); i ++)
        {
            for(int j = 0; j < i; j ++)
            {
                if(flags[j] && dict.contains(s.substring(j + 1, i + 1)))
                {
                    flags[i] = true;
                }
            }
        }
        return flags[s.length() - 1];
    }
    
    // https://oj.leetcode.com/problems/word-break/
    public void wordBreakHelper(String s, int start, Set<String> dict, List<String> breakedStrings, StringBuilder breakedStr) {
        if(s.isEmpty())
        {
            breakedStrings.add(new String(breakedStr));
        }        
        else
        {
            for(int i = start + 1; i <= s.length(); i ++)
            {
                String tmp = s.substring(start,i);
                if(dict.contains(tmp))
                {
                    if(breakedStr.length() > 0)
                    {
                        breakedStr.append(" ");
                    } 
                    int curl = breakedStr.length();
                    breakedStr.append(tmp);
                    wordBreakHelper(s, i, dict, breakedStrings, breakedStr);
                    breakedStr.delete(curl, breakedStr.length());
                }
            }
        }
    }
    
    // https://oj.leetcode.com/problems/partition-list/
    public ListNode partition(ListNode head, int x) {
    
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while(p != null && p.next.val < x)
        {
            p = p.next;
        }
        ListNode p2 = p.next;
        while(p2 != null && p2.next != null)
        {
            if(p2.next.val < x)
            {
                ListNode tmp = p2.next;
                p2.next = tmp.next;
                tmp.next = p.next;
                p.next = tmp;
                p = p.next;
            }
            else
            {
                p2 = p2.next;
            }
        }
        return dummy.next;
    }
    
    // https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
    public static int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }
    private static int sumNumbersHelper(TreeNode root, Integer result)
    {
        if(root == null) return 0;
        result = result * 10 + root.val;
        if(root.left == null && root.right == null)
        {
            return result;
        }
        else
        {
            return sumNumbersHelper(root.left, result) + sumNumbersHelper(root.right, result);
        }
    }
    // https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null)
            return ret;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty())
        {
            TreeNode n = stk.peek();
            stk.pop();
            ret.add(0, n.val);
            if(n.left != null)
                stk.push(n.left);
            if(n.right != null)
            {
                stk.push(n.right);
            }
        }
        return ret;
    }
    
    // https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null)
            return ret;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode n = root;
        while(n != null)
        {
            while(n.left != null)
            {
                stk.push(n);
                n = n.left;
            }
            ret.add(n.val);
            n = n.right;
            while(n == null && !stk.isEmpty())
            {
                n = stk.pop();
                if(n != null)
                {
                    ret.add(n.val);
                    n = n.right;
                }
            }
        }
        
        return ret;
    }
    
    // https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null)
            return ret;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode n = root;
        while(n != null)
        {
            while(n.left != null)
            {
                ret.add(n.val);
                stk.add(n);
                n = n.left;
            }
            ret.add(n.val);
            n = n.right;
            while(n == null && !stk.isEmpty())
            {
                n = stk.pop().right;
            }
        }
        return ret;
    }
    
    public static TreeNode sortedArrayToBST(int[] num) {
    
        return sortedArrayToBST(num, 0, num.length - 1);
    }
    
    private static TreeNode sortedArrayToBST(int[] num, int start, int end)
    {
        if(start > end) return null;
        if(start == end) return new TreeNode(num[start]);
        int i = start + (end - start) / 2;
        TreeNode n = new TreeNode(num[i]);
        n.left = sortedArrayToBST(num, start, i - 1);
        n.right = sortedArrayToBST(num, i + 1, end);
        return n;
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null)
            return ret;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<Integer> tmp = new ArrayList<>();
        
        q1.add(root);
        while(!q1.isEmpty() || !q2.isEmpty())
        {
            if(!q1.isEmpty())
            {
                if(!tmp.isEmpty())
                {
                    ret.add(0,new ArrayList(tmp));
                    tmp.clear();
                }
                while(!q1.isEmpty())
                {
                    TreeNode n = q1.poll();
                    if(n != null)
                    {
                        tmp.add(n.val);
                        q2.add(n.left);
                        q2.add(n.right); 
                    }
                }
            }
            else if(!q2.isEmpty())
            {
                if(!tmp.isEmpty())
                {
                    ret.add(0,new ArrayList(tmp));
                    tmp.clear();
                }
                while(!q2.isEmpty())
                {
                    TreeNode n = q2.poll();
                    if(n != null)
                    {
                        tmp.add(n.val);
                        q1.add(n.left);
                        q1.add(n.right);
                    }
                }
            }
        }
        return ret;
    }
    
    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        return buildTreeHelper2(postorder, postorder.length - 1, inorder, 0, inorder.length -1);
    }
    
    private static TreeNode buildTreeHelper2(int[] postorder, int postEnd, int[] inorder, int start, int end)
    {
        TreeNode tmp;
        if(postEnd < 0)
            return null;
        if(start == end)
            return new TreeNode(inorder[start]);
        if(start < end)
        {
            int q = locateNode(inorder, postorder[postEnd]);
            tmp = new TreeNode(inorder[q]);
            tmp.left = buildTreeHelper2(postorder, postEnd -end + q - 1, inorder, start, q - 1);
            tmp.right = buildTreeHelper2(postorder, postEnd - 1, inorder, 1 + q, end);
            return tmp;
        }
        
        return null;
    }
    
    
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, inorder, 0, preorder.length - 1);
    }
    
    private static TreeNode buildTreeHelper(int[] preorder, int ninPre, int[] inorder, int start, int end)
    {
        TreeNode tmp;
        if(ninPre > preorder.length - 1)
            return null;
        if(start == end)
            return new TreeNode(inorder[start]);
        if(start < end)
        {
            int q = locateNode(inorder, preorder[ninPre]);
            tmp = new TreeNode(inorder[q]);
            tmp.left = buildTreeHelper(preorder, ninPre + 1, inorder, start, q - 1);
            // ninPre + q - start + 1, the first right node index in preorder = q + left childeren num(q - start) + 1; 
            tmp.right = buildTreeHelper(preorder, ninPre + q - start + 1, inorder, 1 + q, end);
            return tmp;
        }
        
        return null;
    }
    
    private static int locateNode(int[] a, int b)
    {
        for(int i = 0; i < a.length; i ++)
        {
            if(a[i] == b)
                return i;
        }
        return -1;
    }
    
    public static void connect(TreeLinkNode root) {
        if(root == null)
            return;
        Queue<TreeLinkNode> q1 = new LinkedList<>();
        Queue<TreeLinkNode> q2 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty() || !q2.isEmpty())
        {
            if(!q1.isEmpty())
            {
                while(!q1.isEmpty())
                {
                    TreeLinkNode n = q1.poll();
                    if(n != null)
                    {
                        while(q1.peek() == null && !q1.isEmpty())
                        {
                            q1.poll();
                        }
                        n.next = q1.peek();
                        q2.add(n.left);
                        q2.add(n.right); 
                    }
                }
            }
            else if(!q2.isEmpty())
            {
                while(!q2.isEmpty())
                {
                    TreeLinkNode n = q2.poll();
                    if(n != null)
                    {
                        while(q2.peek() == null && !q2.isEmpty())
                        {
                            q2.poll();
                        }
                        n.next = q2.peek();
                        q1.add(n.left);
                        q1.add(n.right);
                    }
                }
            }
        }
    }
    
    public static int minDepth(TreeNode root)
    {
        if(root == null) return 0;
            return minDepthHelper(root);
    }
        
    private static int minDepthHelper(TreeNode n)
    {
        if(n == null)
            return 0;
        if(n.left == null && n.right == null)
            return 1;        
        if(n.left == null)
            return 1 + minDepth(n.right);
        if(n.right == null)
            return 1 + minDepth(n.left);
        return 1 + Math.min(minDepthHelper(n.left), minDepthHelper(n.right));
    }
    
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return maxDepthHelper(root);
    }

    private static int maxDepthHelper(TreeNode n)
    {
        if(n == null)
            return 0;
        if(n.left == null && n.right == null)
            return 1;
        return 1 + Math.max(maxDepthHelper(n.left), maxDepthHelper(n.right));
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<String> tmp = new ArrayList<>();
        
        q1.add(root);
        while(!q1.isEmpty() || !q2.isEmpty())
        {
            if(!q1.isEmpty())
            {
                if(!tmp.isEmpty())
                {
                    if(!arrayIsSymmetric(tmp))
                        return false;
                    tmp.clear();
                }
                while(!q1.isEmpty())
                {
                    TreeNode n = q1.poll();
                    if(n != null)
                    {
                        tmp.add(String.valueOf(n.val));
                        q2.add(n.left);
                        q2.add(n.right); 
                    }
                    else
                    {
                        tmp.add("#");
                    }
                }
            }
            else if(!q2.isEmpty())
            {
                if(!tmp.isEmpty())
                {
                    if(!arrayIsSymmetric(tmp))
                        return false;
                    tmp.clear();
                }
                while(!q2.isEmpty())
                {
                    TreeNode n = q2.poll();
                    if(n != null)
                    {
                        tmp.add(String.valueOf(n.val));
                        q1.add(n.left);
                        q1.add(n.right);
                    }
                    else
                    {
                        tmp.add("#");
                    }
                }
            }
        }
        
        return true;
    }
    
    private static boolean arrayIsSymmetric(List<String> a)
    {
        if(a.size() == 1) return true;
        int i = 0; 
        int j = a.size() - 1;
        while(i < j)
        {
            if(!a.get(i ++).equals(a.get(j --)))
            {
                return false;
            }
        }
        return true;
    }
    
    // https://oj.leetcode.com/submissions/detail/21435974/
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null)
            return ret;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<Integer> tmp = new ArrayList<>();
        
        q1.add(root);
        while(!q1.isEmpty() || !q2.isEmpty())
        {
            if(!q1.isEmpty())
            {
                if(!tmp.isEmpty())
                {
                    ret.add(new ArrayList(tmp));
                    tmp.clear();
                }
                while(!q1.isEmpty())
                {
                    TreeNode n = q1.poll();
                    if(n != null)
                    {
                        tmp.add(n.val);
                        q2.add(n.left);
                        q2.add(n.right); 
                    }
                }
            }
            else if(!q2.isEmpty())
            {
                if(!tmp.isEmpty())
                {
                    ret.add(new ArrayList(tmp));
                    tmp.clear();
                }
                while(!q2.isEmpty())
                {
                    TreeNode n = q2.poll();
                    if(n != null)
                    {
                        tmp.add(n.val);
                        q1.add(n.left);
                        q1.add(n.right);
                    }
                }
            }
        }
        return ret;
    }
    
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.isEmpty())
        {
            intervals.add(newInterval);
            return intervals;
        }
        
        intervals.sort(new Comparator<Interval>(){
        @Override
        public int compare(Interval i1, Interval i2)
        {
            if(i1.start < i2.start)
                return -1;
            if(i1.start > i2.start)
            {
                return 1;
            }
            return 0;
        }
        });
        Interval pre = intervals.get(0);
        if(newInterval.end < pre.start || newInterval.start > intervals.get(intervals.size() -1).end)
        {
            intervals.add(newInterval);
            return intervals;
        }
        
        ArrayList<Interval> ret = new ArrayList<>();
        pre = null;
        for(int i = 0; i < intervals.size(); i ++)
        {
            Interval tmp = intervals.get(i);
            
            if(newInterval.start > tmp.end || newInterval.end < tmp.start || (newInterval.start >= tmp.start && newInterval.end <= tmp.end))
            {
                if(pre == null)
                {
                    ret.add(tmp);
                }
                else if(pre.start >= tmp.start && pre.end <= tmp.end)
                {
                    ret.remove(pre);
                    ret.add(tmp);
                    pre = null;
                }
                else if(pre.end < tmp.start)
                {
                    pre = null;
                    ret.add(tmp);
                }
                else if(pre.start > tmp.end)
                {
                    pre = null;
                    ret.add(tmp);
                }
                else
                {
                    Interval newPre = new Interval(Math.min(pre.start, tmp.start), Math.max(pre.end, tmp.end));
                    ret.remove(pre);
                    ret.add(newPre);
                    pre = newPre;
                }
            }
            else      
            {
                Interval newtmp = new Interval(Math.min(tmp.start, newInterval.start), Math.max(newInterval.end, tmp.end));
                ret.add(newtmp);
                pre = newtmp;                
            }            
        }
        return ret;
        
    }
    
    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.isEmpty()) return intervals;
        intervals.sort(new Comparator<Interval>(){
        @Override
        public int compare(Interval i1, Interval i2)
        {
            if(i1.start < i2.start)
                return -1;
            if(i1.start > i2.start)
            {
                return 1;
            }
            return 0;
        }
        });
        ArrayList<Interval> ret = new ArrayList<>();
        Interval pre = intervals.get(0);
        ret.add(pre);
        for(int i = 1; i < intervals.size(); i ++)
        {
            Interval tmp = intervals.get(i);
            if(tmp.start <= pre.end)
            {
                if(tmp.end >= pre.end)
                {
                    Interval newInterval = new Interval(pre.start, tmp.end);
                    ret.remove(pre);
                    ret.add(newInterval);
                    pre = newInterval;
                }
            }
            else{
                ret.add(tmp);
                pre = tmp;
            }
        }
        return ret;
    }
    
    public static String simplifyPath(String path) {
        Stack stk = new Stack();
        String[] tmp = path.split("/");
        for(String s : tmp)
        {
            if(s.equals(".."))
            {
                if(!stk.empty())
                {
                    stk.pop();
                }
            }
            else if(!s.isEmpty() && !s.equals(".") && !s.equals(".."))
            {
                stk.push(s);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stk.empty())
        {
            String s = (String)stk.pop();
            if(sb.length() == 0)
            {
                sb.append(s);
            }
            else if(sb.length() > 0)
            {
                sb.insert(0, "/");
                sb.insert(0, s);
            }
        }
        sb.insert(0, "/");
        return sb.toString();
    }
    
    // https://oj.leetcode.com/problems/minimum-path-sum/
    public static int minPathSum(int[][] grid) {
        int[][] tmp = new int[grid.length][grid[0].length];
        tmp[0][0] = grid[0][0];
        for(int i = 1; i < grid[0].length; i ++)
            tmp[0][i] = tmp[0][i - 1] + grid[0][i];
        for(int i = 1; i < grid.length; i ++)
            tmp[i][0] = tmp[i -1][0] + grid[i][0];
        for(int i = 1; i < grid.length; i ++)
        {
            for(int j = 1; j < grid[0].length; j ++)
            {
                tmp[i][j] = Math.min(tmp[i - 1][j], tmp[i][j - 1]) + grid[i][j];
            }
        }
        return tmp[tmp.length -1][tmp[0].length - 1];
    }
    
    // https://oj.leetcode.com/problems/insertion-sort-list/
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode tail = head;
        ListNode p = head.next;
        
        while(p != null)
        {
            if(p.val >= tail.val)
            {
                tail.next = p;
                tail = tail.next;
                p = p.next;
            }
            else
            {
                ListNode p2 = dummyNode;
                while(p2.next.val < p.val)
                {
                    p2 = p2.next;
                }
                ListNode tmp = p.next;
                p.next = p2.next;
                p2.next = p;
                p = tmp;
            }
        }
        tail.next = null;
        return dummyNode.next;        
    }
    
    // https://oj.leetcode.com/problems/valid-palindrome/
     public static boolean isPalindrome(String s) {
         if(s.isEmpty() || s.length() == 1) return true;
         int i = 0;
         int j = s.length() - 1;
         s = s.toLowerCase();
         while(i < j)
         {
             char c = s.charAt(i);
             char d = s.charAt(j);
             
             if(isAlphanumeric(c) && isAlphanumeric(d))
             {
                 if(c != d)
                     return false;
                 else
                 {
                     i ++;
                     j --;
                 }
             }
             else
             {
                if(!isAlphanumeric(c))
                    i ++;
                if(!isAlphanumeric(d))
                    j --;
             }
         }
         return true;
    }
    
    private static boolean isAlphanumeric(char c)
    {
        return (c >= 0 && c <= 9) || (c>= 'a' && c <= 'z') || (c>= 'A' && c<= 'Z');
    }
     
    // https://oj.leetcode.com/problems/maximum-product-subarray/
    public static int maxProduct(int[] A) {
        return 0;
    }
    
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<>();
        
        if(s == null || s.isEmpty() || s.length() < 10) return ret;
        for( int i = 0; i < s.length() - 10; i ++)
        {
            String str = s.substring(i, i + 9);
            for(int j = i + 10; j < s.length() - 10; j ++)
            {
                String tmp = s.substring(j, j + 9);
                if(str.equals(tmp))
                {
                    ret.add(str);
                    break;
                }
            }
        }
        return ret;
    }
    
    // https://oj.leetcode.com/problems/word-search/
    public static boolean exist(char[][] board, String word) {
        int[][] flags = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i ++)
        {
            for(int j = 0; j < board[i].length; j ++)
            {
                if(existHelper(board, word, flags, i, j))
                    return true;
            }
        }
        return false;
    }
    
    private static boolean existHelper(char[][] board, String word, int[][] bitFlags, int row, int col)
    {
        char c = word.charAt(0);
        if(bitFlags[row][col] == 0 && board[row][col] == c)
        {
            bitFlags[row][col] = 1;
            String s = word.substring(1);
            if(s.isEmpty())
                return true;
            if(row - 1 >= 0 && existHelper(board, s, bitFlags, row - 1, col))
            {
                return true;
            }
            if(col - 1 >= 0 && existHelper(board, s, bitFlags, row, col -1))
            {
                return true;
            }
            if(row + 1 < board.length && existHelper(board, s, bitFlags, row + 1, col))
            {
                return true;
            }
            if(col + 1 < board[row].length && existHelper(board, s, bitFlags, row, col + 1))
            {
                return true;
            }
                        
            bitFlags[row][col] = 0;
            return false;
        }
        
        return false;
    }
    
    public static String addBinary(String a, String b) {
        if(a.isEmpty()) return b;
        if(b.isEmpty()) return a;
        int la = a.length() - 1; 
        int lb = b.length() - 1;
        int carryOn = 0;
        StringBuilder ret = new StringBuilder();
        if(a.charAt(la) == '1' && b.charAt(lb) == '1')
        {
            ret.append('0');
            carryOn = 1;
        }
        else if(a.charAt(la) == b.charAt(lb))
        {
            ret.append('0');
        }
        else
        {
            ret.append('1');
        }
        la = la - 1;
        lb = lb - 1;
        while(la >= 0 && lb >= 0)
        {
            if((b.charAt(lb) - '0' + a.charAt(la) - '0' + carryOn) == 3)
            {
                ret.insert(0, '1');
                carryOn = 1;
            }
            else if(b.charAt(lb) - '0' + a.charAt(la) - '0' + carryOn == 2)
            {
                ret.insert(0,'0');
                carryOn = 1;
            }
            else
            {
                ret.insert(0,(char)(b.charAt(lb) - '0' + a.charAt(la) + carryOn));
                carryOn = 0;
            }
            la --;
            lb --;
        }
        
        if(la >= 0)
        {
            while(la >= 0)
            {
                if(a.charAt(la) == '1' && carryOn == 1)
                {
                    ret.insert(0, '0');
                    carryOn = 1;
                }
                else
                {
                    ret.insert(0, (char) (a.charAt(la) + carryOn));
                    carryOn = 0;
                }
                la --;
            }
        }
        else if(lb >= 0)
        {
            while(lb >= 0)
            {
                if(b.charAt(lb) == '1' && carryOn == 1)
                {
                    ret.insert(0, '0');
                    carryOn = 1;
                }
                else
                {
                    ret.insert(0, (char) (b.charAt(lb) + carryOn));
                    carryOn = 0;
                }
                lb --;
            }
        }
        
        if(carryOn == 1)
            ret.insert(0,'1');
        
        return ret.toString();
    }
    
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int counta = 1;
        ListNode pa = headA;
        while(pa != null)
        {
            counta ++;
            pa = pa.next;
        }
        int countb = 1;
        ListNode pb = headB;
        while(pb != null)
        {
            countb ++;
            pb = pb.next;
        }
        if(counta > countb)
        {
            int i = 0;
            pa = headA;
            while(i < counta - countb)
            {
                i ++;
                pa = pa.next;
            }
            pb = headB;
        }
        else if(counta < countb)
        {
            int i = 0;
            pb = headB;
            while(i < countb - counta)
            {
                i ++;
                pb = pb.next;
            }
            pa = headA;
        }
        else
        {
            pa = headA;
            pb = headB;
        }
                
        while(pa != null && pa != pb)
        {
            pa = pa.next;
            pb = pb.next;
        }
        
        return pa;
    }
    
    // https://oj.leetcode.com/problems/path-sum-ii/
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        List<Integer> p = new ArrayList<>();
        pathSumHelper(root, sum, ret, p);
        return ret;
    }
    
    private void pathSumHelper(TreeNode root, int sum, List<List<Integer>> paths, List<Integer> path)
    {
        if(root == null) return;
        path.add(root.val);
        if(root.left == null && root.right == null && root.val == sum)
        {
            paths.add(new ArrayList<>(path));
        }
        else
        {
            pathSumHelper(root.left, sum - root.val, paths, path);
            pathSumHelper(root.right, sum - root.val, paths, path);
        }
        path.remove(path.size() - 1);
        
    }
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.val == sum)
        {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    
    // https://oj.leetcode.com/problems/triangle/
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty()) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);
        int l = triangle.size();
        for(int i = l -2; i >= 0; i --)
        {
            for(int j = 0; j < triangle.get(i).size(); i ++)
            {
                int tmp = triangle.get(i).get(j);
                triangle.get(i).set(j, tmp + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
    
    // https://oj.leetcode.com/problems/pascals-triangle-ii/
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> element1 = new ArrayList<>();
        element1.add(1);
        if(rowIndex == 0) return element1;
        List<Integer> element2 = new ArrayList<>();
        element2.add(1);
        element2.add(1);
        if(rowIndex == 1)
        {
            return element2;
        }
        int i = 2;
        List<Integer> preEle = element2;
        
        while(i <= rowIndex)
        {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            int j = 1;
            while(j < preEle.size())
            {
                cur.add(preEle.get(j) + preEle.get(j - 1));
                j ++;
            }
            
            cur.add(1);            
            preEle = cur;
            i ++;
        }
        return preEle;
    }
    
    // 
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRows == 0)
            return ret;
        List<Integer> element1 = new ArrayList<>();
        element1.add(1);
        ret.add(element1);
        if(numRows == 1) return ret;
        List<Integer> element2 = new ArrayList<>();
        element2.add(1);
        element2.add(1);
        ret.add(element2);
        if(numRows == 2)
        {
            return ret;
        }
        
        for(int i = 3; i <= numRows; i ++)
        {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            int j = 1;
            List<Integer> x = ret.get(ret.size() -1);
            while(j < x.size())
            {
                tmp.add(x.get(j) + x.get(j - 1));
                j ++;
            }
            tmp.add(1);
            ret.add(tmp);
        }
        
        return ret;
    }
    
    // https://oj.leetcode.com/problems/climbing-stairs/
    public static int climbStairs(int n) {
        int[] steps = new int[n + 1];
        steps[1] = 1;
        for(int i = 2; i < n + 1; i ++)
        {
            steps[i] = steps[i - 1] + steps[i -2];
        }
        
        return steps[n];
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        
        if(s == null || s.isEmpty() || s.length() < 4)
            return ret;
        StringBuilder ip = new StringBuilder();
        restoreIpAddressesHelper(ret,ip,s,0);
        return ret;
    }
    
    private static void restoreIpAddressesHelper(List<String> ips, StringBuilder strBuilder, String s, int partNum)
    {
        if(partNum == 3)
        {
            if(s.length() >= 1 && s.length() <= 3)
            {
                if(s.equals("0") || s.charAt(0) != '0')
                {
                    int tmp = Integer.parseInt(s);
            
                    if(tmp >= 0 && tmp <= 255)
                    {
                        strBuilder.append(s);
                        ips.add(strBuilder.toString());
                        strBuilder.setLength(strBuilder.length() - s.length());
                    }
                }                
            }
        }
        else
        {
            for(int i = 1; i < 4; i ++)
            {
                if(i <= s.length())
                {    
                    String n = s.substring(0, i);
                    if(n.charAt(0) != '0' || n.equals("0"))
                    {
                        int m = Integer.parseInt(n);
                        if(m >= 0 && m <= 255)
                        {
                            strBuilder.append(s.substring(0, i));
                            strBuilder.append('.');
                            restoreIpAddressesHelper(ips, strBuilder, s.substring(i), partNum + 1);
                            strBuilder.setLength(strBuilder.length() - i - 1);
                        }
                    }
                }
            }
        }
    }
    public static int[] plusOne(int[] digits) {
        if(digits.length == 0) return new int[]{1};
        int n = digits.length;
        int i = n -1;
        while(i >= 0)
        {
            if(digits[i] + 1 >= 10)
            {
                i --;
                digits[i] = 0;
            }
            else
            {
                digits[i] += 1;
                return digits;
            }
        }
        
        if(digits[0] == 0)
        {
            int[] tmp = new int[digits.length + 1];
            tmp[0] = 1;
            return tmp;
        }
        
        return null;
    }
    
    public static String reverseWords(String s)
    {
        if(s == null || s.isEmpty()) return s;
        if(s.length() == 1) return s.trim();
        String str = reverseStringHelper(s.trim());
        StringBuilder ret = new StringBuilder();
        int start = 0;
        for(int i = 0; i < str.length(); i ++)
        {
            if(str.charAt(i) == ' ') 
            {
                String s1 = str.substring(start,i);
                ret.append(reverseStringHelper(s1));
                ret.append(' ');
                start = i + 1;
            }
        }
        
        ret.append(reverseStringHelper(str.substring(start)));
        return ret.toString();
    }
    
    private static String reverseStringHelper(String s)
    {
        if(s == null || s.isEmpty() || s.length() == 1) return s;
        char[] tmp = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j)
        {
            char c = tmp[j];
            tmp[j--] = tmp[i];
            tmp[i++] = c;            
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(tmp[0]);
        for(int k = 1; k < tmp.length; k ++)
        {
            if(sb.charAt(sb.length() - 1) == ' ' && tmp[k] == ' ')
                continue;
            sb.append(tmp[k]);
        }
        
        return sb.toString();
    }
    
    // https://oj.leetcode.com/problems/same-tree/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) 
            return true;
        if(p == null || q == null) 
            return false;
        
        if(p.val == q.val)
        {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);            
        }
        else
        {
            return false;            
        }
    }
    
    // https://oj.leetcode.com/problems/unique-paths-ii/
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)
            return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] a = new int[m][n];
        a[0][0] = 1;
        for(int i = 1; i < n; i ++)
        {
            if(obstacleGrid[0][i] == 1)
            {
                a[0][i] = 0;
            }
            else
            {
                a[0][i] = a[0][i - 1];
            }
        }
        
        for(int i = 1; i < m; i ++)
        {
            if(obstacleGrid[i][0] == 1)
            {
                a[i][0] = 0;
            }
            else
            {
                a[i][0] = a[i - 1][0];
            }
        }
        
        for(int i = 1; i < m; i ++)
        {
            for(int j = 1; j < n; j ++)
            {
                if(obstacleGrid[i][j] == 1)
                {
                    a[i][j] = 0;
                }
                else
                {
                    a[i][j] = a[i -1][j] + a[i][j - 1];
                }
            }
        }
        
        return a[m -1][n - 1];
    }
    
    // https://oj.leetcode.com/problems/unique-paths/
    public static int uniquePaths(int m, int n) {
        int[][] a = new int[m][n];
        for(int i = 0; i < n; i ++)
        {
            a[0][i] = 1;
        }
        for(int i = 0; i < m; i ++)
        {
            a[i][0] = 1;
        }
        for(int i = 1; i < m; i ++)
        {
            for(int j = 1; j < n; j ++)
            {
                a[i][j] = a[i -1][j] + a[i][j - 1];
            }
        }
        return a[m -1][n - 1];
    }
    
    // https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
    // 1->1->2, return 2
    // Given 1->2->3->3->4->4->5, return 1->2->5.
    public static ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode tail = head;
        if(head.val == head.next.val)
        {
            tail = null;
        }
        
        ListNode pre= head;
        ListNode cur = pre.next;
        ListNode next= cur.next;
        
        while(next != null)
        {
            if(cur.val != pre.val && cur.val != next.val)
            {
                if(tail == null)
                {
                    head = tail = cur;
                }
                else
                {
                    tail.next = cur;
                    tail = cur;
                }                
            }
            
            pre = cur;
            cur = next;
            next = cur.next;
        }  
        
        if(tail == null)
        {
            if(pre.val == cur.val) 
                return null;
            else 
                return cur;
        }
        else 
        {
            if(pre.val == cur.val)
            {
                tail.next = null;
            }
            else
            {
                if(tail != pre)
                {
                    tail.next = cur;
                }
            }
        }
        
        return head;
    }
    
    // https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
    // Given 1->1->2, return 1->2.
    // Given 1->1->2->3->3, return 1->2->3.
    public static ListNode deleteDuplicates(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = p1.next;
        while(p2 != null)
        {
            while(p2 != null && p1.val == p2.val)
            {
                p2 = p2.next;
            }
            p1.next = p2;
            p1 = p2;
            if(p1 != null)
            {
                p2 = p1.next;
            }
        }
        
        return head;
    }
    
    public static ListNode rotateRight(ListNode head, int n) {
        if(head == null || n == 0 || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = p1;
        int i = 0;
        while(i < n)
        {
            if(p2.next == null)
            {
                p2 = head;
            }
            else
            {
                p2 = p2.next;
            }
            i ++;
        }
        while(p2.next != null)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode p3 = p1.next;
        p1.next = null;
        p2.next = head;
        
        return p3;
    }
    
    // https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
    public static void flatten(TreeNode root) {
        
       if(root == null)
            return;
       flattenHelper(root);
    }
    private static TreeNode flattenHelper(TreeNode root)
    {
        if(root == null) return null;
        TreeNode tmp = root.right;
        if(root.left != null)
        {
            root.right = flattenHelper(root.left);
            TreeNode p = root;
            while(p.right != null)
            {
                p = p.right;
            }
            p.right = flattenHelper(tmp);
        }
        else
        {
            root.right = flattenHelper(root.right);
        }
        root.left = null;
        return root;
        
    }
    
    // https://oj.leetcode.com/problems/compare-version-numbers/
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i = 0; i < Math.min(v1.length, v2.length); i ++)
        {
            String tmp1 = trimLeadingZeros(v1[i]);
            String tmp2 = trimLeadingZeros(v2[i]);
            if(!tmp1.equals(tmp2))
            {
                if(Integer.parseInt(tmp1) < Integer.parseInt(tmp2))
                    return -1;
                else
                    return 1;
            }
        }
        
        if(v1.length > v2.length)
        {
            int i = v2.length;
            while(i < v1.length)
            {
                String tmp = trimLeadingZeros(v1[i]);
                if(!tmp.equals("0"))
                    return 1;
                else
                {
                    i ++;
                }
            }
            
            return 0;
        }
        else if(v1.length < v2.length)
        {
            int i = v1.length;
            while(i < v2.length)
            {
                String tmp = trimLeadingZeros(v2[i]);
                if(!tmp.equals("0"))
                    return -1;
                else
                {
                    i ++;
                }
            }
            
            return 0;
        }
        
        return 0;
    }
    
    private static String trimLeadingZeros(String s)
    {
        int i = 0;
        while(i < s.length())
        {
            if(s.charAt(i) == '0')
                i ++;
            else
                break;
        }
        
        if(i == s.length())
            return "0";
        return s.substring(i);
    }
    
    public static int lengthOfLastWord(String s) {
        if(s.length() == 0)
            return 0;
        char startc = s.charAt(0);
        
        int p = s.length() - 1;
        char endc = s.charAt(p);
        while(p >= 1 && endc == ' ')
        {
           endc = s.charAt(-- p);          
        }
        if(p == 0 && startc != ' ')
            return 1;
        if(p == 0 && startc == ' ')
            return 0;
        
        int count = p;
        while(p >= 1 && endc != ' ')
        {
            endc = s.charAt(-- p);
        }
        
        if(p == 0 && startc != ' ')
            return count - p + 1;
        return count - p;        
    }
    // https://oj.leetcode.com/problems/single-number/ 
    public int singleNumber(int[] A) {
        int ret = A[0];
        for(int i = 1; i < A.length; i ++)
        {
            ret = ret ^ A[i];
        }
        
        return ret;
    }
    
    // https://oj.leetcode.com/problems/largest-number/
    // For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330
    public static String largestNumber(int[] num) {
        String ret = new String();
        if(num.length == 0) return ret;
        if(num.length == 1) return Integer.toString(num[0]);
        
        List<String>[] buckets = new ArrayList[10];
        
        for(int i = 0; i < buckets.length; i ++)
        {
            buckets[i] = new ArrayList();
        }
        
        for(int i = 0; i < num.length; i ++)
        {
            int tmp = num[i];
            while(tmp >= 10)
            {
                tmp = tmp /10;
            }
            
            if(buckets[tmp].isEmpty())
            {
                buckets[tmp].add(Integer.toString(num[i]));
            }
            else
            {
                String s = Integer.toString(num[i]);
                insert(s,buckets[tmp]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = buckets.length -1; i >= 0; i --)
        {
            if(!buckets[i].isEmpty())
            {
                for(String str : buckets[i])
                    sb.append(str);
            }
        }
        
        ret = sb.toString();
        while(ret.length() > 1 && ret.charAt(0) == '0')
        {
            ret = ret.substring(1);
        }
        return ret;
    }
    
    private static void insert(String toInsert, List<String> nums)
    {
        for(int i = 0; i < nums.size(); i ++)
        {
            String s = nums.get(nums.size()-1 - i);
            StringBuilder sb1 = new StringBuilder();
            sb1.append(toInsert).append(s);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(s).append(toInsert);
            if(sb1.toString().compareTo(sb2.toString()) <= 0)
            {
                nums.add(nums.size() - i,toInsert);
                return;
            }            
        }
        nums.add(0,toInsert);
    }
    
    // https://oj.leetcode.com/problems/sort-colors/
    public static void sortColors(int[] A) {
        
        int p0 = 0;
        int p2 = A.length -1;
        int p1 = p0;
        while(p1 <= p2)
        {
            if(A[p1] == 0)
            {
                swap(A, p0, p1);
                p0 ++;
                p1 ++;
            }
            else if(A[p1] == 2)
            {
                swap(A, p1, p2);
                p2 --;
            }
            else
            {
                p1 ++;
            }
        }
    }
    
    private static void swap(int[]a, int i, int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    // https://oj.leetcode.com/problems/jump-game-ii/
    // For example:
    // Given array A = [2,1,3,1,1,4]
    // The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
    public static int jump(int[] A) {
        if(A.length < 2)
        {
            return 0;
        }
        
        if(A.length == 2 || A[0] >= A.length - 1)
        {
            return 1;
        }
        
        int endIndex = A.length -1;
        int[] steps = new int[endIndex]; 
        
        for(int i = endIndex - 1; i >= 0; i --)
        {
            if(A[i] >= endIndex - i)
            {
                steps[i] = 1;
            }
            else
            {
                int minSteps = A.length;
                for(int k = 1; k <= Math.min(A[i], endIndex - 1 - i); k ++)
                {
                    if(steps[i + k] < minSteps)
                    {
                        minSteps = steps[i + k];
                    }
                }
                steps[i] = minSteps + 1;
            }
        }
        
        return steps[0];
    }
    
    // https://oj.leetcode.com/problems/jump-game/
    // For example:
    // A = [2,3,1,1,4], return true.
    // A = [3,2,1,0,4], return false.
    public static boolean canJump(int[] A) {
        if(A.length < 2) return true; 
        
        int expectedJump = 1;
        for(int i = A.length - 2; i >= 0; i --)
        {
            if(A[i] < expectedJump)
            {
                expectedJump += 1; 
            }
            else
            {
                expectedJump = 1;
            }
        }
        
        return expectedJump == 1;
    }
    
    // https://oj.leetcode.com/problems/trapping-rain-water/
    public static int trapWater(int[] A) {
        if(A.length < 3)
            return 0;
        int ret = 0;
        Boolean hasLeft = false;
        int left = 0;
        int blockingStone = 0;
        int r = 0;
        
        for(int i = 0; i < A.length; i ++)
        {
            if(!hasLeft && i < A.length - 1 && A[i] > A[i + 1])
            {
                hasLeft = true;
                left = i;
            }
            else if(hasLeft && A[i] >= A[left])
            {
                int height = Math.min(A[left], A[i]);
                for(int k = left + 1; k < i; k ++)
                {
                    if(A[k] >= height)
                        blockingStone += height;
                    else
                        blockingStone += A[k];
                }
                ret += height * (i - left -1) - blockingStone;
                hasLeft = false;
                i --;
                blockingStone = 0;
            }
            else if(hasLeft && A[i] > A[i -1])
            {
                r = i;
            }
        }
        
        if(hasLeft && r > left)
        {
            int height = Math.min(A[left], A[r]);
            for(int k = left + 1; k < r; k ++)
            {
                    if(A[k] >= height)
                        blockingStone += height;
                    else
                        blockingStone += A[k];
            }
            ret += height * (r - left -1) - blockingStone;
        }
        
        return ret;
    }
    
    // https://oj.leetcode.com/problems/count-and-say/
    // 1, 11, 21, 1211, 111221, ...
    public static String countAndSay(int n) {
        if(n ==0) return "";
        String s = "1";
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int count = 1;
        char c = s.charAt(0);
        
        while(i < n )
        {
           int j = 1;
           while(j < s.length())
           {
               if(s.charAt(j) == c)
               {
                   count += 1;
               }
               else
               {
                   sb.append(Integer.toString(count));
                   sb.append(Character.toString(c));
                   c = s.charAt(j);
                   count = 1;
               }
               j ++;
           }
           sb.append(Integer.toString(count));
           sb.append(Character.toString(c));
           s = sb.toString();
           sb.setLength(0);
           c = s.charAt(0);
           count = 1;
        
           i ++;
        }
        
        return s;
    }    
    
    public static int longestValidParentheses(String s)
    {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int longest = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(count);
                count = 0;
            } else if (stack.size() > 0) {
                count += stack.poll() + 1;
                longest = Math.max(longest, count);
            } else {
                count = 0;
                stack.clear();
            }
        }
        return longest * 2;
    }
    
    public static void nextPermutation(int[] num)
    {
        
    }
    
    public static int divide(int dividend, int divisor) {
        long ret = 0;
        
        if(divisor == 0)
            return Integer.MAX_VALUE;
        
        int flag = 1;
        long d = dividend;
        long r = divisor;
        if(dividend < 0)
        {
            d = -d;
            flag = -flag;
        }
        
        if(divisor < 0)
        {
            r = -r;
            flag = -flag;
        }
        
        if(d < r)
            return (int)ret;
        
        while(d >= r)
        {
            int n = 0;
            while( d >= (r << n))
            {
                n ++;
            }
            ret += 1L << (n - 1);
            d = d - (r << (n - 1));
        }
        
        if(flag < 0)
        {
            if(-ret < (long)Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return -(int)ret;
        }
        else
        {
            if(ret > (long)Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else
                return (int)ret;
        }
    }
    
    public static int strStr(String haystack, String needle) {
        int ret = -1;
        if(haystack == null)
            return ret;
        if(needle == null)
            return ret;
        if(needle.length() ==0 && haystack.length() == 0)
            return 0;
        if(needle.length() == 0 || haystack.length() == 0)
            return ret;
        if(needle.length() > haystack.length())
            return ret;
        
        for(int i = 0; i < haystack.length() - needle.length() + 1; i ++)
        {
            int j = 0;
            if(haystack.charAt(i) == needle.charAt(j))
            {
                int tmp = i;
                while(i < haystack.length() && j < needle.length() &&  haystack.charAt(i) == needle.charAt(j))
                {
                    i ++;
                    j ++;
                }
                
                if(j == needle.length())
                    return tmp;
                else
                {
                    i = tmp;
                }
            }
        }
        
        return ret;        
    }
    
    // https://oj.leetcode.com/problems/remove-element/
    // Given an array and a value, remove all instances of that value in place and return the new length
    // The order of elements can be changed. It doesn't matter what you leave beyond the new length
    public static int removeElement(int[] A, int elem)
    {
        int i = 0;
        while(i < A.length && A[i] != elem)
        {
            i ++;
        }
        
        int j = i + 1;
        while(j < A.length)
        {
            if(A[j] != elem)
            {
                A[i ++] = A[j ++];
            }
            else
            {
                j ++;
            }
        }
        
        return i;
    }
    
    // https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
    // For example, Given input array A = [1,1,1,2],
    //Your function should return length = 2, and A is now [1,2].
    public static int removeDuplicatesInSorted(int[] A) {
    
        int newEnd = 0;
        for(int i = 1; i < A.length; i ++)
        {
            if(A[i] != A[newEnd])
            {
                A[++ newEnd] = A[i];
            }
        }
        
        return newEnd + 1;
    }
    
    //https://oj.leetcode.com/problems/swap-nodes-in-pairs/
    //Given a linked list, swap every two adjacent nodes and return its head.
    //For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
    public static ListNode swapPairs(ListNode head)
    {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        ListNode ret = new ListNode(0);
        ret.next = head;
        ListNode p1 = ret;
        
        while(p1 != null && p1.next != null && p1.next.next != null)
        {
            ListNode tmp = p1.next;
            p1.next = tmp.next;
            tmp.next = p1.next.next;
            p1.next.next = tmp;
            p1 = p1.next.next;
        }
        return ret.next;
    }
    
    public static List<String> generateParenthesis(int n)
    {
        List<String> ret = new ArrayList<>();
        if(n == 0)
            return ret;
            
        StringBuilder sbr = new StringBuilder();
        generateParenthesisHelper(ret, sbr, 0, 2 * n);
        return ret;
    }
    
    private static void generateParenthesisHelper(List<String> strs, StringBuilder sb, int unmatchedLeft, int targetLength)
    {
        if(sb.length() == targetLength)
        {
            strs.add(sb.toString());
        }
        else
        {
            if(unmatchedLeft == 0)
            {
                sb.append('(');
                generateParenthesisHelper(strs, sb, unmatchedLeft + 1, targetLength);
            }
            else
            {
                if(unmatchedLeft < (targetLength - sb.length()))
                {
                    int tmp = sb.length();
                    sb.append('(');
                    generateParenthesisHelper(strs, sb, unmatchedLeft + 1, targetLength);
                    sb.setLength(tmp);
                    sb.append(')');
                    generateParenthesisHelper(strs, sb, unmatchedLeft - 1, targetLength);
                }
                else
                {
                    sb.append(')');
                    generateParenthesisHelper(strs, sb, unmatchedLeft - 1, targetLength);
                
                }
            }
        }
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null && l2 != null) return l2;
        if(l1 != null && l2 == null) return l1;
        
        ListNode ret;
        ListNode p ;
        ListNode p1;
        ListNode p2;
       
        if(l1.val <= l2.val)
        {
            ret = l1;
            p1 = l1.next;
            p2 = l2;
        }
        else
        {
            ret = l2;
            p1 = l1;
            p2 = l2.next;
        }
        
        p = ret;
        while(p1 != null && p2 != null)
        {
            if(p1.val <= p2.val)
            {
                p.next = p1;
                p1 = p1.next;
            }
            else
            {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        
        if(p1 == null)
        {
            p.next = p2;
        }
        else
        {
            p.next = p1;
        }
        return ret;
    }
    
    // https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
    public static List<String> letterCombinations(String digits)
    {
        List<String> ret = new ArrayList<>();
        if(digits == null)
           return null;
        if(digits.length() == 0)
        {
            ret.add("");
            return ret;
        }
        StringBuilder tmpsb = new StringBuilder();
        letterCombinationsHelper(ret, tmpsb, digits);
        return ret;
    }
    
    private static void printListOfString(List<String> strs)
    {
        if(strs == null)
            return;
        strs.stream().forEach((str) -> {
            System.out.println(str);
        });
    }
    
    private static void letterCombinationsHelper(List<String> lists, StringBuilder sb, String str)
    {
        Map<Character, char[]> keyMap = new HashMap<Character, char[]>(){{
            put('2', new char[]{'a','b','c'});
            put('3', new char[]{'d','e','f'});
            put('4', new char[]{'g','h','i'});
            put('5', new char[]{'j','k','l'});
            put('6', new char[]{'m','n','o'});
            put('7', new char[]{'p','q','r','s'});
            put('8', new char[]{'t','u','v'});
            put('9', new char[]{'w','x','y','z'});
        }};
        
        if(str.length() == 0)
        {
            lists.add(sb.toString());
        }
        else
        {
            for(char d : keyMap.get(str.charAt(0)))
            {
                sb.append(d);
                letterCombinationsHelper(lists, sb, str.substring(1));
                sb.setLength(sb.length() - 1);
            }
        }
        
    }    
}
