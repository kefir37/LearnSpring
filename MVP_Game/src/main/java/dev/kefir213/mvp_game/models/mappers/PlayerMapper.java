package dev.kefir213.mvp_game.models.mappers;

import dev.kefir213.mvp_game.models.user.PlayerEntity;
import dev.kefir213.mvp_game.models.user.PlayerRequest;
import dev.kefir213.mvp_game.models.user.PlayerResponse;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    public PlayerEntity toEntity(PlayerRequest request){
        if(request==null){
            throw new IllegalArgumentException();
        }
        return new PlayerEntity(null, request.getUsername(), request.getPassword());
    }
    public PlayerResponse toResponse(PlayerEntity entity){
        if(entity==null){
            throw new IllegalArgumentException();
        }
        return new PlayerResponse(entity.getUsername(), entity.getPassword());
    }
}
