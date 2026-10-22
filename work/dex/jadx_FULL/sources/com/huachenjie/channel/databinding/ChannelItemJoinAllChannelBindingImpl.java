package com.huachenjie.channel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.JoinAllChannelBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemJoinAllChannelBindingImpl extends ChannelItemJoinAllChannelBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7998a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7999a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33253a = sparseIntArray;
        sparseIntArray.put(R.id.ll_info, 7);
    }

    public ChannelItemJoinAllChannelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f7998a, f33253a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String coverImgUrl;
        String avatar;
        String title;
        String blurb;
        String ownerName;
        String memberCountStr;
        synchronized (this) {
            j = this.f7999a;
            this.f7999a = 0L;
        }
        JoinAllChannelBean joinAllChannelBean = ((ChannelItemJoinAllChannelBinding) this).f7997a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (joinAllChannelBean != null) {
                coverImgUrl = joinAllChannelBean.getCoverImgUrl();
                title = joinAllChannelBean.getTitle();
                blurb = joinAllChannelBean.getBlurb();
                ownerName = joinAllChannelBean.getOwnerName();
                memberCountStr = joinAllChannelBean.getMemberCountStr();
                avatar = joinAllChannelBean.getAvatar();
            } else {
                coverImgUrl = null;
                avatar = null;
                title = null;
                blurb = null;
                ownerName = null;
                memberCountStr = null;
            }
            z = !TextUtils.isEmpty(blurb);
        } else {
            z = false;
            coverImgUrl = null;
            avatar = null;
            title = null;
            blurb = null;
            ownerName = null;
            memberCountStr = null;
        }
        if (j2 != 0) {
            aw9.d(((ChannelItemJoinAllChannelBinding) this).f7996a, avatar, false, null);
            CommonBindingAdapter.b0(((ChannelItemJoinAllChannelBinding) this).f7995a, coverImgUrl, JoinAllChannelBean.getOption(), false);
            CommonBindingAdapter.l0(this.c, z);
            TextViewBindingAdapter.setText(this.c, blurb);
            TextViewBindingAdapter.setText(this.d, memberCountStr);
            TextViewBindingAdapter.setText(((ChannelItemJoinAllChannelBinding) this).f7994a, title);
            TextViewBindingAdapter.setText(super.b, ownerName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7999a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7999a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemJoinAllChannelBinding
    public void k(@Nullable JoinAllChannelBean joinAllChannelBean) {
        ((ChannelItemJoinAllChannelBinding) this).f7997a = joinAllChannelBean;
        synchronized (this) {
            this.f7999a |= 1;
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
        k((JoinAllChannelBean) obj);
        return true;
    }

    public ChannelItemJoinAllChannelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AvatarView) objArr[4], (RoundImageView) objArr[1], (LinearLayout) objArr[7], (TextView) objArr[2], (TextView) objArr[5]);
        this.f7999a = -1L;
        ((ChannelItemJoinAllChannelBinding) this).f7996a.setTag(null);
        ((ChannelItemJoinAllChannelBinding) this).f7995a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.d = textView2;
        textView2.setTag(null);
        ((ChannelItemJoinAllChannelBinding) this).f7994a.setTag(null);
        super.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
