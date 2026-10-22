package com.huachenjie.channel.bean;

import android.text.TextUtils;
import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\t\u0010\u001b\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/channel/bean/MayKnowFriendBean;", "", "userInfo", "Lcom/netease/nimlib/sdk/uinfo/model/NimUserInfo;", "isApplied", "", "(Lcom/netease/nimlib/sdk/uinfo/model/NimUserInfo;Z)V", "()Z", "setApplied", "(Z)V", JSApiCachePoint.GET_USER_INFO, "()Lcom/netease/nimlib/sdk/uinfo/model/NimUserInfo;", "component1", "component2", OperatePopupWindow.g, "equals", "other", "formatAcademy", "", "formatString", CachedContentIndex.a.e, "formatterAvatarFrameUrl", "formatterGradeName", "hashCode", "", "showAcademyTag", "showGradeNameTag", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MayKnowFriendBean {
    private boolean isApplied;

    @Nullable
    private final NimUserInfo userInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    public MayKnowFriendBean() {
        NimUserInfo nimUserInfo = null;
        this(nimUserInfo, false, 3, nimUserInfo);
    }

    public MayKnowFriendBean(@Nullable NimUserInfo nimUserInfo, boolean z) {
        this.userInfo = nimUserInfo;
        this.isApplied = z;
    }

    public static /* synthetic */ MayKnowFriendBean copy$default(MayKnowFriendBean mayKnowFriendBean, NimUserInfo nimUserInfo, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            nimUserInfo = mayKnowFriendBean.userInfo;
        }
        if ((i & 2) != 0) {
            z = mayKnowFriendBean.isApplied;
        }
        return mayKnowFriendBean.copy(nimUserInfo, z);
    }

    private final String formatString(String key) {
        Object obj;
        Map extensionMap;
        NimUserInfo nimUserInfo = this.userInfo;
        if (nimUserInfo == null || (extensionMap = nimUserInfo.getExtensionMap()) == null || (obj = extensionMap.get(key)) == null) {
            obj = "";
        }
        return obj instanceof String ? (String) obj : "";
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final NimUserInfo getUserInfo() {
        return this.userInfo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsApplied() {
        return this.isApplied;
    }

    @NotNull
    public final MayKnowFriendBean copy(@Nullable NimUserInfo userInfo, boolean isApplied) {
        return new MayKnowFriendBean(userInfo, isApplied);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MayKnowFriendBean)) {
            return false;
        }
        MayKnowFriendBean mayKnowFriendBean = (MayKnowFriendBean) other;
        return Intrinsics.areEqual(this.userInfo, mayKnowFriendBean.userInfo) && this.isApplied == mayKnowFriendBean.isApplied;
    }

    @NotNull
    public final String formatAcademy() {
        return formatString("departmentName");
    }

    @NotNull
    public final String formatterAvatarFrameUrl() {
        return formatString("avatarFrameImgUrl");
    }

    @NotNull
    public final String formatterGradeName() {
        return formatString("gradeName");
    }

    @Nullable
    public final NimUserInfo getUserInfo() {
        return this.userInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        NimUserInfo nimUserInfo = this.userInfo;
        int iHashCode = (nimUserInfo == null ? 0 : nimUserInfo.hashCode()) * 31;
        boolean z = this.isApplied;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isApplied() {
        return this.isApplied;
    }

    public final void setApplied(boolean z) {
        this.isApplied = z;
    }

    public final boolean showAcademyTag() {
        return !TextUtils.isEmpty(formatAcademy());
    }

    public final boolean showGradeNameTag() {
        return !TextUtils.isEmpty(formatterGradeName());
    }

    @NotNull
    public String toString() {
        return "MayKnowFriendBean(userInfo=" + this.userInfo + ", isApplied=" + this.isApplied + ')';
    }

    public /* synthetic */ MayKnowFriendBean(NimUserInfo nimUserInfo, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : nimUserInfo, (i & 2) != 0 ? false : z);
    }
}
