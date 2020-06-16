//--------------------------------
//	RegistTapiocaInfo.java
//--------------------------------
//　自分が格納されているフォルダ名
package servlet.tapioca;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tapioca;
import control.TapiocaManager;
//アノテーションの記述
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/RegistTapiocaInfo")

	//HttpServletを継承することで、このクラスはServletとして、働くことができる
	public class RegistTapiocaInfo extends HttpServlet{

	/**
	*
	*/
		private static final long serialVersionUID = 1L;

	//  doPostメソッドから呼び出される(リダイレクトされる)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
		 //  forwardはrequestオブジェクトを引数として、次のページに渡すことができる
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tapioca/registTapioca.jsp");
        dispatcher.forward(request, response);
	}

	//  requestオブジェクトには、フォームで入力された文字列などが格納されている。
	//  responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");

		// requestオブジェクトから登録情報の取り出し
//		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		//コンソールに確認するために出力
//		System.out.println("取得した文字列は"+id+"です！");
		System.out.println("取得した文字列は"+name+"です！");
		System.out.println("取得した文字列は"+address+"です！");

		// studentオブジェクトに情報を格納
		Tapioca t = new Tapioca(name, address);

		//  TapiocaManagerオブジェクトの生成
		TapiocaManager manager = new TapiocaManager();

		//  登録
		manager.registTapioca(t);

		//  マイページを表示する
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/user/mypage.jsp");
		dispatcher.forward(request, response);
		}
}
