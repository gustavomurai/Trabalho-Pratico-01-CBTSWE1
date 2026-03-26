/*
 * Disciplina: CBTSWE1 - ADS 571 
 * Professor: Wellington Tuler Moraes 
 * Trabalho Prático 01 - CRUD 
 * Dupla: Gustavo Murai e Igor Murai 
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		// 1. Pega o ID (escondido) e os novos dados digitados
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		// 2. Monta o objeto Emp com os novos valores
		Emp e=new Emp();
		e.setId(id);
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);
		
		// 3. Manda o EmpDao fazer o UPDATE no MySQL
		int status=EmpDao.update(e);
		
		if(status>0){
			// Se deu certo, volta para a lista para você ver a mudança
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Desculpe! Erro ao atualizar os dados.");
		}
		out.close();
	}
}