package io.github.witherdoggie.forgottenforest.world.generator;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.registry.StructureRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;

import java.util.Random;

public class CryptGenerator {

    private static final Identifier CRYPT = new Identifier(ForgottenForest.MODID, "crypt");

    public static void addPieces(StructureManager manager,StructurePiecesHolder structurePiecesHolder, Random random, BlockPos pos) {
        BlockRotation blockRotation = BlockRotation.random(random);
        structurePiecesHolder.addPiece(new CryptGenerator.Piece(manager, CRYPT, pos, blockRotation));
    }

    public static class Piece extends SimpleStructurePiece {

        public Piece(StructureManager manager, Identifier template, BlockPos pos, BlockRotation rotation) {
            super(StructureRegistry.CRYPT_PIECE, 0, manager, template, template.toString(), createPlacementData(rotation), pos);
        }

        public Piece(ServerWorld world, NbtCompound nbt) {
            super(StructureRegistry.CRYPT_PIECE, nbt, world, (identifier1 -> createPlacementData(BlockRotation.valueOf(nbt.getString("Rot")))));
        }

        private static StructurePlacementData createPlacementData(BlockRotation rotation) {
            return (new StructurePlacementData()).setRotation(rotation).setMirror(BlockMirror.NONE).addProcessor(BlockIgnoreStructureProcessor.IGNORE_AIR_AND_STRUCTURE_BLOCKS);
        }

        protected void writeNbt(ServerWorld world, NbtCompound nbt) {
            super.writeNbt(world, nbt);
            nbt.putString("Rot", this.placementData.getRotation().name());
        }

        protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess serverWorldAccess, Random random, BlockBox boundingBox) {

        }
    }
}

