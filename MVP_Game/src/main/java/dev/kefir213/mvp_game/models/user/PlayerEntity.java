package dev.kefir213.mvp_game.models.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_users")
public class PlayerEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    UUID id;
    @Column(name = "c_username")
    String username;
    @Column(name="c_password")
    String password;
}
