//  自分が格納されているフォルダ名
package beans;

public class Tapioca {

	//  属性
	private int id;			//　店舗ID
	private String name = null;			//　店舗名
	private String address = null;		//	住所

	//　初期値を引数に持ったコンストラクタ
	public Tapioca(int id, String name, String address){

		this.id = id;
		this.name = name;
		this.address = address;

	}

	//  IDを持たないコンストラクタ
	public Tapioca(String name, String address){

		this.name = name;
		this.address = address;

	}


	//  初期値を引数に持たないコンストラクタ
	//  Java beansは初期値を持たないコンストラクタが必ず必要
	public Tapioca(){}

	//  setメソッド
	//  Java beansのsetメソッドはsetの後ろに続く文字列が必ず大文字であること
	public void setID(int id){ this.id = id; }
	public void setName(String name){ this.name = name; }
	public void setAddress(String address){ this.address = address; }

	//  getメソッド
	//  Java beansのgetメソッドはgetの後ろに続く文字列が必ず大文字であること
	public int getID(){ return this.id; }
	public String getName(){ return this.name; }
	public String getAddress(){ return this.address; }


}