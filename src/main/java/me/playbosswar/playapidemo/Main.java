package me.playbosswar.playapidemo;

import me.playbosswar.playapi.arena.Arena;
import me.playbosswar.playapi.storage.StorageManager;
import me.playbosswar.playapi.storage.adapters.YAMLAdapter;
import me.playbosswar.playapi.storage.exceptions.AdapterSetupFailedException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws AdapterSetupFailedException, IOException {
        StorageManager storageManager = new StorageManager();
        YAMLAdapter<Arena> adapter = new YAMLAdapter<>(null, "arenas.yml");
        storageManager.registerStorageAdapter(Arena.class, adapter);
    }
}
