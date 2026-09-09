package net.rexbrx.mynt.server.entity;

import java.util.concurrent.ThreadLocalRandom;

public enum MyntEntityCommonVariation {

    NORMAL(0, 70),
    MELANISTIC(1, 15),
    ALBINO(2, 5),
    LEUCISTIC(3, 9);

    private final int id;
    private final int chance;

    private boolean enabled = true;

    MyntEntityCommonVariation(int id, int chance) {
        this.id = id;
        this.chance = chance;
    }

    public int getId() {
        return id;
    }

    public int getChance() {
        return chance;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public static MyntEntityCommonVariation random() {
        int totalChance = 0;

        for (MyntEntityCommonVariation variation : values()) {
            if (variation.enabled) {
                totalChance += variation.chance;
            }
        }

        if (totalChance == 0) {
            throw new IllegalStateException("Nenhuma variação está habilitada.");
        }

        int roll = ThreadLocalRandom.current().nextInt(totalChance);

        int accumulated = 0;

        for (MyntEntityCommonVariation variation : values()) {
            if (!variation.enabled) {
                continue;
            }

            accumulated += variation.chance;

            if (roll < accumulated) {
                return variation;
            }
        }

        throw new IllegalStateException("Erro ao sortear variação.");
    }
}

/*
    MyntEntityVariation variation = MyntEntityVariation.random();

    System.out.println(variation);
    System.out.println(variation.getId());


    MyntEntityVariation.ALBINO.setEnabled(false);
    MyntEntityVariation.LEUCISTIC.setEnabled(false);

    MyntEntityVariation variation = MyntEntityVariation.random();

    MyntEntityVariation.disable(2);
    MyntEntityVariation.enable(2);
    MyntEntityVariation.isEnabled(2);

 */