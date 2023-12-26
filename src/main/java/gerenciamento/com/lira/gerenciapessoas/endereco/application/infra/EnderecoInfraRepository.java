package gerenciamento.com.lira.gerenciapessoas.endereco.application.infra;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.repository.EnderecoRepository;
import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import gerenciamento.com.lira.gerenciapessoas.handler.APIException;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EnderecoInfraRepository implements EnderecoRepository {
    private final EnderecoSpringDataJPAREpository enderecoSpringDataJPAREpository;

    @Override
    public Endereco saveEndereco(Endereco endereco) {
        log.info("[start] EnderecoInfraRepository - saveEndereco");
        enderecoSpringDataJPAREpository.save(endereco);
        log.info("[finish] EnderecoInfraRepository - saveEndereco");
        return endereco;
    }

    @Override
    public List<Endereco> getAllEnderecoPessoa(Pessoa pessoa) {
        log.info("[start] EnderecoInfraRepository - getAllEnderecoPessoa");
        List<Endereco> allEnderecos = enderecoSpringDataJPAREpository.findByPessoa(pessoa);
        log.info("[finish] EnderecoInfraRepository - getAllEnderecoPessoa");
        return allEnderecos;
    }

    @Override
    public Endereco getEnderecoById(UUID idEndereco) {
        var endereco = enderecoSpringDataJPAREpository.findById(idEndereco)
                .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Endereço não encontrado!"));
        return endereco;
    }
}
