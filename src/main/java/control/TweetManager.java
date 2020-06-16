//　自分が格納されているフォルダ名
package control;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.util.List;

import beans.Tweet;
import dao.TweetDAO;

public class TweetManager {

	//  属性
	private Connection connection = null;

	//  引数を持たないコンストラクタ
	public TweetManager(){
	}

	//  追加
	//  引数はTweetオブジェクト
	public void registTweet(Tweet tweet){

		//  TweetDAOオブジェクト生成
		TweetDAO tweetDAO = new TweetDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = tweetDAO.createConnection();

		//  TweetオブジェクトをDataBaseに登録する
		tweetDAO.registTweet(tweet, this.connection);

		//  DataBaseとの接続を切断する
		tweetDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

	}

	//  検索
	public Tweet searchTweet(String comment){

		//  TweetDAOオブジェクト生成
		TweetDAO tweetDAO = new TweetDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = tweetDAO.createConnection();

		//  検索する
		Tweet tweet = new Tweet();
		tweet = tweetDAO.searchTweet(comment, this.connection);

		//  DataBaseとの接続を切断する
		tweetDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

		return tweet;
	}

	//  店舗IDからレビュー一覧を取得
	public List<Tweet> findAll(int id[]) {

		//  TweetDAOオブジェクト生成
		TweetDAO rDAO = new TweetDAO();

		//  DataBaseへ接続し，コネクションオブジェクトを生成する
		this.connection = rDAO.createConnection();

		//  一覧取得を実行する
//		System.out.println("manager:取得したidは"+tapi_id+"です！");
		List<Tweet> rList = rDAO.findAll(id,this.connection);

		//  DataBaseとの接続を切断する
		rDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

		return rList;
	}

}
