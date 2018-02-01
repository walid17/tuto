package tn.iit.spring.tp2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.spring.tp2.entite.Langue;
@Repository
public interface LangueRepo extends JpaRepository<Langue, Long> {
Langue findByValue(String value);
//findOne getOne object languge avec meta data du hiberneate 
}
