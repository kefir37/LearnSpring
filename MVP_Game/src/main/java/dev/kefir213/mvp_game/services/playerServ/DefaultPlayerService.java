package dev.kefir213.mvp_game.services.playerServ;

import dev.kefir213.mvp_game.models.mappers.PlayerMapper;
import dev.kefir213.mvp_game.models.user.PlayerEntity;
import dev.kefir213.mvp_game.models.user.PlayerRequest;
import dev.kefir213.mvp_game.models.user.PlayerResponse;
import dev.kefir213.mvp_game.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultPlayerService implements PlayerService {
    private final PlayerRepository repository;
    private final PlayerMapper mapper;

    @Override
    public PlayerResponse saveNewPlayer(PlayerRequest playerRequest) {
        repository.save(new PlayerEntity(null, playerRequest.getUsername(), playerRequest.getPassword()));
        return new PlayerResponse(playerRequest.getUsername(), playerRequest.getPassword());
    }

    @Override
    public List<PlayerResponse> getAllPlayers() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public PlayerResponse findPlayerById(UUID id) {
        return repository.findById(id).map(mapper::toResponse).orElseThrow(IllegalArgumentException::new);
    }
}
