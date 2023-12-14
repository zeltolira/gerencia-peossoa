package gerenciamento.com.lira.gerenciapessoas.endereco.application.repository;

import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;

import java.util.List;

public interface EnderecoRepository {
    Endereco saveEndereco(Endereco endereco);
    List<Endereco> getAllEnderecoPessoa(Pessoa pessoa);
}
