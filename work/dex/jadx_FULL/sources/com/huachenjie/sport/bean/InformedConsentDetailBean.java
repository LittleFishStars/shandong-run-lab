package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/sport/bean/InformedConsentDetailBean;", "", "detailContent", "", "hasConsent", "", "(Ljava/lang/String;Z)V", "getDetailContent", "()Ljava/lang/String;", "getHasConsent", "()Z", "component1", "component2", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class InformedConsentDetailBean {

    @NotNull
    private final String detailContent;
    private final boolean hasConsent;

    /* JADX WARN: Illegal instructions before constructor call */
    public InformedConsentDetailBean() {
        String str = null;
        this(str, false, 3, str);
    }

    public InformedConsentDetailBean(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "detailContent");
        this.detailContent = str;
        this.hasConsent = z;
    }

    public static /* synthetic */ InformedConsentDetailBean copy$default(InformedConsentDetailBean informedConsentDetailBean, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = informedConsentDetailBean.detailContent;
        }
        if ((i & 2) != 0) {
            z = informedConsentDetailBean.hasConsent;
        }
        return informedConsentDetailBean.copy(str, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDetailContent() {
        return this.detailContent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasConsent() {
        return this.hasConsent;
    }

    @NotNull
    public final InformedConsentDetailBean copy(@NotNull String detailContent, boolean hasConsent) {
        Intrinsics.checkNotNullParameter(detailContent, "detailContent");
        return new InformedConsentDetailBean(detailContent, hasConsent);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InformedConsentDetailBean)) {
            return false;
        }
        InformedConsentDetailBean informedConsentDetailBean = (InformedConsentDetailBean) other;
        return Intrinsics.areEqual(this.detailContent, informedConsentDetailBean.detailContent) && this.hasConsent == informedConsentDetailBean.hasConsent;
    }

    @NotNull
    public final String getDetailContent() {
        return this.detailContent;
    }

    public final boolean getHasConsent() {
        return this.hasConsent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.detailContent.hashCode() * 31;
        boolean z = this.hasConsent;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    @NotNull
    public String toString() {
        return "InformedConsentDetailBean(detailContent=" + this.detailContent + ", hasConsent=" + this.hasConsent + ')';
    }

    public /* synthetic */ InformedConsentDetailBean(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z);
    }
}
