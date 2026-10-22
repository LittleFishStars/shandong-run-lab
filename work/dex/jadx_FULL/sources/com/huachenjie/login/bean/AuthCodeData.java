package com.huachenjie.login.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/login/bean/AuthCodeData;", "Landroid/os/Parcelable;", "ticket", "", "(Ljava/lang/String;)V", "getTicket", "()Ljava/lang/String;", "component1", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AuthCodeData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AuthCodeData> CREATOR = new Creator();

    @NotNull
    private final String ticket;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AuthCodeData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AuthCodeData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AuthCodeData(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AuthCodeData[] newArray(int i) {
            return new AuthCodeData[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AuthCodeData() {
        String str = null;
        this(str, 1, str);
    }

    public AuthCodeData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "ticket");
        this.ticket = str;
    }

    public static /* synthetic */ AuthCodeData copy$default(AuthCodeData authCodeData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authCodeData.ticket;
        }
        return authCodeData.copy(str);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTicket() {
        return this.ticket;
    }

    @NotNull
    public final AuthCodeData copy(@NotNull String ticket) {
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        return new AuthCodeData(ticket);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AuthCodeData) && Intrinsics.areEqual(this.ticket, ((AuthCodeData) other).ticket);
    }

    @NotNull
    public final String getTicket() {
        return this.ticket;
    }

    public int hashCode() {
        return this.ticket.hashCode();
    }

    @NotNull
    public String toString() {
        return "AuthCodeData(ticket=" + this.ticket + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.ticket);
    }

    public /* synthetic */ AuthCodeData(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }
}
