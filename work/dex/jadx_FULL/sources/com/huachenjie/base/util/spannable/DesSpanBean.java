package com.huachenjie.base.util.spannable;

import android.text.style.CharacterStyle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DesSpanBean {
    private final int end;
    private final int flags;
    private final CharacterStyle span;
    private final int start;

    public DesSpanBean(CharacterStyle span, int start, int end, int flags) {
        this.span = span;
        this.start = start;
        this.end = end;
        this.flags = flags;
    }

    public int getEnd() {
        return this.end;
    }

    public int getFlags() {
        return this.flags;
    }

    public Object getSpan() {
        return this.span;
    }

    public int getStart() {
        return this.start;
    }
}
