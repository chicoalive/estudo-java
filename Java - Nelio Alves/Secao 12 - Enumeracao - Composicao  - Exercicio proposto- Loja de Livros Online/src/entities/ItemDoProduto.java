package entities;

public class ItemDoProduto {
    private Integer quantidade;

    // Associação
    private Produto produto;

    // Constructor
    public ItemDoProduto(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    // Getter e Setter
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    // Métodos
    public Double subTotal() {
        return quantidade * produto.getPreco();
    }
}
