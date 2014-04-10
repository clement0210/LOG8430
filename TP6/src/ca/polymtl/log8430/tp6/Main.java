package ca.polymtl.log8430.tp6;
import ca.polymtl.log8430.tp6.model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement0210 on 14-04-10.
 */
public class Main {

    // Liste de File nous permettant de savoir quelles sont les ressources occupées
    private static List<File> busyFiles;
    private static Invocateur invocateur;

    /**
     * Metjode main du programme
     * @param args liste des paramètres
     */
    public static void main(String[] args){
        busyFiles=new ArrayList<>();
        invocateur=new Invocateur();
        scenario1();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        scenario2();
    }

    /**
     * Methode permettant de lancer le scenario n°1
     */
    public static void scenario1(){
        Runnable user1=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +" : Start user 1");
                File file=new File("TP6");
                while(busyFiles.contains(file)){
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() +" : Busy resource " + file.getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() +" : Resource "+file.getName()+" available ");
                busyFiles.add(file);

                CommandeVide1 commandeVide1=new CommandeVide1(invocateur, file);
                try {
                    System.out.print(Thread.currentThread().getName() +" : ");
                    commandeVide1.executer();
                    busyFiles.remove(file);
                } catch (CommandeException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +" : Stop user 1");
            }

        };
        Runnable user2=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +" : Start user 2");
                File file=new File("TP6");
                while(busyFiles.contains(file)){
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() +" : Busy resource " + file.getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() +" : Resource "+file.getName()+" available ");
                busyFiles.add(file);

                CommandeVide3 commandeVide3=new CommandeVide3(invocateur, file);
                try {
                    System.out.print(Thread.currentThread().getName() +" : ");
                    commandeVide3.executer();
                    busyFiles.remove(file);
                } catch (CommandeException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +" : Stop user 2");
              

            }
        };

        System.out.println("Lauching scenario 1 : try to access to the same resource");
        new Thread(user1).start();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(user2).start();
    }

    /**
     * Methode permettant de lancer le scenario n°2
     */
    public static void scenario2(){
        Runnable user1=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +" : Start user 1");
                File file=new File("TP6/src");
                while(busyFiles.contains(file)){
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() +" : Busy resource " + file.getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() +" : Resource "+file.getName()+" available ");
                busyFiles.add(file);

                CommandeVide1 commandeVide1=new CommandeVide1(invocateur, file);
                try {
                    System.out.print(Thread.currentThread().getName() +" : ");
                    commandeVide1.executer();
                    busyFiles.remove(file);
                } catch (CommandeException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +" : Stop user 1");
            }

        };
        Runnable user2=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +" : Start user 2");
                File file=new File("TP6");
                while(busyFiles.contains(file)){
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() +" : Busy resource " + file.getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() +" : Resource "+file.getName()+" available ");
                busyFiles.add(file);

                CommandeVide1 commandeVide1=new CommandeVide1(invocateur, file);
                try {
                    System.out.print(Thread.currentThread().getName() +" : ");
                    commandeVide1.executer();
                    busyFiles.remove(file);
                } catch (CommandeException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +" : Stop user 2");


            }
        };

        System.out.println("Lauching scenario 2 : try to access to the differents resources");
        new Thread(user1).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(user2).start();
    }

}
