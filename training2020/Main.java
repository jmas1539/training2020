package training2020;

import java.util.Scanner;

import training2020.kazunarabe.Kazunarabe;
import training2020.sestubun.Setsubun;

public class Main {

    public static final String ALERT = "！！！！！！！！！！！！！！！！！！！！";
    public static final String INVALID_COMMENT = ALERT + "\n不正な値が入力されました。処理を終了します。\n"+ ALERT ;
    public static final String THANKS_COMMENT =  "ご利用ありがとうございました。" ;
    public static final String NEXT_COMMENT =  "またのご利用をお待ちしております。" ;
    public static Scanner stdIn = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("* * *プログラミング体験アプリへようこそ！* * *");
        System.out.println("1:数字並び替えプログラム");
        System.out.println("2:節分アルゴリズムプログラム");
        System.out.println("3:中華料理注文プログラム");
        System.out.println("9:終了");
        System.out.println("実行したいプログラム番号を選択してください（1-3,9）");
        /** 
        //入力値が不正かどうかの判断
        */
        int n = stdIn.nextInt();
        switch (n) {
            case 1 :Kazunarabe.kazunarabemethod(); 
            break;

            case 2 :Setsubun.setsubunmethod();
            break;

            // /** 
            // case 3 :public static void chinamethod();
            // break;*/

            case 9 :System.out.println("\n" + NEXT_COMMENT + "\n");
            break;
            
            default :System.out.println(INVALID_COMMENT);
            
        }

        //呼ばれたクラスが正常に終了した場合
        System.out.println("\n" + THANKS_COMMENT +  "\n" + NEXT_COMMENT + "\n");

    }


}