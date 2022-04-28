package com.souf.soufmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SoufBlock extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	
	private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 11, 16);

	public SoufBlock(Properties properties) {
		super(properties);
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
//		VoxelShape shape = new VoxelShape();
//		shape = VoxelShape.join(shape, VoxelShape.box(0, 0.25, 0, 1, 0.3125, 1), IBooleanFunction.OR);
//		shape = VoxelShape.join(shape, VoxelShape.box(0, 0.625, 0, 1, 0.6875, 1), IBooleanFunction.OR);
//		shape = VoxelShape.join(shape, VoxelShape.box(0, 0, 0, 0.0625, 0.25, 1), IBooleanFunction.OR);
//		shape = VoxelShape.join(shape, VoxelShape.box(0.9375, 0.3125, 0, 1, 0.625, 1), IBooleanFunction.OR);
//		return shape;
		return SHAPE;
	}

	/* FACING */

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING);
	}

}
