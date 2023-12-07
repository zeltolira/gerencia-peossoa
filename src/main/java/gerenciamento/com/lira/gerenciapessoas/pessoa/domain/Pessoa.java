package gerenciamento.com.lira.gerenciapessoas.pessoa.domain;

import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.request.PessoaRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idPessoa;
    @NotBlank(message = "Campo obrigatório!")
    private String nomePessoa;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @NotBlank(message = "Campo obrigatório!")
    private String dataNascimento;
    private LocalDateTime dataCriacao;

    public Pessoa(PessoaRequest pessoaRequest) {
        this.nomePessoa = pessoaRequest.getNomePessoa();
        this.sexo = pessoaRequest.getSexo();
        this.dataNascimento = pessoaRequest.getDataNascimento();
        this.dataCriacao = LocalDateTime.now();
    }
}
