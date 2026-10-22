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
import com.huachenjie.channel.bean.ChannelMemberBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemOrganizeMemberChannelBindingImpl extends ChannelItemOrganizeMemberChannelBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33305a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8148a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8151a;

    @NonNull
    public final TextView b;

    public ChannelItemOrganizeMemberChannelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f8148a, f33305a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean setAsPresident;
        String avatar;
        String presidentStr;
        String avatarFrameImgUrl;
        String str;
        String nickName;
        String slogan;
        synchronized (this) {
            j = this.f8149a;
            this.f8149a = 0L;
        }
        ChannelMemberBean channelMemberBean = ((ChannelItemOrganizeMemberChannelBinding) this).f8146a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (channelMemberBean != null) {
                setAsPresident = channelMemberBean.getSetAsPresident();
                presidentStr = channelMemberBean.getPresidentStr();
                avatarFrameImgUrl = channelMemberBean.getAvatarFrameImgUrl();
                slogan = channelMemberBean.getSlogan();
                nickName = channelMemberBean.getNickName();
                avatar = channelMemberBean.getAvatar();
            } else {
                setAsPresident = false;
                avatar = null;
                presidentStr = null;
                avatarFrameImgUrl = null;
                slogan = null;
                nickName = null;
            }
            str = String.format("%s", slogan);
        } else {
            setAsPresident = false;
            avatar = null;
            presidentStr = null;
            avatarFrameImgUrl = null;
            str = null;
            nickName = null;
        }
        if (j2 != 0) {
            aw9.d(((ChannelItemOrganizeMemberChannelBinding) this).f33304a, avatar, false, null);
            aw9.c(((ChannelItemOrganizeMemberChannelBinding) this).f33304a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(this.f8151a, nickName);
            TextViewBindingAdapter.setText(this.b, str);
            CommonBindingAdapter.e0(((ChannelItemOrganizeMemberChannelBinding) this).f8147a, setAsPresident);
            TextViewBindingAdapter.setText(((ChannelItemOrganizeMemberChannelBinding) this).f8147a, presidentStr);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8149a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8149a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemOrganizeMemberChannelBinding
    public void k(@Nullable ChannelMemberBean channelMemberBean) {
        ((ChannelItemOrganizeMemberChannelBinding) this).f8146a = channelMemberBean;
        synchronized (this) {
            this.f8149a |= 1;
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
        k((ChannelMemberBean) obj);
        return true;
    }

    public ChannelItemOrganizeMemberChannelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AvatarView) objArr[1], (BLTextView) objArr[4]);
        this.f8149a = -1L;
        ((ChannelItemOrganizeMemberChannelBinding) this).f33304a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8150a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f8151a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.b = textView2;
        textView2.setTag(null);
        ((ChannelItemOrganizeMemberChannelBinding) this).f8147a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
