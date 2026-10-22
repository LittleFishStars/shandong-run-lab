package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/run/bean/HomeJackpotBriefBean;", "", "inspiration", "Lcom/huachenjie/run/bean/HomeInspirationBrief;", "(Lcom/huachenjie/run/bean/HomeInspirationBrief;)V", "getInspiration", "()Lcom/huachenjie/run/bean/HomeInspirationBrief;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HomeJackpotBriefBean {

    @NotNull
    private final HomeInspirationBrief inspiration;

    /* JADX WARN: Illegal instructions before constructor call */
    public HomeJackpotBriefBean() {
        HomeInspirationBrief homeInspirationBrief = null;
        this(homeInspirationBrief, 1, homeInspirationBrief);
    }

    public HomeJackpotBriefBean(@NotNull HomeInspirationBrief homeInspirationBrief) {
        Intrinsics.checkNotNullParameter(homeInspirationBrief, "inspiration");
        this.inspiration = homeInspirationBrief;
    }

    public static /* synthetic */ HomeJackpotBriefBean copy$default(HomeJackpotBriefBean homeJackpotBriefBean, HomeInspirationBrief homeInspirationBrief, int i, Object obj) {
        if ((i & 1) != 0) {
            homeInspirationBrief = homeJackpotBriefBean.inspiration;
        }
        return homeJackpotBriefBean.copy(homeInspirationBrief);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HomeInspirationBrief getInspiration() {
        return this.inspiration;
    }

    @NotNull
    public final HomeJackpotBriefBean copy(@NotNull HomeInspirationBrief inspiration) {
        Intrinsics.checkNotNullParameter(inspiration, "inspiration");
        return new HomeJackpotBriefBean(inspiration);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HomeJackpotBriefBean) && Intrinsics.areEqual(this.inspiration, ((HomeJackpotBriefBean) other).inspiration);
    }

    @NotNull
    public final HomeInspirationBrief getInspiration() {
        return this.inspiration;
    }

    public int hashCode() {
        return this.inspiration.hashCode();
    }

    @NotNull
    public String toString() {
        return "HomeJackpotBriefBean(inspiration=" + this.inspiration + ')';
    }

    public /* synthetic */ HomeJackpotBriefBean(HomeInspirationBrief homeInspirationBrief, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new HomeInspirationBrief(0, 1, null) : homeInspirationBrief);
    }
}
