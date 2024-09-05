/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author rubia
 */
public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> lista = new ArrayList<>();

    public void inserir(PessoaJuridica pj) {
        lista.add(pj);
    }

    public void alterar(int id, PessoaJuridica pessoa) throws Exception {
        Optional<PessoaJuridica> encontrada = lista.stream()
            .filter(p -> p.getId() == pessoa.getId()).findFirst();

        if (encontrada.isPresent()) {
            int index = lista.indexOf(encontrada.get());
            lista.set(index, pessoa);
        } else {
            throw new Exception("Pessoa Jurídica não encontrada.");
        }
    }

    public void excluir(int id) throws Exception {
        PessoaJuridica pessoa = obter(id);
        lista.remove(pessoa);
    }

    public PessoaJuridica obter(int id) throws Exception {
        return lista.stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElseThrow(() -> new Exception("Pessoa Jurídica não encontrada."));
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return lista;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            throw new IOException("Erro ao salvar dados.", e);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            lista = (ArrayList<PessoaJuridica>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Erro ao carregar dados.", e);
        }
    }

}
