package dev.kefir213.mvp_game.services.playerServ;

import dev.kefir213.mvp_game.models.user.PlayerRequest;
import dev.kefir213.mvp_game.models.user.PlayerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PlayerService {
    PlayerResponse saveNewPlayer(PlayerRequest playerRequest);

    List<PlayerResponse> getAllPlayers();

    PlayerResponse findPlayerById(UUID id);
}
