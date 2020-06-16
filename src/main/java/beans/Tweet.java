//  自分が格納されているフォルダ名
package beans;

import java.sql.Date;

public class Tweet {

	//  属性
	private int id;			//　ID
	private String tweet = null;			// 本文
	private Date created_at;			// 投稿日時
	private Date updated_at;		// 更新日時
	private User user;	// UserのID（外部キー）

	// 初期値を引数に持ったコンストラクタ
	public Tweet(int id, String tweet, Date created_at, Date updated_at, User user){

		this.id = id;
		this.tweet = tweet;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.user = user;

	}


	// Tweet 登録時に必要なIDを持たないコンストラクタ
	public Tweet(String tweet, Date created_at, Date updated_at, User user){

		this.tweet = tweet;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.user = user;

	}

	// ToDo:Tweet更新時に必要なコンストラクタ




	//  初期値を引数に持たないコンストラクタ
	//  Java beansは初期値を持たないコンストラクタが必ず必要
	public Tweet(){}

	//  setメソッド
	//  Java beansのsetメソッドはsetの後ろに続く文字列が必ず大文字であること
	public void setID(int id){ this.id = id; }
	public void setTweet(String tweet){ this.tweet = tweet; }
	public void setCreatedAt(Date created_at){ this.created_at = created_at; }
	public void setUpdatedAt(Date updated_at){ this.updated_at = updated_at; }
	public void setUser(User user) { this.user = user; }

	//  getメソッド
	//  Java beansのgetメソッドはgetの後ろに続く文字列が必ず大文字であること
	public int getID(){ return this.id; }
	public String getTweet(){ return this.tweet; }
	public Date getCreatedAt(){ return this.created_at; }
	public Date getUpdatedAt(){ return this.updated_at; }
	public User getUser() {return this.user; }



}