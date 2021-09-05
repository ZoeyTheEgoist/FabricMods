package com.astrazoey.lenientstacksize;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class MaxItemCountSetter {
    private static final String ITEM_INTERMEDIARY = "net.minecraft.class_1792";
    private static final String MAX_COUNT_INTERMEDIARY = "field_8013";

    private final Field field;

    private MaxItemCountSetter(Field field) {
        this.field = field;
    }

    public static MaxItemCountSetter create() throws ReflectiveOperationException {
        var mappings = FabricLoader.getInstance().getMappingResolver();
        var maxCountName = mappings.mapFieldName("intermediary", ITEM_INTERMEDIARY, MAX_COUNT_INTERMEDIARY, "I");

        var field = Item.class.getDeclaredField(maxCountName);
        field.setAccessible(true);

        var modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        return new MaxItemCountSetter(field);
    }

    public void set(Item item, int maxCount) throws IllegalAccessException {
        this.field.set(item, maxCount);
    }
}