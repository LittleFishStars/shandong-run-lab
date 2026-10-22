package com.kc.dw.ad.interstitial;

import com.kc.dw.core.ad.BaseAdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b extends BaseAdSlot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f39094a;

    @Keep
    public class a extends BaseAdSlot.Builder<a, b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f39095a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar) {
            super(bVar);
            this.f39095a = bVar;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot build() {
            return this.f39095a;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder returnThis() {
            return this;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder setTitle(String str) {
            this.f39095a.f39094a = str;
            return this;
        }
    }

    @Override // com.kc.dw.core.ad.BaseAdSlot
    public String getTitle() {
        return this.f39094a;
    }
}
