package com.example.pythonspringboot;
import jakarta.persistence.*;

@Entity
@Table(name = "permisos")
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String fecha;
    private String estado;
    private Long empleadoId;

    public Permiso() {}

    public Permiso(String tipo, String fecha, String estado, Long empleadoId) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.estado = estado;
        this.empleadoId = empleadoId;
    }

    // Getters
    public Long getId() { return id; }
    public String getTipo() { return tipo; }
    public String getFecha() { return fecha; }
    public String getEstado() { return estado; }
    public Long getEmpleadoId() { return empleadoId; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setEmpleadoId(Long empleadoId) { this.empleadoId = empleadoId; }
}
