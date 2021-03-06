package training2020.kazunarabe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * これは数並べをさせるクラス
 */
public class Kazunarabe {

    public static final String DECORATION = "＊＊＊＊＊＊＊＊＊＊＊";
    public static final String ALERT = "！！！！！！！！！！！！！！！！！！！！";
    public static final String INVALID_COMMENT = ALERT + "\n不正な値が入力されました！処理を終了します。\n" + ALERT;
    static Scanner stdIn = new Scanner(System.in);

    //public static void main(String[] args) 
    public static void kazunarabe() throws Exception {

        System.out.println(DECORATION + "\n数字並べ替えプログラム\n" + DECORATION);

        // 入力値でsort順を決定する。
        System.out.print("昇順に並べ替えますか？(y/n)==>");
        boolean isNaturalOrder = "y".equals(stdIn.next());

        // sortさせる数値の個数を決定させる。
        System.out.print("並べ替えしたい数字の数はいくつですか？（2-5）==>");
        int[] a = new int[getInputInt(INVALID_COMMENT)];
        if ((2 > a.length) || (a.length > 5)) {// 数字以外の時エラーになってしまう。エラーメッセージが表示されない。
            handleError(INVALID_COMMENT);
        }

        // sortさせる数値の入力を保持する。
        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "つ目==>");
            a[i] = getInputInt(INVALID_COMMENT);
            if ((0 > a[i]) || (a[i] > 100)) { 
                handleError(INVALID_COMMENT);
            }
        }

        // 入力された数値を昇順に並び替える。
        Arrays.sort(a);

        // sortされた結果を出力する。
        if (isNaturalOrder) {
            System.out.println("昇順に並べ替えます！" + Arrays.toString(a));
        } else {
            int[] b = new int[a.length];
            int maxIndex = (a.length - 1);
            for (int i = maxIndex; i >= 0; i--) {
                b[maxIndex - i] = a[i];
            }
            System.out.println("降順に並べ替えます！" + Arrays.toString(b));
        }
    }

    
    /**
     * errorhandlingをする。
     * 
     * @param message 出力させるエラーメッセージ。
     */
    private static void handleError(String message)  throws Exception {
        System.out.println(message);
        throw new Exception("数並べエラー");
        //System.exit(1);// mainに戻らない様Exitで終了する。
    }

    private static int getInputInt(String message) throws Exception {
        int i = 0;
        try {
            i = stdIn.nextInt();
        } catch (InputMismatchException ex) {
            handleError(message);
        }
        return i;
    }
}