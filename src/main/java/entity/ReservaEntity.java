package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "reserva")
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_recinto")
    private RecintoEntity recinto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pagamento")
    private PagamentoEntity pagamento;

    @Column(name = "hora_inicio")
    private Instant horaInicio;

    @Column(name = "hora_fim")
    private Instant horaFim;

    @Column(name = "estado_reserva", length = 50)
    private String estadoReserva;

    @Column(name = "data_reserva", nullable = false)
    private Instant dataReserva;

    public ReservaEntity() {
        // Empty constructor required by JPA
    }

    // Construtor com todos os parâmetros
    public ReservaEntity(Integer id, ClienteEntity cliente, RecintoEntity recinto, PagamentoEntity pagamento, Instant horaInicio, Instant horaFim, String estadoReserva, Instant dataReserva) {
        this.id = id;
        this.cliente = cliente;
        this.recinto = recinto;
        this.pagamento = pagamento;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.estadoReserva = estadoReserva;
        this.dataReserva = dataReserva;
    }

    // Construtor sem o ID da reserva (para novos objetos)
    public ReservaEntity(ClienteEntity cliente, RecintoEntity recinto, PagamentoEntity pagamento, Instant horaInicio, Instant horaFim, String estadoReserva, Instant dataReserva) {
        this.cliente = cliente;
        this.recinto = recinto;
        this.pagamento = pagamento;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.estadoReserva = estadoReserva;
        this.dataReserva = dataReserva;
    }

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

    public RecintoEntity getRecinto() {
        return recinto;
    }

    public void setRecinto(RecintoEntity recinto) {
        this.recinto = recinto;
    }

    public PagamentoEntity getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoEntity pagamento) {
        this.pagamento = pagamento;
    }

    public Instant getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Instant getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Instant horaFim) {
        this.horaFim = horaFim;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Instant getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Instant dataReserva) {
        this.dataReserva = dataReserva;
    }
}
