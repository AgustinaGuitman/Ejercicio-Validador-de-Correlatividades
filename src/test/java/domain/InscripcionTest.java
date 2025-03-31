package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InscripcionTest {

    Materia analisis1 = new Materia("AM1");
    Materia aga = new Materia("AGA");
    Materia analisis2 = new Materia("AM2");
    Materia matSuperior = new Materia("Matematica Superior");
    Materia fisica = new Materia("Fisica1");

    @Test
    @DisplayName("Un alumno con 0 materias aprobadas se puede inscribir a AM1")

    public void inscribirAM1Con0MateriasAprobadas() {
        Alumno alumno = new Alumno("177.230-8");
        Inscripcion inscripcion = new Inscripcion(alumno);

        inscripcion.agregarMateria(analisis1);

        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Un alumno con AM1 y AGA aprobadas se puede inscribir a AM2")
    public void inscribirAM2ConAM1yAGAAprobadas() {
        Alumno alumno2 = new Alumno("177.230-8");
        Inscripcion inscripcion2 = new Inscripcion(alumno2);

        alumno2.agregarMateriaAprobada(analisis1);
        alumno2.agregarMateriaAprobada(aga);
        analisis2.agregarCorrelativa(analisis1);
        analisis2.agregarCorrelativa(aga);
        inscripcion2.agregarMateria(analisis2);

        Assertions.assertTrue(inscripcion2.aprobada());
    }
    @Test
    @DisplayName("Un alumno con AM1 aprobada no se puede inscribir a AM2")
    public void inscribirAM2ConAM1Aprobada() {
        Alumno alumno3 = new Alumno("177.230-8");
        Inscripcion inscripcion3 = new Inscripcion(alumno3);

        alumno3.agregarMateriaAprobada(analisis1);
        analisis2.agregarCorrelativa(analisis1);
        analisis2.agregarCorrelativa(aga);
        inscripcion3.agregarMateria(analisis2);

        Assertions.assertFalse(inscripcion3.aprobada());
    }

    @Test
    @DisplayName("Un alumno con AM1, AM2 y AGA aprobadas se puede inscribir a Mat Superior y Fisica")
    public void sePuedeInscribirMatSuperiorYFisica() {
        Alumno alumno4 = new Alumno("177.230-8");
        Inscripcion inscripcion4 = new Inscripcion(alumno4);

        alumno4.agregarMateriaAprobada(analisis1);
        alumno4.agregarMateriaAprobada(aga);
        alumno4.agregarMateriaAprobada(analisis2);
        analisis2.agregarCorrelativa(analisis1);
        analisis2.agregarCorrelativa(aga);
        matSuperior.agregarCorrelativa(analisis2);
        matSuperior.agregarCorrelativa(aga);
        matSuperior.agregarCorrelativa(analisis1);

        inscripcion4.agregarMateria(matSuperior);
        inscripcion4.agregarMateria(fisica);

        Assertions.assertTrue(inscripcion4.aprobada());

    }
    @Test
    @DisplayName("Un alumno con AM1 y AM2 aprobadas no se puede inscribir a Mat Superior y Fisica")
    public void noSePuedeInscribirMatSuperiorYFisica() {
        Alumno alumno5 = new Alumno("177.230-8");
        Inscripcion inscripcion4 = new Inscripcion(alumno5);

        alumno5.agregarMateriaAprobada(analisis1);
        alumno5.agregarMateriaAprobada(analisis2);
        analisis2.agregarCorrelativa(analisis1);
        analisis2.agregarCorrelativa(aga);
        matSuperior.agregarCorrelativa(analisis2);
        matSuperior.agregarCorrelativa(aga);
        matSuperior.agregarCorrelativa(analisis1);

        inscripcion4.agregarMateria(matSuperior);
        inscripcion4.agregarMateria(fisica);

        Assertions.assertFalse(inscripcion4.aprobada());

    }
}
