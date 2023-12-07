package gerenciamento.com.lira.gerenciapessoas.pessoa.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
}
