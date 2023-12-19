package gerenciamento.com.lira.gerenciapessoas.pessoa.infra;

import gerenciamento.com.lira.gerenciapessoas.handler.APIException;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.repository.PessoaRepository;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PessoaInfraRepository implements PessoaRepository {
    private final PessoaSpringDataJPARepository pessoaSpringDataJPARepository;

    @Override
    public Pessoa savePessoa(Pessoa pessoa) {
        log.info("[start] PessoaInfraRepository - savePessoa");
        pessoaSpringDataJPARepository.save(pessoa);
        log.info("[finish] PessoaInfraRepository - savePessoa");
        return pessoa;
    }

    @Override
    public List<Pessoa> getAllPessoas() {
        log.info("[start] PessoaInfraRepository - getAllPessoa");
        List<Pessoa> allPessoas = pessoaSpringDataJPARepository.findAll();
        log.info("[finish] PessoaInfraRepository - getAllPessoa");
        return allPessoas;
    }

    @Override
    public Pessoa getPessoaById(UUID idPessoa) {
        log.info("[start] PessoaInfraRepository - getPessoaById");
        Pessoa pessoa = pessoaSpringDataJPARepository.findById(idPessoa)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
        log.info("[finish] PessoaInfraRepository - getPessoaById");
        return pessoa;
    }

    public Optional<Pessoa> findByCpf(String cpf) {
        log.info("[start] EnderecoInfraRepository - findByCpf");
        Optional<Pessoa> pessoa =pessoaSpringDataJPARepository.findByCpf(cpf);
        log.info("[finish] EnderecoInfraRepository - findByCpf");
        return pessoa;
    }
}
