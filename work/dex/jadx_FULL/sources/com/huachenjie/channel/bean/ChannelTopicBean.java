package com.huachenjie.channel.bean;

import android.text.TextUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.channel.R;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0018\u001a\u00020\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/channel/bean/ChannelTopicBean;", "", "channelNo", "", yj7.b.SUBJECT_NO, "subjectName", "subjectImg", "popularityValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelNo", "()Ljava/lang/String;", "getPopularityValue", "getSubjectImg", "getSubjectName", "getSubjectNo", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "formatSubjectImg", "hashCode", "", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ChannelTopicBean {

    @NotNull
    private final String channelNo;

    @NotNull
    private final String popularityValue;

    @NotNull
    private final String subjectImg;

    @NotNull
    private final String subjectName;

    @NotNull
    private final String subjectNo;

    public ChannelTopicBean() {
        this(null, null, null, null, null, 31, null);
    }

    public ChannelTopicBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "channelNo");
        Intrinsics.checkNotNullParameter(str2, yj7.b.SUBJECT_NO);
        Intrinsics.checkNotNullParameter(str3, "subjectName");
        Intrinsics.checkNotNullParameter(str4, "subjectImg");
        Intrinsics.checkNotNullParameter(str5, "popularityValue");
        this.channelNo = str;
        this.subjectNo = str2;
        this.subjectName = str3;
        this.subjectImg = str4;
        this.popularityValue = str5;
    }

    public static /* synthetic */ ChannelTopicBean copy$default(ChannelTopicBean channelTopicBean, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelTopicBean.channelNo;
        }
        if ((i & 2) != 0) {
            str2 = channelTopicBean.subjectNo;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = channelTopicBean.subjectName;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = channelTopicBean.subjectImg;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = channelTopicBean.popularityValue;
        }
        return channelTopicBean.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubjectImg() {
        return this.subjectImg;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPopularityValue() {
        return this.popularityValue;
    }

    @NotNull
    public final ChannelTopicBean copy(@NotNull String channelNo, @NotNull String subjectNo, @NotNull String subjectName, @NotNull String subjectImg, @NotNull String popularityValue) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(subjectNo, yj7.b.SUBJECT_NO);
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        Intrinsics.checkNotNullParameter(subjectImg, "subjectImg");
        Intrinsics.checkNotNullParameter(popularityValue, "popularityValue");
        return new ChannelTopicBean(channelNo, subjectNo, subjectName, subjectImg, popularityValue);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelTopicBean)) {
            return false;
        }
        ChannelTopicBean channelTopicBean = (ChannelTopicBean) other;
        return Intrinsics.areEqual(this.channelNo, channelTopicBean.channelNo) && Intrinsics.areEqual(this.subjectNo, channelTopicBean.subjectNo) && Intrinsics.areEqual(this.subjectName, channelTopicBean.subjectName) && Intrinsics.areEqual(this.subjectImg, channelTopicBean.subjectImg) && Intrinsics.areEqual(this.popularityValue, channelTopicBean.popularityValue);
    }

    @NotNull
    public final Object formatSubjectImg() {
        return TextUtils.isEmpty(this.subjectImg) ? Integer.valueOf(R.drawable.channel_bg_topic_image_placeholder) : this.subjectImg;
    }

    @NotNull
    public final String getChannelNo() {
        return this.channelNo;
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

    public int hashCode() {
        return (((((((this.channelNo.hashCode() * 31) + this.subjectNo.hashCode()) * 31) + this.subjectName.hashCode()) * 31) + this.subjectImg.hashCode()) * 31) + this.popularityValue.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChannelTopicBean(channelNo=" + this.channelNo + ", subjectNo=" + this.subjectNo + ", subjectName=" + this.subjectName + ", subjectImg=" + this.subjectImg + ", popularityValue=" + this.popularityValue + ')';
    }

    public /* synthetic */ ChannelTopicBean(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }
}
