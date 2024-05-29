import java.util.Date;
import java.util.List;

class Reserva {
    Cliente cliente;
    List<Coche> coches;
    Date fechaInicio;
    Date fechaFin;
    double precioTotal;
    boolean entregado;

    public Reserva(Cliente cliente, List<Coche> coches, Date fechaInicio, Date fechaFin, double precioTotal, boolean entregado) {
        this.cliente = cliente;
        this.coches = coches;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = precioTotal;
        this.entregado = entregado;
    }

    public double calcularPrecioTotal() {
        return precioTotal; // Placeholder para la lógica de cálculo
    }

    public String getDetallesReserva() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Cliente: ").append(cliente.nombre)
                .append(", Fecha Inicio: ").append(fechaInicio)
                .append(", Fecha Fin: ").append(fechaFin)
                .append(", Precio Total: ").append(precioTotal)
                .append(", Entregado: ").append(entregado ? "Sí" : "No")
                .append(", Coches: ");
        for (Coche coche : coches) {
            detalles.append(coche.modelo).append(" ");
        }
        return detalles.toString();
    }
}
