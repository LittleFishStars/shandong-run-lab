package com.aliyun.svideosdk.common.struct.project;

import android.text.Layout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Text {
    public static final int TEXT_ALIGN_CENTER = 1;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_RIGHT = 2;
    public long fontId = -1;
    public boolean hasTextLabel;
    public float maxTextSize;
    public String text;
    public int textAlignment;
    public int textColor;
    public int textHeight;
    public int textLabelColor;
    public int textStrokeColor;
    public int textWidth;

    public Layout.Alignment getTextAlignment() {
        int i = this.textAlignment;
        if (i != 0) {
            return i != 2 ? Layout.Alignment.ALIGN_CENTER : Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_NORMAL;
    }
}
