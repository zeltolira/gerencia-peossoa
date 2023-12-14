package gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EnderecoRequest {
    private String logradouro;
    private String cidade;
    private String numero;
}
