/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Model.vo.DeudasPorProyectoVo;
import Model.vo.ProyectoBancoVo;
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
public class DeudasPorProyectoDao extends JDBCUtilities{
    
    public List<DeudasPorProyectoVo> listar(Double limite) throws SQLException {
        ArrayList<DeudasPorProyectoVo> respuesta = new ArrayList<DeudasPorProyectoVo>();
        Connection conn = getConexion();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        String consulta = "SELECT ID_Proyecto as ID, SUM(Precio_Unidad*Cantidad) as VALOR FROM Compra" +
                          " JOIN MaterialConstruccion on Compra.ID_MaterialConstruccion=MaterialConstruccion.ID_MaterialConstruccion" +
                          " WHERE Pagado = 'No'" + " GROUP BY Compra.ID_Proyecto" + " HAVING  VALOR>?" + " ORDER BY VALOR DESC";
        try {
            stmt = conn.prepareStatement(consulta);
            stmt.setDouble(1, limite);
            rset = stmt.executeQuery();
            while (rset.next()) {
                DeudasPorProyectoVo vo = new DeudasPorProyectoVo();
                vo.setId(rset.getInt("ID"));
                vo.setValor(rset.getDouble("VALOR"));
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
