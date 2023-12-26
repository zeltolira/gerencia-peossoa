package gerenciamento.com.lira.gerenciapessoas.endereco.application.repository;

import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.domain.Pessoa;

import java.util.List;
import java.util.UUID;

public interface EnderecoRepository {
    Endereco saveEndereco(Endereco endereco);
    List<Endereco> getAllEnderecoPessoa(Pessoa pessoa);
    Endereco getEnderecoById(UUID idEndereco);
}
