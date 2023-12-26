package gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.domain;

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
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

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
    @NotBlank(message = "Campo obrigatório!")
    @CPF(message = "CPF inválido")
    @Column(unique = true)
    private String cpf;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataHoraUltimaAlteracao;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Endereco> endereco;

    public Pessoa(PessoaRequest pessoaRequest) {
        this.nomePessoa = pessoaRequest.getNomePessoa();
        this.sexo = pessoaRequest.getSexo();
        this.dataNascimento = pessoaRequest.getDataNascimento();
        this.dataCriacao = LocalDateTime.now();
        this.cpf = pessoaRequest.getCpf();
        validarCPF(pessoaRequest.getCpf());
    }


    public void patchPessoa(PessoaPatchRequest pessoaPatchRequest) {
        this.nomePessoa = pessoaPatchRequest.getNomePessoa();
        this.sexo = pessoaPatchRequest.getSexo();
        this.dataNascimento = pessoaPatchRequest.getDataNascimento();
        this.cpf = pessoaPatchRequest.getCpf();
        validarCPF(pessoaPatchRequest.getCpf());
        this.dataHoraUltimaAlteracao = LocalDateTime.now();
    }
    private void validarCPF(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);
        if (!cpfValidator.isValid(cpf, null)) {
            throw new RuntimeException("CPF inválido");
        }
    }
//    public void setEnderecoPrincipal(UUID idEndereco) {
//        boolean encontrado = false;
//
//        for (Endereco endereco : this.endereco) {
//            if (endereco.getIdEndereco().equals(idEndereco)) {
//                encontrado = true;
//                boolean novoStatus = !endereco.isPrincipal();
//                endereco.setPrincipal(novoStatus);
//            } else {
//                endereco.setPrincipal(false);
//            }
//        }
//
//        if (!encontrado) {
//            throw new RuntimeException("Endereço não encontrado para o ID fornecido: " + idEndereco);
//        }
//    }

}
