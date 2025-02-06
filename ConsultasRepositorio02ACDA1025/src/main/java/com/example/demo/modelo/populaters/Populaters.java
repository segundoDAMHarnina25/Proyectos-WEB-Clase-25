package com.example.demo.modelo.populaters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.example.demo.modelo.entities.Persona;
import com.example.demo.modelo.repositories.PersonaRepository;

import jakarta.annotation.PostConstruct;

@Component
@ConditionalOnProperty(name = "spring.jpa.hibernate.ddl-auto", havingValue = "create", matchIfMissing = false)
public class Populaters {
    private final PersonaRepository personaRepository;

    public Populaters(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @PostConstruct
    public void populate() {
        List<String> nombres = List.of(
            "Juan", "María", "Carlos", "Ana", "Pedro", "Lucía", "Luis", "Sofía", "José", "Laura",
            "Miguel", "Carmen", "Raúl", "Elena", "Diego", "Clara", "Antonio", "Isabel", "Francisco", "Marta",
            "David", "Sandra", "Daniel", "Patricia", "Iván", "Beatriz", "Alberto", "Teresa", "Manuel", "Cristina",
            "Fernando", "Paula", "Alejandro", "Rosa", "Jorge", "Natalia", "Ricardo", "Victoria", "Andrés", "Silvia",
            "Esteban", "Eva", "Roberto", "Gloria", "Hugo", "Noelia", "Ramón", "Bárbara", "Óscar", "Adriana",
            "Enrique", "Lidia", "Pablo", "Amelia", "Eduardo", "Miriam", "Gonzalo", "Lorena", "Jaime", "Raquel",
            "Sergio", "Helena", "Álvaro", "Elsa", "Marcos", "Irene", "Víctor", "Alicia", "Julián", "Diana",
            "Emilio", "Leticia", "Gabriel", "Marina", "Salvador", "Vanesa", "Félix", "Nerea", "Eugenio", "Esther",
            "Rubén", "Mercedes", "Julio", "Sara", "Tomás", "Bea", "Ernesto", "Rocío", "Bruno", "Andrea"
        );

        List<String> apellidos = List.of(
            "García", "Fernández", "González", "Rodríguez", "López", "Martínez", "Sánchez", "Pérez", "Gómez", "Jiménez",
            "Ruiz", "Hernández", "Díaz", "Moreno", "Álvarez", "Muñoz", "Romero", "Alonso", "Gutiérrez", "Navarro"
        );

        List<Persona> personas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String nombre = nombres.get(i % nombres.size());
            String apellido = apellidos.get(i % apellidos.size()) + " " + apellidos.get((i + 1) % apellidos.size());
            int edad = 18 + (i % 50);
            int numeroSocio = i + 1;
            personas.add(new Persona(nombre, apellido, edad, numeroSocio));
        }

        personaRepository.saveAll(personas);
    }
}
