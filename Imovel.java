import java.time.LocalDate;
import java.util.Objects;

public abstract class Imovel{
    private String iptu;
    private String tipo, utilizacao;
    private Endereco endereco;
    private Agenda agenda;
    public Imovel(String iptu, String tipo, String utilizacao, String rua, String cidade, String estado, int numero, int cep){
        this.iptu = iptu;
        this.tipo = tipo;
        this.utilizacao = utilizacao;
        this.endereco = new Endereco(rua, cidade, estado, numero, cep);
        this.agenda = new Agenda();
    }

    // Gets e Sets
    public String getIptu() {
        return iptu;
    }

    public void setIptu(String iptu) {
        this.iptu = iptu;
    }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUtilizacao() { return utilizacao; }

    public void setUtilizacao(String utilizacao) { this.utilizacao = utilizacao; }

    public Endereco getEndereco() { return endereco; }


    // Métodos
    @Override
    public String toString() {
        return "Imovel{" + "iptu: " + iptu + "tipo: " + tipo + '\'' + "utilização" + utilizacao + '\'' + "endereco:" + this.endereco.toString() + '}';
    }

    public boolean alugar(LocalDate dataInicio, LocalDate dataFim){
        // se for true, conseguiu alugar o imóvel (tinha datas disponíveis)
        return this.agenda.alugar(dataInicio, dataFim);
    }

    public boolean bloquear(LocalDate dataInicio, LocalDate dataFim){
        // se for true, conseguiu bloquear o imóvel (tinha datas disponíveis)
        return this.agenda.bloquear(dataInicio, dataFim);
    }

    public boolean disponivel(LocalDate dataInicio, LocalDate dataFim){
        boolean valor = this.agenda.disponivel(dataInicio, dataFim);
        if (valor){
            return true;
        }
        return false;
    }

    public abstract float calculaReferencia();

}

