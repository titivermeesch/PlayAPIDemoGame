package me.playbosswar.playapidemo;

import me.playbosswar.playapi.arena.Arena;
import me.playbosswar.playapi.storage.StorageManager;
import me.playbosswar.playapi.storage.adapters.YAMLAdapter;
import me.playbosswar.playapi.storage.exceptions.AdapterSetupFailedException;

public class Main {
    public static void main(String[] args) throws AdapterSetupFailedException {
        StorageManager storageManager = new StorageManager();
        YAMLAdapter<Arena> adapter = new YAMLAdapter<>(null, "arenas.yml", Arena.class);
        System.out.println(adapter);
        System.out.println(adapter.getClass());
        System.out.println(adapter.getClass().getGenericInterfaces().getClass().getName());
       // storageManager.registerStorageAdapter(Arena.class, adapter);
    }
}
