package Controlador;

import ModeloDao.ClienteDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class Cliente extends HttpServlet {

    Modelo.Cliente cli = new Modelo.Cliente();
    ClienteDao DAO = new ClienteDao();
    LocalDate diaActual = LocalDate.now();
    public Integer idCliente;
    public String cliNombres;
    public String cliCedula;
    public String cliApellidos;
    public String cliFecha = diaActual.toString();
    public String cliDireccion;
    public String cliTelefono;
    /**/
    String REGISTROS = "VISTA/cliente.jsp";
    String EDITAR = "VISTA/cliente.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        //========================================================================================== GLOBALES

        String LOGIN = "views/Login.jsp";

        switch (action) {
            case "registro-clientes":
                request.setAttribute("div_si", "sr-only");
                request.setAttribute("div_no", "sr-only");
                acceso = REGISTROS;
                break;
            case "editar-a":
                request.setAttribute("idCliente", request.getParameter("idCliente"));
                acceso = EDITAR;
                break;

            case "eliminar":
                idCliente = Integer.parseInt((String) request.getParameter("idCliente"));
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                if (DAO.delete(idCliente) == "El cliente fue eliminado con exito!") {
                    request.setAttribute("msj_si", "El cliente fue eliminado con exito");
                    request.setAttribute("div_si", "visible");
                    request.setAttribute("div_no", "sr-only");
                } else if (DAO.delete(idCliente) == "Error al eliminar el cliente!") {
                    request.setAttribute("msj_no", "No se pudo eliminar al cliente!");
                    request.setAttribute("div_no", "visible");
                    request.setAttribute("div_si", "sr-only");
                }
                acceso = REGISTROS;
                break;
            default:
                request.setAttribute("div_si", "sr-only");
                request.setAttribute("div_no", "sr-only");
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
        String LOGIN = "views/Login.jsp";

        switch (action) {
            case "registro-clientes":
                acceso = REGISTROS;
                break;
            case "Registrar":
                cliNombres = request.getParameter("txt-nombres");
                cliApellidos = request.getParameter("txt-apellidos");
                cliCedula = request.getParameter("txt-cedula");
                cliTelefono = request.getParameter("txt-telefono");
                cliDireccion = request.getParameter("txt-direccion");
                /* ========== DAR VALORES AL OBJETO =========*/
                Modelo.Cliente cliente = new Modelo.Cliente(cliNombres, cliCedula, cliApellidos, cliFecha, cliDireccion, cliTelefono);

                /* ========== ENVIO EL OBJETO A LA DB=========*/
                DAO.add(cliente);
                acceso = REGISTROS;
                break;
            case "editar-a":
                request.setAttribute("idCliente", request.getParameter("idCliente"));
                acceso = EDITAR;
                break;
            case "Actualizar":

                acceso = REGISTROS;
                break;

            default:
                acceso = REGISTROS;

        }
        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
