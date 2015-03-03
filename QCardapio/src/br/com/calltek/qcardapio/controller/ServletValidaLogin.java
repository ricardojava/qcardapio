package br.com.calltek.qcardapio.controller;


import java.io.IOException;
 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

import br.com.calltek.qcardapio.model.bean.Usuario;
import br.com.calltek.qcardapio.model.dao.UsuarioDao;
 
/**
 *
 * @author hallan medeiros
 *
 */
@WebServlet("/validaLogin.do")
public class ServletValidaLogin extends HttpServlet {
 
    private static final long serialVersionUID = 7633293501883840556L;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                         throws ServletException, IOException{
 
        HttpSession session = request.getSession(); //obtem a sessao do usuario, caso exista
 
        Usuario user = null;
        String login = request.getParameter("username"); // Pega o Login vindo do formulario
        String senha = request.getParameter("password"); //Pega a senha vinda do formulario
 
        try {
            UsuarioDao dao = new UsuarioDao(); //cria uma instancia do DAO usuario
            user = dao.getUsuario(login, senha);
        }
        catch ( Exception e ){
 
        }
 
        //se nao encontrou usuario no banco, redireciona para a pagina de erro!
        if ( user == null ) {
            session.invalidate();
            request.getRequestDispatcher("erroLogin.jsp" ).forward(request, response);
        }
        else{
            //se o dao retornar um usuario, coloca o mesmo na sessao
            session.setAttribute("user", user);
            request.getRequestDispatcher("logado.jsp" ).forward(request, response);
        }
 
    }
 
}