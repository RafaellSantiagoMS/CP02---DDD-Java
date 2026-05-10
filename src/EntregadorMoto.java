public class EntregadorMoto extends Entregador {

    public EntregadorMoto(int id, String nome) {
        super(id, nome, "Moto");
    }

    @Override
    public double calcularTempo(double distancia) {
        return distancia / 40 * 60;
    }

    @Override
    public double calcularCusto(double distancia) {
        return 7 + distancia * 2;
    }
}