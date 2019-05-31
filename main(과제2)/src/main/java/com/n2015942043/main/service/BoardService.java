package com.n2015942043.main.service;

import com.n2015942043.main.domain.Basic;
import com.n2015942043.main.domain.Profile;
import com.n2015942043.main.repository.BasicRepository;
import com.n2015942043.main.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private BasicRepository basicRepository;
    private ProfileRepository profileRepository;

    public BoardService(BasicRepository basicRepository, ProfileRepository profileRepository) {
        this.basicRepository = basicRepository;
        this.profileRepository = profileRepository;
    }
    public Basic findBasicByIdx(Long idx){
        return basicRepository.findById(idx).orElse(null);
    }
    public Profile findProfileByIdx(Long idx){
        return profileRepository.findById(idx).orElse(null);
    }

    public List<Basic> findBasicAll(){
        return basicRepository.findAll();
    }

    public List<Profile> findProfileAll(){
        return profileRepository.findAll();
    }

    public Basic saveBasic(Basic basic){
        return basicRepository.save(basic);
    }
    public Profile saveProfile(Profile profile){
        return profileRepository.save(profile);
    }
}
