package net.rexbrx.mynt.oasis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import net.rexbrx.mynt.utils.myLogger;

public class myFileEngine
{
    public static File create_mynt_text_v1(String name)
    {
        Path internal = Paths.get(name + "." + myFileFilter.myntext);
        try {
            Files.createFile(internal);
        } catch (IOException e) {
            myLogger.myError("Failed to create: " + e.getMessage());
        }
        return internal.toFile();
    }

    public static File create_mynt_text_v2(String name)
    {
        Path internal = Paths.get(name + "." + myFileFilter.myntdata);
        try {
            Files.createFile(internal);
        } catch (IOException e) {
            myLogger.myError("Failed to create: " + e.getMessage());
        }
        return internal.toFile();
    }

    public static File create_file(String name, String extension)
    {
        Path internal = Paths.get(name + "." + extension);
        try {
            Files.createFile(internal);
        } catch (IOException e) {
            myLogger.myError("Failed to create: " + e.getMessage());
        }
        return internal.toFile();
    }

}
