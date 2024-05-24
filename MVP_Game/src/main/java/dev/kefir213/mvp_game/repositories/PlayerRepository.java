package dev.kefir213.mvp_game.repositories;

import dev.kefir213.mvp_game.models.user.PlayerEntity;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, UUID> {
}
