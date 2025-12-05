package dt.Produtos.Jx21.repository;

import dt.Produtos.Jx21.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Produto, Long> {
    List<Produto> findByNome(String nome);
    List<Produto> findByNomeContaining(String parteDoNome);
}
