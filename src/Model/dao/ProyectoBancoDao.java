
package Model.dao;

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
public class ProyectoBancoDao extends JDBCUtilities{
    
    public List<ProyectoBancoVo> listar(String banco) throws SQLException {
        ArrayList<ProyectoBancoVo> respuesta = new ArrayList<ProyectoBancoVo>();
        Connection conn = getConexion();
        PreparedStatement stmt = null;
        ResultSet rset = null;
            
                
        String consulta =   "SELECT ID_Proyecto as ID, Constructora, Ciudad, Proyecto.Clasificacion, Estrato, CONCAT(Nombre,' ',Lider.Primer_Apellido ,' ',Lider.Segundo_Apellido) as LIDER FROM Proyecto"
                            +" JOIN tipo on Proyecto.ID_Tipo=tipo.ID_Tipo"
                            +" JOIN Lider on Proyecto.ID_Lider=Lider.ID_Lider"
                            +" where Proyecto.Banco_Vinculado=? ORDER by	Proyecto.Fecha_Inicio desc, Proyecto.Ciudad ASC, Proyecto.Constructora";
        try {
            stmt = conn.prepareStatement(consulta);
            stmt.setString(1, banco);
            rset = stmt.executeQuery();
            while (rset.next()) {
                ProyectoBancoVo vo = new ProyectoBancoVo();
                vo.setId(rset.getInt("id"));
                vo.setConstructora(rset.getString("constructora"));
                vo.setCiudad(rset.getString("ciudad"));
                vo.setClasificacion(rset.getString("clasificacion"));
                vo.setEstrato(rset.getInt("estrato"));
                vo.setLider(rset.getString("lider"));

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
