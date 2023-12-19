package gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response;

import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
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
    private String cidade;
    @Setter
    private String numero;
    @Setter
    private boolean principal;

    public EnderecoResponse(Endereco endereco) {
        this.idEndereco = endereco.getIdEndereco();
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.cidade = endereco.getCidade();
        this.numero = endereco.getNumero();
        this.principal = endereco.isPrincipal();
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
        enderecoResponse.setCidade(endereco.getCidade());
        enderecoResponse.setNumero(endereco.getNumero());
        enderecoResponse.setPrincipal(endereco.isPrincipal());
        return enderecoResponse;
    }

}
