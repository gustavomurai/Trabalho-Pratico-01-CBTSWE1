/*
 * Disciplina: CBTSWE1 - ADS 571 
 * Professor: Wellington Tuler Moraes 
 * Trabalho Prático 01 - CRUD 
 * Dupla: Gustavo Murai e Igor Murai 
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		// Início do HTML com Bootstrap
		out.println("<html><head><title>Lista de Funcionários</title>");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.min.css' rel='stylesheet'>");
		out.println("<style>");
		out.println("body { background-color: #f4f7f6; padding-top: 50px; padding-bottom: 70px; }");
		out.println(".container-box { background: white; padding: 20px; border-radius: 10px; box-shadow: 0 4px 15px rgba(0,0,0,0.1); }");
		out.println(".footer { background-color: #343a40; color: white; text-align: center; padding: 20px 0; position: fixed; bottom: 0; width: 100%; }");
		out.println("</style></head><body>");
		
		out.println("<div class='container'>");
		out.println("<a href='index.html' class='btn btn-primary mb-3'>+ Adicionar Novo</a>");
		out.println("<h1>Gestão de Funcionários</h1>");
		
		out.println("<div class='container-box mt-4'>");
		
		List<Emp> list=EmpDao.getAllEmployees();
		
		// Tabela com estilo Bootstrap (zebrada e com bordas)
		out.print("<table class='table table-striped table-bordered table-hover'>");
		out.print("<thead class='table-success'><tr><th>ID</th><th>Nome</th><th>Senha</th><th>Email</th><th>País</th><th>Ações</th></tr></thead>");
		out.print("<tbody>");
		
		for(Emp e:list){
			out.print("<tr>"
					+ "<td>"+e.getId()+"</td>"
					+ "<td>"+e.getName()+"</td>"
					+ "<td>******</td>" // Ocultamos a senha
					+ "<td>"+e.getEmail()+"</td>"
					+ "<td>"+e.getCountry()+"</td>"
					+ "<td>"
						+ "<a href='EditServlet?id="+e.getId()+"' class='btn btn-sm btn-outline-primary'>Editar</a> "
						+ "<a href='DeleteServlet?id="+e.getId()+"' class='btn btn-sm btn-outline-danger' onclick='return confirm(\"Tem certeza que deseja excluir "+e.getName()+"?\")'>Deletar</a>"
					+ "</td>"
					+ "</tr>");
		}
		out.print("</tbody>");
		out.print("</table>");
		out.println("</div>"); // Fecha container-box
		out.println("</div>"); // Fecha container principal
		
		// Rodapé Fixo
		out.println("<div class='footer'>");
		out.println("<div class='container'>");
		out.println("projeto realizado por Gustavo Murai e Igor Murai para a materia de Sistemas Web 1");
		out.println("</div></div>");
		
		out.println("</body></html>");
		out.close();
	}
}