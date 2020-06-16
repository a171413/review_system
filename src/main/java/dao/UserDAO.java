
//　自分が格納されているフォルダ名
package dao;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.User;

public class UserDAO{

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
	//  引数はUserオブジェクトと、Connectionオブジェクト
	public void registUser(User user, Connection connection){

		try{

			//  SQLコマンド
			String sql = "insert into user(mail_address, name, password, birthday) values(?, ?, ?, ?)";

			//  SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);

			//  SQLコマンドのクエッションマークに値を、1番目から代入する
			stmt.setString(1, user.getMailAddress());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getPassword());
			stmt.setDate(4, user.getBirthday());

			stmt.executeUpdate();

		}catch(SQLException e){

//			エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();

		} finally {
		}
	}

	//  検索する
	//  引数はUserオブジェクトと、Connectionオブジェクト
	public User searchUser(User user, Connection connection){

		try{

			//  SQLコマンド
			String sql = "select * from user where mail_address = '" + user.getMailAddress() + "' and user_birthday = '" + user.getBirthday() + "'";

			//  SQLのコマンドを実行する
			//  実行結果はrsに格納される
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			rs.first();

			//  rsからそれぞれの情報を取り出し、Userオブジェクトに設定する
			user.setID(rs.getInt("id"));
			user.setPassword(rs.getString("name"));
			user.setPassword(rs.getString("password"));

			//  終了処理
			stmt.close();
			rs.close();

			//  Userオブジェクトを返す
			return user;

			}catch(SQLException e){

				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();
				return null;

			}finally{
			}
	}

	//  IDから検索する
	//  引数はUserオブジェクトと、Connectionオブジェクト
	public User searchUserFromMailAddress(User user, Connection connection){

		try{

			//  SQLコマンド
			String sql = "select * from user where mail_address = '" + user.getMailAddress() + "'";

			//  SQLのコマンドを実行する
			//  実行結果はrsに格納される
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			rs.first();

			User lu = new User(
					rs.getInt("id"),
					rs.getString("mail_address"),
					rs.getString("name"),
					rs.getString("password"),
					rs.getDate("birthday")
					);

			//  終了処理
			stmt.close();
			rs.close();

			//  Userオブジェクトを返す
			return lu;

			}catch(SQLException e){

				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();
				return null;

			}finally{
			}
	}

}
