/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadetrabajo8;

/**
 *
 * @author cooli
 */
public class Paciente {
    private String nombre;
    private String codigo;
    private String sintoma;
    
    public Paciente(String nombre, String codigo, String sintoma){
        this.nombre=nombre;
        this.codigo=codigo;
        this.sintoma=sintoma;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public String getSintoma(){
        return sintoma;
    }
    
    public String toString(){
        return "Nombre: " + nombre + "\nSintoma: " + sintoma + "\nCodigo: " + codigo;
    }
    
}
