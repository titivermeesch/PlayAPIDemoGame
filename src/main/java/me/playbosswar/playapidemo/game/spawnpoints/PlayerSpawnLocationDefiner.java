package me.playbosswar.playapidemo.game.spawnpoints;

import me.playbosswar.playapi.arena.Arena;
import me.playbosswar.playapi.spawnpoints.SpawnPointDefiner;
import me.playbosswar.playapi.teams.Team;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayerSpawnLocationDefiner implements SpawnPointDefiner {
    @Override
    public Map<Player, Location> getSpawnLocationsForPlayers(Arena arena, List<Player> players) {
        if(players.size() > arena.getSpawnPoints().size()) {
            throw new Error("More players than spawn points!");
        }

        Iterator<Location> spawnPoints = arena.getSpawnPoints().iterator();

        return players.stream().collect(Collectors.toMap(Function.identity(), p -> spawnPoints.next()));
    }

    @Override
    public Map<Team, Location> getSpawnLocationsForTeams(Arena arena, List<Team> list) {
        return null;
    }
}
