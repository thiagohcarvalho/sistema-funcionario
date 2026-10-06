import java.math.BigDecimal;

public class Estagiario extends Funcionario {

    @Override
    public void setSalario(BigDecimal salario) {
        if (salario.compareTo(BigDecimal.valueOf(1500)) < 0) {
            throw new IllegalArgumentException("O salário do desenvolvedor deve ser acima de R$ 1500,00");
        }
        super.setSalario(salario);
    }
}
