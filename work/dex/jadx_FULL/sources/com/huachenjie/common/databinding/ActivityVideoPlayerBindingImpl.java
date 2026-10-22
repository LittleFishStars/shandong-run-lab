package com.huachenjie.common.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.video.VideoPlayerActivity;
import com.huachenjie.common.video.VideoPlayerVM;
import com.huachenjie.common.video.VideoTextureView;
import com.huachenjie.common.widget.LoadingLineView;
import com.noober.background.view.BLImageView;
import com.zj.adlib.vk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ActivityVideoPlayerBindingImpl extends ActivityVideoPlayerBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8586a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8587a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f8588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8589a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f8590a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VideoPlayerActivity.a f33744a;

        public a a(VideoPlayerActivity.a value) {
            this.f33744a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f33744a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33743a = sparseIntArray;
        sparseIntArray.put(R.id.videoTextureView, 2);
        sparseIntArray.put(R.id.ivPlayButton, 3);
        sparseIntArray.put(R.id.loadingLine, 4);
        sparseIntArray.put(R.id.pb_video_progress, 5);
        sparseIntArray.put(R.id.sb_video_seek, 6);
        sparseIntArray.put(R.id.llTimeContainer, 7);
        sparseIntArray.put(R.id.tvCurrentPlayTime, 8);
        sparseIntArray.put(R.id.tvVideoDuration, 9);
    }

    public ActivityVideoPlayerBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 10, f8586a, f33743a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f8587a;
            this.f8587a = 0L;
        }
        VideoPlayerVM videoPlayerVM = ((ActivityVideoPlayerBinding) this).f8583a;
        VideoPlayerActivity.a aVar = ((ActivityVideoPlayerBinding) this).f8582a;
        long j2 = 11 & j;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            BaseViewModel.b bVarE = videoPlayerVM != null ? videoPlayerVM.e() : null;
            MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
            updateLiveDataRegistration(0, mutableLiveDataB);
            iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 4));
        }
        int i = iSafeUnbox;
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f8589a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f8589a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.I(this.f8590a, 0, i, 0, 0, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f8590a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8587a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8587a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.common.databinding.ActivityVideoPlayerBinding
    public void l(@Nullable VideoPlayerActivity.a Click) {
        ((ActivityVideoPlayerBinding) this).f8582a = Click;
        synchronized (this) {
            this.f8587a |= 4;
        }
        notifyPropertyChanged(vk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.common.databinding.ActivityVideoPlayerBinding
    public void m(@Nullable VideoPlayerVM Vm) {
        ((ActivityVideoPlayerBinding) this).f8583a = Vm;
        synchronized (this) {
            this.f8587a |= 2;
        }
        notifyPropertyChanged(vk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != vk0.f45372a) {
            return false;
        }
        synchronized (this) {
            this.f8587a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (vk0.p0 == variableId) {
            m((VideoPlayerVM) variable);
        } else {
            if (vk0.k != variableId) {
                return false;
            }
            l((VideoPlayerActivity.a) variable);
        }
        return true;
    }

    public ActivityVideoPlayerBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (ImageView) bindings[3], (LinearLayout) bindings[7], (LoadingLineView) bindings[4], (ProgressBar) bindings[5], (SeekBar) bindings[6], (TextView) bindings[8], (TextView) bindings[9], (VideoTextureView) bindings[2]);
        this.f8587a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f8588a = frameLayout;
        frameLayout.setTag(null);
        BLImageView bLImageView = (BLImageView) bindings[1];
        this.f8590a = bLImageView;
        bLImageView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
