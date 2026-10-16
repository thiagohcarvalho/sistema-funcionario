import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
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
                case "4": {
                    IO.println("Digite o Nome ou CPF do funcionário:");
                    String textoBusca = scanner.nextLine();
                    if (isTextCpf(textoBusca)) {
                        buscaFuncionarioCpf(textoBusca);
                    } else {
                        buscaFuncionarioNome(textoBusca);
                    }

                }
                break;
                case "5": {
                    IO.println("Digite o CPF do funcionário:");
                    String cpfRemove = scanner.nextLine();
                    removerFuncionario(cpfRemove);
                }
                break;
                case "6": {
                    IO.println("Digite o CPF do funcionário:");
                    String cpfAlterar = scanner.nextLine();
                    IO.println("Digite o salário novo:");
                    BigDecimal salarioFuncionario = new BigDecimal(scanner.nextLine());
                    alterarSalarioFuncionario(cpfAlterar, salarioFuncionario);
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
            printFuncionario(funcionario);
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

    private static void buscaFuncionarioCpf(String textoBusca) {
        for (Funcionario funcionario : funcionariosList) {
            if (funcionario.getCpf().equals(textoBusca)) {
                printFuncionario(funcionario);
                return;
            }
        }
        IO.println("Funcionário não encontrado, tente novamente.");
    }

    private static void buscaFuncionarioNome(String textoBusca) {
        boolean encontrado = false;

        for (Funcionario funcionario : funcionariosList) {
            if (funcionario.getNome().equalsIgnoreCase(textoBusca)) {
                printFuncionario(funcionario);
                encontrado = true;
            }
        }
        if (!encontrado) IO.println("Funcionário não encontrado, tente novamente.");
    }

    private static void removerFuncionario(String cpf) {
        boolean removido = funcionariosList.removeIf(
                funcionario -> funcionario.getCpf().equals(cpf)
        );

        if (removido) {
            IO.println("Funcionário removido com sucesso.");
        } else {
            IO.println("Funcionário não encontrado, tente novamente.");
        }
    }

    private static void alterarSalarioFuncionario(String cpf, BigDecimal salario) {
        Optional<Funcionario> resultado = findFuncionarioByCpf(cpf);

        resultado.ifPresentOrElse(
                funcionario -> funcionario.setSalario(salario),
                () -> IO.println("Funcionário não encontrado.")
        );
    }

    private static void printFuncionario(Funcionario funcionario) {
        IO.println("Cargo: " + funcionario.getClass().getSimpleName());
        IO.println("Nome do Funcionário: " + funcionario.getNome());
        IO.println("CPF do Funcionário: " + funcionario.getCpf());
        IO.println("Salário do Funcionário: " + funcionario.getSalario());
    }

    private static boolean isTextCpf(String texto) {
        return texto.matches("\\d{11}");
    }

    private static Optional<Funcionario> findFuncionarioByCpf(String cpf) {
        for (Funcionario funcionario : funcionariosList) {
            if (funcionario.getCpf().equals(cpf)) {
                return Optional.of(funcionario);
            }
        }
        return Optional.empty();
    }
}