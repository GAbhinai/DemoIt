package ser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet({"/Ser","/res","/login"})
public class Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("yygrhdoivkerjdvbj");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String path = request.getServletPath();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csm","root","root");
			if(path.equals("/res")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String query = "insert into s values(?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, name);
			
			pst.execute();
			
			out.println("Row inserted in s");
			
			pst.close();
			
			}
		else if (path.equals("/login")) {
				
				int id = Integer.parseInt(request.getParameter("ids"));
				String name = request.getParameter("names");
				String query = "insert into s1 values(?,?)";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1, id);
				pst.setString(2, name);
				
				pst.execute();
				
				out.println("Row inserted in s1");
				
				pst.close();
				
			}
		else {
			out.println("Wrong");
		}
			con.close();
		}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
	}

