package com.example.javaserver.repositories;
import com.example.javaserver.models.LoginRegister;
import com.example.javaserver.models.PetInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PetInfoRepository extends CrudRepository<PetInfo, Long>{
    @Query(value="SELECT * FROM pets WHERE user_id=:uid", nativeQuery = true)
    public List<PetInfo> findPetForUser(@Param("uid")Long userId);

    @Query(value="SELECT * FROM pets WHERE pet_id=:pid", nativeQuery = true)
    public PetInfo findPetForId(@Param("pid")Long pid);

    @Query(value="SELECT * FROM pets WHERE breed=:bd", nativeQuery = true)
    public List<PetInfo> findPetByBreed(@Param("bd")String breed);

//    @Query(value="INSERT INTO `webdev_sp21`.`pets` (`pet_id`, `age`) VALUES ('4', '3');", nativeQuery = true)
//    public PetInfo createPet(@Param("pid")Long userId, PetInfo pet);
}
