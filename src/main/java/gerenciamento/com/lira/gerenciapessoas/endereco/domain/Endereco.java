package gerenciamento.com.lira.gerenciapessoas.endereco.domain;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idEndereco;

    private String cep;
    private String logradouro;
    private String cidade;
    private String numero;

    @Setter
    private boolean principal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    

    public Endereco(Pessoa pessoa, EnderecoRequest enderecoRequest) {
        this.cep = enderecoRequest.getCep();
        this.logradouro = enderecoRequest.getLogradouro();
        this.cidade = enderecoRequest.getCidade();
        this.numero = enderecoRequest.getNumero();
        this.pessoa = pessoa;
        validarEndereco(enderecoRequest);
        if (enderecoJaCadastrado(pessoa, enderecoRequest)) {
            throw new RuntimeException("Endereço já cadastrado para esta pessoa.");
        }
        tornarPrincipal();
    }

    public void tornarPrincipal() {
        this.principal = true;
        if (pessoa != null && pessoa.getEndereco() != null) {
            pessoa.getEndereco().stream()
                    .filter(endereco -> !endereco.equals(this))
                    .forEach(endereco -> endereco.setPrincipal(false));
        }
    }
    private void validarEndereco(EnderecoRequest enderecoRequest) {
        if (enderecoRequest.getCep() == null || enderecoRequest.getCep().isEmpty()){
            throw new RuntimeException("CEP é um campo obrigatório");
        }
    }
    private boolean enderecoJaCadastrado(Pessoa pessoa, EnderecoRequest enderecoRequest) {
        List<Endereco> enderecosCadastrados = pessoa.getEndereco();
        for (Endereco endereco : enderecosCadastrados) {
            if (saoEnderecosIguais(endereco, enderecoRequest)) {
                return true;
            }
        }
        return false;

    }

    private boolean saoEnderecosIguais(Endereco endereco, EnderecoRequest enderecoRequest) {
        return  endereco.getCep().equals(enderecoRequest.getCep())
                && endereco.getNumero().equals(enderecoRequest.getNumero());
    }
}
