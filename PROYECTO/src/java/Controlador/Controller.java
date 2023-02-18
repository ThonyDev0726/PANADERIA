package Controlador;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {

    String MAIN = "index.jsp";
    String LOGIN = "VISTA/login.jsp";
    String CLIENTE = "VISTA/cliente.jsp";
    String INSUMO = "VISTA/insumo.jsp";
    String PRODUCTO = "VISTA/producto.jsp";
    String REGISTRO = "VISTA/registro.jsp";
    String USUARIO = "VISTA/usuario.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        //========================================================================================== GLOBALES

        switch (action) {
            case "main":
                acceso = MAIN;
                break;
            case "iniciar-sesion":
                acceso = LOGIN;
                break;
            case "dashboard":
                acceso = CLIENTE;
                break;
            case "insumo":
                acceso = INSUMO;
                break;
            case "producto":
                acceso = PRODUCTO;
                break;
            case "registro":
                acceso = REGISTRO;
                break;
            case "usuario":
                acceso = USUARIO;
                break;
            default:
                acceso = MAIN;
        }
        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
