package com.example.player_service.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.player_service.Entity.Player;
import com.example.player_service.Service.PlayerService;

@RestController
@RequestMapping("/api/players")
@CrossOrigin("*")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

	@PostMapping("/save")
    public ResponseEntity<Player> registerPlayer(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.register(player));
    }

	@GetMapping("/search")
    public ResponseEntity<List<Player>> searchPlayers(
        @RequestParam(required = false) String location,
        @RequestParam(required = false) String position,
        @RequestParam(required = false) String professionalism
    ) {
        return ResponseEntity.ok(playerService.search(location, position, professionalism));
    }
	
	@SuppressWarnings("null")
	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestParam String mobile){
		Player player =playerService.searchByMobile(mobile);
		if(player!=null) {
			System.out.println("Player exists for mobie:"+mobile);
			return ResponseEntity.ok().body(player);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found");
	}
	
}

