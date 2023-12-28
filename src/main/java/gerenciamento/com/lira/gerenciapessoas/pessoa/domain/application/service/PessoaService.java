package gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.service;

import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.api.request.PessoaPatchRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.api.request.PessoaRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.api.response.PessoaDetalhadoResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.api.response.PessoaListResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.domain.application.api.response.PessoaResponse;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    PessoaResponse postPessoa(PessoaRequest pessoaRequest);
    List<PessoaListResponse> getAllPessoas();
    PessoaDetalhadoResponse getPessoaById(UUID idPessoa);
    void patchPessoaById(UUID idPessoa, PessoaPatchRequest pessoaPatchRequest);
}
