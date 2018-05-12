package pers.lxs.offer.from01to10;

import java.io.PrintStream;
import java.util.Scanner;

public class Main01
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    int target = sc.nextInt();

    int M = sc.nextInt();
    int N = sc.nextInt();

    int[][] array = new int[M][N];

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        array[i][j] = sc.nextInt();
      }
    }

    sc.close();

    System.out.println(new Main01().Find(target, array));
  }

  public boolean Find(int target, int[][] array)
  {
    int M = array.length;
    int N = array[0].length;

    int r = M - 1; int c = 0;

    while ((r >= 0) && (c < N))
    {
      if (array[r][c] == target) {
        return true;
      }

      if (array[r][c] < target)
        c++;
      else if (array[r][c] > target) {
        r--;
      }

    }

    return false;
  }
}