package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.sport.bean.RunRankBean;
import com.zj.adlib.aw9;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemHuodongRunRanksBindingImpl extends ItemHuodongRunRanksBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36518a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13612a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13614a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13615a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public ItemHuodongRunRanksBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13612a, f36518a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String nickName;
        String avatarUrl;
        String str;
        String duration;
        int rankNumber;
        synchronized (this) {
            j = this.f13613a;
            this.f13613a = 0L;
        }
        RunRankBean runRankBean = ((ItemHuodongRunRanksBinding) this).f13611a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (runRankBean != null) {
                nickName = runRankBean.getNickName();
                rankNumber = runRankBean.getRankNumber();
                duration = runRankBean.formatDuration();
                avatarUrl = runRankBean.getAvatarUrl();
            } else {
                rankNumber = 0;
                nickName = null;
                avatarUrl = null;
                duration = null;
            }
            str = "" + rankNumber;
        } else {
            nickName = null;
            avatarUrl = null;
            str = null;
            duration = null;
        }
        if (j2 != 0) {
            aw9.d(((ItemHuodongRunRanksBinding) this).f36517a, avatarUrl, false, null);
            TextViewBindingAdapter.setText(this.f13614a, str);
            TextViewBindingAdapter.setText(this.b, nickName);
            TextViewBindingAdapter.setText(this.c, duration);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13613a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13613a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemHuodongRunRanksBinding
    public void k(@Nullable RunRankBean runRankBean) {
        ((ItemHuodongRunRanksBinding) this).f13611a = runRankBean;
        synchronized (this) {
            this.f13613a |= 1;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 != i) {
            return false;
        }
        k((RunRankBean) obj);
        return true;
    }

    public ItemHuodongRunRanksBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AvatarView) objArr[2]);
        this.f13613a = -1L;
        ((ItemHuodongRunRanksBinding) this).f36517a.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.f13615a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13614a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.c = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
