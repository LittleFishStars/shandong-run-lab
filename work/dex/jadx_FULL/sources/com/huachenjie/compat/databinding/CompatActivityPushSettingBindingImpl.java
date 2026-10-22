package com.huachenjie.compat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.Converters;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.compat.page.settings.PushSettingAdapter;
import com.huachenjie.compat.page.settings.PushSettingViewModel;
import com.noober.background.view.BLTextView;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class CompatActivityPushSettingBindingImpl extends CompatActivityPushSettingBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34059a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9182a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9183a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9188a;

    @NonNull
    public final LinearLayout b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View.OnClickListener f34060a;

        public a a(View.OnClickListener onClickListener) {
            this.f34060a = onClickListener;
            if (onClickListener == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34060a.onClick(view);
        }
    }

    public CompatActivityPushSettingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f9182a, f34059a));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00b1  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        PushSettingAdapter value;
        View.OnClickListener onClickListener;
        a aVarA;
        String str;
        Integer num;
        boolean zIsBackShow;
        int i;
        int i2;
        int background;
        int i3;
        View.OnClickListener rightTextClick;
        Integer backTintColor;
        float alpha;
        int titleTextColor;
        int statusBarHeight;
        int backIconResId;
        String titleName;
        View.OnClickListener backClick;
        synchronized (this) {
            j = this.f9183a;
            this.f9183a = 0L;
        }
        PushSettingViewModel pushSettingViewModel = ((CompatActivityPushSettingBinding) this).f9181a;
        float f = 0.0f;
        if ((15 & j) != 0) {
            if ((j & 13) != 0) {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = pushSettingViewModel != null ? pushSettingViewModel.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                BindingTitleBean value2 = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                if (value2 != null) {
                    titleName = value2.getTitleName();
                    titleTextColor = value2.getTitleTextColor();
                    backClick = value2.getBackClick();
                    rightTextClick = value2.getRightTextClick();
                    statusBarHeight = value2.getStatusBarHeight();
                    backIconResId = value2.getBackIconResId();
                    backTintColor = value2.getBackTintColor();
                    alpha = value2.getAlpha();
                    background = value2.getBackground();
                    zIsBackShow = value2.isBackShow();
                } else {
                    zIsBackShow = false;
                    titleTextColor = 0;
                    statusBarHeight = 0;
                    backIconResId = 0;
                    background = 0;
                    backClick = null;
                    rightTextClick = null;
                    backTintColor = null;
                    alpha = 0.0f;
                    titleName = null;
                }
                if (backClick != null) {
                    a aVar = this.f9187a;
                    if (aVar == null) {
                        aVar = new a();
                        this.f9187a = aVar;
                    }
                    aVarA = aVar.a(backClick);
                } else {
                    aVarA = null;
                }
            } else {
                aVarA = null;
                rightTextClick = null;
                backTintColor = null;
                alpha = 0.0f;
                zIsBackShow = false;
                titleTextColor = 0;
                statusBarHeight = 0;
                backIconResId = 0;
                background = 0;
                titleName = null;
            }
            if ((j & 14) == 0) {
                value = null;
            } else {
                MutableLiveData<PushSettingAdapter> mutableLiveDataL = pushSettingViewModel != null ? pushSettingViewModel.l() : null;
                updateLiveDataRegistration(1, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value = mutableLiveDataL.getValue();
                } else {
                    value = null;
                }
            }
            i2 = titleTextColor;
            onClickListener = rightTextClick;
            i3 = statusBarHeight;
            i = backIconResId;
            num = backTintColor;
            str = titleName;
            f = alpha;
        } else {
            value = null;
            onClickListener = null;
            aVarA = null;
            str = null;
            num = null;
            zIsBackShow = false;
            i = 0;
            i2 = 0;
            background = 0;
            i3 = 0;
        }
        if ((13 & j) != 0) {
            CommonBindingAdapter.c0(this.b, f);
            ViewBindingAdapter.setBackground(this.b, Converters.convertColorToDrawable(background));
            CommonBindingAdapter.O(this.b, 0, i3, 0, 0, null);
            TextViewBindingAdapter.setText(this.f9185a, str);
            this.f9185a.setTextColor(i2);
            CommonBindingAdapter.q(this.f9188a, onClickListener, null);
            DrawablesBindingAdapter.e(((CompatActivityPushSettingBinding) this).f34058a, i);
            CommonBindingAdapter.Y(((CompatActivityPushSettingBinding) this).f34058a, num);
            CommonBindingAdapter.l0(((CompatActivityPushSettingBinding) this).f34058a, zIsBackShow);
            CommonBindingAdapter.q(((CompatActivityPushSettingBinding) this).f34058a, aVarA, null);
        }
        if ((j & 14) != 0) {
            CommonBindingAdapter.g(this.f9186a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9183a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9183a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.CompatActivityPushSettingBinding
    public void k(@Nullable PushSettingViewModel pushSettingViewModel) {
        ((CompatActivityPushSettingBinding) this).f9181a = pushSettingViewModel;
        synchronized (this) {
            this.f9183a |= 4;
        }
        notifyPropertyChanged(wk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<PushSettingAdapter> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9183a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9183a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.p0 != i) {
            return false;
        }
        k((PushSettingViewModel) obj);
        return true;
    }

    public CompatActivityPushSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[2]);
        this.f9183a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9184a = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[1];
        this.b = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f9185a = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f9188a = bLTextView;
        bLTextView.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[5];
        this.f9186a = recyclerView;
        recyclerView.setTag(null);
        ((CompatActivityPushSettingBinding) this).f34058a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
