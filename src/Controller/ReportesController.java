/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.dao.ComprasDeLiderDao;
import Model.dao.DeudasPorProyectoDao;
import Model.dao.ProyectoBancoDao;
import Model.vo.DeudasPorProyectoVo;
import Model.vo.ProyectoBancoVo;
import Model.dao.ComprasDeLiderDao;
import Model.vo.ComprasDeLiderVo;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Alejandro
 */
public class ReportesController {
    private ProyectoBancoDao proyectoBancoDao;
    private ComprasDeLiderDao comprasDeLiderDao;
    private DeudasPorProyectoDao pagadoPorProyectoDao;

    public ReportesController() {
        proyectoBancoDao = new ProyectoBancoDao();
        pagadoPorProyectoDao = new DeudasPorProyectoDao();
        comprasDeLiderDao = new ComprasDeLiderDao();
            
        
    }

    public List<ProyectoBancoVo> listarProyectosPorBanco(String banco) throws SQLException {
        return proyectoBancoDao.listar(banco);
    }
      
    
    public List<DeudasPorProyectoVo> listarTotalAdeudadoProyectos(Double limite) throws SQLException {
        return pagadoPorProyectoDao.listar(limite);
    }
    public List<ComprasDeLiderVo> listarlideresmasgastan() throws SQLException {
        return comprasDeLiderDao.listar(); 
    }
    

    
}
    

