package entities;

import entities.enums.StatusDoPedido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Date dataPedido;
    private StatusDoPedido statusDoPedido;

    // Associação
    private Cliente cliente;

    // Composição
    List<ItemDoProduto> itens = new ArrayList<>();

    // Constructor
    public Pedido(Date dataPedido, StatusDoPedido statusDoPedido, Cliente cliente) {
        this.dataPedido = dataPedido;
        this.statusDoPedido = statusDoPedido;
        this.cliente = cliente;
    }

    // Getter e Setter
    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusDoPedido getStatusDoPedido() {
        return statusDoPedido;
    }

    public void setStatusDoPedido(StatusDoPedido statusDoPedido) {
        this.statusDoPedido = statusDoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Métodos
    public void addItem(ItemDoProduto produto) {
        itens.add(produto);
    }

    public void removeItem(ItemDoProduto produto) {
        itens.remove(produto);
    }
}
