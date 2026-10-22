package com.huachenjie.run.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.bean.RunRecordStatusLog;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huawei.hms.utils.FileUtil;
import com.noober.background.view.BLView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunItemRunRecordStatusBindingImpl extends RunItemRunRecordStatusBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35632a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11969a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11973a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f11974a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public RunItemRunRecordStatusBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 9, f11969a, f35632a));
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordStatusBinding
    public void A(boolean ShowAppealTime) {
        super.c = ShowAppealTime;
        synchronized (this) {
            this.f11970a |= 256;
        }
        notifyPropertyChanged(lk0.W);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordStatusBinding
    public void B(boolean ShowContent) {
        super.d = ShowContent;
        synchronized (this) {
            this.f11970a |= 128;
        }
        notifyPropertyChanged(lk0.X);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordStatusBinding
    public void C(boolean ShowFace) {
        super.e = ShowFace;
        synchronized (this) {
            this.f11970a |= 16;
        }
        notifyPropertyChanged(lk0.Y);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordStatusBinding
    public void D(boolean ShowGradient) {
        super.b = ShowGradient;
        synchronized (this) {
            this.f11970a |= 8;
        }
        notifyPropertyChanged(lk0.a0);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordStatusBinding
    public void E(boolean ShowTag) {
        ((RunItemRunRecordStatusBinding) this).f11968a = ShowTag;
        synchronized (this) {
            this.f11970a |= 64;
        }
        notifyPropertyChanged(lk0.d0);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordStatusBinding
    public void F(int TagBg) {
        this.L = TagBg;
        synchronized (this) {
            this.f11970a |= 4;
        }
        notifyPropertyChanged(lk0.h0);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordStatusBinding
    public void G(@Nullable String TagText) {
        this.g = TagText;
        synchronized (this) {
            this.f11970a |= 32;
        }
        notifyPropertyChanged(lk0.i0);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordStatusBinding
    public void H(@Nullable String Time) {
        this.h = Time;
        synchronized (this) {
            this.f11970a |= 4096;
        }
        notifyPropertyChanged(lk0.l0);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordStatusBinding
    public void I(@Nullable String Title) {
        this.f = Title;
        synchronized (this) {
            this.f11970a |= 512;
        }
        notifyPropertyChanged(lk0.m0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f11970a;
            this.f11970a = 0L;
        }
        int i = this.K;
        String str = this.j;
        int i2 = this.L;
        boolean z = super.b;
        boolean z2 = super.e;
        String str2 = this.g;
        boolean z3 = ((RunItemRunRecordStatusBinding) this).f11968a;
        boolean z4 = super.d;
        boolean z5 = super.c;
        String str3 = this.f;
        String str4 = this.i;
        RunRecordStatusLog runRecordStatusLog = ((RunItemRunRecordStatusBinding) this).f11967a;
        String str5 = this.h;
        long j4 = j & FileUtil.LOCAL_REPORT_FILE_MAX_SIZE;
        int i3 = 0;
        if (j4 != 0) {
            i3 = (runRecordStatusLog != null ? runRecordStatusLog.getStatus() : 0) == 1 ? 1 : 0;
            if (j4 != 0) {
                if (i3 != 0) {
                    j2 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    j3 = 131072;
                } else {
                    j2 = j | PlaybackStateCompat.ACTION_PREPARE;
                    j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                }
                j = j2 | j3;
            }
            drawable = AppCompatResources.getDrawable(this.f11972a.getContext(), i3 != 0 ? R.drawable.run_run_ic_detail_record_valid : R.drawable.run_run_ic_detail_record_invalid);
            i3 = i3 != 0 ? -12858007 : RunIndexRecordAdapter.L;
        } else {
            z2 = z2;
            drawable = null;
        }
        int i4 = i3;
        long j5 = j & 12288;
        if ((j & 8193) != 0) {
            CommonBindingAdapter.x(this.f11971a, i);
        }
        if ((j & 8200) != 0) {
            CommonBindingAdapter.l0(this.f11974a, z);
        }
        if ((j & FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.f11972a, drawable);
            this.f11973a.setTextColor(i4);
        }
        if ((8704 & j) != 0) {
            TextViewBindingAdapter.setText(this.f11973a, str3);
        }
        if (j5 != 0) {
            TextViewBindingAdapter.setText(this.b, str5);
        }
        if ((8194 & j) != 0) {
            TextViewBindingAdapter.setText(this.c, str);
        }
        if ((8320 & j) != 0) {
            CommonBindingAdapter.l0(this.c, z4);
        }
        if ((9216 & j) != 0) {
            TextViewBindingAdapter.setText(this.d, str4);
        }
        if ((8448 & j) != 0) {
            CommonBindingAdapter.l0(this.d, z5);
        }
        if ((8224 & j) != 0) {
            TextViewBindingAdapter.setText(this.e, str2);
        }
        if ((8196 & j) != 0) {
            CommonBindingAdapter.x(this.e, i2);
        }
        if ((8256 & j) != 0) {
            CommonBindingAdapter.l0(this.e, z3);
        }
        if ((j & 8208) != 0) {
            CommonBindingAdapter.l0(((RunItemRunRecordStatusBinding) this).f35631a, z2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11970a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11970a = 8192L;
        }
        requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordStatusBinding
    public void setContent(@Nullable String Content) {
        this.j = Content;
        synchronized (this) {
            this.f11970a |= 2;
        }
        notifyPropertyChanged(lk0.n);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.i == variableId) {
            z(((Integer) variable).intValue());
        } else if (lk0.n == variableId) {
            setContent((String) variable);
        } else if (lk0.h0 == variableId) {
            F(((Integer) variable).intValue());
        } else if (lk0.a0 == variableId) {
            D(((Boolean) variable).booleanValue());
        } else if (lk0.Y == variableId) {
            C(((Boolean) variable).booleanValue());
        } else if (lk0.i0 == variableId) {
            G((String) variable);
        } else if (lk0.d0 == variableId) {
            E(((Boolean) variable).booleanValue());
        } else if (lk0.X == variableId) {
            B(((Boolean) variable).booleanValue());
        } else if (lk0.W == variableId) {
            A(((Boolean) variable).booleanValue());
        } else if (lk0.m0 == variableId) {
            I((String) variable);
        } else if (lk0.d == variableId) {
            x((String) variable);
        } else if (lk0.g == variableId) {
            y((RunRecordStatusLog) variable);
        } else {
            if (lk0.l0 != variableId) {
                return false;
            }
            H((String) variable);
        }
        return true;
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordStatusBinding
    public void x(@Nullable String AppealTime) {
        this.i = AppealTime;
        synchronized (this) {
            this.f11970a |= 1024;
        }
        notifyPropertyChanged(lk0.d);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordStatusBinding
    public void y(@Nullable RunRecordStatusLog Bean) {
        ((RunItemRunRecordStatusBinding) this).f11967a = Bean;
        synchronized (this) {
            this.f11970a |= 2048;
        }
        notifyPropertyChanged(lk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordStatusBinding
    public void z(int CardBg) {
        this.K = CardBg;
        synchronized (this) {
            this.f11970a |= 1;
        }
        notifyPropertyChanged(lk0.i);
        super.requestRebind();
    }

    public RunItemRunRecordStatusBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RecyclerView) bindings[7]);
        this.f11970a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f11971a = frameLayout;
        frameLayout.setTag(null);
        BLView bLView = (BLView) bindings[1];
        this.f11974a = bLView;
        bLView.setTag(null);
        ImageView imageView = (ImageView) bindings[2];
        this.f11972a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.f11973a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[4];
        this.b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[5];
        this.c = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[6];
        this.d = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) bindings[8];
        this.e = textView5;
        textView5.setTag(null);
        ((RunItemRunRecordStatusBinding) this).f35631a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
