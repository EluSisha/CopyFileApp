package ru.learnup.halflife;

import java.io.*;

import static ru.learnup.halflife.Main.PROGRESS_CONTENT_FILENAME;

public class Progress implements Serializable {

    private static final long serialVersionUID = 1231245L;

    private String nameOfHero;
    private int lvlOfHero;

    private double damage;
    private double intelligence;
    private double agility;
    private double hitPoints;

    public Progress(String nameOfHero, int lvlOfHero, double damage, double intelligence, double agility, double hitPoints) {
        this.nameOfHero = nameOfHero;
        this.lvlOfHero = lvlOfHero;
        this.damage = damage;
        this.intelligence = intelligence;
        this.agility = agility;
        this.hitPoints = hitPoints;
    }

    protected boolean saveProgressOfHero(Progress progress) {
        try (FileOutputStream fos = new FileOutputStream(PROGRESS_CONTENT_FILENAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(progress);

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    protected Progress loadProgress() {
        try (FileInputStream fis = new FileInputStream(PROGRESS_CONTENT_FILENAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            final Object obj = ois.readObject();
            Progress result = (Progress) obj;

            return result;
        } catch (IOException | ClassNotFoundException e1) {
            return null;
        }
    }

    public String getNameOfHero() {
        return nameOfHero;
    }

    public void setNameOfHero(String nameOfHero) {
        this.nameOfHero = nameOfHero;
    }

    public int getLvlOfHero() {
        return lvlOfHero;
    }

    public void setLvlOfHero(int lvlOfHero) {
        this.lvlOfHero = lvlOfHero;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(double hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public String toString() {
        return "halflife.Progress{" +
                "nameOfHero='" + nameOfHero + '\'' +
                ", lvlOfHero=" + lvlOfHero +
                ", damage=" + damage +
                ", intelligence=" + intelligence +
                ", agility=" + agility +
                ", HitPoints=" + hitPoints +
                '}';
    }
}
