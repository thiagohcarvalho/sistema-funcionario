import java.math.BigDecimal;

public class Funcionario {
    private String nome;

    private String cpf;

    private BigDecimal salario;

    public Funcionario(String nome, String cpf, BigDecimal salario) {
        this.nome = nome;
        this.cpf = cpf;
        setSalario(salario);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public BigDecimal getSalario() {
        return salario;
    }
}
