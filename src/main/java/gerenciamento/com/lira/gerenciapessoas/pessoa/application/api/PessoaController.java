package gerenciamento.com.lira.gerenciapessoas.pessoa.application.api;

import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.request.PessoaRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.PessoaResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
