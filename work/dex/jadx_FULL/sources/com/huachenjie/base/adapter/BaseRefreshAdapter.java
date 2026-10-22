package com.huachenjie.base.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.base.R;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Deprecated
public abstract class BaseRefreshAdapter<T, VH extends BaseViewHolder> extends BaseQuickAdapter<T, VH> {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f32760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6926a;
    public View b;
    public View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f6927c;
    public boolean d;

    public BaseRefreshAdapter(int layoutResId) {
        super(layoutResId);
        this.f6926a = false;
        this.f6927c = false;
        this.d = false;
        this.K = R.layout.layout_empty_data;
    }

    private View g() {
        if (getRecyclerViewOrNull() == null) {
            this.f6926a = true;
            return null;
        }
        if (this.f32760a == null) {
            this.f32760a = LayoutInflater.from(getContext()).inflate(f(), (ViewGroup) null);
        }
        return this.f32760a;
    }

    public int f() {
        return this.K;
    }

    public int h() {
        return 0;
    }

    public final View i() {
        if (h() == 0) {
            return null;
        }
        if (getRecyclerViewOrNull() == null) {
            this.d = true;
            return null;
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getContext()).inflate(h(), (ViewGroup) null);
        }
        return this.c;
    }

    public int j() {
        return 0;
    }

    public final View k() {
        if (j() == 0) {
            return null;
        }
        if (getRecyclerViewOrNull() == null) {
            this.f6927c = true;
            return null;
        }
        if (this.b == null) {
            this.b = LayoutInflater.from(getContext()).inflate(j(), (ViewGroup) null);
        }
        return this.b;
    }

    public void l() {
        this.f6926a = false;
        removeEmptyView();
    }

    public void m() {
        this.d = false;
        if (i() != null) {
            removeAllHeaderView();
        }
    }

    public void n() {
        this.f6927c = false;
        if (k() != null) {
            removeAllHeaderView();
        }
    }

    public void o(int layoutId) {
        this.K = layoutId;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.f6926a) {
            this.f6926a = false;
            p();
        }
        if (this.f6927c) {
            this.f6927c = false;
            r();
        }
        if (this.d) {
            this.d = false;
            q();
        }
    }

    public void p() {
        if (hasEmptyView() || g() == null) {
            return;
        }
        setEmptyView(g());
    }

    public void q() {
        if (i() != null) {
            setFooterView(i());
        }
    }

    public void r() {
        if (k() != null) {
            setHeaderView(k());
        }
    }

    public BaseRefreshAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
        this.f6926a = false;
        this.f6927c = false;
        this.d = false;
        this.K = R.layout.layout_empty_data;
    }
}
