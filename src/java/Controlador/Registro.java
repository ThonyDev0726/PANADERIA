package Controlador;

import Modelo.REGISTROS;
import ModeloDao.RegistroDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Registro extends HttpServlet {

    RegistroDao DAO = new RegistroDao();
    REGISTROS reg = new REGISTROS();

    public Integer idRegistro;
    public String regFecha;
    public Integer regNumero;
    public String regTipo;
    /**/
    String REGISTROS = "VISTA/registro.jsp";
    String EDITAR = "VISTA/registro-actualizar.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        //========================================================================================== GLOBALES
        String LOGIN = "views/Login.jsp";

        switch (action) {
            case "registros":
                acceso = REGISTROS;
                break;
            case "eliminar":
                idRegistro = Integer.parseInt((String) request.getParameter("idRegistro"));
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                DAO.delete(idRegistro);
                acceso = REGISTROS;
                break;
            case "editar":
                request.setAttribute("idRegistro", request.getParameter("idRegistro"));
                acceso = EDITAR;
                break;
            default:
                acceso = REGISTROS;
        }
        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        //========================================================================================== GLOBALES

        switch (action) {
            case "Registrar":
                regFecha = request.getParameter("txtFecha");
                regNumero = Integer.parseInt(request.getParameter("txtRegistro"));
                regTipo = request.getParameter("txtTipo");               
                DAO.add(new REGISTROS(regFecha, regNumero, regTipo));
                acceso = REGISTROS;
                break;
            case "Actualizar":
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                idRegistro = Integer.parseInt((String) request.getParameter("idRegistro"));
                regFecha = request.getParameter("txtFecha");
                regNumero = Integer.parseInt(request.getParameter("txtRegistro"));
                regTipo = request.getParameter("txtTipo");
                reg = new REGISTROS(idRegistro, regFecha, regNumero, regTipo);
                DAO.update(reg);
                acceso = REGISTROS;
                break;
            default:
                acceso = REGISTROS;
        }
        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);
    }

}
