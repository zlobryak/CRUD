package ru.netology.tournament;

import ru.netology.sys.AlreadyRegisteredException;
import ru.netology.sys.NotRegisteredException;
import ru.netology.sys.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
  List<Player> allRegisteredPlayers = new ArrayList<>();

  public void register(Player player) {
    if (!allRegisteredPlayers.contains(player)) {
      allRegisteredPlayers.add(player);
    } else {
      throw new AlreadyRegisteredException("Player " + player + " already registered");
    }
  }

  public ArrayList<Player> findAll() {
    return (ArrayList<Player>) allRegisteredPlayers;
  }

  public int round(String playerName1, String playerName2) {
    int winnerIs = 0;
    int strength1 = 0;
    int strenght2 = 0;

    for (Player player : allRegisteredPlayers) {
      if (Objects.equals(player.getName(), playerName1)) {
        strength1 = player.getStrength();
      } else if (Objects.equals(player.getName(), playerName2)) strenght2 = player.getStrength();
    }
    if (strength1 != 0) {
      if (strenght2 != 0) {
        if (strength1 > strenght2) {
          winnerIs = 1;
        } else if (strength1 < strenght2) {
          winnerIs = 2;
        }
      } else {
        throw new NotRegisteredException(playerName2 + " is not registered");
      }
    } else {
      throw new NotRegisteredException(playerName1 + " is not registered");
    }
    return winnerIs;
  }
}
