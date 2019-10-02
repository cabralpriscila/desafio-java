package com.desafio.java;

public class Main {

    private static RepositorioValores repositorioValores = new RepositorioValores();

    public static void main(String[] args) {

        EntradaValores entradaValores = new EntradaValores(repositorioValores);
        entradaValores.receber();

        SaidaValores saidaValores = new SaidaValores(repositorioValores);
        saidaValores.consultar();

    }
}
