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
 * @author Ana Lucia Hernandez (17138).
 * @author Andrea Arguello (17801). 
 */
public class Principal {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException if file is not found
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
        int cycle =0;
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
            while (cycle ==0)
            {
            
                String exit = "";
                System.out.println("\n ****************\nQué desea hacer? \n\t 1. Ver los actuales pacientes en espera (en orden de prioridad)"
                        + "\n\t 2. Retirar al siguiente paciente de la lista. \n\t 3. Salir\n ********************");

                String entry = teclado.nextLine();
                switch (entry)
                {
                    case ("1"):
                        if (size != 0)
                        {
                            System.out.println("\n------------------ UTILIZANDO PROPIA IMPLEMENTACION DE VECTORHEAP---------------------");
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
                        else
                        {
                            System.out.println("Ya no hay más pacientes en la lista.");
                        }
                        listaPacientes = new VectorHeap(lista);
                        pacientes = new VectorHeapJFC(lista);
                        break;
                    case ("2"):
                        if (size != 0)
                        {
                            System.out.println("\n------------------ UTILIZANDO PROPIA IMPLEMENTACION DE VECTORHEAP---------------------");
                            System.out.println(((Paciente)listaPacientes.getFirst()).toString());
                            lista.remove((Paciente)listaPacientes.remove()); //para que se elimine de la lista que se lee (cuando se ven cuales pacientes quedan)
                            System.out.println("\n------------------------- UTILIZANDO JAVA FRAMEWORK COLLECTION ---------------------");
                            System.out.println(((Paciente)pacientes.poll()).toString());
                            size = listaPacientes.size();
                        }
                        else
                        {
                            System.out.println("Ya no hay más pacientes en la lista.");
                        }
                        break;
                    case "3":
                        cycle =1;
                        break;
                }
            }
        }
        finally{
            br.close();
        }
    }
    
}
