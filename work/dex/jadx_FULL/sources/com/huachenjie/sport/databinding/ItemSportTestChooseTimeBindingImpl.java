package com.huachenjie.sport.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.sport.R;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemSportTestChooseTimeBindingImpl extends ItemSportTestChooseTimeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36531a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13647a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13650a;

    public ItemSportTestChooseTimeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13647a, f36531a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        int colorFromResource;
        int colorFromResource2;
        int i;
        int colorFromResource3;
        int colorFromResource4;
        boolean z;
        int colorFromResource5;
        int i2;
        ImageView imageView;
        int i3;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f13648a;
            this.f13648a = 0L;
        }
        Boolean bool = ((ItemSportTestChooseTimeBinding) this).f13645a;
        Boolean bool2 = ((ItemSportTestChooseTimeBinding) this).f13646b;
        if ((j & 7) != 0) {
            zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(bool2);
            if ((j & 8) != 0) {
                j |= zSafeUnbox ? 1024L : 512L;
            }
            if ((j & 7) != 0) {
                j |= zSafeUnbox ? PlaybackStateCompat.ACTION_PREPARE : 8192L;
            }
            if ((j & 6) != 0) {
                if (zSafeUnbox2) {
                    j2 = j | 64 | 256;
                    j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                } else {
                    j2 = j | 32 | 128;
                    j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                j = j2 | j3;
            }
            if ((j & 7) != 0) {
                j |= zSafeUnbox2 ? 4096L : 2048L;
            }
            i = zSafeUnbox ? 2 : 1;
            colorFromResource4 = zSafeUnbox2 ? ViewDataBinding.getColorFromResource(this.f13650a, R.color.white) : ViewDataBinding.getColorFromResource(this.f13650a, R.color.color_CAD2DA);
            z = !zSafeUnbox2;
            if ((j & 7) != 0) {
                j = z ? j | 16 : j | 8;
            }
            if ((j & 6) != 0) {
                colorFromResource3 = ViewDataBinding.getColorFromResource(((ItemSportTestChooseTimeBinding) this).b, zSafeUnbox2 ? R.color.color_333333 : R.color.color_666666);
                colorFromResource2 = zSafeUnbox2 ? ViewDataBinding.getColorFromResource(((ItemSportTestChooseTimeBinding) this).f36530a, R.color.color_2A2A2A) : ViewDataBinding.getColorFromResource(((ItemSportTestChooseTimeBinding) this).f36530a, R.color.white);
                if (zSafeUnbox2) {
                    imageView = this.f13649a;
                    i3 = R.color.hcj_theme_txt_color;
                } else {
                    imageView = this.f13649a;
                    i3 = R.color.white;
                }
                colorFromResource = ViewDataBinding.getColorFromResource(imageView, i3);
            } else {
                colorFromResource = 0;
                colorFromResource2 = 0;
                colorFromResource3 = 0;
            }
        } else {
            zSafeUnbox = false;
            colorFromResource = 0;
            colorFromResource2 = 0;
            i = 0;
            colorFromResource3 = 0;
            colorFromResource4 = 0;
            z = false;
        }
        if ((j & 8) != 0) {
            colorFromResource5 = ViewDataBinding.getColorFromResource(this.f13650a, zSafeUnbox ? R.color.hcj_theme_txt_color : R.color.color_999999);
        } else {
            colorFromResource5 = 0;
        }
        long j4 = 7 & j;
        if (j4 != 0) {
            if (z) {
                colorFromResource5 = ViewDataBinding.getColorFromResource(this.f13650a, R.color.color_CAD2DA);
            }
            i2 = colorFromResource5;
        } else {
            i2 = 0;
        }
        if (j4 != 0) {
            DrawablesBindingAdapter.h(this.f13650a, 0, Integer.valueOf(colorFromResource4), i2, i, 0.0f, 0.0f, 6.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if ((5 & j) != 0) {
            CommonBindingAdapter.l0(this.f13649a, zSafeUnbox);
        }
        if ((j & 6) != 0) {
            CommonBindingAdapter.Y(this.f13649a, Integer.valueOf(colorFromResource));
            ((ItemSportTestChooseTimeBinding) this).f36530a.setTextColor(colorFromResource2);
            ((ItemSportTestChooseTimeBinding) this).b.setTextColor(colorFromResource3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13648a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13648a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemSportTestChooseTimeBinding
    public void l(@Nullable Boolean bool) {
        ((ItemSportTestChooseTimeBinding) this).f13646b = bool;
        synchronized (this) {
            this.f13648a |= 2;
        }
        notifyPropertyChanged(ok0.A);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemSportTestChooseTimeBinding
    public void m(@Nullable Boolean bool) {
        ((ItemSportTestChooseTimeBinding) this).f13645a = bool;
        synchronized (this) {
            this.f13648a |= 1;
        }
        notifyPropertyChanged(ok0.E);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.E == i) {
            m((Boolean) obj);
        } else {
            if (ok0.A != i) {
                return false;
            }
            l((Boolean) obj);
        }
        return true;
    }

    public ItemSportTestChooseTimeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[1]);
        this.f13648a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13650a = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.f13649a = imageView;
        imageView.setTag(null);
        ((ItemSportTestChooseTimeBinding) this).f36530a.setTag(null);
        ((ItemSportTestChooseTimeBinding) this).b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
