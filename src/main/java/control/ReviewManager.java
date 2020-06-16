//　自分が格納されているフォルダ名
package control;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.util.List;

import beans.Review;
import dao.ReviewDAO;

public class ReviewManager {

	//  属性
	private Connection connection = null;

	//  引数を持たないコンストラクタ
	public ReviewManager(){
	}

	//  追加
	//  引数はReviewオブジェクト
	public void registReview(Review review){

		//  ReviewDAOオブジェクト生成
		ReviewDAO reviewDAO = new ReviewDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = reviewDAO.createConnection();

		//  ReviewオブジェクトをDataBaseに登録する
		reviewDAO.registReview(review, this.connection);

		//  DataBaseとの接続を切断する
		reviewDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

	}

	//  検索
	public Review searchReview(String comment){

		//  ReviewDAOオブジェクト生成
		ReviewDAO reviewDAO = new ReviewDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = reviewDAO.createConnection();

		//  検索する
		Review review = new Review();
		review = reviewDAO.searchReview(comment, this.connection);

		//  DataBaseとの接続を切断する
		reviewDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

		return review;
	}

	//  店舗IDからレビュー一覧を取得
	public List<Review> findAll(int tapi_id) {

		//  ReviewDAOオブジェクト生成
		ReviewDAO rDAO = new ReviewDAO();

		//  DataBaseへ接続し，コネクションオブジェクトを生成する
		this.connection = rDAO.createConnection();

		//  一覧取得を実行する
		System.out.println("manager:取得したidは"+tapi_id+"です！");
		List<Review> rList = rDAO.findAll(tapi_id,this.connection);

		//  DataBaseとの接続を切断する
		rDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

		return rList;
	}

}
