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
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import com.airbnb.lottie.LottieAnimationView;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.SignBean;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemSignBindingImpl extends HomeItemSignBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34293a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9539a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9543a;

    @NonNull
    public final TextView b;

    public HomeItemSignBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f9539a, f34293a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean signed;
        int i;
        int i2;
        Drawable drawable;
        String dayName;
        boolean fromSign;
        boolean z2;
        int colorFromResource;
        int colorFromResource2;
        boolean z3;
        boolean z4;
        Drawable drawable2;
        String str;
        int day;
        long j2;
        long j3;
        long j4;
        long j5;
        synchronized (this) {
            j = this.f9540a;
            this.f9540a = 0L;
        }
        SignBean signBean = ((HomeItemSignBinding) this).f9538a;
        long j6 = j & 3;
        if (j6 != 0) {
            if (signBean != null) {
                dayName = signBean.getDayName();
                signed = signBean.getSigned();
                day = signBean.getDay();
            } else {
                signed = false;
                day = 0;
                dayName = null;
            }
            if (j6 != 0) {
                if (signed) {
                    j4 = j | 128;
                    j5 = 2048;
                } else {
                    j4 = j | 64;
                    j5 = 1024;
                }
                j = j4 | j5;
            }
            z = !signed;
            boolean z5 = day == 7;
            if ((j & 3) != 0) {
                j |= z ? 512L : 256L;
            }
            if ((j & 3) != 0) {
                if (z5) {
                    j2 = j | 32 | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    j3 = 2097152;
                } else {
                    j2 = j | 16 | 262144;
                    j3 = 1048576;
                }
                j = j2 | j3;
            }
            int i3 = z5 ? 0 : 8;
            int iB = SizeUtils.b(z5 ? 40.0f : 28.0f);
            drawable = z5 ? AppCompatResources.getDrawable(this.f9541a.getContext(), R.drawable.home_ic_sign_coin_large) : AppCompatResources.getDrawable(this.f9541a.getContext(), R.drawable.home_ic_sign_coin);
            i2 = i3;
            i = iB;
        } else {
            z = false;
            signed = false;
            i = 0;
            i2 = 0;
            drawable = null;
            dayName = null;
        }
        if ((1664 & j) != 0) {
            fromSign = signBean != null ? signBean.getFromSign() : false;
            z2 = (j & 640) != 0 ? !fromSign : false;
        } else {
            fromSign = false;
            z2 = false;
        }
        long j7 = j & 3;
        if (j7 != 0) {
            z4 = signed ? z2 : false;
            if (!z) {
                z2 = false;
            }
            if (signed) {
                fromSign = true;
            }
            if (j7 != 0) {
                j = z4 ? j | 8 | 8192 | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | 131072 : j | 4 | 4096 | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            drawable2 = AppCompatResources.getDrawable(this.f9542a.getContext(), z4 ? R.drawable.home_bg_sign_done : R.drawable.home_bg_sign_normal);
            colorFromResource = z4 ? ViewDataBinding.getColorFromResource(this.b, R.color.color_CCCCCC) : RunIndexRecordAdapter.N;
            colorFromResource2 = ViewDataBinding.getColorFromResource(this.f9543a, z4 ? R.color.color_CCCCCC : R.color.black);
            z3 = z2;
        } else {
            colorFromResource = 0;
            colorFromResource2 = 0;
            z3 = false;
            fromSign = false;
            z4 = false;
            drawable2 = null;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
            str = String.format("+%d", Integer.valueOf(signBean != null ? signBean.getRewardAmount() : 0));
        } else {
            str = null;
        }
        long j8 = j & 3;
        if (j8 == 0) {
            str = null;
        } else if (z4) {
            str = "已领取";
        }
        if (j8 != 0) {
            CommonBindingAdapter.l0(((HomeItemSignBinding) this).f34292a, fromSign);
            ViewBindingAdapter.setBackground(this.f9542a, drawable2);
            TextViewBindingAdapter.setText(this.f9543a, dayName);
            this.f9543a.setTextColor(colorFromResource2);
            float f = i;
            CommonBindingAdapter.H(this.f9541a, f);
            CommonBindingAdapter.G(this.f9541a, f);
            ImageViewBindingAdapter.setImageDrawable(this.f9541a, drawable);
            CommonBindingAdapter.l0(this.f9541a, z3);
            CommonBindingAdapter.I(this.f9541a, 0, i2, 0, 0, null);
            TextViewBindingAdapter.setText(this.b, str);
            this.b.setTextColor(colorFromResource);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9540a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9540a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemSignBinding
    public void k(@Nullable SignBean signBean) {
        ((HomeItemSignBinding) this).f9538a = signBean;
        synchronized (this) {
            this.f9540a |= 1;
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

    public HomeItemSignBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LottieAnimationView) objArr[3]);
        this.f9540a = -1L;
        ((HomeItemSignBinding) this).f34292a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9542a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f9543a = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f9541a = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
