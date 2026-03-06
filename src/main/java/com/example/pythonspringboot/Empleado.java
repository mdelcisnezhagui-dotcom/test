
package com.example.pythonspringboot;
import jakarta.persistence.*;
//archivo que  define el molde de un empleado, solo la estructura

//permite crear la tabla empleados en la base de datos
@Entity
//se envía el nombre de la tabla a crearse en postgreSQL
@Table(name = "empleados")
public class Empleado {

    //se indica la llave primaria de la tabla
    @Id
    //indica la generación automática del id en la base
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String cargo;
    private String departamento;

        //constructor vacio necesario para recibir JSON y poder crear un empleado
        public Empleado() {}

        // Constructor
        public Empleado(String nombre, String cargo, String departamento) {
            this.nombre = nombre;
            this.cargo = cargo;
            this.departamento = departamento;
        }

        // Getters
        public Long getId() { return id; }
        public String getNombre() { return nombre; }
        public String getCargo() { return cargo; }
        public String getDepartamento() { return departamento; }

        // Setters — necesarios para que Spring llene los campos del JSON
        public void setId(Long id) { this.id = id; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public void setCargo(String cargo) { this.cargo = cargo; }
        public void setDepartamento(String departamento) { this.departamento = departamento; }
}
