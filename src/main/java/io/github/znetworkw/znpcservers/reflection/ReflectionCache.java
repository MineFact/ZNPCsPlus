package io.github.znetworkw.znpcservers.reflection;

import com.mojang.authlib.GameProfile;
import io.github.znetworkw.znpcservers.reflection.types.*;
import io.github.znetworkw.znpcservers.utility.Utils;
import io.netty.channel.Channel;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public final class ReflectionCache {
    public static final Class<?> PACKET_PLAY_IN_USE_ENTITY_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayInUseEntity")).get();

    public static final Class<?> ENUM_PLAYER_INFO_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutPlayerInfo$EnumPlayerInfoAction")
            .withClassName("ClientboundPlayerInfoUpdatePacket$a")).get();

    public static final Class<?> PACKET_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.PROTOCOL)
            .withClassName("Packet")).get();

    public static final Class<?> ENTITY_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withClassName("Entity")).get();

    public static final Class<?> ENTITY_LIVING = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withClassName("EntityLiving")).get();

    public static final Class<?> ENTITY_PLAYER_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.SERVER_LEVEL)
            .withClassName("EntityPlayer")).get();

    public static final Class<?> ENTITY_ARMOR_STAND_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("decoration")
            .withClassName("EntityArmorStand")).get();

    public static final Class<?> ENTITY_BAT_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("ambient")
            .withClassName("EntityBat")).get();

    public static final Class<?> ENTITY_BLAZE_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntityBlaze")).get();

    public static final Class<?> ENTITY_CAVE_SPIDER_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntityCaveSpider")).get();

    public static final Class<?> ENTITY_CHICKEN_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityChicken")).get();

    public static final Class<?> ENTITY_COW_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityCow")).get();

    public static final Class<?> ENTITY_CREEPER_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntityCreeper")).get();

    public static final Class<?> ENTITY_ENDER_DRAGON_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("boss.enderdragon")
            .withClassName("EntityEnderDragon")).get();

    public static final Class<?> ENTITY_ENDERMAN_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntityEnderman")).get();

    public static final Class<?> ENTITY_HUMAN_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("player")
            .withClassName("EntityHuman")).get();

    public static final Class<?> ENTITY_ENDERMITE_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntityEndermite")).get();

    public static final Class<?> ENTITY_GHAST_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntityGhast")).get();

    public static final Class<?> ENTITY_IRON_GOLEM_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityIronGolem")).get();

    public static final Class<?> ENTITY_GIANT_ZOMBIE_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntityGiantZombie")).get();

    public static final Class<?> ENTITY_GUARDIAN_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntityGuardian")).get();

    public static final Class<?> ENTITY_HORSE_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal.horse")
            .withClassName("EntityHorse")).get();

    public static final Class<?> ENTITY_LLAMA_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal.horse")
            .withClassName("EntityLlama")).get(!Utils.versionNewer(11));

    public static final Class<?> ENTITY_MAGMA_CUBE_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntityMagmaCube")).get();

    public static final Class<?> ENTITY_MUSHROOM_COW_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityMushroomCow")).get();

    public static final Class<?> ENTITY_OCELOT_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityOcelot")).get();

    public static final Class<?> ENTITY_TURTLE = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityTurtle")).get(!Utils.versionNewer(13));

    public static final Class<?> ENTITY_WARDEN = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster.warden")
            .withClassName("EntityWarden")
            .withClassName("Warden")).get(!Utils.versionNewer(19));

    public static final Class<?> ENTITY_BEE_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityBee")).get(!Utils.versionNewer(15));

    public static final Class<?> ENTITY_PARROT_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityParrot")).get(!Utils.versionNewer(12));

    public static final Class<?> ENTITY_PIG_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityPig")).get();

    public static final Class<?> ENTITY_RABBIT_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityRabbit")).get();

    public static final Class<?> ENTITY_POLAR_BEAR_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityPolarBear")).get(!Utils.versionNewer(10));

    public static final Class<?> ENTITY_PANDA_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityPanda")).get(!Utils.versionNewer(14));

    public static final Class<?> ENTITY_SHEEP_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntitySheep")).get();

    public static final Class<?> ENTITY_SNOWMAN_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntitySnowman")).get();

    public static final Class<?> ENTITY_SHULKER_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntityShulker")).get(!Utils.versionNewer(9));

    public static final Class<?> ENTITY_SILVERFISH_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntitySilverfish")).get();

    public static final Class<?> ENTITY_SKELETON_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntitySkeleton")).get();

    public static final Class<?> ENTITY_SLIME_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntitySlime")).get();

    public static final Class<?> ENTITY_SPIDER_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntitySpider")).get();

    public static final Class<?> ENTITY_SQUID_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntitySquid")).get();

    public static final Class<?> ENTITY_VILLAGER_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("npc")
            .withClassName("EntityVillager")).get();

    public static final Class<?> ENTITY_WITCH_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntityWitch")).get();

    public static final Class<?> ENTITY_WITHER_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("boss.wither")
            .withClassName("EntityWither")).get();

    public static final Class<?> ENTITY_ZOMBIE_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("monster")
            .withClassName("EntityZombie")).get();

    public static final Class<?> ENTITY_WOLF_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityWolf")).get();

    public static final Class<?> ENTITY_AXOLOTL_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal.axolotl")
            .withClassName("Axolotl")).get(!Utils.versionNewer(17));

    public static final Class<?> ENTITY_GOAT_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal.goat")
            .withClassName("Goat")).get(!Utils.versionNewer(17));

    public static final Class<?> ENTITY_FOX_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withSubClass("animal")
            .withClassName("EntityFox")).get(!Utils.versionNewer(14));

    public static final Class<?> ENTITY_TYPES_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withClassName("EntityTypes")).get();

    public static final Class<?> ENUM_CHAT_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.MINECRAFT)
            .withClassName("EnumChatFormat")).get();

    public static final Class<?> ENUM_ITEM_SLOT = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withClassName("EnumItemSlot")).get(!Utils.versionNewer(9));

    public static final Class<?> I_CHAT_BASE_COMPONENT = new ClassReflection(new ReflectionBuilder(ReflectionPackage.CHAT)
            .withClassName("IChatBaseComponent")).get();

    public static final Class<?> ITEM_STACK_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.ITEM)
            .withClassName("ItemStack")).get();

    public static final Class<?> DATA_WATCHER_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.SYNCHER)
            .withClassName("DataWatcher")).get(!Utils.versionNewer(9));

    public static final Class<?> DATA_WATCHER_OBJECT = new ClassReflection(new ReflectionBuilder(ReflectionPackage.SYNCHER)
            .withClassName("DataWatcherObject")).get(!Utils.versionNewer(9));

    public static final Class<?> DATA_WATCHER_REGISTRY = new ClassReflection(new ReflectionBuilder(ReflectionPackage.SYNCHER)
            .withClassName("DataWatcherRegistry")).get(!Utils.versionNewer(9));

    public static final Class<?> DATA_WATCHER_SERIALIZER = new ClassReflection(new ReflectionBuilder(ReflectionPackage.SYNCHER)
            .withClassName("DataWatcherSerializer")).get(!Utils.versionNewer(9));

    public static final Class<?> WORLD_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.WORLD_LEVEL)
            .withClassName("World")).get();

    public static final Class<?> CRAFT_ITEM_STACK_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.BUKKIT)
            .withClassName("inventory.CraftItemStack")).get();

    public static final Class<?> WORLD_SERVER_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.SERVER_LEVEL)
            .withClassName("WorldServer")).get();

    public static final Class<?> MINECRAFT_SERVER_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.SERVER)
            .withClassName("MinecraftServer")).get();

    public static final Class<?> PLAYER_INTERACT_MANAGER_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.SERVER_LEVEL)
            .withClassName("PlayerInteractManager")).get();

    public static final Class<?> PLAYER_CONNECTION_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.SERVER_NETWORK)
            .withClassName("PlayerConnection")).get();

    public static final Class<?> NETWORK_MANAGER_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.NETWORK)
            .withClassName("NetworkManager")).get();

    public static final Class<?> PACKET_PLAY_OUT_PLAYER_INFO_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutPlayerInfo")
            .withClassName("ClientboundPlayerInfoUpdatePacket"))
            .get();

    public static final Class<?> PACKET_PLAY_OUT_PLAYER_INFO_REMOVE_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("ClientboundPlayerInfoRemovePacket"))
            .get(true);

    public static final Class<?> PACKET_PLAY_OUT_SCOREBOARD_TEAM_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutScoreboardTeam")).get();

    public static final Class<?> PACKET_PLAY_OUT_ENTITY_DESTROY_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutEntityDestroy")).get();

    public static final Class<?> SCOREBOARD_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.WORLD_SCORES)
            .withClassName("Scoreboard")).get();

    public static final Class<?> SCOREBOARD_TEAM_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.WORLD_SCORES)
            .withClassName("ScoreboardTeam")).get();

    public static final Class<?> ENUM_TAG_VISIBILITY = new ClassReflection(new ReflectionBuilder(ReflectionPackage.WORLD_SCORES)
            .withClassName("ScoreboardTeamBase$EnumNameTagVisibility")).get();

    public static final Class<?> CRAFT_CHAT_MESSAGE_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.BUKKIT)
            .withClassName("util.CraftChatMessage")).get();

    public static final Class<?> PROFILE_PUBLIC_KEY_CLASS = new ClassReflection(new ReflectionBuilder(ReflectionPackage.WORLD_ENTITY_PLAYER)
            .withClassName("ProfilePublicKey")).get(!Utils.versionNewer(19));

    public static final BaseReflection<Constructor<?>> SCOREBOARD_TEAM_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(SCOREBOARD_TEAM_CLASS)
            .withParameterTypes(SCOREBOARD_CLASS, String.class));

    public static final BaseReflection<Constructor<?>> PLAYER_CONSTRUCTOR_OLD = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENTITY_PLAYER_CLASS)
            .withParameterTypes(MINECRAFT_SERVER_CLASS, WORLD_SERVER_CLASS, GameProfile.class, PLAYER_INTERACT_MANAGER_CLASS));

    public static final BaseReflection<Constructor<?>> PLAYER_CONSTRUCTOR_NEW = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENTITY_PLAYER_CLASS)
            .withParameterTypes(MINECRAFT_SERVER_CLASS, WORLD_SERVER_CLASS, GameProfile.class));

    public static final BaseReflection<Constructor<?>> PLAYER_CONSTRUCTOR_NEW_1 = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENTITY_PLAYER_CLASS)
            .withParameterTypes(MINECRAFT_SERVER_CLASS, WORLD_SERVER_CLASS, GameProfile.class, PROFILE_PUBLIC_KEY_CLASS));

    public static final BaseReflection<Constructor<?>> PLAYER_CONSTRUCTOR_NEW_2 = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENTITY_PLAYER_CLASS)
            .withParameterTypes(MINECRAFT_SERVER_CLASS, WORLD_SERVER_CLASS, GameProfile.class));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_PLAYER_INFO_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(PACKET_PLAY_OUT_PLAYER_INFO_CLASS)
            .withParameterTypes(ENUM_PLAYER_INFO_CLASS, (Utils.BUKKIT_VERSION > 16) ? Collection.class : Iterable.class).withParameterTypes(ENUM_PLAYER_INFO_CLASS, ENTITY_PLAYER_CLASS));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_PLAYER_INFO_REMOVE_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(PACKET_PLAY_OUT_PLAYER_INFO_REMOVE_CLASS)
            .withParameterTypes(List.class));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_ENTITY_LOOK_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutEntity$PacketPlayOutEntityLook")
            .withParameterTypes(int.class, byte.class, byte.class, boolean.class));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_ENTITY_HEAD_ROTATION_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutEntityHeadRotation")
            .withParameterTypes(ENTITY_CLASS, byte.class));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_ENTITY_TELEPORT_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutEntityTeleport")
            .withParameterTypes(ENTITY_CLASS));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_ENTITY_META_DATA_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutEntityMetadata")
            .withParameterTypes(int.class, DATA_WATCHER_CLASS, boolean.class));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_ENTITY_META_DATA_CONSTRUCTOR_V1 = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutEntityMetadata")
            .withParameterTypes(int.class, List.class));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_NAMED_ENTITY_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutNamedEntitySpawn")
            .withParameterTypes(ENTITY_HUMAN_CLASS));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_ENTITY_DESTROY_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(PACKET_PLAY_OUT_ENTITY_DESTROY_CLASS)
            .withParameterTypes(int.class).withParameterTypes(int[].class));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_SPAWN_ENTITY_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutSpawnEntity")
            .withClassName("PacketPlayOutSpawnEntityLiving")
            .withParameterTypes(ENTITY_LIVING).withParameterTypes(ENTITY_CLASS));

    public static final BaseReflection<Constructor<?>> PLAYER_INTERACT_MANAGER_OLD_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PlayerInteractManager")
            .withParameterTypes(WORLD_CLASS));

    public static final BaseReflection<Constructor<?>> PLAYER_INTERACT_MANAGER_NEW_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PlayerInteractManager")
            .withParameterTypes(WORLD_SERVER_CLASS));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_SCOREBOARD_TEAM_CONSTRUCTOR_OLD = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(PACKET_PLAY_OUT_SCOREBOARD_TEAM_CLASS));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_ENTITY_EQUIPMENT_CONSTRUCTOR_OLD = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutEntityEquipment")
            .withParameterTypes(int.class, int.class, ITEM_STACK_CLASS));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_ENTITY_EQUIPMENT_CONSTRUCTOR_NEWEST_OLD = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutEntityEquipment")
            .withParameterTypes(int.class, ENUM_ITEM_SLOT, ITEM_STACK_CLASS));

    public static final BaseReflection<Constructor<?>> PACKET_PLAY_OUT_ENTITY_EQUIPMENT_CONSTRUCTOR_V1 = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutEntityEquipment")
            .withParameterTypes(int.class, List.class));

    public static final BaseReflection<Constructor<?>> I_CHAT_BASE_COMPONENT_A_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.CHAT)
            .withClassName("ChatComponentText")
            .withParameterTypes(String.class));

    public static final BaseReflection<Constructor<?>> ENTITY_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENTITY_ARMOR_STAND_CLASS)
            .withParameterTypes(WORLD_CLASS, double.class, double.class, double.class));

    public static final BaseReflection<Constructor<?>> DATA_WATCHER_OBJECT_CONSTRUCTOR = new ConstructorReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(DATA_WATCHER_OBJECT)
            .withParameterTypes(int.class, DATA_WATCHER_SERIALIZER));

    public static final BaseReflection<Method> AS_NMS_COPY_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.BUKKIT)
            .withClassName("inventory.CraftItemStack")
            .withMethodName("asNMSCopy")
            .withParameterTypes(ItemStack.class));

    public static final BaseReflection<Method> GET_PROFILE_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withClassName(ENTITY_HUMAN_CLASS)
            .withExpectResult(GameProfile.class));

    public static final BaseReflection<Method> GET_ENTITY_ID = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENTITY_CLASS)
            .withMethodName("getId")
            .withMethodName("ae")
            .withMethodName("ah")
            .withMethodName("af")
            .withExpectResult(int.class));

    public static final BaseReflection<Method> GET_HANDLE_PLAYER_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.BUKKIT)
            .withClassName("entity.CraftPlayer").withClassName("entity.CraftHumanEntity")
            .withMethodName("getHandle"));

    public static final BaseReflection<Method> GET_HANDLE_WORLD_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.BUKKIT)
            .withClassName("CraftWorld")
            .withMethodName("getHandle"));

    public static final BaseReflection<Method> GET_SERVER_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.BUKKIT)
            .withClassName("CraftServer")
            .withMethodName("getServer"));

    public static final BaseReflection<Method> SEND_PACKET_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(PLAYER_CONNECTION_CLASS)
            .withMethodName("sendPacket").withMethodName("a")
            .withParameterTypes(PACKET_CLASS));

    public static final BaseReflection<Method> SET_CUSTOM_NAME_OLD_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENTITY_CLASS)
            .withMethodName("setCustomName")
            .withParameterTypes(String.class));

    public static final BaseReflection<Method> SET_CUSTOM_NAME_NEW_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENTITY_CLASS)
            .withMethodName("setCustomName")
            .withMethodName("a")
            .withMethodName("b")
            .withParameterTypes(I_CHAT_BASE_COMPONENT).withExpectResult(void.class));

    public static final BaseReflection<Method> SET_CUSTOM_NAME_VISIBLE_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENTITY_CLASS)
            .withMethodName("setCustomNameVisible")
            .withMethodName("n")
            .withParameterTypes(boolean.class));

    public static final BaseReflection<Method> SET_INVISIBLE_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENTITY_ARMOR_STAND_CLASS)
            .withMethodName("setInvisible").withMethodName("j")
            .withParameterTypes(boolean.class));

    public static final BaseReflection<Method> SET_LOCATION_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENTITY_CLASS)
            .withMethodName("setPositionRotation")
            .withMethodName("a")
            .withParameterTypes(double.class, double.class, double.class, float.class, float.class));

    public static final BaseReflection<Method> SET_DATA_WATCHER_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(DATA_WATCHER_CLASS)
            .withMethodName("set").withMethodName("b")
            .withParameterTypes(DATA_WATCHER_OBJECT, Object.class));

    public static final BaseReflection<Method> WATCH_DATA_WATCHER_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(DATA_WATCHER_CLASS)
            .withMethodName("watch")
            .withParameterTypes(int.class, Object.class));

    public static final BaseReflection<Method> GET_DATA_WATCHER_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENTITY_CLASS)
            .withMethodName("getDataWatcher")
            .withMethodName("ai")
            .withMethodName("al")
            .withMethodName("aj")
            .withExpectResult(DATA_WATCHER_CLASS));

    public static final BaseReflection<Method> GET_BUKKIT_ENTITY_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENTITY_CLASS)
            .withMethodName("getBukkitEntity"));

    public static final BaseReflection<Method> GET_ENUM_CHAT_ID_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENUM_CHAT_CLASS)
            .withMethodName("b"));

    public static final BaseReflection<Method> ENUM_CHAT_TO_STRING_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENUM_CHAT_CLASS)
            .withExpectResult(String.class)
            .withMethodName("toString"));

    public static final BaseReflection<Method> ENTITY_TYPES_A_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.ENTITY)
            .withClassName(ENTITY_TYPES_CLASS)
            .withMethodName("a")
            .withParameterTypes(String.class));

    public static final BaseReflection<Method> PACKET_PLAY_OUT_SCOREBOARD_TEAM_CREATE_V1 = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(PACKET_PLAY_OUT_SCOREBOARD_TEAM_CLASS)
            .withMethodName("a")
            .withParameterTypes(SCOREBOARD_TEAM_CLASS));

    public static final BaseReflection<Method> PACKET_PLAY_OUT_SCOREBOARD_TEAM_CREATE = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(PACKET_PLAY_OUT_SCOREBOARD_TEAM_CLASS)
            .withMethodName("a")
            .withParameterTypes(SCOREBOARD_TEAM_CLASS, boolean.class));

    public static final BaseReflection<Method> SCOREBOARD_PLAYER_LIST = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(SCOREBOARD_TEAM_CLASS)
            .withMethodName("getPlayerNameSet").withMethodName("g"));

    public static final BaseReflection<Method> ENUM_CHAT_FORMAT_FIND = new MethodReflection(new ReflectionBuilder(ReflectionPackage.MINECRAFT)
            .withClassName(ENUM_CHAT_CLASS)
            .withParameterTypes(String.class).withExpectResult(ENUM_CHAT_CLASS));

    public static final BaseReflection<Method> CRAFT_CHAT_MESSAGE_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.BUKKIT)
            .withClassName(CRAFT_CHAT_MESSAGE_CLASS)
            .withMethodName("fromStringOrNull")
            .withParameterTypes(String.class));

    public static final BaseReflection<Method> GET_UNIQUE_ID_METHOD = new MethodReflection(new ReflectionBuilder(ReflectionPackage.MINECRAFT)
            .withClassName(ENTITY_CLASS)
            .withExpectResult(UUID.class));

    public static final BaseReflection<Method> GET_DATAWATCHER_B_LIST = new MethodReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withMethodName("c")
            .withClassName(DATA_WATCHER_CLASS));

    public static final BaseReflection<Field> PLAYER_CONNECTION_FIELD = new FieldReflection(new ReflectionBuilder(ReflectionPackage.SERVER_LEVEL)
            .withClassName(ENTITY_PLAYER_CLASS)
            .withFieldName((Utils.BUKKIT_VERSION > 16) ? "b" : "playerConnection"));

    public static final BaseReflection<Field> NETWORK_MANAGER_FIELD = new FieldReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(PLAYER_CONNECTION_CLASS)
            .withFieldName((Utils.BUKKIT_VERSION > 16) ? "a" : "networkManager")
            .withExpectResult(NETWORK_MANAGER_CLASS));

    public static final BaseReflection<Field> CHANNEL_FIELD = new FieldReflection(new ReflectionBuilder(ReflectionPackage.SERVER_NETWORK)
            .withClassName(NETWORK_MANAGER_CLASS)
            .withExpectResult(Channel.class));

    public static final BaseReflection<Field> PACKET_IN_USE_ENTITY_ID_FIELD = new FieldReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayInUseEntity")
            .withFieldName("a"));

    public static final BaseReflection<Object> ADD_PLAYER_FIELD = new FieldReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutPlayerInfo$EnumPlayerInfoAction")
            .withClassName("ClientboundPlayerInfoUpdatePacket$a")
            .withFieldName((Utils.BUKKIT_VERSION > 16) ? "a" : "ADD_PLAYER")).asValueField();

    public static final BaseReflection<Object> UPDATE_LISTED_FIELD = new FieldReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("ClientboundPlayerInfoUpdatePacket$a")
            .withFieldName("d")).asValueField();

    public static final BaseReflection<Object> REMOVE_PLAYER_FIELD = new FieldReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName("PacketPlayOutPlayerInfo$EnumPlayerInfoAction")
            .withClassName("ClientboundPlayerInfoUpdatePacket$a")
            .withFieldName((Utils.BUKKIT_VERSION > 16) ? "e" : "REMOVE_PLAYER")).asValueField();

    public static final BaseReflection<Object> DATA_WATCHER_REGISTER_FIELD = new FieldReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(DATA_WATCHER_REGISTRY)
            .withFieldName("a")).asValueField();

    public static final BaseReflection<Object> ENUM_TAG_VISIBILITY_NEVER_FIELD = new FieldReflection(new ReflectionBuilder(ReflectionPackage.PACKET)
            .withClassName(ENUM_TAG_VISIBILITY)
            .withFieldName("b")).asValueField();
}