package com.huachenjie.home.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.home.bean.DailyTasksBean;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemTaskListBindingImpl extends HomeItemTaskListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34295a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9547a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f9549a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9550a;

    @NonNull
    public final TextView c;

    public HomeItemTaskListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f9547a, f34295a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        RequestOptions requestOptions;
        String strStatusName;
        String str3;
        float f;
        boolean z;
        int i;
        int i2;
        String strLocalOnceProgressStr;
        String strRewardDisplayStr;
        String logoUrl;
        int i3;
        boolean zFinished;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f9548a;
            this.f9548a = 0L;
        }
        DailyTasksBean dailyTasksBean = ((HomeItemTaskListBinding) this).f9545a;
        long j4 = j & 3;
        String strNameStr = null;
        if (j4 != 0) {
            requestOptions = ju3.h;
            if (dailyTasksBean != null) {
                strNameStr = dailyTasksBean.nameStr();
                strStatusName = dailyTasksBean.statusName();
                zFinished = dailyTasksBean.finished();
                strRewardDisplayStr = dailyTasksBean.rewardDisplayStr();
                int status = dailyTasksBean.getStatus();
                logoUrl = dailyTasksBean.getLogoUrl();
                strLocalOnceProgressStr = dailyTasksBean.localOnceProgressStr();
                i3 = status;
            } else {
                strLocalOnceProgressStr = null;
                strStatusName = null;
                strRewardDisplayStr = null;
                logoUrl = null;
                i3 = 0;
                zFinished = false;
            }
            if (j4 != 0) {
                j |= zFinished ? 512L : 256L;
            }
            z = !zFinished;
            float f2 = zFinished ? 0.5f : 1.0f;
            boolean z2 = i3 == 2;
            if ((j & 3) != 0) {
                j = z ? j | 128 : j | 64;
            }
            if ((j & 3) != 0) {
                if (z2) {
                    j2 = j | 8;
                    j3 = 32;
                } else {
                    j2 = j | 4;
                    j3 = 16;
                }
                j = j2 | j3;
            }
            int i4 = z2 ? -3355444 : -16002049;
            i = z2 ? -1 : RunIndexRecordAdapter.K;
            f = f2;
            str3 = logoUrl;
            i2 = i4;
            str2 = strRewardDisplayStr;
            String str4 = strNameStr;
            strNameStr = strLocalOnceProgressStr;
            str = str4;
        } else {
            str = null;
            str2 = null;
            requestOptions = null;
            strStatusName = null;
            str3 = null;
            f = 0.0f;
            z = false;
            i = 0;
            i2 = 0;
        }
        boolean z3 = (128 & j) != 0 ? !TextUtils.isEmpty(strNameStr) : false;
        long j5 = j & 3;
        if (j5 == 0 || !z) {
            z3 = false;
        }
        if (j5 != 0) {
            float f3 = f;
            CommonBindingAdapter.c0(((HomeItemTaskListBinding) this).f34294a, f3);
            CommonBindingAdapter.b0(((HomeItemTaskListBinding) this).f34294a, str3, requestOptions, false);
            CommonBindingAdapter.c0(((HomeItemTaskListBinding) this).b, f3);
            CommonBindingAdapter.e0(this.c, z);
            TextViewBindingAdapter.setText(this.c, str2);
            TextViewBindingAdapter.setText(this.f9550a, strNameStr);
            CommonBindingAdapter.l0(this.f9550a, z3);
            CommonBindingAdapter.e0(((HomeItemTaskListBinding) this).f9544a, z);
            TextViewBindingAdapter.setText(((HomeItemTaskListBinding) this).f9544a, strStatusName);
            ((HomeItemTaskListBinding) this).f9544a.setTextColor(i);
            DrawablesBindingAdapter.h(((HomeItemTaskListBinding) this).f9544a, 0, Integer.valueOf(i2), 0, 0.0f, 0.0f, 0.0f, 16.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            CommonBindingAdapter.e0(((HomeItemTaskListBinding) this).f9546b, z);
            TextViewBindingAdapter.setText(((HomeItemTaskListBinding) this).f9546b, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9548a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9548a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemTaskListBinding
    public void k(@Nullable DailyTasksBean dailyTasksBean) {
        ((HomeItemTaskListBinding) this).f9545a = dailyTasksBean;
        synchronized (this) {
            this.f9548a |= 1;
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
        k((DailyTasksBean) obj);
        return true;
    }

    public HomeItemTaskListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ImageView) objArr[3], (TextView) objArr[6], (TextView) objArr[2]);
        this.f9548a = -1L;
        ((HomeItemTaskListBinding) this).f34294a.setTag(null);
        ((HomeItemTaskListBinding) this).b.setTag(null);
        BLRelativeLayout bLRelativeLayout = (BLRelativeLayout) objArr[0];
        this.f9549a = bLRelativeLayout;
        bLRelativeLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.c = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[5];
        this.f9550a = bLTextView;
        bLTextView.setTag(null);
        ((HomeItemTaskListBinding) this).f9544a.setTag(null);
        ((HomeItemTaskListBinding) this).f9546b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
