import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Alumno> alumnos;
    private List<Catedratico> catedraticos;
    private List<Curso> cursos;

    public Menu() {
        alumnos = new ArrayList<>();
        catedraticos = new ArrayList<>();
        cursos = new ArrayList<>();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Registrar Alumno");
            System.out.println("2. Registrar Catedrático");
            System.out.println("3. Inscribir Alumno en Curso");
            System.out.println("4. Asignar Curso a Catedrático");
            System.out.println("5. Mostrar Alumnos");
            System.out.println("6. Mostrar Catedráticos");
            System.out.println("7. Mostar Cursos");
            System.out.println("8. Crear Curso");
            System.out.println("9. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarAlumno(scanner);
                    break;
                case 2:
                    registrarCatedratico(scanner);
                    break;
                case 3:
                    inscribirAlumnoEnCurso(scanner);
                    break;
                case 4:
                    asignarCursoACatedratico(scanner);
                    break;
                case 5:
                    mostrarAlumnos();
                    break;
                case 6:
                    mostrarCatedraticos();
                    break;
                case 7:
                    mostrarCursos();
                    break;
                case 8:
                    crearCurso();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    private void registrarAlumno(Scanner scanner) {
        System.out.print("Nombre del Alumno: ");
        String nombre = scanner.nextLine();
        String id = GeneradorID.generarID();
        System.out.println("ID del Alumno: "+id);
        System.out.print("Carrera del Alumno: ");
        String carrera = scanner.nextLine();

        Alumno alumno = new Alumno(nombre, id, carrera);
        alumnos.add(alumno);
        System.out.println("Alumno registrado exitosamente.\n");
    }

    private void registrarCatedratico(Scanner scanner) {
        System.out.print("Nombre del Catedrático: ");
        String nombre = scanner.nextLine();
        String id = GeneradorID.generarID();
        System.out.println("ID del Catedrático: "+id);
        System.out.print("Profesion del Catedrático: ");
        String profesion = scanner.nextLine();

        Catedratico catedratico = new Catedratico(nombre, id, profesion);
        catedraticos.add(catedratico);
        System.out.println("Catedrático registrado exitosamente.\n");
    }

    private void inscribirAlumnoEnCurso(Scanner scanner) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
            return;
        }
        System.out.println("Lista de Alumnos:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + 1 + ". " + alumnos.get(i).getNombre());
        }
        System.out.print("Elige el número del Alumno: ");
        int numAlumno = scanner.nextInt() - 1;
        scanner.nextLine();


        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.\n");
            return;
        }

        System.out.println("Lista de cursos:");
        for (int i2 = 0; i2 < cursos.size(); i2++) {
            System.out.println(i2 + 1 + ". " + cursos.get(i2).getNombre());
        }

        System.out.print("Elige el número deL curso: ");
        int numCurso = scanner.nextInt() - 1;
        scanner.nextLine();
        String codigoCurso = cursos.get(numCurso).getCodigo();
        String nombreCurso = cursos.get(numCurso).getNombre();

        Curso curso = new Curso(nombreCurso, codigoCurso);
        alumnos.get(numAlumno).inscribirCurso(curso);

        /*System.out.print("Nombre del Curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("Código del Curso: ");
        String codigoCurso = scanner.nextLine();
        Curso curso = new Curso(nombreCurso, codigoCurso);
        alumnos.get(numAlumno).inscribirCurso(curso);
        cursos.add(curso);*/

    }
    
    private void crearCurso() {
        System.out.print("Nombre del Curso: ");
        Scanner scanner = new Scanner(System.in);
        String nombreCurso = scanner.nextLine();
        System.out.print("Código del Curso: ");
        String codigoCurso = GeneradorID.generarID();

        Curso curso = new Curso(nombreCurso, codigoCurso);
        cursos.add(curso);
    }

    private void asignarCursoACatedratico(Scanner scanner) {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
            return;
        }
        System.out.println("Lista de Catedráticos:");
        for (int i = 0; i < catedraticos.size(); i++) {
            System.out.println(i + 1 + ". " + catedraticos.get(i).getNombre());
        }
        System.out.print("Elige el número del Catedrático: ");
        int numCatedratico = scanner.nextInt() - 1;
        scanner.nextLine();

        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.\n");
            return;
        }

        System.out.println("Lista de cursos:");
        for (int i2 = 0; i2 < cursos.size(); i2++) {
            System.out.println(i2 + 1 + ". " + cursos.get(i2).getNombre());
        }

        System.out.print("Elige el número deL curso: ");
        int numCurso = scanner.nextInt() - 1;
        scanner.nextLine();
        String codigoCurso = cursos.get(numCurso).getCodigo();
        String nombreCurso = cursos.get(numCurso).getNombre();

        /*System.out.print("Nombre del Curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("Código del Curso: ");
        String codigoCurso = scanner.nextLine();*/

        Curso curso = new Curso(nombreCurso, codigoCurso);
        catedraticos.get(numCatedratico).asignarCurso(curso);
        //cursos.add(curso);
    }

    private void mostrarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
        } else {
            System.out.println("----- Lista de Alumnos -----");
            for (Alumno alumno : alumnos) {
                alumno.mostrarDetalles();
            }
            System.out.println();
        }
    }

    private void mostrarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.\n");
        } else {
            System.out.println("----- Lista de Cursos -----");
            for (Curso curso : cursos) {
                curso.mostrarDetalles();
            }
            System.out.println();
        }
    }


    private void mostrarCatedraticos() {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
        } else {
            System.out.println("----- Lista de Catedráticos -----");
            for (Catedratico catedratico : catedraticos) {
                catedratico.mostrarDetalles();
            }
            System.out.println();
        }
    }

}