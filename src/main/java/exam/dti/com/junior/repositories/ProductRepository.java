/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.dti.com.junior.repositories;

import exam.dti.com.junior.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author William
 */
@Repository
public interface ProductRepository extends JpaRepository<Produto, Integer> {}
