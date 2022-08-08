/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.vo;

/**
 *
 * @author Alejandro
 */
public class ProyectoBancoVo {
    private int id;
    private String constructora;
    private String ciudad;
    private String clasificacion;
    private int estrato;
    private String lider;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the constructora
     */
    public String getConstructora() {
        return constructora;
    }

    /**
     * @param constructora the constructora to set
     */
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the clasificacion
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * @return the estrato
     */
    public int getEstrato() {
        return estrato;
    }

    /**
     * @param estrato the estrato to set
     */
    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    /**
     * @return the lider
     */
    public String getLider() {
        return lider;
    }

    /**
     * @param lider the lider to set
     */
    public void setLider(String lider) {
        this.lider = lider;
    }
    
     
 @Override
    public String toString() {
        return String.format("%3d %-25s %-20s %-15s %7d %-30s",
                id, constructora, ciudad, clasificacion, estrato, lider);
    }            
    
}
