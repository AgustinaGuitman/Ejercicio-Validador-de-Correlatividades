package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private String legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String legajo) {
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }
    public boolean estaAprobada(Materia materia) {
        return materiasAprobadas.contains(materia);
    }
    public void agregarMateriaAprobada(Materia ... materias) {
        Collections.addAll(this.materiasAprobadas, materias);
    }
}
