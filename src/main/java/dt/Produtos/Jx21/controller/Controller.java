package dt.Produtos.Jx21.controller;

import dt.Produtos.Jx21.model.Produto;
import dt.Produtos.Jx21.repository.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class Controller {
    private final Repository repository;

    public Controller(Repository repository){
        this.repository = repository;
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto){
        return repository.save(produto);
    }

    @GetMapping
    public List<Produto> Listar(){
        return repository.findAll();
    }

    @GetMapping("/{Id}")
    public Produto Buscar(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{Id}")
    public Produto Atualizar(@PathVariable Long id, @RequestBody Produto novoProduto){
        return repository.findById(id).map(produto -> {
            produto.setNome(novoProduto.getNome());
            produto.setPreco(novoProduto.getPreco());

            return repository.save(produto);
        }).orElse(null);
    }

    @DeleteMapping("/{Id}")
    public void Deletar(@PathVariable Long id){
        repository.deleteById(id);
    }


}
