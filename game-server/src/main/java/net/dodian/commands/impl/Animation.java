package net.dodian.commands.impl;

import net.dodian.commands.Command;
import net.dodian.commands.annotations.MaintenanceCommand;
import net.dodian.commands.annotations.Name;
import net.dodian.old.world.entity.impl.player.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Name("anim")
@MaintenanceCommand
@Component
public class Animation extends Command {

    @Override
    public boolean execute(Player player, List<String> parts) {
        if (!super.execute(player, parts)) {
            return false;
        }
        int id = Integer.parseInt(parts.get(0));
        player.performAnimation(new net.dodian.old.world.model.Animation(id));
        player.getPacketSender().sendMessage("did animation: " + id);
        return true;
    }
}
