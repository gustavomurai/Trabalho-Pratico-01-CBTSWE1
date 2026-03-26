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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Emp e=EmpDao.getEmployeeById(id);
		
		// Início do HTML com Bootstrap
		out.println("<html><head><title>Atualizar Funcionário</title>");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.min.css' rel='stylesheet'>");
		out.println("<style>");
		out.println("body { background-color: #f4f7f6; padding-top: 50px; padding-bottom: 70px; }");
		out.println(".card { border-radius: 10px; box-shadow: 0 4px 15px rgba(0,0,0,0.1); }");
		out.println(".card-header { background-color: #f39c12; color: white; font-weight: bold; }");
		out.println(".footer { background-color: #343a40; color: white; text-align: center; padding: 20px 0; position: fixed; bottom: 0; width: 100%; }");
		out.println("</style></head><body>");
		
		out.println("<div class='container'>");
		out.println("<div class='row justify-content-center'>");
		out.println("<div class='col-md-8'>");
		out.println("<a href='ViewServlet' class='btn btn-secondary mb-3'>Voltar para a Lista</a>");
		
		out.println("<div class='card'>");
		out.println("<div class='card-header'><h3>Atualizar Funcionário</h3></div>");
		out.println("<div class='card-body'>");
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<input type='hidden' name='id' value='"+e.getId()+"'/>");
		
		out.println("<div class='mb-3'>");
		out.println("<label for='name' class='form-label'>Nome:</label>");
		out.println("<input type='text' class='form-control' id='name' name='name' value='"+e.getName()+"' required>");
		out.println("</div>");
		
		out.println("<div class='mb-3'>");
		out.println("<label for='password' class='form-label'>Senha:</label>");
		out.println("<input type='password' class='form-control' id='password' name='password' value='"+e.getPassword()+"' required>");
		out.println("</div>");
		
		out.println("<div class='mb-3'>");
		out.println("<label for='email' class='form-label'>Email:</label>");
		out.println("<input type='email' class='form-control' id='email' name='email' value='"+e.getEmail()+"' required>");
		out.println("</div>");
		
		out.println("<div class='mb-3'>");
		out.println("<label for='country' class='form-label'>País:</label>");
		out.println("<select class='form-select' id='country' name='country'>");
		// Lógica simples para selecionar o país atual
		String c = e.getCountry();
		out.print("<option "+(c.equals("Brasil")?"selected":"")+">Brasil</option>");
		out.print("<option "+(c.equals("EUA")?"selected":"")+">EUA</option>");
		out.print("<option "+(c.equals("Reino Unido")?"selected":"")+">Reino Unido</option>");
		out.print("<option "+(c.equals("Outro")?"selected":"")+">Outro</option>");
		out.print("</select>");
		out.println("</div>");
		
		out.print("<button type='submit' class='btn btn-warning w-100'>Salvar Alteração</button>");
		out.print("</form>");
		
		out.println("</div>"); // Fecha card-body
		out.println("</div>"); // Fecha card
		out.println("</div>"); // Fecha col
		out.println("</div>"); // Fecha row
		out.println("</div>"); // Fecha container
		
		// Rodapé Fixo
		out.println("<div class='footer'>");
		out.println("<div class='container'>");
		out.println("projeto realizado por Gustavo Murai e Igor Murai para a materia de Sistemas Web 1");
		out.println("</div></div>");
		
		out.println("</body></html>");
		out.close();
	}
}