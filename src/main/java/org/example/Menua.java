package org.example;
import java.util.Scanner;

public class Menua {
    private Babeslekua babeslekua;
    private Scanner sc;

    public Menua(Babeslekua babeslekua) {
        this.babeslekua = babeslekua;
        this.sc = new Scanner(System.in);
    }
    public void erakutsiMenua(){
        System.out.println("====================================");
        System.out.println("        ANIMALIEN BABESLEKUA");
        System.out.println("====================================");
        System.out.println("1. Animalia gehitu");
        System.out.println("2. Animalia erakutsi");
        System.out.println("3. Animalia adoptatu");
        System.out.println("4. Animalia ezabatu");
        System.out.println("5. Guztiek soinua egin");
        System.out.println("6. Txakurra lotu");
        System.out.println("0. Irten");
    }
    public void exekutatu() {
        int aukera;
        do {
            erakutsiMenua();
            aukera = irakurriZenbakia();
            switch (aukera) {
                case 1 -> gehituAnimalia();
                case 2 -> ezabatuAnimalia();
                case 3 -> babeslekua.erakutsiAnimaliak();
                case 4 -> adoptatuAnimalia();
                case 5 -> babeslekua.eginSoinuak();
                case 6 -> System.out.println("A-TA PERROOOO!!");
                case 0 -> System.out.println("Agur!");
                default -> System.out.println("Aukera okerra.");
            }
        } while (aukera != 0);
    }
    private int irakurriZenbakia() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Zenbaki oso bat sartu: ");
            }
        }
    }
    private void gehituAnimalia() {
        System.out.println("Zer animalia? (1 Txakurra, 2 Katua, 3 Untxia)");
        int mota = irakurriZenbakia();
        if (mota < 1 || mota > 3) {
            System.out.println("Mota okerra.");
            return;
        }
        System.out.print("Izena: ");
        String izena = sc.nextLine().trim();
        if (babeslekua.bilatuAnimalia(izena) != null) {
            System.out.println("Izen hori duen animalia bat badago jada.");
            return;
        }
        System.out.print("Adina: ");
        int adina = irakurriZenbakia();
        System.out.print("Pisua (kg): ");
        double pisua = irakurriZenbakia();

        Animalia animalia = switch (mota) {
            case 1 -> new Txakurra(izena, adina, pisua);
            case 2 -> new Katua(izena, adina, pisua);
            default -> new Untxia(izena, adina, pisua);
        };
        babeslekua.gehituAnimalia(animalia);
        System.out.println("Animalia gehitu da.");
    }
    public void adoptatuAnimalia() {
        System.out.print("Izena: ");
        String izena = sc.nextLine().trim();
        if (babeslekua.adoptatuAnimalia(izena)) {
        } else {
            System.out.println("animalia hori adoptatuta dago");
        }
    }
    private void ezabatuAnimalia() {
        System.out.print("Izena: ");
        String izena = sc.nextLine().trim();
        if (babeslekua.ezabatuAnimalia(izena)) {
            System.out.println("Animalia ezabatu da.");
        } else {
            System.out.println("Ez da animalia hori aurkitu.");
        }
    }






}