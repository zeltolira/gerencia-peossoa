package gerenciamento.com.lira.gerenciapessoas.pessoa.application.repository;

import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PessoaRepository {
    Pessoa savePessoa(Pessoa pessoa);
    List<Pessoa> getAllPessoas();
    Pessoa getPessoaById(UUID idPessoa);
    Optional<Pessoa> findByCpf(String cpf);
}
