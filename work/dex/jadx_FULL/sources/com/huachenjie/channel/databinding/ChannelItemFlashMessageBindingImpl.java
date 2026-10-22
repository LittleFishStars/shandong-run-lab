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
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.bean.FlashMessageBuddyChatBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLView;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemFlashMessageBindingImpl extends ChannelItemFlashMessageBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33239a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7955a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7956a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7957a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7958a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f7959a;

    @NonNull
    public final TextView b;

    public ChannelItemFlashMessageBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f7955a, f33239a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        String title;
        boolean z;
        boolean z2;
        boolean z3;
        String str2;
        boolean z4;
        synchronized (this) {
            j = this.f7956a;
            this.f7956a = 0L;
        }
        FlashMessageBuddyChatBean flashMessageBuddyChatBean = ((ChannelItemFlashMessageBinding) this).f7954a;
        long j2 = j & 3;
        String str3 = null;
        if (j2 != 0) {
            requestOptions = ju3.b;
            if (flashMessageBuddyChatBean != null) {
                boolean redDot = flashMessageBuddyChatBean.getRedDot();
                String content = flashMessageBuddyChatBean.getContent();
                title = flashMessageBuddyChatBean.getTitle();
                String icon = flashMessageBuddyChatBean.getIcon();
                z4 = redDot;
                str3 = content;
                str2 = icon;
            } else {
                str2 = null;
                title = null;
                z4 = false;
            }
            z2 = !TextUtils.isEmpty(str3);
            z3 = !TextUtils.isEmpty(title);
            boolean z5 = z4;
            str = str3;
            str3 = str2;
            z = z5;
        } else {
            requestOptions = null;
            str = null;
            title = null;
            z = false;
            z2 = false;
            z3 = false;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((ChannelItemFlashMessageBinding) this).f33238a, str3, requestOptions, false);
            CommonBindingAdapter.l0(this.f7959a, z);
            TextViewBindingAdapter.setText(this.f7957a, title);
            CommonBindingAdapter.l0(this.f7957a, z3);
            TextViewBindingAdapter.setText(this.b, str);
            CommonBindingAdapter.l0(this.b, z2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7956a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7956a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemFlashMessageBinding
    public void k(@Nullable FlashMessageBuddyChatBean flashMessageBuddyChatBean) {
        ((ChannelItemFlashMessageBinding) this).f7954a = flashMessageBuddyChatBean;
        synchronized (this) {
            this.f7956a |= 1;
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
        k((FlashMessageBuddyChatBean) obj);
        return true;
    }

    public ChannelItemFlashMessageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1]);
        this.f7956a = -1L;
        ((ChannelItemFlashMessageBinding) this).f33238a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f7958a = constraintLayout;
        constraintLayout.setTag(null);
        BLView bLView = (BLView) objArr[2];
        this.f7959a = bLView;
        bLView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f7957a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
