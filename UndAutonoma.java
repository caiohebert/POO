public class UndAutonoma extends Imovel {
    private float areautil;
    private float areaconstruida;

    public UndAutonoma(String iptu, String tipo, String utilizacao, String rua, String cidade, String estado, int numero, int cep, float areautil, float areaconstruida) {
        super(iptu, tipo, utilizacao, rua, cidade, estado, numero, cep);
        this.areautil = areautil;
        this.areaconstruida = areaconstruida;
    }

    // GETS E SETS
    public float getAreautil() {
        return areautil;
    }

    public void setAreautil(float areautil) {
        this.areautil = areautil;
    }

    public float getAreaconstruida() {
        return areaconstruida;
    }

    public void setAreaconstruida(float areaconstruida) {
        this.areaconstruida = areaconstruida;
    }

    // MÉTODOS
    @Override
    public float calculaReferencia() {
        float valor = this.getAreaconstruida() * 15f;
        return valor;
    }
}
