package gerenciamento.com.lira.gerenciapessoas.endereco.application.service;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoPatchRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoDetalhadoResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoListResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.repository.EnderecoRepository;
import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.repository.PessoaRepository;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
        endereco.setStatusPrincipal(pessoa, endereco, enderecoRepository);
        enderecoRepository.saveEndereco(endereco);
        log.info("[finish] EnderecoApplicationService - setPrincipal");
    }
}
