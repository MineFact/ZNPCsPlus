package lol.pyr.znpcsplus.metadata;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;

public class V1_8Factory implements MetadataFactory {
    @Override
    public EntityData skinLayers() {
        return createSkinLayers(12);
    }

    @Override
    public EntityData effects(boolean onFire, boolean glowing, boolean invisible) {
        return new EntityData(0, EntityDataTypes.BYTE, (onFire ? 0x01 : 0) | (invisible ? 0x20 : 0));
    }

    protected EntityData createSkinLayers(int index) {
        return new EntityData(index, EntityDataTypes.BYTE, Byte.MAX_VALUE);
    }
}