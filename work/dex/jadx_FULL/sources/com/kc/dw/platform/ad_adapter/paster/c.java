package com.kc.dw.platform.ad_adapter.paster;

import android.view.View;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.utils.f;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.ad.nativ.d f39483a;
    public final d.a b;

    public c(d.a aVar, com.kc.dw.ad.nativ.d dVar) {
        this.b = aVar;
        this.f39483a = dVar;
    }

    @Override // com.kc.dw.core.safe.m
    public void safeOnClick(View view) {
        String default_coord;
        d dVar = this.b.b;
        if (dVar.g) {
            T t = dVar.f39477a;
            if (t != 0 && ((i) t).getCbc() == 0 && this.b.b.i.getInteractionListener() != null) {
                this.b.b.i.getInteractionListener().onAdClicked();
            }
            this.f39483a.setInteractionListener(this.b.b.i.getInteractionListener());
            this.f39483a.a().setClkActType(1);
            try {
                String[] clickUrl = this.f39483a.a().getClickUrl();
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i = this.b.b.m;
                int i2 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
                if (i == 0) {
                    i = -999;
                }
                String strValueOf = String.valueOf(i);
                int i3 = this.b.b.n;
                if (i3 == 0) {
                    i3 = -999;
                }
                String strValueOf2 = String.valueOf(i3);
                int i4 = this.b.b.o;
                if (i4 == 0) {
                    i4 = -999;
                }
                String strValueOf3 = String.valueOf(i4);
                int i5 = this.b.b.p;
                if (i5 != 0) {
                    i2 = i5;
                }
                String strValueOf4 = String.valueOf(i2);
                long j = jCurrentTimeMillis / 1000;
                long j2 = this.b.b.q;
                try {
                    i iVarA = this.f39483a.a();
                    if ((iVarA instanceof BaseAdSlot) && (default_coord = iVarA.getDefault_coord()) != null) {
                        if ("-999".equals(strValueOf)) {
                            strValueOf = default_coord;
                        }
                        if ("-999".equals(strValueOf2)) {
                            strValueOf2 = default_coord;
                        }
                        if ("-999".equals(strValueOf3)) {
                            strValueOf3 = default_coord;
                        }
                        if ("-999".equals(strValueOf4)) {
                            strValueOf4 = default_coord;
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                for (int i6 = 0; i6 < clickUrl.length; i6++) {
                    clickUrl[i6] = f.a(clickUrl[i6], strValueOf, strValueOf2, strValueOf3, strValueOf4, String.valueOf(j), String.valueOf(j2), String.valueOf(j2), String.valueOf(jCurrentTimeMillis));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            f.a((com.kc.dw.platform.ad_adapter.c) this.f39483a, true);
        }
    }
}
