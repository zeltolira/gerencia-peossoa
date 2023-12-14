package gerenciamento.com.lira.gerenciapessoas.endereco.application.infra;

import gerenciamento.com.lira.gerenciapessoas.endereco.application.repository.EnderecoRepository;
import gerenciamento.com.lira.gerenciapessoas.endereco.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EnderecoInfraRepository implements EnderecoRepository {
    private final EnderecoSpringDataJPAREpository enderecoSpringDataJPAREpository;

    @Override
    public Endereco saveEndereco(Endereco endereco) {
        log.info("[start] EnderecoInfraRepository - saveEndereco");
        enderecoSpringDataJPAREpository.save(endereco);
        log.info("[finish] EnderecoInfraRepository - saveEndereco");
        return endereco;
    }


}
