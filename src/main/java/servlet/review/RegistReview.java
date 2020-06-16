//--------------------------------
//	RegistReview.java
//--------------------------------
//　自分が格納されているフォルダ名
package servlet.review;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Review;
import beans.User;
import control.ReviewManager;
//アノテーションの記述
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/RegistReview")

	//HttpServletを継承することで、このクラスはServletとして、働くことができる
	public class RegistReview extends HttpServlet{

	/**
	*
	*/
		private static final long serialVersionUID = 1L;

	//  doPostメソッドから呼び出される(リダイレクトされる)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        //  requestオブジェクトからTapiocaIDの取り出し
        int tapi_id = Integer.parseInt(request.getParameter("id"));

        //  requestオブジェクトに情報を格納
        request.setAttribute("tapi_id", tapi_id);
		 //  forwardはrequestオブジェクトを引数として、次のページに渡すことができる
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/review/registReview.jsp");
        dispatcher.forward(request, response);
	}

	//  requestオブジェクトには、フォームで入力された文字列などが格納されている。
	//  responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");

		//  requestスコープからインスタンスを取得
		int point = Integer.parseInt(request.getParameter("point"));
		String comment = request.getParameter("comment");
		int tapi_id = Integer.parseInt(request.getParameter("id"));
		//  currentDate の取得
		java.util.Date now = new java.util.Date();
		java.sql.Date current_date = new java.sql.Date(now.getTime());

		//  HttpSession インスタンス取得
		HttpSession session = request.getSession();
		//  セッションスコープからインスタンスを取得
		User current_user = (User) session.getAttribute("lu");

//		//  TapiocaManagerオブジェクトを生成
//		TapiocaManager tmanager = new TapiocaManager();
//
//		//  TapiocaIDからTapiocaインスタンスを取得
//		Tapioca current_tapi = tmanager.searchFromID(tapi_id);

		//コンソールに確認するために出力
		System.out.println("取得した文字列は"+point+"です！");
		System.out.println("取得した文字列は"+comment+"です！");
		System.out.println("投稿した日付は"+current_date+"です！");
		System.out.println("取得した文字列は"+current_user+"です！");
		System.out.println("取得した文字列は"+tapi_id+"です！");


		// reviewオブジェクトに情報を格納
		Review r = new Review(point, comment, current_date, 1, current_date, current_user, tapi_id);

		//  ReviewManagerオブジェクトの生成
		ReviewManager manager = new ReviewManager();

		//  Review登録
		manager.registReview(r);

//		request.setAttribute("id", tapi_id);
		response.sendRedirect("/ReviewSystem/ShowReview?id="+tapi_id);
	}

}
