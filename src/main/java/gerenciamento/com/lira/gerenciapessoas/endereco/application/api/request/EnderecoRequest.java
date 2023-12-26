package gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request;

import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Status;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class EnderecoRequest {
    private UUID idPessoa;
    private String cep;
    private String logradouro;
    private String cidade;
    private String numero;
    private Status status;

}
