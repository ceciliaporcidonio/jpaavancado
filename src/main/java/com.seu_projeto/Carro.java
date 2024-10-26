package com.seu_projeto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false) // Relacionamento Many-to-One
    private Marca marca;

    @ManyToMany
    @JoinTable(name = "carro_acessorios",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id")) // Relacionamento Many-to-Many
    private List<Acessorio> acessorios;

    public Carro() {}

    public Carro(String modelo, Marca marca) {
        this.modelo = modelo;
        this.marca = marca;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
}
