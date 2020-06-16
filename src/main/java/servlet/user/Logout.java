//--------------------------------
//	LogSession.java
//--------------------------------
//　自分が格納されているフォルダ名
package servlet.user;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//アノテーションの記述
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/Logout")

	//HttpServletを継承することで、このクラスはServletとして、働くことができる
	public class Logout extends HttpServlet{

	/**
	*
	*/
		private static final long serialVersionUID = 1L;

	//  doPostメソッドから呼び出される(リダイレクトされる)
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        //  セッションスコープを破棄
        HttpSession session = request.getSession();
        session.invalidate();

        //  ログイン画面に戻る
		response.sendRedirect("/ReviewSystem/");

	}

	//  requestオブジェクトには、フォームで入力された文字列などが格納されている。
	//  responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");
	}
}
