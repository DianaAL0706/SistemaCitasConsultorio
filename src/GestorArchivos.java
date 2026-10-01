import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class GestorArchivos {

    public static void prepararArchivos() {

        File carpetaDb = new File("db");

        if (!carpetaDb.exists()) {
            carpetaDb.mkdir();
        }
        File archivoDoctores = new File(carpetaDb, "doctores.txt");
        File archivoPacientes = new File(carpetaDb, "pacientes.txt");
        File archivoCitas = new File(carpetaDb, "citas.txt");

        try {
            if (!archivoDoctores.exists()) {
                archivoDoctores.createNewFile();
            }

            if (!archivoPacientes.exists()) {
                archivoPacientes.createNewFile();
            }

            if (!archivoCitas.exists()) {
                archivoCitas.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error al crear los archivos de la base de datos.");
        }

    }
    public static void guardarDoctor(Doctor doctor) {

        try (FileWriter escritor = new FileWriter("db/doctores.txt", true)) {

            escritor.write(
                    doctor.getId() + "," +
                            doctor.getNombreCompleto() + "," +
                            doctor.getEspecialidad() +
                            System.lineSeparator()
            );

        } catch (IOException e) {
            System.out.println("Error al guardar la información del doctor.");
        }
    }
    public static void cargarDoctores(ArrayList<Doctor> doctores) {

        try (BufferedReader lector = new BufferedReader(
                new FileReader("db/doctores.txt"))) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length == 3) {
                    Doctor doctor = new Doctor(
                            datos[0],
                            datos[1],
                            datos[2]
                    );

                    doctores.add(doctor);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al cargar la información de los doctores.");
        }
    }
    public static void guardarPaciente(Paciente paciente) {

        try (FileWriter escritor = new FileWriter("db/pacientes.txt", true)) {

            escritor.write(
                    paciente.getId() + "," +
                            paciente.getNombreCompleto() +
                            System.lineSeparator()
            );

        } catch (IOException e) {
            System.out.println("Error al guardar la información del paciente.");
        }
    }
    public static void cargarPacientes(ArrayList<Paciente> pacientes) {

        try (BufferedReader lector = new BufferedReader(
                new FileReader("db/pacientes.txt"))) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length == 2) {
                    Paciente paciente = new Paciente(
                            datos[0],
                            datos[1]
                    );

                    pacientes.add(paciente);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al cargar la información de los pacientes.");
        }
    }
    public static void guardarCita(Cita cita) {

        try (FileWriter escritor = new FileWriter("db/citas.txt", true)) {

            escritor.write(
                    cita.getId() + "," +
                            cita.getFecha() + "," +
                            cita.getHora() + "," +
                            cita.getMotivo() + "," +
                            cita.getDoctor().getId() + "," +
                            cita.getPaciente().getId() +
                            System.lineSeparator()
            );

        } catch (IOException e) {
            System.out.println("Error al guardar la información de la cita.");
        }
    }
    public static void cargarCitas(ArrayList<Cita> citas,
                                   ArrayList<Doctor> doctores,
                                   ArrayList<Paciente> pacientes) {

        try (BufferedReader lector = new BufferedReader(
                new FileReader("db/citas.txt"))) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length == 6) {

                    Doctor doctorCita = null;
                    Paciente pacienteCita = null;

                    for (Doctor d : doctores) {
                        if (d.getId().equalsIgnoreCase(datos[4])) {
                            doctorCita = d;
                            break;
                        }
                    }

                    for (Paciente p : pacientes) {
                        if (p.getId().equalsIgnoreCase(datos[5])) {
                            pacienteCita = p;
                            break;
                        }
                    }

                    if (doctorCita != null && pacienteCita != null) {
                        Cita cita = new Cita(
                                datos[0],
                                datos[1],
                                datos[2],
                                datos[3],
                                doctorCita,
                                pacienteCita
                        );

                        citas.add(cita);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al cargar la información de las citas.");
        }
    }
}
