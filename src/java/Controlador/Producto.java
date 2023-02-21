/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import ModeloDao.ProductoDao;
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
public class Producto extends HttpServlet {

    ProductoDao DAO = new ProductoDao();
    LocalDate diaActual = LocalDate.now();
    public Integer idProducto;
    public String proNombre;
    public Float proPrecio;
    public String proElaboracion = diaActual.toString();
    public Integer proCantidad;
    /**/
    String REGISTROS = "VISTA/producto.jsp";
    String EDITAR = "VISTA/producto.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        //========================================================================================== GLOBALES
        String LOGIN = "views/Login.jsp";

        switch (action) {
            case "registro-clientes":
                acceso = REGISTROS;
                break;
            case "eliminar":                
            case "editar-a":
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
                proNombre = request.getParameter("txtNombre");
                proPrecio = Float.parseFloat(request.getParameter("txtPrecio"));
                proCantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                /* ========== DAR VALORES AL OBJETO =========*/
                Modelo.PRODUCTOS producto = new Modelo.PRODUCTOS(proNombre, proCantidad, proPrecio, proElaboracion);
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                DAO.add(producto);
                acceso = REGISTROS;
                break;
            case "editar-a":

            case "Actualizar":
                idProducto = Integer.parseInt(request.getParameter("txt-idProducto"));
                proNombre = request.getParameter("txtNombre");
                proCantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                proPrecio = Float.parseFloat(request.getParameter("txtPrecio"));
                proElaboracion = request.getParameter("txtElaboracion");
                /* ========== DAR VALORES AL OBJETO =========*/
                Modelo.PRODUCTOS productoActalizar = new Modelo.PRODUCTOS(idProducto, proNombre, proCantidad, proPrecio, proElaboracion);
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                DAO.add(productoActalizar);
                acceso = REGISTROS;
                break;
            default:
                acceso = REGISTROS;
        }
        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);
    }

}
