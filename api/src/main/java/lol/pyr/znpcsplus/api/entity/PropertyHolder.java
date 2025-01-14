package lol.pyr.znpcsplus.api.entity;

import java.util.Set;

/**
 * Represents classes that have property values attatched to them
 */
public interface PropertyHolder {
    /**
     * Method used to get the value of a property from a property holder
     *
     * @param key Unique key representing a property
     * @return The value associated with the provided property key and this holder
     * @param <T> The type of the property value
     */
    <T> T getProperty(EntityProperty<T> key);

    /**
     * Method used to check if a property holder has a value set for a specific property key
     *
     * @param key Unique key representing a property
     * @return Whether this holder has a value set for the provided key
     */
    boolean hasProperty(EntityProperty<?> key);

    /**
     * Method used to set a value for the provided key on this property holder
     *
     * @param key Unique key representing a property
     * @param value The value to assign to the property key on this holder
     * @param <T> The type of the property value
     */
    <T> void setProperty(EntityProperty<T> key, T value);

    /**
     * Method used to get a set of all of the property keys that this holder has a value for
     *
     * @return List of property keys
     */
    Set<EntityProperty<?>> getAppliedProperties();
}
