package com.huachenjie.home.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.SignBean;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemSign7ExtraBindingImpl extends HomeItemSign7ExtraBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34291a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9534a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9535a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9537a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public HomeItemSign7ExtraBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f9534a, f34291a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean signed;
        String str;
        String dayName;
        boolean fromSign;
        boolean z2;
        Drawable drawable;
        int colorFromResource;
        int colorFromResource2;
        int colorFromResource3;
        boolean z3;
        String str2;
        int extraCoin;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f9535a;
            this.f9535a = 0L;
        }
        SignBean signBean = ((HomeItemSign7ExtraBinding) this).f9533a;
        long j4 = j & 3;
        if (j4 != 0) {
            if (signBean != null) {
                dayName = signBean.getDayName();
                signed = signBean.getSigned();
                extraCoin = signBean.getExtraCoin();
            } else {
                signed = false;
                extraCoin = 0;
                dayName = null;
            }
            if (j4 != 0) {
                if (signed) {
                    j2 = j | 128;
                    j3 = 2048;
                } else {
                    j2 = j | 64;
                    j3 = 1024;
                }
                j = j2 | j3;
            }
            z = !signed;
            str = String.format("额外+%d", Integer.valueOf(extraCoin));
            if ((j & 3) != 0) {
                j |= z ? 512L : 256L;
            }
        } else {
            z = false;
            signed = false;
            str = null;
            dayName = null;
        }
        if ((1664 & j) != 0) {
            fromSign = signBean != null ? signBean.getFromSign() : false;
            z2 = (j & 640) != 0 ? !fromSign : false;
        } else {
            fromSign = false;
            z2 = false;
        }
        long j5 = j & 3;
        if (j5 != 0) {
            z3 = signed ? z2 : false;
            if (!z) {
                z2 = false;
            }
            if (signed) {
                fromSign = true;
            }
            if (j5 != 0) {
                j = z3 ? j | 8 | 32 | 8192 | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | 131072 : j | 4 | 16 | 4096 | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            colorFromResource2 = z3 ? ViewDataBinding.getColorFromResource(this.c, R.color.color_CCCCCC) : -9078407;
            drawable = z3 ? AppCompatResources.getDrawable(this.f9536a.getContext(), R.drawable.home_bg_sign_done) : AppCompatResources.getDrawable(this.f9536a.getContext(), R.drawable.home_bg_sign_normal);
            colorFromResource = z3 ? ViewDataBinding.getColorFromResource(this.b, R.color.color_CCCCCC) : RunIndexRecordAdapter.N;
            colorFromResource3 = z3 ? ViewDataBinding.getColorFromResource(this.f9537a, R.color.color_CCCCCC) : ViewDataBinding.getColorFromResource(this.f9537a, R.color.black);
        } else {
            drawable = null;
            colorFromResource = 0;
            colorFromResource2 = 0;
            colorFromResource3 = 0;
            fromSign = false;
            z2 = false;
            z3 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
            str2 = String.format("+%d", Integer.valueOf(signBean != null ? signBean.getRewardAmount() : 0));
        } else {
            str2 = null;
        }
        long j6 = j & 3;
        if (j6 == 0) {
            str2 = null;
        } else if (z3) {
            str2 = "已领取";
        }
        if (j6 != 0) {
            CommonBindingAdapter.l0(((HomeItemSign7ExtraBinding) this).f34290a, z2);
            CommonBindingAdapter.l0(((HomeItemSign7ExtraBinding) this).f9532a, fromSign);
            ViewBindingAdapter.setBackground(this.f9536a, drawable);
            TextViewBindingAdapter.setText(this.f9537a, dayName);
            this.f9537a.setTextColor(colorFromResource3);
            TextViewBindingAdapter.setText(this.b, str2);
            this.b.setTextColor(colorFromResource);
            TextViewBindingAdapter.setText(this.c, str);
            this.c.setTextColor(colorFromResource2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9535a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9535a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemSign7ExtraBinding
    public void k(@Nullable SignBean signBean) {
        ((HomeItemSign7ExtraBinding) this).f9533a = signBean;
        synchronized (this) {
            this.f9535a |= 1;
        }
        notifyPropertyChanged(xk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.g != i) {
            return false;
        }
        k((SignBean) obj);
        return true;
    }

    public HomeItemSign7ExtraBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (LottieAnimationView) objArr[2]);
        this.f9535a = -1L;
        ((HomeItemSign7ExtraBinding) this).f34290a.setTag(null);
        ((HomeItemSign7ExtraBinding) this).f9532a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9536a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f9537a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.c = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
