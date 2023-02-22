package Controlador;

import ModeloDao.InsumoDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;

/**
 *
 * @author perez
 */
public class Insumo extends HttpServlet {

    InsumoDao DAO = new InsumoDao();
    LocalDate diaActual = LocalDate.now();
    public Integer idInsumo;
    public String incNombre;
    public Float incPrecio;
    public String incCompra = diaActual.toString();
    public Integer incCantidad;
    public String incTipo;
    /**/
    String REGISTROS = "VISTA/insumo.jsp";
    String EDITAR = "VISTA/insumo-actualizar.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        //========================================================================================== GLOBALES

        switch (action) {
            case "registro-clientes":
                acceso = REGISTROS;
                break;
            case "eliminar":
                idInsumo = Integer.parseInt((String) request.getParameter("idInsumo"));
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                DAO.delete(idInsumo);
                acceso = REGISTROS;
                break;
            case "editar":
                request.setAttribute("idInsumo", request.getParameter("idInsumo"));
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
        String LOGIN = "views/Login.jsp";

        switch (action) {
            case "registro-clientes":
                acceso = REGISTROS;
                break;
            case "Registrar":
                incNombre = request.getParameter("txtNombre");
                incPrecio = Float.parseFloat(request.getParameter("txtPrecio"));
                incCantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                incTipo = request.getParameter("txtTipo");
                /* ========== DAR VALORES AL OBJETO =========*/
                Modelo.INSUMOS insumo = new Modelo.INSUMOS(incNombre, incPrecio, incCompra, incCantidad, incTipo);
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                DAO.add(insumo);
                acceso = REGISTROS;
                break;

            case "Actualizar":
                idInsumo = Integer.parseInt(request.getParameter("txt-idInsumo"));
                incNombre = request.getParameter("txtNombre");
                incPrecio = Float.parseFloat(request.getParameter("txtPrecio"));
                incCantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                incTipo = request.getParameter("txtTipo");
                /* ========== DAR VALORES AL OBJETO =========*/
                Modelo.INSUMOS insumoActalizar = new Modelo.INSUMOS(idInsumo, incNombre, incPrecio, incCompra, incCantidad, incTipo);
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                DAO.update(insumoActalizar);
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
