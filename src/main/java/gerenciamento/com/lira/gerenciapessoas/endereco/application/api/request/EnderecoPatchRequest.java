package gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request;

import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Status;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EnderecoPatchRequest {
    private String cep;
    private String logradouro;
    private String cidade;
    private String numero;
    private Status status;
}
