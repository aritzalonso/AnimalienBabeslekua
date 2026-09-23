package org.example;

public class Main {
    public static void main(String[] args) {
        Babeslekua babeslekua = new Babeslekua();
        Menua menua = new Menua(babeslekua);
        menua.exekutatu();
    }
}