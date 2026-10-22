package com.huachenjie.sport.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.widget.ShadowLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.SportTestItemBean;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemSportTestBindingImpl extends ItemSportTestBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36527a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13636a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13637a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13638a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13639a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f13640a;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public ItemSportTestBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f13636a, f36527a));
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0195  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        long j2;
        int colorFromResource;
        boolean z;
        boolean z2;
        boolean z3;
        Drawable drawable;
        Integer reserveTimeStatus;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z4;
        int colorFromResource2;
        boolean z5;
        String fitnessTestDate;
        String location;
        String title;
        boolean z6;
        String str5;
        long j3;
        long j4;
        Integer fitnessTestStatus;
        TextView textView;
        int i;
        synchronized (this) {
            j = this.f13637a;
            this.f13637a = 0L;
        }
        SportTestItemBean sportTestItemBean = ((ItemSportTestBinding) this).f13634a;
        Boolean bool = ((ItemSportTestBinding) this).f13635a;
        boolean z7 = false;
        if ((j & 7) != 0) {
            long j5 = j & 5;
            if (j5 != 0) {
                if (sportTestItemBean != null) {
                    fitnessTestDate = sportTestItemBean.getFitnessTestDate();
                    location = sportTestItemBean.getLocation();
                    fitnessTestStatus = sportTestItemBean.getFitnessTestStatus();
                    title = sportTestItemBean.getTitle();
                    reserveTimeStatus = sportTestItemBean.getReserveTimeStatus();
                } else {
                    fitnessTestDate = null;
                    location = null;
                    fitnessTestStatus = null;
                    title = null;
                    reserveTimeStatus = null;
                }
                int iSafeUnbox = ViewDataBinding.safeUnbox(fitnessTestStatus);
                int iSafeUnbox2 = ViewDataBinding.safeUnbox(reserveTimeStatus);
                boolean z8 = iSafeUnbox == 2;
                z = iSafeUnbox2 == 2;
                if (j5 != 0) {
                    j |= z8 ? 1024L : 512L;
                }
                if ((j & 5) != 0) {
                    j = z ? j | 4096 : j | 2048;
                }
                if (z8) {
                    textView = this.b;
                    i = R.color.color_FF762F;
                } else {
                    textView = this.b;
                    i = R.color.color_8997A4;
                }
                colorFromResource = ViewDataBinding.getColorFromResource(textView, i);
            } else {
                colorFromResource = 0;
                z = false;
                fitnessTestDate = null;
                location = null;
                title = null;
                reserveTimeStatus = null;
            }
            int iSafeUnbox3 = ViewDataBinding.safeUnbox(sportTestItemBean != null ? sportTestItemBean.getFitnessType() : null);
            long j6 = j & 5;
            if (j6 != 0) {
                boolean z9 = iSafeUnbox3 == 1;
                z6 = iSafeUnbox3 != 3;
                if (j6 != 0) {
                    if (z9) {
                        j3 = j | 16;
                        j4 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    } else {
                        j3 = j | 8;
                        j4 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    }
                    j = j3 | j4;
                }
                str5 = z9 ? "集中测试" : "报名预约";
                drawable = AppCompatResources.getDrawable(this.f13638a.getContext(), z9 ? R.drawable.ic_sport_test_class : R.drawable.ic_sport_test_appointment);
            } else {
                z6 = false;
                drawable = null;
                str5 = null;
            }
            z2 = iSafeUnbox3 == 2;
            if ((j & 7) == 0) {
                j2 = 64;
            } else if (z2) {
                j2 = 64;
                j |= 64;
            } else {
                j2 = 64;
                j |= 32;
            }
            str = fitnessTestDate;
            str2 = location;
            str3 = str5;
            str4 = title;
            z3 = z6;
        } else {
            j2 = 64;
            colorFromResource = 0;
            z = false;
            z2 = false;
            z3 = false;
            drawable = null;
            reserveTimeStatus = null;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
        }
        boolean z10 = (j2 & j) != 0 ? !ViewDataBinding.safeUnbox(bool) : false;
        if ((4096 & j) != 0) {
            z4 = !ViewDataBinding.safeUnbox(sportTestItemBean != null ? sportTestItemBean.getUserReserveStatus() : null);
        } else {
            z4 = false;
        }
        long j7 = j & 7;
        if (j7 != 0) {
            if (!z2) {
                z10 = false;
            }
            if (j7 != 0) {
                j = z10 ? j | 256 : j | 128;
            }
        } else {
            z10 = false;
        }
        long j8 = j & 5;
        if (j8 != 0) {
            if (!z) {
                z4 = false;
            }
            if (j8 != 0) {
                j |= z4 ? PlaybackStateCompat.ACTION_PREPARE : 8192L;
            }
            colorFromResource2 = ViewDataBinding.getColorFromResource(((ItemSportTestBinding) this).f36526a, z4 ? R.color.color_main_v2 : R.color.color_8997A4);
        } else {
            colorFromResource2 = 0;
        }
        if ((j & 256) != 0) {
            if (sportTestItemBean != null) {
                reserveTimeStatus = sportTestItemBean.getReserveTimeStatus();
            }
            z5 = ViewDataBinding.safeUnbox(reserveTimeStatus) != 3;
        }
        long j9 = 7 & j;
        if (j9 != 0 && z10) {
            z7 = z5;
        }
        boolean z11 = z7;
        if ((4 & j) != 0) {
            DrawablesBindingAdapter.h(this.f13639a, 0, -1051652, 0, 0.0f, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 13.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if ((j & 5) != 0) {
            TextViewBindingAdapter.setText(this.d, str4);
            boolean z12 = z3;
            CommonBindingAdapter.l0(this.f13638a, z12);
            ImageViewBindingAdapter.setImageDrawable(this.f13638a, drawable);
            CommonBindingAdapter.l0(this.e, z12);
            TextViewBindingAdapter.setText(this.e, str3);
            TextViewBindingAdapter.setText(this.f, str);
            TextViewBindingAdapter.setText(this.g, str2);
            DrawablesBindingAdapter.h(((ItemSportTestBinding) this).f36526a, 0, Integer.valueOf(colorFromResource2), 0, 0.0f, 0.0f, 0.0f, 6.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            DrawablesBindingAdapter.h(this.b, 0, Integer.valueOf(colorFromResource), 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 11.0f, 11.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if (j9 != 0) {
            CommonBindingAdapter.l0(((ItemSportTestBinding) this).f36526a, z10);
            CommonBindingAdapter.l0(this.c, z11);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13637a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13637a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemSportTestBinding
    public void l(@Nullable Boolean bool) {
        ((ItemSportTestBinding) this).f13635a = bool;
        synchronized (this) {
            this.f13637a |= 2;
        }
        notifyPropertyChanged(ok0.B);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemSportTestBinding
    public void m(@Nullable SportTestItemBean sportTestItemBean) {
        ((ItemSportTestBinding) this).f13634a = sportTestItemBean;
        synchronized (this) {
            this.f13637a |= 1;
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
        if (ok0.p0 == i) {
            m((SportTestItemBean) obj);
        } else {
            if (ok0.B != i) {
                return false;
            }
            l((Boolean) obj);
        }
        return true;
    }

    public ItemSportTestBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[9]);
        this.f13637a = -1L;
        ShadowLayout shadowLayout = (ShadowLayout) objArr[0];
        this.f13640a = shadowLayout;
        shadowLayout.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[1];
        this.f13639a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.d = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.f13638a = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.e = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.f = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[6];
        this.g = textView4;
        textView4.setTag(null);
        ((ItemSportTestBinding) this).f36526a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
