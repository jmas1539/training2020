package training2020.china;

/**
 ** 商品マスタ、カテゴリマスタからデータを取得するロジックの実装クラス
 **/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl implements MenuDao {

    /* データベースへの接続、SQLをコンスタントとして定義 */
    /* 実際ユーザIDやパスワード、ホスト名などはプロパティファイルに保持するが、研修のため直書き */
    private static final String URL = "jdbc:mysql://localhost:3306/freshers_schema?serverTimezone=JST";
    private static final String USER = "root";
    private static final String PASS = "freshers@2020";
    private static final String SQL1 = "select I.*, C.categorynm from item As I	inner join category As C on I.category = C.category;";
    private static final String SQL2 = "select * from item where menuno = menuno???;";
    private static final String SQL3 = "select * from category where weekday(now()) = catflg;";
    private static final String SQL4 = "select * from item where category = category???;";

    // List is working as a database
    // private List<ItemDto> menuList;

    /**
     ** メニューリスト取得
     ** 
     * @see training2020.MenuDao#getAllMenus()
     **/
    @Override
    public List<ItemDto> getAllMenus() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<ItemDto> menuList = new ArrayList<ItemDto>();

        try {
            // DB接続
            conn = getConnection();

            // SQL1 を実行。結果はレコードセットに格納される
            ps = conn.prepareStatement(SQL1);
            rs = ps.executeQuery();

            // レコードセットをループしてすべての抽出行をItemDtoフィールドにセットする
            while (rs.next()) {
                ItemDto md = new ItemDto();
                md.setMenuno(rs.getString("menuno"));
                md.setItemnm(rs.getString("itemnm"));
                md.setCategory(rs.getString("category"));
                md.setPrice(rs.getInt("price"));
                md.setItemdesc(rs.getString("itemdesc"));
                md.setCategorynm(rs.getString("categorynm"));
                menuList.add(md);
            }
            return menuList;

        } catch (SQLException e) {
            System.out.println("*** Error!! SQLException ***");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);

        } catch (RuntimeException e) {
            System.out.println("*** Error!! Exception ***");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            closeSql(conn, ps, rs);
        }
    }

    /*
     * 該当するメニュー番号の商品情報を取得する
     * 
     * @see training2020.MenuDao#getMenu(java.lang.String)
     */
    @Override
    public ItemDto getMenu(String menuno) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        /* ItemDtoのインスタンスを生成 */
        ItemDto md = new ItemDto();
        try {
            // DB接続
            conn = getConnection();

            /* SQL2実行 */
            ps = conn.prepareStatement(SQL2);
            ps.setString(1, menuno);
            rs = ps.executeQuery();

            /* 該当商品情報をItemDtoフィールドにセットする */
            if (rs.next()) {
                md.setMenuno(rs.getString("menuno"));
                md.setItemnm(rs.getString("itemnm"));
                md.setCategory(rs.getString("category"));
                md.setPrice(rs.getInt("price"));
                md.setItemdesc(rs.getString("itemdesc"));
                return md;

                /* 該当なしならNullで復帰 */
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("*** Error!! SQLException ***");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            System.out.println("*** Error!! Exception ***");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            closeSql(conn, ps, rs);
        }
    }

    /*
     * おすすめのカテゴリを取得する
     * 
     * @see training2020.MenuDao#recommandedCategory()
     * ポイントはSQLで本日の曜日を取得して抽出条件にしているところ
     */
    @Override
    public CategoryDto recommandedCategory() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        /* CategoryDtoインスタンス生成 */
        CategoryDto cd = new CategoryDto();
        try {
            // DB接続
            conn = getConnection();

            /* SQL3実行 */
            ps = conn.prepareStatement(SQL3);
            rs = ps.executeQuery();

            /* 該当カテゴリ情報をCategoryDtoフィールドにセットする */
            if (rs.next()) {
                cd.setCategory(rs.getString("category"));
                cd.setCategorynm(rs.getString("categorynm"));
                cd.setCatflg(rs.getInt("catflg"));
                cd.setMemo(rs.getString("memo"));
                return cd;

                /* 該当なしならNullで復帰 */
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("*** Error!! SQLException ***");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            System.out.println("*** Error!! Exception ***");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            closeSql(conn, ps, rs);
        }
    }

    /*
     * 該当するカテゴリのメニュー（商品）情報を取得する
     * 
     * @see training2020.MenuDao#recommandedMenu(java.lang.String)
     */
    @Override
    public List<ItemDto> recommandedMenu(String category) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<ItemDto> menuList = new ArrayList<ItemDto>();

        try {
            // DB接続
            conn = getConnection();

            /* SQL4実行 */
            ps = conn.prepareStatement(SQL4);
            ps.setString(1, category);
            rs = ps.executeQuery();

            while (rs.next()) {
                ItemDto md = new ItemDto();
                md.setMenuno(rs.getString("menuno"));
                md.setItemnm(rs.getString("itemnm"));
                md.setCategory(rs.getString("category"));
                md.setPrice(rs.getInt("price"));
                md.setItemdesc(rs.getString("itemdesc"));
                menuList.add(md);
            }
            return menuList;

        } catch (SQLException e) {
            System.out.println("*** Error!! SQLException ***");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            System.out.println("*** Error!! Exception ***");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            closeSql(conn, ps, rs);
        }
    }

    /**
     ** DB接続 復帰値：DBコネクション
     **/
    private Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    /**
     ** データベースアクセス後処理 復帰値：なし
     **/
    private static void closeSql(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}