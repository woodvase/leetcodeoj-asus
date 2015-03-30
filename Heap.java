package codingexcercise;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoli
 */
public class Heap {
    public static void heapSort(int[] a)
    {
        build(a);
        for(int i = a.length - 1; i >0; i --)
        {
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            heapify(a, 0, i);
        }
    }
    
    // subtrees below index are heaps. adding a[index] to the heap 
    public static void heapify(int[] a, int index, int end)
    {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int min = index;
        if(left < end && a[left] < a[index])
        {
            min = left;
        }
        if(right < end && a[right] < a[index])
        {
            min = right;
        }
        if(min != index)
        {
            int tmp = a[index];
            a[index] = a[min];
            a[min] = tmp;
            heapify(a, min, end); 
        }
    }
    public static void build(int[] a)
    {
        for(int i = a.length / 2; i >= 0; i --)
        {
            heapify(a, i, a.length);
        }
    }                
}
