package com.desafio.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class RepositorioValores {

    private HashMap<Integer, List<Integer>> numerosInformados = new HashMap<>();

    public void adicionar(Integer id, List<Integer> valores){

        numerosInformados.put(id, valores);
    }

    public HashMap<Integer, List<Integer>> getNumerosInformados() {
        return numerosInformados;
    }

    public String consultar(Integer x, Integer y){
        List<List<Integer>> lista = new ArrayList(numerosInformados.values());

        List<Integer> linha;

        try{
            linha = lista.get(x - 1);
        }
        catch (IndexOutOfBoundsException ex){
            return "ERROR!";
        }

        Integer coluna;

        try{
            coluna = linha.get(y - 1);
        }
        catch (IndexOutOfBoundsException ex){
            return "ERROR!";
        }

        return coluna.toString();
    }
}
