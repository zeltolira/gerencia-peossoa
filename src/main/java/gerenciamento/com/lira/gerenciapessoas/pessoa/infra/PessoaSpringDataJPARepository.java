package gerenciamento.com.lira.gerenciapessoas.pessoa.infra;

import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaSpringDataJPARepository extends JpaRepository<Pessoa, UUID> {
}
