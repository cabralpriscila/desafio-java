package com.desafio.java;

import com.desafio.java.excecoes.LinhaInvalidaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntradaValores {

    private RepositorioValores repositorioValores;

    public EntradaValores(RepositorioValores repositorioValores){
        this.repositorioValores = repositorioValores;
    }

    private void verficarLinhaVazia(String[] valoresLinha){
        if (valoresLinha[0].isEmpty()) {
            throw new LinhaInvalidaException("Infome ao menos o número de elementos");
        }

    }

    private void validarQuantidadeElementosLinha(String[] valoresLinha){
        int numeroElementosLinhaUm = Integer.parseInt(valoresLinha[0]);
        if (valoresLinha.length - 1 != numeroElementosLinhaUm) {
            throw new LinhaInvalidaException("O número informado não corresponde ao número de elementos");
        }

    }

    /**
     * Esse método recebe do usuário a quantidade de linhas a serem carregadas.
     * Para cada linha o programa pede para o usuário a quantidade de elementos importados (cada elemento é um número inteiro)
     *
     * Ao final do método, os dados foram carregados no mapa da classe RepositorioValores
     */
    public void receber(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o numero de linhas: ");
        int numeroLinhas = scan.nextInt();

        if(numeroLinhas > 100000){
            throw new LinhaInvalidaException("O total de numeros inteiros nas N linhas nao podera ultrapassar 10 ^ 5");
        }

        for (int i = 1; i <= numeroLinhas; i++) {

            List<Integer> numerosInformadosLinha = new ArrayList<>();

            scan = new Scanner(System.in);
            String linha = scan.nextLine();
            String[] valoresLinha = linha.split(" ");

            verficarLinhaVazia(valoresLinha);

            validarQuantidadeElementosLinha(valoresLinha);

            for (int j = 1; j < valoresLinha.length; j++) {
                numerosInformadosLinha.add(Integer.parseInt(valoresLinha[j]));
            }

            repositorioValores.adicionar(i, numerosInformadosLinha);
        }
    }
}
