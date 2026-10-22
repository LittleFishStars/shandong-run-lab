package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/base/bean/UserThirdInfo;", "", "status", "", "authAgreementCode", "", "thirdUserNo", "(ILjava/lang/String;Ljava/lang/String;)V", "getAuthAgreementCode", "()Ljava/lang/String;", "getStatus", "()I", "setStatus", "(I)V", "getThirdUserNo", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UserThirdInfo {

    @NotNull
    private final String authAgreementCode;
    private int status;

    @NotNull
    private final String thirdUserNo;

    public UserThirdInfo() {
        this(0, null, null, 7, null);
    }

    public UserThirdInfo(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "authAgreementCode");
        Intrinsics.checkNotNullParameter(str2, "thirdUserNo");
        this.status = i;
        this.authAgreementCode = str;
        this.thirdUserNo = str2;
    }

    public static /* synthetic */ UserThirdInfo copy$default(UserThirdInfo userThirdInfo, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = userThirdInfo.status;
        }
        if ((i2 & 2) != 0) {
            str = userThirdInfo.authAgreementCode;
        }
        if ((i2 & 4) != 0) {
            str2 = userThirdInfo.thirdUserNo;
        }
        return userThirdInfo.copy(i, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAuthAgreementCode() {
        return this.authAgreementCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getThirdUserNo() {
        return this.thirdUserNo;
    }

    @NotNull
    public final UserThirdInfo copy(int status, @NotNull String authAgreementCode, @NotNull String thirdUserNo) {
        Intrinsics.checkNotNullParameter(authAgreementCode, "authAgreementCode");
        Intrinsics.checkNotNullParameter(thirdUserNo, "thirdUserNo");
        return new UserThirdInfo(status, authAgreementCode, thirdUserNo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserThirdInfo)) {
            return false;
        }
        UserThirdInfo userThirdInfo = (UserThirdInfo) other;
        return this.status == userThirdInfo.status && Intrinsics.areEqual(this.authAgreementCode, userThirdInfo.authAgreementCode) && Intrinsics.areEqual(this.thirdUserNo, userThirdInfo.thirdUserNo);
    }

    @NotNull
    public final String getAuthAgreementCode() {
        return this.authAgreementCode;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getThirdUserNo() {
        return this.thirdUserNo;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.status) * 31) + this.authAgreementCode.hashCode()) * 31) + this.thirdUserNo.hashCode();
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    @NotNull
    public String toString() {
        return "UserThirdInfo(status=" + this.status + ", authAgreementCode=" + this.authAgreementCode + ", thirdUserNo=" + this.thirdUserNo + ')';
    }

    public /* synthetic */ UserThirdInfo(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2);
    }
}
