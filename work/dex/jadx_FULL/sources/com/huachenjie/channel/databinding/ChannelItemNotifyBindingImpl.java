package com.huachenjie.channel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.channel.bean.NotifyBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.noober.background.view.BLView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemNotifyBindingImpl extends ChannelItemNotifyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33293a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8103a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f8105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f8106a;

    @NonNull
    public final TextView b;

    public ChannelItemNotifyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f8103a, f33293a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String name;
        boolean z;
        boolean z2;
        int icon;
        synchronized (this) {
            j = this.f8104a;
            this.f8104a = 0L;
        }
        NotifyBean notifyBean = ((ChannelItemNotifyBinding) this).f8102a;
        long j2 = j & 3;
        String content = null;
        int i = 0;
        boolean redDot = false;
        if (j2 != 0) {
            if (notifyBean != null) {
                redDot = notifyBean.getRedDot();
                content = notifyBean.getContent();
                icon = notifyBean.formatIcon();
                name = notifyBean.formatName();
            } else {
                name = null;
                icon = 0;
            }
            z2 = !TextUtils.isEmpty(content);
            int i2 = icon;
            z = redDot;
            i = i2;
        } else {
            name = null;
            z = false;
            z2 = false;
        }
        if (j2 != 0) {
            DrawablesBindingAdapter.e(((ChannelItemNotifyBinding) this).f33292a, i);
            CommonBindingAdapter.l0(this.f8106a, z);
            CommonBindingAdapter.l0(this.b, z2);
            TextViewBindingAdapter.setText(this.b, content);
            TextViewBindingAdapter.setText(((ChannelItemNotifyBinding) this).f8101a, name);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8104a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8104a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemNotifyBinding
    public void k(@Nullable NotifyBean notifyBean) {
        ((ChannelItemNotifyBinding) this).f8102a = notifyBean;
        synchronized (this) {
            this.f8104a |= 1;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((NotifyBean) obj);
        return true;
    }

    public ChannelItemNotifyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[3]);
        this.f8104a = -1L;
        ((ChannelItemNotifyBinding) this).f33292a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f8105a = constraintLayout;
        constraintLayout.setTag(null);
        BLView bLView = (BLView) objArr[2];
        this.f8106a = bLView;
        bLView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.b = textView;
        textView.setTag(null);
        ((ChannelItemNotifyBinding) this).f8101a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
