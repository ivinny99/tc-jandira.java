import java.util.Date;

public class Frequencia {
    private Aluno aluno;
    private Date data;

    public Frequencia(Aluno aluno) {
        this.aluno = aluno;
        this.data = new Date(); // Data atual
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Date getData() {
        return data;
    }
}
