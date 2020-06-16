
//　自分が格納されているフォルダ名
package dao;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Review;
import beans.User;

public class ReviewDAO{

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
	//  引数はReviewオブジェクトと、Connectionオブジェクト
	public void registReview(Review review, Connection connection){

		try{


			//  SQLコマンド
			String sql = "insert into review(point, comment, created_at,references_point, updated_at, user_id, tapioca_id) values(?, ?, ?, ?, ?, ?, ?)";

			//  SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);

			//  SQLコマンドのクエッションマークに値を、1番目から代入する
//			stmt.setInt(1, review.getID());
			stmt.setInt(1, review.getPoint());
			stmt.setString(2, review.getComment());
			stmt.setDate(3, review.getCreatedAt());
			stmt.setInt(4, review.getReferencesPoint());
			stmt.setDate(5, review.getUpdatedAt());
			stmt.setInt(6, review.getUser().getID());
			stmt.setInt(7, review.getTapiocaID());


			stmt.executeUpdate();

		}catch(SQLException e){

			//	エラーが発生したackTrace();
			e.printStackTrace();

		} finally {
		}
	}

	//  検索する
	//  引数はReviewオブジェクトと、Connectionオブジェクト
	public Review searchReview(String comment, Connection connection){

		try{

			//  SQLコマンド
			String sql = "select * from review where comment　like '%?%'";

			//  SQLのコマンドを実行する
			//  実行結果はrsに格納される
			PreparedStatement pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, comment);
			ResultSet rs = pStmt.executeQuery(sql);

			rs.first();

			//  rsからそれぞれの情報を取り出し、Reviewオブジェクトに設定する
			Review review = new Review();
			review.setID(rs.getInt("id"));
			review.setPoint(rs.getInt("point"));
			review.setComment(rs.getString("comment"));
			review.setCreatedAt(rs.getDate("created_at"));
			review.setReferencesPoint(rs.getInt("references_point"));
			review.setUpdatedAt(rs.getDate("updated_at"));

			//  終了処理
			pStmt.close();
			rs.close();

			//  Reviewオブジェクトを返す
			return review;

			}catch(SQLException e){

				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();
				return null;

			}finally{
			}
	}

	//  TapiocaIDをもとにデータベースからレビュー一覧取得
	public List<Review> findAll(int id, Connection connection){

		try {
			System.out.println("dao:取得した口コミのお店のIDは"+id+"です！");
			List<Review> rl = new ArrayList<>();	//  rl=reviewList
			//  SQLコマンド
			String sql = "select review.id, review.point, review.comment,review.created_at, user.id, user.name, user.birthday from review inner join user on review.user_id=user.id where tapioca_id = ?";

			//  SQLコマンド実行
			PreparedStatement pStmt = connection.prepareStatement(sql);

			//  PreparedStatementに値を格納
			pStmt.setInt(1, id);
			//  実行結果はrs
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Review r = new Review();
				r.setID(rs.getInt("review.id"));
				r.setPoint(rs.getInt("review.point"));
				r.setComment(rs.getString("review.comment"));
				r.setCreatedAt(rs.getDate("review.created_at"));
				User u = new User();
				u.setID(rs.getInt("user.id"));
				u.setName(rs.getString("user.name"));
				u.setBirthday(rs.getDate("user.birthday"));
//				r.getUser().setID(rs.getString("id"));
//				r.getUser().setName(rs.getString("name"));
//				r.getUser().setBirthday(rs.getDate("birthday"));
				r.setUser(u);
				r.setTapiocaID(id);
				rl.add(r);
			}
			pStmt.close();
			rs.close();
			return rl;

		}catch(SQLException e){

				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();
				return null;
			}

		}

}


