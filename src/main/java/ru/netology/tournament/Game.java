
package ru.netology.tournament;

import java.util.HashMap;

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
    if (allRegisteredPlayers.get(playerName1) != null) {
      if (allRegisteredPlayers.get(playerName2) != null) {
        if (allRegisteredPlayers.get(playerName1) > allRegisteredPlayers.get(playerName2)) {
          winnerIs = 1;
        } else if (allRegisteredPlayers.get(playerName1) < allRegisteredPlayers.get(playerName2)) {
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
