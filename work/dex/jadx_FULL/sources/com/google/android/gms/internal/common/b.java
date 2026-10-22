package com.google.android.gms.internal.common;

import com.aliyun.vod.common.utils.IOUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends zzk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f31329a;

    public b(char c) {
        this.f31329a = c;
    }

    @Override // com.google.android.gms.internal.common.zzo
    public final boolean a(char c) {
        return c == this.f31329a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CharMatcher.is('");
        int i = this.f31329a;
        char[] cArr = {IOUtils.DIR_SEPARATOR_WINDOWS, 'u', 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(i & 15);
            i >>= 4;
        }
        sb.append(String.copyValueOf(cArr));
        sb.append("')");
        return sb.toString();
    }
}
