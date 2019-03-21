import java.util.*;
import java.io.*;

/*sort the array from least to greatest value. This is a wrapper function*/
public class Merge{
  public static void mergesort(int[] data){
    mergesortMake(data);
  }

  private static void mergesortMake(int[] data){
    if(data.length <= 1){}
    else if(data.length > 50)
    {
      int[] left = new int[data.length / 2];
      int[] right = new int[data.length - left.length];
      for(int i = 0; i < left.length; i ++)
      {
        left[i] = data[i];
      }
      for(int i = 0; i < right.length; i ++)
      {
        right[i] = data[left.length + i];
      }
      // System.out.println("My two new arrays are");
      // System.out.print("Left: " + Arrays.toString(left) + " ");
      // System.out.println("Right: " + Arrays.toString(right));
      mergesortMake(left);
      mergesortMake(right);
      //past this point, the data has finished splitting. We move onto merging now
      for(int i = 0, a = 0 , b = 0; i < data.length;)
      {
        if(b == right.length)
        {
          // System.out.println("The i index is now " + i);
          data[i] = left[a];
          // System.out.println("left[a] is " + left[a]);
          a ++;
          i ++;
          // System.out.println("Moved from left array into data due to empty right array. Here is my data! " + Arrays.toString(data));
        }
        else if(a == left.length)
        {
          // System.out.println("The i index is now " + i);
          data[i] = right[b];
          // System.out.println("right[b] is " + right[b]);
          b ++;
          i ++;
          // System.out.println("Moved from right array into data due to empty left array. Here is my data! " + Arrays.toString(data));
        }
        else if(a < left.length && b < right.length)
        {
          if(left[a] <= right[b])
          {
            // System.out.println("The i index is now " + i);
            data[i] = left[a];
            a ++;
            i ++;
            // System.out.println("Moved from left array into data. Here is my data! " + Arrays.toString(data));
            continue;
          }
          else
          {
            // System.out.println("The i index is now " + i);
            data[i] = right[b];
            b ++;
            i ++;
            // System.out.println("Moved from right array into data. Here is my data! " + Arrays.toString(data));
            continue;
          }
        }
      }
      // System.out.println("After combining the previous two arrays, here is my combined! " + Arrays.toString(data));
    }
    else
    {
      insertionsort(data,0,data.length - 1);
    }
  }

  public static void insertionsort(int[] data, int lo,int hi){
    for(int i = lo + 1; i <= hi; i ++)
    {
      // System.out.println("Initial look at array " + Arrays.toString(data));
      if(data[i] < data[i - 1])
      {
        for(int n = i; n > lo; n --)
        {
          if(data[n - 1] > data[n])
          {
            int holder = data[n - 1];
            data[n - 1] = data[n];
            data[n] = holder;
          }
          else
          {
            n = -1;
          }
          // System.out.println("Something wrong has been found and fixed " + Arrays.toString(data));
        }
      }
    }
  }
  public static void main(String[] args){
    int[] randomArray = new int[10];
    int[] problemArray = {17, 18, 7, 13, 1, 5, 16, 11, 0, 5};
    for(int i = 0; i < randomArray.length; i ++)
    {
      randomArray[i] = ((int) (Math.random() * 1000)) % 20;
    }
    System.out.println("My current array being used is " + Arrays.toString(randomArray));
    mergesort(randomArray);
    System.out.println("My sorted array is " + Arrays.toString(randomArray));
    // System.out.println("My current array being used is " + Arrays.toString(problemArray));
    // mergesort(problemArray);
    // System.out.println("My sorted array is " + Arrays.toString(problemArray));
  }

}
