package com.huachenjie.channel.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/channel/bean/JoinChannelCategoryBean;", "", "categoryName", "", yj7.g.f20870c, "(Ljava/lang/String;Ljava/lang/String;)V", "getCategoryName", "()Ljava/lang/String;", "getCategoryNo", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class JoinChannelCategoryBean {

    @NotNull
    private final String categoryName;

    @NotNull
    private final String categoryNo;

    /* JADX WARN: Illegal instructions before constructor call */
    public JoinChannelCategoryBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public JoinChannelCategoryBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "categoryName");
        Intrinsics.checkNotNullParameter(str2, yj7.g.f20870c);
        this.categoryName = str;
        this.categoryNo = str2;
    }

    public static /* synthetic */ JoinChannelCategoryBean copy$default(JoinChannelCategoryBean joinChannelCategoryBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = joinChannelCategoryBean.categoryName;
        }
        if ((i & 2) != 0) {
            str2 = joinChannelCategoryBean.categoryNo;
        }
        return joinChannelCategoryBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCategoryNo() {
        return this.categoryNo;
    }

    @NotNull
    public final JoinChannelCategoryBean copy(@NotNull String categoryName, @NotNull String categoryNo) {
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(categoryNo, yj7.g.f20870c);
        return new JoinChannelCategoryBean(categoryName, categoryNo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JoinChannelCategoryBean)) {
            return false;
        }
        JoinChannelCategoryBean joinChannelCategoryBean = (JoinChannelCategoryBean) other;
        return Intrinsics.areEqual(this.categoryName, joinChannelCategoryBean.categoryName) && Intrinsics.areEqual(this.categoryNo, joinChannelCategoryBean.categoryNo);
    }

    @NotNull
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    public final String getCategoryNo() {
        return this.categoryNo;
    }

    public int hashCode() {
        return (this.categoryName.hashCode() * 31) + this.categoryNo.hashCode();
    }

    @NotNull
    public String toString() {
        return "JoinChannelCategoryBean(categoryName=" + this.categoryName + ", categoryNo=" + this.categoryNo + ')';
    }

    public /* synthetic */ JoinChannelCategoryBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
