package ModeloDao;

import Conexion.Conexion;
import Interfaces.crud_cliente;
import Modelo.CLIENTES;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao  implements crud_cliente{

    CLIENTES objeto = new CLIENTES();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ============== VARIABLES PARA PROCEDIMIENTOS ALMACENADOS ==============*/
    String LISTAR = "CALL SELECT_CLIENTES()";
    String LISTAR_ID = "CALL A_S_ID_Cliente(?)";
    String CREAR = "CALL INSERT_CLIENTE(?,?,?,?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_Cliente(?,?,?,?,?,?,?,?)";
    String ELIMINAR = "CALL DELETE_Cliente(?)";

    @Override
    public List listar() {
        ArrayList<CLIENTES> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                CLIENTES cli = new CLIENTES();
                cli.setIdCliente(rs.getInt(1));
                cli.setCliCedula(rs.getString(2));
                cli.setCliNombres(rs.getString(3));
                cli.setCliApellidos(rs.getString(4));
                cli.setCliFecha(rs.getString(5));
                cli.setCliDireccion(rs.getString(6));
                cli.setCliTelefono(rs.getString(7));
                lista.add(cli);
            }
            System.out.println("SE ESTA LISTANDO LOS ClienteS");
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS ClienteS" + ex);
        }
        return lista;
    }

    @Override
    public CLIENTES list(int id) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                objeto.setIdCliente(rs.getInt(1));
                objeto.setCliCedula(rs.getString(2));
                objeto.setCliNombres(rs.getString(3));
                objeto.setCliApellidos(rs.getString(4));
                objeto.setCliDireccion(rs.getString(5));
                objeto.setCliTelefono(rs.getString(6));
            }
            System.out.println("SE ESTA LISTANDO EL Cliente");
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS ClienteS" + ex);
        }
        return objeto;
    }

    @Override
    public String add(CLIENTES cli) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setString(1, cli.getCliCedula());
            cs.setString(2, cli.getCliNombres());
            cs.setString(3, cli.getCliApellidos());
            cs.setString(4, cli.getCliFecha());
            cs.setString(5, cli.getCliDireccion());
            cs.setString(6, cli.getCliTelefono());
            cs.execute();
            System.out.println("SE CREO EL Cliente CON EXITO");
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR EL Cliente");
            System.out.println(ex);
            return "El Cliente no fue creado!";
        }
        return "El Cliente fue creado con exito!";
    }

    @Override
    public String update(CLIENTES cli) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, cli.getIdCliente());
            cs.setString(2, cli.getCliCedula());
            cs.setString(3, cli.getCliNombres());
            cs.setString(4, cli.getCliApellidos());
            cs.setString(5, cli.getCliFecha());
            cs.setString(6, cli.getCliDireccion());
            cs.setString(7, cli.getCliTelefono());
            System.out.println("SE ACTUALIZO EL Cliente CON EXITO");
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR EL Cliente");
            System.out.println(ex);
            return "El Cliente no fue actualizado!";
        }
        return "El Cliente fue actualizado con exito!";
    }

    @Override
    public String delete(int id) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ELIMINAR);
            cs.setInt(1, id);
            System.out.println("SE ELIMINO EL Cliente: " + id);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el Cliente!");
            System.out.println(ex);
            return "Error al eliminar el Cliente!";
        }
        return "El Cliente fue eliminado con exito!";
    }
    
}
