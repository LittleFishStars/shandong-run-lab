package com.huachenjie.mall.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
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
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.video.AliVideoView;
import com.huachenjie.mall.page.course_detail.CourseDetailActivity;
import com.huachenjie.mall.page.course_detail.CourseDetailAdapter;
import com.huachenjie.mall.page.course_detail.CourseDetailVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityCourseDetailBindingImpl extends MallActivityCourseDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10188a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10189a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10191a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10195a;

    @NonNull
    public final ImageView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CourseDetailActivity.a f34787a;

        public a a(CourseDetailActivity.a aVar) {
            this.f34787a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34787a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CourseDetailActivity.a f34788a;

        public b a(CourseDetailActivity.a aVar) {
            this.f34788a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34788a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        f10187a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{7}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34786a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.video_view, 8);
    }

    public MallActivityCourseDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f10187a, f34786a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f1  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        CourseDetailAdapter value;
        BindingTitleBean value2;
        Drawable drawable;
        int iSafeUnbox;
        boolean z;
        boolean z2;
        String str;
        a aVarA;
        b bVarA;
        long j2;
        boolean z3;
        long j3;
        long j4;
        synchronized (this) {
            j = this.f10188a;
            this.f10188a = 0L;
        }
        CourseDetailVM courseDetailVM = ((MallActivityCourseDetailBinding) this).f10186a;
        CourseDetailActivity.a aVar = ((MallActivityCourseDetailBinding) this).f10185a;
        if ((190 & j) != 0) {
            if ((j & 162) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = courseDetailVM != null ? courseDetailVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            long j5 = j & 164;
            if (j5 != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = courseDetailVM != null ? courseDetailVM.m() : null;
                updateLiveDataRegistration(2, mutableLiveDataM);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
                if (j5 != 0) {
                    if (zSafeUnbox) {
                        j3 = j | 512;
                        j4 = 8192;
                    } else {
                        j3 = j | 256;
                        j4 = 4096;
                    }
                    j = j3 | j4;
                }
                str = zSafeUnbox ? "继续播放" : "试看结束";
                drawable = zSafeUnbox ? AppCompatResources.getDrawable(this.b.getContext(), com.huachenjie.mall.R.drawable.mall_ic_video_play_continue) : AppCompatResources.getDrawable(this.b.getContext(), com.huachenjie.mall.R.drawable.ic_video_view_replay);
            } else {
                drawable = null;
                str = null;
            }
            long j6 = j & 168;
            if (j6 != 0) {
                MutableLiveData<Integer> mutableLiveDataO = courseDetailVM != null ? courseDetailVM.o() : null;
                updateLiveDataRegistration(3, mutableLiveDataO);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
                z = iSafeUnbox == 1;
                z3 = iSafeUnbox == 0;
                if (j6 != 0) {
                    j = z ? j | 2048 : j | 1024;
                }
                j2 = 176;
            } else {
                iSafeUnbox = 0;
                z = false;
                j2 = 176;
                z3 = false;
            }
            if ((j & j2) == 0) {
                z2 = z3;
                value = null;
            } else {
                MutableLiveData<CourseDetailAdapter> mutableLiveDataJ = courseDetailVM != null ? courseDetailVM.j() : null;
                updateLiveDataRegistration(4, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                    z2 = z3;
                } else {
                    z2 = z3;
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            drawable = null;
            iSafeUnbox = 0;
            z = false;
            z2 = false;
            str = null;
        }
        long j7 = j & 192;
        if (j7 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f10194a;
            if (bVar == null) {
                bVar = new b();
                this.f10194a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f10193a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10193a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        boolean z4 = (1024 & j) != 0 && iSafeUnbox == 3;
        long j8 = 168 & j;
        if (j8 == 0) {
            z4 = false;
        } else if (z) {
            z4 = true;
        }
        if (j8 != 0) {
            CommonBindingAdapter.l0(this.f10190a, z2);
            CommonBindingAdapter.l0(this.f10189a, z4);
        }
        if (j7 != 0) {
            CommonBindingAdapter.q(this.f10189a, aVarA, null);
            CommonBindingAdapter.q(this.f10195a, bVarA, null);
        }
        if ((164 & j) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable);
            TextViewBindingAdapter.setText(this.f10192a, str);
        }
        if ((176 & j) != 0) {
            CommonBindingAdapter.g(((MallActivityCourseDetailBinding) this).f34785a, value, false, false);
        }
        if ((j & 162) != 0) {
            ((MallActivityCourseDetailBinding) this).f10183a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityCourseDetailBinding) this).f10183a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10188a != 0) {
                return true;
            }
            return ((MallActivityCourseDetailBinding) this).f10183a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10188a = 128L;
        }
        ((MallActivityCourseDetailBinding) this).f10183a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityCourseDetailBinding
    public void l(@Nullable CourseDetailActivity.a aVar) {
        ((MallActivityCourseDetailBinding) this).f10185a = aVar;
        synchronized (this) {
            this.f10188a |= 64;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityCourseDetailBinding
    public void m(@Nullable CourseDetailVM courseDetailVM) {
        ((MallActivityCourseDetailBinding) this).f10186a = courseDetailVM;
        synchronized (this) {
            this.f10188a |= 32;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10188a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<CourseDetailAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10188a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 1) {
            return r((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10188a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10188a |= 8;
        }
        return true;
    }

    public final boolean r(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10188a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityCourseDetailBinding) this).f10183a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((CourseDetailVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((CourseDetailActivity.a) obj);
        }
        return true;
    }

    public MallActivityCourseDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (RecyclerView) objArr[6], (LayoutToolbarBindingBinding) objArr[7], (AliVideoView) objArr[8]);
        this.f10188a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10191a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10190a = imageView;
        imageView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[2];
        this.f10189a = frameLayout;
        frameLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[3];
        this.f10195a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ImageView imageView2 = (ImageView) objArr[4];
        this.b = imageView2;
        imageView2.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.f10192a = textView;
        textView.setTag(null);
        ((MallActivityCourseDetailBinding) this).f34785a.setTag(null);
        setContainedBinding(((MallActivityCourseDetailBinding) this).f10183a);
        setRootTag(view);
        invalidateAll();
    }
}
