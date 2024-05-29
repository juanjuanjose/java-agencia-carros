class Cliente {
    int codigo;
    String dni;
    String nombre;
    String direccion;
    String telefono;
    Cliente clienteAval;

    public Cliente(int codigo, String dni, String nombre, String direccion, String telefono, Cliente clienteAval) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.clienteAval = clienteAval;
    }

    public String getDetallesCliente() {
        return "Codigo: " + codigo + ", Nombre: " + nombre + ", DNI: " + dni + ", Dirección: " + direccion + ", Teléfono: " + telefono +
                (clienteAval != null ? ", Avalado por: " + clienteAval.nombre : "");
    }
}
