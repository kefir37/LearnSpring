package dev.kefir213.mvp_game.controllers;

import dev.kefir213.mvp_game.models.user.PlayerRequest;
import dev.kefir213.mvp_game.models.user.PlayerResponse;
import dev.kefir213.mvp_game.services.playerServ.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/player-api")
public class PlayerRestController {
    private final PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerResponse> createPlayer(@Valid @RequestBody PlayerRequest playerRequest){
        PlayerResponse response = playerService.saveNewPlayer(playerRequest);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getAllPlayers(){
        List<PlayerResponse> responses = playerService.getAllPlayers();
        return ResponseEntity.ok().body(responses);
    }
    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerResponse> getPlayerById(@PathVariable UUID playerId){
        PlayerResponse response= playerService.findPlayerById(playerId);
        return ResponseEntity.ok().body(response);
    }
}
