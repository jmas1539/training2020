package training2020.china;

import java.util.Scanner;

public class China {

	public static final String DECORATIONLON_L = "＊＊＊＊＊＊＊＊＊＊＊＊＊";
	public static final String DECORATIONLON_S = "====";
	public static final String DECORATIONLON_ERROR = "！！！！！！！！！！！！！！！！！！！！！！！！";
	public static Scanner stdIn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(DECORATIONLON_L + "\n中華料理注文プログラム\n" + DECORATIONLON_L);
		System.out.println("いらっしゃいませ。" + DECORATIONLON_S + "メニューリスト" + DECORATIONLON_S);
		System.out.println("メニューNo." + ItemDto.menuno + "【" + CategoryDto.categorynm + "】" + ":" + ItemDto.itemnm + "･･･" + ItemDto.price + "【" + ItemDto.itemdesc +"】");
		
		
		System.out.println(DECORATIONLON_S + "本日（）のおすすめは「麺類」です。" + DECORATIONLON_S);
		System.out.println("ご注文はお決まりですか？メニュー番号を入力してください。==>" + DECORATIONLON_S);
		
		
		
		System.out.println(DECORATIONLON_S + "ご注文内容は以下の通りです。" + DECORATIONLON_S);
		System.out.println(DECORATIONLON_S + "ご注文を承りました。" + DECORATIONLON_S);

	}

}