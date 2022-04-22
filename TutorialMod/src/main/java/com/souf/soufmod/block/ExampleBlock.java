package com.souf.soufmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ExampleBlock extends Block {

	public ExampleBlock(Properties properties) {
		super(properties);

	}

	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult result) {

		if (!world.isClientSide()) {

		}

		return super.use(state, world, pos, player, hand, result);
	}

}
