package com.byazt.xiv;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1883, 15})
public class uj implements ve, Function {
    public volatile Function c;
    public volatile ve tt;

    public uj(ve veVar) {
        this.tt = veVar;
    }

    public uj(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.tt.getInitBridge();
            case 2:
                return this.tt.getClassName();
            case 3:
                return this.tt.getAdnVersionListKey();
            case 4:
                return this.tt.getAdnVersion();
            case 5:
                this.tt.saveManager((Function) sparseArray.get(1));
                return null;
            case 6:
                return this.tt.getManager();
            case 7:
                this.tt.saveUnSupportVersion((String) sparseArray.get(1));
                return null;
            case 8:
                return this.tt.getUnSupportVersion();
            case 9:
                return this.tt.getAdnName();
            default:
                return null;
        }
    }

    @Override // com.byazt.xiv.ve
    public String getAdnName() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.xiv.ve
    public String getAdnVersion() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.xiv.ve
    public String getAdnVersionListKey() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.xiv.ve
    public String getClassName() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.xiv.ve
    public Function getInitBridge() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (Function) this.c.apply(sparseArray);
    }

    @Override // com.byazt.xiv.ve
    public Function getManager() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (Function) this.c.apply(sparseArray);
    }

    @Override // com.byazt.xiv.ve
    public String getUnSupportVersion() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.xiv.ve
    public void saveManager(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, function);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.xiv.ve
    public void saveUnSupportVersion(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }
}
