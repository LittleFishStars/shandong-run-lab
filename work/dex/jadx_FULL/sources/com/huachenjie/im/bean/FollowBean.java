package com.huachenjie.im.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/im/bean/FollowBean;", "", "bisFollow", "", "friendAppUserCode", "", "(ZLjava/lang/String;)V", "getBisFollow", "()Z", "getFriendAppUserCode", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "IM_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FollowBean {
    private final boolean bisFollow;

    @NotNull
    private final String friendAppUserCode;

    /* JADX WARN: Illegal instructions before constructor call */
    public FollowBean() {
        String str = null;
        this(false, str, 3, str);
    }

    public FollowBean(boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "friendAppUserCode");
        this.bisFollow = z;
        this.friendAppUserCode = str;
    }

    public static /* synthetic */ FollowBean copy$default(FollowBean followBean, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = followBean.bisFollow;
        }
        if ((i & 2) != 0) {
            str = followBean.friendAppUserCode;
        }
        return followBean.copy(z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getBisFollow() {
        return this.bisFollow;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFriendAppUserCode() {
        return this.friendAppUserCode;
    }

    @NotNull
    public final FollowBean copy(boolean bisFollow, @NotNull String friendAppUserCode) {
        Intrinsics.checkNotNullParameter(friendAppUserCode, "friendAppUserCode");
        return new FollowBean(bisFollow, friendAppUserCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FollowBean)) {
            return false;
        }
        FollowBean followBean = (FollowBean) other;
        return this.bisFollow == followBean.bisFollow && Intrinsics.areEqual(this.friendAppUserCode, followBean.friendAppUserCode);
    }

    public final boolean getBisFollow() {
        return this.bisFollow;
    }

    @NotNull
    public final String getFriendAppUserCode() {
        return this.friendAppUserCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.bisFollow;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.friendAppUserCode.hashCode();
    }

    @NotNull
    public String toString() {
        return "FollowBean(bisFollow=" + this.bisFollow + ", friendAppUserCode=" + this.friendAppUserCode + ')';
    }

    public /* synthetic */ FollowBean(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str);
    }
}
