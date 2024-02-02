public class UndCompartilhada extends Imovel{
    private String id;
    private Condominio condominio;

    public UndCompartilhada(String iptu, String tipo, String utilizacao, String rua, String cidade, String estado, int numero, int cep, String id, Condominio condominio) {
        super(iptu, tipo, utilizacao, rua, cidade, estado, numero, cep);
        this.id = id;
        this.condominio = condominio;
    }

    // GETS E SETS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // MÉTODOS
    public float qtdItens(){
        return this.condominio.qtdItens();
    }



    @Override
    public float calculaReferencia() {
        // iptu
        float iptu = Float.parseFloat(super.getIptu());
        // calcular qtd de itens de lazer
        float qtdItens = this.qtdItens();
        // multiplicar
        if(this.condominio.qtdItens() == 0){
            return iptu * 0.9f;
        }
        return iptu * qtdItens;
    }
}
