/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Model.vo.ComprasDeLiderVo;
import Model.vo.DeudasPorProyectoVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class ComprasDeLiderDao extends JDBCUtilities{
    
    public List<ComprasDeLiderVo> listar() throws SQLException {
        ArrayList<ComprasDeLiderVo> respuesta = new ArrayList<ComprasDeLiderVo>();
        Connection conn = getConexion();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        String consulta =   "SELECT CONCAT(Nombre,' ',Lider.Primer_Apellido ,' ',Lider.Segundo_Apellido) as LIDER, SUM(Precio_Unidad*Cantidad) as VALOR FROM Compra " +
                            " JOIN MaterialConstruccion on Compra.ID_MaterialConstruccion=MaterialConstruccion.ID_MaterialConstruccion " +
                            " JOIN Proyecto ON COMPRA.ID_Proyecto = Proyecto.ID_Proyecto " +
                            " JOIN lIDER ON Proyecto.ID_Lider = Lider.ID_Lider " +
                            " GROUP BY CONCAT(Nombre,' ',Lider.Primer_Apellido ,' ',Lider.Segundo_Apellido)" +
                            " ORDER BY VALOR DESC" +
                            " LIMIT 10";
        try {
            stmt = conn.prepareStatement(consulta);
            rset = stmt.executeQuery();
            while (rset.next()) {
                ComprasDeLiderVo vo = new ComprasDeLiderVo();
                vo.setLider(rset.getString("Lider"));
                vo.setValor(rset.getDouble("Valor"));

                respuesta.add(vo);
            }
        } finally {
            if (rset != null) {
                rset.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
    
}
