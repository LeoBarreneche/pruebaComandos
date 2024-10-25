
package javaapplication3;

import java.util.Random;
import java.util.Scanner;

public class JavaApplication3 {

   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int furiaDelTwister = random.nextInt(10);
        int opcion, cont;
        String refugioUsuario;
        String refugios[] = {"Subterraneo", "en las Montañas", "en el Bosque"};
        String inventarioUsuario[] = new String[5];
        String suministrosClave[] = {"Manta térmica", "Encendedor", "Comida enlatada", "Botiquín básico", "Kit de primeros auxilios", "Linterna", "Radio", "Filtro de agua", "Cobija", "Herramientas"};
        String sumClave=suministrosClave[furiaDelTwister];
        boolean esSeguro;
        int energiaUsu=100, energSobrevive=40;
        int gastoEnergRefugios []={45, 60, 35};
        int EnergSuministros[]={5,3,15,10,20,3,4,8,6,7};
        int restaEnergPotenciaTornado[]={15,30,40};
        int rangosPotenciaTornado []={2,7,9};
        
        System.out.println("Se acerca un tornado, para sobrevivir al mismo deberas buscar un refugio, recolectar suministros y tener los indicados");
        System.out.println("pero ademas deberas quedarte con la suficiente energia para finalizar ganador\n");
        
        // SELECCION Y ASIGNACION DEL REFUGIO
        refugioUsuario = Metodos.SelecyAsignRefugio(refugios);
        
        // ENERGIA SEGUN REFUGIO
        energiaUsu-=Metodos.calcEnergRefugio(refugios, refugioUsuario, gastoEnergRefugios);
        System.out.println("Energia en estos momentos al " + energiaUsu + "%.");
       
        
        // RECOLECTAR SUMINISTROS 
        inventarioUsuario = Metodos.recolectarSuministros(inventarioUsuario, suministrosClave);
        
        //ENERGIA SEGUN SUMINISTROS
        energiaUsu+=Metodos.energSuministros(inventarioUsuario, suministrosClave, EnergSuministros, energiaUsu);
        System.out.println("Energia en estos momentos al " + energiaUsu + "%.");
        

        //FORTALECER EL REFUGIO
        esSeguro=Metodos.fortalecerRefugio(inventarioUsuario, sumClave);
        
        //ENERGIA POR POTENCIA DE TORNADO
        energiaUsu-=Metodos.energPotenciaTornado(furiaDelTwister, restaEnergPotenciaTornado, rangosPotenciaTornado);
        
        //EVALUACION FINAL
        Metodos.evaluacionFinal(esSeguro, sumClave, energiaUsu, energSobrevive);
        
        
        //Para Modo Estrategico
        String [] Subterraneo = {"Filtro de agua","Manta térmica","Linterna"};
        String [] Montaña = {"Manta térmica", "Encendedor", "Herramientas"};
        String [] Bosque = {"Cobija", "Botiquín básico", "Radio"};
        
        System.out.println("\n----------------------------------------");
        System.out.println("\nAhora hagamos el MODO ESTRATEGICO:\n");
        
        String [] sumClaveMejora = Metodos.AsignarSuminClaves(refugios, Subterraneo, Montaña, Bosque);
        
        inventarioUsuario = Metodos.recolectarSuministros(inventarioUsuario, suministrosClave);
        
        esSeguro=Metodos.fortalecerRefugioMejora(inventarioUsuario, sumClaveMejora);
    
        Metodos.evaluacionFinal(esSeguro, sumClaveMejora);
       
        
    }
    
}
