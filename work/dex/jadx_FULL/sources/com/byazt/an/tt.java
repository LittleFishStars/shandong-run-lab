package com.byazt.an;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1270, 13})
public abstract class tt {
    public final DataSetObservable c = new DataSetObservable();
    public DataSetObserver tt;

    public float c(int i) {
        return 1.0f;
    }

    public abstract int c();

    public int c(Object obj) {
        return -1;
    }

    public Object c(ViewGroup viewGroup, int i) {
        return c((View) viewGroup, i);
    }

    public abstract boolean c(View view, Object obj);

    public Parcelable tt() {
        return null;
    }

    public void ve() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.tt;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.c.notifyChanged();
    }

    public void c(ViewGroup viewGroup, int i, Object obj) {
        c((View) viewGroup, i, obj);
    }

    @Deprecated
    public Object c(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void c(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.tt = dataSetObserver;
        }
    }
}
