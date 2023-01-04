package com.ldtteam.domumornamentum.datagen.floatingcarpet;

import com.ldtteam.domumornamentum.block.ModBlocks;
import com.ldtteam.domumornamentum.block.decorative.FloatingCarpetBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WoolCarpetBlock;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class FloatingCarpetRecipeProvider extends RecipeProvider
{
    public FloatingCarpetRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> builder) {
        final Map<DyeColor, WoolCarpetBlock> carpets = new HashMap<>();
        carpets.put(((WoolCarpetBlock) Blocks.WHITE_CARPET).getColor(), (WoolCarpetBlock) Blocks.WHITE_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.LIGHT_GRAY_CARPET).getColor(), (WoolCarpetBlock) Blocks.LIGHT_GRAY_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.GRAY_CARPET).getColor(), (WoolCarpetBlock) Blocks.GRAY_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.BLACK_CARPET).getColor(), (WoolCarpetBlock) Blocks.BLACK_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.BROWN_CARPET).getColor(), (WoolCarpetBlock) Blocks.BROWN_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.RED_CARPET).getColor(), (WoolCarpetBlock) Blocks.RED_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.ORANGE_CARPET).getColor(), (WoolCarpetBlock) Blocks.ORANGE_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.YELLOW_CARPET).getColor(), (WoolCarpetBlock) Blocks.YELLOW_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.LIME_CARPET).getColor(), (WoolCarpetBlock) Blocks.LIME_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.GREEN_CARPET).getColor(), (WoolCarpetBlock) Blocks.GREEN_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.CYAN_CARPET).getColor(), (WoolCarpetBlock) Blocks.CYAN_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.LIGHT_BLUE_CARPET).getColor(), (WoolCarpetBlock) Blocks.LIGHT_BLUE_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.BLUE_CARPET).getColor(), (WoolCarpetBlock) Blocks.BLUE_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.PURPLE_CARPET).getColor(), (WoolCarpetBlock) Blocks.PURPLE_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.MAGENTA_CARPET).getColor(), (WoolCarpetBlock) Blocks.MAGENTA_CARPET);
        carpets.put(((WoolCarpetBlock) Blocks.PINK_CARPET).getColor(), (WoolCarpetBlock) Blocks.PINK_CARPET);

        for (final FloatingCarpetBlock block : ModBlocks.getInstance().getFloatingCarpets())
        {
            final DyeColor color = block.getColor();
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, block, 4)
                    .pattern("C  ")
                    .pattern("S  ")
                    .pattern("   ")
                    .define('C', carpets.get(color))
                    .define('S', Tags.Items.STRING)
                    .group("floating_carpets");
        }
    }

    @NotNull
    @Override
    public String getName()
    {
        return "Floating Carpet Recipe Provider";
    }
}
