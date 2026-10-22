package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.i;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class a {
    public static final char[][] b = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[][] f32018a;

    public a(char[][] cArr) {
        this.f32018a = cArr;
    }

    public static a a(Map<Character, String> map) {
        return new a(b(map));
    }

    @VisibleForTesting
    public static char[][] b(Map<Character, String> map) {
        i.E(map);
        if (map.isEmpty()) {
            return b;
        }
        char[][] cArr = new char[((Character) Collections.max(map.keySet())).charValue() + 1][];
        for (Character ch : map.keySet()) {
            cArr[ch.charValue()] = map.get(ch).toCharArray();
        }
        return cArr;
    }

    public char[][] c() {
        return this.f32018a;
    }
}
