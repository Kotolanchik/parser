package ru.kolodkin.parser.tools;

public abstract class ParserSettings {
    public static String BASE_URL;
    public static String PREFIX;
    protected int startPoint;
    protected int endPoint;

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }
}
