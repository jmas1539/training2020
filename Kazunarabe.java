
import java.util.Arrays;
import java.util.Scanner;

public class Kazunarabe {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("昇順で並び替えますか？y/n==>");
        String choice = stdIn.next();// 要素数を読み込む


        System.out.println("並べ替えしたい数はいくつですか？（２〜５）==>");
        int n = stdIn.nextInt();// 要素数を読み込む
        int[] a = new int[n]; // 配列を生成
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "つ目");
            a[i] = stdIn.nextInt();
            
        }
        Arrays.sort(a);
        
        if ("y".equals(choice)) {
            
            System.out.println("昇順に並び替えます！" + Arrays.toString(a));
        }

        else {
            
            int[] b = new int[n]; //配列を生成
            int maxIndex = n - 1;
            for (int i = maxIndex ; i >= 0; i--) {
               b[maxIndex - i] = a[i];
            }

            System.out.println("降順に並び替えます！" + Arrays.toString(b));
        }   
    }
}