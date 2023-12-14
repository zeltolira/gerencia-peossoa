package gerenciamento.com.lira.gerenciapessoas.pessoa.domain;

import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.request.PessoaPatchRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.request.PessoaRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
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
    private LocalDateTime dataHoraUltimaAlteracao;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.REMOVE)
    private List<Endereco> endereco;
    public Pessoa(PessoaRequest pessoaRequest) {
        this.nomePessoa = pessoaRequest.getNomePessoa();
        this.sexo = pessoaRequest.getSexo();
        this.dataNascimento = pessoaRequest.getDataNascimento();
        this.dataCriacao = LocalDateTime.now();
    }

    public void patchPessoa(PessoaPatchRequest pessoaPatchRequest) {
        this.nomePessoa = pessoaPatchRequest.getNomePessoa();
        this.sexo = pessoaPatchRequest.getSexo();
        this.dataNascimento = pessoaPatchRequest.getDataNascimento();
        this.dataHoraUltimaAlteracao = LocalDateTime.now();
    }

}
