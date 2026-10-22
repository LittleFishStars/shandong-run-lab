package com.huachenjie.common.databinding;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.R;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.widget.BottomIconView;
import com.huachenjie.common.widget.CheckImageView;
import com.huachenjie.common.widget.CheckTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.vk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class LayoutBottomIconViewBindingImpl extends LayoutBottomIconViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8650a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f8652a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33765a = sparseIntArray;
        sparseIntArray.put(R.id.iv_icon_red_dot, 3);
        sparseIntArray.put(R.id.iv_text_red_dot, 4);
    }

    public LayoutBottomIconViewBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f8650a, f33765a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        Drawable drawable;
        Drawable drawable2;
        int i;
        int i2;
        int checkedTextColor;
        boolean z;
        int textSize;
        int checkedTextSize;
        Drawable drawable3;
        Drawable iconRes;
        int i3;
        synchronized (this) {
            j = this.f8651a;
            this.f8651a = 0L;
        }
        Boolean bool = ((LayoutBottomIconViewBinding) this).f8649a;
        BottomIconView.BottomIconBean bottomIconBean = ((LayoutBottomIconViewBinding) this).f33764a;
        long j2 = j & 7;
        if (j2 != 0) {
            zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            if (j2 != 0) {
                j = zSafeUnbox ? j | 16 : j | 8;
            }
        } else {
            zSafeUnbox = false;
        }
        long j3 = 6 & j;
        String str = null;
        if (j3 != 0) {
            if (bottomIconBean != null) {
                Drawable checkedIconRes = bottomIconBean.getCheckedIconRes();
                int iconSize = bottomIconBean.getIconSize();
                int textColor = bottomIconBean.getTextColor();
                iconRes = bottomIconBean.getIconRes();
                String text = bottomIconBean.getText();
                checkedTextColor = bottomIconBean.getCheckedTextColor();
                drawable3 = checkedIconRes;
                str = text;
                i2 = textColor;
                i3 = iconSize;
            } else {
                drawable3 = null;
                iconRes = null;
                i3 = 0;
                i2 = 0;
                checkedTextColor = 0;
            }
            drawable2 = drawable3;
            i = i3;
            drawable = iconRes;
            z = !TextUtils.isEmpty(str);
        } else {
            drawable = null;
            drawable2 = null;
            i = 0;
            i2 = 0;
            checkedTextColor = 0;
            z = false;
        }
        if ((j & 24) != 0) {
            checkedTextSize = ((16 & j) == 0 || bottomIconBean == null) ? 0 : bottomIconBean.getCheckedTextSize();
            textSize = ((8 & j) == 0 || bottomIconBean == null) ? 0 : bottomIconBean.getTextSize();
        } else {
            textSize = 0;
            checkedTextSize = 0;
        }
        long j4 = 7 & j;
        if (j4 == 0) {
            textSize = 0;
        } else if (zSafeUnbox) {
            textSize = checkedTextSize;
        }
        if (j3 != 0) {
            float f = i;
            CommonBindingAdapter.f0(((LayoutBottomIconViewBinding) this).f8646a, f);
            CommonBindingAdapter.g0(((LayoutBottomIconViewBinding) this).f8646a, f);
            DrawablesBindingAdapter.d(((LayoutBottomIconViewBinding) this).f8646a, drawable, null, drawable2, null, null, null, null, null, null, null, null, null, null, null);
            CommonBindingAdapter.l0(((LayoutBottomIconViewBinding) this).f8647a, z);
            TextViewBindingAdapter.setText(((LayoutBottomIconViewBinding) this).f8647a, str);
            DrawablesBindingAdapter.g(((LayoutBottomIconViewBinding) this).f8647a, Integer.valueOf(i2), Integer.valueOf(checkedTextColor), null, null, null, null, null);
        }
        if ((j & 5) != 0) {
            ((LayoutBottomIconViewBinding) this).f8646a.setChecked(zSafeUnbox);
            ((LayoutBottomIconViewBinding) this).f8647a.setChecked(zSafeUnbox);
        }
        if (j4 != 0) {
            TextViewBindingAdapter.setTextSize(((LayoutBottomIconViewBinding) this).f8647a, textSize);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8651a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8651a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.common.databinding.LayoutBottomIconViewBinding
    public void l(@Nullable BottomIconView.BottomIconBean Data) {
        ((LayoutBottomIconViewBinding) this).f33764a = Data;
        synchronized (this) {
            this.f8651a |= 2;
        }
        notifyPropertyChanged(vk0.o);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.huachenjie.common.databinding.LayoutBottomIconViewBinding
    public void setChecked(@Nullable Boolean Checked) {
        ((LayoutBottomIconViewBinding) this).f8649a = Checked;
        synchronized (this) {
            this.f8651a |= 1;
        }
        notifyPropertyChanged(vk0.j);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (vk0.j == variableId) {
            setChecked((Boolean) variable);
        } else {
            if (vk0.o != variableId) {
                return false;
            }
            l((BottomIconView.BottomIconBean) variable);
        }
        return true;
    }

    public LayoutBottomIconViewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CheckImageView) bindings[1], (BLView) bindings[3], (BLView) bindings[4], (CheckTextView) bindings[2]);
        this.f8651a = -1L;
        ((LayoutBottomIconViewBinding) this).f8646a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f8652a = constraintLayout;
        constraintLayout.setTag(null);
        ((LayoutBottomIconViewBinding) this).f8647a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
