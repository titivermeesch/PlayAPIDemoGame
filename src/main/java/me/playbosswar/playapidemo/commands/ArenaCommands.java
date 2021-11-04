package me.playbosswar.playapidemo.commands;

import me.playbosswar.playapi.arena.Arena;
import me.playbosswar.playapi.exceptions.AlreadyRegisteredException;
import me.playbosswar.playapi.storage.exceptions.AdapterTransactionException;
import me.playbosswar.playapidemo.PlayApiDemo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.UUID;

/**
 * /arena create name
 * /a
 */
public class ArenaCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Arena arena = new Arena("Test arena", UUID.randomUUID());
        try {
            PlayApiDemo.getInstance().getArenaManager().registerArena(arena);
        } catch (AdapterTransactionException | AlreadyRegisteredException e) {
            e.printStackTrace();
        }
        return true;
    }
}
