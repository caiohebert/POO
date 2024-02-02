import java.util.ArrayList;
import java.time.LocalDate;
public class Agenda {
    private ArrayList<LocalDate> datasAlugado;
    private ArrayList<LocalDate> datasBloqueado;

    public Agenda(){
        datasAlugado = new ArrayList<>();
        datasBloqueado = new ArrayList<>();
    }

    // método que verifica se o imóvel está disponível ou não
    public boolean disponivel(LocalDate dataInicio, LocalDate dataFim){
        LocalDate data = dataInicio;
        if (dataInicio.isEqual(dataFim)){
            for (LocalDate d : datasAlugado){
                if (d.isEqual(data)){
                    return false;
                }
            }
            for (LocalDate d2 : datasBloqueado){
                if(d2.isEqual(data)){
                    return false;
                }
            }
            return true;
        }
        while (! data.isEqual(dataFim)){
            // verifica se tem data na lista de alugado. Se tiver, o imóvel não ta disponivel
            for (LocalDate d : datasAlugado){
                if (d.isEqual(data)){
                    return false;
                }
            }

            // verifica se tem data na lista de bloqueado. Se tiver, o imóvel não ta disponivel
            for (LocalDate d2 : datasBloqueado){
                if(d2.isEqual(data)){
                    return false;
                }
            }
            data = data.plusDays(1);
        }
        return true;
    }

    public boolean alugar(LocalDate dataInicio, LocalDate dataFim){
        boolean valor = this.disponivel(dataInicio, dataFim);
        LocalDate data = dataInicio;

        if (valor){
            // se é um dia
            if (dataInicio.isEqual(dataFim)){
                this.datasAlugado.add(dataInicio);
            }

            // se são mais de um dia
            while (! data.isEqual(dataFim)){
                this.datasAlugado.add(data);
                data = data.plusDays(1);
            }
            return true;
        }
        return false;
    }

    public boolean bloquear(LocalDate dataInicio, LocalDate dataFim){
        boolean valor = this.disponivel(dataInicio, dataFim);
        LocalDate data = dataInicio;
        if (valor){
            if (dataInicio.isEqual(dataFim)){
                this.datasBloqueado.add(dataInicio);
            }
            while (! data.isEqual(dataFim)){
                this.datasBloqueado.add(data);
                data = data.plusDays(1);
            }
            return true;
        }
        // se não, não adiciona.
        return false;
    }
}