// Radix sort implementation
// Submitted by: Bina Maria
// Banner Id: 00366107

import java.util.*;

class Radix {

    // The utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];

        //Loop through all the elements of the array arr[] and find out the highest value and store it in the variable 'mx'
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // To do counting sort of arr[] according to the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        // output array
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // To store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        // Change count[i] so that count[i] now contain the actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // To populate the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now contains sorted numbers according to current digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to sort arr[] of size n using Radix Sort
    static void radixsort(int arr[], int n)
    {
        // To find the maximum number
        int m = getMax(arr, n);

        // To do counting sort for every digit, here instead of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            //Calling countsort()
            countSort(arr, n, exp);
    }

    // The utility function to print the array
    static void print(int arr[], int n)
    {
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }


    /*The main function which gets evoked automatically once the program gets started*/
    public static void main (String[] args)
    {
        //The input array with the numbers to be sorted
        int arr[] = {70, 45, 75, 90, 8029, 24, 2, 6677 , 6, 5};
        System.out.println("The input array:");

        int n = arr.length;
        int count=0;

        //To check if the digits in each number entered is less than or equal to 4 digits
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
              if(String.valueOf(arr[i]).length()>4)
            {
count=1;
            }
        }
        if(count==1)
        {

       System.out.println("\nDigits of the input entered exceeded the maximum limit 4");
        }
        else
        {
            //Call the Radixsort() if the digits in all the numbers are less than or equal to 4
            radixsort(arr, n);
            //To print the output array
            System.out.println("\nThe sorted array:");
            print(arr, n);
        }


    }
}
