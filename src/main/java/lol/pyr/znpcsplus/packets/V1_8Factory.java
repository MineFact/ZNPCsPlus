package lol.pyr.znpcsplus.packets;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.protocol.player.GameMode;
import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import io.github.znetworkw.znpcservers.npc.NPCSkin;
import lol.pyr.znpcsplus.ZNPCsPlus;
import lol.pyr.znpcsplus.entity.PacketEntity;
import lol.pyr.znpcsplus.entity.PacketLocation;
import lol.pyr.znpcsplus.metadata.MetadataFactory;
import lol.pyr.znpcsplus.npc.NPC;
import lol.pyr.znpcsplus.npc.NPCProperty;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Optional;

public class V1_8Factory implements PacketFactory {
    @Override
    public void spawnPlayer(Player player, PacketEntity entity) {
        NPC owner = entity.getOwner();
        addTabPlayer(player, entity);
        createTeam(player, entity);
        PacketLocation location = entity.getLocation();
        sendPacket(player, new WrapperPlayServerSpawnPlayer(entity.getEntityId(),
                entity.getUuid(), location.toVector3d(), location.getYaw(), location.getPitch(), List.of()));
        if (owner.getProperty(NPCProperty.SKIN_LAYERS)) sendMetadata(player, entity, MetadataFactory.get().skinLayers());
        boolean glow = owner.hasProperty(NPCProperty.GLOW);
        boolean fire = owner.getProperty(NPCProperty.FIRE);
        if (glow || fire) sendMetadata(player, entity, MetadataFactory.get().effects(fire, glow));
        ZNPCsPlus.SCHEDULER.scheduleSyncDelayedTask(() -> removeTabPlayer(player, entity), 60);
    }

    @Override
    public void spawnEntity(Player player, PacketEntity entity) {
        PacketLocation location = entity.getLocation();
        EntityType type = entity.getType();
        ClientVersion clientVersion = PacketEvents.getAPI().getServerManager().getVersion().toClientVersion();
        sendPacket(player, type.getLegacyId(clientVersion) == -1 ?
                new WrapperPlayServerSpawnLivingEntity(entity.getEntityId(), entity.getUuid(), type, location.toVector3d(),
                        location.getYaw(), location.getPitch(), location.getPitch(), new Vector3d(), List.of()) :
                new WrapperPlayServerSpawnEntity(entity.getEntityId(), Optional.of(entity.getUuid()), entity.getType(), location.toVector3d(),
                        location.getPitch(), location.getYaw(), location.getYaw(), 0, Optional.empty()));
    }

    @Override
    public void destroyEntity(Player player, PacketEntity entity) {
        sendPacket(player, new WrapperPlayServerDestroyEntities(entity.getEntityId()));
        if (entity.getType() == EntityTypes.PLAYER) removeTeam(player, entity);
    }

    @Override
    public void teleportEntity(Player player, PacketEntity entity) {
        PacketLocation location = entity.getLocation();
        sendPacket(player, new WrapperPlayServerEntityTeleport(entity.getEntityId(),
                location.toVector3d(), location.getYaw(), location.getPitch(), true));
    }

    @Override
    public void addTabPlayer(Player player, PacketEntity entity) {
        if (entity.getType() != EntityTypes.PLAYER) return;
        sendPacket(player, new WrapperPlayServerPlayerInfo(
                WrapperPlayServerPlayerInfo.Action.ADD_PLAYER, new WrapperPlayServerPlayerInfo.PlayerData(Component.text(""),
                skinned(entity, new UserProfile(entity.getUuid(), Integer.toString(entity.getEntityId()))), GameMode.CREATIVE, 1)));
    }

    @Override
    public void removeTabPlayer(Player player, PacketEntity entity) {
        if (entity.getType() != EntityTypes.PLAYER) return;
        sendPacket(player, new WrapperPlayServerPlayerInfo(
                WrapperPlayServerPlayerInfo.Action.REMOVE_PLAYER, new WrapperPlayServerPlayerInfo.PlayerData(null,
                new UserProfile(entity.getUuid(), null), null, -1)));
    }

    @Override
    public void createTeam(Player player, PacketEntity entity) {
        NPC owner = entity.getOwner();
        sendPacket(player, new WrapperPlayServerTeams("npc_team_" + entity.getEntityId(), WrapperPlayServerTeams.TeamMode.CREATE, new WrapperPlayServerTeams.ScoreBoardTeamInfo(
                Component.empty(), Component.empty(), Component.empty(),
                WrapperPlayServerTeams.NameTagVisibility.NEVER,
                WrapperPlayServerTeams.CollisionRule.NEVER,
                owner.hasProperty(NPCProperty.GLOW) ? owner.getProperty(NPCProperty.GLOW) : NamedTextColor.WHITE,
                WrapperPlayServerTeams.OptionData.NONE
        )));
        sendPacket(player, new WrapperPlayServerTeams("npc_team_" + entity.getEntityId(), WrapperPlayServerTeams.TeamMode.ADD_ENTITIES, (WrapperPlayServerTeams.ScoreBoardTeamInfo) null, Integer.toString(entity.getEntityId())));
    }

    @Override
    public void removeTeam(Player player, PacketEntity entity) {
        sendPacket(player, new WrapperPlayServerTeams("npc_team_" + entity.getEntityId(), WrapperPlayServerTeams.TeamMode.REMOVE, (WrapperPlayServerTeams.ScoreBoardTeamInfo) null));
    }

    @Override
    public void sendMetadata(Player player, PacketEntity entity, EntityData... data) {
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, new WrapperPlayServerEntityMetadata(entity.getEntityId(), List.of(data)));
    }

    protected void sendPacket(Player player, PacketWrapper<?> packet) {
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }

    protected UserProfile skinned(PacketEntity entity, UserProfile profile) {
        NPC owner = entity.getOwner();
        if (!owner.hasProperty(NPCProperty.SKIN)) return profile;
        NPCSkin skin = owner.getProperty(NPCProperty.SKIN);
        profile.setTextureProperties(List.of(new TextureProperty("textures", skin.getTexture(), skin.getSignature())));
        return profile;
    }
}
