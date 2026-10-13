import java.math.BigDecimal;

public class Gerente extends Funcionario {

    public Gerente(String nome, String cpf, BigDecimal salario) {
        super(nome, cpf, salario);
    }

    @Override
    public void setSalario(BigDecimal salario) {
        if (salario.compareTo(BigDecimal.valueOf(7000)) < 0) {
            throw new IllegalArgumentException("O salário do desenvolvedor deve ser acima de R$ 7000,00");
        }
        super.setSalario(salario);
    }
}
