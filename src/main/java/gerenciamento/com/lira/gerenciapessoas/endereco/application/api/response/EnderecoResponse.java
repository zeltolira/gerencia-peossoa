package gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response;

import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class EnderecoResponse {
    private UUID idEndereco;

    public EnderecoResponse(Endereco endereco) {
        this.idEndereco = endereco.getIdEndereco();
    }
}
