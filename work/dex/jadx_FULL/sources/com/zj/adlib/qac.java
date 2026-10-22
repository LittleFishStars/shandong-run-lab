package com.zj.adlib;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nac f44165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f19042a;
    public nac b;

    public /* synthetic */ qac(String str, pac pacVar) {
        nac nacVar = new nac(null);
        this.f44165a = nacVar;
        this.b = nacVar;
        str.getClass();
        this.f19042a = str;
    }

    public final qac a(@CheckForNull Object obj) {
        nac nacVar = new nac(null);
        this.b.f43486a = nacVar;
        this.b = nacVar;
        nacVar.f18383a = obj;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f19042a);
        sb.append('{');
        nac nacVar = this.f44165a.f43486a;
        String str = "";
        while (nacVar != null) {
            Object obj = nacVar.f18383a;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            nacVar = nacVar.f43486a;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
