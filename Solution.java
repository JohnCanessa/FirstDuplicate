import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 
 */
public class Solution {

  /**
   * Find first duplicate in specified array. Use a hashmap. O(n) & S(n).
   */
  static int firstDuplicate(int[] arr) {

    // **** ****
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    // **** loop processing the array ****
    for (int i = 0; i < arr.length; i++) {

      // **** check if values in NOT in the hash map ****
      if (hm.containsKey(arr[i])) {
        return arr[i];
      }

      // **** put the value in the hash map ****
      hm.put(arr[i], 1);
    }

    // **** no duplicate found ****
    return -1;
  }

  /**
   * Find first duplicate in specified array. Use a hash set. O(n) & S(n).
   */
  static int firstDuplicate1(int[] arr) {

    // **** ****
    HashSet<Integer> set = new HashSet<Integer>();

    // **** traverse the array ****
    for (int i = 0; i < arr.length; i++) {
      if (!set.add(arr[i])) {
        return arr[i];
      }
    }

    // **** no duplicate found ****
    return -1;
  }

  /**
   * Find first duplicate in specified array. Use a hash set. O(n) & S(1).
   */
  static int firstDuplicate2(int[] arr) {

    // **** traverse the array ****
    for (int i = 0; i < arr.length; i++) {

      // **** get the index for this value ****
      int j = Math.abs(arr[i]) - 1;

      // // ???? ????
      // System.out.println("firstDuplicate2 <<< j: " + j);

      // **** check if this value (as an index) has been seen ****
      if (arr[j] < 0) {
        return Math.abs(arr[i]);
      }

      // **** flag that the index has been seen ****
      arr[j] *= -1;

      // // ???? ????
      // System.out.println("firstDuplicate2 <<< arr: " + Arrays.toString(arr));

    }

    // **** no duplicate found ****
    return -1;
  }

  /**
   * Test scaffolding. The values in the array are in the range [1 : n].
   */
  public static void main(String[] args) {

    // **** open scanner ****
    Scanner sc = new Scanner(System.in);

    // **** get number of test cases ****
    int t = sc.nextInt();

    // ???? ????
    System.out.println("main <<< t: " + t);

    // **** get past the EOL ****
    sc.nextLine();

    // **** loop once per test case ****
    for (int i = 0; i < t; i++) {

      // **** read the string of numbers ****
      String s = sc.nextLine();

      // // ???? ????
      // System.out.println("main <<< s ==>" + s + "<==");

      // **** split the numbers in the stirng ****
      String sa[] = s.split(" ");

      // **** declare the array ****
      int[] arr = new int[sa.length];

      // **** populate array of integers ****
      for (int j = 0; j < sa.length; j++) {
        arr[j] = Integer.parseInt(sa[j]);
      }

      // ???? ????
      System.out.println("main <<< arr: " + Arrays.toString(arr));

      // **** get the first duplicate ****
      System.out.println("main <<< firstDuplicate: " + firstDuplicate(arr));
      System.out.println("main <<< firstDuplicate: " + firstDuplicate1(arr));
      System.out.println("main <<< firstDuplicate: " + firstDuplicate2(arr));
    }

    // **** close scanner ****
    sc.close();
  }
}