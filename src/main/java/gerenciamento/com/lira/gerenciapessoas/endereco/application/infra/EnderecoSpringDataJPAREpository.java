package gerenciamento.com.lira.gerenciapessoas.endereco.application.infra;

import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoSpringDataJPAREpository extends JpaRepository <Endereco, UUID> {
}
