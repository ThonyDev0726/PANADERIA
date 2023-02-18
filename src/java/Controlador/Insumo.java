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
    String EDITAR = "VISTA/insumo.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
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
                Modelo.Insumo insumo = new Modelo.Insumo(incNombre, incPrecio, incCompra, incCantidad, incTipo);
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                DAO.add(insumo);
                acceso = REGISTROS;
                break;
            case "editar-a":
                idInsumo = Integer.parseInt(request.getParameter("txt-idInsumo"));
                incNombre = request.getParameter("txtNombre");
                incPrecio = Float.parseFloat(request.getParameter("txtPrecio"));
                incCantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                incTipo = request.getParameter("txtTipo");
                /* ========== DAR VALORES AL OBJETO =========*/
                Modelo.Insumo insumoActalizar = new Modelo.Insumo(idInsumo, incNombre, incPrecio, incCompra, incCantidad, incTipo);
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                DAO.add(insumoActalizar);
                acceso = REGISTROS;
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
