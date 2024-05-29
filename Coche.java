class Coche {
    String matricula;
    String modelo;
    String color;
    String marca;
    String garaje;

    public Coche(String matricula, String modelo, String color, String marca, String garaje) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.garaje = garaje;
    }

    public String getDetallesCoche() {
        return "Matricula: " + matricula + ", Modelo: " + modelo + ", Color: " + color + ", Marca: " + marca + ", Garaje: " + garaje;
    }
}
