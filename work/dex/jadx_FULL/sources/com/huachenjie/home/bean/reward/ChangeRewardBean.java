package com.huachenjie.home.bean.reward;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006#"}, d2 = {"Lcom/huachenjie/home/bean/reward/ChangeRewardBean;", "", "probabilityPublicityUrl", "", "ruleDescriptionUrl", "jackpotList", "", "Lcom/huachenjie/home/bean/reward/JackpotListBean;", "inspiration", "", "lotteryThemeConfig", "Lcom/huachenjie/home/bean/reward/LotteryThemeConfig;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILcom/huachenjie/home/bean/reward/LotteryThemeConfig;)V", "getInspiration", "()I", "setInspiration", "(I)V", "getJackpotList", "()Ljava/util/List;", "getLotteryThemeConfig", "()Lcom/huachenjie/home/bean/reward/LotteryThemeConfig;", "getProbabilityPublicityUrl", "()Ljava/lang/String;", "getRuleDescriptionUrl", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ChangeRewardBean {
    private int inspiration;

    @NotNull
    private final List<JackpotListBean> jackpotList;

    @NotNull
    private final LotteryThemeConfig lotteryThemeConfig;

    @NotNull
    private final String probabilityPublicityUrl;

    @NotNull
    private final String ruleDescriptionUrl;

    public ChangeRewardBean() {
        this(null, null, null, 0, null, 31, null);
    }

    public ChangeRewardBean(@NotNull String str, @NotNull String str2, @NotNull List<JackpotListBean> list, int i, @NotNull LotteryThemeConfig lotteryThemeConfig) {
        Intrinsics.checkNotNullParameter(str, "probabilityPublicityUrl");
        Intrinsics.checkNotNullParameter(str2, "ruleDescriptionUrl");
        Intrinsics.checkNotNullParameter(list, "jackpotList");
        Intrinsics.checkNotNullParameter(lotteryThemeConfig, "lotteryThemeConfig");
        this.probabilityPublicityUrl = str;
        this.ruleDescriptionUrl = str2;
        this.jackpotList = list;
        this.inspiration = i;
        this.lotteryThemeConfig = lotteryThemeConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChangeRewardBean copy$default(ChangeRewardBean changeRewardBean, String str, String str2, List list, int i, LotteryThemeConfig lotteryThemeConfig, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = changeRewardBean.probabilityPublicityUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = changeRewardBean.ruleDescriptionUrl;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            list = changeRewardBean.jackpotList;
        }
        List list2 = list;
        if ((i2 & 8) != 0) {
            i = changeRewardBean.inspiration;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            lotteryThemeConfig = changeRewardBean.lotteryThemeConfig;
        }
        return changeRewardBean.copy(str, str3, list2, i3, lotteryThemeConfig);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProbabilityPublicityUrl() {
        return this.probabilityPublicityUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRuleDescriptionUrl() {
        return this.ruleDescriptionUrl;
    }

    @NotNull
    public final List<JackpotListBean> component3() {
        return this.jackpotList;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getInspiration() {
        return this.inspiration;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final LotteryThemeConfig getLotteryThemeConfig() {
        return this.lotteryThemeConfig;
    }

    @NotNull
    public final ChangeRewardBean copy(@NotNull String probabilityPublicityUrl, @NotNull String ruleDescriptionUrl, @NotNull List<JackpotListBean> jackpotList, int inspiration, @NotNull LotteryThemeConfig lotteryThemeConfig) {
        Intrinsics.checkNotNullParameter(probabilityPublicityUrl, "probabilityPublicityUrl");
        Intrinsics.checkNotNullParameter(ruleDescriptionUrl, "ruleDescriptionUrl");
        Intrinsics.checkNotNullParameter(jackpotList, "jackpotList");
        Intrinsics.checkNotNullParameter(lotteryThemeConfig, "lotteryThemeConfig");
        return new ChangeRewardBean(probabilityPublicityUrl, ruleDescriptionUrl, jackpotList, inspiration, lotteryThemeConfig);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChangeRewardBean)) {
            return false;
        }
        ChangeRewardBean changeRewardBean = (ChangeRewardBean) other;
        return Intrinsics.areEqual(this.probabilityPublicityUrl, changeRewardBean.probabilityPublicityUrl) && Intrinsics.areEqual(this.ruleDescriptionUrl, changeRewardBean.ruleDescriptionUrl) && Intrinsics.areEqual(this.jackpotList, changeRewardBean.jackpotList) && this.inspiration == changeRewardBean.inspiration && Intrinsics.areEqual(this.lotteryThemeConfig, changeRewardBean.lotteryThemeConfig);
    }

    public final int getInspiration() {
        return this.inspiration;
    }

    @NotNull
    public final List<JackpotListBean> getJackpotList() {
        return this.jackpotList;
    }

    @NotNull
    public final LotteryThemeConfig getLotteryThemeConfig() {
        return this.lotteryThemeConfig;
    }

    @NotNull
    public final String getProbabilityPublicityUrl() {
        return this.probabilityPublicityUrl;
    }

    @NotNull
    public final String getRuleDescriptionUrl() {
        return this.ruleDescriptionUrl;
    }

    public int hashCode() {
        return (((((((this.probabilityPublicityUrl.hashCode() * 31) + this.ruleDescriptionUrl.hashCode()) * 31) + this.jackpotList.hashCode()) * 31) + Integer.hashCode(this.inspiration)) * 31) + this.lotteryThemeConfig.hashCode();
    }

    public final void setInspiration(int i) {
        this.inspiration = i;
    }

    @NotNull
    public String toString() {
        return "ChangeRewardBean(probabilityPublicityUrl=" + this.probabilityPublicityUrl + ", ruleDescriptionUrl=" + this.ruleDescriptionUrl + ", jackpotList=" + this.jackpotList + ", inspiration=" + this.inspiration + ", lotteryThemeConfig=" + this.lotteryThemeConfig + ')';
    }

    public /* synthetic */ ChangeRewardBean(String str, String str2, List list, int i, LotteryThemeConfig lotteryThemeConfig, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) == 0 ? str2 : "", (i2 & 4) != 0 ? new ArrayList() : list, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? new LotteryThemeConfig(null, null, null, 7, null) : lotteryThemeConfig);
    }
}
