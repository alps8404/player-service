package com.example.player_service.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.player_service.Entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	@Query("SELECT p FROM Player p WHERE " +
		       "(:location IS NULL OR p.location = :location) AND " +
		       "(:position IS NULL OR p.position = :position) AND " +
		       "(:professionalism IS NULL OR p.professionalism = :professionalism)")
		List<Player> searchPlayers(@Param("location") String location,
		                           @Param("position") String position,
		                           @Param("professionalism") String professionalism);
	
	
	//If the User already logged in previously....
	 Optional<Player> findByMobile(String mobile);

}

