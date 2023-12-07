package gerenciamento.com.lira.gerenciapessoas.pessoa.application.repository;

import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;

public interface PessoaRepository {
    Pessoa savePessoa(Pessoa pessoa);
}
