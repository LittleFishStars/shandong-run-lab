package com.huachenjie.home.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/home/bean/AwardBean;", "", "awardNo", "", "awardLinkNo", "awardName", "imgUrl", "awardType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAwardLinkNo", "()Ljava/lang/String;", "getAwardName", "getAwardNo", "getAwardType", "()I", "getImgUrl", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AwardBean {

    @NotNull
    private final String awardLinkNo;

    @NotNull
    private final String awardName;

    @NotNull
    private final String awardNo;
    private final int awardType;

    @NotNull
    private final String imgUrl;

    public AwardBean() {
        this(null, null, null, null, 0, 31, null);
    }

    public AwardBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i) {
        Intrinsics.checkNotNullParameter(str, "awardNo");
        Intrinsics.checkNotNullParameter(str2, "awardLinkNo");
        Intrinsics.checkNotNullParameter(str3, "awardName");
        Intrinsics.checkNotNullParameter(str4, "imgUrl");
        this.awardNo = str;
        this.awardLinkNo = str2;
        this.awardName = str3;
        this.imgUrl = str4;
        this.awardType = i;
    }

    public static /* synthetic */ AwardBean copy$default(AwardBean awardBean, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = awardBean.awardNo;
        }
        if ((i2 & 2) != 0) {
            str2 = awardBean.awardLinkNo;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = awardBean.awardName;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = awardBean.imgUrl;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            i = awardBean.awardType;
        }
        return awardBean.copy(str, str5, str6, str7, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAwardNo() {
        return this.awardNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAwardLinkNo() {
        return this.awardLinkNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAwardName() {
        return this.awardName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImgUrl() {
        return this.imgUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getAwardType() {
        return this.awardType;
    }

    @NotNull
    public final AwardBean copy(@NotNull String awardNo, @NotNull String awardLinkNo, @NotNull String awardName, @NotNull String imgUrl, int awardType) {
        Intrinsics.checkNotNullParameter(awardNo, "awardNo");
        Intrinsics.checkNotNullParameter(awardLinkNo, "awardLinkNo");
        Intrinsics.checkNotNullParameter(awardName, "awardName");
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        return new AwardBean(awardNo, awardLinkNo, awardName, imgUrl, awardType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AwardBean)) {
            return false;
        }
        AwardBean awardBean = (AwardBean) other;
        return Intrinsics.areEqual(this.awardNo, awardBean.awardNo) && Intrinsics.areEqual(this.awardLinkNo, awardBean.awardLinkNo) && Intrinsics.areEqual(this.awardName, awardBean.awardName) && Intrinsics.areEqual(this.imgUrl, awardBean.imgUrl) && this.awardType == awardBean.awardType;
    }

    @NotNull
    public final String getAwardLinkNo() {
        return this.awardLinkNo;
    }

    @NotNull
    public final String getAwardName() {
        return this.awardName;
    }

    @NotNull
    public final String getAwardNo() {
        return this.awardNo;
    }

    public final int getAwardType() {
        return this.awardType;
    }

    @NotNull
    public final String getImgUrl() {
        return this.imgUrl;
    }

    public int hashCode() {
        return (((((((this.awardNo.hashCode() * 31) + this.awardLinkNo.hashCode()) * 31) + this.awardName.hashCode()) * 31) + this.imgUrl.hashCode()) * 31) + Integer.hashCode(this.awardType);
    }

    @NotNull
    public String toString() {
        return "AwardBean(awardNo=" + this.awardNo + ", awardLinkNo=" + this.awardLinkNo + ", awardName=" + this.awardName + ", imgUrl=" + this.imgUrl + ", awardType=" + this.awardType + ')';
    }

    public /* synthetic */ AwardBean(String str, String str2, String str3, String str4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? 0 : i);
    }
}
