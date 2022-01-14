package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer> {
    List<RecoveryRoom> findAll();
    
    @Query("Select p FROM RecoveryRoomType p")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    
    
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    
    @Query("Select p FROM RecoveryRoomType p WHERE p.name = :name")
    RecoveryRoomType getRecoveryRoomType(String name);
    
    @Query("Select p FROM RecoveryRoom p WHERE p.size > :size")
    List<RecoveryRoom> findBySizeMoreThan(double size);
}
