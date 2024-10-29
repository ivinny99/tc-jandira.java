public class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public boolean registrarVenda(int quantidade) {
        if (quantidade <= estoque) {
            estoque -= quantidade;
            return true; // Venda registrada com sucesso
        } else {
            return false; // Estoque insuficiente
        }
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$" + preco);
        System.out.println("Estoque: " + estoque);
    }
}
