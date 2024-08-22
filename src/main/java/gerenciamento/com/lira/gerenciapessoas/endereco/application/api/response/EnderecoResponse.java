package gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response;

import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
public class EnderecoResponse {
    private UUID idEndereco;
    @Setter
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
    private Status status;

    public EnderecoResponse(Endereco endereco) {
        this.idEndereco = endereco.getIdEndereco();
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.localidade = endereco.getLocalidade();
        this.uf = endereco.getUf();
        this.numero = endereco.getNumero();
        this.status = endereco.getStatus();
    }

    public static List<EnderecoResponse> converte(List<Endereco> endereco) {
        return endereco.stream()
                .map(EnderecoResponse::converte)
                .collect(Collectors.toList());
    }

    public static  EnderecoResponse converte(Endereco endereco){
        EnderecoResponse enderecoResponse = new EnderecoResponse(endereco);
        enderecoResponse.setCep(endereco.getCep());
        enderecoResponse.setLogradouro(endereco.getLogradouro());
        enderecoResponse.setComplemento(endereco.getComplemento());
        enderecoResponse.setBairro(endereco.getBairro());
        enderecoResponse.setLocalidade(endereco.getLocalidade());
        enderecoResponse.setUf(endereco.getUf());
        enderecoResponse.setNumero(endereco.getNumero());
        return enderecoResponse;
    }


}
