package carpet.bastion.utils;

public enum MCTime {
    SECONDS(20),
    MINUTES(20 * 60),
    HOURS(20 * 60 * 60),
    DAYS(20 * 60 * 60 * 24);

    private final int time;

    MCTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
