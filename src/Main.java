import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Aluno> alunos = new ArrayList<>();
    private static final ArrayList<Produto> produtos = new ArrayList<>();
    private static final ArrayList<Pagamento> pagamentos = new ArrayList<>();
    private static final ArrayList<Frequencia> frequencias = new ArrayList<>();

    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }

    public static void mostrarMenuPrincipal() {
        while (true) {
            limparTela();
            System.out.println("1. Cadastrar novo aluno");
            System.out.println("2. Exibir alunos");
            System.out.println("3. Registrar presença");
            System.out.println("4. Cadastrar produto");
            System.out.println("5. Exibir produtos");
            System.out.println("6. Vender produto");
            System.out.println("7. Registrar pagamento");
            System.out.println("8. Exibir pagamentos");
            System.out.println("9. Relatório de frequência");
            System.out.println("10. Relatório de pagamentos");
            System.out.println("11. Buscar aluno");
            System.out.println("12. Buscar produto");
            System.out.println("13. Excluir aluno");
            System.out.println("14. Relatório Detalhado de Alunos");
            System.out.println("15. Relatório Detalhado de Produtos");
            System.out.println("16. Relatório de Alunos com Mensalidades Atrasadas");
            System.out.println("17. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarAluno();
                    break;
                case "2":
                    relatorioDetalhadoAlunos();
                    break;
                case "3":
                    registrarPresenca();
                    break;
                case "4":
                    cadastrarProduto();
                    break;
                case "5":
                    relatorioDetalhadoProdutos();
                    break;
                case "6":
                    venderProduto();
                    break;
                case "7":
                    registrarPagamento();
                    break;
                case "8":
                    relatorioPagamentos();
                    break;
                case "9":
                    relatorioFrequencia();
                    break;
                case "10":
                    relatorioPagamentos();
                    break;
                case "11":
                    System.out.print("Parte do nome do aluno: ");
                    String nomeAluno = scanner.nextLine();
                    buscarAluno(nomeAluno);
                    break;
                case "12":
                    System.out.print("Parte do nome do produto: ");
                    String nomeProduto = scanner.nextLine();
                    buscarProduto(nomeProduto);
                    break;
                case "13":
                    excluirAluno();
                    break;
                case "14":
                    relatorioDetalhadoAlunos();
                    break;
                case "15":
                    relatorioDetalhadoProdutos();
                    break;
                case "16":
                    relatorioAlunosAtrasados();
                    break;
                case "17":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void venderProduto() {
    }

    private static void limparTela() {
        // Limpar a tela (no console)
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Implementação das funções relacionadas a alunos
    public static void cadastrarAluno() {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Faixa: ");
        String faixa = scanner.nextLine();
        System.out.print("Mensalidade paga? (1 para Sim, 0 para Não): ");
        boolean mensalidade = scanner.nextLine().equals("1");
        System.out.print("Data de Nascimento (DD/MM/AAAA): ");
        String dataNascimento = scanner.nextLine();

        Aluno novoAluno = new Aluno(nome, idade, faixa, mensalidade, dataNascimento);
        alunos.add(novoAluno);
        System.out.println("Aluno " + nome + " cadastrado com sucesso!");
        pausarTela();
    }

    public static void buscarAluno(String nomeParcial) {
        ArrayList<Aluno> encontrados = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.getNome().toLowerCase().startsWith(nomeParcial.toLowerCase())) {
                encontrados.add(aluno);
            }
        }
        if (!encontrados.isEmpty()) {
            for (Aluno aluno : encontrados) {
                aluno.exibirInformacoes();
            }
        } else {
            System.out.println("Nenhum aluno encontrado com o nome começando por '" + nomeParcial + "'");
        }
        pausarTela();
    }

    public static void relatorioDetalhadoAlunos() {
        limparTela();
        System.out.println("Relatório Detalhado de Alunos");
        System.out.println("-".repeat(30));
        if (!alunos.isEmpty()) {
            for (Aluno aluno : alunos) {
                aluno.exibirInformacoes();
                System.out.println("-".repeat(30));
            }
        } else {
            System.out.println("Nenhum aluno cadastrado.");
        }
        pausarTela();
    }

    public static void excluirAluno() {
        System.out.print("Nome do aluno a ser excluído: ");
        String nome = scanner.nextLine();
        Aluno alunoEncontrado = null;
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                alunoEncontrado = aluno;
                break;
            }
        }
        if (alunoEncontrado != null) {
            alunos.remove(alunoEncontrado);
            System.out.println("Aluno " + alunoEncontrado.getNome() + " excluído com sucesso!");
        } else {
            System.out.println("Aluno '" + nome + "' não encontrado.");
        }
        pausarTela();
    }

    public static void pausarTela() {
        System.out.print("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    // Funções relacionadas a produtos, pagamentos e frequência podem ser implementadas aqui

    public static void cadastrarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Quantidade em estoque: ");
        int estoque = Integer.parseInt(scanner.nextLine());

        Produto novoProduto = new Produto(nome, preco, estoque);
        produtos.add(novoProduto);
        System.out.println("Produto " + nome + " cadastrado com sucesso!");
        pausarTela();
    }

    public static void buscarProduto(String nomeParcial) {
        ArrayList<Produto> encontrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().startsWith(nomeParcial.toLowerCase())) {
                encontrados.add(produto);
            }
        }
        if (!encontrados.isEmpty()) {
            for (Produto produto : encontrados) {
                produto.exibirInformacoes();
            }
        } else {
            System.out.println("Nenhum produto encontrado com o nome começando por '" + nomeParcial + "'");
        }
        pausarTela();
    }

    public static void relatorioDetalhadoProdutos() {
        limparTela();
        System.out.println("Relatório Detalhado de Produtos");
        System.out.println("-".repeat(30));
        if (!produtos.isEmpty()) {
            for (Produto produto : produtos) {
                produto.exibirInformacoes();
                System.out.println("-".repeat(30));
            }
        } else {
            System.out.println("Nenhum produto cadastrado.");
        }
        pausarTela();
    }

    public static void registrarPagamento() {
        System.out.print("Nome do aluno que efetuou o pagamento: ");
        String nome = scanner.nextLine();
        System.out.print("Valor pago: ");
        double valor = Double.parseDouble(scanner.nextLine());

        Aluno alunoEncontrado = null;
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                alunoEncontrado = aluno;
                break;
            }
        }

        if (alunoEncontrado != null) {
            Pagamento novoPagamento = new Pagamento(alunoEncontrado, valor);
            pagamentos.add(novoPagamento);
            alunoEncontrado.setMensalidade(true);
            System.out.println("Pagamento de R$" + valor + " registrado para " + nome + ".");
        } else {
            System.out.println("Aluno " + nome + " não encontrado.");
        }
        pausarTela();
    }

    public static void relatorioPagamentos() {
        limparTela();
        System.out.println("Relatório de Pagamentos");
        System.out.println("-".repeat(30));
        if (!pagamentos.isEmpty()) {
            for (Pagamento pagamento : pagamentos) {
                System.out.println("Nome: " + pagamento.getAluno().getNome());
                System.out.println("Data: " + pagamento.getData());
                System.out.println("Valor: R$" + pagamento.getValor());
                System.out.println("-".repeat(30));
            }
        } else {
            System.out.println("Nenhum pagamento registrado.");
        }
        pausarTela();
    }

    public static void registrarPresenca() {
        // Implementação para registrar presença
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        Aluno alunoEncontrado = null;
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                alunoEncontrado = aluno;
                break;
            }
        }
        if (alunoEncontrado != null) {
            Frequencia novaFrequencia = new Frequencia(alunoEncontrado);
            frequencias.add(novaFrequencia);
            System.out.println("Presença registrada para " + nome + ".");
        } else {
            System.out.println("Aluno " + nome + " não encontrado.");
        }
        pausarTela();
    }

    public static void relatorioFrequencia() {
        // Implementação para relatar frequência
        limparTela();
        System.out.println("Relatório de Frequência");
        System.out.println("-".repeat(30));
        if (!frequencias.isEmpty()) {
            for (Frequencia frequencia : frequencias) {
                System.out.println("Nome: " + frequencia.getAluno().getNome());
                System.out.println("Data: " + frequencia.getData());
                System.out.println("-".repeat(30));
            }
        } else {
            System.out.println("Nenhuma frequência registrada.");
        }
        pausarTela();
    }

    public static void relatorioAlunosAtrasados() {
        limparTela();
        System.out.println("Relatório de Alunos com Mensalidades Atrasadas");
        System.out.println("-".repeat(30));
        for (Aluno aluno : alunos) {
            if (!aluno.isMensalidade()) {
                aluno.exibirInformacoes();
                System.out.println("-".repeat(30));
            }
        }
        pausarTela();
    }
}
