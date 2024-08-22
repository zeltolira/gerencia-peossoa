package gerenciamento.com.lira.gerenciapessoas.endereco.application.api;

import com.google.gson.Gson;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoPatchRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoDetalhadoResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoListResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.service.EnderecoService;
import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EnderecoController implements EnderecoAPI {
    private final EnderecoService enderecoService;

    @Override
    public EnderecoResponse postEndereco(UUID idPessoa, EnderecoRequest enderecoRequest) throws IOException {
        log.info("[start] EnderecoController - postEndereco");
        EnderecoResponse endereco = enderecoService.postEndereco(idPessoa, enderecoRequest);
        Endereco endAux = enderecoService.buscaEnderecoPorCep(endereco.getCep());
        endereco.setCep(endAux.getCep());
        endereco.setLogradouro(endAux.getLogradouro());
        endereco.setComplemento(endAux.getComplemento());
        endereco.setLocalidade(endAux.getLocalidade());
        endereco.setUf(endAux.getUf());
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

    @Override
    public EnderecoDetalhadoResponse getEnderecoPorId(UUID idPessoa, UUID idEndereco) {
        log.info("[start] EnderecoController - getEnderecoPorId");
        EnderecoDetalhadoResponse enderecoDetalhado = enderecoService.getEnderecoByID(idPessoa, idEndereco);
        log.info("[finish] EnderecoController - getEnderecoPorId");
        return enderecoDetalhado;
    }

    @Override
    public void patchEndereco(UUID idEndereco, EnderecoPatchRequest enderecoPatchRequest) {
        log.info("[start] EnderecoController - PatchEndreco");
        enderecoService.patchEndereco(idEndereco, enderecoPatchRequest);
        log.info("[finish] EnderecoController - PatchEndreco");

    }

    @Override
    public void setPrincipal(UUID idPessoa, UUID idEndereco) {
        log.info("[start] EnderecoController - setPrincipal");
        enderecoService.setPrincipal(idPessoa,idEndereco);
        log.info("[finish] EnderecoController - setPrincipal");
    }


}
