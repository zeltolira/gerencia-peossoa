package gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.api;

import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.api.request.PessoaPatchRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.api.request.PessoaRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.api.response.PessoaDetalhadoResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.api.response.PessoaListResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.api.response.PessoaResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/pessoa")
public interface PessoaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PessoaResponse postPessoa(@Valid @RequestBody PessoaRequest pessoaRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<PessoaListResponse> getAllPessoas();

    @GetMapping(value = "/{idPessoa}")
    @ResponseStatus(code = HttpStatus.OK)
    PessoaDetalhadoResponse getPessoaById(@PathVariable UUID idPessoa);

    @PatchMapping(value = "/{idPessoa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchPessoaById(@PathVariable UUID idPessoa, @Valid @RequestBody PessoaPatchRequest pessoaPatchRequest);

}
