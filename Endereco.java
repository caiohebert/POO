import java.util.Objects;

public class Endereco {
    private String rua, cidade;
    private int numero, cep;
    private Estados estado;

    public Endereco(String rua, String cidade, String estado, int numero, int cep) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = Estados.valueOf(estado);
        this.numero = numero;
        this.cep = cep;
    }

    // Gets e Sets
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    // Métodos
    public void atualizaEndereco(String rua, String cidade, String estado, int numero, int cep){
        this.rua = rua;
        this.cidade = cidade;
        this.estado = Estados.valueOf(estado);
        this.numero = numero;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "rua: " + this.rua + '\'' + ", cidade: " + this.cidade + '\'' + ", estado: " + this.estado + '\'' + ", numero: " + this.numero + ", cep: " + this.cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco endereco)) return false;
        return getNumero() == endereco.getNumero() && getCep() == endereco.getCep() && Objects.equals(getRua(), endereco.getRua()) && Objects.equals(getCidade(), endereco.getCidade()) && estado == endereco.estado;
    }

}
