package com.byazt.yj;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1197, 67})
public class u implements t, Function {
    public volatile Function c;
    public volatile t tt;

    public u(t tVar) {
        this.tt = tVar;
    }

    public u(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Boolean.valueOf(this.tt.cancelRequest());
            case 2:
                return this.tt.getUrl();
            case 3:
                return Integer.valueOf(this.tt.getWidth());
            case 4:
                return Integer.valueOf(this.tt.getHeight());
            case 5:
                return this.tt.getScaleType();
            case 6:
                return this.tt.getRawCacheKey();
            case 7:
                return this.tt.getMemoryCacheKey();
            case 8:
                return this.tt.getBitmapConfig();
            default:
                return null;
        }
    }

    @Override // com.byazt.yj.t
    public boolean cancelRequest() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.yj.t
    public Bitmap.Config getBitmapConfig() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (Bitmap.Config) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.t
    public int getHeight() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.yj.t
    public String getMemoryCacheKey() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.t
    public String getRawCacheKey() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.t
    public ImageView.ScaleType getScaleType() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (ImageView.ScaleType) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.t
    public String getUrl() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.t
    public int getWidth() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }
}
