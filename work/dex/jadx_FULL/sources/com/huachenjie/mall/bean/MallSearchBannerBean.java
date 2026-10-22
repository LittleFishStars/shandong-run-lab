package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/mall/bean/MallSearchBannerBean;", "", "presetNo", "", "presetWord", "sortNum", "", "lastOperateUserName", "lastOperateTime", "createTime", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/String;", "getLastOperateTime", "getLastOperateUserName", "getPresetNo", "getPresetWord", "getSortNum", "()I", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MallSearchBannerBean {

    @NotNull
    private final String createTime;

    @NotNull
    private final String lastOperateTime;

    @NotNull
    private final String lastOperateUserName;

    @NotNull
    private final String presetNo;

    @NotNull
    private final String presetWord;
    private final int sortNum;

    public MallSearchBannerBean() {
        this(null, null, 0, null, null, null, 63, null);
    }

    public MallSearchBannerBean(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "presetNo");
        Intrinsics.checkNotNullParameter(str2, "presetWord");
        Intrinsics.checkNotNullParameter(str3, "lastOperateUserName");
        Intrinsics.checkNotNullParameter(str4, "lastOperateTime");
        Intrinsics.checkNotNullParameter(str5, "createTime");
        this.presetNo = str;
        this.presetWord = str2;
        this.sortNum = i;
        this.lastOperateUserName = str3;
        this.lastOperateTime = str4;
        this.createTime = str5;
    }

    public static /* synthetic */ MallSearchBannerBean copy$default(MallSearchBannerBean mallSearchBannerBean, String str, String str2, int i, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mallSearchBannerBean.presetNo;
        }
        if ((i2 & 2) != 0) {
            str2 = mallSearchBannerBean.presetWord;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            i = mallSearchBannerBean.sortNum;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = mallSearchBannerBean.lastOperateUserName;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = mallSearchBannerBean.lastOperateTime;
        }
        String str8 = str4;
        if ((i2 & 32) != 0) {
            str5 = mallSearchBannerBean.createTime;
        }
        return mallSearchBannerBean.copy(str, str6, i3, str7, str8, str5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPresetNo() {
        return this.presetNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPresetWord() {
        return this.presetWord;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSortNum() {
        return this.sortNum;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLastOperateUserName() {
        return this.lastOperateUserName;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLastOperateTime() {
        return this.lastOperateTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final MallSearchBannerBean copy(@NotNull String presetNo, @NotNull String presetWord, int sortNum, @NotNull String lastOperateUserName, @NotNull String lastOperateTime, @NotNull String createTime) {
        Intrinsics.checkNotNullParameter(presetNo, "presetNo");
        Intrinsics.checkNotNullParameter(presetWord, "presetWord");
        Intrinsics.checkNotNullParameter(lastOperateUserName, "lastOperateUserName");
        Intrinsics.checkNotNullParameter(lastOperateTime, "lastOperateTime");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        return new MallSearchBannerBean(presetNo, presetWord, sortNum, lastOperateUserName, lastOperateTime, createTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MallSearchBannerBean)) {
            return false;
        }
        MallSearchBannerBean mallSearchBannerBean = (MallSearchBannerBean) other;
        return Intrinsics.areEqual(this.presetNo, mallSearchBannerBean.presetNo) && Intrinsics.areEqual(this.presetWord, mallSearchBannerBean.presetWord) && this.sortNum == mallSearchBannerBean.sortNum && Intrinsics.areEqual(this.lastOperateUserName, mallSearchBannerBean.lastOperateUserName) && Intrinsics.areEqual(this.lastOperateTime, mallSearchBannerBean.lastOperateTime) && Intrinsics.areEqual(this.createTime, mallSearchBannerBean.createTime);
    }

    @NotNull
    public final String getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final String getLastOperateTime() {
        return this.lastOperateTime;
    }

    @NotNull
    public final String getLastOperateUserName() {
        return this.lastOperateUserName;
    }

    @NotNull
    public final String getPresetNo() {
        return this.presetNo;
    }

    @NotNull
    public final String getPresetWord() {
        return this.presetWord;
    }

    public final int getSortNum() {
        return this.sortNum;
    }

    public int hashCode() {
        return (((((((((this.presetNo.hashCode() * 31) + this.presetWord.hashCode()) * 31) + Integer.hashCode(this.sortNum)) * 31) + this.lastOperateUserName.hashCode()) * 31) + this.lastOperateTime.hashCode()) * 31) + this.createTime.hashCode();
    }

    @NotNull
    public String toString() {
        return "MallSearchBannerBean(presetNo=" + this.presetNo + ", presetWord=" + this.presetWord + ", sortNum=" + this.sortNum + ", lastOperateUserName=" + this.lastOperateUserName + ", lastOperateTime=" + this.lastOperateTime + ", createTime=" + this.createTime + ')';
    }

    public /* synthetic */ MallSearchBannerBean(String str, String str2, int i, String str3, String str4, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5);
    }
}
