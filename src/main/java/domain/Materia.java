package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }
    public boolean cumpleCorrelativas(Alumno alumno) {
        return correlativas.stream().allMatch(m-> alumno.estaAprobada(m));
    } //correlativas.stream().allMatch(alumno::estaAprobada);

    public void agregarCorrelativa(Materia ... materias) {
        Collections.addAll(this.correlativas, materias);
    }
}
