package gerenciamento.com.lira.gerenciapessoas.endereco.application.api;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoPatchRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoDetalhadoResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoListResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/endereco/{idPessoa}")
public interface EnderecoAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EnderecoResponse postEndereco(@PathVariable UUID idPessoa, @Valid @RequestBody EnderecoRequest enderecoRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<EnderecoListResponse> getAllEndereco(@PathVariable UUID idPessoa);

    @GetMapping(value = "/{idEndereco}")
    @ResponseStatus(value = HttpStatus.OK)
    EnderecoDetalhadoResponse getEnderecoPorId(@PathVariable UUID idPessoa, @PathVariable UUID idEndereco);

    @PatchMapping(value ="/{idEndereco}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void patchEndereco(@PathVariable UUID idEndereco, @Valid @RequestBody EnderecoPatchRequest enderecoPatchRequest);

    @PatchMapping("/principal/{idEndereco}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void setPrincipal(@PathVariable UUID idPessoa, @PathVariable UUID idEndereco);
}
