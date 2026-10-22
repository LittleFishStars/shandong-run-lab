package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.noober.background.view.BLTextView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelDialogOpenNotificationBindingImpl extends ChannelDialogOpenNotificationBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7743a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7744a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f7745a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33149a = sparseIntArray;
        sparseIntArray.put(R.id.iv_header, 1);
        sparseIntArray.put(R.id.tv_title, 2);
        sparseIntArray.put(R.id.tv_des, 3);
        sparseIntArray.put(R.id.bt_cancel, 4);
        sparseIntArray.put(R.id.bt_open, 5);
    }

    public ChannelDialogOpenNotificationBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f7743a, f33149a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f7744a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7744a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7744a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelDialogOpenNotificationBinding
    public void k(@Nullable BaseViewModel baseViewModel) {
        ((ChannelDialogOpenNotificationBinding) this).f7740a = baseViewModel;
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
        k((BaseViewModel) obj);
        return true;
    }

    public ChannelDialogOpenNotificationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLTextView) objArr[4], (BLTextView) objArr[5], (ImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[2]);
        this.f7744a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f7745a = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
