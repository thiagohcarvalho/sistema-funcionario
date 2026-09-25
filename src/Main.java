import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
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
                case "7": {
                    cont = false;
                }
                break;
            }
        }
    }
}