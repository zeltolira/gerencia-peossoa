package gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.api.request;

import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Sexo;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PessoaPatchRequest {
    private String nomePessoa;
    private Sexo sexo;
    private String dataNascimento;
    private String cpf;
}
