package com.huachenjie.works.bean.dorm;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.bean.SpineSuitModelBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n¢\u0006\u0002\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u0083\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001J\u0013\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0006HÖ\u0001J\t\u00105\u001a\u00020\nHÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001a¨\u00066"}, d2 = {"Lcom/huachenjie/works/bean/dorm/DormUserInfoBean;", "", "metaAuthFlag", "", "bisVip", "suitId", "", "spine", "Lcom/huachenjie/common/bean/SpineSuitModelBean;", "attitudeImgUrl", "", "attitudeName", "attitudeJsonUrl", "metaverseUserId", "charmValue", "inspirationValue", "starStone", "ruleUrl", "(ZZILcom/huachenjie/common/bean/SpineSuitModelBean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttitudeImgUrl", "()Ljava/lang/String;", "getAttitudeJsonUrl", "getAttitudeName", "getBisVip", "()Z", "getCharmValue", "()I", "setCharmValue", "(I)V", "getInspirationValue", "getMetaAuthFlag", "getMetaverseUserId", "getRuleUrl", "getSpine", "()Lcom/huachenjie/common/bean/SpineSuitModelBean;", "getStarStone", "getSuitId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DormUserInfoBean {

    @NotNull
    private final String attitudeImgUrl;

    @NotNull
    private final String attitudeJsonUrl;

    @NotNull
    private final String attitudeName;
    private final boolean bisVip;
    private int charmValue;

    @NotNull
    private final String inspirationValue;
    private final boolean metaAuthFlag;

    @NotNull
    private final String metaverseUserId;

    @NotNull
    private final String ruleUrl;

    @Nullable
    private final SpineSuitModelBean spine;

    @NotNull
    private final String starStone;
    private final int suitId;

    public DormUserInfoBean() {
        this(false, false, 0, null, null, null, null, null, 0, null, null, null, 4095, null);
    }

    public DormUserInfoBean(boolean z, boolean z2, int i, @Nullable SpineSuitModelBean spineSuitModelBean, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i2, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "attitudeImgUrl");
        Intrinsics.checkNotNullParameter(str2, "attitudeName");
        Intrinsics.checkNotNullParameter(str3, "attitudeJsonUrl");
        Intrinsics.checkNotNullParameter(str4, "metaverseUserId");
        Intrinsics.checkNotNullParameter(str5, "inspirationValue");
        Intrinsics.checkNotNullParameter(str6, "starStone");
        Intrinsics.checkNotNullParameter(str7, "ruleUrl");
        this.metaAuthFlag = z;
        this.bisVip = z2;
        this.suitId = i;
        this.spine = spineSuitModelBean;
        this.attitudeImgUrl = str;
        this.attitudeName = str2;
        this.attitudeJsonUrl = str3;
        this.metaverseUserId = str4;
        this.charmValue = i2;
        this.inspirationValue = str5;
        this.starStone = str6;
        this.ruleUrl = str7;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getMetaAuthFlag() {
        return this.metaAuthFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getInspirationValue() {
        return this.inspirationValue;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getStarStone() {
        return this.starStone;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getRuleUrl() {
        return this.ruleUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getBisVip() {
        return this.bisVip;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSuitId() {
        return this.suitId;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SpineSuitModelBean getSpine() {
        return this.spine;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAttitudeImgUrl() {
        return this.attitudeImgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAttitudeName() {
        return this.attitudeName;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAttitudeJsonUrl() {
        return this.attitudeJsonUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMetaverseUserId() {
        return this.metaverseUserId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getCharmValue() {
        return this.charmValue;
    }

    @NotNull
    public final DormUserInfoBean copy(boolean metaAuthFlag, boolean bisVip, int suitId, @Nullable SpineSuitModelBean spine, @NotNull String attitudeImgUrl, @NotNull String attitudeName, @NotNull String attitudeJsonUrl, @NotNull String metaverseUserId, int charmValue, @NotNull String inspirationValue, @NotNull String starStone, @NotNull String ruleUrl) {
        Intrinsics.checkNotNullParameter(attitudeImgUrl, "attitudeImgUrl");
        Intrinsics.checkNotNullParameter(attitudeName, "attitudeName");
        Intrinsics.checkNotNullParameter(attitudeJsonUrl, "attitudeJsonUrl");
        Intrinsics.checkNotNullParameter(metaverseUserId, "metaverseUserId");
        Intrinsics.checkNotNullParameter(inspirationValue, "inspirationValue");
        Intrinsics.checkNotNullParameter(starStone, "starStone");
        Intrinsics.checkNotNullParameter(ruleUrl, "ruleUrl");
        return new DormUserInfoBean(metaAuthFlag, bisVip, suitId, spine, attitudeImgUrl, attitudeName, attitudeJsonUrl, metaverseUserId, charmValue, inspirationValue, starStone, ruleUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DormUserInfoBean)) {
            return false;
        }
        DormUserInfoBean dormUserInfoBean = (DormUserInfoBean) other;
        return this.metaAuthFlag == dormUserInfoBean.metaAuthFlag && this.bisVip == dormUserInfoBean.bisVip && this.suitId == dormUserInfoBean.suitId && Intrinsics.areEqual(this.spine, dormUserInfoBean.spine) && Intrinsics.areEqual(this.attitudeImgUrl, dormUserInfoBean.attitudeImgUrl) && Intrinsics.areEqual(this.attitudeName, dormUserInfoBean.attitudeName) && Intrinsics.areEqual(this.attitudeJsonUrl, dormUserInfoBean.attitudeJsonUrl) && Intrinsics.areEqual(this.metaverseUserId, dormUserInfoBean.metaverseUserId) && this.charmValue == dormUserInfoBean.charmValue && Intrinsics.areEqual(this.inspirationValue, dormUserInfoBean.inspirationValue) && Intrinsics.areEqual(this.starStone, dormUserInfoBean.starStone) && Intrinsics.areEqual(this.ruleUrl, dormUserInfoBean.ruleUrl);
    }

    @NotNull
    public final String getAttitudeImgUrl() {
        return this.attitudeImgUrl;
    }

    @NotNull
    public final String getAttitudeJsonUrl() {
        return this.attitudeJsonUrl;
    }

    @NotNull
    public final String getAttitudeName() {
        return this.attitudeName;
    }

    public final boolean getBisVip() {
        return this.bisVip;
    }

    public final int getCharmValue() {
        return this.charmValue;
    }

    @NotNull
    public final String getInspirationValue() {
        return this.inspirationValue;
    }

    public final boolean getMetaAuthFlag() {
        return this.metaAuthFlag;
    }

    @NotNull
    public final String getMetaverseUserId() {
        return this.metaverseUserId;
    }

    @NotNull
    public final String getRuleUrl() {
        return this.ruleUrl;
    }

    @Nullable
    public final SpineSuitModelBean getSpine() {
        return this.spine;
    }

    @NotNull
    public final String getStarStone() {
        return this.starStone;
    }

    public final int getSuitId() {
        return this.suitId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24 */
    public int hashCode() {
        boolean z = this.metaAuthFlag;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.bisVip;
        int iHashCode = (((i + (z2 ? 1 : z2)) * 31) + Integer.hashCode(this.suitId)) * 31;
        SpineSuitModelBean spineSuitModelBean = this.spine;
        return ((((((((((((((((iHashCode + (spineSuitModelBean == null ? 0 : spineSuitModelBean.hashCode())) * 31) + this.attitudeImgUrl.hashCode()) * 31) + this.attitudeName.hashCode()) * 31) + this.attitudeJsonUrl.hashCode()) * 31) + this.metaverseUserId.hashCode()) * 31) + Integer.hashCode(this.charmValue)) * 31) + this.inspirationValue.hashCode()) * 31) + this.starStone.hashCode()) * 31) + this.ruleUrl.hashCode();
    }

    public final void setCharmValue(int i) {
        this.charmValue = i;
    }

    @NotNull
    public String toString() {
        return "DormUserInfoBean(metaAuthFlag=" + this.metaAuthFlag + ", bisVip=" + this.bisVip + ", suitId=" + this.suitId + ", spine=" + this.spine + ", attitudeImgUrl=" + this.attitudeImgUrl + ", attitudeName=" + this.attitudeName + ", attitudeJsonUrl=" + this.attitudeJsonUrl + ", metaverseUserId=" + this.metaverseUserId + ", charmValue=" + this.charmValue + ", inspirationValue=" + this.inspirationValue + ", starStone=" + this.starStone + ", ruleUrl=" + this.ruleUrl + ')';
    }

    public /* synthetic */ DormUserInfoBean(boolean z, boolean z2, int i, SpineSuitModelBean spineSuitModelBean, String str, String str2, String str3, String str4, int i2, String str5, String str6, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? null : spineSuitModelBean, (i3 & 16) != 0 ? "" : str, (i3 & 32) != 0 ? "" : str2, (i3 & 64) != 0 ? "" : str3, (i3 & 128) != 0 ? "" : str4, (i3 & 256) == 0 ? i2 : 0, (i3 & 512) != 0 ? "" : str5, (i3 & 1024) != 0 ? "" : str6, (i3 & 2048) == 0 ? str7 : "");
    }
}
