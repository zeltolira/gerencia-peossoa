package gerenciamento.com.lira.gerenciapessoas.endereco.domain;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private UUID idEnderco;

    private String cep;
    private String logradouro;
    private String cidade;
    private String numero;

    public Endereco(EnderecoRequest enderecoRequestRequest) {
        this.logradouro = enderecoRequestRequest.getLogradouro();
        this.cidade = enderecoRequestRequest.getCidade();
        this.numero = enderecoRequestRequest.getNumero();
    }

}
