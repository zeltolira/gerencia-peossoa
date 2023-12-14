package gerenciamento.com.lira.gerenciapessoas.endereco.application.api;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EnderecoController implements EnderecoAPI {
    private final EnderecoService enderecoService;

    @Override
    public EnderecoResponse postEndereco(UUID idPessoa, EnderecoRequest enderecoRequestRequest) {
        log.info("[start] EnderecoController - postEndereco");
        EnderecoResponse endereco = enderecoService.postEndereco(idPessoa, enderecoRequestRequest);
        log.info("[finish] EnderecoController - postEndereco");
        return endereco;
    }
}
