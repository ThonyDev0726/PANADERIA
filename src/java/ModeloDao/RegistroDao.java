package ModeloDao;

import Conexion.Conexion;
import Interfaces.crud_registro;
import Modelo.Registro;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistroDao implements crud_registro {

    Registro c = new Registro();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ============== VARIABLES PARA PROCEDIMIENTOS ALMACENADOS ==============*/
    String LISTAR = "CALL SELECT_Registro_ALL()";
    String LISTAR_ID = "CALL A_S_ID_Registro(?)";
    String CREAR = "CALL INSERT_RegistroS(?,?,?,?,?,?,?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_Registro(?,?,?,?,?,?,?,?,?)";
    String ELIMINAR = "CALL DELETE_Registro(?)";

    @Override
    public List listar() {
        ArrayList<Registro> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                Registro cli = new Registro();
                cli.setIdRegistro(rs.getInt(1));
                cli.setRegFecha(rs.getString(2));
                cli.setRegNumero(rs.getInt(3));
                cli.setRegTipo(rs.getString(4));
                lista.add(cli);
            }
            System.out.println("SE ESTA LISTANDO LOS RegistroS");
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS RegistroS" + ex);
        }
        return lista;
    }

    @Override
    public Registro list(int id) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                c.setIdRegistro(rs.getInt(1));
                c.setRegFecha(rs.getString(2));
                c.setRegNumero(rs.getInt(3));
                c.setRegTipo(rs.getString(4));
            }
            System.out.println("SE ESTA LISTANDO EL Registro");
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS RegistroS" + ex);
        }
        return c;
    }

    @Override
    public String add(Registro cli) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setString(1, cli.getRegFecha());
            cs.setInt(2, cli.getRegNumero());
            cs.setString(3, cli.getRegTipo());
            cs.execute();
            System.out.println("SE CREO EL Registro CON EXITO");
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR EL Registro");
            System.out.println(ex);
            return "El Registro no fue creado!";
        }
        return "El Registro fue creado con exito!";
    }

    @Override
    public String update(Registro cli) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, cli.getIdRegistro());
            cs.setString(2, cli.getRegFecha());
            cs.setInt(3, cli.getRegNumero());
            cs.setString(4, cli.getRegTipo());
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR EL Registro");
            System.out.println(ex);
            return "El Registro no fue actualizado!";
        }
        return "El Registro fue actualizado con exito!";
    }

    @Override
    public String delete(int id) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ELIMINAR);
            cs.setInt(1, id);
            System.out.println("SE ELIMINO EL Registro: " + id);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el Registro!");
            System.out.println(ex);
            return "Error al eliminar el Registro!";
        }
        return "El Registro fue eliminado con exito!";
    }

}
