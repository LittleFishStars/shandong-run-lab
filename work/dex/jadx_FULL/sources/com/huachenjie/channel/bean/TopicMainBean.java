package com.huachenjie.channel.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.yj7;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003Jk\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0007HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00063"}, d2 = {"Lcom/huachenjie/channel/bean/TopicMainBean;", "", yj7.b.b, "", "subjectName", "channelName", "worksCount", "", "popularityValue", "subjectImg", "joinFlag", "", "avatarList", "", "subjectUserValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/lang/String;)V", "avatar1", "getAvatar1", "()Ljava/lang/String;", "avatar2", "getAvatar2", "avatar3", "getAvatar3", "getAvatarList", "()Ljava/util/List;", "getChannelName", "getJoinFlag", "()Z", "setJoinFlag", "(Z)V", "getPopularityValue", "getSubjectImg", "getSubjectName", "getSubjectNo", "getSubjectUserValue", "getWorksCount", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TopicMainBean {

    @NotNull
    private final List<String> avatarList;

    @Nullable
    private final String channelName;
    private boolean joinFlag;

    @NotNull
    private final String popularityValue;

    @NotNull
    private final String subjectImg;

    @NotNull
    private final String subjectName;

    @NotNull
    private final String subjectNo;

    @NotNull
    private final String subjectUserValue;
    private final int worksCount;

    public TopicMainBean() {
        this(null, null, null, 0, null, null, false, null, null, 511, null);
    }

    public TopicMainBean(@NotNull String str, @NotNull String str2, @Nullable String str3, int i, @NotNull String str4, @NotNull String str5, boolean z, @NotNull List<String> list, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, yj7.b.b);
        Intrinsics.checkNotNullParameter(str2, "subjectName");
        Intrinsics.checkNotNullParameter(str4, "popularityValue");
        Intrinsics.checkNotNullParameter(str5, "subjectImg");
        Intrinsics.checkNotNullParameter(list, "avatarList");
        Intrinsics.checkNotNullParameter(str6, "subjectUserValue");
        this.subjectNo = str;
        this.subjectName = str2;
        this.channelName = str3;
        this.worksCount = i;
        this.popularityValue = str4;
        this.subjectImg = str5;
        this.joinFlag = z;
        this.avatarList = list;
        this.subjectUserValue = str6;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getWorksCount() {
        return this.worksCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPopularityValue() {
        return this.popularityValue;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSubjectImg() {
        return this.subjectImg;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getJoinFlag() {
        return this.joinFlag;
    }

    @NotNull
    public final List<String> component8() {
        return this.avatarList;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSubjectUserValue() {
        return this.subjectUserValue;
    }

    @NotNull
    public final TopicMainBean copy(@NotNull String subjectNo, @NotNull String subjectName, @Nullable String channelName, int worksCount, @NotNull String popularityValue, @NotNull String subjectImg, boolean joinFlag, @NotNull List<String> avatarList, @NotNull String subjectUserValue) {
        Intrinsics.checkNotNullParameter(subjectNo, yj7.b.b);
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        Intrinsics.checkNotNullParameter(popularityValue, "popularityValue");
        Intrinsics.checkNotNullParameter(subjectImg, "subjectImg");
        Intrinsics.checkNotNullParameter(avatarList, "avatarList");
        Intrinsics.checkNotNullParameter(subjectUserValue, "subjectUserValue");
        return new TopicMainBean(subjectNo, subjectName, channelName, worksCount, popularityValue, subjectImg, joinFlag, avatarList, subjectUserValue);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TopicMainBean)) {
            return false;
        }
        TopicMainBean topicMainBean = (TopicMainBean) other;
        return Intrinsics.areEqual(this.subjectNo, topicMainBean.subjectNo) && Intrinsics.areEqual(this.subjectName, topicMainBean.subjectName) && Intrinsics.areEqual(this.channelName, topicMainBean.channelName) && this.worksCount == topicMainBean.worksCount && Intrinsics.areEqual(this.popularityValue, topicMainBean.popularityValue) && Intrinsics.areEqual(this.subjectImg, topicMainBean.subjectImg) && this.joinFlag == topicMainBean.joinFlag && Intrinsics.areEqual(this.avatarList, topicMainBean.avatarList) && Intrinsics.areEqual(this.subjectUserValue, topicMainBean.subjectUserValue);
    }

    @Nullable
    public final String getAvatar1() {
        return (String) CollectionsKt.getOrNull(this.avatarList, 0);
    }

    @Nullable
    public final String getAvatar2() {
        return (String) CollectionsKt.getOrNull(this.avatarList, 1);
    }

    @Nullable
    public final String getAvatar3() {
        return (String) CollectionsKt.getOrNull(this.avatarList, 2);
    }

    @NotNull
    public final List<String> getAvatarList() {
        return this.avatarList;
    }

    @Nullable
    public final String getChannelName() {
        return this.channelName;
    }

    public final boolean getJoinFlag() {
        return this.joinFlag;
    }

    @NotNull
    public final String getPopularityValue() {
        return this.popularityValue;
    }

    @NotNull
    public final String getSubjectImg() {
        return this.subjectImg;
    }

    @NotNull
    public final String getSubjectName() {
        return this.subjectName;
    }

    @NotNull
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    @NotNull
    public final String getSubjectUserValue() {
        return this.subjectUserValue;
    }

    public final int getWorksCount() {
        return this.worksCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    public int hashCode() {
        int iHashCode = ((this.subjectNo.hashCode() * 31) + this.subjectName.hashCode()) * 31;
        String str = this.channelName;
        int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.worksCount)) * 31) + this.popularityValue.hashCode()) * 31) + this.subjectImg.hashCode()) * 31;
        boolean z = this.joinFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode2 + r1) * 31) + this.avatarList.hashCode()) * 31) + this.subjectUserValue.hashCode();
    }

    public final void setJoinFlag(boolean z) {
        this.joinFlag = z;
    }

    @NotNull
    public String toString() {
        return "TopicMainBean(subjectNo=" + this.subjectNo + ", subjectName=" + this.subjectName + ", channelName=" + this.channelName + ", worksCount=" + this.worksCount + ", popularityValue=" + this.popularityValue + ", subjectImg=" + this.subjectImg + ", joinFlag=" + this.joinFlag + ", avatarList=" + this.avatarList + ", subjectUserValue=" + this.subjectUserValue + ')';
    }

    public /* synthetic */ TopicMainBean(String str, String str2, String str3, int i, String str4, String str5, boolean z, List list, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5, (i2 & 64) == 0 ? z : false, (i2 & 128) != 0 ? new ArrayList() : list, (i2 & 256) == 0 ? str6 : "");
    }
}
