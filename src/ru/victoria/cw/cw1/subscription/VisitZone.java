package ru.victoria.cw.cw1.subscription;

public class VisitZone {
    private boolean isGym;
    private boolean isPool;
    private boolean isGroupLessons;
    public VisitZone(boolean  isGym, boolean isPool, boolean isGroupLessons) {
        this.setGym(isGym);
        this.setPool(isPool);
        this.setGroupLessons(isGroupLessons);
    }

    public boolean getIsGym() {
        return isGym;
    }

    public void setGym(boolean isGym) {
        this.isGym = isGym;
    }

    public boolean getIsPool() {
        return isPool;
    }

    public void setPool(boolean isPool) {
        this.isPool = isPool;
    }

    public boolean getIsGroupLessons() {
        return isGroupLessons;
    }

    public void setGroupLessons(boolean isGroupLessons) {
        this.isGroupLessons = isGroupLessons;
    }
    private String getTrueZoneName() {
        if (isGym&&isPool&&isGroupLessons)
            return "тренажeрный зал, бассейн и зал групповых тренировок";
        else if (isGym&&isPool)
            return "тренажерный зал и бассейн";
        else if (isGym&&isGroupLessons)
            return "тренажерный зал и зал групповых тренировок";
        else if (isPool&&isGroupLessons)
            return "бассейн и зал групповых тренировок";
        else if (isGym) {
             return "тренажерный зал";
         }
        else if (isPool) {
             return "бассейн";
         }
        else if (isGroupLessons) {
             return "зал групповых тренировок";
         }
         return "зона отсутствует";
    }


    @Override
    public String toString() {
        return getTrueZoneName();
    }
}
