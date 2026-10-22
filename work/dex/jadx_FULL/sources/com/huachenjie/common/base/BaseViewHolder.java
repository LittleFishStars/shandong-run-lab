package com.huachenjie.common.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseViewHolder<D> extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f33643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnItemClickListener f8501a;

    public interface OnItemClickListener {
        void a(View view, int position);
    }

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.f33643a = itemView.getContext();
    }

    public abstract void a(Context context, D data);

    public void b(Context context, D data, Object payload) {
    }

    public BaseViewHolder c(int viewId, int resId) {
        findViewById(viewId).setBackgroundResource(resId);
        return this;
    }

    public BaseViewHolder d(int viewId, View.OnClickListener listener) {
        findViewById(viewId).setOnClickListener(listener);
        return this;
    }

    public BaseViewHolder e(int viewId, String value) {
        ((TextView) findViewById(viewId)).setText(value);
        return this;
    }

    public void f(int viewId, int color) {
        ((TextView) findViewById(viewId)).setTextColor(color);
    }

    public <T extends View> T findViewById(int i) {
        return (T) this.itemView.findViewById(i);
    }

    public void g(int viewId, int size) {
        ((TextView) findViewById(viewId)).setTextSize(size);
    }

    public int getColor(@ColorRes int id) {
        return this.f33643a.getResources().getColor(id);
    }

    public Drawable getDrawable(@DrawableRes int id) {
        return this.f33643a.getResources().getDrawable(id);
    }

    public Resources getResources() {
        return this.f33643a.getResources();
    }

    public String getString(@StringRes int id) {
        return this.f33643a.getResources().getString(id);
    }

    public void h(int viewId, int visibility) {
        findViewById(viewId).setVisibility(visibility);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnItemClickListener onItemClickListener = this.f8501a;
        if (onItemClickListener != null) {
            onItemClickListener.a(view, getAdapterPosition());
        }
    }

    public void setOnItemClickListener(OnItemClickListener myItemClickListener) {
        this.f8501a = myItemClickListener;
    }
}
