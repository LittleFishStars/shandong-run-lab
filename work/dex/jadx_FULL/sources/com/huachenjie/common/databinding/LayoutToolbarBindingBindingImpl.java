package com.huachenjie.common.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.Converters;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.noober.background.view.BLView;
import com.zj.adlib.vk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class LayoutToolbarBindingBindingImpl extends LayoutToolbarBindingBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33787a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8705a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final View f8707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8708a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f8709a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f8710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f8711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f8712a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLView f8713b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View.OnClickListener f33788a;

        public a a(View.OnClickListener value) {
            this.f33788a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f33788a.onClick(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View.OnClickListener f33789a;

        public b a(View.OnClickListener value) {
            this.f33789a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f33789a.onClick(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View.OnClickListener f33790a;

        public c a(View.OnClickListener value) {
            this.f33790a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f33790a.onClick(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View.OnClickListener f33791a;

        public d a(View.OnClickListener value) {
            this.f33791a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f33791a.onClick(arg0);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View.OnClickListener f33792a;

        public e a(View.OnClickListener value) {
            this.f33792a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f33792a.onClick(arg0);
        }
    }

    public LayoutToolbarBindingBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 10, f8705a, f33787a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        boolean zIsBackShow;
        int i2;
        boolean z;
        boolean zIsShowRightIcon;
        int rightSubIconResId;
        boolean z2;
        int rightIconResId;
        int i3;
        boolean z3;
        boolean zIsLeftSubIconShow;
        int rightButtonBackground;
        int i4;
        boolean z4;
        boolean zIsShowRightIconNew;
        float alpha;
        d dVarA;
        b bVarA;
        c cVarA;
        Integer rightSubIconTintColor;
        String titleName;
        Integer rightIconTintColor;
        e eVarA;
        a aVarA;
        Integer backTintColor;
        Integer leftSubIconTintColor;
        String rightButtonText;
        int leftSubIconResId;
        int rightButtonTextColor;
        boolean zIsShowDivider;
        boolean zIsShowRightSubIconNew;
        int titleTextColor;
        int backIconResId;
        View.OnClickListener backClick;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        View.OnClickListener onClickListener3;
        View.OnClickListener onClickListener4;
        synchronized (this) {
            j = this.f8706a;
            this.f8706a = 0L;
        }
        BindingTitleBean bindingTitleBean = ((LayoutToolbarBindingBinding) this).f8703a;
        long j2 = j & 3;
        int background = 0;
        if (j2 != 0) {
            if (bindingTitleBean != null) {
                boolean zIsShowRightText = bindingTitleBean.isShowRightText();
                int statusBarHeight = bindingTitleBean.getStatusBarHeight();
                boolean zIsShowRightSubIcon = bindingTitleBean.isShowRightSubIcon();
                rightButtonTextColor = bindingTitleBean.getRightButtonTextColor();
                zIsShowDivider = bindingTitleBean.isShowDivider();
                rightSubIconTintColor = bindingTitleBean.getRightSubIconTintColor();
                zIsShowRightIconNew = bindingTitleBean.isShowRightIconNew();
                rightSubIconResId = bindingTitleBean.getRightSubIconResId();
                titleName = bindingTitleBean.getTitleName();
                rightIconResId = bindingTitleBean.getRightIconResId();
                zIsShowRightSubIconNew = bindingTitleBean.isShowRightSubIconNew();
                leftSubIconResId = bindingTitleBean.getLeftSubIconResId();
                alpha = bindingTitleBean.getAlpha();
                View.OnClickListener rightSubIconClick = bindingTitleBean.getRightSubIconClick();
                rightIconTintColor = bindingTitleBean.getRightIconTintColor();
                rightButtonBackground = bindingTitleBean.getRightButtonBackground();
                titleTextColor = bindingTitleBean.getTitleTextColor();
                View.OnClickListener rightTextClick = bindingTitleBean.getRightTextClick();
                zIsShowRightIcon = bindingTitleBean.isShowRightIcon();
                backIconResId = bindingTitleBean.getBackIconResId();
                View.OnClickListener leftSubIconClick = bindingTitleBean.getLeftSubIconClick();
                backTintColor = bindingTitleBean.getBackTintColor();
                zIsLeftSubIconShow = bindingTitleBean.isLeftSubIconShow();
                View.OnClickListener rightIconClick = bindingTitleBean.getRightIconClick();
                zIsBackShow = bindingTitleBean.isBackShow();
                leftSubIconTintColor = bindingTitleBean.getLeftSubIconTintColor();
                background = bindingTitleBean.getBackground();
                rightButtonText = bindingTitleBean.getRightButtonText();
                backClick = bindingTitleBean.getBackClick();
                onClickListener2 = rightSubIconClick;
                z4 = zIsShowRightText;
                onClickListener = rightTextClick;
                i = statusBarHeight;
                onClickListener3 = leftSubIconClick;
                z2 = zIsShowRightSubIcon;
                onClickListener4 = rightIconClick;
            } else {
                rightButtonTextColor = 0;
                zIsShowDivider = false;
                zIsShowRightIconNew = false;
                rightSubIconResId = 0;
                rightIconResId = 0;
                zIsShowRightSubIconNew = false;
                leftSubIconResId = 0;
                rightButtonBackground = 0;
                titleTextColor = 0;
                z4 = false;
                zIsShowRightIcon = false;
                backIconResId = 0;
                i = 0;
                zIsLeftSubIconShow = false;
                z2 = false;
                zIsBackShow = false;
                background = 0;
                alpha = 0.0f;
                backClick = null;
                onClickListener = null;
                onClickListener2 = null;
                onClickListener3 = null;
                onClickListener4 = null;
                rightSubIconTintColor = null;
                titleName = null;
                rightIconTintColor = null;
                backTintColor = null;
                leftSubIconTintColor = null;
                rightButtonText = null;
            }
            i4 = rightButtonTextColor;
            if (onClickListener2 != null) {
                a aVar = this.f8708a;
                if (aVar == null) {
                    aVar = new a();
                    this.f8708a = aVar;
                }
                aVarA = aVar.a(onClickListener2);
            } else {
                aVarA = null;
            }
            if (onClickListener != null) {
                b bVar = this.f8709a;
                if (bVar == null) {
                    bVar = new b();
                    this.f8709a = bVar;
                }
                bVarA = bVar.a(onClickListener);
            } else {
                bVarA = null;
            }
            if (onClickListener3 != null) {
                c cVar = this.f8710a;
                if (cVar == null) {
                    cVar = new c();
                    this.f8710a = cVar;
                }
                cVarA = cVar.a(onClickListener3);
            } else {
                cVarA = null;
            }
            if (onClickListener4 != null) {
                e eVar = this.f8712a;
                if (eVar == null) {
                    eVar = new e();
                    this.f8712a = eVar;
                }
                eVarA = eVar.a(onClickListener4);
            } else {
                eVarA = null;
            }
            if (backClick != null) {
                d dVar = this.f8711a;
                if (dVar == null) {
                    dVar = new d();
                    this.f8711a = dVar;
                }
                dVarA = dVar.a(backClick);
            } else {
                dVarA = null;
            }
            z = zIsShowDivider;
            z3 = zIsShowRightSubIconNew;
            i3 = titleTextColor;
            i2 = backIconResId;
        } else {
            i = 0;
            zIsBackShow = false;
            i2 = 0;
            z = false;
            zIsShowRightIcon = false;
            rightSubIconResId = 0;
            z2 = false;
            rightIconResId = 0;
            i3 = 0;
            z3 = false;
            zIsLeftSubIconShow = false;
            rightButtonBackground = 0;
            i4 = 0;
            z4 = false;
            zIsShowRightIconNew = false;
            alpha = 0.0f;
            dVarA = null;
            bVarA = null;
            cVarA = null;
            rightSubIconTintColor = null;
            titleName = null;
            rightIconTintColor = null;
            eVarA = null;
            aVarA = null;
            backTintColor = null;
            leftSubIconTintColor = null;
            rightButtonText = null;
            leftSubIconResId = 0;
        }
        if (j2 != 0) {
            CommonBindingAdapter.c0(((LayoutToolbarBindingBinding) this).f8702a, alpha);
            ViewBindingAdapter.setBackground(((LayoutToolbarBindingBinding) this).f8702a, Converters.convertColorToDrawable(background));
            boolean z5 = zIsLeftSubIconShow;
            CommonBindingAdapter.O(((LayoutToolbarBindingBinding) this).f8702a, 0, i, 0, 0, null);
            DrawablesBindingAdapter.e(((LayoutToolbarBindingBinding) this).f33786a, rightIconResId);
            CommonBindingAdapter.Y(((LayoutToolbarBindingBinding) this).f33786a, rightIconTintColor);
            CommonBindingAdapter.l0(((LayoutToolbarBindingBinding) this).f33786a, zIsShowRightIcon);
            CommonBindingAdapter.q(((LayoutToolbarBindingBinding) this).f33786a, eVarA, null);
            DrawablesBindingAdapter.e(((LayoutToolbarBindingBinding) this).b, rightSubIconResId);
            CommonBindingAdapter.Y(((LayoutToolbarBindingBinding) this).b, rightSubIconTintColor);
            CommonBindingAdapter.l0(((LayoutToolbarBindingBinding) this).b, z2);
            CommonBindingAdapter.q(((LayoutToolbarBindingBinding) this).b, aVarA, null);
            TextViewBindingAdapter.setText(this.b, titleName);
            this.b.setTextColor(i3);
            CommonBindingAdapter.l0(this.f8713b, z3);
            CommonBindingAdapter.l0(this.f8707a, z);
            DrawablesBindingAdapter.e(this.c, i2);
            CommonBindingAdapter.Y(this.c, backTintColor);
            CommonBindingAdapter.l0(this.c, zIsBackShow);
            CommonBindingAdapter.q(this.c, dVarA, null);
            DrawablesBindingAdapter.e(this.d, leftSubIconResId);
            CommonBindingAdapter.Y(this.d, leftSubIconTintColor);
            CommonBindingAdapter.l0(this.d, z5);
            CommonBindingAdapter.q(this.d, cVarA, null);
            ViewBindingAdapter.setBackground(((LayoutToolbarBindingBinding) this).f8701a, Converters.convertColorToDrawable(rightButtonBackground));
            TextViewBindingAdapter.setText(((LayoutToolbarBindingBinding) this).f8701a, rightButtonText);
            ((LayoutToolbarBindingBinding) this).f8701a.setTextColor(i4);
            CommonBindingAdapter.l0(((LayoutToolbarBindingBinding) this).f8701a, z4);
            CommonBindingAdapter.q(((LayoutToolbarBindingBinding) this).f8701a, bVarA, null);
            CommonBindingAdapter.l0(((LayoutToolbarBindingBinding) this).f8704a, zIsShowRightIconNew);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8706a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8706a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.common.databinding.LayoutToolbarBindingBinding
    public void k(@Nullable BindingTitleBean Title) {
        ((LayoutToolbarBindingBinding) this).f8703a = Title;
        synchronized (this) {
            this.f8706a |= 1;
        }
        notifyPropertyChanged(vk0.m0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (vk0.m0 != variableId) {
            return false;
        }
        k((BindingTitleBean) variable);
        return true;
    }

    public LayoutToolbarBindingBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[0], (ImageView) bindings[6], (ImageView) bindings[4], (ImageView) bindings[2], (ImageView) bindings[3], (TextView) bindings[8], (BLView) bindings[7]);
        this.f8706a = -1L;
        ((LayoutToolbarBindingBinding) this).f8702a.setTag(null);
        ((LayoutToolbarBindingBinding) this).f33786a.setTag(null);
        ((LayoutToolbarBindingBinding) this).b.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.b = textView;
        textView.setTag(null);
        BLView bLView = (BLView) bindings[5];
        this.f8713b = bLView;
        bLView.setTag(null);
        View view = (View) bindings[9];
        this.f8707a = view;
        view.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        ((LayoutToolbarBindingBinding) this).f8701a.setTag(null);
        ((LayoutToolbarBindingBinding) this).f8704a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
