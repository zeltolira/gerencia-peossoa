package gerenciamento.com.lira.gerenciapessoas.pessoa.application.service;

import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.request.PessoaRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.PessoaListResponse;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.PessoaResponse;

import java.util.List;

public interface PessoaService {
    PessoaResponse postPessoa(PessoaRequest pessoaRequest);
    List<PessoaListResponse> getAllPessoas();
}
