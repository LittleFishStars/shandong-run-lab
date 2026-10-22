package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    private Set<String> beo = new HashSet();
    private Set<String> bep = new HashSet();

    public final synchronized String[] Qf() {
        Set<String> set;
        set = this.bep;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized String[] Qq() {
        Set<String> set;
        set = this.beo;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.beo.add(str);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (strArr2 != null && strArr2.length > 0) {
            for (String str2 : strArr2) {
                if (!TextUtils.isEmpty(str2)) {
                    this.bep.add(str2);
                }
            }
        }
    }
}
