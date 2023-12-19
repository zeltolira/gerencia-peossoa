package gerenciamento.com.lira.gerenciapessoas.pessoa.application.service;

import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.request.PessoaPatchRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.request.PessoaRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.PessoaDetalhadoResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.PessoaListResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.PessoaResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.repository.PessoaRepository;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {
    private final PessoaRepository pessoaRepository;

    @Override
    public PessoaResponse postPessoa(PessoaRequest pessoaRequest) {
       log.info("[start] PessoaApplicationService - postPessoa");
        if (cpfJaCadastrado(pessoaRequest.getCpf())) {
            log.error("CPF já cadastrado: {}", pessoaRequest.getCpf());
            throw new RuntimeException("CPF já cadastrado");
        }
       Pessoa pessoa = pessoaRepository.savePessoa(new Pessoa(pessoaRequest));
       log.info("[finish] PessoaApplicationService - postPessoa");
        return new PessoaResponse(pessoa);
    }

    private boolean cpfJaCadastrado(String cpf) {
        return pessoaRepository.findByCpf(cpf).isPresent();
    }

    @Override
    public List<PessoaListResponse> getAllPessoas() {
       log.info("[start] PessoaApplicationService - getAllPessoas");
       List<Pessoa> pessoas = pessoaRepository.getAllPessoas();
       log.info("[finish] PessoaApplicationService - getAllPessoas");
        return PessoaListResponse.converte(pessoas);
    }

    @Override
    public PessoaDetalhadoResponse getPessoaById(UUID idPessoa) {
        log.info("[start] PessoaApplicationService - getPessoaById");
        Pessoa pessoa = (Pessoa) pessoaRepository.getPessoaById(idPessoa);
        log.info("[finish] PessoaApplicationService - getPessoaById");
        return new PessoaDetalhadoResponse(pessoa);
    }

    @Override
    public void patchPessoaById(UUID idPessoa, PessoaPatchRequest pessoaPatchRequest) {
        log.info("[start] PessoaApplicationService - patchPessoaById");
        Pessoa pessoa = pessoaRepository.getPessoaById(idPessoa);
        pessoa.patchPessoa(pessoaPatchRequest);
        pessoaRepository.savePessoa(pessoa);
        log.info("[finish] PessoaApplicationService - patchPessoaById");
    }
}
