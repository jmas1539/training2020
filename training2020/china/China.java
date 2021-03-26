package training2020.china;

import java.util.List;
import java.util.Scanner;

public class China {

	public static final String DECORATIONLON_L = "＊＊＊＊＊＊＊＊＊＊＊＊＊";
	public static final String DECORATIONLON_S = "====";
	public static final String DECORATIONLON_ERROR = "！！！！！！！！！！！！！！！！！！！！！！！！";
	public static final String COMMMENT_NOMENU = "入力されたメニュー番号は存在しません。";
	public static final String ORDER = "ご注文内容は以下の通りです。";
	public static Scanner stdIn = new Scanner(System.in);

	// public static void main(String[] args)
	public static void oderChineseFood() {
		MenuDaoImpl menudaoimpl = new MenuDaoImpl();
		
		// メニューリストの表示する。displayMenuList();//
		System.out.println(DECORATIONLON_L + "\n中華料理注文プログラム\n" + DECORATIONLON_L);
		System.out.println("いらっしゃいませ。" + DECORATIONLON_S + "メニューリスト" + DECORATIONLON_S);
		List<ItemDto> menuList = menudaoimpl.getAllMenus();// メニューリストを取ってる。
		for (int i = 0; i < menuList.size(); i++) {// sizeにするとメニュー数に応じた数値が入る。回数反復するときとかは条件に使うデータの値を小さくする。１とか
			System.out.println("メニューNo." + menuList.get(i).getMenuno() + "[" + menuList.get(i).getCategorynm() + "]"
					+ "    " + menuList.get(i).getItemnm() + "･･･" + menuList.get(i).getPrice() + "円【"
					+ menuList.get(i).getItemdesc() + "】");
		}


		// 今日のおすすめを表示する。displayRecommend();
		CategoryDto cd = menudaoimpl.recommandedCategory();// CategoryDtoをインスタンス化してる
		String[] days = { "月", "火", "水", "木", "金", "土", "日" };//定数にできるよ
		System.out.println(DECORATIONLON_S + "本日（" + days[cd.getCatflg()] + "曜日" + "）のおすすめは" + cd.getCategorynm()
				+ "です。" + DECORATIONLON_S);
		System.out.print("ご注文はお決まりですか？メニュー番号を入力してください。==>");


		// メニュー番号の入力を受け付け、メニュー表から商品情報を取得する。
		String menuno = stdIn.next();
		ItemDto md = menudaoimpl.getMenu(menuno);// 入力された値の中身があるか判断する。（箪笥の引き出しの中に情報が入っているかどうか）
		if (md.getMenuno() == null) {
			System.out.println(DECORATIONLON_ERROR + "\n" + COMMMENT_NOMENU + "\n" + DECORATIONLON_ERROR);
		}

		//取得したメニュー情報を表示する。
		boolean isSale = cd.getCategory().equals(md.getCategory());
		System.out.println(DECORATIONLON_S + ORDER + DECORATIONLON_S);
		System.out.println("メニュー番号：" + menuno);
		System.out.println("注文名：" + md.getItemnm());
		if (isSale) {
			System.out.println("注文金額：" + (int) (md.getPrice() * 0.9) + "円");// インスタンスに情報が入っている。
			System.out.println("本日のおすすめは１割引です！");
		} else {
			System.out.println("注文金額：" + md.getPrice() + "円");
		}
		System.out.println(DECORATIONLON_S + "ご注文を承りました。" + DECORATIONLON_S);

	}

}