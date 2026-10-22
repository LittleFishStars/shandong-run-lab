package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.EpisodeDetailBean;
import com.huachenjie.mall.bean.EpisodeProgress;
import com.huachenjie.mall.page.course_detail.CourseDetailVM;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallViewCourseDetailHeaderBindingImpl extends MallViewCourseDetailHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11018a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11021a;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35078a = sparseIntArray;
        sparseIntArray.put(R.id.tv_lessons_learned_title, 7);
        sparseIntArray.put(R.id.tv_study_time_title, 8);
        sparseIntArray.put(R.id.tv_wait_study_time_title, 9);
    }

    public MallViewCourseDetailHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f11018a, f35078a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String episodeName;
        String seeDurationStr;
        String str2;
        String episodeDesc;
        EpisodeProgress episodeProgress;
        int seeCount;
        int nonSeeCount;
        synchronized (this) {
            j = this.f11019a;
            this.f11019a = 0L;
        }
        CourseDetailVM courseDetailVM = ((MallViewCourseDetailHeaderBinding) this).f11017a;
        long j2 = j & 7;
        boolean z = false;
        String str3 = null;
        if (j2 != 0) {
            MutableLiveData<EpisodeDetailBean> mutableLiveDataL = courseDetailVM != null ? courseDetailVM.l() : null;
            updateLiveDataRegistration(0, mutableLiveDataL);
            EpisodeDetailBean value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
            if (value != null) {
                episodeName = value.getEpisodeName();
                episodeProgress = value.getEpisodeProgress();
                episodeDesc = value.getEpisodeDesc();
            } else {
                episodeDesc = null;
                episodeName = null;
                episodeProgress = null;
            }
            boolean z2 = episodeProgress != null;
            if (episodeProgress != null) {
                nonSeeCount = episodeProgress.getNonSeeCount();
                seeCount = episodeProgress.getSeeCount();
                seeDurationStr = episodeProgress.getSeeDurationStr();
            } else {
                seeCount = 0;
                seeDurationStr = null;
                nonSeeCount = 0;
            }
            str2 = episodeDesc;
            str = String.format("%d门", Integer.valueOf(nonSeeCount));
            str3 = String.format("%d门", Integer.valueOf(seeCount));
            z = z2;
        } else {
            str = null;
            episodeName = null;
            seeDurationStr = null;
            str2 = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(this.f11021a, z);
            TextViewBindingAdapter.setText(this.d, str3);
            TextViewBindingAdapter.setText(this.e, seeDurationStr);
            TextViewBindingAdapter.setText(this.f, str);
            TextViewBindingAdapter.setText(this.g, episodeName);
            TextViewBindingAdapter.setText(this.h, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11019a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11019a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewCourseDetailHeaderBinding
    public void k(@Nullable CourseDetailVM courseDetailVM) {
        ((MallViewCourseDetailHeaderBinding) this).f11017a = courseDetailVM;
        synchronized (this) {
            this.f11019a |= 2;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<EpisodeDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f11019a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 != i) {
            return false;
        }
        k((CourseDetailVM) obj);
        return true;
    }

    public MallViewCourseDetailHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[7], (TextView) objArr[8], (TextView) objArr[9]);
        this.f11019a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f11020a = linearLayout;
        linearLayout.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[1];
        this.f11021a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.d = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.e = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.f = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.g = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[6];
        this.h = textView5;
        textView5.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
