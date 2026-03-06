package com.example.pythonspringboot;
//clase para guardar datos iniciales en la base de datos

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmpleadoRepository repository;

    @Override
    public void run(String... args) {
        // Solo carga datos si la tabla está vacía
        if (repository.count() == 0) {
            repository.save(new Empleado("María García", "Docente", "Sistemas"));
            repository.save(new Empleado("Carlos López", "Administrativo", "RRHH"));
            repository.save(new Empleado("Ana Torres", "Directora", "Talento Humano"));
            System.out.println("Datos iniciales cargados.");
        }
    }
}