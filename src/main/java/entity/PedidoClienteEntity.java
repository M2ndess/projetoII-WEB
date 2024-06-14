package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "pedido_cliente", schema = "public", catalog = "proj2")
public class PedidoClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_pedido")
    private int idPedido;
    @Basic
    @Column(name = "id_cliente")
    private int idCliente;
    @Basic
    @Column(name = "id_entrega")
    private int idEntrega;
    @Basic
    @Column(name = "data_pedido")
    private Date dataPedido;
    @Basic
    @Column(name = "estado_pedido")
    private String estadoPedido;
    @Basic
    @Column(name = "preco_liquido")
    private Double precoLiquido;
    @Basic
    @Column(name = "taxa")
    private Double taxa;
    /*@ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
    private ClienteEntity clienteByIdCliente;
    @ManyToOne
    @JoinColumn(name = "id_entrega", referencedColumnName = "id_entrega", nullable = false)
    private EntregaEntity entregaByIdEntrega;*/

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Double getPrecoLiquido() {
        return precoLiquido;
    }

    public void setPrecoLiquido(Double precoLiquido) {
        this.precoLiquido = precoLiquido;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidoClienteEntity that = (PedidoClienteEntity) o;

        if (idPedido != that.idPedido) return false;
        if (idCliente != that.idCliente) return false;
        if (idEntrega != that.idEntrega) return false;
        if (dataPedido != null ? !dataPedido.equals(that.dataPedido) : that.dataPedido != null) return false;
        if (estadoPedido != null ? !estadoPedido.equals(that.estadoPedido) : that.estadoPedido != null) return false;
        if (precoLiquido != null ? !precoLiquido.equals(that.precoLiquido) : that.precoLiquido != null) return false;
        if (taxa != null ? !taxa.equals(that.taxa) : that.taxa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPedido;
        result = 31 * result + idCliente;
        result = 31 * result + idEntrega;
        result = 31 * result + (dataPedido != null ? dataPedido.hashCode() : 0);
        result = 31 * result + (estadoPedido != null ? estadoPedido.hashCode() : 0);
        result = 31 * result + (precoLiquido != null ? precoLiquido.hashCode() : 0);
        result = 31 * result + (taxa != null ? taxa.hashCode() : 0);
        return result;
    }

    /*public ClienteEntity getClienteByIdCliente() {
        return clienteByIdCliente;
    }

    public void setClienteByIdCliente(ClienteEntity clienteByIdCliente) {
        this.clienteByIdCliente = clienteByIdCliente;
    }

    public EntregaEntity getEntregaByIdEntrega() {
        return entregaByIdEntrega;
    }

    public void setEntregaByIdEntrega(EntregaEntity entregaByIdEntrega) {
        this.entregaByIdEntrega = entregaByIdEntrega;
    }*/
}
