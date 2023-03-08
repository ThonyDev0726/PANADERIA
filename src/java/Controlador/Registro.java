package Controlador;

import Modelo.REGISTROS;
import ModeloDao.RegistroDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class Registro extends HttpServlet {

    RegistroDao DAO = new RegistroDao();
    REGISTROS reg = new REGISTROS();

    public Integer idRegistro;
    public String regFecha;
    public Integer regCantidad;
    public Integer fkCliente;
    public Integer fkProducto;
    public String regTotal;
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
                regFecha = LocalDate.now().toString();
                regCantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                regTotal = request.getParameter("txtTotal");
                fkCliente = obtenerNumero(request.getParameter("pkCliente"));
                fkProducto = obtenerNumero(request.getParameter("fkProducto"));
                System.out.println("Listo todo");
                DAO.add(new REGISTROS(regFecha, regCantidad, regTotal, fkCliente, fkProducto));
                acceso = REGISTROS;
                break;
            case "Actualizar":
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                idRegistro = Integer.parseInt((String) request.getParameter("idRegistro"));
                regFecha = request.getParameter("txtFecha");
                regCantidad = Integer.parseInt(request.getParameter("txtRegistro"));
                regTotal = request.getParameter("txtTipo");
                reg = new REGISTROS(idRegistro, regFecha, regCantidad, regTotal);
                DAO.update(reg);
                acceso = REGISTROS;
                break;
            default:
                acceso = REGISTROS;
        }
        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);
    }

    public Integer obtenerNumero(String cadena) {
        String ingreso = cadena;
        char[] cadena_div = ingreso.toCharArray();
        String respuesta = "";
        for (int i = 0; i < cadena_div.length; i++) {
            if (Character.isDigit(cadena_div[i])) {
                respuesta += cadena_div[i];
            }
        }
        return Integer.parseInt(respuesta);
    }
}
