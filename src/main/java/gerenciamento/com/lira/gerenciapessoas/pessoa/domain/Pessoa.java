package gerenciamento.com.lira.gerenciapessoas.pessoa.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;
    @NotBlank(message = "Campo obrigatório!")
    private String nomeCliente;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @NotBlank(message = "Campo obrigatório!")
    private String dataNascimento;
}
