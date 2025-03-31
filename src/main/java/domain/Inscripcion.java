package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materias = new ArrayList<>();
    }

    // aprobada dice si el alumno se puede inscribir a todas las materias
    public boolean aprobada() {
        return materias.stream().allMatch(m -> m.cumpleCorrelativas(alumno));

    }

    public void agregarMateria(Materia ... materias) {
        Collections.addAll(this.materias, materias);
    }
}
