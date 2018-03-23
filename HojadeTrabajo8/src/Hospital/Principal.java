/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author cooli
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"));    
        StringBuilder sb = new StringBuilder();
        String line;
        VectorHeap listaPacientes = null;
        VectorHeapJFC pacientes = null;
        Vector<Paciente> lista = new Vector<>();

        Scanner teclado = new Scanner(System.in);

        try {
            while ((line=br.readLine())!=null) {
                String nombre;
                String prioridad;
                String enfermedad;
                
                sb.append(line);
                sb.append(System.lineSeparator()); 
                Paciente patient = null;
                
                int posNombre = line.indexOf(",");
                nombre = line.substring(0, posNombre).toUpperCase();
                String resto = line.substring(posNombre+1, line.length()).toUpperCase();
                int posEnf = resto.indexOf(",");
                enfermedad = resto.substring(0, posEnf).toUpperCase();
                prioridad = resto.substring(posEnf+1, resto.length()).toUpperCase();
                patient = new Paciente (nombre, prioridad, enfermedad);
                lista.add(patient);
            }
            listaPacientes = new VectorHeap(lista);
            pacientes = new VectorHeapJFC(lista);
            int size = listaPacientes.size();
            
            for (int i =0; i<size; i++)
            {
                System.out.println(((Paciente)listaPacientes.remove()).toString());
            }
            System.out.println("\n------------------------- UTILIZANDO JAVA FRAMEWORK COLLECTION ---------------------");
            for (int i =0; i<size; i++)
            {
                System.out.println(((Paciente)pacientes.poll()).toString());
            }
        }
        finally{
            br.close();
        }
    }
    
}
