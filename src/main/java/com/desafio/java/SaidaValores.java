package com.desafio.java;

import com.desafio.java.excecoes.LinhaInvalidaException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class SaidaValores {

    private HashMap<Integer, Integer[]> posicoesConsulta = new HashMap<>();

    private RepositorioValores repositorioValores;

    public SaidaValores(RepositorioValores repositorioValores) {
        this.repositorioValores = repositorioValores;
    }

    private void validarValores(String[] valoresLinha){
        if (valoresLinha.length != 2){
            throw new LinhaInvalidaException("Para consultar é necessário dois valores por linha");
        }
    }

    /**
     * Esse método recebe do usuário a quantidade de consultas a serem feitas.
     * Depois o usuário indica os valores dos índices da linha e coluna na qual ele quer fazer a consulta
     *
     * Ao final do método, os dados são mostrados para o usuário
     */

    public void consultar() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o numero de consultas: ");
        int numeroLinhas = scan.nextInt();

        for (int i = 1; i <= numeroLinhas; i++) {
            scan = new Scanner(System.in);
            String linha = scan.nextLine();
            String[] valoresLinha = linha.split(" ");

            validarValores(valoresLinha);

            int x = Integer.parseInt(valoresLinha[0]);

            int y = Integer.parseInt(valoresLinha[1]);

            posicoesConsulta.put(i, new Integer[]{x, y});
        }

        Collection<Integer[]> posicoes = posicoesConsulta.values();

        for(Integer[] posicao : posicoes){
            int x = posicao[0];
            int y = posicao[1];

            String resultado = repositorioValores.consultar(x,y);
            System.out.println(resultado);
        }

    }
}
