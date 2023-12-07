package gerenciamento.com.lira.gerenciapessoas.pessoa.application.service;

import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.request.PessoaRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.PessoaResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.repository.PessoaRepository;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {
    private final PessoaRepository pessoaRepository;

    @Override
    public PessoaResponse postPessoa(PessoaRequest pessoaRequest) {
       log.info("[start] PessoaApplicationService - postPessoa");
       Pessoa pessoa = pessoaRepository.savePessoa(new Pessoa(pessoaRequest));
       log.info("[finish] PessoaApplicationService - postPessoa");
        return new PessoaResponse(pessoa);
    }
}
