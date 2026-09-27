public abstract class Product implements Vendavel {

    private String nome;
    private double preco;
    private int quantidade;

    public Product(String nome, double preco, int quantidade)
            throws QuantidadeInvalidaException {

        if (preco < 0) {
            throw new QuantidadeInvalidaException(
                    "Preço não pode ser negativo."
            );
        }

        if (quantidade < 0) {
            throw new QuantidadeInvalidaException(
                    "Quantidade não pode ser negativa."
            );
        }

        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public abstract double calcularValorTotal();

    public String getDescricao() {
        return String.format(
                "Nome: %s | Preço: R$ %.2f | Quantidade: %d",
                nome, preco, quantidade
        );
    }

    @Override
    public void vender(int quantidadeDesejada)
            throws ProdutoIndisponivelException {

        if (quantidadeDesejada <= 0) {
            throw new ProdutoIndisponivelException(
                    "A quantidade da venda deve ser maior que zero."
            );
        }

        if (quantidadeDesejada > quantidade) {
            throw new ProdutoIndisponivelException(
                    "Produto indisponível. Estoque disponível: " + quantidade
            );
        }

        quantidade -= quantidadeDesejada;
    }

    public void aplicarDesconto(double percentual) {
        if (percentual < 0) {
            return;
        }

        if (percentual > 100) {
            percentual = 100;
        }

        preco -= preco * (percentual / 100.0);
    }

    public void aplicarDesconto(double percentual, double descontoMaximo) {
        if (percentual < 0) {
            return;
        }

        if (descontoMaximo < 0) {
            return;
        }

        double percentualAplicado = Math.min(percentual, descontoMaximo);
        aplicarDesconto(percentualAplicado);
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
