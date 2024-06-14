package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "transportadora", schema = "public", catalog = "proj2")
public class TransportadoraEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_transportadora")
    private int idTransportadora;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "contacto")
    private String contacto;
    @Basic
    @Column(name = "morada")
    private String morada;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "website")
    private String website;
    /*@OneToMany(mappedBy = "transportadoraByIdTransportadora")
    private Collection<EntregaEntity> entregasByIdTransportadora;*/

    public int getIdTransportadora() {
        return idTransportadora;
    }

    public void setIdTransportadora(int idTransportadora) {
        this.idTransportadora = idTransportadora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransportadoraEntity that = (TransportadoraEntity) o;

        if (idTransportadora != that.idTransportadora) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (contacto != null ? !contacto.equals(that.contacto) : that.contacto != null) return false;
        if (morada != null ? !morada.equals(that.morada) : that.morada != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTransportadora;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (contacto != null ? contacto.hashCode() : 0);
        result = 31 * result + (morada != null ? morada.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        return result;
    }

    /*public Collection<EntregaEntity> getEntregasByIdTransportadora() {
        return entregasByIdTransportadora;
    }

    public void setEntregasByIdTransportadora(Collection<EntregaEntity> entregasByIdTransportadora) {
        this.entregasByIdTransportadora = entregasByIdTransportadora;
    }*/
}
