package gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response;

import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class EnderecoDetalhadoResponse {
    private String cep;
    @Setter
    private String logradouro;
    @Setter
    private String complemento;
    @Setter
    private String bairro;
    @Setter
    private String localidade;
    @Setter
    private String uf;
    @Setter
    private String numero;

    public EnderecoDetalhadoResponse(Endereco endereco) {
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.localidade = endereco.getLocalidade();
        this.uf = endereco.getUf();
        this.numero = endereco.getNumero();
    }
}
