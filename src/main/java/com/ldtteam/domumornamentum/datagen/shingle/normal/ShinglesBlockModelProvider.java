package com.ldtteam.domumornamentum.datagen.shingle.normal;

import com.ldtteam.datagenerators.models.block.BlockModelJson;
import com.ldtteam.domumornamentum.block.decorative.ShingleBlock;
import com.ldtteam.domumornamentum.block.types.ShingleShapeType;
import com.ldtteam.domumornamentum.shingles.ShingleHeightType;
import com.ldtteam.domumornamentum.util.Constants;
import com.ldtteam.domumornamentum.util.DataGeneratorConstants;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.CachedOutput;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Locale;

public class ShinglesBlockModelProvider implements DataProvider
{
    private final DataGenerator generator;

    public ShinglesBlockModelProvider(final DataGenerator generator)
    {
        this.generator = generator;
    }

    @Override
    public void run(@NotNull CachedOutput cache) throws IOException
    {
        for (final ShingleHeightType heightType : ShingleHeightType.values())
        {
            for (final ShingleShapeType shapeType : ShingleShapeType.values())
            {
                final BlockModelJson modelJson = new BlockModelJson();

                modelJson.setLoader(Constants.MOD_ID + ":" + Constants.MATERIALLY_TEXTURED_MODEL_LOADER.toString());
                modelJson.setParent(new ResourceLocation(Constants.MOD_ID, "block/shingles/" + heightType.getId() + shapeType.name().toLowerCase(Locale.ROOT) + "_spec").toString());

                final String name = heightType.getId() + shapeType.name().toLowerCase(Locale.ROOT) + ".json";
                final Path saveFile = this.generator.getOutputFolder().resolve(DataGeneratorConstants.SHINGLES_BLOCK_MODELS_DIR).resolve(name);

                DataProvider.saveStable(cache, DataGeneratorConstants.serialize(modelJson), saveFile);
            }
        }
    }

    @Override
    @NotNull
    public String getName()
    {
        return "Shingles Block Model Provider";
    }
}
