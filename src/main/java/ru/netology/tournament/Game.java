
package ru.netology.tournament;

import java.util.HashMap;
import java.util.Objects;
import ru.netology.sys.AlreadyRegisteredException;
import ru.netology.sys.NotRegisteredException;
import ru.netology.sys.Player;


public class Game {
  //  private List<Player> allRegisteredPlayers = new ArrayList<>();
  private HashMap<String, Integer> allRegisteredPlayers = new HashMap<>();
  public void register(Player player) {
    if (!allRegisteredPlayers.containsKey(player.getName())) {
      allRegisteredPlayers.put(player.getName(), player.getStrength());
    } else {
      throw new AlreadyRegisteredException(
              "Player " + player + " already registered"
      );
    }
  }

  public HashMap<String, Integer> findAll() {
    return allRegisteredPlayers;
  }

  public int round(String playerName1, String playerName2) {
    int winnerIs = 0;
    int strength1 = 0;
    int strenght2 = 0;

    for (String player : allRegisteredPlayers.keySet()) {
      if (Objects.equals(player, playerName1)) {
        strength1 = allRegisteredPlayers.get(player);
      } else if (Objects.equals(player, playerName2)) {
        strenght2 = allRegisteredPlayers.get(player);
      }
    }
    if (strength1 != 0) {
      if (strenght2 != 0) {
        if (strength1 > strenght2) {
          winnerIs = 1;
        } else if (strength1 < strenght2) {
          winnerIs = 2;
        }
      } else {
        throw new NotRegisteredException(
                playerName2 + " is not registered"
        );
      }
    } else {
      throw new NotRegisteredException(
              playerName1 + " is not registered"
      );
    }
    return winnerIs;
  }
}
