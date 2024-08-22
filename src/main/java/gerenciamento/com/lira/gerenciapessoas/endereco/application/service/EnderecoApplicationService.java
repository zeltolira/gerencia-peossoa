package gerenciamento.com.lira.gerenciapessoas.endereco.application.service;

import com.google.gson.Gson;
import gerenciamento.com.lira.gerenciapessoas.config.GsonConfig;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoPatchRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoDetalhadoResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoListResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.repository.EnderecoRepository;
import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import gerenciamento.com.lira.gerenciapessoas.handler.APIException;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.repository.PessoaRepository;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class EnderecoApplicationService implements EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;

    @Override
    public EnderecoResponse postEndereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
        log.info("[start] EnderecoApplicationService - postoEndereco");
        Pessoa pessoa = pessoaRepository.getPessoaById(idPessoa);
        Endereco novoEndereco = enderecoRepository.saveEndereco(new Endereco(pessoa, enderecoRequest));
        log.info("[finish] EnderecoApplicationService - postoEndereco");
        return new EnderecoResponse(novoEndereco);
    }

    @Override
    public List<EnderecoListResponse> getEnderecoPessoa(UUID idPessoa) {
        log.info("[start] EnderecoApplicationService - getEnderecoPessoa");
        Pessoa pessoa = pessoaRepository.getPessoaById(idPessoa);
        List<Endereco> endereco = enderecoRepository.getAllEnderecoPessoa(pessoa);
        log.info("[finish] EnderecoApplicationService - getEnderecoPessoa");
        return EnderecoListResponse.converte(endereco);
    }

    @Override
    public EnderecoDetalhadoResponse getEnderecoByID(UUID idPessoa, UUID idEndereco) {
        log.info("[start] EnderecoApplicationService - getEnderecoByID");
        pessoaRepository.getPessoaById(idPessoa).getEndereco();
        Endereco endereco = enderecoRepository.getEnderecoById(idEndereco);
        log.info("[finish] EnderecoApplicationService - getEnderecoByID");
        return new EnderecoDetalhadoResponse(endereco);
    }

    @Override
    public void patchEndereco(UUID idEndereco, EnderecoPatchRequest enderecoPatchRequest) {
        log.info("[start] EnderecoApplicationService - patchEndereco");
        Endereco endereco =enderecoRepository.getEnderecoById(idEndereco);
        endereco.patch(enderecoPatchRequest);
        enderecoRepository.saveEndereco(endereco);
        log.info("[finish] EnderecoApplicationService - patchEndereco");

    }

    @Override
    public void setPrincipal(UUID idPessoa, UUID idEndereco) {
        log.info("[start] EnderecoApplicationService - setPrincipal");
        Pessoa pessoa = pessoaRepository.getPessoaById(idPessoa);
        Endereco endereco = enderecoRepository.getEnderecoById(idEndereco);
        endereco.changeStatusToMain(pessoa, enderecoRepository);
        enderecoRepository.saveEndereco(endereco);
        log.info("[finish] EnderecoApplicationService - setPrincipal");
    }

    @Override
    public Endereco buscaEnderecoPorCep(String cep) throws APIException, IOException {
        log.info("[start] EnderecoApplicationService - buscaEnderecoPorCep");
        URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
        URLConnection connection = url.openConnection();
        try (InputStream is = connection.getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            StringBuilder jsonCep = new StringBuilder();
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                jsonCep.append(linha);
            }
            Gson gson = GsonConfig.getGson();
            log.info("[finish] EnderecoApplicationService - buscaEnderecoPorCep");
            return gson.fromJson(jsonCep.toString(), Endereco.class);
        }
    }
}
