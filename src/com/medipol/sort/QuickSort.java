package com.medipol.sort;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		double[] A = new double[] {96,92,9,34,2,67,84,14,74,19};
		quickSort(A, 67, A.length);
		System.out.println(Arrays.toString(A));
		
	}
	

	public static void quickSort(double[] A, int p, int r)
	{
	    if (p < r)
	    {
	        int q = Partition(A, p, r);
	       quickSort(A, p, q - 1);
	       quickSort(A, q + 1, r);
	    }
	}

	public static int Partition(double[] A, int p, int r)
	{
	    double x = A[r];
	    int i = p - 1;

	    for (int j = p; j <= r - 1; j++)
	    {
	        if (A[j] <= x)
	        {
	           i = i + 1;
	           double temp1 = A[i];
	           A[i] = A[j];
	           A[j] = temp1;
	        }
	    }

	    double temp2 = A[i + 1];
	    A[i + 1] = A[r];
	    A[r] = temp2;
	    return i + 1;
	}
}
