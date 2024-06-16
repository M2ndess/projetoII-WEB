package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pagamento")
public class PagamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento", nullable = false)
    private Integer id;

    @Column(name = "metodo_pagamento", nullable = false, length = 100)
    private String metodoPagamento;

    @Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    public PagamentoEntity() {
        // Empty constructor required by JPA
    }

    // Construtor com todos os parâmetros
    public PagamentoEntity(Integer id, String metodoPagamento, BigDecimal valorTotal) {
        this.id = id;
        this.metodoPagamento = metodoPagamento;
        this.valorTotal = valorTotal;
    }

    // Construtor com todos os parâmetros exceto o ID
    public PagamentoEntity(String metodoPagamento, BigDecimal valorTotal) {
        this.metodoPagamento = metodoPagamento;
        this.valorTotal = valorTotal;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
