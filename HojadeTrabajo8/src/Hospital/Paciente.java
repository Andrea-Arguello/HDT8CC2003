/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;


/**
 *
 * @author Ana Lucia Hernandez (17138).
 * @author Andrea Arguello (17801). 
 */
public class Paciente<E> implements Comparable<E> {
    private String nombre;
    private String codigo;
    private String sintoma;
    /**
     * 
     * @param nombre: nombre paciente
     * @param codigo: codigo paciente
     * @param sintoma : enfermedad del paciente
     */
    public Paciente(String nombre, String codigo, String sintoma){
        this.nombre=nombre;
        this.codigo=codigo;
        this.sintoma=sintoma;
    }
    /**
     * 
     * @return nombre del paciente
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * 
     * @return codigo de prioridad del paciente
     */
    public String getCodigo(){
        return codigo;
    }
    /**
     * 
     * @return enfermedad del paciente
     */
    public String getSintoma(){
        return sintoma;
    }
    /**
     * 
     * @return string de informacion de paciente.
     */
    public String toString(){
        return "Nombre: " + nombre + "\tSintoma: " + sintoma + "\tCodigo: " + codigo;
    }
    
    /**
     * 
     * @param otroPaciente: el otro paciente al que se quiere comparar
     * @return entero que indica si es mayor, igual o menor
     */
    @Override
    public int compareTo(E otroPaciente) {
        String codigo2 = ((Paciente)otroPaciente).getCodigo();
        int compare = codigo.compareTo(codigo2);
        return compare;
    }
    
}
