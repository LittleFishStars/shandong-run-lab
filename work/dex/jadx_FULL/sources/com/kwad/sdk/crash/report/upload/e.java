package com.kwad.sdk.crash.report.upload;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e {
    public static e bfU = new e(-11, "Please init.");
    public static e bfV = new e(-12, "error when zip_file");
    public static e bfW = new e(-13, "There is no valid network.");
    public static e bfX = new e(-14, "Token is invalid.");
    public static e bfY = new e(-15, "upload task execute frequence exceed.");
    public static e bfZ = new e(-16, "process request fail.");
    public static e bga = new e(-17, "sever response error http code");
    public static e bgb = new e(-18, "sever response error result code");
    public static e bgc = new e(-19, "server bad response.");
    private final int bgd;
    private final String bge;

    private e(int i, String str) {
        this.bgd = i;
        this.bge = str;
    }

    public final String CZ() {
        return this.bge;
    }
}
