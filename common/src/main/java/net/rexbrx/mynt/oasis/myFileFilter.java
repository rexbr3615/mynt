package net.rexbrx.mynt.oasis;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FilenameFilter;

public enum myFileFilter implements FilenameFilter
{
    xml("xml"),
    html("html"),
    css("css"),
    js("js"),

    json("json"),
    cfg("cfg"),

    zip("zip"),
    rar("rar"),

    txt("txt"),
    myntext("myntext"),
    myntdata("myntdata"),

    png("png"),
    jpg("jpg"),
    jpeg("jpeg"),
    jfif("jfif"),
    tga("tga"),

    jar("jar"),
    exe("exe"),
    msi("msi"),

    log("log"),
    dat("dat"),
    obj("obj")
    ;

    private final String[] extensions;
    myFileFilter(String... suffix) {
        this.extensions = suffix;
    }

    public static boolean isKnown(File dir, String name) {
        for (FilenameFilter filter : values())
            if (filter.accept(dir, name))
                return true;
        return false;
    }

    public String[] getExtensions() {
        return this.extensions;
    }

    @Override
    public boolean accept(File dir, String name) {
        return FilenameUtils.isExtension(name, extensions);
    }
}
