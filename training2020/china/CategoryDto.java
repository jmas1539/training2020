package training2020.china;

/**
 ** categoryテーブルの内容を格納するクラス変数と各フィールドのアクセッサを定義
 **///

public class CategoryDto {
	private String getMenuno;
	private String category;
	private  String categorynm;
	private int catflg;
	private String memo;

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

	public int getCatflg() {
		return catflg;
	}

	public void setCatflg(int catflg) {
		this.catflg = catflg;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}