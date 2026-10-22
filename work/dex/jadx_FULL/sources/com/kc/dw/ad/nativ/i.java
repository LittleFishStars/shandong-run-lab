package com.kc.dw.ad.nativ;

import com.kc.dw.core.ad.BaseAdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class i extends BaseAdSlot {
    public long C;
    public long D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f39132a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public long i;
    public String[] j;
    public String[] k;
    public String[] l;
    public String[] m;
    public String[] n;
    public String[] o;
    public String[] p;
    public String[] q;
    public String[] r;
    public String[] s;
    public String[] t;
    public String[] u;
    public int v;
    public int x;
    public long y;
    public int w = 1;
    public boolean z = true;
    public boolean A = true;
    public boolean B = false;

    @Keep
    public class a extends BaseAdSlot.Builder<a, i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f39133a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar) {
            super(iVar);
            this.f39133a = iVar;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot build() {
            return this.f39133a;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder returnThis() {
            return this;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder setAppName(String str) {
            this.f39133a.appName = str;
            return this;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder setDesc(String str) {
            this.f39133a.desc = str;
            return this;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder setIconUrl(String str) {
            this.f39133a.iconUrl = str;
            return this;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder setTitle(String str) {
            this.f39133a.title = str;
            return this;
        }
    }

    @Override // com.kc.dw.core.ad.BaseAdSlot
    public String getDesc() {
        return this.desc;
    }

    @Override // com.kc.dw.core.ad.BaseAdSlot
    public String getIconUrl() {
        return this.iconUrl;
    }

    @Override // com.kc.dw.core.ad.BaseAdSlot
    public String getTitle() {
        return this.title;
    }

    @Override // com.kc.dw.core.ad.BaseAdSlot
    public void setAdPatternType(int i) {
        this.adPatternType = i;
    }
}
