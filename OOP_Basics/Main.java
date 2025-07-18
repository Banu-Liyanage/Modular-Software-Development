public class Main {
  // This program initializes an array, modifies its last element, and prints the sum of two specific elements.
  // It demonstrates basic array manipulation in Java.
  static String name = "John";
  
  public static void main(String[] args){
    int[] array = {1, 2, 3, 4, 5};  //creates an array with 5 element(int type)
    int length = array.length;
    array[length-1]=8;
    System.out.println(array[4]+array[2]);
    System.out.println("Max value: " + maxValue(array));
    Happybirthday(name);
  }
  public static int maxValue(int[] array){ // This method finds the maximum value in an integer array.
    int max=0;
    for (int i =0; i<array.length;i++){
      if (array[i]>max) max=array[i];
    }
    return max;
  }
  static void Happybirthday(String name){
    System.out.println("Happy birthday to you, " + name + "!");
    System.out.println("Happy birthday to you, " + name + "!");
    System.out.println("Happy birthday dear " + name + "!");
    System.out.println("Happy birthday to you, " + name + "!");
  }
  
}