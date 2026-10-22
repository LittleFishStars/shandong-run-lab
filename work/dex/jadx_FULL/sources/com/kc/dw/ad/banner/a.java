package com.kc.dw.ad.banner;

import com.kc.dw.core.ad.BaseAdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a extends BaseAdSlot {

    /* JADX INFO: renamed from: com.kc.dw.ad.banner.a$a, reason: collision with other inner class name */
    @Keep
    public class C1018a extends BaseAdSlot.Builder<C1018a, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39085a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1018a(a aVar) {
            super(aVar);
            this.f39085a = aVar;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot build() {
            return this.f39085a;
        }

        @Override // com.kc.dw.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder returnThis() {
            return this;
        }
    }
}
