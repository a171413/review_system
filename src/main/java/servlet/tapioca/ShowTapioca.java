//--------------------------------
//	RegistTapiocaInfo.java
//--------------------------------
//　自分が格納されているフォルダ名
package servlet.tapioca;

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

import beans.Tapioca;
import control.TapiocaManager;
//アノテーションの記述
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/ShowTapioca")

	//HttpServletを継承することで、このクラスはServletとして、働くことができる
	public class ShowTapioca extends HttpServlet{

	/**
	*
	*/
		private static final long serialVersionUID = 1L;

	//  doPostメソッドから呼び出される(リダイレクトされる)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        //  Tapioca型のList用意
        List<Tapioca> tList = new ArrayList<>();

        //  TapiocaManagerオブジェクトの生成
        TapiocaManager manager = new TapiocaManager();

        //  一覧検索実行
        tList = manager.findAll();

        //  requestオブジェクトに情報を格納
        request.setAttribute("tl", tList);
        //  店舗リスト画面を表示する
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tapioca/showTapioca.jsp");
        dispatcher.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");

	}

}
