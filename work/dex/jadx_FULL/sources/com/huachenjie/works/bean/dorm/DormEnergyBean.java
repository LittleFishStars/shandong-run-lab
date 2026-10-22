package com.huachenjie.works.bean.dorm;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/works/bean/dorm/DormEnergyBean;", "", "energyValue", "", "showSupplementBtn", "", "digesting", "countdownSeconds", "digestStartTime", "", "digestEndTime", "(IZZILjava/lang/String;Ljava/lang/String;)V", "getCountdownSeconds", "()I", "setCountdownSeconds", "(I)V", "getDigestEndTime", "()Ljava/lang/String;", "getDigestStartTime", "getDigesting", "()Z", "getEnergyValue", "getShowSupplementBtn", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DormEnergyBean {
    private int countdownSeconds;

    @NotNull
    private final String digestEndTime;

    @NotNull
    private final String digestStartTime;
    private final boolean digesting;
    private final int energyValue;
    private final boolean showSupplementBtn;

    public DormEnergyBean() {
        this(0, false, false, 0, null, null, 63, null);
    }

    public DormEnergyBean(int i, boolean z, boolean z2, int i2, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "digestStartTime");
        Intrinsics.checkNotNullParameter(str2, "digestEndTime");
        this.energyValue = i;
        this.showSupplementBtn = z;
        this.digesting = z2;
        this.countdownSeconds = i2;
        this.digestStartTime = str;
        this.digestEndTime = str2;
    }

    public final int getCountdownSeconds() {
        return this.countdownSeconds;
    }

    @NotNull
    public final String getDigestEndTime() {
        return this.digestEndTime;
    }

    @NotNull
    public final String getDigestStartTime() {
        return this.digestStartTime;
    }

    public final boolean getDigesting() {
        return this.digesting;
    }

    public final int getEnergyValue() {
        return this.energyValue;
    }

    public final boolean getShowSupplementBtn() {
        return this.showSupplementBtn;
    }

    public final void setCountdownSeconds(int i) {
        this.countdownSeconds = i;
    }

    public /* synthetic */ DormEnergyBean(int i, boolean z, boolean z2, int i2, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? false : z2, (i3 & 8) == 0 ? i2 : 0, (i3 & 16) != 0 ? "" : str, (i3 & 32) != 0 ? "" : str2);
    }
}
