//　自分が格納されているフォルダ名
package control;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.util.List;

import beans.Tapioca;
import dao.TapiocaDAO;

public class TapiocaManager {

	//  属性
	private Connection connection = null;

	//  引数を持たないコンストラクタ
	public TapiocaManager(){
	}

	//  追加
	//  引数はTapiocaオブジェクト
	public void registTapioca(Tapioca tapioca){

		//  TapiocaDAOオブジェクト生成
		TapiocaDAO tDAO = new TapiocaDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = tDAO.createConnection();

		//  TapiocaオブジェクトをDataBaseに登録する
		tDAO.registTapioca(tapioca, this.connection);

		//  DataBaseとの接続を切断する
		tDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

	}

	//  検索
	public Tapioca searchTapioca(Tapioca tapioca){

		//  TapiocaDAOオブジェクト生成
		TapiocaDAO tDAO = new TapiocaDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = tDAO.createConnection();

		//  検索する
		tapioca = tDAO.searchTapioca(tapioca, this.connection);

		//  DataBaseとの接続を切断する
		tDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

		return tapioca;
	}

	//  IDから店舗を検索
	public Tapioca searchFromID(int id) {

		//  TapiocaDAOオブジェクト生成
		TapiocaDAO tDAO = new TapiocaDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = tDAO.createConnection();

		//  検索する
		Tapioca t = tDAO.searchFromID(id, this.connection);

		//  DataBaseとの接続を切断する
		tDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

		return t;
	}

	//  一覧取得
	public List<Tapioca> findAll() {

		//  TapiocaDAOオブジェクト生成
		TapiocaDAO tDAO = new TapiocaDAO();

		//  DataBaseへ接続し，コネクションオブジェクトを生成する
		this.connection = tDAO.createConnection();

		//  一覧取得を実行する
		List<Tapioca> tList = tDAO.findAll(this.connection);

		//  DataBaseとの接続を切断する
		tDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

		return tList;
	}

}
