/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.dti.com.junior.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/**
 *
 * @author William
 */
@Entity
@Table( name = "produtos" )
@EntityListeners(AuditingEntityListener.class)
 
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cdProduto;
    
    @Column(name = "nmProduto", nullable = false)
    private String nmProduto;
    
    @Column(name = "qtProduto", nullable = false)
    private Integer qtProduto;
    
    @Column(name = "vlrProdC", nullable = false)
    private Integer vlrProdC;

    public Integer getCdProduto() {
        return cdProduto;
    }

    /**
     * @return the nmProduto
     */
    public String getNmProduto() {
        return nmProduto;
    }

    /**
     * @param nmProduto the nmProduto to set
     */
    public void setNmProduto(String nmProduto) {
        this.nmProduto = nmProduto;
    }

    /**
     * @return the qtProduto
     */
    public Integer getQtProduto() {
        return qtProduto;
    }

    /**
     * @param qtProduto the qtProduto to set
     */
    public void setQtProduto(Integer qtProduto) {
        this.qtProduto = qtProduto;
    }

    /**
     * @return the vlrProdC
     */
    public Integer getVlrProdC() {
        return vlrProdC;
    }

    /**
     * @param vlrProdC the vlrProdC to set
     */
    public void setVlrProdC(Integer vlrProdC) {
        this.vlrProdC = vlrProdC;
    }
}
