package com.google.android.inner_exoplayer2.text.span;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class TextAnnotation {
    public static final int POSITION_AFTER = 2;
    public static final int POSITION_BEFORE = 1;
    public static final int POSITION_UNKNOWN = -1;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    private TextAnnotation() {
    }
}
