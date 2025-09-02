package com.example.player_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.player_service.Entity.Player;
import com.example.player_service.Repository.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    private  PlayerRepository playerRepo;

    public   Player register(Player player) {
        return playerRepo.save(player);
    }

    public   List<Player> search(String location, String position, String professionalism) {
        return playerRepo.searchPlayers(location, position, professionalism);
    }
    
    public boolean validate(String mobile , String Otp) {
   	 return playerRepo.findByMobile(mobile).isPresent() && Otp.equals("123456");
    }
    
    public Player searchByMobile(String mobile) {
    	return playerRepo.findByMobile(mobile).orElse(null);
    }
 }


