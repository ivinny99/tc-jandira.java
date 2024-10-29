import java.util.Date;

public class Pagamento {
    private Aluno aluno;
    private double valor;
    private Date data;

    public Pagamento(Aluno aluno, double valor) {
        this.aluno = aluno;
        this.valor = valor;
        this.data = new Date(); // Data atual
    }

    public Aluno getAluno() {
        return aluno;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }
}
