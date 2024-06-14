package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido_item", schema = "public", catalog = "proj2")
public class PedidoItemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_item")
    private int idItem;
    @Basic
    @Column(name = "id_pedido")
    private int idPedido;
    @Basic
    @Column(name = "quantidade")
    private int quantidade;
    @Basic
    @Column(name = "custo_unitário")
    private double custoUnitário;
    @Basic
    @Column(name = "id_lote")
    private Integer idLote;
    /*@ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", nullable = false)
    private PedidoClienteEntity pedidoClienteByIdPedido;
    @ManyToOne
    @JoinColumn(name = "id_lote", referencedColumnName = "id_lote")
    private LoteEntity loteByIdLote;*/

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getCustoUnitário() {
        return custoUnitário;
    }

    public void setCustoUnitário(double custoUnitário) {
        this.custoUnitário = custoUnitário;
    }

    public Integer getIdLote() {
        return idLote;
    }

    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidoItemEntity that = (PedidoItemEntity) o;

        if (idItem != that.idItem) return false;
        if (idPedido != that.idPedido) return false;
        if (quantidade != that.quantidade) return false;
        if (Double.compare(that.custoUnitário, custoUnitário) != 0) return false;
        if (idLote != null ? !idLote.equals(that.idLote) : that.idLote != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idItem;
        result = 31 * result + idPedido;
        result = 31 * result + quantidade;
        temp = Double.doubleToLongBits(custoUnitário);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (idLote != null ? idLote.hashCode() : 0);
        return result;
    }

    /*public PedidoClienteEntity getPedidoClienteByIdPedido() {
        return pedidoClienteByIdPedido;
    }

    public void setPedidoClienteByIdPedido(PedidoClienteEntity pedidoClienteByIdPedido) {
        this.pedidoClienteByIdPedido = pedidoClienteByIdPedido;
    }

    public LoteEntity getLoteByIdLote() {
        return loteByIdLote;
    }

    public void setLoteByIdLote(LoteEntity loteByIdLote) {
        this.loteByIdLote = loteByIdLote;
    }*/
}
