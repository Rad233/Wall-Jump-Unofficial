package genandnic.walljump.registry;

import genandnic.walljump.WallJumpConfig;
import genandnic.walljump.enchantment.DoubleJumpEnchantment;
import genandnic.walljump.enchantment.SpeedBoostEnchantment;
import genandnic.walljump.enchantment.WallJumpEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WallJumpEnchantmentRegistry {
    public static Enchantment WALLJUMP_ENCHANTMENT;
    public static Enchantment DOUBLEJUMP_ENCHANTMENT;
    public static Enchantment SPEEDBOOST_ENCHANTMENT;

    public static void registerWallJumpEnchantment() {
        if (!WallJumpConfig.getConfig().useWallJump && WallJumpConfig.getConfig().enableWallJumpEnchantment) {
            WALLJUMP_ENCHANTMENT = Registry.register(
                    Registry.ENCHANTMENT,
                    new Identifier("walljump", "walljump"),
                    new WallJumpEnchantment(
                            Enchantment.Rarity.UNCOMMON,
                            EnchantmentTarget.ARMOR_FEET,
                            new EquipmentSlot[] {
                                    EquipmentSlot.FEET
                            }
                    )
            );
        }
    }

    public static void registerDoubleJumpEnchantment() {
        if (!WallJumpConfig.getConfig().useDoubleJump && WallJumpConfig.getConfig().enableDoubleJumpEnchantment) {
            DOUBLEJUMP_ENCHANTMENT = Registry.register(
                    Registry.ENCHANTMENT,
                    new Identifier("walljump", "doublejump"),
                    new DoubleJumpEnchantment(
                            Enchantment.Rarity.RARE,
                            EnchantmentTarget.ARMOR_FEET,
                            new EquipmentSlot[] {
                                    EquipmentSlot.FEET
                            }
                    )
            );
        }
    }

    public static void registerSpeedBoostEnchantment() {
        if (WallJumpConfig.getConfig().sprintSpeedBoost == 0.0 && WallJumpConfig.getConfig().enableSpeedBoostEnchantment) {
            SPEEDBOOST_ENCHANTMENT = Registry.register(
                    Registry.ENCHANTMENT,
                    new Identifier("walljump", "speedboost"),
                    new SpeedBoostEnchantment(
                            Enchantment.Rarity.RARE,
                            EnchantmentTarget.ARMOR_FEET,
                            new EquipmentSlot[] {
                                    EquipmentSlot.FEET
                            }
                    )
            );
        }
    }
}
