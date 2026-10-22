package com.huachenjie.social_contact.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.huachenjie.base.bean.GiftBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\u0010\u0013J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\u0087\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001J\u0013\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\t\u0010<\u001a\u00020\u0006HÖ\u0001J\u0019\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010$R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017¨\u0006B"}, d2 = {"Lcom/huachenjie/social_contact/bean/NoticeBean;", "Landroid/os/Parcelable;", UserTrackConstant.JUMP_TYPE, "", "noticeType", "noticeTitle", "", "noticeTime", "subContent", "noticeUrl", "readStatus", "messageType", "receiveType", "", "noticeCode", "giftName", "giftList", "", "Lcom/huachenjie/base/bean/GiftBean;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getGiftList", "()Ljava/util/List;", "getGiftName", "()Ljava/lang/String;", "setGiftName", "(Ljava/lang/String;)V", "getJumpType", "()I", "getMessageType", "getNoticeCode", "getNoticeTime", "getNoticeTitle", "getNoticeType", "getNoticeUrl", "getReadStatus", "setReadStatus", "(I)V", "getReceiveType", "()Z", "setReceiveType", "(Z)V", "getSubContent", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NoticeBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<NoticeBean> CREATOR = new Creator();

    @NotNull
    private final List<GiftBean> giftList;

    @NotNull
    private String giftName;
    private final int jumpType;
    private final int messageType;

    @NotNull
    private final String noticeCode;

    @NotNull
    private final String noticeTime;

    @NotNull
    private final String noticeTitle;
    private final int noticeType;

    @NotNull
    private final String noticeUrl;
    private int readStatus;
    private boolean receiveType;

    @NotNull
    private final String subContent;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NoticeBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NoticeBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            boolean z = parcel.readInt() != 0;
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            int i5 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i5);
            for (int i6 = 0; i6 != i5; i6++) {
                arrayList.add(parcel.readParcelable(NoticeBean.class.getClassLoader()));
            }
            return new NoticeBean(i, i2, string, string2, string3, string4, i3, i4, z, string5, string6, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NoticeBean[] newArray(int i) {
            return new NoticeBean[i];
        }
    }

    public NoticeBean() {
        this(0, 0, null, null, null, null, 0, 0, false, null, null, null, 4095, null);
    }

    public NoticeBean(int i, int i2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i3, int i4, boolean z, @NotNull String str5, @NotNull String str6, @NotNull List<GiftBean> list) {
        Intrinsics.checkNotNullParameter(str, "noticeTitle");
        Intrinsics.checkNotNullParameter(str2, "noticeTime");
        Intrinsics.checkNotNullParameter(str3, "subContent");
        Intrinsics.checkNotNullParameter(str4, "noticeUrl");
        Intrinsics.checkNotNullParameter(str5, "noticeCode");
        Intrinsics.checkNotNullParameter(str6, "giftName");
        Intrinsics.checkNotNullParameter(list, "giftList");
        this.jumpType = i;
        this.noticeType = i2;
        this.noticeTitle = str;
        this.noticeTime = str2;
        this.subContent = str3;
        this.noticeUrl = str4;
        this.readStatus = i3;
        this.messageType = i4;
        this.receiveType = z;
        this.noticeCode = str5;
        this.giftName = str6;
        this.giftList = list;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getNoticeCode() {
        return this.noticeCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getGiftName() {
        return this.giftName;
    }

    @NotNull
    public final List<GiftBean> component12() {
        return this.giftList;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getNoticeType() {
        return this.noticeType;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNoticeTitle() {
        return this.noticeTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNoticeTime() {
        return this.noticeTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSubContent() {
        return this.subContent;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getNoticeUrl() {
        return this.noticeUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getReadStatus() {
        return this.readStatus;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getMessageType() {
        return this.messageType;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getReceiveType() {
        return this.receiveType;
    }

    @NotNull
    public final NoticeBean copy(int jumpType, int noticeType, @NotNull String noticeTitle, @NotNull String noticeTime, @NotNull String subContent, @NotNull String noticeUrl, int readStatus, int messageType, boolean receiveType, @NotNull String noticeCode, @NotNull String giftName, @NotNull List<GiftBean> giftList) {
        Intrinsics.checkNotNullParameter(noticeTitle, "noticeTitle");
        Intrinsics.checkNotNullParameter(noticeTime, "noticeTime");
        Intrinsics.checkNotNullParameter(subContent, "subContent");
        Intrinsics.checkNotNullParameter(noticeUrl, "noticeUrl");
        Intrinsics.checkNotNullParameter(noticeCode, "noticeCode");
        Intrinsics.checkNotNullParameter(giftName, "giftName");
        Intrinsics.checkNotNullParameter(giftList, "giftList");
        return new NoticeBean(jumpType, noticeType, noticeTitle, noticeTime, subContent, noticeUrl, readStatus, messageType, receiveType, noticeCode, giftName, giftList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoticeBean)) {
            return false;
        }
        NoticeBean noticeBean = (NoticeBean) other;
        return this.jumpType == noticeBean.jumpType && this.noticeType == noticeBean.noticeType && Intrinsics.areEqual(this.noticeTitle, noticeBean.noticeTitle) && Intrinsics.areEqual(this.noticeTime, noticeBean.noticeTime) && Intrinsics.areEqual(this.subContent, noticeBean.subContent) && Intrinsics.areEqual(this.noticeUrl, noticeBean.noticeUrl) && this.readStatus == noticeBean.readStatus && this.messageType == noticeBean.messageType && this.receiveType == noticeBean.receiveType && Intrinsics.areEqual(this.noticeCode, noticeBean.noticeCode) && Intrinsics.areEqual(this.giftName, noticeBean.giftName) && Intrinsics.areEqual(this.giftList, noticeBean.giftList);
    }

    @NotNull
    public final List<GiftBean> getGiftList() {
        return this.giftList;
    }

    @NotNull
    public final String getGiftName() {
        return this.giftName;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    @NotNull
    public final String getNoticeCode() {
        return this.noticeCode;
    }

    @NotNull
    public final String getNoticeTime() {
        return this.noticeTime;
    }

    @NotNull
    public final String getNoticeTitle() {
        return this.noticeTitle;
    }

    public final int getNoticeType() {
        return this.noticeType;
    }

    @NotNull
    public final String getNoticeUrl() {
        return this.noticeUrl;
    }

    public final int getReadStatus() {
        return this.readStatus;
    }

    public final boolean getReceiveType() {
        return this.receiveType;
    }

    @NotNull
    public final String getSubContent() {
        return this.subContent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    public int hashCode() {
        int iHashCode = ((((((((((((((Integer.hashCode(this.jumpType) * 31) + Integer.hashCode(this.noticeType)) * 31) + this.noticeTitle.hashCode()) * 31) + this.noticeTime.hashCode()) * 31) + this.subContent.hashCode()) * 31) + this.noticeUrl.hashCode()) * 31) + Integer.hashCode(this.readStatus)) * 31) + Integer.hashCode(this.messageType)) * 31;
        boolean z = this.receiveType;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((iHashCode + r1) * 31) + this.noticeCode.hashCode()) * 31) + this.giftName.hashCode()) * 31) + this.giftList.hashCode();
    }

    public final void setGiftName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.giftName = str;
    }

    public final void setReadStatus(int i) {
        this.readStatus = i;
    }

    public final void setReceiveType(boolean z) {
        this.receiveType = z;
    }

    @NotNull
    public String toString() {
        return "NoticeBean(jumpType=" + this.jumpType + ", noticeType=" + this.noticeType + ", noticeTitle=" + this.noticeTitle + ", noticeTime=" + this.noticeTime + ", subContent=" + this.subContent + ", noticeUrl=" + this.noticeUrl + ", readStatus=" + this.readStatus + ", messageType=" + this.messageType + ", receiveType=" + this.receiveType + ", noticeCode=" + this.noticeCode + ", giftName=" + this.giftName + ", giftList=" + this.giftList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.jumpType);
        parcel.writeInt(this.noticeType);
        parcel.writeString(this.noticeTitle);
        parcel.writeString(this.noticeTime);
        parcel.writeString(this.subContent);
        parcel.writeString(this.noticeUrl);
        parcel.writeInt(this.readStatus);
        parcel.writeInt(this.messageType);
        parcel.writeInt(this.receiveType ? 1 : 0);
        parcel.writeString(this.noticeCode);
        parcel.writeString(this.giftName);
        List<GiftBean> list = this.giftList;
        parcel.writeInt(list.size());
        Iterator<GiftBean> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable(it.next(), flags);
        }
    }

    public /* synthetic */ NoticeBean(int i, int i2, String str, String str2, String str3, String str4, int i3, int i4, boolean z, String str5, String str6, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? "" : str, (i5 & 8) != 0 ? "" : str2, (i5 & 16) != 0 ? "" : str3, (i5 & 32) != 0 ? "" : str4, (i5 & 64) != 0 ? 0 : i3, (i5 & 128) != 0 ? 0 : i4, (i5 & 256) == 0 ? z : false, (i5 & 512) != 0 ? "" : str5, (i5 & 1024) == 0 ? str6 : "", (i5 & 2048) != 0 ? new ArrayList() : list);
    }
}
