package training2020.sestubun;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Setsubun {
    private static final String DECORATIONLON_L = "＊＊＊＊＊＊＊＊＊＊＊＊＊";
    public static final String ALERT = "！！！！！！！！！！！！！！！！！！！！";
    public static final String INVALID_COMMENT = ALERT + "\n不正な値が入力されました！処理を終了します。\n" + ALERT;
    public static String[] name = { "じいちゃん", "ばあちゃん", "父ちゃん", "母ちゃん", "おれ", "いもうと" };
    public static final String STOP_COMMENT = "終了します。" ;
    public static Scanner stdIn = new Scanner(System.in);
    private static Person personAt100 = null;
    private static Person personAt200 = null;

    //public static void main(String[] args) {
    public static void setsubunmethod() {
    
        System.out.println(DECORATIONLON_L + "\n数字並べ替えプログラム\n" + DECORATIONLON_L);
        // 処理を続行するかしないかの判断
        System.out.print("今日は節分ですか？(y/n)==>");
        if (!"y".equals(stdIn.next())) {
            System.out.print(STOP_COMMENT);
            System.exit(1);//メインに戻る様にする。
        }
        try {
            Person[] families = new Person[name.length];
            for (int i = 0; i < name.length; i++) {
                System.out.print(name[i] + "の年齢は==>");
                families[i] = new Person(name[i], stdIn.nextInt());
                if ((0 > families[i].getAge()) || (families[i].getAge() > 100)) { // 数字以外の時エラーになってしまう。エラーメッセージが表示されない。
                    handleError(INVALID_COMMENT);
                }
            }

            int sum = 0;
            for (int i = 0; i < families.length; i++) {
                families[i].sayEatBeans();
                sum = sum + families[i].getAge();
                if (sum >= 100 && personAt100 == null) {
                    personAt100 = families[i];
                }
                if (sum >= 200 && personAt200 == null) {
                    personAt200 = families[i];
                }
            }
            if (personAt100 == null) {
                System.out.println("100粒目の豆を食べた人はいません。");
            } else {
                System.out.println("100粒目の豆を食べた人は" + personAt100.getName() + "です。");
            }
            if (personAt200 == null) {
                System.out.println("200粒目の豆を食べた人はいません。");
            } else {
                System.out.println("200粒目の豆を食べた人は" + personAt200.getName() + "です。");
            }
            System.out.println("家族全員で食べた豆の数は" + sum + "粒です。");

        } catch (InputMismatchException e) {
            handleError(INVALID_COMMENT);
        }
    }

    private static void handleError(String message) {// クラスの中にメソッドを作る際は、メソッド同士は別々で作る。（メソッドの定義の中で別のメソッド定義ができない）
        System.out.println(message);
       
    }
}