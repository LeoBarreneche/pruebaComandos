
package javaapplication3;

import java.util.Scanner;

public class Metodos {
    
    public static String SelecyAsignRefugio(String[] refugios) {
        Scanner input = new Scanner(System.in);
        int opcion;
        System.out.println("Este es el listado de refugios disponibles: ");
        for (int i = 0; i < refugios.length; i++) {
            System.out.println((i + 1) + "- " + refugios[i]);
        }
        System.out.println("Seleccione el refugio que desea: ");
        opcion = input.nextInt();
        return refugios[opcion - 1];
    }

    public static String[] recolectarSuministros(String[] inventarioUsuario, String[] suministrosClave) {
        Scanner input = new Scanner(System.in);
        int cont = 0, opcion;
        System.out.println("\nEstos son los suministros claves disponibles: ");
        for (int i = 0; i < suministrosClave.length; i++) {
            System.out.println((i + 1) + "- " + suministrosClave[i]);
        }
        System.out.println("\nIngrese hasta 5 suministro que desea guardar o");
        System.out.println("0 - para salir\n");

        do {
            System.out.println((cont + 1) + "° suministro:");
            opcion = input.nextInt();
            if (opcion != 0) {
                inventarioUsuario[cont] = suministrosClave[opcion - 1];
            }
            if (opcion == 0) {
                for (int i = cont; i < inventarioUsuario.length; i++) {
                    inventarioUsuario[i] = "vacio";
                }
            }
            cont++;
        } while (opcion != 0 && cont < 5);
        if (cont == 5) {
            System.out.println("\nHa alcanzado el limite maximo de suministros\n");
        }
        System.out.println("\nEstos son los suministros recolectados: ");
        for (int i = 0; i < inventarioUsuario.length; i++) {
            if (i + 1 < inventarioUsuario.length) {
                System.out.print(inventarioUsuario[i] + ", ");
            } else {
                System.out.print(inventarioUsuario[i] + ".\n");
            }
        }
        return inventarioUsuario;
    }

    public static boolean fortalecerRefugio(String[] inventarioUsuario, String sumClave) {
        boolean esSeguro = false;
        for (int i = 0; i < inventarioUsuario.length; i++) {
            if (inventarioUsuario[i].equals(sumClave)) {
                esSeguro = true;
            }
        }
        return esSeguro;
    }

    public static void evaluacionFinal(boolean esSeguro, String sumClave, int energiaUsu, int energSobrevive) {
        
        //evaluamos si ademas de poseer el suministro clave, cuenta con la energia suficiente para sobrevivir
        
        if (esSeguro && (energiaUsu>=energSobrevive)) {
            System.out.println("\n¡Has sobrevivido al Twister! El refugio resistió.");
            System.out.println("¡Felicidades, has ganado con el " + sumClave + "ademas de que has quedado con sufucuente energia para sobrevivir!");
            System.out.println("Sobreviviste con una energia de "+energiaUsu+"%");
        } else if (esSeguro){
            System.out.println("El refugio ha resistido al Twister ya que has recolectado el suministro clave que era: "+sumClave);
            System.out.println("pero no has finalizado con la energia suficiente para continuar la aventura...");
            System.out.println("Energia final "+energiaUsu+"%. Game Over, camarada...");
        }else if (energiaUsu>=energSobrevive){
            System.out.println("\nSi bien cuentas con una energia de "+energiaUsu+"%, el refugio no resistió el Twister, te falto recoger suministro " + sumClave);
            System.out.println("Game Over, camarada...");
        }else{
            System.out.println("El refugio no ha resistido la potenica del Twister por faltar el suministro clave: "+sumClave);
            System.out.println("ademas de que has finalizado con poca energia: "+energiaUsu+"%");
            System.out.println("Game Over...");
        }
    }

    // PARA MEJORA DE MODO ESTRATEGICO
    public static String[] AsignarSuminClaves(String[] refugios, String[] refug1, String[] refug2, String[] refug3) {
        Scanner input = new Scanner(System.in);
        String[] sumClaveMejora = new String[3];
        int opcion;
        System.out.println("Este es el listado de refugios disponibles: ");
        for (int i = 0; i < refugios.length; i++) {
            System.out.println((i + 1) + "- " + refugios[i]);
        }
        System.out.println("Seleccione el refugio que desea: ");
        opcion = input.nextInt();
        switch (opcion) {
            case 1:
                sumClaveMejora = refug1;
                break;
            case 2:
                sumClaveMejora = refug2;
                break;
            case 3:
                sumClaveMejora = refug3;
                break;
        }
        return sumClaveMejora;
    }

    public static boolean fortalecerRefugioMejora(String[] inventarioUsuario, String[] sumClaveMejora) {
        boolean esSeguro = false;
        int cont = 0;
        for (int i = 0; i < sumClaveMejora.length; i++) {
            for (int j = 0; j < inventarioUsuario.length; j++) {
                if (sumClaveMejora[i].equals(inventarioUsuario[j])) {
                    cont++;
                    break;
                }
            }
        }
        if (cont == 3) {
            esSeguro = true;
        }
        return esSeguro;
    }

    public static void evaluacionFinal(boolean esSeguro, String[] sumClaveMejora) {
        if (esSeguro) {
            System.out.println("\n¡Has sobrevivido al Twister! El refugio resistió por contar con los suminsitros:");
            for (int i = 0; i < sumClaveMejora.length; i++) {
                if (i + 1 < sumClaveMejora.length) {
                    System.out.print(sumClaveMejora[i] + ", ");
                } else {
                    System.out.println(sumClaveMejora[i]);
                }
            }
            System.out.println("¡Felicidades, has ganado!");
        } else {
            System.out.println("\nEl refugio no resistió el Twister, era necesario contar con los siguiente suministros:");
            for (int i = 0; i < sumClaveMejora.length; i++) {
                if (i + 1 < sumClaveMejora.length) {
                    System.out.print(sumClaveMejora[i] + ", ");
                } else {
                    System.out.println(sumClaveMejora[i]);
                }
            }
            System.out.println("Game Over, camarada...");
        }
    }

    
    // Mejoras añadiendo consumo o acumulacion de energia segun refugios, suministros y potencia del Twister
    
    public static int calcEnergRefugio(String[] listaRefugios, String refugio, int[] energiaRefugios) {
        //Consumo de energia segun el refugio elegido
        int energConsumida = 0;
        for (int i = 0; i < listaRefugios.length; i++) {
            if (refugio.equals(listaRefugios[i])) {
                energConsumida = energiaRefugios[i];
            }
        }
        return energConsumida;
    }

    public static int energSuministros(String[] inventarioUsu, String[] Suministros, int[] EnergporSumin, int energUsu) {
        //Dependiendo los suministros elegidos sumamos energia
        int energAgregada = 0;
        for (int i = 0; i < inventarioUsu.length; i++) {
            for (int j = 0; j < Suministros.length; j++) {
                if (inventarioUsu[i].equals(Suministros[j])) {
                    energAgregada += EnergporSumin[j];
                }
            }
        }
        System.out.println("Con los suministros elegidos has sumado "+energAgregada+"% de energia.");
        return energAgregada;
    }

    public static int energPotenciaTornado(int PotenciaTornado, int[] energiaConsumeTornado, int[] Rangos) {
        //calculamos la energ que descuenta la potencia del Twister segun rangos de potencia y energia que consume cada rango 
        //pasados por parametros
        int energ=0;
        System.out.print("El Twister ha tenido una potencia de nivel "+PotenciaTornado+", descontando la siguiente energia: ");
        if (PotenciaTornado < Rangos[0]) {
            System.out.println(energiaConsumeTornado[0]+"%");
            energ+= energiaConsumeTornado[0];
        } else if (PotenciaTornado < Rangos[1]) {
            System.out.println(energiaConsumeTornado[1]+"%");
            energ+= energiaConsumeTornado[1];
        } else if (PotenciaTornado <= Rangos[2]) {
            System.out.println(energiaConsumeTornado[2]+"%");
            energ+= energiaConsumeTornado[2];
        }
        return energ;
    }
    
    
}
