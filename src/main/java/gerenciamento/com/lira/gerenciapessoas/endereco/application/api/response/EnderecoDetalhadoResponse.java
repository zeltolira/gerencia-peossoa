package gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response;

import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class EnderecoDetalhadoResponse {
    private String cep;
    private String logradouro;
    private String cidade;
    private String numero;
//    private Status status;

    public EnderecoDetalhadoResponse(Endereco endereco) {
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.cidade = endereco.getCidade();
        this.numero = endereco.getNumero();
//        this.status = endereco.getStatus();
    }
}
