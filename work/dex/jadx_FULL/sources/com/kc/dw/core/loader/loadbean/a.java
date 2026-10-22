package com.kc.dw.core.loader.loadbean;

import com.kc.dw.core.domain.SdkAdInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SdkAdInfo f39268a;
    public Object b;
    public int e;
    public boolean g;
    public int c = 1;
    public int d = 0;
    public int f = -1;

    public int a() {
        if (!this.g) {
            if ("bidding".equals(this.f39268a.getOtype())) {
                return this.f;
            }
            if ("order".equals(this.f39268a.getOtype())) {
                return (this.e + 100000) - this.f39268a.getScore();
            }
            if ("price".equals(this.f39268a.getOtype())) {
                return this.f39268a.getCodPrice() + this.e;
            }
        }
        return this.f;
    }

    public String toString() {
        StringBuilder sbA = com.kc.dw.activity.a.a("SmallGroupBean{platform =");
        sbA.append(this.g ? "MS" : this.f39268a.getSdk());
        sbA.append(", state=");
        sbA.append(this.c);
        sbA.append(", timeoutState=");
        sbA.append(this.d);
        sbA.append(", firstScore=");
        sbA.append(this.e);
        sbA.append(", secondScore=");
        sbA.append(a());
        sbA.append(", isMs=");
        sbA.append(this.g);
        sbA.append(", isCache=");
        sbA.append(false);
        sbA.append(", hashCode=");
        sbA.append(hashCode());
        sbA.append('}');
        return sbA.toString();
    }
}
