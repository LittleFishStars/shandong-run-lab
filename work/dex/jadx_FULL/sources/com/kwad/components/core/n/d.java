package com.kwad.components.core.n;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class d<T extends com.kwad.sdk.mvp.a> extends KSFrameLayout {
    public T abm;
    public Presenter mPresenter;
    protected ViewGroup oC;

    public d(Context context) {
        this(context, null);
    }

    private void initMVP() {
        this.abm = (T) an();
        com.kwad.sdk.core.d.c.w("jky", this + " BaseMVPView initMVP mCallerContext: " + this.abm);
        if (this.mPresenter == null) {
            this.mPresenter = onCreatePresenter();
            com.kwad.sdk.core.d.c.w("jky", this + " BaseMVPView initMVP mPresenter: " + this.mPresenter + ", mContainerView: + " + this.oC);
            this.mPresenter.N(this.oC);
        }
        this.mPresenter.q(this.abm);
    }

    public abstract void a(@NonNull ViewGroup viewGroup);

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ae() {
        super.ae();
        com.kwad.sdk.core.d.c.w("jky", this + " BaseMVPView onViewAttached");
        initMVP();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void af() {
        super.af();
        T t = this.abm;
        if (t != null) {
            t.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public boolean al() {
        return false;
    }

    public abstract T an();

    @LayoutRes
    public abstract int getLayoutId();

    public abstract void initData();

    @NonNull
    public abstract Presenter onCreatePresenter();

    public final void tp() {
        com.kwad.sdk.core.d.c.w("jky", this + " BaseMVPView createView");
        initData();
        if (getLayoutId() > 0) {
            this.oC = (ViewGroup) m.inflate(getContext(), getLayoutId(), this);
        } else {
            this.oC = tq();
        }
        a(this.oC);
    }

    public ViewGroup tq() {
        return null;
    }

    private d(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        com.kwad.sdk.core.d.c.w("jky", this + " BaseMVPView init createOnChild: " + al());
        if (al()) {
            return;
        }
        tp();
    }
}
