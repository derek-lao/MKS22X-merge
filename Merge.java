/*sort the array from least to greatest value. This is a wrapper function*/
public class Merge{
  public static void mergesort(int[] data){

  }

  public static void mergesortBreak(int[] data){
    if(data.length <= 1){} //stop
    else
    {
      int[] left = new int[data.length / 2];
      int[] right;
      if(data.length % 2 == 0)
      {
        right = new int[data.length / 2];
      }
      else
      {
        right = new int[data.length / 2 + 1];
      }
      for(int i = 0; i < left.length; i ++)
      {
        left[i] = data[i];
      }
      for(int i = 0; i < right.length; i ++)
      {
        right[i] = data[left.length + i];
      }
      mergesortBreak(left);
      mergesortBreak(right);
    }
  }
}
