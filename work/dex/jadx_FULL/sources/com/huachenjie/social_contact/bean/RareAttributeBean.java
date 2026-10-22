package com.huachenjie.social_contact.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.social_contact.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006-"}, d2 = {"Lcom/huachenjie/social_contact/bean/RareAttributeBean;", "Landroid/os/Parcelable;", "dialogType", "", "unlockImg", "", "unlockType", "unlockName", "unlockSuccessContent", "unlockFailureContent", "unlockConfigCode", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDialogType", "()I", "getUnlockConfigCode", "()Ljava/lang/String;", "getUnlockFailureContent", "getUnlockImg", "getUnlockName", "getUnlockSuccessContent", "getUnlockType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "formatLockStatus", "formatRareDes", "formatRareName", "formatUnlockType", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RareAttributeBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RareAttributeBean> CREATOR = new Creator();
    private final int dialogType;

    @NotNull
    private final String unlockConfigCode;

    @NotNull
    private final String unlockFailureContent;

    @NotNull
    private final String unlockImg;

    @NotNull
    private final String unlockName;

    @NotNull
    private final String unlockSuccessContent;
    private final int unlockType;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RareAttributeBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RareAttributeBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RareAttributeBean(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RareAttributeBean[] newArray(int i) {
            return new RareAttributeBean[i];
        }
    }

    public RareAttributeBean() {
        this(0, null, 0, null, null, null, null, 127, null);
    }

    public RareAttributeBean(int i, @NotNull String str, int i2, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "unlockImg");
        Intrinsics.checkNotNullParameter(str2, "unlockName");
        Intrinsics.checkNotNullParameter(str3, "unlockSuccessContent");
        Intrinsics.checkNotNullParameter(str4, "unlockFailureContent");
        Intrinsics.checkNotNullParameter(str5, "unlockConfigCode");
        this.dialogType = i;
        this.unlockImg = str;
        this.unlockType = i2;
        this.unlockName = str2;
        this.unlockSuccessContent = str3;
        this.unlockFailureContent = str4;
        this.unlockConfigCode = str5;
    }

    public static /* synthetic */ RareAttributeBean copy$default(RareAttributeBean rareAttributeBean, int i, String str, int i2, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = rareAttributeBean.dialogType;
        }
        if ((i3 & 2) != 0) {
            str = rareAttributeBean.unlockImg;
        }
        String str6 = str;
        if ((i3 & 4) != 0) {
            i2 = rareAttributeBean.unlockType;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            str2 = rareAttributeBean.unlockName;
        }
        String str7 = str2;
        if ((i3 & 16) != 0) {
            str3 = rareAttributeBean.unlockSuccessContent;
        }
        String str8 = str3;
        if ((i3 & 32) != 0) {
            str4 = rareAttributeBean.unlockFailureContent;
        }
        String str9 = str4;
        if ((i3 & 64) != 0) {
            str5 = rareAttributeBean.unlockConfigCode;
        }
        return rareAttributeBean.copy(i, str6, i4, str7, str8, str9, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDialogType() {
        return this.dialogType;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUnlockImg() {
        return this.unlockImg;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getUnlockType() {
        return this.unlockType;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUnlockName() {
        return this.unlockName;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUnlockSuccessContent() {
        return this.unlockSuccessContent;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUnlockFailureContent() {
        return this.unlockFailureContent;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUnlockConfigCode() {
        return this.unlockConfigCode;
    }

    @NotNull
    public final RareAttributeBean copy(int dialogType, @NotNull String unlockImg, int unlockType, @NotNull String unlockName, @NotNull String unlockSuccessContent, @NotNull String unlockFailureContent, @NotNull String unlockConfigCode) {
        Intrinsics.checkNotNullParameter(unlockImg, "unlockImg");
        Intrinsics.checkNotNullParameter(unlockName, "unlockName");
        Intrinsics.checkNotNullParameter(unlockSuccessContent, "unlockSuccessContent");
        Intrinsics.checkNotNullParameter(unlockFailureContent, "unlockFailureContent");
        Intrinsics.checkNotNullParameter(unlockConfigCode, "unlockConfigCode");
        return new RareAttributeBean(dialogType, unlockImg, unlockType, unlockName, unlockSuccessContent, unlockFailureContent, unlockConfigCode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RareAttributeBean)) {
            return false;
        }
        RareAttributeBean rareAttributeBean = (RareAttributeBean) other;
        return this.dialogType == rareAttributeBean.dialogType && Intrinsics.areEqual(this.unlockImg, rareAttributeBean.unlockImg) && this.unlockType == rareAttributeBean.unlockType && Intrinsics.areEqual(this.unlockName, rareAttributeBean.unlockName) && Intrinsics.areEqual(this.unlockSuccessContent, rareAttributeBean.unlockSuccessContent) && Intrinsics.areEqual(this.unlockFailureContent, rareAttributeBean.unlockFailureContent) && Intrinsics.areEqual(this.unlockConfigCode, rareAttributeBean.unlockConfigCode);
    }

    public final int formatLockStatus() {
        int i = this.dialogType;
        if (i == 1) {
            return R.mipmap.ic_rare_attribute_unlock;
        }
        if (i != 2) {
            return 0;
        }
        return R.mipmap.ic_rare_attribute_lock;
    }

    @NotNull
    public final String formatRareDes() {
        int i = this.dialogType;
        if (i != 1) {
            return i != 2 ? "" : this.unlockFailureContent;
        }
        return this.unlockSuccessContent;
    }

    @NotNull
    public final String formatRareName() {
        return TextUtils.isEmpty(this.unlockName) ? "" : this.unlockName;
    }

    @NotNull
    public final String formatUnlockType() {
        String str;
        int i = this.dialogType;
        if (i != 1) {
            str = i != 2 ? "" : "已失效";
        } else {
            str = "解锁";
        }
        int i2 = this.unlockType;
        if (i2 == 1) {
            return "装扮" + str;
        }
        if (i2 == 2) {
            return "头像框" + str;
        }
        if (i2 == 3) {
            return "身姿" + str;
        }
        if (i2 != 4) {
            return "";
        }
        return "主页背景" + str;
    }

    public final int getDialogType() {
        return this.dialogType;
    }

    @NotNull
    public final String getUnlockConfigCode() {
        return this.unlockConfigCode;
    }

    @NotNull
    public final String getUnlockFailureContent() {
        return this.unlockFailureContent;
    }

    @NotNull
    public final String getUnlockImg() {
        return this.unlockImg;
    }

    @NotNull
    public final String getUnlockName() {
        return this.unlockName;
    }

    @NotNull
    public final String getUnlockSuccessContent() {
        return this.unlockSuccessContent;
    }

    public final int getUnlockType() {
        return this.unlockType;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.dialogType) * 31) + this.unlockImg.hashCode()) * 31) + Integer.hashCode(this.unlockType)) * 31) + this.unlockName.hashCode()) * 31) + this.unlockSuccessContent.hashCode()) * 31) + this.unlockFailureContent.hashCode()) * 31) + this.unlockConfigCode.hashCode();
    }

    @NotNull
    public String toString() {
        return "RareAttributeBean(dialogType=" + this.dialogType + ", unlockImg=" + this.unlockImg + ", unlockType=" + this.unlockType + ", unlockName=" + this.unlockName + ", unlockSuccessContent=" + this.unlockSuccessContent + ", unlockFailureContent=" + this.unlockFailureContent + ", unlockConfigCode=" + this.unlockConfigCode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.dialogType);
        parcel.writeString(this.unlockImg);
        parcel.writeInt(this.unlockType);
        parcel.writeString(this.unlockName);
        parcel.writeString(this.unlockSuccessContent);
        parcel.writeString(this.unlockFailureContent);
        parcel.writeString(this.unlockConfigCode);
    }

    public /* synthetic */ RareAttributeBean(int i, String str, int i2, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) == 0 ? i2 : 0, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? "" : str4, (i3 & 64) != 0 ? "" : str5);
    }
}
