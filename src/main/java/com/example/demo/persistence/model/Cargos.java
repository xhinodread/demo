package com.example.demo.persistence.model;


import jakarta.persistence.*;

/******
@Entity
public class Cargos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdCargo;
    @Column(nullable = false, unique = true)
    private String Cargo;

    @Column(nullable = false)
    private String FechaIngreso;

    @Column(nullable = false)
    private int CodUsuarioIngreso;

    public Cargos(){ super(); }

    public Cargos(String title, String author) {
        super();
        this.Cargo = Cargo;
        this.FechaIngreso = FechaIngreso;
        this.CodUsuarioIngreso = CodUsuarioIngreso;

    }

    public long getId() {
        return IdCargo;
    }
    public void setId(long IdCargo) {
        this.IdCargo = IdCargo;
    }

    public String getCargo() {
        return Cargo;
    }
    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }
    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public int getCodUsuarioIngreso() {
        return CodUsuarioIngreso;
    }
    public void setCodUsuarioIngreso(int CodUsuarioIngreso) {
        this.CodUsuarioIngreso = CodUsuarioIngreso;
    }

    @Override
    public String toString() {
        return "Cargo [id=" + IdCargo + ", Cargo=" + Cargo + ", FechaIngreso=" + FechaIngreso + "]";
    }


}
*****/