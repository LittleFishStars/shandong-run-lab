package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f6438a;

    public a(String str, int i) {
        this.f6438a = str;
        this.f32248a = i;
    }

    public static a a(String str) {
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        char cCharAt = str.charAt(0);
        int i = 16;
        if (str.startsWith("0x") || str.startsWith("0X")) {
            str = str.substring(2);
        } else if (cCharAt == '#') {
            str = str.substring(1);
        } else if (cCharAt != '0' || str.length() <= 1) {
            i = 10;
        } else {
            str = str.substring(1);
            i = 8;
        }
        return new a(str, i);
    }
}
