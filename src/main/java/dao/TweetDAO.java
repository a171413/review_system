
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

import beans.Tweet;
import beans.User;

public class TweetDAO{

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
	//  引数はTweetオブジェクトと、Connectionオブジェクト
	public void registTweet(Tweet tweet, Connection connection){

		try{


			//  SQLコマンド
			String sql = "insert into tweets(tweet, created_at, updated_at, user_id) values(?, ?, ?, ?)";

			//  SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);

			//  SQLコマンドのクエッションマークに値を、1番目から代入する
//			stmt.setInt(1, tweet.getID());
			stmt.setString(1, tweet.getTweet());
			stmt.setDate(2, tweet.getCreatedAt());
			stmt.setDate(3, tweet.getUpdatedAt());
			stmt.setInt(4, tweet.getUser().getID());

			stmt.executeUpdate();

		}catch(SQLException e){

			//	エラーが発生したackTrace();
			e.printStackTrace();

		} finally {
		}
	}

	//  検索する
	//  引数はTweetオブジェクトと、Connectionオブジェクト
	public Tweet searchTweet(String word, Connection connection){

		try{
			//  SQLコマンド
			String sql = "select * from tweets where tweet like '%?%'";

			//  SQLのコマンドを実行する
			//  実行結果はrsに格納される
			PreparedStatement pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, word);
			ResultSet rs = pStmt.executeQuery(sql);

			rs.first();

			//  rsからそれぞれの情報を取り出し、Tweetオブジェクトに設定する
			Tweet tweet = new Tweet();
			tweet.setID(rs.getInt("id"));
			tweet.setTweet(rs.getString("tweet"));
			tweet.setCreatedAt(rs.getDate("created_at"));
			tweet.setUpdatedAt(rs.getDate("updated_at"));


			//  終了処理
			pStmt.close();
			rs.close();

			//  Tweetオブジェクトを返す
			return tweet;

			}catch(SQLException e){

				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();
				return null;

			}finally{
			}
	}

	//  TapiocaIDをもとにデータベースからレビュー一覧取得
	public List<Tweet> findAll(int id[], Connection connection){

		try {
//			System.out.println("dao:取得した口コミのお店のIDは"+id+"です！");
			List<Tweet> twl = new ArrayList<>();	//  twl=tweetList
			for(int i=0 ; i<id.length ; i++) {
				//  SQLコマンド
				String sql = "select * from tweets where user_id = ?";
				//  SQLコマンド実行
				PreparedStatement pStmt = connection.prepareStatement(sql);
				//  PreparedStatementに値を格納
				pStmt.setInt(1, id[i]);
				//  実行結果はrs
				ResultSet rs = pStmt.executeQuery();

				while (rs.next()) {
					Tweet tw = new Tweet();
					tw.setID(rs.getInt("tweet.id"));
					tw.setTweet(rs.getString("tweet.tweet"));
					tw.setCreatedAt(rs.getDate("tweet.created_at"));
					tw.setUpdatedAt(rs.getDate("tweet.updated_at"));
					User u = new User();
					u.setID(rs.getInt("user.id"));
					u.setName(rs.getString("user.name"));
					u.setBirthday(rs.getDate("user.birthday"));
					tw.setUser(u);
					twl.add(tw);
				}
				pStmt.close();
				rs.close();
			}
			return twl;

		}catch(SQLException e){

				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();
				return null;
			}

		}

}


