package com.huachenjie.channel.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import com.zj.adlib.s72;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÂ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J_\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020&HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020&HÖ\u0001R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u00062"}, d2 = {"Lcom/huachenjie/channel/bean/ClubMessageBean;", "Landroid/os/Parcelable;", "messageCode", "", "messageTitle", "messageContent", "clubName", "imgList", "", "Lcom/huachenjie/base/bean/ImageBean;", "applyTime", "", UserConstants.USER_PARAMS.b, "avatar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLjava/lang/String;Ljava/lang/String;)V", "applyTimeStr", "getApplyTimeStr", "()Ljava/lang/String;", "getAvatar", "getClubName", "firstImageUrl", "getFirstImageUrl", "getImgList", "()Ljava/util/List;", "getMessageCode", "getMessageContent", "getMessageTitle", "getNickName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ClubMessageBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ClubMessageBean> CREATOR = new Creator();
    private final long applyTime;

    @NotNull
    private final String avatar;

    @NotNull
    private final String clubName;

    @NotNull
    private final List<ImageBean> imgList;

    @NotNull
    private final String messageCode;

    @NotNull
    private final String messageContent;

    @NotNull
    private final String messageTitle;

    @NotNull
    private final String nickName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClubMessageBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClubMessageBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(parcel.readParcelable(ClubMessageBean.class.getClassLoader()));
            }
            return new ClubMessageBean(string, string2, string3, string4, arrayList, parcel.readLong(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClubMessageBean[] newArray(int i) {
            return new ClubMessageBean[i];
        }
    }

    public ClubMessageBean() {
        this(null, null, null, null, null, 0L, null, null, 255, null);
    }

    public ClubMessageBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull List<ImageBean> list, long j, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "messageCode");
        Intrinsics.checkNotNullParameter(str2, "messageTitle");
        Intrinsics.checkNotNullParameter(str3, "messageContent");
        Intrinsics.checkNotNullParameter(str4, "clubName");
        Intrinsics.checkNotNullParameter(list, "imgList");
        Intrinsics.checkNotNullParameter(str5, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str6, "avatar");
        this.messageCode = str;
        this.messageTitle = str2;
        this.messageContent = str3;
        this.clubName = str4;
        this.imgList = list;
        this.applyTime = j;
        this.nickName = str5;
        this.avatar = str6;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    private final long getApplyTime() {
        return this.applyTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessageCode() {
        return this.messageCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessageTitle() {
        return this.messageTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessageContent() {
        return this.messageContent;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getClubName() {
        return this.clubName;
    }

    @NotNull
    public final List<ImageBean> component5() {
        return this.imgList;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final ClubMessageBean copy(@NotNull String messageCode, @NotNull String messageTitle, @NotNull String messageContent, @NotNull String clubName, @NotNull List<ImageBean> imgList, long applyTime, @NotNull String nickName, @NotNull String avatar) {
        Intrinsics.checkNotNullParameter(messageCode, "messageCode");
        Intrinsics.checkNotNullParameter(messageTitle, "messageTitle");
        Intrinsics.checkNotNullParameter(messageContent, "messageContent");
        Intrinsics.checkNotNullParameter(clubName, "clubName");
        Intrinsics.checkNotNullParameter(imgList, "imgList");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        return new ClubMessageBean(messageCode, messageTitle, messageContent, clubName, imgList, applyTime, nickName, avatar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClubMessageBean)) {
            return false;
        }
        ClubMessageBean clubMessageBean = (ClubMessageBean) other;
        return Intrinsics.areEqual(this.messageCode, clubMessageBean.messageCode) && Intrinsics.areEqual(this.messageTitle, clubMessageBean.messageTitle) && Intrinsics.areEqual(this.messageContent, clubMessageBean.messageContent) && Intrinsics.areEqual(this.clubName, clubMessageBean.clubName) && Intrinsics.areEqual(this.imgList, clubMessageBean.imgList) && this.applyTime == clubMessageBean.applyTime && Intrinsics.areEqual(this.nickName, clubMessageBean.nickName) && Intrinsics.areEqual(this.avatar, clubMessageBean.avatar);
    }

    @NotNull
    public final String getApplyTimeStr() {
        String strC = s72.c(this.applyTime, "yyyy.MM.dd HH:mm");
        Intrinsics.checkNotNullExpressionValue(strC, "formatDateTimeByFormat(a…Time, \"yyyy.MM.dd HH:mm\")");
        return strC;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getClubName() {
        return this.clubName;
    }

    @NotNull
    public final String getFirstImageUrl() {
        return this.imgList.isEmpty() ^ true ? this.imgList.get(0).getUrl() : "";
    }

    @NotNull
    public final List<ImageBean> getImgList() {
        return this.imgList;
    }

    @NotNull
    public final String getMessageCode() {
        return this.messageCode;
    }

    @NotNull
    public final String getMessageContent() {
        return this.messageContent;
    }

    @NotNull
    public final String getMessageTitle() {
        return this.messageTitle;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    public int hashCode() {
        return (((((((((((((this.messageCode.hashCode() * 31) + this.messageTitle.hashCode()) * 31) + this.messageContent.hashCode()) * 31) + this.clubName.hashCode()) * 31) + this.imgList.hashCode()) * 31) + Long.hashCode(this.applyTime)) * 31) + this.nickName.hashCode()) * 31) + this.avatar.hashCode();
    }

    @NotNull
    public String toString() {
        return "ClubMessageBean(messageCode=" + this.messageCode + ", messageTitle=" + this.messageTitle + ", messageContent=" + this.messageContent + ", clubName=" + this.clubName + ", imgList=" + this.imgList + ", applyTime=" + this.applyTime + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.messageCode);
        parcel.writeString(this.messageTitle);
        parcel.writeString(this.messageContent);
        parcel.writeString(this.clubName);
        List<ImageBean> list = this.imgList;
        parcel.writeInt(list.size());
        Iterator<ImageBean> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable(it.next(), flags);
        }
        parcel.writeLong(this.applyTime);
        parcel.writeString(this.nickName);
        parcel.writeString(this.avatar);
    }

    public /* synthetic */ ClubMessageBean(String str, String str2, String str3, String str4, List list, long j, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? 0L : j, (i & 64) != 0 ? "" : str5, (i & 128) == 0 ? str6 : "");
    }
}
