package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "lote", schema = "public", catalog = "proj2")
public class LoteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_lote")
    private int idLote;
    @Basic
    @Column(name = "id_funcionario")
    private int idFuncionario;
    @Basic
    @Column(name = "custo")
    private double custo;
    @Basic
    @Column(name = "data_criacao")
    private Date dataCriacao;
    @Basic
    @Column(name = "data_validade")
    private Date dataValidade;
    @Basic
    @Column(name = "estado_lote")
    private String estadoLote;
    /*@OneToMany(mappedBy = "loteByIdLote")
    private Collection<EnchidoEntity> enchidosByIdLote;
    @ManyToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario", nullable = false)
    private FuncionarioEntity funcionarioByIdFuncionario;*/

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getEstadoLote() {
        return estadoLote;
    }

    public void setEstadoLote(String estadoLote) {
        this.estadoLote = estadoLote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoteEntity that = (LoteEntity) o;

        if (idLote != that.idLote) return false;
        if (idFuncionario != that.idFuncionario) return false;
        if (Double.compare(that.custo, custo) != 0) return false;
        if (dataCriacao != null ? !dataCriacao.equals(that.dataCriacao) : that.dataCriacao != null) return false;
        if (dataValidade != null ? !dataValidade.equals(that.dataValidade) : that.dataValidade != null) return false;
        if (estadoLote != null ? !estadoLote.equals(that.estadoLote) : that.estadoLote != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idLote;
        result = 31 * result + idFuncionario;
        temp = Double.doubleToLongBits(custo);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
        result = 31 * result + (dataValidade != null ? dataValidade.hashCode() : 0);
        result = 31 * result + (estadoLote != null ? estadoLote.hashCode() : 0);
        return result;
    }

    /*public Collection<EnchidoEntity> getEnchidosByIdLote() {
        return enchidosByIdLote;
    }

    public void setEnchidosByIdLote(Collection<EnchidoEntity> enchidosByIdLote) {
        this.enchidosByIdLote = enchidosByIdLote;
    }

    public FuncionarioEntity getFuncionarioByIdFuncionario() {
        return funcionarioByIdFuncionario;
    }

    public void setFuncionarioByIdFuncionario(FuncionarioEntity funcionarioByIdFuncionario) {
        this.funcionarioByIdFuncionario = funcionarioByIdFuncionario;
    }*/
}
