package gerenciamento.com.lira.gerenciapessoas.pessoa.application.service;

import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.request.PessoaRequest;
import gerenciamento.com.lira.gerenciapessoas.pessoa.application.api.response.PessoaResponse;

public interface PessoaService {
    PessoaResponse postPessoa(PessoaRequest pessoaRequest);
}
