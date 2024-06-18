package entity;

import java.time.Instant;
import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva", nullable = false)
    private Integer id;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "id_recinto")
    private Integer idRecinto;

    @Column(name = "id_pagamento")
    private Long idPagamento; // Alterado para Long para aceitar valores do tipo Long

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

    // Getters and setters omitted for brevity

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdRecinto() {
        return idRecinto;
    }

    public void setIdRecinto(Integer idRecinto) {
        this.idRecinto = idRecinto;
    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
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
