//--------------------------------
//	ShowReview.java
//--------------------------------
//　自分が格納されているフォルダ名
package servlet.review;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Review;
import beans.Tapioca;
import control.ReviewManager;
import control.TapiocaManager;
//アノテーションの記述
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/ShowReview")

	//HttpServletを継承することで、このクラスはServletとして、働くことができる
	public class ShowReview extends HttpServlet{

	/**
	*
	*/
		private static final long serialVersionUID = 1L;

	//  doPostメソッドから呼び出される(リダイレクトされる)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        //  requestオブジェクトから店舗IDの取り出し
        int id = Integer.parseInt(request.getParameter("id"));
        //  コンソールに確認するために出力
        System.out.println("取得した文字列は"+id+"です！");

        //  TapiocaManagerオブジェクト生成
        TapiocaManager tm = new TapiocaManager();
        //  店舗IDからお店情報を取得
        Tapioca t = tm.searchFromID(id);

        //  DBから取得したお店情報を確認のため出力
        System.out.println("servlet:取得したお店のIDは"+t.getID()+"です！");

        //  ReviewManagerオブジェクト生成
        ReviewManager rm = new ReviewManager();
        //  Tapioca型のList用意
        List<Review> rList = new ArrayList<>();
        //  店舗IDからレビュー一覧を取得
        rList = rm.findAll(t.getID());

        //  requestオブジェクトに情報を格納
        request.setAttribute("rl", rList);
        request.setAttribute("tapioca", t);
        //  店舗リスト画面を表示する
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/review/showReview.jsp");
        dispatcher.forward(request, response);
	}

	//  requestオブジェクトには、フォームで入力された文字列などが格納されている。
	//  responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

//		// requestオブジェクトの文字エンコーディングの設定
//		request.setCharacterEncoding("UTF-8");
//
//		// requestオブジェクトから登録情報の取り出し
//		int id = Integer.parseInt(request.getParameter("id"));
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		Date birthday = Date.valueOf(request.getParameter("birthday"));
//
//		//コンソールに確認するために出力
//		System.out.println("取得した文字列は"+id+"です！");
//		System.out.println("取得した文字列は"+name+"です！");
//		System.out.println("取得した文字列は"+password+"です！");
//		System.out.println("取得した文字列は"+request.getParameter("birthday")+"です！");
//
//
//		// studentオブジェクトに情報を格納
//		User u = new User(id, name, password, birthday);
//
//		//  StudentManagerオブジェクトの生成
//		UserManager manager = new UserManager();
//
//		//  登録
//		manager.registUser(u);
//
//		//  成功画面を表示する
//		//System.out.println("OK牧場");
//		response.sendRedirect("/ReviewSystem/");
		}
}
