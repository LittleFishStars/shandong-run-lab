package com.huachenjie.works.bean.publish;

import com.alipay.sdk.m.c0.d;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/works/bean/publish/PubWorkTopicBean;", "", "title", "", "popularityValue", yj7.b.b, "isNewTopic", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "setNewTopic", "(Z)V", "getPopularityValue", "()Ljava/lang/String;", "getSubjectNo", "setSubjectNo", "(Ljava/lang/String;)V", "getTitle", d.p, "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PubWorkTopicBean {
    private boolean isNewTopic;

    @NotNull
    private final String popularityValue;

    @NotNull
    private String subjectNo;

    @NotNull
    private String title;

    public PubWorkTopicBean() {
        this(null, null, null, false, 15, null);
    }

    public PubWorkTopicBean(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "popularityValue");
        Intrinsics.checkNotNullParameter(str3, yj7.b.b);
        this.title = str;
        this.popularityValue = str2;
        this.subjectNo = str3;
        this.isNewTopic = z;
    }

    public static /* synthetic */ PubWorkTopicBean copy$default(PubWorkTopicBean pubWorkTopicBean, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pubWorkTopicBean.title;
        }
        if ((i & 2) != 0) {
            str2 = pubWorkTopicBean.popularityValue;
        }
        if ((i & 4) != 0) {
            str3 = pubWorkTopicBean.subjectNo;
        }
        if ((i & 8) != 0) {
            z = pubWorkTopicBean.isNewTopic;
        }
        return pubWorkTopicBean.copy(str, str2, str3, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPopularityValue() {
        return this.popularityValue;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsNewTopic() {
        return this.isNewTopic;
    }

    @NotNull
    public final PubWorkTopicBean copy(@NotNull String title, @NotNull String popularityValue, @NotNull String subjectNo, boolean isNewTopic) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(popularityValue, "popularityValue");
        Intrinsics.checkNotNullParameter(subjectNo, yj7.b.b);
        return new PubWorkTopicBean(title, popularityValue, subjectNo, isNewTopic);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PubWorkTopicBean)) {
            return false;
        }
        PubWorkTopicBean pubWorkTopicBean = (PubWorkTopicBean) other;
        return Intrinsics.areEqual(this.title, pubWorkTopicBean.title) && Intrinsics.areEqual(this.popularityValue, pubWorkTopicBean.popularityValue) && Intrinsics.areEqual(this.subjectNo, pubWorkTopicBean.subjectNo) && this.isNewTopic == pubWorkTopicBean.isNewTopic;
    }

    @NotNull
    public final String getPopularityValue() {
        return this.popularityValue;
    }

    @NotNull
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((((this.title.hashCode() * 31) + this.popularityValue.hashCode()) * 31) + this.subjectNo.hashCode()) * 31;
        boolean z = this.isNewTopic;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isNewTopic() {
        return this.isNewTopic;
    }

    public final void setNewTopic(boolean z) {
        this.isNewTopic = z;
    }

    public final void setSubjectNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subjectNo = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "PubWorkTopicBean(title=" + this.title + ", popularityValue=" + this.popularityValue + ", subjectNo=" + this.subjectNo + ", isNewTopic=" + this.isNewTopic + ')';
    }

    public /* synthetic */ PubWorkTopicBean(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? false : z);
    }
}
