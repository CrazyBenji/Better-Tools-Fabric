package net.benji.bettertools.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ScytheItem extends HoeItem {

    public ScytheItem(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (!world.isClientSide && world instanceof ServerLevel) {
            // Get all positions in 3x3 area around the clicked position
            List<BlockPos> positionsToHoe = get3x3Positions(pos);

            boolean anyBlockHoed = false;

            // Attempt to till each block in the area
            for (BlockPos targetPos : positionsToHoe) {
                if (canHoeBlock(world, targetPos)) {
                    if (world.getBlockState(targetPos.above()).isAir()) {
                        // Set the tilled block state
                        world.setBlock(targetPos, Blocks.FARMLAND.defaultBlockState(), 11);

                        // Play tilling sound
                        world.playSound(null, targetPos, SoundEvents.HOE_TILL,
                                SoundSource.BLOCKS, 1.0F, 1.0F);

                        anyBlockHoed = true;
                    }
                }
            }

            if (anyBlockHoed) {
                // Damage the tool once for the original block
                assert player != null;
                EquipmentSlot equipmentSlot = stack.equals(player.getItemBySlot(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
                stack.hurtAndBreak(1, player, equipmentSlot);
                return InteractionResult.SUCCESS;
            }
        }

        // Fall back to default hoe behavior if no tilling happened
        return super.useOn(context);
    }

    private List<BlockPos> get3x3Positions(BlockPos center) {
        List<BlockPos> positions = new ArrayList<>();

        // Create 3x3 area on the same Y level (horizontal plane)
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                positions.add(center.offset(x, 0, z));
            }
        }

        return positions;
    }

    private boolean canHoeBlock(Level world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        return block == Blocks.GRASS_BLOCK ||
                block == Blocks.DIRT_PATH ||
                block == Blocks.DIRT ||
                block == Blocks.COARSE_DIRT ||
                block == Blocks.ROOTED_DIRT;
    }
}
