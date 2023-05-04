package lol.pyr.znpcsplus.entity;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import lol.pyr.znpcsplus.reflection.Reflections;
import lol.pyr.znpcsplus.util.VersionUtil;
import lol.pyr.znpcsplus.api.entity.PropertyHolder;
import lol.pyr.znpcsplus.packets.PacketFactory;
import lol.pyr.znpcsplus.util.ZLocation;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;

public class PacketEntity {
    private final PropertyHolder properties;
    private final int entityId;
    private final UUID uuid;

    private final EntityType type;
    private ZLocation location;

    public PacketEntity(PropertyHolder properties, EntityType type, ZLocation location) {
        this.properties = properties;
        this.entityId = reserveEntityID();
        this.uuid = UUID.randomUUID();
        this.type = type;
        this.location = location;
    }

    public int getEntityId() {
        return entityId;
    }

    public ZLocation getLocation() {
        return location;
    }

    public UUID getUuid() {
        return uuid;
    }

    public EntityType getType() {
        return type;
    }

    public void setLocation(ZLocation location, Collection<Player> viewers) {
        this.location = location;
        for (Player viewer : viewers) PacketFactory.get().teleportEntity(viewer, this);
    }

    public void spawn(Player player) {
        if (type == EntityTypes.PLAYER) PacketFactory.get().spawnPlayer(player, this, properties);
        else PacketFactory.get().spawnEntity(player, this, properties);
    }

    public void despawn(Player player) {
        PacketFactory.get().destroyEntity(player, this, properties);
    }

    public void refreshMeta(Player player) {
        PacketFactory.get().sendAllMetadata(player, this, properties);
    }

    private static int reserveEntityID() {
        if (VersionUtil.isNewerThan(14)) return Reflections.ATOMIC_ENTITY_ID_FIELD.get().incrementAndGet();
        else {
            int id = Reflections.ENTITY_ID_MODIFIER.get();
            Reflections.ENTITY_ID_MODIFIER.set(id + 1);
            return id;
        }
    }
}