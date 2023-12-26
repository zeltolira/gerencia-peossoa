package gerenciamento.com.lira.gerenciapessoas.endereco.application.infra;

import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnderecoSpringDataJPAREpository extends JpaRepository <Endereco, UUID> {
    List<Endereco> findByPessoa(Pessoa pessoa);
}
