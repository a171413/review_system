//--------------------------------
//	LogSession.java
//--------------------------------
//　自分が格納されているフォルダ名
package servlet.user;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import control.UserManager;
//アノテーションの記述
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/Login")

	//HttpServletを継承することで、このクラスはServletとして、働くことができる
	public class LogSession extends HttpServlet{

	/**
	*
	*/
		private static final long serialVersionUID = 1L;

	//  doPostメソッドから呼び出される(リダイレクトされる)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        //  セッションスコープを取得
        HttpSession session = request.getSession();
        if(session.getAttribute("lu")!=null) {

        	//  マイページを表示する
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/mypage.jsp");
			dispatcher.forward(request, response);

        }else {

            //  ログイン画面に戻る
    		response.sendRedirect("/ReviewSystem/");

        }
	}

	//  requestオブジェクトには、フォームで入力された文字列などが格納されている。
	//  responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");

		// requestオブジェクトから登録情報の取り出し
		String mail_address = request.getParameter("mail_address");
		String password = request.getParameter("password");

		//コンソールに確認するために出力
//		System.out.println("取得した文字列は"+mail_address+"です！");
//		System.out.println("取得した文字列は"+password+"です！");


		// userオブジェクトに情報を格納
		User user = new User(mail_address, password);

		//  UserManagerオブジェクトの生成
		UserManager manager = new UserManager();

		//  正しいUser 情報の取得
		User lu = manager.signIn(user);

		if(lu!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("lu", lu);

			//  マイページを表示する
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/mypage.jsp");
			dispatcher.forward(request, response);
		} else {
			//  ログイン画面に戻る
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/logfailed.jsp");
			dispatcher.forward(request, response);
		}

	}
}
