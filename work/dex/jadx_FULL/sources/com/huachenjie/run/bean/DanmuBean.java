package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/run/bean/DanmuBean;", "", "content", "", UserConstants.USER_PARAMS.b, "self", "", "isBrand", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getContent", "()Ljava/lang/String;", "()Z", "getNickName", "getSelf", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DanmuBean {

    @NotNull
    private final String content;
    private final boolean isBrand;

    @NotNull
    private final String nickName;
    private final boolean self;

    public DanmuBean() {
        this(null, null, false, false, 15, null);
    }

    public DanmuBean(@NotNull String str, @NotNull String str2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, UserConstants.USER_PARAMS.b);
        this.content = str;
        this.nickName = str2;
        this.self = z;
        this.isBrand = z2;
    }

    public static /* synthetic */ DanmuBean copy$default(DanmuBean danmuBean, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = danmuBean.content;
        }
        if ((i & 2) != 0) {
            str2 = danmuBean.nickName;
        }
        if ((i & 4) != 0) {
            z = danmuBean.self;
        }
        if ((i & 8) != 0) {
            z2 = danmuBean.isBrand;
        }
        return danmuBean.copy(str, str2, z, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSelf() {
        return this.self;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsBrand() {
        return this.isBrand;
    }

    @NotNull
    public final DanmuBean copy(@NotNull String content, @NotNull String nickName, boolean self, boolean isBrand) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        return new DanmuBean(content, nickName, self, isBrand);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DanmuBean)) {
            return false;
        }
        DanmuBean danmuBean = (DanmuBean) other;
        return Intrinsics.areEqual(this.content, danmuBean.content) && Intrinsics.areEqual(this.nickName, danmuBean.nickName) && this.self == danmuBean.self && this.isBrand == danmuBean.isBrand;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    public final boolean getSelf() {
        return this.self;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((this.content.hashCode() * 31) + this.nickName.hashCode()) * 31;
        boolean z = this.self;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.isBrand;
        return i + (z2 ? 1 : z2);
    }

    public final boolean isBrand() {
        return this.isBrand;
    }

    @NotNull
    public String toString() {
        return "DanmuBean(content=" + this.content + ", nickName=" + this.nickName + ", self=" + this.self + ", isBrand=" + this.isBrand + ')';
    }

    public /* synthetic */ DanmuBean(String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }
}
