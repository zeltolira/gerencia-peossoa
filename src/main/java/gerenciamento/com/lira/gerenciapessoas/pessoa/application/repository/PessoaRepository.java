package gerenciamento.com.lira.gerenciapessoas.pessoa.application.repository;

import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.PessoaListResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;

import java.util.List;

public interface PessoaRepository {
    Pessoa savePessoa(Pessoa pessoa);
    List<Pessoa> getAllPessoas();
}
