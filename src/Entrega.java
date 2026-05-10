public class Entrega {

    private int id;
    private String endereco;
    private double distancia;
    private String status;
    private Entregador entregador;

    public Entrega(int id, String endereco, double distancia) {
        this.id = id;
        this.endereco = endereco;
        this.distancia = distancia;
        this.status = "Pendente";
    }

    public void atribuirEntregador(Entregador entregador) {
        this.entregador = entregador;
        this.status = "Em rota";
        System.out.println("Entrega atribuída para " + entregador.getNome());
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }

    public void atualizarStatus(String status, String observacao) {
        this.status = status;
        System.out.println("Observação: " + observacao);
    }

    public void mostrarEntrega() {
        System.out.println("ID: " + id);
        System.out.println("Endereço: " + endereco);
        System.out.println("Distância: " + distancia + " km");
        System.out.println("Status: " + status);

        if (entregador != null) {
            System.out.println("Entregador: " + entregador.getNome());
            System.out.println("Veículo: " + entregador.getVeiculo());
            System.out.println("Tempo estimado: " + entregador.calcularTempo(distancia) + " minutos");
            System.out.println("Custo estimado: R$ " + entregador.calcularCusto(distancia));
        } else {
            System.out.println("Entregador: não atribuído");
        }
    }

    public int getId() {
        return id;
    }
}