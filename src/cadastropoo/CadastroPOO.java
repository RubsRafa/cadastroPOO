/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.IOException;
import model.*;
import java.util.Scanner;

/**
 *
 * @author rubia
 */
public class CadastroPOO {
    
    private static String ArquivoFisicas = "pessoasFisicas.bin";
    private static String ArquivoJuridicas = "pessoasJuridicas.bin";
    
    private static PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
    private static PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();

 
    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        boolean executando = true;

        while (executando) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Incluir");
            System.out.println("2. Alterar");
            System.out.println("3. Excluir");
            System.out.println("4. Exibir pelo ID");
            System.out.println("5. Exibir todos");
            System.out.println("6. Salvar dados");
            System.out.println("7. Recuperar dados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();  // Consumir a quebra de linha após o número

            switch (opcao) {
                case 1:  // Incluir
                    incluir(sc, repoFisica, repoJuridica);
                    break;
                case 2:  // Alterar
                    alterar(sc, repoFisica, repoJuridica);
                    break;
                case 3:  // Excluir
                    excluir(sc, repoFisica, repoJuridica);
                    break;
                case 4:  // Exibir pelo ID
                    exibirPorId(sc, repoFisica, repoJuridica);
                    break;
                case 5:  // Exibir todos
                    exibirTodos(sc, repoFisica, repoJuridica);
                    break;
                case 6:  // Salvar dados
                    salvarDados(sc, repoFisica, repoJuridica);
                    break;
                case 7:  // Recuperar dados
                    recuperarDados(sc, repoFisica, repoJuridica);
                    break;
                case 0:  // Sair
                    executando = false;
                    System.out.println("Sistema finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        sc.close();
    }

    private static void incluir(Scanner sc, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Escolha o tipo: 1. Física | 2. Jurídica");
        int tipo = sc.nextInt();
        sc.nextLine();

        switch (tipo) {
            case 1 ->                 {
                    System.out.print("ID: ");
                    int id = sc.nextInt();  // Ler ID como int
                    sc.nextLine();  
                    
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    
                    repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
                }
            case 2 ->                 {
                    System.out.print("ID: ");
                    int id = sc.nextInt();  // Ler ID como int
                    sc.nextLine();  
                    
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    
                    System.out.print("CNPJ: ");
                    String cnpj = sc.nextLine();
                    
                    repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
                }
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void alterar(Scanner sc, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Escolha o tipo: 1. Física | 2. Jurídica");
        int tipo = sc.nextInt();
        sc.nextLine();
        
        try {
        switch (tipo) {
            case 1 -> {
                System.out.print("ID para alterar: ");
                int id = sc.nextInt();
                sc.nextLine();

                PessoaFisica pessoa = repoFisica.obter(id); 
                if (pessoa != null) {
                    System.out.println("Dados atuais: " + pessoa);
                    System.out.print("Novo nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Novo CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Nova idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    pessoa.setNome(nome);
                    pessoa.setCpf(cpf);
                    pessoa.setIdade(idade);
                    repoFisica.alterar(id, pessoa); 
                } else {
                    System.out.println("Pessoa não encontrada.");
                }
            }
            case 2 -> {
                System.out.print("ID para alterar: ");
                int id = sc.nextInt();
                sc.nextLine();

                PessoaJuridica pessoa = repoJuridica.obter(id);
                if (pessoa != null) {
                    System.out.println("Dados atuais: " + pessoa);
                    System.out.print("Novo nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Novo CNPJ: ");
                    String cnpj = sc.nextLine();

                    pessoa.setNome(nome);
                    pessoa.setCnpj(cnpj);
                    repoJuridica.alterar(id, pessoa);
                } else {
                    System.out.println("Pessoa não encontrada.");
                }
            }
            default -> System.out.println("Opção inválida!");
        }
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao alterar os dados: " + e.getMessage());
    }
    }

    private static void excluir(Scanner sc, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Escolha o tipo: 1. Física | 2. Jurídica");
        int tipo = sc.nextInt();
        sc.nextLine();
        
        try {
            switch (tipo) {
               case 1 ->                 {
                      System.out.print("ID para excluir: ");
                      int id = sc.nextInt();
                      sc.nextLine();
                      repoFisica.excluir(id);
                   }
               case 2 ->                 {
                        System.out.print("ID para excluir: ");
                        int id = sc.nextInt();
                    sc.nextLine();
                        repoJuridica.excluir(id);
                    }
                default -> System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao excluir os dados: " + e.getMessage());
        }
    }

    private static void exibirPorId(Scanner sc, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Escolha o tipo: 1. Física | 2. Jurídica");
        int tipo = sc.nextInt();
        sc.nextLine();
        
        try {
        switch (tipo) {
            case 1 ->                 {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    PessoaFisica pf = repoFisica.obter(id);
                    if (pf != null) {
                        pf.exibir();
                    } else {
                        System.out.println("Pessoa Física não encontrada.");
                    }                      }
            case 2 ->                 {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    PessoaJuridica pj = repoJuridica.obter(id);
                    if (pj != null) {
                        pj.exibir();
                    } else {
                        System.out.println("Pessoa Jurídica não encontrada.");
                    }                      }
            default -> System.out.println("Opção inválida!");
        }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao exibir por ID: " + e.getMessage());
        }
    }

    private static void exibirTodos(Scanner sc, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Escolha o tipo: 1. Física | 2. Jurídica");
        int tipo = sc.nextInt();
        sc.nextLine();
        
        try {

        switch (tipo) {
            case 1 -> {
                for (PessoaFisica pf : repoFisica.obterTodos()) {
                    pf.exibir();
                }
            }
            case 2 -> {
                for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                    pj.exibir();
                }
            }
            default -> System.out.println("Opção inválida!");
        }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao exibir todos os dados: " + e.getMessage());
        }
    }

    private static void salvarDados(Scanner sc, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Informe o prefixo do arquivo: ");
        String prefixo = sc.nextLine();

        try {
            repoFisica.persistir(prefixo + ".fisica.bin");
            repoJuridica.persistir(prefixo + ".juridica.bin");
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static void recuperarDados(Scanner sc, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Informe o prefixo do arquivo: ");
        String prefixo = sc.nextLine();

        try {
            repoFisica.recuperar(prefixo + ".fisica.bin");
            repoJuridica.recuperar(prefixo + ".juridica.bin");
            System.out.println("Dados recuperados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados: " + e.getMessage());
        }
    }
    
}
