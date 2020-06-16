//--------------------------------
//	RegistTweet.java
//--------------------------------
//　自分が格納されているフォルダ名
package servlet.tweet;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Tweet;
import beans.User;
import control.TweetManager;
//アノテーションの記述
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/RegistTweet")

	//HttpServletを継承することで、このクラスはServletとして、働くことができる
	public class RegistTweet extends HttpServlet{

	/**
	*
	*/
		private static final long serialVersionUID = 1L;

	//  doPostメソッドから呼び出される(リダイレクトされる)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
		 //  forwardはrequestオブジェクトを引数として、次のページに渡すことができる
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tweet/registTweet.jsp");
        dispatcher.forward(request, response);
	}

	//  requestオブジェクトには、フォームで入力された文字列などが格納されている。
	//  responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");

		// requestオブジェクトから登録情報の取り出し
		String tweet = request.getParameter("tweet");
		// currentDate の取得
		java.util.Date now = new java.util.Date();
		java.sql.Date current_date = new java.sql.Date(now.getTime());
		// HttpSession インスタンス取得
		HttpSession session = request.getSession();
		// セッションスコープからインスタンスを取得
		User current_user = (User) session.getAttribute("lu");

		// studentオブジェクトに情報を格納
		Tweet tw = new Tweet(tweet, current_date, current_date, current_user);

		//  StudentManagerオブジェクトの生成
		TweetManager manager = new TweetManager();

		//  登録
		manager.registTweet(tw);

		//  成功画面を表示する
		//System.out.println("OK牧場");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/mypage.jsp");
        dispatcher.forward(request, response);
	}
}
