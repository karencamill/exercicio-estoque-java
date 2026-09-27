# Exercício de Implementação — Sistema de Estoque de Produtos

Projeto desenvolvido em Java conforme as especificações do exercício de avaliação.

## Conceitos utilizados

- Classes abstratas
- Herança
- Interfaces
- Polimorfismo dinâmico
- Sobrecarga de métodos (polimorfismo estático)
- Composição
- Exceções personalizadas
- `try/catch`
- `ArrayList`

## Classes

- `EstoqueException`
- `QuantidadeInvalidaException`
- `ProdutoIndisponivelException`
- `Vendavel`
- `Product`
- `ProdutoComum`
- `ProdutoPerecivel`
- `Estoque`
- `EstoqueApp`

## Como executar

1. Abra a pasta do projeto no IntelliJ IDEA.
2. Certifique-se de que todas as classes estão no mesmo diretório/pacote.
3. Execute a classe `EstoqueApp`.
4. O programa demonstrará:
   - Cadastro de produtos comuns e perecíveis;
   - Exceção para quantidade negativa;
   - Venda válida;
   - Tentativa de venda acima do estoque;
   - Sobrecarga do método `aplicarDesconto`;
   - Cálculo do valor total do estoque.

## Regras dos produtos perecíveis

Produtos perecíveis com `diasParaVencer <= 3` recebem automaticamente 20% de desconto no método `calcularValorTotal()`.

## GitHub

Exemplo de comandos:

```bash
git init
git add .
git commit -m "Implementa sistema de estoque"
git branch -M main
git remote add origin URL_DO_SEU_REPOSITORIO
git push -u origin main
```
