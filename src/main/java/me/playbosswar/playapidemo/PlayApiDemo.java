package me.playbosswar.playapidemo;

import me.playbosswar.playapi.arena.Arena;
import me.playbosswar.playapi.arena.ArenaManager;
import me.playbosswar.playapi.storage.StorageManager;
import me.playbosswar.playapi.storage.adapters.YAMLAdapter;
import me.playbosswar.playapi.storage.exceptions.AdapterSetupFailedException;
import me.playbosswar.playapidemo.commands.ArenaCommands;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class PlayApiDemo extends JavaPlugin {
    private static PlayApiDemo instance;
    private ArenaManager arenaManager;
    private StorageManager storageManager;

    @Override
    public void onEnable() {
        instance = this;
        this.storageManager = new StorageManager();
        this.arenaManager = new ArenaManager(storageManager);

        getCommand("arena").setExecutor(new ArenaCommands());

        setup();
    }

    private void setup() {
        saveDefaultConfig();
        try {
            storageManager.registerStorageAdapter(Arena.class, new YAMLAdapter<>(this, "arenas.yml", Arena.class));
        } catch (AdapterSetupFailedException | IOException e) {
            e.printStackTrace();
        }
    }

    public static PlayApiDemo getInstance() {
        return instance;
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }
}
