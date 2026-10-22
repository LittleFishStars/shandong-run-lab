package com.byazt.lz;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 601, 71})
public class x implements sp, Function {
    public volatile Function c;
    public volatile sp tt;

    public x(sp spVar) {
        this.tt = spVar;
    }

    public x(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return this.tt.getUserId();
            case 2:
                return this.tt.getChannel();
            case 3:
                return this.tt.getSubChannel();
            case 4:
                return Integer.valueOf(this.tt.getAge());
            case 5:
                return this.tt.getGender();
            case 6:
                return this.tt.getUserValueGroup();
            case 7:
                return this.tt.getCustomInfos();
            default:
                return null;
        }
    }

    @Override // com.byazt.lz.sp
    public int getAge() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.lz.sp
    public String getChannel() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.lz.sp
    public Map getCustomInfos() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (Map) this.c.apply(sparseArray);
    }

    @Override // com.byazt.lz.sp
    public String getGender() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.lz.sp
    public String getSubChannel() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.lz.sp
    public String getUserId() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.lz.sp
    public String getUserValueGroup() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (String) this.c.apply(sparseArray);
    }
}
