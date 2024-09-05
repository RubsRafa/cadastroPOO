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
public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> lista = new ArrayList<>();

    public void inserir(PessoaFisica pf) {
        lista.add(pf);
    }

    public void alterar(int id, PessoaFisica pessoa) throws Exception {
        Optional<PessoaFisica> encontrada = lista.stream()
            .filter(p -> p.getId() == pessoa.getId()).findFirst();

        if (encontrada.isPresent()) {
            int index = lista.indexOf(encontrada.get());
            lista.set(index, pessoa);
        } else {
            throw new Exception("Pessoa Física não encontrada.");
        }

    }

    public void excluir(int id) throws Exception {
        PessoaFisica pessoa = obter(id);
        lista.remove(pessoa);
    }

    public PessoaFisica obter(int id) throws Exception {
        return lista.stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElseThrow(() -> new Exception("Pessoa Física não encontrada."));
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return lista;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(lista);
            System.out.println("Dados de Pessoa Física Armazenados.");
        } catch (IOException e) {
            throw new IOException("Erro ao salvar dados.", e);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            lista = (ArrayList<PessoaFisica>) ois.readObject();
            System.out.println("Dados de Pessoa Jurídica Armazenados.");
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Erro ao carregar dados.", e);
        }
    }
}
