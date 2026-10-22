package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.MayKnowFriendBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemAddFriendBindingImpl extends ChannelItemAddFriendBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33217a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7898a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7899a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7900a;

    @NonNull
    public final BLTextView b;

    @NonNull
    public final BLTextView c;

    public ChannelItemAddFriendBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f7898a, f33217a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String string;
        String academy;
        String name;
        String avatar;
        String str;
        String str2;
        boolean zShowGradeNameTag;
        boolean z;
        boolean z2;
        NimUserInfo userInfo;
        boolean zIsApplied;
        boolean zShowAcademyTag;
        synchronized (this) {
            j = this.f7899a;
            this.f7899a = 0L;
        }
        MayKnowFriendBean mayKnowFriendBean = ((ChannelItemAddFriendBinding) this).f7896a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (mayKnowFriendBean != null) {
                academy = mayKnowFriendBean.formatAcademy();
                zIsApplied = mayKnowFriendBean.isApplied();
                userInfo = mayKnowFriendBean.getUserInfo();
                str = mayKnowFriendBean.formatterGradeName();
                str2 = mayKnowFriendBean.formatterAvatarFrameUrl();
                zShowAcademyTag = mayKnowFriendBean.showAcademyTag();
                zShowGradeNameTag = mayKnowFriendBean.showGradeNameTag();
            } else {
                academy = null;
                userInfo = null;
                str = null;
                str2 = null;
                zShowGradeNameTag = false;
                zIsApplied = false;
                zShowAcademyTag = false;
            }
            if (j2 != 0) {
                j |= zIsApplied ? 8L : 4L;
            }
            z = !zIsApplied;
            string = zIsApplied ? ((ChannelItemAddFriendBinding) this).f7897a.getResources().getString(R.string.channel_add_friend_sent) : ((ChannelItemAddFriendBinding) this).f7897a.getResources().getString(R.string.channel_add_friend_add);
            if (userInfo != null) {
                name = userInfo.getName();
                avatar = userInfo.getAvatar();
            } else {
                name = null;
                avatar = null;
            }
            z2 = zShowAcademyTag;
        } else {
            string = null;
            academy = null;
            name = null;
            avatar = null;
            str = null;
            str2 = null;
            zShowGradeNameTag = false;
            z = false;
            z2 = false;
        }
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(((ChannelItemAddFriendBinding) this).f7897a, string);
            CommonBindingAdapter.e0(((ChannelItemAddFriendBinding) this).f7897a, z);
            aw9.d(((ChannelItemAddFriendBinding) this).f7895a, avatar, false, null);
            aw9.c(((ChannelItemAddFriendBinding) this).f7895a, str2, null);
            CommonBindingAdapter.l0(this.b, zShowGradeNameTag);
            TextViewBindingAdapter.setText(this.b, str);
            CommonBindingAdapter.l0(this.c, z2);
            TextViewBindingAdapter.setText(this.c, academy);
            TextViewBindingAdapter.setText(((ChannelItemAddFriendBinding) this).f33216a, name);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7899a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7899a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemAddFriendBinding
    public void k(@Nullable MayKnowFriendBean mayKnowFriendBean) {
        ((ChannelItemAddFriendBinding) this).f7896a = mayKnowFriendBean;
        synchronized (this) {
            this.f7899a |= 1;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.g != i) {
            return false;
        }
        k((MayKnowFriendBean) obj);
        return true;
    }

    public ChannelItemAddFriendBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLTextView) objArr[5], (AvatarView) objArr[1], (TextView) objArr[2]);
        this.f7899a = -1L;
        ((ChannelItemAddFriendBinding) this).f7897a.setTag(null);
        ((ChannelItemAddFriendBinding) this).f7895a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7900a = linearLayout;
        linearLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.b = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[4];
        this.c = bLTextView2;
        bLTextView2.setTag(null);
        ((ChannelItemAddFriendBinding) this).f33216a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
