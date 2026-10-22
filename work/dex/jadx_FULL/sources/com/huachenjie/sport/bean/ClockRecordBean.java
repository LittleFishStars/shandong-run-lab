package com.huachenjie.sport.bean;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003JY\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010¨\u0006/"}, d2 = {"Lcom/huachenjie/sport/bean/ClockRecordBean;", "", RemoteMessageConst.Notification.ICON, "", "text", "", "textColor", "status", "statusColor", "statusBackground", RequestParameters.SUBRESOURCE_LOCATION, "imgUrl", "(ILjava/lang/String;ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getIcon", "()I", "setIcon", "(I)V", "getImgUrl", "()Ljava/lang/String;", "setImgUrl", "(Ljava/lang/String;)V", "getLocation", "setLocation", "getStatus", "setStatus", "getStatusBackground", "setStatusBackground", "getStatusColor", "setStatusColor", "getText", "setText", "getTextColor", "setTextColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ClockRecordBean {
    private int icon;

    @NotNull
    private String imgUrl;

    @NotNull
    private String location;

    @NotNull
    private String status;
    private int statusBackground;
    private int statusColor;

    @NotNull
    private String text;
    private int textColor;

    public ClockRecordBean() {
        this(0, null, 0, null, 0, 0, null, null, 255, null);
    }

    public ClockRecordBean(int i, @NotNull String str, int i2, @NotNull String str2, int i3, int i4, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "status");
        Intrinsics.checkNotNullParameter(str3, RequestParameters.SUBRESOURCE_LOCATION);
        Intrinsics.checkNotNullParameter(str4, "imgUrl");
        this.icon = i;
        this.text = str;
        this.textColor = i2;
        this.status = str2;
        this.statusColor = i3;
        this.statusBackground = i4;
        this.location = str3;
        this.imgUrl = str4;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getStatusColor() {
        return this.statusColor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getStatusBackground() {
        return this.statusBackground;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @NotNull
    public final ClockRecordBean copy(int icon, @NotNull String text, int textColor, @NotNull String status, int statusColor, int statusBackground, @NotNull String location, @NotNull String imgUrl) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(location, RequestParameters.SUBRESOURCE_LOCATION);
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        return new ClockRecordBean(icon, text, textColor, status, statusColor, statusBackground, location, imgUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClockRecordBean)) {
            return false;
        }
        ClockRecordBean clockRecordBean = (ClockRecordBean) other;
        return this.icon == clockRecordBean.icon && Intrinsics.areEqual(this.text, clockRecordBean.text) && this.textColor == clockRecordBean.textColor && Intrinsics.areEqual(this.status, clockRecordBean.status) && this.statusColor == clockRecordBean.statusColor && this.statusBackground == clockRecordBean.statusBackground && Intrinsics.areEqual(this.location, clockRecordBean.location) && Intrinsics.areEqual(this.imgUrl, clockRecordBean.imgUrl);
    }

    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @NotNull
    public final String getLocation() {
        return this.location;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    public final int getStatusBackground() {
        return this.statusBackground;
    }

    public final int getStatusColor() {
        return this.statusColor;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.icon) * 31) + this.text.hashCode()) * 31) + Integer.hashCode(this.textColor)) * 31) + this.status.hashCode()) * 31) + Integer.hashCode(this.statusColor)) * 31) + Integer.hashCode(this.statusBackground)) * 31) + this.location.hashCode()) * 31) + this.imgUrl.hashCode();
    }

    public final void setIcon(int i) {
        this.icon = i;
    }

    public final void setImgUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imgUrl = str;
    }

    public final void setLocation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.location = str;
    }

    public final void setStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final void setStatusBackground(int i) {
        this.statusBackground = i;
    }

    public final void setStatusColor(int i) {
        this.statusColor = i;
    }

    public final void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final void setTextColor(int i) {
        this.textColor = i;
    }

    @NotNull
    public String toString() {
        return "ClockRecordBean(icon=" + this.icon + ", text=" + this.text + ", textColor=" + this.textColor + ", status=" + this.status + ", statusColor=" + this.statusColor + ", statusBackground=" + this.statusBackground + ", location=" + this.location + ", imgUrl=" + this.imgUrl + ')';
    }

    public /* synthetic */ ClockRecordBean(int i, String str, int i2, String str2, int i3, int i4, String str3, String str4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? "" : str, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? "" : str2, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) == 0 ? i4 : 0, (i5 & 64) != 0 ? "" : str3, (i5 & 128) == 0 ? str4 : "");
    }
}
