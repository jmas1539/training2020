
import java.util.Arrays;
import java.util.Scanner;

public class Kazunarabe {

    public static void main(String[] args) {
        try {
            Scanner stdIn = new Scanner(System.in);
            System.out.print("昇順に並び替えますか？(y/n)==>");
            String choice = stdIn.next();     // 要素数を読み込む

            System.out.println("並べ替えしたい数はいくつですか？（２-５）==>");
            int n = stdIn.nextInt();          // 要素数を読み込む
            int[] a = new int[n];             // 配列を生成

            if ((2 <= n) && (n <= 5)) {       //並び替え対象の値の数を制限
                for (int i = 0; i < n; i++) {//n
                    System.out.print((i + 1) + "つ目==>");
                    a[i] = stdIn.nextInt();
                    if ((0 <= i) && (i <= 100)) {//並び替え対象の値の制限
                    
                    }
                }
            }    

            else {                             //不正な値が入力された時の対処
                System.out.println("！！！！！！！！！！！！！！！！！！！！\n不正な値が入力されました！処理を終了します。\n!！！！！！！！！！！！！！！！！！！！！");
            }    

            Arrays.sort(a);                     //入力された数値を昇順に並び替え

            if ("y".equals(choice)) {
                System.out.println("昇順に並び替えます！" + Arrays.toString(a));
            }

            else {
                int[] b = new int[n]; // 配列を生成
                int maxIndex = n - 1;
                for (int i = maxIndex; i >= 0; i--) {
                    b[maxIndex - i] = a[i];
                }
                System.out.println("降順に並び替えます！" + Arrays.toString(b));
            }
        } catch (Exception e) {                  //不正な値が入力された時の対処
            System.out.println("！！！！！！！！！！！！！！！！！！！！\n不正な値が入力されました！処理を終了します。\n!！！！！！！！！！！！！！！！！！！！！");
        }
    }
}