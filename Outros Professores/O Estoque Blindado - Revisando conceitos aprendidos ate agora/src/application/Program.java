package application;

import model.entities.Product;
import model.exception.StockException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner keyboard = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        boolean isStockOperationValid = false;

        while (!isStockOperationValid) {
            try {
                System.out.print("Quantos produtos serão adicionados? ");
                int quantityToAdd = Integer.parseInt(keyboard.nextLine().trim());
                for (int i = 0; i < quantityToAdd; i++) {
                    System.out.println("Dados do produto " + (i + 1) + ":");
                    System.out.print("Nome: ");
                    String name = keyboard.nextLine().trim();
                    System.out.print("Preço unitário: ");
                    double price = Double.parseDouble(keyboard.nextLine().trim());
                    System.out.print("Quantidade em estoque: ");
                    int quantity = Integer.parseInt(keyboard.nextLine().trim());
                    System.out.print("Estoque minimo: ");
                    int minimumQuantity = Integer.parseInt(keyboard.nextLine().trim());
                    Product product = new Product(name, price, quantity, minimumQuantity);
                    productList.add(product);
                    System.out.println("Produto adicionado com sucesso!");
                    System.out.println();
                }
                isStockOperationValid = true;
            } catch (StockException e) {
                System.out.println("Erro de venda: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Erro na conversão de dados!");
            }
        }

        System.out.println("Dados do estoque: ");
        for (Product p : productList) {
            System.out.println(p);
        }

        isStockOperationValid = false;
        while (!isStockOperationValid) {
            try {
                System.out.print("Deseja vender algum produto (sim/não)? ");
                String answer = keyboard.nextLine().trim();
                if (answer.equalsIgnoreCase("sim")) {
                    System.out.print("Digite o nome do produto: ");
                    String productName = keyboard.nextLine().trim();
                    Product productToSell = null;
                    for (Product p : productList) {
                        if (p.getName().equalsIgnoreCase(productName)) {
                            productToSell = p;
                            break;
                        }
                    }

                    if (productToSell != null) {
                        System.out.print("Digite a quantidade para venda: ");
                        int quantityToSell = Integer.parseInt(keyboard.nextLine().trim());
                        productToSell.removeQuantity(quantityToSell);
                        System.out.println("Produto vendido com sucesso!");
                        System.out.println();
                    } else {
                        System.out.println("Produto não encontrado!");
                    }

                } else if (answer.equalsIgnoreCase("não")) {
                    isStockOperationValid = true;
                }
            } catch (StockException e) {
                System.out.println("Erro de venda: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Erro na conversão de dados!");
            }
        }

        System.out.println("Dados atualizados do estoque: ");
        for (Product p : productList) {
            System.out.println(p);
        }
        keyboard.close();
    }
}
