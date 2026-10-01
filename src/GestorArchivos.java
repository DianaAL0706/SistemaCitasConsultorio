import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

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
}
