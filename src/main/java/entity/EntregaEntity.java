package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "entrega", schema = "public", catalog = "proj2")
public class EntregaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_entrega")
    private int idEntrega;
    @Basic
    @Column(name = "id_transportadora")
    private int idTransportadora;
    @Basic
    @Column(name = "data_entrega")
    private Date dataEntrega;

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public int getIdTransportadora() {
        return idTransportadora;
    }

    public void setIdTransportadora(int idTransportadora) {
        this.idTransportadora = idTransportadora;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntregaEntity that = (EntregaEntity) o;

        if (idEntrega != that.idEntrega) return false;
        if (idTransportadora != that.idTransportadora) return false;
        if (dataEntrega != null ? !dataEntrega.equals(that.dataEntrega) : that.dataEntrega != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEntrega;
        result = 31 * result + idTransportadora;
        result = 31 * result + (dataEntrega != null ? dataEntrega.hashCode() : 0);
        return result;
    }
}
