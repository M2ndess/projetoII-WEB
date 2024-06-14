package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "enchido", schema = "public", catalog = "proj2")
public class EnchidoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_enchido")
    private int idEnchido;
    @Basic
    @Column(name = "tipo_enchido")
    private String tipoEnchido;
    @Basic
    @Column(name = "custo_unitario")
    private double custoUnitario;
    @Basic
    @Column(name = "fase_producao")
    private String faseProducao;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "quantidade")
    private Integer quantidade;
    @Basic
    @Column(name = "id_lote")
    private Integer idLote;

    public int getIdEnchido() {
        return idEnchido;
    }

    public void setIdEnchido(int idEnchido) {
        this.idEnchido = idEnchido;
    }

    public String getTipoEnchido() {
        return tipoEnchido;
    }

    public void setTipoEnchido(String tipoEnchido) {
        this.tipoEnchido = tipoEnchido;
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(double custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    public String getFaseProducao() {
        return faseProducao;
    }

    public void setFaseProducao(String faseProducao) {
        this.faseProducao = faseProducao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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

        EnchidoEntity that = (EnchidoEntity) o;

        if (idEnchido != that.idEnchido) return false;
        if (Double.compare(that.custoUnitario, custoUnitario) != 0) return false;
        if (tipoEnchido != null ? !tipoEnchido.equals(that.tipoEnchido) : that.tipoEnchido != null) return false;
        if (faseProducao != null ? !faseProducao.equals(that.faseProducao) : that.faseProducao != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;
        if (quantidade != null ? !quantidade.equals(that.quantidade) : that.quantidade != null) return false;
        if (idLote != null ? !idLote.equals(that.idLote) : that.idLote != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idEnchido;
        result = 31 * result + (tipoEnchido != null ? tipoEnchido.hashCode() : 0);
        temp = Double.doubleToLongBits(custoUnitario);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (faseProducao != null ? faseProducao.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (quantidade != null ? quantidade.hashCode() : 0);
        result = 31 * result + (idLote != null ? idLote.hashCode() : 0);
        return result;
    }
}
