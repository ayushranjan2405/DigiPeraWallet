package com.digipera.dto;

public class Notification {

    private final String line1Left;
    private final String line1Right;
    private final String line2Left;
    private final String line2Right;

    public Notification(String line1Left, String line1Right, String line2Left, String line2Right) {
        this.line1Left = line1Left;
        this.line1Right = line1Right;
        this.line2Left = line2Left;
        this.line2Right = line2Right;
    }

    public String getLine1Left() {
        return line1Left;
    }

    public String getLine1Right() {
        return line1Right;
    }

    public String getLine2Left() {
        return line2Left;
    }

    public String getLine2Right() {
        return line2Right;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "line1Left='" + line1Left + '\'' +
                ", line1Right='" + line1Right + '\'' +
                ", line2Left='" + line2Left + '\'' +
                ", line2Right='" + line2Right + '\'' +
                '}';
    }
}
