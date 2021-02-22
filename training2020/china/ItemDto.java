package training2020.china;

/**
 ** itemテーブルの内容を格納するクラス変数と各フィールドのアクセッサを定義
 **/

public class ItemDto {
	/* ItemDto フィールド：privateを付けて非公開アクセスとして、クラスの外部に対してデータを隠蔽する */
	private String menuno;
	private String itemnm;
	private String category;
	private String categorynm;
	private int price;
	private String itemdesc;

	public String getMenuno() {
		return menuno;
	}

	public void setMenuno(String menuno) {
		this.menuno = menuno;
	}

	public String getItemnm() {
		return itemnm;
	}

	public void setItemnm(String itemnm) {
		this.itemnm = itemnm;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategorynm() {
		return categorynm;
	}

	public void setCategorynm(String categorynm) {
		this.categorynm = categorynm;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getItemdesc() {
		return itemdesc;
	}

	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}

}
