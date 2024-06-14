package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "materia_prima", schema = "public", catalog = "proj2")
public class MateriaPrimaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_materia_prima")
    private int idMateriaPrima;
    @Basic
    @Column(name = "id_fornecedor")
    private int idFornecedor;
    @Basic
    @Column(name = "tipo_materia_prima")
    private String tipoMateriaPrima;
    @Basic
    @Column(name = "custo_unitario")
    private double custoUnitario;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "quantidade")
    private Integer quantidade;
    @Basic
    @Column(name = "id_lote")
    private int idLote;
    /*@ManyToOne
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor", nullable = false)
    private FornecedorEntity fornecedorByIdFornecedor;
    @ManyToOne
    @JoinColumn(name = "id_lote", referencedColumnName = "id_lote", nullable = false)
    private LoteEntity loteByIdLote;*/

    public int getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(int idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getTipoMateriaPrima() {
        return tipoMateriaPrima;
    }

    public void setTipoMateriaPrima(String tipoMateriaPrima) {
        this.tipoMateriaPrima = tipoMateriaPrima;
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(double custoUnitario) {
        this.custoUnitario = custoUnitario;
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

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MateriaPrimaEntity that = (MateriaPrimaEntity) o;

        if (idMateriaPrima != that.idMateriaPrima) return false;
        if (idFornecedor != that.idFornecedor) return false;
        if (Double.compare(that.custoUnitario, custoUnitario) != 0) return false;
        if (idLote != that.idLote) return false;
        if (tipoMateriaPrima != null ? !tipoMateriaPrima.equals(that.tipoMateriaPrima) : that.tipoMateriaPrima != null)
            return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;
        if (quantidade != null ? !quantidade.equals(that.quantidade) : that.quantidade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idMateriaPrima;
        result = 31 * result + idFornecedor;
        result = 31 * result + (tipoMateriaPrima != null ? tipoMateriaPrima.hashCode() : 0);
        temp = Double.doubleToLongBits(custoUnitario);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (quantidade != null ? quantidade.hashCode() : 0);
        result = 31 * result + idLote;
        return result;
    }

    /*public FornecedorEntity getFornecedorByIdFornecedor() {
        return fornecedorByIdFornecedor;
    }

    public void setFornecedorByIdFornecedor(FornecedorEntity fornecedorByIdFornecedor) {
        this.fornecedorByIdFornecedor = fornecedorByIdFornecedor;
    }

    public LoteEntity getLoteByIdLote() {
        return loteByIdLote;
    }

    public void setLoteByIdLote(LoteEntity loteByIdLote) {
        this.loteByIdLote = loteByIdLote;
    }*/
}
