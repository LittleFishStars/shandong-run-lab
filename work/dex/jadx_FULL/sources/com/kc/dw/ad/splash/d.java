package com.kc.dw.ad.splash;

import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.BaseAdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d extends i {
    public int E = 3;
    public String F;
    public int G;
    public int H;
    public int I;

    @Keep
    public class a extends BaseAdSlot.Builder<a, d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f39170a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar) {
            super(dVar);
            this.f39170a = dVar;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot build() {
            return this.f39170a;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder returnThis() {
            return this;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder setPowerIndex(int i) {
            this.f39170a.G = i;
            return this;
        }
    }

    @Override // com.kc.dw.core.ad.BaseAdSlot
    public int getClk_type() {
        return this.E;
    }

    @Override // com.kc.dw.core.ad.BaseAdSlot
    public int getPower_index() {
        return this.G;
    }
}
