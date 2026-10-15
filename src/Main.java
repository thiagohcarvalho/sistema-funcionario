import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Funcionario> funcionariosList = new ArrayList<>();

    static void main() {
        boolean cont = true;

        while (cont) {
            IO.println("Bem vindo ao sistema de funcionários!");
            IO.println("Abaixo estão suas opções, escolha uma delas:");
            IO.println("1 - Cadastrar Funcionário");
            IO.println("2 - Listar funcionários");
            IO.println("3 - Calcular folha salarial");
            IO.println("4 - Buscar funcionário");
            IO.println("5 - Remover funcionário");
            IO.println("6 - Alterar salário");
            IO.println("7 - Sair");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": {
                    IO.println("Digite o nome do funcionário a ser cadastrado:");
                    String nomeFuncionario = scanner.nextLine();
                    IO.println("Digite o CPF do funcionário a ser cadastrado:");
                    String cpfFuncionario = scanner.nextLine();
                    IO.println("Digite o salário do funcionário a ser cadastrado:");
                    BigDecimal salarioFuncionario = new BigDecimal(scanner.nextLine());
                    String opcaoFuncionario;

                    while (true) {
                        IO.println("Digite o tipo de funcionário a ser cadastrado:");
                        IO.println("1 - Desenvolvedor");
                        IO.println("2 - Gerente");
                        IO.println("3 - Estagiário");

                        opcaoFuncionario = scanner.nextLine();

                        switch (opcaoFuncionario) {
                            case "1" -> {
                                cadastrarDesenvolvedor(nomeFuncionario, cpfFuncionario, salarioFuncionario);
                                break;
                            }
                            case "2" -> {
                                cadastrarGerente(nomeFuncionario, cpfFuncionario, salarioFuncionario);
                                break;
                            }
                            case "3" -> {
                                cadastrarEstagiario(nomeFuncionario, cpfFuncionario, salarioFuncionario);
                                break;
                            }
                            default -> {
                                IO.println("Opção inválida! Tente novamente.");
                                continue;
                            }
                        }

                        break;
                    }
                }
                break;
                case "2": {
                    listarFuncionarios();
                }
                case "3": {
                    calcularFolhaSalarial();
                }
                break;
                case "7": {
                    cont = false;
                }
                break;
            }
        }
    }

    private static void cadastrarDesenvolvedor(String nome, String cpf, BigDecimal salario) {
        try {
            Desenvolvedor dev = new Desenvolvedor(nome, cpf, salario);
            funcionariosList.add(dev);
        } catch (IllegalArgumentException e) {
            IO.println(e.getMessage());
        }
    }

    private static void cadastrarGerente(String nome, String cpf, BigDecimal salario) {
        try {
            Gerente gerente = new Gerente(nome, cpf, salario);
            funcionariosList.add(gerente);
        } catch (IllegalArgumentException e) {
            IO.println(e.getMessage());
        }
    }

    private static void cadastrarEstagiario(String nome, String cpf, BigDecimal salario) {
        try {
            Estagiario estagiario = new Estagiario(nome, cpf, salario);
            funcionariosList.add(estagiario);
        } catch (IllegalArgumentException e) {
            IO.println(e.getMessage());
        }
    }

    private static void listarFuncionarios() {
        if (funcionariosList.isEmpty()) {
            IO.println("Sem funcionários cadastrados!");
            return;
        }
        for (Funcionario funcionario : funcionariosList) {
            IO.println("========================");
            IO.println("Cargo: " + funcionario.getClass().getSimpleName());
            IO.println("Nome do Funcionário: " + funcionario.getNome());
            IO.println("CPF do Funcionário: " + funcionario.getCpf());
            IO.println("Salário do Funcionário: " + funcionario.getSalario());
        }
        IO.println("========================");
    }

    private static void calcularFolhaSalarial() {
        if (funcionariosList.isEmpty()) {
            IO.println("Sem funcionários cadastrados!");
            return;
        }
        BigDecimal somaSalario = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionariosList) {
            somaSalario = somaSalario.add(funcionario.getSalario());
        }
        IO.println("A folha salarial da empresa é: " + somaSalario);
    }
}