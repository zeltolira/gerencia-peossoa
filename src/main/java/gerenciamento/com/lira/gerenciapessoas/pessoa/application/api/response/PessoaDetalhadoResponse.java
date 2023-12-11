package gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response;

import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Sexo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class PessoaDetalhadoResponse {
    private UUID idPessoa;
    private String nomePessoa;
    private Sexo sexo;
    private String dataNascimento;

    public PessoaDetalhadoResponse(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.nomePessoa = pessoa.getNomePessoa();
        this.sexo = pessoa.getSexo();
        this.dataNascimento = pessoa.getDataNascimento();
    }
}
