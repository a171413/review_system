
//　自分が格納されているフォルダ名
package dao;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Tapioca;

public class TapiocaDAO{

	//  属性

	//  データベースの接続先アドレスを静的変数として記述
	private final static String DRIVER_URL =
		"jdbc:mysql://localhost:3306/tapi_review?useUnicode=true&characterEncoding=Windows-31J";

	//  データベース接続ドライバの名前を静的変数として記述
	private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";

	//  データベースのユーザー名　（デフォルトではroot）
	private final static String USER_NAME = "root";

	//  データベースのユーザーのパスワード　(デフォルトでは設定なし)
	private final static String PASSWORD = "root";

	//  データベースとの接続を行う
	//  データベースの接続情報を持ったConnectionオブジェクトを返す
	public Connection createConnection(){
		try{
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
			return con;
		} catch(ClassNotFoundException e){
			System.out.println("Can't Find JDBC Driver.\n");

		} catch(SQLException e){
			System.out.println("Connect Error.\n");
		}
		return null;
	}

	//  Connectionオブジェクトを使って、データベースとの接続を切断する
	//  引数Connectionオブジェクト
	public void closeConnection(Connection con){

		try{
			con.close();
		}catch(Exception ex){}
	}

	//  情報をデータベースに登録する
	//  引数はTapiocaオブジェクトと、Connectionオブジェクト
	public void registTapioca(Tapioca tapioca, Connection connection){

		try{

			//  SQLコマンド
			String sql = "insert into tapioca(name, address) values(?, ?)";

			//  SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);

			//  SQLコマンドのクエッションマークに値を、1番目から代入する
//			stmt.setInt(1, tapioca.getTapiocaID());
			stmt.setString(1, tapioca.getName());
			stmt.setString(2, tapioca.getAddress());

			stmt.executeUpdate();

		}catch(SQLException e){

//			エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();

		} finally {
		}
	}

	//  検索する
	//  引数はTapiocaオブジェクトと、Connectionオブジェクト
	public Tapioca searchTapioca(Tapioca tapioca, Connection connection){

		try{

			//  SQLコマンド
			String sql = "select * from tapioca where id = ?";


			//  SQLのコマンドを実行する
			PreparedStatement pStmt = connection.prepareStatement(sql);

			//  PreparedStatementに値を格納
			pStmt.setInt(1, tapioca.getID());

			//  実行結果はrsに格納される
			ResultSet rs = pStmt.executeQuery();

			rs.first();

			//  rsからそれぞれの情報を取り出し、Tapiocaオブジェクトに設定する
			tapioca.setName(rs.getString("name"));
			tapioca.setAddress(rs.getString("address"));

			//  終了処理
			pStmt.close();
			rs.close();

			//  Tapiocaオブジェクトを返す
			return tapioca;

			}catch(SQLException e){

				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();
				return null;

			}finally{
			}
	}

	//  IDから店舗を検索
	public Tapioca searchFromID(int id, Connection connection){

		try{

			//  SQLコマンド
			String sql = "select * from tapioca where id = ?";


			//  SQLのコマンドを実行する
			PreparedStatement pStmt = connection.prepareStatement(sql);

			//  PreparedStatementに値を格納
			pStmt.setInt(1, id);

			System.out.println(pStmt.toString());

			//  実行結果はrsに格納される
			ResultSet rs = pStmt.executeQuery();

			rs.first();

			//  rsからそれぞれの情報を取り出し、Tapiocaオブジェクトに設定する
			Tapioca t = new Tapioca();
			t.setID(rs.getInt("id"));
			t.setName(rs.getString("name"));
			t.setAddress(rs.getString("address"));

			//  終了処理
			pStmt.close();
			rs.close();

			//  Tapiocaオブジェクトを返す
			return t;

			}catch(SQLException e){

				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();
				return null;

			}finally{
			}
	}

	//  データベースから一覧を取得
	public List<Tapioca> findAll(Connection connection){
		List<Tapioca> tapiocaList = new ArrayList<>();

		//  DB接続
		try {
			String sql = "select * from tapioca order by id asc";

			//  SQLのコマンドを実行する
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Tapioca t = new Tapioca();
				t.setID(rs.getInt("id"));
				t.setName(rs.getString("name"));
				t.setAddress(rs.getString("address"));
				tapiocaList.add(t);
			}
			stmt.close();
			rs.close();
			return tapiocaList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
