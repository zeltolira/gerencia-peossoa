package gerenciamento.com.lira.gerenciapessoas.endereco.application.service;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoPatchRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoDetalhadoResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoListResponse;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoResponse;

import java.util.List;
import java.util.UUID;

public interface EnderecoService {
    EnderecoResponse postEndereco(UUID idPessoa, EnderecoRequest enderecoRequest);
    List<EnderecoListResponse> getEnderecoPessoa(UUID idPessoa);
    EnderecoDetalhadoResponse getEnderecoByID(UUID idPessoa, UUID idEndereco);
    void patchEndereco(UUID idEndereco, EnderecoPatchRequest enderecoPatchRequest);
    void setPrincipal(UUID idPessoa, UUID idEndereco);
}
