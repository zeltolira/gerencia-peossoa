package gerenciamento.com.lira.gerenciapessoas.endereco.application.service;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.request.EnderecoRequest;
import gerenciamento.com.lira.gerenciapessoas.endereco.application.api.response.EnderecoResponse;

import java.util.UUID;

public interface EnderecoService {
    EnderecoResponse postEndereco(UUID idPessoa, EnderecoRequest enderecoRequestRequest);
}
