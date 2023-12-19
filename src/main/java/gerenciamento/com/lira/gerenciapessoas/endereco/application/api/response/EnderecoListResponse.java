package gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response;

import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
@Getter
@ToString
public class EnderecoListResponse {
    private UUID idEndereco;
    private String cep;
    private String logradouro;
    private String cidade;
    private String numero;
    private boolean pricnipal;

    public static List<EnderecoListResponse> converte(List<Endereco> endereco) {
        return endereco.stream()
                .map(EnderecoListResponse::new)
                .collect(Collectors.toList());
    }

    public EnderecoListResponse(Endereco endereco) {
        this.idEndereco = endereco.getIdEndereco();
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.cidade = endereco.getCidade();
        this.numero = endereco.getNumero();
        this.pricnipal = endereco.isPrincipal();
    }
}
