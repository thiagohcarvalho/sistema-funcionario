import java.math.BigDecimal;

public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, String cpf, BigDecimal salario) {
        super(nome, cpf, salario);
    }

    @Override
    public void setSalario(BigDecimal salario) {
        if (salario.compareTo(BigDecimal.valueOf(4500)) < 0) {
            throw new IllegalArgumentException("O salário do desenvolvedor deve ser acima de R$ 4500,00");
        }
        super.setSalario(salario);
    }
}
