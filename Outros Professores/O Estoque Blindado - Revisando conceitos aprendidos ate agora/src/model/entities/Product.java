package model.entities;

import model.exception.StockException;

public class Product {
    // Variables
    private String name;
    private Double price;
    private Integer quantityInStock;
    private Integer minimumQuantity;

    // Constructors
    public Product() {
    }

    public Product(String name, Double price, Integer quantityInStock, Integer minimumQuantity) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.minimumQuantity = minimumQuantity;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Integer minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }


    // Methods
    public void addQuantity(Integer quantity) {
        this.quantityInStock += quantity;
    }

    public void removeQuantity(Integer quantity) {
        // Se o que o usuário digitar for maior que o que tiver em estoque então lança o erro
        if (quantity > this.quantityInStock) {
            throw new StockException("Estoque insuficiente");
        }
        // Se o que tiver em estoque menos o que o usuário digitar for menor que o mínimo então lança o erro
        if (this.quantityInStock - quantity < this.minimumQuantity) {
            throw new StockException("A venda viola a politica de estoque mínimo da loja ");
        }
        this.quantityInStock -= quantity;
    }

    private Double total() {
        return price * quantityInStock;
    }
    // Returns

    @Override
    public String toString() {
        return "Produto: " + name + "\n"
                + "Preço: " + price + "\n"
                + "Estoque atual: " + quantityInStock + "\n"
                + "Total " + String.format("%.2f", total());

    }
}
