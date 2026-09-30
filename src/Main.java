import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Doctor> doctores = new ArrayList<>();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Cita> citas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Administrador administrador =
                new Administrador("admin", "1234");

        if (administrador.validarAcceso("admin", "1234")) {
            System.out.println("Acceso correcto.");

            Doctor doctor = new Doctor(
                    "D001",
                    "Laura Martínez",
                    "Medicina General"
            );
            doctores.add(doctor);

            String continuar;
            do{

            System.out.println("\nREGISTRO DE DOCTORES");

            System.out.print("Ingrese el ID del doctor: ");
            String idDoctor = scanner.nextLine();

            System.out.print("Ingrese el nombre completo: ");
            String nombreDoctor = scanner.nextLine();

            System.out.print("Ingrese la especialidad: ");
            String especialidadDoctor = scanner.nextLine();

            boolean existeDoctor = false;

            for (Doctor d : doctores) {
                if (d.getId().equalsIgnoreCase(idDoctor)) {
                    existeDoctor = true;
                    break;
                }
            }
            if (existeDoctor) {
                System.out.println("Error: ya existe un doctor con ese ID.");
            } else if (idDoctor.trim().isEmpty()
                    || nombreDoctor.trim().isEmpty()
                    || especialidadDoctor.trim().isEmpty()) {
                System.out.println("Error: todos los campos son obligatorios.");
            } else {
                Doctor nuevoDoctor = new Doctor(
                        idDoctor,
                        nombreDoctor,
                        especialidadDoctor
                );
                doctores.add(nuevoDoctor);
                System.out.println("Doctor registrado correctamente.");
            }

        System.out.print("\n¿Desea registrar otro doctor? (S/N): ");
        continuar = scanner.nextLine();

    } while (continuar.equalsIgnoreCase("S"));

                Paciente paciente = new Paciente(
                    "P001",
                    "Carlos Hernández"
            );
            pacientes.add(paciente);

            String continuarPaciente;

            do {
                System.out.println("\nREGISTRO DE PACIENTES");

                System.out.print("Ingrese el ID del paciente: ");
                String idPaciente = scanner.nextLine();

                System.out.print("Ingrese el nombre completo: ");
                String nombrePaciente = scanner.nextLine();
                boolean existePaciente = false;

                for (Paciente p : pacientes) {
                    if (p.getId().equalsIgnoreCase(idPaciente)) {
                        existePaciente = true;
                        break;
                    }
                }
                if (existePaciente) {
                    System.out.println("Error: ya existe un paciente con ese ID.");
                } else if (idPaciente.trim().isEmpty()
                        || nombrePaciente.trim().isEmpty()) {
                    System.out.println("Error: todos los campos son obligatorios.");
                } else {
                    Paciente nuevoPaciente = new Paciente(
                            idPaciente,
                            nombrePaciente
                    );

                    pacientes.add(nuevoPaciente);
                    System.out.println("Paciente registrado correctamente.");
                }

                System.out.print("\n¿Desea registrar otro paciente? (S/N): ");
                continuarPaciente = scanner.nextLine();

            } while (continuarPaciente.equalsIgnoreCase("S"));

            Cita cita = new Cita(
                    "C001",
                    "20/09/2026",
                    "10:00",
                    "Consulta general",
                    doctor,
                    paciente
            );
            citas.add(cita);

            String continuarCita;

            do {
                System.out.println("\nREGISTRO DE CITAS");

                System.out.print("Ingrese el ID de la cita: ");
                String idCita = scanner.nextLine();

                System.out.print("Ingrese la fecha: ");
                String fechaCita = scanner.nextLine();

                System.out.print("Ingrese la hora: ");
                String horaCita = scanner.nextLine();

                System.out.print("Ingrese el motivo: ");
                String motivoCita = scanner.nextLine();

                System.out.print("Ingrese el ID del doctor: ");
                String idDoctorCita = scanner.nextLine();

                System.out.print("Ingrese el ID del paciente: ");
                String idPacienteCita = scanner.nextLine();

                Doctor doctorCita = null;

                for (Doctor d : doctores) {
                    if (d.getId().equalsIgnoreCase(idDoctorCita)) {
                        doctorCita = d;
                        break;
                    }
                }
                Paciente pacienteCita = null;

                for (Paciente p : pacientes) {
                    if (p.getId().equalsIgnoreCase(idPacienteCita)) {
                        pacienteCita = p;
                        break;
                    }
                }
                boolean existeCita = false;

                for (Cita c : citas) {
                    if (c.getId().equalsIgnoreCase(idCita)) {
                        existeCita = true;
                        break;
                    }
                }
                if (existeCita) {
                    System.out.println("Error: ya existe una cita con ese ID.");
                } else if (idCita.trim().isEmpty()
                        || fechaCita.trim().isEmpty()
                        || horaCita.trim().isEmpty()
                        || motivoCita.trim().isEmpty()
                        || idDoctorCita.trim().isEmpty()
                        || idPacienteCita.trim().isEmpty()) {
                    System.out.println("Error: todos los campos son obligatorios.");
                } else if (doctorCita == null) {
                    System.out.println("Error: no existe un doctor con ese ID.");
                } else if (pacienteCita == null) {
                    System.out.println("Error: no existe un paciente con ese ID.");
                } else {
                    Cita nuevaCita = new Cita(
                            idCita,
                            fechaCita,
                            horaCita,
                            motivoCita,
                            doctorCita,
                            pacienteCita
                    );

                    citas.add(nuevaCita);
                    System.out.println("Cita registrada correctamente.");
                }
                System.out.print("\n¿Desea registrar otra cita? (S/N): ");
                continuarCita = scanner.nextLine();

            } while (continuarCita.equalsIgnoreCase("S"));

            System.out.println("ID de cita: " + cita.getId());
            System.out.println("Fecha: " + cita.getFecha());
            System.out.println("Hora: " + cita.getHora());
            System.out.println("Motivo: " + cita.getMotivo());
            System.out.println("Doctor: " +
                    cita.getDoctor().getNombreCompleto());
            System.out.println("Paciente: " +
                    cita.getPaciente().getNombreCompleto());
        } else {
            System.out.println("Identificador o contraseña incorrectos.");
        }
    }
}