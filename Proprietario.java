import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.time.format.DateTimeFormatter;

public class Proprietario{
    private String nome, cpf, identidade;
    private Endereco endereco;
    private ArrayList<Imovel> seusImoveis;
    public Proprietario(String nome, String cpf, String identidade, String rua, String cidade, String estado, int numero, int cep){
        this.nome = nome;
        this.cpf = cpf;
        this.identidade = identidade;
        // Agregação forte
        this.endereco = new Endereco(rua, cidade, estado, numero, cep);
        this.seusImoveis = new ArrayList<>();
    }

    // Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public Endereco getEndereco() { return endereco; }

    // Métodos
    public void atualizaEndereco(String rua, String cidade, String estado, int numero, int cep) {
        this.endereco.atualizaEndereco(rua, cidade, estado, numero, cep);
    }

    // método de adicionar imóveis a lista de imóveis do proprietário
    public boolean addImovel(Imovel imovel){
        // não deve ser possível adicionar um imóvel do mesmo endereço do proprietário
        if(imovel.getEndereco().equals(this.endereco)){
            return false;
        }
        this.seusImoveis.add(imovel);
        return true;
    }

    public void listarImoveis(String tipo){
        for (Imovel imovel : this.seusImoveis) {
            if (Objects.equals(tipo, imovel.getTipo())) {
                System.out.println(imovel);
            }
        }
    }

    public Imovel encontrarImovel(String iptu){
        for(Imovel i : this.seusImoveis){
            if(Objects.equals(iptu, i.getIptu())){
                return i;
            }
        }
        return null;
    }


    // alugar um imovel da array de imoveis
    public String alugarImovel(String iptu, LocalDate dataInicio, LocalDate dataFim){
        // cria o formato de data para data com barras para ser usado na impressão
        DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // procura o imóvel que queremos bloquear
        for(Imovel i : this.seusImoveis){
            if(Objects.equals(iptu, i.getIptu())){
                // se tiver data disponivel
                if(i.alugar(dataInicio, dataFim)){
                    return "Imóvel será alugado do dia " + dataInicio.format(formatadorBarra) + " ao dia " + dataFim.format(formatadorBarra);
                }
                // se não
                return "não há datas disponíveis";
            }
        }
        // se não acha o imóvel
        return "Imóvel não encontrado! Ou não existe, ou você procurou no proprietário errado.";
    }

    public String bloquearImovel(String iptu, LocalDate dataInicio, LocalDate dataFim){
        // cria o formato de data para data com barras para ser usado na impressão
        DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // procura o imóvel que queremos bloquear
        for(Imovel i : this.seusImoveis){
            if(Objects.equals(iptu, i.getIptu())){
                // se tiver data disponivel
               if(i.bloquear(dataInicio, dataFim)){
                   return "Imóvel será bloqueado do dia " + dataInicio.format(formatadorBarra) + " ao dia " + dataFim.format(formatadorBarra);
               }
               // se não
                return "não há datas disponíveis";
            }
        }
        // se não acha o imóvel
        return "Imóvel não encontrado! Ou não existe, ou você procurou no proprietário errado.";
    }

    public String disponivel(String iptu, LocalDate dataInicio, LocalDate dataFim){
        for(Imovel i : this.seusImoveis){
            if(Objects.equals(iptu, i.getIptu())) {
                if(i.disponivel(dataInicio, dataFim)){
                    return "Imóvel disponível";
                }
                return "não há datas disponíveis";
            }
        }
        return "Imóvel não encontrado! Ou não existe, ou você procurou no proprietário errado.";
    }

}
