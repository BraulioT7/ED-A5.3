/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programas;

import datos.DatosDesordenados;
import datos.DatosOrdenados;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Braulio
 */
public class Comparador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Burbuja b = new Burbuja();
        QuickSort q = new QuickSort();
        ShellSort sh = new ShellSort();
        RadixSort ra = new RadixSort();
        //DatosOrdenados datosOrd;
        int n, s; 
        long t, t1, t2;
        
        n = Integer.parseInt(JOptionPane.showInputDialog(
                "¿Cuántos datos son?"));
        s = Integer.parseInt(JOptionPane.showInputDialog(
                "¿Cuál es el valor máximo?"));
        
        int [] arreglo = new int[n];
        for (int i=0; i<n; i++){
            arreglo[i] = (int)(Math.random() * s) + 1;
        }
        for(int x : arreglo){
            System.out.print(" " + x);
        }
        System.out.println("\n");
        
        t1 = System.nanoTime();   // start
            b.bubbleSort(arreglo);
            t2 = System.nanoTime();   // stop
            t= t2 - t1;
            System.out.println("n="+ n + " t=" + t + " ns. Burbuja= ");
            imparr(arreglo);
            System.out.println("\n");
            
            t1 = System.nanoTime();   // start
            shuffleArray(arreglo);
            t2 = System.nanoTime();   // stop
            t = t2 - t1;
            System.out.println("Tiempo reordenando el arreglo: " + t +"ns. \n\n");
            
            t1 = System.nanoTime();   // start
            q.quicksort(arreglo, 0, n-1);
            t2 = System.nanoTime();   // stop
            t = t2 - t1;
            System.out.println("n="+ n + " t=" + t + " ns. QuickSort= ");
            imparr(arreglo);
            System.out.println("\n");
            
            t1 = System.nanoTime();   // start
            shuffleArray(arreglo);
            t2 = System.nanoTime();   // stop
            t = t2 - t1;
            System.out.println("Tiempo reordenando el arreglo: " + t +"ns.\n\n");
            
            t1 = System.nanoTime();   // start
            sh.shell(arreglo);
            t2 = System.nanoTime();   // stop
            t = t2 - t1;
            System.out.println("n="+ n + " t=" + t + " ns. ShellSort= ");
            imparr(arreglo);
            System.out.println("\n");
            
            t1 = System.nanoTime();   // start
            shuffleArray(arreglo);
            t2 = System.nanoTime();   // stop
            t = t2 - t1;
            System.out.println("Tiempo reordenando el arreglo: " + t +"ns.\n\n");
            
            t1 = System.nanoTime();   // start
            ra.radixsort(arreglo,n);
            t2 = System.nanoTime();   // stop
            t = t2 - t1;
            System.out.println("n="+ n + " t=" + t + " ns. RadixSort= ");
            imparr(arreglo);
        
    }
    
    private static void shuffleArray(int[] array) {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            if (index != i) {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }
    
    public static void imparr(int[] arreglo)
    {
        for(int x : arreglo){
            System.out.print(" " + x);
        }
    }

}
