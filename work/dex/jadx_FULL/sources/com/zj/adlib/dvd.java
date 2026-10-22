package com.zj.adlib;

import com.alipay.sdk.m.p.a;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class dvd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qud f41291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f16150a;
    public qud b;

    public /* synthetic */ dvd(String str, yud yudVar) {
        qud qudVar = new qud(null);
        this.f41291a = qudVar;
        this.b = qudVar;
        str.getClass();
        this.f16150a = str;
    }

    public final dvd a(String str, @CheckForNull Object obj) {
        qud qudVar = new qud(null);
        this.b.f44303a = qudVar;
        this.b = qudVar;
        qudVar.f19172a = obj;
        qudVar.f19173a = str;
        return this;
    }

    public final dvd b(String str, boolean z) {
        String strValueOf = String.valueOf(z);
        ptd ptdVar = new ptd(null);
        this.b.f44303a = ptdVar;
        this.b = ptdVar;
        ((qud) ptdVar).f19172a = strValueOf;
        ((qud) ptdVar).f19173a = "isManifestFile";
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f16150a);
        sb.append('{');
        qud qudVar = this.f41291a.f44303a;
        String str = "";
        while (qudVar != null) {
            Object obj = qudVar.f19172a;
            sb.append(str);
            String str2 = qudVar.f19173a;
            if (str2 != null) {
                sb.append(str2);
                sb.append(a.h);
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            qudVar = qudVar.f44303a;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
