package gerenciamento.com.lira.gerenciapessoas.endereco.application.api;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoListResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EnderecoController implements EnderecoAPI {
    private final EnderecoService enderecoService;

    @Override
    public EnderecoResponse postEndereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
        log.info("[start] EnderecoController - postEndereco");
        EnderecoResponse endereco = enderecoService.postEndereco(idPessoa, enderecoRequest);
        log.info("[finish] EnderecoController - postEndereco");
        return endereco;
    }

    @Override
    public List<EnderecoListResponse> getAllEndereco(UUID idPessoa) {
        log.info("[start] EnderecoController - getAllEndereco");
        List<EnderecoListResponse> endereco = enderecoService.getEnderecoPessoa(idPessoa);
        log.info("[finish] EnderecoController - getAllEndereco");
        return endereco;
    }
}
