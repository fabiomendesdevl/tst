package dominio;

import lombok.*;
//detalhe classe criada para producer usando lombok dentro da pasta dominio
//domingo e onde vai ficar todos os clientes
//imutavel;
//getter setters contrutors;

@Data
@EqualsAndHashCode
public class Producer {
    Integer id;
    String name;

    public Producer() {

    }
    public String toString(){
        return "\nId: "+ id + "  Nome:" + name + "\n";
    }
}
