package tn.iit.spring.tp2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.iit.spring.tp2.entite.Langue;
import tn.iit.spring.tp2.entite.Mot;
//@RepositoryRestResource(path ="lang")
@Repository
public interface MotRepo extends JpaRepository<Mot, Long> {
Mot findByCle(long cle);
@Query("SELECT c  FROM Mot c WHERE c.langue =:langue and c.mot like :mot ")
List<Mot> findByLangueMot(@Param("langue") Langue l,@Param("mot") String mot);
//findOne getOne object languge avec meta data du hiberneate 
@Query("SELECT MAX(c.cle)  FROM Mot c WHERE c.langue =:langue ")
public long getMaxCle(@Param("langue") Langue l);
@Query("SELECT c  FROM Mot c WHERE c.langue =:langue and c.cle like :cle ")
Mot findByCleLangue(@Param("cle") long cle,@Param("langue") Langue langueOut);
}
