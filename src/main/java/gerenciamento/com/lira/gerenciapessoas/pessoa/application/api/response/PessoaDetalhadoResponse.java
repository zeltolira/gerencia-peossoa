package gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Sexo;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@ToString
public class PessoaDetalhadoResponse {
    private UUID idPessoa;
    private String nomePessoa;
    private Sexo sexo;
    private String dataNascimento;
    private String cpf;
    private List<EnderecoResponse> enderecos;

    public PessoaDetalhadoResponse(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.nomePessoa = pessoa.getNomePessoa();
        this.sexo = pessoa.getSexo();
        this.dataNascimento = pessoa.getDataNascimento();
        this.cpf = pessoa.getCpf();
        this.enderecos = EnderecoResponse.converte(pessoa.getEndereco());
    }
}
