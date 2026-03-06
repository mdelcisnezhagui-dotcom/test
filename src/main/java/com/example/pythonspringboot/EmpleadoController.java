package com.example.pythonspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
//Aqui se crear el MICROSERVICIO
@RestController //esta clase recibe peticiones HTTP y responde un JSON
@RequestMapping("/empleados")//todas las rutas de esta clase empiezan con /empleados
public class EmpleadoController {

    //permite usar el repositorio directamente
    @Autowired
    private EmpleadoRepository repository;

    // GET /empleados → devuelve todos desde postgreSQL
    @GetMapping
                                                            //trae todo los empleados de postgreSQL
    public List<Empleado> obtenerTodos() {
        return repository.findAll();
    }

    // GET /empleados/1 → devuelve uno por id
    @GetMapping("/{id}") //este método responde cada vez que alguien hace get
                                //ayuda a captura el id del empleado, por ejemplo el id 1: /empleados/1
    public Empleado obtenerPorId(@PathVariable Long id) {
        Optional<Empleado> empleado = repository.findById(id);
        return empleado.orElse(null);
    }


    // POST /empleados → crea un empleado nuevo
    @PostMapping //responde cuando alguien hace post a /empleados
                                //esta notación le dice a spring que los datos del empleado vienen en el cuerpo de la petición en JSON
    public Empleado crearEmpleado(@RequestBody Empleado nuevoEmpleado) {
                        //inserta o actualiza en postgreSQL
        return repository.save(nuevoEmpleado);
    }

    // DELETE /empleados/1
    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable Long id) {
        repository.deleteById(id);
    }
}