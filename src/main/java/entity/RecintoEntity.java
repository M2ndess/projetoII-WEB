package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "recinto")
public class RecintoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recinto", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_recinto")
    private TipoRecintoEntity idTipoRecinto;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "morada", nullable = false)
    private String morada;

    @Column(name = "horario_funcionamento", length = 100)
    private String horarioFuncionamento;

    @Lob
    @Column(name = "info_extra")
    private String infoExtra;

    @Column(name = "estado_recinto", length = 50)
    private String estadoRecinto;

    @Column(name = "preco_hora")
    private BigDecimal precoHora;

    public RecintoEntity() {
        // Empty constructor required by JPA
    }

    // Construtor com todos os parâmetros
    public RecintoEntity(Integer id, ClienteEntity cliente, TipoRecintoEntity idTipoRecinto, String nome, String morada, String horarioFuncionamento, String infoExtra, String estadoRecinto, BigDecimal precoHora) {
        this.id = id;
        this.cliente = cliente;
        this.idTipoRecinto = idTipoRecinto;
        this.nome = nome;
        this.morada = morada;
        this.horarioFuncionamento = horarioFuncionamento;
        this.infoExtra = infoExtra;
        this.estadoRecinto = estadoRecinto;
        this.precoHora = precoHora;
    }

    // Construtor sem o ID
    public RecintoEntity(ClienteEntity cliente, TipoRecintoEntity idTipoRecinto, String nome, String morada, String horarioFuncionamento, String infoExtra, String estadoRecinto, BigDecimal precoHora) {
        this.cliente = cliente;
        this.idTipoRecinto = idTipoRecinto;
        this.nome = nome;
        this.morada = morada;
        this.horarioFuncionamento = horarioFuncionamento;
        this.infoExtra = infoExtra;
        this.estadoRecinto = estadoRecinto;
        this.precoHora = precoHora;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public TipoRecintoEntity getIdTipoRecinto() {
        return idTipoRecinto;
    }

    public void setIdTipoRecinto(TipoRecintoEntity idTipoRecinto) {
        this.idTipoRecinto = idTipoRecinto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getInfoExtra() {
        return infoExtra;
    }

    public void setInfoExtra(String infoExtra) {
        this.infoExtra = infoExtra;
    }

    public String getEstadoRecinto() {
        return estadoRecinto;
    }

    public void setEstadoRecinto(String estadoRecinto) {
        this.estadoRecinto = estadoRecinto;
    }

    public BigDecimal getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(BigDecimal precoHora) {
        this.precoHora = precoHora;
    }
}
