package Controlador;

import Modelo.CLIENTES;
import ModeloDao.ClienteDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class Cliente extends HttpServlet {

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
    String EDITAR = "VISTA/cliente-actualizar.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        //========================================================================================== GLOBALES

        switch (action) {
            case "registro-clientes":
                acceso = REGISTROS;
                break;
            case "editar":
                request.setAttribute("idCliente", request.getParameter("idCliente"));
                acceso = EDITAR;
                break;
            case "eliminar":
                idCliente = Integer.parseInt((String) request.getParameter("idCliente"));
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                DAO.delete(idCliente);
                acceso = REGISTROS;
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
                cliNombres = request.getParameter("txt-nombres");
                cliApellidos = request.getParameter("txt-apellidos");
                cliFecha = request.getParameter("txt-fecha");
                cliCedula = request.getParameter("txt-cedula");
                cliTelefono = request.getParameter("txt-telefono");
                cliDireccion = request.getParameter("txt-direccion");
                /* ========== DAR VALORES AL OBJETO =========*/
                Modelo.CLIENTES cliente = new Modelo.CLIENTES(cliNombres, cliCedula, cliApellidos, cliFecha, cliDireccion, cliTelefono);

                /* ========== ENVIO EL OBJETO A LA DB=========*/
                DAO.add(cliente);
                acceso = REGISTROS;
                break;
            case "Actualizar":
                idCliente = Integer.parseInt(request.getParameter("txt-idCliente"));
                System.out.println("ID cliente" +idCliente);
                cliNombres = request.getParameter("txt-nombres");
                cliApellidos = request.getParameter("txt-apellidos");
                cliFecha = null;
                cliCedula = request.getParameter("txt-cedula");
                cliTelefono = request.getParameter("txt-telefono");
                cliDireccion = request.getParameter("txt-direccion");
                /* ========== DAR VALORES AL OBJETO =========*/
                CLIENTES clienteActualizar = new CLIENTES(idCliente, cliNombres, cliCedula, cliApellidos, cliDireccion, cliTelefono);

                /* ========== ENVIO EL OBJETO A LA DB=========*/
                DAO.update(clienteActualizar);
                acceso = REGISTROS;
                break;

            default:
                acceso = REGISTROS;

        }
        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);
    }

}
