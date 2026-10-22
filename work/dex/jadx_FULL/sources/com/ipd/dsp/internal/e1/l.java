package com.ipd.dsp.internal.e1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.ad.DspNativeAd;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class l implements DspNativeAd.AppMiitInfo, Serializable {
    public final String f;
    public final String g;
    public final String h;
    public final long i;
    public final String j;
    public final List<String> k = new ArrayList();
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;

    public l(b bVar) {
        long j;
        this.f = bVar.q;
        this.g = bVar.s;
        this.h = bVar.m;
        try {
            j = Long.parseLong(bVar.z);
        } catch (Throwable unused) {
            j = 0;
        }
        this.i = j;
        this.j = bVar.y;
        ArrayList<String> arrayList = bVar.u;
        if (arrayList != null) {
            try {
                this.k.addAll(arrayList);
            } catch (Throwable unused2) {
            }
        }
        this.l = bVar.v;
        this.m = bVar.r;
        this.n = bVar.x;
        this.o = bVar.B;
        this.p = bVar.A;
        this.q = bVar.C;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd.AppMiitInfo
    @Nullable
    public String getAppName() {
        return this.f;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd.AppMiitInfo
    @Nullable
    public String getAuthorName() {
        return this.g;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd.AppMiitInfo
    @Nullable
    public String getDescriptionUrl() {
        return this.n;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd.AppMiitInfo
    @Nullable
    public String getIcpInfoUrl() {
        return this.q;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd.AppMiitInfo
    @Nullable
    public String getIcpNumber() {
        return this.o;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd.AppMiitInfo
    @Nullable
    public String getPackageName() {
        return this.h;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd.AppMiitInfo
    public long getPackageSizeBytes() {
        return this.i;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd.AppMiitInfo
    @NonNull
    public List<String> getPermissions() {
        return this.k;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd.AppMiitInfo
    @Nullable
    public String getPermissionsUrl() {
        return this.j;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd.AppMiitInfo
    @Nullable
    public String getPrivacyAgreement() {
        return this.l;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd.AppMiitInfo
    @Nullable
    public String getSuitableAge() {
        return this.p;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd.AppMiitInfo
    @Nullable
    public String getVersionName() {
        return this.m;
    }
}
