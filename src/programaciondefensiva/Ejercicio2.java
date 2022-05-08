/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaciondefensiva;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author miguel
 */
public class Ejercicio2 {
    //Clase para iniciar el juego de ahorcado
    public static void juego()
    {
        //palabras que se pueden jugar
        String[] palabras = {"Mapache","Oso","Caballo","Perro","Gato","Serpiente"};
        final int INTENTOS= 9;
        int intentosRealizados =0;
        int aciertos =0;
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        char respuesta;
        Random rnd = new Random();
        
        do
        {
            //Random para escoger una palabra al azar
            int num=rnd.nextInt(palabras.length);
            char[] letras = letras(palabras[num].toLowerCase());
            char[] letras2 = letras(palabras[num].toLowerCase());
            char[] tusRespuestas = new char[letras.length];
            for(int i =0; i<tusRespuestas.length;i++)
            {
                tusRespuestas[i] = '-';
            }
            
            System.out.println("Adivina la palabra");
            boolean ganado = false;
            while(INTENTOS>intentosRealizados && !ganado)
            {
                imprimeOcultar(tusRespuestas);
                System.out.println("\nIntroduce una letra");
                respuesta = scanner.next().toLowerCase().charAt(0);
                for(int i=0;i<letras.length;i++)
                {
                    if(letras[i]==respuesta)
                    {
                        tusRespuestas[i] = letras[i];
                        letras[i] =' ';
                        aciertos++;
                    }
                }
                intentosRealizados++;
                ganado = (aciertos==tusRespuestas.length);
            }
            if(aciertos==tusRespuestas.length)
            {
                System.out.println("\nFelicidades... Ganaste");
                imprimeOcultar(tusRespuestas);
            }else
            {
                System.out.println("\nFracasaste... Te he vencido");
                System.out.println("Lo que ingresate fue: ");
                imprimeOcultar(tusRespuestas);
                System.out.println("\n");
                System.out.println("Lo que debías encontrar era: ");
                imprimeOcultar(letras2);
            }
            intentosRealizados=0;
            aciertos=0;
            respuesta = pregunta("\n\nQuieres volver a jugar?", scanner);
        }while(respuesta !='n');
    }
    
    /*metodo que sirve para comparar las letras ingresadas por el usuario 
      con la palabra que se esta jugando
    */
    private static char[] letras(String palabra)
    {
        char[] letras=new char[palabra.length()];
        for(int i =0; i<palabra.length();i++)letras[i] = palabra.charAt(i);
        return letras;
    }
    //Metodo que imprime u oculta las letras dependiendo del resultado.
    private static void imprimeOcultar(char[] tusRespuestas)
    {
        for(int i = 0; i<tusRespuestas.length;i++)
        {
            System.out.print(tusRespuestas[i]+" ");
        }
    }
    //Metodo para volver a jugar o salir del juego
    private static char pregunta(String m, Scanner teclado)
    {
        char resp;
        System.out.println(m + "(s/n)");
        resp = teclado.next().toLowerCase().charAt(0);
        while(resp != 's' && resp != 'n')
        {
            System.out.println(m + "(s/n)");
            resp = teclado.next().toLowerCase().charAt(0);
        }
        return resp;
    }
}
