package training2020.electricBicycle;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ElectricBicycle {
    public static final String DECORATION = "＊＊＊＊＊＊＊＊＊＊＊＊";
    public static final String ALERT = "！！！！！！！！！！！！！！！！！！！！！！！";
    public static final String INVALID_COMMENT = ALERT + "\n不正な値が入力されました。処理を終了します。\n" + ALERT;
    public static final String STOP_COMMENT = "終了します。";
    static Scanner stdIn = new Scanner(System.in);
    protected static int charge = 0;
    protected static double mileage = 0;
    protected static double fee = 0;

    public static void main(String[] args) {
    //public static void electricCar() {
        System.out.println(DECORATION + "\n電気自転車充電プログラム\n" + DECORATION);
        System.out.print("充電しますか？(y/n)==>");

        if (!"y".equals(stdIn.next())) {
            System.out.print("\n" + STOP_COMMENT);
            System.exit(1);
        }
        System.out.print("何キロワット充電しますか？==>");

        // 充電する電気料の入力と確認
        try {
            charge  = stdIn.nextInt();
        } catch (InputMismatchException e) {
            System.out.print(INVALID_COMMENT);
            System.exit(1);
        }

        // 走行距離と料金の算出
        if (charge >= 0 && charge  <= 30) {
            fee = charge  * 17.73;
            mileage = charge  * 1.5;
        } else if (charge  >= 31 && charge  <= 80) {
            fee = charge  * 21.26;
            mileage = charge  * 1.5;
        } else if (charge  >= 81 && charge  <= 100) {
            fee = charge  * 24.07;
            mileage = charge  * 1.5;
        } else if (charge  >= 101 && charge  <= 200) {
            fee = charge  * 21.26;
            mileage = charge  * 1.5;
        } else {
            System.out.print(ElectricBicycle.INVALID_COMMENT);
            System.exit(1);
        }

        // 結果の表示
        System.out.println(charge  + "キロワット、充電しました。");
        System.out.println("あなたのJ-charyは、" + mileage + "km走ることができます。");
        System.out.println("充電にかかった費用は、" + displayFormat(fee) + "円です。");
    }

    // 表示形式の設定
    private static String displayFormat(double fee) {
        Math.floor(fee);// 切り捨て
        int intFee = (int) fee; // 整数で表示
        NumberFormat formatter = NumberFormat.getNumberInstance(); // カンマ区切りで表示
        return formatter.format(intFee);
    }
}
