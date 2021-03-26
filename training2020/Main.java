package training2020;

import java.util.Scanner;

import training2020.china.China;
import training2020.kazunarabe.Kazunarabe;
import training2020.sestubun.Setsubun;

public class Main {

    public static final String ALERT = "！！！！！！！！！！！！！！！！！！！！";
    public static final String INVALID_COMMENT = "不正な値が入力されました。処理を終了します。";
    public static final String THANKS_COMMENT = "ご利用ありがとうございました。";
    public static final String NEXT_COMMENT = "またのご利用をお待ちしております。";
    public static Scanner stdIn = new Scanner(System.in);
    

    public static void main(String[] args) {

        System.out.println("* * *プログラミング体験アプリへようこそ！* * *");
        System.out.println("1:数字並び替えプログラム");
        System.out.println("2:節分アルゴリズムプログラム");
        System.out.println("3:今日の運勢プログラム");
        System.out.println("4:電気自転車プログラム");
        System.out.println("5:中華料理注文プログラム");
        System.out.println("9:処理終了");
        System.out.print("実行したいプログラム番号を選択してください。（1-5,9）:");
        /**
         * //入力値が不正かどうかの判断
         */
        try {
            int n = stdIn.nextInt();
            switch (n) {
                case 1:
                    Kazunarabe.kazunarabe();
                    break;

                case 2:
                    Setsubun.setsubunmethod();
                    break;

                case 3:
                    //Fortune.fortune();
                    break;

                case 4:
                    System.out.println("準備中");
                    break;

                case 5:
                    China.oderChineseFood();
                    break;

                case 9:
                    System.out.println("\n" + NEXT_COMMENT + "\n");
                    System.exit(1);// mainに戻らない様Exitで終了する。
                    break;

                default:
                    System.out.println(ALERT + INVALID_COMMENT + ALERT);
                    break;
            }

        } catch (Exception e) {
            //e.printStackTrace();(エラーの時に出る説明文を出す)
            System.out.println("\n" + NEXT_COMMENT + "\n");
            System.exit(1);// mainに戻らない様Exitで終了する。
        }

        // 呼ばれたクラスが正常に終了した場合
        System.out.println( THANKS_COMMENT + "\n" );
        System.out.println(NEXT_COMMENT );

    }

    //getInput
}