public class EntregadorBicicleta extends Entregador {

    public EntregadorBicicleta(int id, String nome) {
        super(id, nome, "Bicicleta");
    }

    @Override
    public double calcularTempo(double distancia) {
        return distancia / 15 * 60;
    }

    @Override
    public double calcularCusto(double distancia) {
        return 4 + distancia * 1.5;
    }
}