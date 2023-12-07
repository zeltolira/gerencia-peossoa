package gerenciamento.com.lira.gerenciapessoas.pessoa.infra;

import gerenciamento.com.lira.gerenciapessoas.pessoa.application.repository.PessoaRepository;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PessoaInfraRepository implements PessoaRepository {
    private PessoaSpringDataJPARepository pessoaSpringDataJPARepository;

    @Override
    public Pessoa savePessoa(Pessoa pessoa) {
        log.info("[start] PessoaInfraRepository - savePessoa");
        pessoaSpringDataJPARepository.save(pessoa);
        log.info("[finish] PessoaInfraRepository - savePessoa");
        return pessoa;
    }
}
