package cj.mobile.jt.core.modle;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class h0 implements IJuTuiBiddingAdData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22506a;
    public final List b;
    public final List c;
    public final String d;

    public h0(long j, List<String> list, List<String> list2, String str) {
    }

    @Override // cj.mobile.jt.core.modle.IJuTuiBiddingAdData
    public final long getEcpm() {
        return this.f22506a;
    }

    @Override // cj.mobile.jt.core.modle.IJuTuiBiddingAdData
    public final Map getExtra() {
        return Collections.emptyMap();
    }

    @Override // cj.mobile.jt.core.modle.IJuTuiBiddingAdData
    public final void notifyLoss(float f, IJuTuiBiddingAdData.LOSS_REASON loss_reason, String str) {
    }

    @Override // cj.mobile.jt.core.modle.IJuTuiBiddingAdData
    public final void notifyWin(float f) {
    }
}
