public class Main {

    public static void main(String[] args) {

        // Crear administrador
        Administrador administrador =
                new Administrador("admin", "1234");

        // Validar acceso
        if (administrador.validarAcceso("admin", "1234")) {
            System.out.println("Acceso correcto.");

            // Crear doctor
            Doctor doctor = new Doctor(
                    "D001",
                    "Laura Martínez",
                    "Medicina General"
            );

            // Crear paciente
            Paciente paciente = new Paciente(
                    "P001",
                    "Carlos Hernández"
            );

            // Crear cita y relacionarla con doctor y paciente
            Cita cita = new Cita(
                    "C001",
                    "20/09/2026",
                    "10:00",
                    "Consulta general",
                    doctor,
                    paciente
            );

            // Mostrar información de la cita
            System.out.println("Cita registrada correctamente.");
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