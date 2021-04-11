package com.example.javaserver.services;

import com.example.javaserver.models.LoginRegister;
import com.example.javaserver.models.PetInfo;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PetInfoService {
    private List<PetInfo> pets = new ArrayList<>();
    {

        PetInfo p1 = new PetInfo(234l, 1234l, "corgi", "orange", "female", 4, "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/14112506/Pembroke-Welsh-Corgi-standing-outdoors-in-the-fall.jpg", null, null, "adopatable", "cute doggy!", "San Jose", "95123");
        PetInfo p2 = new PetInfo(235l, 1235l, "husky", "apple", "male", 3, "https://i.pinimg.com/originals/8d/f1/30/8df130937d0403785d15b8be9d750a5c.jpg", null, null, "adopatable", "cute doggy!", "Seattle", "");
        PetInfo p3 = new PetInfo(236l, 1236l, "chihuahua", "bun", "female", 7, "", null, null, "adopatable", "cute doggy!", "New York City", "10001");
        PetInfo p4 = new PetInfo(237l, 1237l, "bichon", "dudu", "female", 9, "", null, null, "adopatable", "cute doggy!", "","");

        pets.add(p1);
        pets.add(p2);
        pets.add(p3);
        pets.add(p4);
    }

    public PetInfo createPet(Long userId, PetInfo pet) {

        pet.setUserId(userId);
        pet.setPetId((new Date()).getTime());
        pets.add(pet);
        return pet;
    }


    public List<PetInfo>  findPetByBreed(String breed) {

        List<PetInfo> pt = new ArrayList<>();
        for(PetInfo p:pets) {
            if(p.getBreed().equals(breed)) {
                pt.add(p);
            }
        }
        return pt;
    }

    public List<PetInfo> findAllPets(){return pets;}

    public List<PetInfo> findPetForId(Long pid) {
        List<PetInfo> pt = new ArrayList<>();
        for(PetInfo p:pets) {
            if(p.getPetId().equals(pid)) {
                pt.add(p);
            }
        }
        return pt;
    }


    public List<PetInfo> findPetForUser(Long userId) {
        List<PetInfo> pt = new ArrayList<>();
        for(PetInfo p:pets) {
            if(p.getUserId().equals(userId)) {
                pt.add(p);
            }
        }
        return pt;
    }

    public Integer deletePet(Long petId) {
        int index = -1;
        for(int i = 0; i < pets.size();i++) {
            if(pets.get(i).getPetId().equals(petId)){
                index = i;
                pets.remove(index);
                return 1;
            }
        }
        return -1;

    }

    public Integer updatePet(Long petId, PetInfo pet) {
        for(int i = 0; i < pets.size();i++) {
            if(pets.get(i).getPetId().equals(petId)){
                pets.set(i, pet);
                return 1;
            }
        }
        return -1;
    }



}
