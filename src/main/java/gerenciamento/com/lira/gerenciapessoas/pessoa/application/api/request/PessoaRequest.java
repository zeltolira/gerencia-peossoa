package gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.request;

import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.domain.Sexo;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PessoaRequest {
    private String nomePessoa;
    private Sexo sexo;
    private String dataNascimento;
    private String cpf;
}
