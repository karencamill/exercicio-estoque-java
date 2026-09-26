public class EstoqueApp {

    public static void main(String[] args) {

        Estoque estoque = new Estoque();

        try {
            ProdutoComum arroz = new ProdutoComum(
                    "Arroz", 25.00, 10
            );

            ProdutoComum feijao = new ProdutoComum(
                    "Feijão", 8.50, 20
            );

            ProdutoPerecivel leite = new ProdutoPerecivel(
                    "Leite", 6.00, 15, 10
            );

            ProdutoPerecivel iogurte = new ProdutoPerecivel(
                    "Iogurte", 5.00, 8, 2
            );

            estoque.adicionarProduto(arroz);
            estoque.adicionarProduto(feijao);
            estoque.adicionarProduto(leite);
            estoque.adicionarProduto(iogurte);

            System.out.println("===== PRODUTOS CADASTRADOS =====");
            estoque.listarProdutos();

            System.out.println();
            System.out.println("===== TESTE DE SOBRECARGA =====");

            arroz.aplicarDesconto(10);
            System.out.println("Arroz após 10% de desconto:");
            System.out.println(arroz.getDescricao());

            feijao.aplicarDesconto(20, 10);
            System.out.println("Feijão com desconto solicitado de 20%, limitado a 10%:");
            System.out.println(feijao.getDescricao());

        } catch (QuantidadeInvalidaException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }

        System.out.println();
        System.out.println("===== TESTE DE QUANTIDADE NEGATIVA =====");

        try {
            ProdutoComum produtoInvalido = new ProdutoComum(
                    "Produto Inválido", 10.00, -5
            );

            estoque.adicionarProduto(produtoInvalido);

        } catch (QuantidadeInvalidaException e) {
            System.out.println(
                    "QuantidadeInvalidaException capturada: "
                            + e.getMessage()
            );
        }

        System.out.println();
        System.out.println("===== TESTE DE VENDA =====");

        try {
            estoque.venderProduto(0, 3);

            System.out.println(
                    "Venda realizada com sucesso: 3 unidades do produto 0."
            );

        } catch (ProdutoIndisponivelException e) {
            System.out.println(
                    "ProdutoIndisponivelException capturada: "
                            + e.getMessage()
            );
        }

        System.out.println();
        System.out.println("Estoque após a venda:");
        estoque.listarProdutos();

        System.out.println();
        System.out.println("===== TESTE DE VENDA ACIMA DO ESTOQUE =====");

        try {
            estoque.venderProduto(0, 100);

        } catch (ProdutoIndisponivelException e) {
            System.out.println(
                    "ProdutoIndisponivelException capturada: "
                            + e.getMessage()
            );
        }

        System.out.println();
        System.out.println("===== VALOR TOTAL DO ESTOQUE =====");

        double valorTotal = estoque.calcularValorTotalEstoque();

        System.out.printf(
                "Valor total do estoque: R$ %.2f%n",
                valorTotal
        );

        System.out.println();
        System.out.println("Observação:");
        System.out.println(
                "O iogurte possui até 3 dias para vencer e, "
                        + "por isso, recebe 20% de desconto no cálculo."
        );
    }
}
