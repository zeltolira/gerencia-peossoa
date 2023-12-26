package gerenciamento.com.lira.gerenciapessoas.pessoa.application.api;

import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.request.PessoaPatchRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.request.PessoaRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.PessoaDetalhadoResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.PessoaListResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.PessoaResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI {
    private final PessoaService pessoaService;

    @Override
    public PessoaResponse postPessoa(PessoaRequest pessoaRequest) {
        log.info("[start] PessoaController - postPessoa");
        PessoaResponse pessoaCriada = pessoaService.postPessoa(pessoaRequest);
        log.info("[finish] PessoaController - postPessoa");
        return pessoaCriada;
    }

    @Override
    public List<PessoaListResponse> getAllPessoas() {
        log.info("[start] PessoaController - getTodasPessoas");
        List<PessoaListResponse> pessoas = pessoaService.getAllPessoas();
        log.info("[finish] PessoaController - getTodasPessoas");
        return pessoas;
    }

    @Override
    public PessoaDetalhadoResponse getPessoaById(UUID idPessoa) {
        log.info("[start] PessoaController - getPessoaById");
        PessoaDetalhadoResponse pessoaDetalhada = pessoaService.getPessoaById(idPessoa);
        log.info("[finish] PessoaController - getPessoaById");
        return pessoaDetalhada;
    }

    @Override
    public void patchPessoaById(UUID idPessoa, PessoaPatchRequest pessoaPatchRequest) {
        log.info("[start] PessoaController - patchPessoaById");
        log.info("[idPessoa] {}", idPessoa);
        pessoaService.patchPessoaById(idPessoa, pessoaPatchRequest);
        log.info("[finish] PessoaController - patchPessoaById");
    }
}
