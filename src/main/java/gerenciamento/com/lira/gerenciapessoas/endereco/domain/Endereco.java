package gerenciamento.com.lira.gerenciapessoas.endereco.domain;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoPatchRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.repository.EnderecoRepository;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
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
    @NotNull
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String numero;
    private Status status;
    private LocalDateTime dataHoraCadastro;
    private LocalDateTime dataHoraUltimaAlteracao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;


    public Endereco(Pessoa pessoa, EnderecoRequest enderecoRequest) {
        this.cep = enderecoRequest.getCep();
        this.logradouro = enderecoRequest.getLogradouro();
        this.complemento = enderecoRequest.getComplemento();
        this.bairro = enderecoRequest.getBairro();
        this.localidade = enderecoRequest.getLocalidade();
        this.uf = enderecoRequest.getUf();
        this.numero = enderecoRequest.getNumero();
        this.status = enderecoRequest.getStatus();
        this.pessoa = pessoa;
        this.dataHoraCadastro = LocalDateTime.now();
        validateAddress(enderecoRequest);
    }

    private void validateAddress(EnderecoRequest enderecoRequest) {
        validIfMain();
        if (addressRegistered(pessoa, enderecoRequest)) {
            throw new RuntimeException("Endereço já cadastrado para esta pessoa.");
        }

    }

    private boolean addressRegistered(Pessoa pessoa, EnderecoRequest enderecoRequest) {
        List<Endereco> enderecosCadastrados = pessoa.getEndereco();
        for (Endereco endereco : enderecosCadastrados) {
            if (sameEddress(endereco, enderecoRequest)) {
                return true;
            }
        }
        return false;

    }

    private boolean sameEddress(Endereco endereco, EnderecoRequest enderecoRequest) {
        return endereco.getCep().equals(enderecoRequest.getCep())
                && endereco.getNumero().equals(enderecoRequest.getNumero());
    }
    private boolean isNewMain(Pessoa pessoa) {
        for (Endereco endereco : pessoa.getEndereco()) {
            if (endereco.isMain()) {
                return false;
            }
        }
        return true;
    }

    private void validIfMain(){
        if (isNewMain(pessoa)) {
            this.status = Status.PRINCIPAL;
        } else {
            this.status = Status.SECUNDARIO;
        }
    }

    private boolean isMain() {
        return this.status == Status.PRINCIPAL;
    }

    public void patch(EnderecoPatchRequest enderecoRequest) {
        this.cep = enderecoRequest.getCep();
        this.logradouro = enderecoRequest.getLogradouro();
        this.complemento = enderecoRequest.getComplemento();
        this.bairro = enderecoRequest.getBairro();
        this.localidade = enderecoRequest.getLocalidade();
        this.uf = enderecoRequest.getUf();
        this.numero = enderecoRequest.getNumero();
        this.status = enderecoRequest.getStatus();
        this.dataHoraUltimaAlteracao = LocalDateTime.now();
    }

    public void changeStatusToSecundary() {
        this.status = Status.SECUNDARIO;
    }

    private void checkIfMain(Endereco outroEndereco, EnderecoRepository enderecoRepository) {
        if (!outroEndereco.equals(this)) {
            outroEndereco.changeStatusToSecundary();
            enderecoRepository.saveEndereco(outroEndereco);
        }
    }

    public void changeStatusToMain(Pessoa pessoa, EnderecoRepository enderecoRepository) {
        pessoa.getEndereco().forEach(outroEndereco -> checkIfMain(outroEndereco, enderecoRepository));
        this.status = Status.PRINCIPAL;
    }
}

