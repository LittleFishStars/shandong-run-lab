package com.zj.adlib;

import android.text.TextPaint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ql6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TextPaint f44240a;

    public static TextPaint a() {
        if (f44240a == null) {
            TextPaint textPaint = new TextPaint();
            f44240a = textPaint;
            textPaint.setFlags(3);
            f44240a.setStrokeWidth(3.5f);
        }
        return f44240a;
    }
}
