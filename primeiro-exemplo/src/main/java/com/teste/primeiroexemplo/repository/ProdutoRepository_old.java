package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.model.exception.ResourceNotFoundException;

//@Repository
public class ProdutoRepository_old {
    
    //Simulando um banco de dados
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * M�todo para retorna uma lista de produtos
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * M�todo que retorna o produto encontrado pelo seu Id.
     * @param id do produto que ser� localizado.
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional <Produto> obterPorId(Integer id){

        return produtos.stream()
        .filter(produto -> produto.getId() == id)
        .findFirst();
    }

    /**
     * M�todo para adicionar produto na lista.
     * @param produto que ser� adicionado
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * M�todo para deletar o produto por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * M�todo para atualizar o produto na lista
     * @param produto que ser� atualizado.
     * @return Retorna o produto ap�s atualizar a lista.
     */
    public Produto atualizar(Produto produto){

        //Encontra o produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if (produtoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        //Remove o produto antigo da lista. 
        deletar(produto.getId());

        //Adiciona o produto atualizado na lista.
        produtos.add(produto);

        return produto;
    }

}
