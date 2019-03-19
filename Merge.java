import java.util.*;
import java.io.*;

/*sort the array from least to greatest value. This is a wrapper function*/
public class Merge{
  public static void mergesort(int[] data){
    mergesortMake(data);
  }

  // public static void mergesortBreak(int[] data,int[] thing1,int[] thing2){
  //   if(data.length <= 1){} //stop
  //   else
  //   {
  //     int[] thing1Left = new int[thing1.length / 2];
  //     int[] thing1Right = new int[thing1.length - thing1Left.length];
  //     int[] thing2Left = new int[thing2.length / 2];
  //     int[] thing2Right = new int[thing2.length - thing2Left.length];
  //     for(int i = 0; i < thing1Left.length; i ++)
  //     {
  //       thing1Left[i] = thing1[i];
  //     }
  //     for(int i = 0; i < thing1right.length; i ++)
  //     {
  //       right[i] = data[left.length + i];
  //     }
  //     mergesortBreak(left,left,right);
  //     mergesortBreak(right,left,right);
  //   }
  // }

  public static void mergesortMake(int[] data){

    if(data.length <= 1){}
    else
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
      if(left.length == 0)
      {
        data[0] = right[0];
      }
      if(right.length == 0)
      {
        data[0] = left[0];
      }
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
