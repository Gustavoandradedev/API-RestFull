package com.teste.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> obterTodos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.findById(id);
    }

    /**
     * M�todo para adicionar produto na lista.
     * @param produto que ser� adicionado
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        return produtoRepository.save(produto);
    }

        /**
     * M�todo para deletar o produto por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        produtoRepository.deleteById(id);
    }

        /**
     * M�todo para atualizar o produto na lista
     * @param produto que ser� atualizado.
     * @param id do produto
     * @return Retorna o produto ap�s atualizar a lista.
     */
    public Produto atualizar(Integer id, Produto produto){

        produto.setId(id);

        return produtoRepository.save(produto);
    }

}
