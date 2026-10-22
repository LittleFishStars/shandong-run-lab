package com.kwad.sdk.utils;

import com.zj.adlib.c25;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class ax {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static int a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i) {
        int i2;
        ?? r0 = z;
        if (z2) {
            i2 = (z ? 1 : 0) | 2;
        }
        if (z3) {
            r0 = i2;
            r0 = (r0 == true ? 1 : 0) | 4;
        }
        if (z4) {
            r0 = (r0 == true ? 1 : 0) | '\b';
        }
        if (z5) {
            r0 = (r0 == true ? 1 : 0) | c25.e;
        }
        if (z6) {
            r0 = (r0 == true ? 1 : 0) | ' ';
        }
        return i == 2 ? r0 | 64 : r0;
    }
}
