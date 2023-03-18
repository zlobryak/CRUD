package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.sys.AlreadyRegisteredException;
import ru.netology.sys.NotRegisteredException;
import ru.netology.sys.Player;

import java.util.ArrayList;
class GameTest {
  Game game = new Game();
  Player player1 = new Player(1, "Player1", 10);
  Player player2 = new Player(2, "Player2", 100);
  Player player3 = new Player(3, "Player3", 10);
  ArrayList<Player> AllPlayers = new ArrayList<>();

  @BeforeEach
  public void setup() {
    AllPlayers.add(player1);
    AllPlayers.add(player2);
    AllPlayers.add(player3);
  }
  @Test
  void register() {
    game.register(player1);
    game.register(player2);
    game.register(player3);
    ArrayList<Player> actual = game.findAll();
    Assertions.assertTrue(AllPlayers.equals(actual));
  }

  @Test
  void registerAlreadyRegisteredException() {
    game.register(player1);
    game.register(player2);
    game.register(player3);
    Assertions.assertThrows(AlreadyRegisteredException.class, () -> {
      game.register(player3);
    });
  }

  @Test
  void roundPlayer2Win() {
    game.register(player1);
    game.register(player2);
    int actual = game.round("Player1", "Player2");
    Assertions.assertEquals(2, actual);
  }
  @Test
  void roundPlayer1Win() {
    game.register(player1);
    game.register(player2);
    int actual = game.round("Player2", "Player1");
    Assertions.assertEquals(1, actual);
  }
  @Test
  void roundPlayerDraw() {
    game.register(player1);
    game.register(player3);
    int actual = game.round("Player3", "Player1");
    Assertions.assertEquals(0, actual);
  }

  @Test
  void roundNotRegisteredException1() {
    game.register(player1);
    game.register(player2);
    Assertions.assertThrows(NotRegisteredException.class, () -> {
      game.round("Player1", "Player3");
    });
  }
  @Test
  void roundNotRegisteredException2() {
    game.register(player1);
    game.register(player2);
    Assertions.assertThrows(NotRegisteredException.class, () -> {
      game.round("Player3", "Player1");
    });
  }
}