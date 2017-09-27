package com.concept.algorithms.array;

public class MergeTwoSortedArrays {
    
    public static void main (String... args) {
        MergeTwoSortedArrays m = new MergeTwoSortedArrays();
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6, 8};
        int c[] = m.merge(a, b);
        for (int i:c) {
            System.out.print(i + " ");
        }
    }

    public int[] merge(int[] a, int[] b)  {
        
        int[] c = null;
        
        if(null==a && null!=b) return b;
        else if (null==b && null!=a) return a;
        else if (null==a && null==b) return null;
        else {
            int len1 = a.length;
            int len2 = b.length;
            int i=0,j=0,k=0;
            c= new int[len1+len2];
            
            while (i<len1 && j<len2) {
                if (a[i] < b[j]) {
                    c[k++] = a[i++];
                } else {
                    c[k++] = b[j++];
                }
            }
            
            while (i<len1) {
                c[k++] = a[i++];
            }
            
            while (j<len2) {
                c[k++] = b[j++];
            }
            
        }
        
        return c;
        
    }
}
