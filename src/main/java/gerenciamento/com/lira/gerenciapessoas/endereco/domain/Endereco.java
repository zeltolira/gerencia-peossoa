package gerenciamento.com.lira.gerenciapessoas.endereco.domain;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    
    public Endereco(EnderecoRequest enderecoRequestRequest, boolean principal) {
        this.logradouro = enderecoRequestRequest.getLogradouro();
        this.cidade = enderecoRequestRequest.getCidade();
        this.numero = enderecoRequestRequest.getNumero();
        this.principal = principal;
    }

    public Endereco(EnderecoRequest enderecoRequestRequest) {
        this.logradouro = enderecoRequestRequest.getLogradouro();
        this.cidade = enderecoRequestRequest.getCidade();
        this.numero = enderecoRequestRequest.getNumero();
    }

    public void tornarPrincipal() {
        this.principal = true;
        if (pessoa != null && pessoa.getEndereco() != null) {
            pessoa.getEndereco().stream()
                    .filter(endereco -> !endereco.equals(this))
                    .forEach(endereco -> endereco.setPrincipal(false));
        }
    }
}
