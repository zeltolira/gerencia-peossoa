package gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response;

import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.domain.Pessoa;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class PessoaResponse {
    private UUID idPessoa;

    public PessoaResponse(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
    }
}
