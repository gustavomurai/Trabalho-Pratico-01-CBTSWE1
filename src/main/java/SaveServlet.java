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

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		Emp e=new Emp();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);
		
		// Início do HTML com o estilo padrão do projeto
		out.println("<html><head>");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.min.css' rel='stylesheet'>");
		out.println("<style>");
		out.println("body { background-color: #f4f7f6; padding-top: 100px; padding-bottom: 70px; }");
		out.println(".footer { background-color: #343a40; color: white; text-align: center; padding: 20px 0; position: fixed; bottom: 0; width: 100%; }");
		out.println(".message-box { background: white; padding: 40px; border-radius: 10px; box-shadow: 0 4px 15px rgba(0,0,0,0.1); text-align: center; }");
		out.println("</style></head><body>");
		out.println("<div class='container'><div class='row justify-content-center'><div class='col-md-6 message-box'>");

		if (EmpDao.emailExists(email)) {
			// TELA DE ERRO AJUSTADA
			out.print("<h2 class='text-danger'>Ops!</h2>");
			out.print("<p class='lead'>O e-mail <strong>" + email + "</strong> já está cadastrado em nosso sistema.</p>");
			out.print("<a href='index.html' class='btn btn-warning mt-3'>Voltar para o Formulário</a>");
		} else {
			int status = EmpDao.save(e);
			if (status > 0) {
				// TELA DE SUCESSO AJUSTADA
				out.print("<h2 class='text-success'>Sucesso!</h2>");
				out.print("<p class='lead'>Funcionário cadastrado corretamente.</p>");
				out.print("<a href='ViewServlet' class='btn btn-primary mt-3'>Ver Lista de Funcionários</a>");
			} else {
				out.print("<h2 class='text-danger'>Erro!</h2>");
				out.print("<p>Houve um problema técnico ao salvar os dados.</p>");
				out.print("<a href='index.html' class='btn btn-secondary mt-3'>Tentar Novamente</a>");
			}
		}

		out.println("</div></div></div>"); // Fecha container/row/col

		// Rodapé padrão solicitado
		out.println("<div class='footer'><div class='container'>");
		out.println("projeto realizado por Gustavo Murai e Igor Murai para a materia de Sistemas Web 1");
		out.println("</div></div>");
		
		out.println("</body></html>");
		out.close();
	}
}