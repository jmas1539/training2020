package training2020.china;

/**
 **  itemテーブル、categoryテーブルの情報を取得するためのインターフェース
 **/
import java.util.List;

public interface MenuDao {

    // メニューリスト取得する
    public List<ItemDto> getAllMenus();

    // メニュー番号の商品情報を取得する。
    // 引数は入力されたメニュー番号を渡せば、商品情報をItemDtoクラス変数で取得することができる。
    public ItemDto getMenu(String menuno);

    // 本日のおすすめ情報を取得する
    // 呼び出すだけで、本日のおすすめカテゴリが取得できる。
    public CategoryDto recommandedCategory();

    // 本日のおすすめメニューを取得する
    // 本日のおすすめカテゴリからおすすめメニューを取得することができる。複数あるかもしれないからListでクラス変数を受け取る。
    public List<ItemDto> recommandedMenu(String category);
}