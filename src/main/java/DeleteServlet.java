import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 1. Pega o ID que veio lá do link da tabela
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		// 2. Chama o método de deletar que já criamos no EmpDao
		EmpDao.delete(id);
		
		// 3. Redireciona você de volta para a lista atualizada
		response.sendRedirect("ViewServlet");
	}
}