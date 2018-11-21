package br.com.partners.bean;


/**
 * Classe bean reponsavel para pegar atributos pdf e passar para xml
 *
 */
public class Pedido {

    private String cliente;

    private String cnpj;

    private String pedido;

    private String descricaoPedido;

    public Pedido(String cliente, String cnpj, String pedido, String descricaoPedido) {
        this.cliente = cliente;
        this.cnpj = cnpj;
        this.pedido = pedido;
        this.descricaoPedido = descricaoPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }
}
