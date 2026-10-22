package com.huachenjie.run.databinding;

import android.content.Context;
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
import androidx.p002lifecycle.MutableLiveData;
import com.aliyun.vod.common.utils.FileUtils;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.ShadowFrameLayout;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutSunRunQualifyConditionsBindingImpl extends RunLayoutSunRunQualifyConditionsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35718a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12216a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12219a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowFrameLayout f12221a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12222b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12223b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12224c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f12225c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f12226d;

    public RunLayoutSunRunQualifyConditionsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 12, f12216a, f35718a));
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0178 A[PHI: r2
      0x0178: PHI (r2v7 long) = (r2v6 long), (r2v24 long) binds: [B:87:0x0147, B:101:0x0172] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:62:0x00ea A[PHI: r2
      0x00ea: PHI (r2v4 long) = (r2v3 long), (r2v31 long) binds: [B:45:0x00bb, B:59:0x00e4] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        Drawable drawable;
        int i2;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int iSafeUnbox;
        Drawable drawable5;
        long j2;
        int i10;
        long j3;
        long j4;
        Context context;
        int i11;
        long j5;
        long j6;
        Context context2;
        int i12;
        long j7;
        long j8;
        long j9;
        long j10;
        synchronized (this) {
            j = this.f12217a;
            this.f12217a = 0L;
        }
        SunshineRunVM sunshineRunVM = ((RunLayoutSunRunQualifyConditionsBinding) this).f35717a;
        if ((1023 & j) != 0) {
            long j11 = j & 769;
            int i13 = RunIndexRecordAdapter.P;
            if (j11 != 0) {
                MutableLiveData<Boolean> mutableLiveDataE = sunshineRunVM != null ? sunshineRunVM.E() : null;
                updateLiveDataRegistration(0, mutableLiveDataE);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataE != null ? mutableLiveDataE.getValue() : null);
                if (j11 != 0) {
                    if (zSafeUnbox) {
                        j9 = j | 8192;
                        j10 = 2147483648L;
                    } else {
                        j9 = j | 4096;
                        j10 = FileUtils.ONE_GB;
                    }
                    j = j9 | j10;
                }
                i9 = zSafeUnbox ? -16730402 : -15130848;
                drawable2 = zSafeUnbox ? AppCompatResources.getDrawable(this.c.getContext(), R.drawable.run_ic_run_pause_cond_done) : AppCompatResources.getDrawable(this.c.getContext(), R.drawable.run_ic_run_pause_cond_todo);
            } else {
                i9 = 0;
                drawable2 = null;
            }
            if ((j & 770) != 0) {
                BaseViewModel.b bVarE = sunshineRunVM != null ? sunshineRunVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 20));
            } else {
                iSafeUnbox = 0;
            }
            long j12 = j & 772;
            if (j12 == 0) {
                i4 = 0;
            } else {
                MutableLiveData<Boolean> mutableLiveDataF = sunshineRunVM != null ? sunshineRunVM.F() : null;
                updateLiveDataRegistration(2, mutableLiveDataF);
                boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataF != null ? mutableLiveDataF.getValue() : null);
                if (j12 != 0) {
                    j |= zSafeUnbox2 ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
                }
                if (zSafeUnbox2) {
                    i4 = 0;
                } else {
                    i4 = 8;
                }
            }
            long j13 = j & 776;
            if (j13 != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = sunshineRunVM != null ? sunshineRunVM.v() : null;
                updateLiveDataRegistration(3, mutableLiveDataV);
                boolean zSafeUnbox3 = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
                if (j13 != 0) {
                    if (zSafeUnbox3) {
                        j7 = j | 131072;
                        j8 = 134217728;
                    } else {
                        j7 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        j8 = 67108864;
                    }
                    j = j7 | j8;
                }
                i3 = zSafeUnbox3 ? -16730402 : -15130848;
                if (zSafeUnbox3) {
                    context2 = this.b.getContext();
                    i12 = R.drawable.run_ic_run_pause_cond_done;
                } else {
                    context2 = this.b.getContext();
                    i12 = R.drawable.run_ic_run_pause_cond_todo;
                }
                drawable5 = AppCompatResources.getDrawable(context2, i12);
            } else {
                i3 = 0;
                drawable5 = null;
            }
            long j14 = j & 784;
            if (j14 == 0) {
                i8 = 0;
            } else {
                MutableLiveData<Boolean> mutableLiveDataW = sunshineRunVM != null ? sunshineRunVM.w() : null;
                updateLiveDataRegistration(4, mutableLiveDataW);
                boolean zSafeUnbox4 = ViewDataBinding.safeUnbox(mutableLiveDataW != null ? mutableLiveDataW.getValue() : null);
                if (j14 != 0) {
                    j |= zSafeUnbox4 ? 8388608L : PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
                }
                if (zSafeUnbox4) {
                    i8 = 0;
                } else {
                    i8 = 8;
                }
            }
            long j15 = j & 800;
            if (j15 != 0) {
                MutableLiveData<Boolean> mutableLiveDataP = sunshineRunVM != null ? sunshineRunVM.P() : null;
                updateLiveDataRegistration(5, mutableLiveDataP);
                boolean zSafeUnbox5 = ViewDataBinding.safeUnbox(mutableLiveDataP != null ? mutableLiveDataP.getValue() : null);
                if (j15 != 0) {
                    j |= zSafeUnbox5 ? 536870912L : 268435456L;
                }
                i10 = zSafeUnbox5 ? 0 : 8;
                j2 = 832;
            } else {
                j2 = 832;
                i10 = 0;
            }
            long j16 = j & j2;
            if (j16 != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = sunshineRunVM != null ? sunshineRunVM.O() : null;
                updateLiveDataRegistration(6, mutableLiveDataO);
                boolean zSafeUnbox6 = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
                if (j16 != 0) {
                    if (zSafeUnbox6) {
                        j5 = j | 2048;
                        j6 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    } else {
                        j5 = j | 1024;
                        j6 = 262144;
                    }
                    j = j5 | j6;
                }
                i7 = zSafeUnbox6 ? -16730402 : -15130848;
                if (zSafeUnbox6) {
                    context = this.d.getContext();
                    i11 = R.drawable.run_ic_run_pause_cond_done;
                } else {
                    context = this.d.getContext();
                    i11 = R.drawable.run_ic_run_pause_cond_todo;
                }
                drawable = AppCompatResources.getDrawable(context, i11);
            } else {
                i7 = 0;
                drawable = null;
            }
            long j17 = j & 896;
            if (j17 != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = sunshineRunVM != null ? sunshineRunVM.m() : null;
                updateLiveDataRegistration(7, mutableLiveDataM);
                boolean zSafeUnbox7 = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
                if (j17 != 0) {
                    if (zSafeUnbox7) {
                        j3 = j | 2097152;
                        j4 = 33554432;
                    } else {
                        j3 = j | 1048576;
                        j4 = 16777216;
                    }
                    j = j3 | j4;
                }
                Drawable drawable6 = AppCompatResources.getDrawable(this.f12218a.getContext(), zSafeUnbox7 ? R.drawable.run_ic_run_pause_cond_done : R.drawable.run_ic_run_pause_cond_todo);
                if (!zSafeUnbox7) {
                    i13 = -15130848;
                }
                i = i13;
                drawable4 = drawable6;
            } else {
                i = 0;
                drawable4 = null;
            }
            i5 = i9;
            i2 = iSafeUnbox;
            drawable3 = drawable5;
            i6 = i10;
        } else {
            i = 0;
            drawable = null;
            i2 = 0;
            drawable2 = null;
            drawable3 = null;
            drawable4 = null;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if ((j & 770) != 0) {
            CommonBindingAdapter.I(this.f12221a, 16, i2, 0, 0, null);
        }
        if ((j & 896) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.f12218a, drawable4);
            this.f12223b.setTextColor(i);
        }
        if ((776 & j) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable3);
            this.f12220a.setTextColor(i3);
        }
        if ((772 & j) != 0) {
            this.f12219a.setVisibility(i4);
        }
        if ((j & 769) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.c, drawable2);
            this.f12225c.setTextColor(i5);
        }
        if ((800 & j) != 0) {
            this.f12222b.setVisibility(i6);
        }
        if ((832 & j) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.d, drawable);
            this.f12226d.setTextColor(i7);
        }
        if ((j & 784) != 0) {
            this.f12224c.setVisibility(i8);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12217a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12217a = 512L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutSunRunQualifyConditionsBinding
    public void k(@Nullable SunshineRunVM Vm) {
        ((RunLayoutSunRunQualifyConditionsBinding) this).f35717a = Vm;
        synchronized (this) {
            this.f12217a |= 256;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Boolean> VmDisConditionDone, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12217a |= 128;
        }
        return true;
    }

    public final boolean m(MutableLiveData<Boolean> VmNfcConditionDone, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12217a |= 8;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> VmNfcConditionVisible, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12217a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> VmPointConditionDone, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12217a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return o((MutableLiveData) object, fieldId);
            case 1:
                return s((MutableLiveData) object, fieldId);
            case 2:
                return p((MutableLiveData) object, fieldId);
            case 3:
                return m((MutableLiveData) object, fieldId);
            case 4:
                return n((MutableLiveData) object, fieldId);
            case 5:
                return r((MutableLiveData) object, fieldId);
            case 6:
                return q((MutableLiveData) object, fieldId);
            case 7:
                return l((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<Boolean> VmPointConditionVisible, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12217a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> VmSpeedConditionDone, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12217a |= 64;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Boolean> VmSpeedConditionVisible, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12217a |= 32;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12217a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((SunshineRunVM) variable);
        return true;
    }

    public RunLayoutSunRunQualifyConditionsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 8);
        this.f12217a = -1L;
        ShadowFrameLayout shadowFrameLayout = (ShadowFrameLayout) bindings[0];
        this.f12221a = shadowFrameLayout;
        shadowFrameLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f12218a = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[10];
        this.b = imageView2;
        imageView2.setTag(null);
        TextView textView = (TextView) bindings[11];
        this.f12220a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[2];
        this.f12223b = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[3];
        this.f12219a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView3 = (ImageView) bindings[4];
        this.c = imageView3;
        imageView3.setTag(null);
        TextView textView3 = (TextView) bindings[5];
        this.f12225c = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[6];
        this.f12222b = linearLayout2;
        linearLayout2.setTag(null);
        ImageView imageView4 = (ImageView) bindings[7];
        this.d = imageView4;
        imageView4.setTag(null);
        TextView textView4 = (TextView) bindings[8];
        this.f12226d = textView4;
        textView4.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) bindings[9];
        this.f12224c = linearLayout3;
        linearLayout3.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
