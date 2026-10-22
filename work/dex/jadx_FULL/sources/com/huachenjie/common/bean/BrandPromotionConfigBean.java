package com.huachenjie.common.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/common/bean/BrandPromotionConfigBean;", "", "brandName", "", "barrageText", "countdownIconUrl", "finishIconUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBarrageText", "()Ljava/lang/String;", "getBrandName", "getCountdownIconUrl", "getFinishIconUrl", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BrandPromotionConfigBean {

    @NotNull
    private final String barrageText;

    @NotNull
    private final String brandName;

    @NotNull
    private final String countdownIconUrl;

    @NotNull
    private final String finishIconUrl;

    public BrandPromotionConfigBean() {
        this(null, null, null, null, 15, null);
    }

    public BrandPromotionConfigBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "brandName");
        Intrinsics.checkNotNullParameter(str2, "barrageText");
        Intrinsics.checkNotNullParameter(str3, "countdownIconUrl");
        Intrinsics.checkNotNullParameter(str4, "finishIconUrl");
        this.brandName = str;
        this.barrageText = str2;
        this.countdownIconUrl = str3;
        this.finishIconUrl = str4;
    }

    public static /* synthetic */ BrandPromotionConfigBean copy$default(BrandPromotionConfigBean brandPromotionConfigBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brandPromotionConfigBean.brandName;
        }
        if ((i & 2) != 0) {
            str2 = brandPromotionConfigBean.barrageText;
        }
        if ((i & 4) != 0) {
            str3 = brandPromotionConfigBean.countdownIconUrl;
        }
        if ((i & 8) != 0) {
            str4 = brandPromotionConfigBean.finishIconUrl;
        }
        return brandPromotionConfigBean.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBrandName() {
        return this.brandName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBarrageText() {
        return this.barrageText;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCountdownIconUrl() {
        return this.countdownIconUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFinishIconUrl() {
        return this.finishIconUrl;
    }

    @NotNull
    public final BrandPromotionConfigBean copy(@NotNull String brandName, @NotNull String barrageText, @NotNull String countdownIconUrl, @NotNull String finishIconUrl) {
        Intrinsics.checkNotNullParameter(brandName, "brandName");
        Intrinsics.checkNotNullParameter(barrageText, "barrageText");
        Intrinsics.checkNotNullParameter(countdownIconUrl, "countdownIconUrl");
        Intrinsics.checkNotNullParameter(finishIconUrl, "finishIconUrl");
        return new BrandPromotionConfigBean(brandName, barrageText, countdownIconUrl, finishIconUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BrandPromotionConfigBean)) {
            return false;
        }
        BrandPromotionConfigBean brandPromotionConfigBean = (BrandPromotionConfigBean) other;
        return Intrinsics.areEqual(this.brandName, brandPromotionConfigBean.brandName) && Intrinsics.areEqual(this.barrageText, brandPromotionConfigBean.barrageText) && Intrinsics.areEqual(this.countdownIconUrl, brandPromotionConfigBean.countdownIconUrl) && Intrinsics.areEqual(this.finishIconUrl, brandPromotionConfigBean.finishIconUrl);
    }

    @NotNull
    public final String getBarrageText() {
        return this.barrageText;
    }

    @NotNull
    public final String getBrandName() {
        return this.brandName;
    }

    @NotNull
    public final String getCountdownIconUrl() {
        return this.countdownIconUrl;
    }

    @NotNull
    public final String getFinishIconUrl() {
        return this.finishIconUrl;
    }

    public int hashCode() {
        return (((((this.brandName.hashCode() * 31) + this.barrageText.hashCode()) * 31) + this.countdownIconUrl.hashCode()) * 31) + this.finishIconUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "BrandPromotionConfigBean(brandName=" + this.brandName + ", barrageText=" + this.barrageText + ", countdownIconUrl=" + this.countdownIconUrl + ", finishIconUrl=" + this.finishIconUrl + ")";
    }

    public /* synthetic */ BrandPromotionConfigBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}
