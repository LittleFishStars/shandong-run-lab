package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\rJ\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jz\u0010\"\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006)"}, d2 = {"Lcom/huachenjie/sport/bean/OutsideRecord;", "", "signInImgUrl", "", "", "signInLocationName", "signInStatus", "", "signInTime", "signOutImgUrl", "signOutLocationName", "signOutStatus", "signOutTime", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getSignInImgUrl", "()Ljava/util/List;", "getSignInLocationName", "()Ljava/lang/String;", "getSignInStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSignInTime", "getSignOutImgUrl", "getSignOutLocationName", "getSignOutStatus", "getSignOutTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/huachenjie/sport/bean/OutsideRecord;", "equals", "", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OutsideRecord {

    @Nullable
    private final List<String> signInImgUrl;

    @Nullable
    private final String signInLocationName;

    @Nullable
    private final Integer signInStatus;

    @Nullable
    private final String signInTime;

    @Nullable
    private final List<String> signOutImgUrl;

    @Nullable
    private final String signOutLocationName;

    @Nullable
    private final Integer signOutStatus;

    @Nullable
    private final String signOutTime;

    public OutsideRecord(@Nullable List<String> list, @Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable List<String> list2, @Nullable String str3, @Nullable Integer num2, @Nullable String str4) {
        this.signInImgUrl = list;
        this.signInLocationName = str;
        this.signInStatus = num;
        this.signInTime = str2;
        this.signOutImgUrl = list2;
        this.signOutLocationName = str3;
        this.signOutStatus = num2;
        this.signOutTime = str4;
    }

    @Nullable
    public final List<String> component1() {
        return this.signInImgUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSignInLocationName() {
        return this.signInLocationName;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getSignInStatus() {
        return this.signInStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSignInTime() {
        return this.signInTime;
    }

    @Nullable
    public final List<String> component5() {
        return this.signOutImgUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSignOutLocationName() {
        return this.signOutLocationName;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getSignOutStatus() {
        return this.signOutStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSignOutTime() {
        return this.signOutTime;
    }

    @NotNull
    public final OutsideRecord copy(@Nullable List<String> signInImgUrl, @Nullable String signInLocationName, @Nullable Integer signInStatus, @Nullable String signInTime, @Nullable List<String> signOutImgUrl, @Nullable String signOutLocationName, @Nullable Integer signOutStatus, @Nullable String signOutTime) {
        return new OutsideRecord(signInImgUrl, signInLocationName, signInStatus, signInTime, signOutImgUrl, signOutLocationName, signOutStatus, signOutTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutsideRecord)) {
            return false;
        }
        OutsideRecord outsideRecord = (OutsideRecord) other;
        return Intrinsics.areEqual(this.signInImgUrl, outsideRecord.signInImgUrl) && Intrinsics.areEqual(this.signInLocationName, outsideRecord.signInLocationName) && Intrinsics.areEqual(this.signInStatus, outsideRecord.signInStatus) && Intrinsics.areEqual(this.signInTime, outsideRecord.signInTime) && Intrinsics.areEqual(this.signOutImgUrl, outsideRecord.signOutImgUrl) && Intrinsics.areEqual(this.signOutLocationName, outsideRecord.signOutLocationName) && Intrinsics.areEqual(this.signOutStatus, outsideRecord.signOutStatus) && Intrinsics.areEqual(this.signOutTime, outsideRecord.signOutTime);
    }

    @Nullable
    public final List<String> getSignInImgUrl() {
        return this.signInImgUrl;
    }

    @Nullable
    public final String getSignInLocationName() {
        return this.signInLocationName;
    }

    @Nullable
    public final Integer getSignInStatus() {
        return this.signInStatus;
    }

    @Nullable
    public final String getSignInTime() {
        return this.signInTime;
    }

    @Nullable
    public final List<String> getSignOutImgUrl() {
        return this.signOutImgUrl;
    }

    @Nullable
    public final String getSignOutLocationName() {
        return this.signOutLocationName;
    }

    @Nullable
    public final Integer getSignOutStatus() {
        return this.signOutStatus;
    }

    @Nullable
    public final String getSignOutTime() {
        return this.signOutTime;
    }

    public int hashCode() {
        List<String> list = this.signInImgUrl;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.signInLocationName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.signInStatus;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.signInTime;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list2 = this.signOutImgUrl;
        int iHashCode5 = (iHashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str3 = this.signOutLocationName;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.signOutStatus;
        int iHashCode7 = (iHashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.signOutTime;
        return iHashCode7 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "OutsideRecord(signInImgUrl=" + this.signInImgUrl + ", signInLocationName=" + this.signInLocationName + ", signInStatus=" + this.signInStatus + ", signInTime=" + this.signInTime + ", signOutImgUrl=" + this.signOutImgUrl + ", signOutLocationName=" + this.signOutLocationName + ", signOutStatus=" + this.signOutStatus + ", signOutTime=" + this.signOutTime + ')';
    }
}
