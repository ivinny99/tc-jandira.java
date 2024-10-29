public class Aluno {
    private String nome;
    private int idade;
    private String faixa;
    private boolean mensalidade;
    private String dataNascimento;

    public Aluno(String nome, int idade, String faixa, boolean mensalidade, String dataNascimento) {
        this.nome = nome;
        this.idade = idade;
        this.faixa = faixa;
        this.mensalidade = mensalidade;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public boolean isMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(boolean mensalidade) {
        this.mensalidade = mensalidade;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        //cpf
        //email
        //etc
        System.out.println("Faixa: " + faixa);
        System.out.println("Mensalidade: " + (mensalidade ? "Paga" : "Atrasada"));
        System.out.println("Data de Nascimento: " + dataNascimento);
    }
}
