//--------------------------------
//	RegistUserInfo.java
//--------------------------------
//　自分が格納されているフォルダ名
package servlet.user;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import control.UserManager;
//アノテーションの記述
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/RegistUser")

	//HttpServletを継承することで、このクラスはServletとして、働くことができる
	public class RegistUserInfo extends HttpServlet{

	/**
	*
	*/
		private static final long serialVersionUID = 1L;

	//  doPostメソッドから呼び出される(リダイレクトされる)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
		 //  forwardはrequestオブジェクトを引数として、次のページに渡すことができる
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/registUser.jsp");
        dispatcher.forward(request, response);
	}

	//  requestオブジェクトには、フォームで入力された文字列などが格納されている。
	//  responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");

		// requestオブジェクトから登録情報の取り出し
//		int id = Integer.parseInt(request.getParameter("id"));
		String mail_address = request.getParameter("mail_address");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Date birthday = Date.valueOf(request.getParameter("birthday"));

		//コンソールに確認するために出力
		System.out.println("取得した文字列は"+mail_address+"です！");
		System.out.println("取得した文字列は"+name+"です！");
		System.out.println("取得した文字列は"+password+"です！");
		System.out.println("取得した文字列は"+request.getParameter("birthday")+"です！");


		// studentオブジェクトに情報を格納
		User u = new User(mail_address, name, password, birthday);

		//  StudentManagerオブジェクトの生成
		UserManager manager = new UserManager();

		//  登録
		manager.registUser(u);

		//  成功画面を表示する
		//System.out.println("OK牧場");
		response.sendRedirect("/ReviewSystem/");
		}
}
