import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App implements Aplicacao {
    private ArrayList<Imovel> imoveisIndependentes = new ArrayList<>();
    private ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
    public void Simulador() {
        Scanner in = new Scanner(System.in);
        Scanner leint = new Scanner(System.in);
        Scanner lefloat = new Scanner(System.in);

        while (true) {
            System.out.println("\n__________________________________________");
            System.out.println("Olá! Escolha uma das opções abaixo digitando o número correspondente e apertando 'enter': \n1. Cadastrar Proprietário\n2. Cadastrar Imóvel\n3. Agendar bloqueio de um imóvel\n4. Consultar valor de referência de um imóvel\n5. Ver disponibilidade de um Imóvel\n6. Alugar um Imóvel");
            int opcao = leint.nextInt();

            switch (opcao) {
                // CADASTRAR PROPRIETARIO
                case 1 -> {
                    System.out.println("\nCADASTRAR PROPRIETÁRIO\nDigite o nome do proprietário:");
                    String nome = in.nextLine();

                    System.out.println("Digite o CPF:");
                    String cpf = in.nextLine();

                    System.out.println("Digite a identidade:");
                    String identidade = in.nextLine();

                    System.out.println("Digite o nome da rua:");
                    String rua = in.nextLine();

                    System.out.println("Digite o nome da cidade:");
                    String cidade = in.nextLine();

                    System.out.println("Digite a sigla do estado em caps lock:");
                    String estado = in.nextLine();

                    System.out.println("Digite o número da casa/prédio:");
                    int numero = leint.nextInt();

                    System.out.println("Digite o CEP:");
                    int cep = leint.nextInt();

                    // Verifica se o proprietário ja existe
                    try{
                        cadastraProprietario(nome, cpf, identidade, rua, cidade, estado, numero, cep);
                    } catch (UsuarioExistenteException e){
                        System.out.println(e.getMessage());
                    }

                    System.out.println("\nProprietário criado!");
                }

                //CADASTRAR IMOVEL
                case 2 -> {
                    System.out.println("\nCADASTRAR IMÓVEL");
                    System.out.println("Você deseja cadastrar um imóvel pertencente a um proprietário ou um imóvel independente?\n1. Imóvel pertencente a um proprietário\n2. Imóvel independente");
                    opcao = leint.nextInt();
                    switch (opcao){
                        // pertencente a um proprietario
                        case 1 -> {
                            System.out.println("Esse imóvel é uma unidade autônoma ou compartilhada(está em um condomínio)?\n1. Unidade autônoma\n2. Unidade compartilhada");
                            opcao = leint.nextInt();
                            switch (opcao){
                                // Unidade Autônoma
                                case 1 ->{
                                    System.out.println("Digite o nome do proprietário:");
                                    String nome = in.nextLine();

                                    System.out.println("Digite o número do IPTU:");
                                    String iptu = in.nextLine();

                                    System.out.println("Digite o tipo de imóvel:");
                                    String tipo = in.nextLine();

                                    System.out.println("Digite a utilização do imóvel:");
                                    String utilizacao = in.nextLine();

                                    System.out.println("Digite o nome da rua:");
                                    String rua = in.nextLine();

                                    System.out.println("Digite o nome da cidade:");
                                    String cidade = in.nextLine();

                                    System.out.println("Digite a sigla do estado em caps lock:");
                                    String estado = in.nextLine();

                                    System.out.println("Digite o número da casa/prédio:");
                                    int numero = leint.nextInt();

                                    System.out.println("Digite o CEP:");
                                    int cep = leint.nextInt();

                                    System.out.println("Digite a Área útil:");
                                    float areautil = lefloat.nextFloat();

                                    System.out.println("Digite a Área construída:");
                                    float areaconstruida = lefloat.nextFloat();

                                    //realiza o cadastro e imprime a string de retorno da função
                                    System.out.println(cadastraUndAutonoma(nome, iptu, tipo, utilizacao, rua, cidade, estado, numero, cep, areautil, areaconstruida));
                                }

                                // Unidade Compartilhada
                                case 2 -> {
                                    System.out.println("Digite o nome do proprietário:");
                                    String nome = in.nextLine();

                                    System.out.println("Digite o número do IPTU:");
                                    String iptu = in.nextLine();

                                    System.out.println("Digite o tipo de imóvel:");
                                    String tipo = in.nextLine();

                                    System.out.println("Digite a utilização do imóvel:");
                                    String utilizacao = in.nextLine();

                                    System.out.println("Digite o nome da rua:");
                                    String rua = in.nextLine();

                                    System.out.println("Digite o nome da cidade:");
                                    String cidade = in.nextLine();

                                    System.out.println("Digite a sigla do estado em caps lock:");
                                    String estado = in.nextLine();

                                    System.out.println("Digite o número da casa/prédio:");
                                    int numero = leint.nextInt();

                                    System.out.println("Digite o CEP:");
                                    int cep = leint.nextInt();

                                    System.out.println("Digite a identificação na área compartilhada:");
                                    String id = in.nextLine();

                                    System.out.println("\nAgora vamos cadastrar o condomínio!\n");
                                    System.out.println("Digite os itens de lazer que o condominio possui (na mesma linha e apenas com espaço entre eles):");
                                    String itens = in.nextLine();

                                    // cria o condominio
                                    Condominio condominio = new Condominio(rua, cidade, estado, numero, cep);
                                    String[] lista = itens.split(" ");
                                    for (String i : lista){
                                        condominio.addItem(i);
                                    }
                                    System.out.println("\n Condomínio criado!");
                                    //realiza o cadastro e imprime a string de retorno da função
                                    System.out.println(cadastraUndCompartilhada(nome, iptu, tipo, utilizacao, rua, cidade, estado, numero, cep, id, condominio));
                                }
                            }
                        }
                        // independente
                        case 2 -> {
                            System.out.println("Esse imóvel é uma unidade autônoma ou compartilhada(está em um condomínio)?\n1. Unidade autônoma\n2. Unidade compartilhada");
                            opcao = leint.nextInt();
                            switch (opcao){
                                // Unidade Autônoma
                                case 1 ->{
                                    System.out.println("Digite o número do IPTU:");
                                    String iptu = in.nextLine();

                                    System.out.println("Digite o tipo de imóvel:");
                                    String tipo = in.nextLine();

                                    System.out.println("Digite a utilização do imóvel:");
                                    String utilizacao = in.nextLine();

                                    System.out.println("Digite o nome da rua:");
                                    String rua = in.nextLine();

                                    System.out.println("Digite o nome da cidade:");
                                    String cidade = in.nextLine();

                                    System.out.println("Digite a sigla do estado em caps lock:");
                                    String estado = in.nextLine();

                                    System.out.println("Digite o número da casa/prédio:");
                                    int numero = leint.nextInt();

                                    System.out.println("Digite o CEP:");
                                    int cep = leint.nextInt();

                                    System.out.println("Digite a Área útil:");
                                    float areautil = lefloat.nextFloat();

                                    System.out.println("Digite a Área construída:");
                                    float areaconstruida = lefloat.nextFloat();

                                    //realiza o cadastro e imprime a string de retorno da função
                                    cadastraUndAutInd(iptu, tipo, utilizacao, rua, cidade, estado, numero, cep, areautil, areaconstruida);
                                    System.out.println("\n Imóvel cadastrado!");
                                }

                                // Unidade Compartilhada
                                case 2 -> {
                                    System.out.println("Digite o número do IPTU:");
                                    String iptu = in.nextLine();

                                    System.out.println("Digite o tipo de imóvel:");
                                    String tipo = in.nextLine();

                                    System.out.println("Digite a utilização do imóvel:");
                                    String utilizacao = in.nextLine();

                                    System.out.println("Digite o nome da rua:");
                                    String rua = in.nextLine();

                                    System.out.println("Digite o nome da cidade:");
                                    String cidade = in.nextLine();

                                    System.out.println("Digite a sigla do estado em caps lock:");
                                    String estado = in.nextLine();

                                    System.out.println("Digite o número da casa/prédio:");
                                    int numero = leint.nextInt();

                                    System.out.println("Digite o CEP:");
                                    int cep = leint.nextInt();

                                    System.out.println("Digite a identificação na área compartilhada:");
                                    String id = in.nextLine();

                                    System.out.println("\nAgora vamos cadastrar o condomínio!\n");
                                    System.out.println("Digite os itens de lazer que o condominio possui (na mesma linha e apenas com espaço entre eles):");
                                    String itens = in.nextLine();

                                    // cria o condominio
                                    Condominio condominio = new Condominio(rua, cidade, estado, numero, cep);
                                    String[] lista = itens.split(" ");
                                    for (String i : lista){
                                        condominio.addItem(i);
                                    }
                                    System.out.println("\n Condomínio criado!");
                                    //realiza o cadastro e imprime a string de retorno da função
                                    cadastraUndCompInd(iptu, tipo, utilizacao, rua, cidade, estado, numero, cep, id, condominio);
                                    System.out.println("\n Imóvel cadastrado!");
                                }
                            }
                        }
                    }
                }
                // BLOQUEAR IMOVEL
                case 3 -> {
                    System.out.println("\nBLOQUEAR IMÓVEL");
                    System.out.println("Você deseja bloquear um imóvel que já pertence a um proprietário criado ou um que exista sem proprietário?\n1. Bloquear imóvel de proprietário\n2. Bloquear imóvel que não pertence a um proprietário");
                    opcao = leint.nextInt();

                    switch (opcao) {
                        // Imovel pertencente
                        case 1 -> {
                            System.out.println("Digite o nome do proprietário:");
                            String nome = in.nextLine();

                            System.out.println("Digite o número de IPTU do imóvel que quer bloquear:");
                            String iptu = in.nextLine();

                            System.out.println("\nVamos anotar a data de início! (para apenas um dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String ano = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mes = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String dia = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataInicio = ano + "-" + mes + "-" + dia;

                            System.out.println("\nVamos anotar a data final! (para apenas um dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String anoFim = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mesFim = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String diaFim = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataFim = anoFim + "-" + mesFim + "-" + diaFim;

                            // cria data no formato da classe localdate
                            LocalDate dataVerifInicio = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            LocalDate dataVerifFim = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                            // finalmente bloqueia o imovel
                            System.out.println("\n");
                            System.out.println(bloquearImovel(nome, iptu, dataVerifInicio, dataVerifFim));
                        }
                        // imovel independente
                        case 2 -> {
                            System.out.println("Digite o número de IPTU do imóvel que quer bloquear:");
                            String iptu = in.nextLine();

                            System.out.println("\nVamos anotar a data de início! (para apenas um dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String ano = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mes = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String dia = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataInicio = ano + "-" + mes + "-" + dia;

                            System.out.println("\nVamos anotar a data final! (para apenas um dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String anoFim = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mesFim = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String diaFim = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataFim = anoFim + "-" + mesFim + "-" + diaFim;

                            // cria data no formato da classe localdate
                            LocalDate dataVerifInicio = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            LocalDate dataVerifFim = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                            // finalmente bloqueia o imovel
                            System.out.println("\n");
                            System.out.println(bloquearImovelIndep(iptu, dataVerifInicio, dataVerifFim));
                        }
                    }
                }

                // Consultar valor de referência de um imóvel
                case 4 -> {
                    System.out.println("É um imóvel idependente de um proprietário?\n1. Pertence a um proprietário\n2. Independente");
                    opcao = leint.nextInt();

                    switch (opcao){
                        // Pertence a um proprietário
                        case 1 -> {
                            System.out.println("Digite o nome do proprietário:");
                            String nome = in.nextLine();

                            System.out.println("Digite o número de IPTU do imóvel que quer bloquear:");
                            String iptu = in.nextLine();

                            System.out.println("Digite o indice de sazonalidade:\n0. Comum (sem índice)\n1. Reveillon\n2. Carnaval\n3. Feriado alta estação\n4. Feriado baixa estação");
                            opcao = leint.nextInt();

                            System.out.println("\nAgora digite a data do período do aluguel");
                            System.out.println("\nVamos anotar a data de início! (para apenas um dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String ano = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mes = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String dia = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataInicio = ano + "-" + mes + "-" + dia;

                            System.out.println("\nVamos anotar a data final! (para apenas um dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String anoFim = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mesFim = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String diaFim = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataFim = anoFim + "-" + mesFim + "-" + diaFim;

                            // cria data no formato da classe localdate
                            LocalDate dataVerifInicio = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            LocalDate dataVerifFim = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                            for (Proprietario p : listaProprietarios){
                                if(Objects.equals(nome, p.getNome())){
                                    Imovel imovel = p.encontrarImovel(iptu);
                                    calculaAluguel(opcao, imovel, dataVerifInicio, dataVerifFim);
                                }
                            }
                        }

                        // Independente
                        case 2 -> {
                            System.out.println("Digite o número de IPTU do imóvel que quer bloquear:");
                            String iptu = in.nextLine();

                            System.out.println("Digite o indice de sazonalidade:\n0. Comum (sem índice)\n1. Reveillon\n2. Carnaval\n3. Feriado alta estação\n4. Feriado baixa estação");
                            opcao = leint.nextInt();

                            System.out.println("\nAgora digite a data do período do aluguel");
                            System.out.println("\nVamos anotar a data de início! (para apenas um dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String ano = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mes = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String dia = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataInicio = ano + "-" + mes + "-" + dia;

                            System.out.println("\nVamos anotar a data final! (para apenas um dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String anoFim = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mesFim = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String diaFim = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataFim = anoFim + "-" + mesFim + "-" + diaFim;

                            // cria data no formato da classe localdate
                            LocalDate dataVerifInicio = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            LocalDate dataVerifFim = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                            for (Imovel i : imoveisIndependentes){
                                if(Objects.equals(iptu, i.getIptu())){
                                    calculaAluguel(opcao, i, dataVerifInicio, dataVerifFim);
                                }
                            }
                        }
                    }
                }

                // Ver disponibilidade de um Imóvel
                case 5 -> {
                    System.out.println("\nVer disponibilidade de um Imóvel");
                    System.out.println("Você deseja ver um imóvel que já pertence a um proprietário criado ou um que exista sem proprietário?\n1. Imóvel de proprietário\n2. Imóvel que não pertence a um proprietário");
                    opcao = leint.nextInt();

                    switch (opcao) {
                        // Imovel pertencente
                        case 1 -> {
                            System.out.println("Digite o nome do proprietário:");
                            String nome = in.nextLine();

                            System.out.println("Digite o número de IPTU do imóvel que quer verificar:");
                            String iptu = in.nextLine();

                            System.out.println("\nVamos anotar a data de início! (para apenas o dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String ano = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mes = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String dia = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataInicio = ano + "-" + mes + "-" + dia;

                            System.out.println("\nVamos anotar a data final! (para apenas o dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String anoFim = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mesFim = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String diaFim = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataFim = anoFim + "-" + mesFim + "-" + diaFim;

                            // cria data no formato da classe localdate
                            LocalDate dataVerifInicio = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            LocalDate dataVerifFim = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                            // finalmente bloqueia o imovel
                            System.out.println("\n");
                            System.out.println(verificaImovelProp(nome, iptu, dataVerifInicio, dataVerifFim));

                        }
                        // imovel independente
                        case 2 -> {
                            System.out.println("Digite o número de IPTU do imóvel que quer verificar:");
                            String iptu = in.nextLine();

                            System.out.println("\nVamos anotar a data de início! (para apenas o dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String ano = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mes = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String dia = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataInicio = ano + "-" + mes + "-" + dia;

                            System.out.println("\nVamos anotar a data final! (para apenas o dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String anoFim = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mesFim = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String diaFim = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataFim = anoFim + "-" + mesFim + "-" + diaFim;

                            // cria data no formato da classe localdate
                            LocalDate dataVerifInicio = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            LocalDate dataVerifFim = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                            // finalmente bloqueia o imovel
                            System.out.println("\n");
                            System.out.println(verificaImovelInd(iptu, dataVerifInicio, dataVerifFim));
                        }
                    }
                }

                // Alugar um imóvel
                case 6 -> {
                    System.out.println("\nALUGAR IMÓVEL");
                    System.out.println("Você deseja alugar um imóvel que já pertence a um proprietário criado ou um que exista sem proprietário?\n1. Alugar imóvel de proprietário\n2. Alugar imóvel que não pertence a um proprietário");
                    opcao = leint.nextInt();

                    switch (opcao) {
                        // Imovel pertencente
                        case 1 -> {
                            System.out.println("Digite o nome do proprietário:");
                            String nome = in.nextLine();

                            System.out.println("Digite o número de IPTU do imóvel que quer bloquear:");
                            String iptu = in.nextLine();

                            System.out.println("\nVamos anotar a data de início! (para apenas um dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String ano = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mes = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String dia = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataInicio = ano + "-" + mes + "-" + dia;

                            System.out.println("\nVamos anotar a data final! (para apenas um dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String anoFim = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mesFim = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String diaFim = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataFim = anoFim + "-" + mesFim + "-" + diaFim;

                            // cria data no formato da classe localdate
                            LocalDate dataVerifInicio = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            LocalDate dataVerifFim = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                            // finalmente bloqueia o imovel
                            System.out.println("\n");
                            System.out.println(alugarImovel(nome, iptu, dataVerifInicio, dataVerifFim));
                        }
                        // imovel independente
                        case 2 -> {
                            System.out.println("Digite o número de IPTU do imóvel que quer bloquear:");
                            String iptu = in.nextLine();

                            System.out.println("\nVamos anotar a data de início! (para apenas um dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String ano = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mes = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String dia = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataInicio = ano + "-" + mes + "-" + dia;

                            System.out.println("\nVamos anotar a data final! (para apenas um dia digite a mesma data 2 vezes)\n");
                            System.out.println("Digite o ano em que quer verfificar:");
                            String anoFim = in.nextLine();

                            System.out.println("Digite o mês em que quer verfificar (ex: para março, digite 03):");
                            String mesFim = in.nextLine();

                            System.out.println("Digite o dia em que quer verfificar (ex: para o dia 6, digite 06):");
                            String diaFim = in.nextLine();

                            //cria string com a data num formato convertivel para o tipo da classe localdate
                            String dataFim = anoFim + "-" + mesFim + "-" + diaFim;

                            // cria data no formato da classe localdate
                            LocalDate dataVerifInicio = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            LocalDate dataVerifFim = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                            // finalmente bloqueia o imovel
                            System.out.println("\n");
                            System.out.println(alugarImovelInd(iptu, dataVerifInicio, dataVerifFim));
                        }
                    }
                }
            }
            System.out.println("\n__________________________________________\nE agora? Deseja encerrar o programa?\n1. Encerrar\n2. Continuar (voltar ao menu principal)");
            opcao = leint.nextInt();
            if (opcao == 1){
                System.out.println("\nObrigado por testar o nosso sistema! volte sempre!");
                break;
            }
            System.out.println("\n Certo! Retornando ao menu inicial...");
        }
    }

    // MÉTODOS
    public void cadastraProprietario(String nome, String cpf, String identidade, String rua, String cidade, String estado, int numero, int cep) throws UsuarioExistenteException{
        // Verifica se o proprietário ja existe
        for (Proprietario p : listaProprietarios){
            if (p.getCpf().equals(cpf)){
                throw new UsuarioExistenteException("Esse proprietário já está cadastrado");
            }
        }
        Proprietario proprietario = new Proprietario(nome, cpf, identidade, rua, cidade, estado, numero, cep);
        listaProprietarios.add(proprietario);
    }

    // método para cadastrar um imóvel direto na lista de um determinado proprietário
    public String cadastraUndAutonoma(String nome, String iptu, String tipo, String utilizacao, String rua, String cidade, String estado, int numero, int cep, float areautil, float areaconstruida){
        UndAutonoma und = new UndAutonoma(iptu, tipo, utilizacao, rua, cidade, estado, numero, cep, areautil, areaconstruida);
        // procura o proprietario que queremos cadastrar tal imovel na lista de proprietarios da aplicação
        for(Proprietario p : listaProprietarios){
            if (Objects.equals(nome, p.getNome())){
                if (p.addImovel(und)){
                    return "Imóvel cadastrado!";
                }
                // se a função addImovel retorna falso é porque tentamos adicionar um imóvel com o endereço do propritário na sua lista de imóveis
                return "Epa! Um proprietário não pode alugar o lugar onde mora!";
            }
        }
        // caso onde o proprietário não foi criado
        return "Esse proprietário não existe!";
    }

    public String cadastraUndCompartilhada(String nome, String iptu, String tipo, String utilizacao, String rua, String cidade, String estado, int numero, int cep, String id, Condominio condominio){
        UndCompartilhada und = new UndCompartilhada(iptu, tipo, utilizacao, rua, cidade, estado, numero, cep, id, condominio);
        // procura o proprietario que queremos cadastrar tal imovel na lista de proprietarios da aplicação
        for(Proprietario p : listaProprietarios){
            if (Objects.equals(nome, p.getNome())){
                if (p.addImovel(und)){
                    return "Imóvel cadastrado!";
                }
                // se a função addImovel retorna falso é porque tentamos adicionar um imóvel com o endereço do propritário na sua lista de imóveis
                return "Epa! Um proprietário não pode alugar o lugar onde mora!";
            }
        }
        // caso onde o proprietário não foi criado
        return "Esse proprietário não existe!";
    }

    //método para cadastrar um imóvel independente, que não tenha um proprietário cadastrado
    public void cadastraUndAutInd( String iptu, String tipo, String utilizacao, String rua, String cidade, String estado, int numero, int cep, float areautil, float areaconstruida){
        UndAutonoma und = new UndAutonoma(iptu, tipo, utilizacao, rua, cidade, estado, numero, cep, areautil, areaconstruida);
        imoveisIndependentes.add(und);
    }

    public void cadastraUndCompInd(String iptu, String tipo, String utilizacao, String rua, String cidade, String estado, int numero, int cep, String id, Condominio condominio){
        UndCompartilhada und = new UndCompartilhada(iptu, tipo, utilizacao, rua, cidade, estado, numero, cep, id, condominio);
        imoveisIndependentes.add(und);
    }

    //método para bloquear um imóvel de um proprietário
    public String bloquearImovel(String nome, String iptu, LocalDate dataInicio, LocalDate dataFim){
        // procura o proprietario que queremos bloquear tal imovel na lista de proprietarios da aplicação
        for (Proprietario p : listaProprietarios){
            if(Objects.equals(nome, p.getNome())){
                return p.bloquearImovel(iptu, dataInicio, dataFim);
            }
        }
        return "Proprietário não encontrado!";
    }

    //método para bloquear um imóvel independente
    public String bloquearImovelIndep(String iptu, LocalDate dataInicio, LocalDate dataFim){
        // cria o formato de data para data com barras para ser usado na impressão
        DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // procura o imovel que quer bloquear na lista de imoveis independentes
        for (Imovel i : imoveisIndependentes){
            if(Objects.equals(iptu, i.getIptu())){
                // se tiver data disponível
                if(i.bloquear(dataInicio, dataFim)){
                    return "Imóvel será bloqueado do dia " + dataInicio.format(formatadorBarra) + " ao dia " + dataFim.format(formatadorBarra);
                }
                // se não
                return "não há datas disponíveis";
            }
        }
        return "Imóvel não encontrado!";
    }

    //método para bloquear um imóvel de um proprietário
    public String alugarImovel(String nome, String iptu, LocalDate dataInicio, LocalDate dataFim){
        for (Proprietario p : listaProprietarios){
            if(Objects.equals(nome, p.getNome())){
                return p.alugarImovel(iptu, dataInicio, dataFim);
            }
        }
        return "Proprietário não encontrado!";
    }

    //método para bloquear um imóvel independente
    public String alugarImovelInd(String iptu, LocalDate dataInicio, LocalDate dataFim){
        // cria o formato de data para data com barras para ser usado na impressão
        DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // procura o imovel que quer bloquear na lista de imoveis independentes
        for (Imovel i : imoveisIndependentes){
            if(Objects.equals(iptu, i.getIptu())){
                // se tiver data disponível
                if(i.alugar(dataInicio, dataFim)){
                    return "Imóvel será alugado do dia " + dataInicio.format(formatadorBarra) + " ao dia " + dataFim.format(formatadorBarra);
                }
                // se não
                return "não há datas disponíveis";
            }
        }
        return "Imóvel não encontrado!";
    }

    // método para devolver ao usuário o valor de referencia, com e sem o indice de sazonalidade
    public void calculaAluguel(int indice, Imovel imovel, LocalDate dataInicio, LocalDate dataFim){
        float valor = 0;
        float valorSaz = 0;
        LocalDate data = dataInicio;

        if (imovel instanceof UndAutonoma || imovel instanceof UndCompartilhada){
            switch (indice){
                // Sem indice
                case 0 -> {
                    if (dataInicio.isEqual(dataFim)){
                        System.out.println("Valor do alguel: " + imovel.calculaReferencia());
                    }
                    else {
                        while (! data.isEqual(dataFim)){
                            valor += imovel.calculaReferencia();
                            data = data.plusDays(1);
                        }
                        System.out.println("Valor do Aluguel: " + valor);
                    }
                }

                // Reveillon
                case 1 -> {
                    if (dataInicio.isEqual(dataFim)){
                        valorSaz = imovel.calculaReferencia() * 1.2f;
                        System.out.println("Valor do alguel: " + imovel.calculaReferencia());
                        System.out.println("Valor do alguel com sazonalidade: " + valorSaz);
                    }
                    else {
                        while (! data.isEqual(dataFim)){
                            valor += imovel.calculaReferencia();
                            valorSaz += imovel.calculaReferencia() * 1.2f;
                            data = data.plusDays(1);
                        }
                        System.out.println("Valor do Aluguel: " + valor);
                        System.out.println("Valor do alguel com sazonalidade: " + valorSaz);
                    }
                }

                // Carnaval
                case 2 -> {
                    if (dataInicio.isEqual(dataFim)){
                        valorSaz = imovel.calculaReferencia() * 1.15f;
                        System.out.println("Valor do alguel: " + imovel.calculaReferencia());
                        System.out.println("Valor do alguel com sazonalidade: " + valorSaz);
                    }
                    else {
                        while (! data.isEqual(dataFim)){
                            valor += imovel.calculaReferencia();
                            valorSaz += imovel.calculaReferencia() * 1.15f;
                            data = data.plusDays(1);
                        }
                        System.out.println("Valor do Aluguel: " + valor);
                        System.out.println("Valor do alguel com sazonalidade: " + valorSaz);
                    }
                }

                // Feriado alta estação
                case 3 -> {
                    if (dataInicio.isEqual(dataFim)){
                        valorSaz = imovel.calculaReferencia() * 1.1f;
                        System.out.println("Valor do alguel: " + imovel.calculaReferencia());
                        System.out.println("Valor do alguel com sazonalidade: " + valorSaz);
                    }
                    else {
                        while (! data.isEqual(dataFim)){
                            valor += imovel.calculaReferencia();
                            valorSaz += imovel.calculaReferencia() * 1.1f;
                            data = data.plusDays(1);
                        }
                        System.out.println("Valor do Aluguel: " + valor);
                        System.out.println("Valor do alguel com sazonalidade: " + valorSaz);
                    }
                }

                // Feriado baixa estação
                case 4 -> {
                    if (dataInicio.isEqual(dataFim)){
                        valorSaz = imovel.calculaReferencia() * 1.05f;
                        System.out.println("Valor do alguel: " + imovel.calculaReferencia());
                        System.out.println("Valor do alguel com sazonalidade: " + valorSaz);
                    }
                    else {
                        while (! data.isEqual(dataFim)){
                            valor += imovel.calculaReferencia();
                            valorSaz += imovel.calculaReferencia() * 1.05f;
                            data = data.plusDays(1);
                        }
                        System.out.println("Valor do Aluguel: " + valor);
                        System.out.println("Valor do alguel com sazonalidade: " + valorSaz);
                    }
                }
            }
        }
    }

    public String verificaImovelProp(String nome, String iptu, LocalDate dataInicio, LocalDate dataFim){
        for (Proprietario p : listaProprietarios){
            if(Objects.equals(nome, p.getNome())){
                return p.disponivel(iptu, dataInicio, dataFim);
            }
        }
        return "Proprietário não encontrado!";
    }

    public String verificaImovelInd(String iptu, LocalDate dataInicio, LocalDate dataFim){
        for (Imovel i : imoveisIndependentes){
            if(Objects.equals(iptu, i.getIptu())){
                if(i.disponivel(dataInicio, dataFim)){
                    return "Imóvel disponível!";
                }
                return "Imóvel indisponível";
            }
        }
        return "Imóvel não encontrado!";
    }
}