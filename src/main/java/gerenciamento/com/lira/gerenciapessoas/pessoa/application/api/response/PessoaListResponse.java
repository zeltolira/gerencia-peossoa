package gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response;

import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
public class PessoaListResponse {
    private UUID idPessoa;
    private String nomePessoa;

    public static List<PessoaListResponse> converte(List<Pessoa> pessoas) {
        return pessoas.stream()
                .map(PessoaListResponse::new)
                .collect(Collectors.toList());
    }

    public PessoaListResponse(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.nomePessoa = pessoa.getNomePessoa();
    }
}
