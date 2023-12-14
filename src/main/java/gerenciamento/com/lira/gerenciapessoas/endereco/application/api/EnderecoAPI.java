package gerenciamento.com.lira.gerenciapessoas.endereco.application.api;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/endereco/{idPessoa}")
public interface EnderecoAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EnderecoResponse postEndereco(@PathVariable UUID idPessoa, @Valid @RequestBody EnderecoRequest enderecoRequestRequest);
}
