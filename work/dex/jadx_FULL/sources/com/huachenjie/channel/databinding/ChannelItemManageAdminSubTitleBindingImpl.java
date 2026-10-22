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
import com.huachenjie.channel.R;
import com.zj.adlib.SubAdminTitle;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemManageAdminSubTitleBindingImpl extends ChannelItemManageAdminSubTitleBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33258a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8010a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8013a;

    public ChannelItemManageAdminSubTitleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f8010a, f33258a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.f8011a;
            this.f8011a = 0L;
        }
        SubAdminTitle subAdminTitle = ((ChannelItemManageAdminSubTitleBinding) this).f33257a;
        long j2 = j & 3;
        if (j2 != 0) {
            str = String.format(this.f8013a.getResources().getString(R.string.channel_manage_sub_admin_count), Integer.valueOf(subAdminTitle != null ? subAdminTitle.d() : 0));
        } else {
            str = null;
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f8013a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8011a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8011a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemManageAdminSubTitleBinding
    public void k(@Nullable SubAdminTitle subAdminTitle) {
        ((ChannelItemManageAdminSubTitleBinding) this).f33257a = subAdminTitle;
        synchronized (this) {
            this.f8011a |= 1;
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
        k((SubAdminTitle) obj);
        return true;
    }

    public ChannelItemManageAdminSubTitleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f8011a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8012a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f8013a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
