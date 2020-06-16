//  自分が格納されているフォルダ名
package beans;

import java.sql.Date;

public class Review {

	//  属性
	private int id;			//　ID
	private int point;			//　評価
	private String comment = null;		//	コメント
	private Date created_at;		//  投稿日
	private int references_point;	// いいね数
	private Date updated_at;		// 更新日
	private User user = null;		//  投稿者
	private int tapioca_id;		//  店舗ID

	//　初期値を引数に持ったコンストラクタ
	public Review(int id, int point, String comment, Date created_at, int references_point, Date updated_at, User user, int tapioca_id){

		this.id = id;
		this.point = point;
		this.comment = comment;
		this.created_at = created_at;
		this.references_point = references_point;
		this.updated_at = updated_at;
		this.user = user;
		this.tapioca_id = tapioca_id;

	}

	//  ID を持たないコンストラクタ
	public Review(int point, String comment,Date created_at, int references_point, Date updated_at, User user, int tapioca_id){

		this.point = point;
		this.comment = comment;
		this.created_at = created_at;
		this.references_point = references_point;
		this.updated_at = updated_at;
		this.user = user;
		this.tapioca_id = tapioca_id;

	}



	//  初期値を引数に持たないコンストラクタ
	//  Java beansは初期値を持たないコンストラクタが必ず必要
	public Review(){}

	//  setメソッド
	//  Java beansのsetメソッドはsetの後ろに続く文字列が必ず大文字であること
	public void setID(int id){ this.id = id; }
	public void setPoint(int point){ this.point = point; }
	public void setComment(String comment){ this.comment = comment; }
	public void setCreatedAt(Date created_at) { this.created_at = created_at; }
	public void setReferencesPoint(int references_point) { this.references_point = references_point; }
	public void setUpdatedAt(Date updated_at) { this.updated_at = updated_at; }
	public void setUser(User user){ this.user = user; }
	public void setTapiocaID(int tapioca_id){ this.tapioca_id = tapioca_id; }

	//  getメソッド
	//  Java beansのgetメソッドはgetの後ろに続く文字列が必ず大文字であること
	public int getID(){ return this.id; }
	public int getPoint(){ return this.point; }
	public String getComment(){ return this.comment; }
	public Date getCreatedAt() {return this.created_at; }
	public int getReferencesPoint() {return this.references_point;}
	public Date getUpdatedAt() {return this.updated_at;}
	public User getUser(){ return this.user; }
	public int getTapiocaID(){ return this.tapioca_id; }

}