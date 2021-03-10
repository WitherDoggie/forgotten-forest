package io.github.witherdoggie.forgottenforest.generator;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.registry.StructureRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;

import java.util.List;
import java.util.Random;

public class CryptGenerator {

    private static final Identifier CRYPT = new Identifier(ForgottenForest.MODID, "crypt");

    public static void addPiece(StructureManager manager, BlockPos pos, BlockRotation rotation, List<StructurePiece> pieces) {
        pieces.add(new Piece(manager, pos, CRYPT, rotation));
    }

    public static class Piece extends SimpleStructurePiece {
        private final Identifier template;
        private final BlockRotation rotation;

        public Piece(StructureManager manager, BlockPos pos, Identifier template, BlockRotation rotation) {
            super(StructureRegistry.PIECE, 0);
            this.template = template;
            this.pos = pos;
            this.rotation = rotation;
            this.initializeStructureData(manager);
        }

        public Piece(StructureManager manager, CompoundTag tag) {
            super(StructureRegistry.PIECE, tag);
            this.template = new Identifier(tag.getString("Template"));
            this.rotation = BlockRotation.valueOf(tag.getString("Rot"));
            this.initializeStructureData(manager);
        }

        private void initializeStructureData(StructureManager manager) {
            Structure structure = manager.getStructureOrBlank(this.template);
            StructurePlacementData placementData = (new StructurePlacementData()).setRotation(this.rotation).setMirror(BlockMirror.NONE).addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
            this.setStructureData(structure, this.pos, placementData);
        }

        protected void toNbt(CompoundTag tag) {
            super.toNbt(tag);
            tag.putString("Template", this.template.toString());
            tag.putString("Rot", this.rotation.name());
        }

        protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess serverWorldAccess, Random random, BlockBox boundingBox) {


        }
    }
}
