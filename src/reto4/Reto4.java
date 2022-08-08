/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto4;

import View.ReportesView;

/**
 *
 * @author Alejandro
 */
public class Reto4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var reportesView = new ReportesView();
        var banco = "Conavi";
        reportesView.proyectosFinanciadosPorBanco(banco);
        System.out.println("================================================================================");
        
        var limiteInferior = 50_000d;
        reportesView.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior); 
        System.out.println("================================================================================");
       
        reportesView. lideresQueMasGastan();
        
    }
    
}
