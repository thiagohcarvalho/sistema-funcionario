import java.math.BigDecimal;

public class Funcionario {
    private String nome;

    private String cpf;

    private BigDecimal salario;

    public Funcionario(String nome, String cpf, BigDecimal salario) {
        setNome(nome);
        setCpf(cpf);
        setSalario(salario);
    }

    public void setNome(String nome) {
        if (nome.matches("^[\\p{L} ]+$")) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Cadastro inválido.");
        }
    }

    public void setCpf(String cpf) {
        if (cpf.matches("\\d{11}")) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("Cadastro inválido. Tente novamente.");
        }
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
