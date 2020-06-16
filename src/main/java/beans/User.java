//  自分が格納されているフォルダ名
package beans;

import java.sql.Date;

public class User {

	//  属性
	private int id;			//　ID
	private String mail_address = null;		// メールアドレス
	private String name = null;			// 名前
	private String password = null;			//　パスワード
	private Date birthday = null;		//	誕生日

	//　初期値を引数に持ったコンストラクタ
	public User(int id, String mail_address, String name, String password, Date birthday){

		this.id = id;
		this.mail_address = mail_address;
		this.name = name;
		this.password = password;
		this.birthday = birthday;

	}

	// 新規登録・パスワード確認に用いるコンストラクタ
	public User(String mail_address, String name, String password, Date birthday){

		this.mail_address = mail_address;
		this.name = name;
		this.password = password;
		this.birthday = birthday;

	}

	//　初期値を引数に持ったコンストラクタ
	public User(int id,String name,Date birthday){

		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

	//  ログイン時に必要なコンストラクタ
	public User(String mail_address, String password) {
		this.mail_address = mail_address;
		this.password = password;
	}

	//  初期値を引数に持たないコンストラクタ
	//  Java beansは初期値を持たないコンストラクタが必ず必要
	public User(){}

	//  setメソッド
	//  Java beansのsetメソッドはsetの後ろに続く文字列が必ず大文字であること
	public void setID(int id){ this.id = id; }
	public void setMailAddress(String mail_address) { this.mail_address = mail_address; }
	public void setName(String name){ this.name = name; }
	public void setPassword(String password){ this.password = password; }
	public void setBirthday(Date birthday){ this.birthday = birthday; }

	//  getメソッド
	//  Java beansのgetメソッドはgetの後ろに続く文字列が必ず大文字であること
	public int getID(){ return this.id; }
	public String getMailAddress() { return this.mail_address; }
	public String getName(){ return this.name; }
	public String getPassword(){ return this.password; }
	public Date getBirthday(){ return this.birthday; }



}