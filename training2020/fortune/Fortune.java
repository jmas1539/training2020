package training2020.fortune;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Fortune {
    public static final String DECORATION = "＊＊＊＊＊＊＊＊＊＊＊";
    public static final String ALERT = "！！！！！！！！！！！！！！！！！！！！！！！";
    public static final String INPUT_NAME = "あなたの名前を入力してください。===>";
    public static final String OUTPUT_RESULT = "さんの今日の運勢は、";
    public static final String INVALID_COMMENT = ALERT + "\n名前の入力がなかったため、処理を終了します。\n" + ALERT;
    static Scanner stdIn = new Scanner(System.in);
    public static List<String> fortuneList = Arrays.asList("大吉です。", "中吉です。", "中吉です。","中吉です。","中吉です。","小吉です。", "小吉です。","吉です。", "吉です。","凶です。ファイト！");

    public static void main(String[] args) {
        System.out.println(DECORATION + "\n今日の運勢プログラム\n" + DECORATION);
        System.out.println(INPUT_NAME);
        String username = null;

        for (int i = 0; i < 3; i++) {
            username = stdIn.nextLine();
            if ("".equals(username)) {
                // Ststem.
                if (i == 2){
                    System.out.println(INVALID_COMMENT);
                    System.exit(1);
                }
                continue;
            }                
            break;
        }
        int index = new Random().nextInt(fortuneList.size()); // fortuneListをランダムに選択
        String result = fortuneList.get(index); // ランダムに選択された要素
        System.out.println(username + OUTPUT_RESULT + result); // fortuneListの中を表示
    }

}
