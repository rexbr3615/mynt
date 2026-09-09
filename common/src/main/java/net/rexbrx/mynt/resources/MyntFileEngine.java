package net.rexbrx.mynt.resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import net.rexbrx.mynt.log.MyntLog;

public class MyntFileEngine
{
    public static File create_mynt_text_v1(String name)
    {
        Path internal = Paths.get(name + "." + MyntFileList.myntext);
        try {
            Files.createFile(internal);
        } catch (IOException e) {
            MyntLog.myError("Failed to create: " + e.getMessage());
        }
        return internal.toFile();
    }

    public static File create_mynt_text_v2(String name)
    {
        Path internal = Paths.get(name + "." + MyntFileList.myntdata);
        try {
            Files.createFile(internal);
        } catch (IOException e) {
            MyntLog.myError("Failed to create: " + e.getMessage());
        }
        return internal.toFile();
    }

    public static File create_file(String name, String extension)
    {
        Path internal = Paths.get(name + "." + extension);
        try {
            Files.createFile(internal);
        } catch (IOException e) {
            MyntLog.myError("Failed to create: " + e.getMessage());
        }
        return internal.toFile();
    }

}
