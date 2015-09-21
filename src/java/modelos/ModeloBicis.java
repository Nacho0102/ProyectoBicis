/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import objetos.Bicicleta;
import objetos.TipoGenero;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author Nacho
 */
public class ModeloBicis {

    private ServletContext servlet;
    private Connection cn;
    private CachedRowSet crs;

    public ModeloBicis(ServletContext src) {
        this.servlet = src;
    }

    private Object getBean(String nombreBean) {
        ApplicationContext contexto = WebApplicationContextUtils.getRequiredWebApplicationContext(this.servlet);
        Object bean = contexto.getBean(nombreBean);
        return bean;
    }

    public void conectarSQL() throws SQLException {
        DriverManager.registerDriver(new SQLServerDriver());
        this.crs = RowSetProvider.newFactory().createCachedRowSet();
        this.crs.setUrl("jdbc:sqlserver://NACHO-PC\\SQLEXPRESS:1433;databaseName=BICIS_NACHO");
        this.crs.setUsername("sa");
        this.crs.setPassword("");
    }

    public String getBicicletas() throws SQLException {
        //Como conectar un cursor de salida
        this.conectarSQL();
        String consulta = "SELECT * FROM BICICLETAS";
        this.crs.setCommand(consulta);

        this.crs.execute();
        this.crs.beforeFirst();

        String html = "<table border='1' style='width:auto'> ";
        html += "<tr>";
        html += "<th>MARCA</th>";
        html += "<th>MODELO</th>";
        html += "<th>CARTEL</th>";
        html += "<th>FOTO</th>";
        html += "<th>COLOR</th>";
        html += "<th>TALLA</th>";
        html += "<th>PRECIO</th>";
        html += "<th>COMPRAR</th>";
        html += "</tr>";
        while (crs.next()) {
            html += "<tr>";
            html += "<td>";
            html += crs.getString("MARCA");
            html += "</td>";

            html += "<td>";
            html += crs.getString("MODELO");
            html += "</td>";

            html += "<td><img width='104' height='142' src='/ProyectoBicis/BICIS/";
            html += crs.getString("FOTO");
            html += "'/></td>";

            html += "<td>";
            html += crs.getString("COLOR");
            html += "</td>";
            
            html += "<td>";
            html += crs.getString("TALLA");
            html += "</td>";
            
            html += "<td>";
            html += crs.getString("PRECIO");
            html += "</td>";

            html += "<td>"
                    + "<a href='WebMostrarArgumentosBicicletas.htm?bicicleta="
                    + crs.getString("IDBICICLETA")
                    + "&operacion=argumentoBicicletas'>Ver más</a>"
                    + "</td>";

            html += "<td><a href='WebMostrarBicicletas.htm?bicicleta="
                    + crs.getString("IDBICICLETA")
                    + "&operacion=comprar'>Comprar Bicicleta</a></td>";
            html += "</tr>";

        }
        html += "</table>";

//        
        return html;

    }

    public String getArgumentoBicicletas(int idbicicleta) throws SQLException {
        //Como conectar un cursor de salida
        this.conectarSQL();
        String consulta = "SELECT * FROM BICICLETAS WHERE IDBICICLETA = ?";
        this.crs.setCommand(consulta);
        this.crs.setInt(1, idbicicleta);
        this.crs.execute();
        this.crs.beforeFirst();

        //El cursor devuelve un RESULTSET
        String html = "<table border='1' style='width:auto'> ";
        html += "<tr>";
        html += "<th>MARCA</th>";
        html += "<th>MODELO</th>";
        html += "<th>FOTO</th>";
        html += "<th>COLOR</th>";
        html += "<th>TALLA</th>";
        html += "<th>PRECIO</th>";
        html += "<th>COMPRAR</th>";
        html += "</tr>";
        while (this.crs.next()) {
            html += "<tr>";
            html += "<td>";
            html += this.crs.getString("MARCA");
            html += "</td>";

            html += "<td>";
            html += crs.getString("MODELO");
            html += "</td>";

            html += "<td><img width='104' height='142' src='/ProyectoBicis/BICIS/";
            html += crs.getString("FOTO");
            html += "'/></td>";

            html += "<td>";
            html += crs.getString("COLOR");
            html += "</td>";

            html += "<td>";
            html += crs.getString("TALLA");
            html += "</td>";
             
            html += "<td>";
            html += crs.getString("PRECIO");
            html += "</td>";

            html += "<td><a href='WebMostrarArgumentosBicicletas.htm?bicicleta="
                    + crs.getString("IDBICICLETA")
                    + "&operacion=comprar'>Comprar Bicicleta</a></td>";
            html += "</tr>";

        }
        html += "</table>";

//        
        return html;

    }

    public String comprarBicicleta(int idbicicleta) throws SQLException {
        this.conectarSQL();
        String consulta = "SELECT * FROM BICICLETAS WHERE IDBICICLETA = ?";
        this.crs.setCommand(consulta);
        this.crs.setInt(1, idbicicleta);
        this.crs.execute();
        this.crs.beforeFirst();
        String html = "<form>";
        while (crs.next()) {

            html += "MODELO: "
                    + crs.getString("MODELO")
                    + "<br/> codigo de cliente"
                    + "<input type='text' name='txtidcliente'/>"
                    + "<br/>"
                    + "Codigo de Producto"
                    + "<input type='text' name='txtcodigoproducto'/>"
                    + "<br/>"
                    + "Unidades"
                    + "<input type='text' name='txtunidades'/>";

        }
        html += "</form>";
        return html;
    }

    public ArrayList<TipoGenero> getGeneros() throws SQLException {
        this.conectarSQL();
        String consulta = "SELECT * FROM GENEROS";
        this.crs.setCommand(consulta);
        this.crs.execute(this.cn);
        this.crs.beforeFirst();
        ArrayList<TipoGenero> lista = new ArrayList();
        while (this.crs.next()) {
            TipoGenero gen = new TipoGenero();
            gen.setIdgenero(this.crs.getInt("IDGENERO"));
            gen.setGenero(this.crs.getString("GENERO"));
            lista.add(gen);
        }
        return lista;
    }

    public ArrayList<Bicicleta> getBicicletasGenero(int idgenero) throws SQLException {
        this.conectarSQL();
        String consulta = "SELECT * FROM BICICLETAS WHERE IDGENERO = ?";
        this.crs.setCommand(consulta);
        this.crs.setInt(1, idgenero);
        this.crs.execute(this.cn);
        this.crs.beforeFirst();
        ArrayList<Bicicleta> lista = new ArrayList();
        while (this.crs.next()) {
            Bicicleta bici = new Bicicleta();
            bici.setIdbicicleta(this.crs.getInt("IDBICICLETA"));
            bici.setMarca(this.crs.getString("MARCA"));
            bici.setPrecio(this.crs.getInt("PRECIO"));
            bici.setFoto(this.crs.getString("FOTO"));
            bici.setModelo(this.crs.getString("MODELO"));
            bici.setColor(this.crs.getString("COLOR"));
            bici.setTalla(this.crs.getString("TALLA"));
            bici.setIdgenero(this.crs.getInt("IDGENERO"));
            lista.add(bici);
        }
        return lista;
    }

    public Bicicleta getBicicleta(int idbicicleta) throws SQLException {
        this.conectarSQL();
        String consulta = "SELECT * FROM BICICLETAS WHERE IDBICICLETA = ?";
        this.crs.setCommand(consulta);
        this.crs.setInt(1, idbicicleta);
        this.crs.execute(this.cn);
        this.crs.beforeFirst();
        if (this.crs.next()) {
            Bicicleta bici = new Bicicleta();
            bici.setIdbicicleta(this.crs.getInt("IDBICICLETA"));
            bici.setMarca(this.crs.getString("MARCA"));
            bici.setPrecio(this.crs.getInt("PRECIO"));
            bici.setFoto(this.crs.getString("FOTO"));
            bici.setModelo(this.crs.getString("MODELO"));
            bici.setColor(this.crs.getString("COLOR"));
            bici.setTalla(this.crs.getString("TALLA"));
            bici.setIdgenero(this.crs.getInt("IDGENERO"));
            return bici;
        } else {
            return null;
        }
    }

    public ArrayList<Bicicleta> getBicicletasCarrito(ArrayList<Integer> bicicletas)
            throws SQLException {
        this.conectarSQL();
        String datos = "";
        for (int idbici : bicicletas) {
            datos += idbici + ",";
        }
        datos = datos.substring(0, datos.length() - 1);
        String consulta = "SELECT * FROM BICICLETAS WHERE IDBICICLETA IN ("
                + datos + ")";
        this.crs.setCommand(consulta);
        this.crs.execute(this.cn);
        this.crs.beforeFirst();
        ArrayList<Bicicleta> lista = new ArrayList();
        while (this.crs.next()) {
            Bicicleta bici = new Bicicleta();
            bici.setIdbicicleta(this.crs.getInt("IDBICICLETA"));
            bici.setMarca(this.crs.getString("MARCA"));
            bici.setPrecio(this.crs.getInt("PRECIO"));
            bici.setFoto(this.crs.getString("FOTO"));
            bici.setModelo(this.crs.getString("MODELO"));
            bici.setColor(this.crs.getString("COLOR"));
            bici.setTalla(this.crs.getString("TALLA"));
            bici.setIdgenero(this.crs.getInt("IDGENERO"));
            lista.add(bici);
        }
        return lista;
    }

}
