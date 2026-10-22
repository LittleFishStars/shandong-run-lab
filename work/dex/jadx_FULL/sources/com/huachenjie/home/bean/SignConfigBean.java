package com.huachenjie.home.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J7\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/huachenjie/home/bean/SignConfigBean;", "", "continueDays", "", "signList", "", "Lcom/huachenjie/home/bean/SignBean;", "todaySigned", "", "videoConfig", "Lcom/huachenjie/home/bean/VideoConfigBean;", "(ILjava/util/List;ZLcom/huachenjie/home/bean/VideoConfigBean;)V", "getContinueDays", "()I", "setContinueDays", "(I)V", "getSignList", "()Ljava/util/List;", "getTodaySigned", "()Z", "setTodaySigned", "(Z)V", "getVideoConfig", "()Lcom/huachenjie/home/bean/VideoConfigBean;", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SignConfigBean {
    private int continueDays;

    @NotNull
    private final List<SignBean> signList;
    private boolean todaySigned;

    @NotNull
    private final VideoConfigBean videoConfig;

    public SignConfigBean() {
        this(0, null, false, null, 15, null);
    }

    public SignConfigBean(int i, @NotNull List<SignBean> list, boolean z, @NotNull VideoConfigBean videoConfigBean) {
        Intrinsics.checkNotNullParameter(list, "signList");
        Intrinsics.checkNotNullParameter(videoConfigBean, "videoConfig");
        this.continueDays = i;
        this.signList = list;
        this.todaySigned = z;
        this.videoConfig = videoConfigBean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SignConfigBean copy$default(SignConfigBean signConfigBean, int i, List list, boolean z, VideoConfigBean videoConfigBean, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = signConfigBean.continueDays;
        }
        if ((i2 & 2) != 0) {
            list = signConfigBean.signList;
        }
        if ((i2 & 4) != 0) {
            z = signConfigBean.todaySigned;
        }
        if ((i2 & 8) != 0) {
            videoConfigBean = signConfigBean.videoConfig;
        }
        return signConfigBean.copy(i, list, z, videoConfigBean);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getContinueDays() {
        return this.continueDays;
    }

    @NotNull
    public final List<SignBean> component2() {
        return this.signList;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getTodaySigned() {
        return this.todaySigned;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final VideoConfigBean getVideoConfig() {
        return this.videoConfig;
    }

    @NotNull
    public final SignConfigBean copy(int continueDays, @NotNull List<SignBean> signList, boolean todaySigned, @NotNull VideoConfigBean videoConfig) {
        Intrinsics.checkNotNullParameter(signList, "signList");
        Intrinsics.checkNotNullParameter(videoConfig, "videoConfig");
        return new SignConfigBean(continueDays, signList, todaySigned, videoConfig);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignConfigBean)) {
            return false;
        }
        SignConfigBean signConfigBean = (SignConfigBean) other;
        return this.continueDays == signConfigBean.continueDays && Intrinsics.areEqual(this.signList, signConfigBean.signList) && this.todaySigned == signConfigBean.todaySigned && Intrinsics.areEqual(this.videoConfig, signConfigBean.videoConfig);
    }

    public final int getContinueDays() {
        return this.continueDays;
    }

    @NotNull
    public final List<SignBean> getSignList() {
        return this.signList;
    }

    public final boolean getTodaySigned() {
        return this.todaySigned;
    }

    @NotNull
    public final VideoConfigBean getVideoConfig() {
        return this.videoConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.continueDays) * 31) + this.signList.hashCode()) * 31;
        boolean z = this.todaySigned;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + this.videoConfig.hashCode();
    }

    public final void setContinueDays(int i) {
        this.continueDays = i;
    }

    public final void setTodaySigned(boolean z) {
        this.todaySigned = z;
    }

    @NotNull
    public String toString() {
        return "SignConfigBean(continueDays=" + this.continueDays + ", signList=" + this.signList + ", todaySigned=" + this.todaySigned + ", videoConfig=" + this.videoConfig + ')';
    }

    public /* synthetic */ SignConfigBean(int i, List list, boolean z, VideoConfigBean videoConfigBean, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new ArrayList() : list, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? new VideoConfigBean(false, 0, 0, 0, 15, null) : videoConfigBean);
    }
}
