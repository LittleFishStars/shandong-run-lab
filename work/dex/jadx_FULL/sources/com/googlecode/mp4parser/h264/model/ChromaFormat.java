package com.googlecode.mp4parser.h264.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ChromaFormat {
    public static ChromaFormat MONOCHROME = new ChromaFormat(0, 0, 0);
    public static ChromaFormat YUV_420 = new ChromaFormat(1, 2, 2);
    public static ChromaFormat YUV_422 = new ChromaFormat(2, 2, 1);
    public static ChromaFormat YUV_444 = new ChromaFormat(3, 1, 1);
    private int id;
    private int subHeight;
    private int subWidth;

    public ChromaFormat(int i, int i2, int i3) {
        this.id = i;
        this.subWidth = i2;
        this.subHeight = i3;
    }

    public static ChromaFormat fromId(int i) {
        ChromaFormat chromaFormat = MONOCHROME;
        if (i == chromaFormat.id) {
            return chromaFormat;
        }
        ChromaFormat chromaFormat2 = YUV_420;
        if (i == chromaFormat2.id) {
            return chromaFormat2;
        }
        ChromaFormat chromaFormat3 = YUV_422;
        if (i == chromaFormat3.id) {
            return chromaFormat3;
        }
        ChromaFormat chromaFormat4 = YUV_444;
        if (i == chromaFormat4.id) {
            return chromaFormat4;
        }
        return null;
    }

    public int getId() {
        return this.id;
    }

    public int getSubHeight() {
        return this.subHeight;
    }

    public int getSubWidth() {
        return this.subWidth;
    }

    public String toString() {
        return "ChromaFormat{\nid=" + this.id + ",\n subWidth=" + this.subWidth + ",\n subHeight=" + this.subHeight + '}';
    }
}
