import java.time.LocalDate;
/*
CONSERTAR MAIN
MUDAR O APP PARA SIMULADOR
MUDAR METODOS ESTATICOS PARA PUBLIC
*/


public interface Aplicacao {
    void Simulador();
    void cadastraProprietario(String nome, String cpf, String identidade, String rua, String cidade, String estado, int numero, int cep) throws UsuarioExistenteException ;
    String cadastraUndAutonoma(String nome, String iptu, String tipo, String utilizacao, String rua, String cidade, String estado, int numero, int cep, float areautil, float areaconstruida);
    String cadastraUndCompartilhada(String nome, String iptu, String tipo, String utilizacao, String rua, String cidade, String estado, int numero, int cep, String id, Condominio condominio);
    void cadastraUndAutInd( String iptu, String tipo, String utilizacao, String rua, String cidade, String estado, int numero, int cep, float areautil, float areaconstruida);
    void cadastraUndCompInd(String iptu, String tipo, String utilizacao, String rua, String cidade, String estado, int numero, int cep, String id, Condominio condominio);
    String bloquearImovel(String nome, String iptu, LocalDate dataInicio, LocalDate dataFim);
    String bloquearImovelIndep(String iptu, LocalDate dataInicio, LocalDate dataFim);
    String alugarImovel(String nome, String iptu, LocalDate dataInicio, LocalDate dataFim);
    String alugarImovelInd(String iptu, LocalDate dataInicio, LocalDate dataFim);
    void calculaAluguel(int indice, Imovel imovel, LocalDate dataInicio, LocalDate dataFim);
    String verificaImovelProp(String nome, String iptu, LocalDate dataInicio, LocalDate dataFim);
    String verificaImovelInd(String iptu, LocalDate dataInicio, LocalDate dataFim);
}
