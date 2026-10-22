package com.huachenjie.channel.bean;

import android.text.TextUtils;
import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.im.bean.FriendUserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J)\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/huachenjie/channel/bean/FriendListBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "userInfo", "Lcom/huachenjie/im/bean/FriendUserInfo;", "firstLetter", "", "groupName", "(Lcom/huachenjie/im/bean/FriendUserInfo;Ljava/lang/String;Ljava/lang/String;)V", "getFirstLetter", "()Ljava/lang/String;", "setFirstLetter", "(Ljava/lang/String;)V", "getGroupName", "setGroupName", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", JSApiCachePoint.GET_USER_INFO, "()Lcom/huachenjie/im/bean/FriendUserInfo;", "setUserInfo", "(Lcom/huachenjie/im/bean/FriendUserInfo;)V", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "toString", "Companion", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FriendListBean implements MultiItemEntity {
    public static final int ITEM_TYPE_GROUP = 1;
    public static final int ITEM_TYPE_USER = 2;

    @NotNull
    private String firstLetter;

    @NotNull
    private String groupName;

    @Nullable
    private FriendUserInfo userInfo;

    public FriendListBean() {
        this(null, null, null, 7, null);
    }

    public FriendListBean(@Nullable FriendUserInfo friendUserInfo, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "firstLetter");
        Intrinsics.checkNotNullParameter(str2, "groupName");
        this.userInfo = friendUserInfo;
        this.firstLetter = str;
        this.groupName = str2;
    }

    public static /* synthetic */ FriendListBean copy$default(FriendListBean friendListBean, FriendUserInfo friendUserInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            friendUserInfo = friendListBean.userInfo;
        }
        if ((i & 2) != 0) {
            str = friendListBean.firstLetter;
        }
        if ((i & 4) != 0) {
            str2 = friendListBean.groupName;
        }
        return friendListBean.copy(friendUserInfo, str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FriendUserInfo getUserInfo() {
        return this.userInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFirstLetter() {
        return this.firstLetter;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    @NotNull
    public final FriendListBean copy(@Nullable FriendUserInfo userInfo, @NotNull String firstLetter, @NotNull String groupName) {
        Intrinsics.checkNotNullParameter(firstLetter, "firstLetter");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        return new FriendListBean(userInfo, firstLetter, groupName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendListBean)) {
            return false;
        }
        FriendListBean friendListBean = (FriendListBean) other;
        return Intrinsics.areEqual(this.userInfo, friendListBean.userInfo) && Intrinsics.areEqual(this.firstLetter, friendListBean.firstLetter) && Intrinsics.areEqual(this.groupName, friendListBean.groupName);
    }

    @NotNull
    public final String getFirstLetter() {
        return this.firstLetter;
    }

    @NotNull
    public final String getGroupName() {
        return this.groupName;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return TextUtils.isEmpty(this.groupName) ? 2 : 1;
    }

    @Nullable
    public final FriendUserInfo getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        FriendUserInfo friendUserInfo = this.userInfo;
        return ((((friendUserInfo == null ? 0 : friendUserInfo.hashCode()) * 31) + this.firstLetter.hashCode()) * 31) + this.groupName.hashCode();
    }

    public final void setFirstLetter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstLetter = str;
    }

    public final void setGroupName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupName = str;
    }

    public final void setUserInfo(@Nullable FriendUserInfo friendUserInfo) {
        this.userInfo = friendUserInfo;
    }

    @NotNull
    public String toString() {
        return "FriendListBean(userInfo=" + this.userInfo + ", firstLetter=" + this.firstLetter + ", groupName=" + this.groupName + ')';
    }

    public /* synthetic */ FriendListBean(FriendUserInfo friendUserInfo, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : friendUserInfo, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }
}
