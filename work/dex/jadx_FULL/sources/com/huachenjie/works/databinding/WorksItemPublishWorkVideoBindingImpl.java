package com.huachenjie.works.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.DrawableCenterButton;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.widget.select_media.SelectGridMediaAdapter;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemPublishWorkVideoBindingImpl extends WorksItemPublishWorkVideoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14668a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14669a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14670a;

    @NonNull
    public final ImageView b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37061a = sparseIntArray;
        sparseIntArray.put(R.id.fl_container, 3);
        sparseIntArray.put(R.id.iv_video_mark, 4);
        sparseIntArray.put(R.id.bt_preview, 5);
        sparseIntArray.put(R.id.bt_del, 6);
    }

    public WorksItemPublishWorkVideoBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f14668a, f37061a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        String string;
        String picPath;
        boolean z;
        String str;
        RequestOptions requestOptions;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f14669a;
            this.f14669a = 0L;
        }
        SelectGridMediaAdapter selectGridMediaAdapter = ((WorksItemPublishWorkVideoBinding) this).f14667a;
        PubWorkMediaData pubWorkMediaData = ((WorksItemPublishWorkVideoBinding) this).f14666a;
        long j4 = j & 7;
        if (j4 != 0) {
            picPath = pubWorkMediaData != null ? pubWorkMediaData.getPicPath() : null;
            z = picPath == null;
            if (j4 != 0) {
                j = z ? j | 16 | 64 : j | 8 | 32;
            }
            if ((j & 6) != 0) {
                if (z) {
                    j2 = j | 256;
                    j3 = 1024;
                } else {
                    j2 = j | 128;
                    j3 = 512;
                }
                j = j2 | j3;
            }
            if ((j & 6) != 0) {
                string = z ? ((WorksItemPublishWorkVideoBinding) this).f14665a.getResources().getString(R.string.works_publish_work_add_cover) : ((WorksItemPublishWorkVideoBinding) this).f14665a.getResources().getString(R.string.works_publish_work_edit_cover);
                drawable = z ? AppCompatResources.getDrawable(((WorksItemPublishWorkVideoBinding) this).f14665a.getContext(), R.drawable.works_ic_publish_video_cover_add) : AppCompatResources.getDrawable(((WorksItemPublishWorkVideoBinding) this).f14665a.getContext(), R.drawable.works_ic_publish_video_cover_edit);
            } else {
                drawable = null;
                string = null;
            }
        } else {
            drawable = null;
            string = null;
            picPath = null;
            z = false;
        }
        RequestOptions requestOptions2 = (32 & j) != 0 ? ju3.p : null;
        String videoPath = ((16 & j) == 0 || pubWorkMediaData == null) ? null : pubWorkMediaData.getVideoPath();
        RequestOptions blurOptions = ((64 & j) == 0 || selectGridMediaAdapter == null) ? null : selectGridMediaAdapter.getBlurOptions();
        long j5 = 7 & j;
        if (j5 != 0) {
            if (z) {
                picPath = videoPath;
            }
            if (!z) {
                blurOptions = requestOptions2;
            }
            requestOptions = blurOptions;
            str = picPath;
        } else {
            str = null;
            requestOptions = null;
        }
        if ((j & 6) != 0) {
            TextViewBindingAdapter.setDrawableStart(((WorksItemPublishWorkVideoBinding) this).f14665a, drawable);
            TextViewBindingAdapter.setText(((WorksItemPublishWorkVideoBinding) this).f14665a, string);
        }
        if (j5 != 0) {
            CommonBindingAdapter.b0(this.b, str, requestOptions, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14669a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14669a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemPublishWorkVideoBinding
    public void l(@Nullable SelectGridMediaAdapter Adapter) {
        ((WorksItemPublishWorkVideoBinding) this).f14667a = Adapter;
        synchronized (this) {
            this.f14669a |= 1;
        }
        notifyPropertyChanged(qk0.b);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemPublishWorkVideoBinding
    public void m(@Nullable PubWorkMediaData Data) {
        ((WorksItemPublishWorkVideoBinding) this).f14666a = Data;
        synchronized (this) {
            this.f14669a |= 2;
        }
        notifyPropertyChanged(qk0.o);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.b == variableId) {
            l((SelectGridMediaAdapter) variable);
        } else {
            if (qk0.o != variableId) {
                return false;
            }
            m((PubWorkMediaData) variable);
        }
        return true;
    }

    public WorksItemPublishWorkVideoBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (DrawableCenterButton) bindings[2], (DrawableCenterButton) bindings[6], (DrawableCenterButton) bindings[5], (FrameLayout) bindings[3], (ImageView) bindings[4]);
        this.f14669a = -1L;
        ((WorksItemPublishWorkVideoBinding) this).f14665a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14670a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.b = imageView;
        imageView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
