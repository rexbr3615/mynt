package net.rexbrx.mynt.neoforge;

import net.neoforged.fml.common.Mod;

import net.rexbrx.mynt.Mynt;

@Mod(Mynt.ID)
public final class MyntNeoForge {
    public MyntNeoForge() {
        // Run our common setup.
        Mynt.init();
    }
}
