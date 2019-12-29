/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.dti.com.junior.controllers;

import exam.dti.com.junior.repositories.ProductRepository;
import exam.dti.com.junior.models.Produto;
import exam.dti.com.junior.exceptions.NonexistentEntityException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author William
 */

@RestController
@RequestMapping("/api/v1")
public class ProdutoController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping("/produtos")
    public List<Produto> getAllProducts(){
        return productRepository.findAll();
    }
    
    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable(value = "id") Integer productId)
            throws NonexistentEntityException
        {
        Produto produto = productRepository
                .findById(productId)
                .orElseThrow( () -> new NonexistentEntityException("Product not found :: "+ productId));
            return ResponseEntity.ok().body(produto);
    }
    
    @PostMapping("/produtos")
    public Produto createProduct(@Valid @RequestBody Produto product){
        return productRepository.save(product);
    }   
    
    @PutMapping("/produtos/{id}")
    public ResponseEntity<?> saveProduct(@RequestBody Produto produto, @PathVariable("id") Integer id){
        productRepository.save(produto);
        return ResponseEntity.ok("Atualizado!") ;
    };
    
    @PatchMapping("/produtos/{id}")
    public ResponseEntity<?> updateProductPartial(@RequestBody Produto produto, @PathVariable("id") Integer id)
        throws NonexistentEntityException{
        Produto myProduto = productRepository
                .findById(id)
                .orElseThrow( () -> new NonexistentEntityException("Product not found :: "+ id));
        
        if(null != produto.getNmProduto()){
            myProduto.setNmProduto(produto.getNmProduto());
        }
        
        if(null != produto.getQtProduto()){
            myProduto.setQtProduto(produto.getQtProduto());
        }
        
        if(produto.getVlrProdC() != null){
            myProduto.setVlrProdC(produto.getVlrProdC());
        }
        
        productRepository.save(myProduto);        
        
        return ResponseEntity.ok("Atualizado!") ;
    };
    
}
