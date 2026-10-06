import java.math.BigDecimal;

public class Gerente extends Funcionario {

    @Override
    public void setSalario(BigDecimal salario) {
        if (salario.compareTo(BigDecimal.valueOf(7000)) < 0) {
            throw new IllegalArgumentException("O salário do desenvolvedor deve ser acima de R$ 7000,00");
        }
        super.setSalario(salario);
    }
}
