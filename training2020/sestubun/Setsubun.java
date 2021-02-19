package training2020.sestubun;

import java.util.Scanner;

public class Setsubun {

    public static final String DECORATIONLON_L = "＊＊＊＊＊＊＊＊＊＊＊＊＊";
    public static final String DECORATIONLON_S = "＊＊＊";
    public static final String EAT = "粒食べました";

    public static String[] name = { "じいちゃん", "ばあちゃん", "父ちゃん", "母ちゃん", "おれ", "いもうと" };// 多次元配列どう使う。
    /** public static int [] age = {90,80,70,60,50,40}; */

    public static final String STOP_COMMENT = DECORATIONLON_S + "\n終了します。\n" + DECORATIONLON_S;
    public static Scanner stdIn = new Scanner(System.in);

    private static Person personAt100 = null;
    private static Person personAt200 = null;

    public static void main(String[] args) {
        /**
         * for ( int i = 0; i < name.length; i++){ System.out.println("name" + i + "人目,"
         * + name[i]); System.out.println("age" + i + "つ目,"+ age[i]); }
         */

        System.out.println(DECORATIONLON_L + "\n数字並べ替えプログラム\n" + DECORATIONLON_L);

        // 処理を続行するかしないかの判断
        System.out.print("今日は節分ですか？(y/n)==>");
        if (!"y".equals(stdIn.next())) {
            System.out.print(STOP_COMMENT);
            System.exit(1);
        }

        Person[] families = new Person[name.length];
        for (int i = 0; i < name.length; i++) {
            System.out.print(name[i] + "の年齢は==>");
            families[i] = new Person(name[i], stdIn.nextInt());
        }

        for (int i = 0; i < name.length; i++) {
            families[i].sayEatBeans();
        }

        int sum = 0;
        for (int i = 0; i < families.length; i++) {
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
    }
}

// "100粒目の豆を食べた人はいません。"
// "200粒目の豆を食べた人はいません。"

// それぞれの年齢を配列に保持する。ループにしたい。ループにしたい時のiの置き方がわからん。２つの配列を同時に回す？？ageとname
/**
 * int[] age; age = new int[5]; if ((0 > age[i]) || (age[i] > 100)) {
 * //数字以外の時エラーになってしまう。エラーメッセージが表示されない。 System.out.println(STOP_COMMENT); }
 */
/**
 * name = new int System.out.print(name[0] + "の年齢"); int age0 = stdIn.nextInt();
 * System.out.print(name[1] + "の年齢"); int age1 = stdIn.nextInt();
 * System.out.print(name[2] + "の年齢"); int age2 = stdIn.nextInt();
 * System.out.print(name[3] + "の年齢"); int age3 = stdIn.nextInt();
 * System.out.print(name[4] + "の年齢"); int age4 = stdIn.nextInt();
 * System.out.print(name[5] + "の年齢"); int age5 = stdIn.nextInt();
 */

// ループさせたい
/**
 * name[i] age[i] System.out.println(DECORATIONLON_S + name[0] + "は" + age0 +
 * EAT + DECORATIONLON_S); System.out.println(DECORATIONLON_S + name[1] + "は" +
 * age1 + EAT + DECORATIONLON_S); System.out.println(DECORATIONLON_S + name[2] +
 * "は" + age2 + EAT + DECORATIONLON_S); System.out.println(DECORATIONLON_S +
 * name[3] + "は" + age3 + EAT + DECORATIONLON_S);
 * System.out.println(DECORATIONLON_S + name[4] + "は" + age4 + EAT +
 * DECORATIONLON_S); System.out.println(DECORATIONLON_S + name[5] + "は" + age5 +
 * EAT + DECORATIONLON_S);
 * 
 * System.out.println(DECORATIONLON_S + name + "は豆を" + age0 + EAT +
 * DECORATIONLON_S); System.out.println(DECORATIONLON_S + name[1] + "は" + age1 +
 * EAT + DECORATIONLON_S); System.out.println(DECORATIONLON_S + name[2] + "は" +
 * age2 + EAT + DECORATIONLON_S); System.out.println(DECORATIONLON_S + name[3] +
 * "は" + age3 + EAT + DECORATIONLON_S); System.out.println(DECORATIONLON_S +
 * name[4] + "は" + age4 + EAT + DECORATIONLON_S);
 * System.out.println(DECORATIONLON_S + name[5] + "は" + age5 + EAT +
 * DECORATIONLON_S);
 * 
 * 
 * int total = age0 + age1 + age2 + age3 + age4 + age5; int count0 = age0 +
 * age1; int count1 = count0 + age2; int count2 = count1 + age3; int count3 =
 * count2 + age4; int count4 = count3 + age5;
 * 
 * if (total < 100){ System.out.println("100粒目の豆を食べた人はいません。"); } if (total <
 * 200) { System.out.println("200粒目の豆を食べた人はいません。"); }
 * 
 * if (100 <= count0 && count0 < 200) { System.out.println("100粒目の豆を食べた人は" +
 * "です。"); }
 * 
 * if (200 <= count0 && count0 < 300) { System.out.println("200粒目の豆を食べた人は" +
 * "です。"); System.out.println("家族全員で食べた豆の数は" + total + "粒です。"); } if (total <
 * 100){ System.out.println("100粒目の豆を食べた人はいません。"); } if (total < 200) {
 * System.out.println("200粒目の豆を食べた人はいません。"); }
 * 
 * if (100 <= count0 && count0 < 200) { System.out.println("100粒目の豆を食べた人は" +
 * "です。"); }
 * 
 * if (200 <= count0 && count0 < 300) { System.out.println("200粒目の豆を食べた人は" +
 * "です。"); System.out.println("家族全員で食べた豆の数は" + total + "粒です。"); } }
 */
