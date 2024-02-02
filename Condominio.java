import java.util.ArrayList;
public class Condominio {
    private Endereco endereco;
    private ArrayList<String> itensLazer;

    public Condominio(String rua, String cidade, String estado, int numero, int cep) {
        this.endereco = new Endereco(rua, cidade, estado, numero, cep);
        this.itensLazer = new ArrayList<>();
    }

    // MÉTODOS
    public void addItem(String item){
       this.itensLazer.add(item);
    }

    public int qtdItens(){
        return this.itensLazer.size();
    }
}
