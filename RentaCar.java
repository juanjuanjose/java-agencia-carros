import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class RentaCar {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Coche> coches = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();
    private static List<Agencia> agencias = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Menu:");
            System.out.println("1. CRUD Agencia");
            System.out.println("2. CRUD Automóviles");
            System.out.println("3. CRUD Clientes");
            System.out.println("4. CRUD Reservas");
            System.out.println("5. Listar alquileres de un cliente");
            System.out.println("0. Salir");
            option = scanner.nextInt();
            switch(option) {
                case 1:
                    crudAgencia(scanner);
                    break;
                case 2:
                    crudCoche(scanner);
                    break;
                case 3:
                    crudCliente(scanner);
                    break;
                case 4:
                    crudReserva(scanner);
                    break;
                case 5:
                    listarAlquileresCliente(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while(option != 0);
        scanner.close();
    }

    private static void crudAgencia(Scanner scanner) {
        System.out.println("1. Crear Agencia");
        System.out.println("2. Leer Agencias");
        System.out.println("3. Actualizar Agencia");
        System.out.println("4. Eliminar Agencia");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch(option) {
            case 1:
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Dirección: ");
                String direccion = scanner.nextLine();
                System.out.print("Teléfono: ");
                String telefono = scanner.nextLine();
                agencias.add(new Agencia(nombre, direccion, telefono));
                break;
            case 2:
                for (Agencia agencia : agencias) {
                    System.out.println(agencia.getDetallesAgencia());
                }
                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void crudCoche(Scanner scanner) {
        System.out.println("1. Crear Coche");
        System.out.println("2. Leer Coches");
        System.out.println("3. Actualizar Coche");
        System.out.println("4. Eliminar Coche");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch(option) {
            case 1:
                System.out.print("Matrícula: ");
                String matricula = scanner.nextLine();
                System.out.print("Modelo: ");
                String modelo = scanner.nextLine();
                System.out.print("Color: ");
                String color = scanner.nextLine();
                System.out.print("Marca: ");
                String marca = scanner.nextLine();
                System.out.print("Garaje: ");
                String garaje = scanner.nextLine();
                coches.add(new Coche(matricula, modelo, color, marca, garaje));
                break;
            case 2:
                for (Coche coche : coches) {
                    System.out.println(coche.getDetallesCoche());
                }
                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void crudCliente(Scanner scanner) {
        System.out.println("1. Crear Cliente");
        System.out.println("2. Leer Clientes");
        System.out.println("3. Actualizar Cliente");
        System.out.println("4. Eliminar Cliente");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch(option) {
            case 1:
                System.out.print("Código: ");
                int codigo = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("DNI: ");
                String dni = scanner.nextLine();
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Dirección: ");
                String direccion = scanner.nextLine();
                System.out.print("Teléfono: ");
                String telefono = scanner.nextLine();
                Cliente clienteAval = null;
                clientes.add(new Cliente(codigo, dni, nombre, direccion, telefono, clienteAval));
                break;
            case 2:
                for (Cliente cliente : clientes) {
                    System.out.println(cliente.getDetallesCliente());
                }
                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void crudReserva(Scanner scanner) {
        
        System.out.println("1. Crear Reserva");
        System.out.println("2. Leer Reservas");
        System.out.println("3. Actualizar Reserva");
        System.out.println("4. Eliminar Reserva");
        int option = scanner.nextInt();
        scanner.nextLine(); 

        switch(option) {
            case 1:
                System.out.print("Código del cliente: ");
                int codigoCliente = scanner.nextInt();
                scanner.nextLine();
                Cliente cliente = clientes.stream().filter(c -> c.codigo == codigoCliente).findFirst().orElse(null);
                if (cliente == null) {
                    System.out.println("Cliente no encontrado.");
                    break;
                }
                System.out.print("Número de coches en la reserva: ");
                int numCoches = scanner.nextInt();
                scanner.nextLine();
                List<Coche> cochesReserva = new ArrayList<>();
                for (int i = 0; i < numCoches; i++) {
                    System.out.print("Matrícula del coche: ");
                    String matricula = scanner.nextLine();
                    Coche coche = coches.stream().filter(c -> c.matricula.equals(matricula)).findFirst().orElse(null);
                    if (coche != null) {
                        cochesReserva.add(coche);
                    } else {
                        System.out.println("Coche no encontrado.");
                    }
                }
                System.out.print("Fecha de inicio (dd/MM/yyyy): ");
                String fechaInicioStr = scanner.nextLine();
                System.out.print("Fecha de fin (dd/MM/yyyy): ");
                String fechaFinStr = scanner.nextLine();

                Date fechaInicio = new Date();
                Date fechaFin = new Date();
                System.out.print("Precio total: ");
                double precioTotal = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("¿Entregado? (true/false): ");
                boolean entregado = scanner.nextBoolean();
                reservas.add(new Reserva(cliente, cochesReserva, fechaInicio, fechaFin, precioTotal, entregado));
                break;
            case 2:
                for (Reserva reserva : reservas) {
                    System.out.println(reserva.getDetallesReserva());
                }
                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void listarAlquileresCliente(Scanner scanner) {
        System.out.print("Código del cliente: ");
        int codigoCliente = scanner.nextInt();
        Cliente cliente = clientes.stream().filter(c -> c.codigo == codigoCliente).findFirst().orElse(null);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        for (Reserva reserva : reservas) {
            if (reserva.cliente.codigo == codigoCliente) {
                System.out.println(reserva.getDetallesReserva());
            }
        }
    }
}
