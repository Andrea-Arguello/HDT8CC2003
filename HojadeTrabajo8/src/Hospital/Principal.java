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

        Scanner teclado = new Scanner(System.in);

        try {
            while ((line=br.readLine())!=null) {
                String palabraIngles;
                String palabraEspanol;
                sb.append(line);
                sb.append(System.lineSeparator()); 
                line = line + " "; //Concatenado para que el ultimo valor sea leido sin problemas
                                   //por substring
                for(int i=1;i<line.length();i++){
                    
                    String iter = line.substring((i-1), i); 
                    if(iter.equals(","))
                    {
                        palabraEspanol = line.substring(i, line.length()-1).toUpperCase(); //se obtiene la subcadena luego de ","
                        palabraIngles = line.substring(0, i-1).toUpperCase(); //se obtiene la subcadena antes de "," 
                    }
                }
            }
        }
        finally{
            br.close();
        }
    }
    
}
