public abstract class Entregador implements Entregavel {

    private int id;
    private String nome;
    private String veiculo;

    public Entregador(int id, String nome, String veiculo) {
        this.id = id;
        this.nome = nome;
        this.veiculo = veiculo;
    }

    public void mostrarDados() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Veículo: " + veiculo);
    }

    public abstract double calcularCusto(double distancia);

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getVeiculo() {
        return veiculo;
    }
}