package com.byazt.dna;

import android.content.Context;
import android.os.Looper;
import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, 512})
public class d implements h, Function {
    public volatile Function c;
    public volatile h tt;

    public d(h hVar) {
        this.tt = hVar;
    }

    public d(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Function function;
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.tt != null ? this.tt : this.c;
        }
        if (iIntValue == -4 && (function = (Function) sparseArray.get(1)) != null) {
            this.tt = null;
            this.c = function;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // com.byazt.dna.h
    public com.byazt.fk.sp createTTLiveVideoPlayer(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        ?? iVar;
        if (this.tt != null) {
            return this.tt.createTTLiveVideoPlayer(context, z, j, jSONObject, looper);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, Boolean.valueOf(z));
        sparseArray.put(3, Long.valueOf(j));
        sparseArray.put(4, jSONObject);
        sparseArray.put(5, looper);
        ?? Apply = this.c.apply(sparseArray);
        if (Apply != 0) {
            iVar = Apply;
            iVar = new com.byazt.fk.i((Function) Apply);
        }
        iVar = Apply;
        return (com.byazt.fk.sp) iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @Override // com.byazt.dna.h
    public com.byazt.fk.sp createTTVideoPlayer(Context context, String str) {
        ?? iVar;
        if (this.tt != null) {
            return this.tt.createTTVideoPlayer(context, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, context);
        sparseArray.put(2, str);
        ?? Apply = this.c.apply(sparseArray);
        if (Apply != 0) {
            iVar = Apply;
            iVar = new com.byazt.fk.i((Function) Apply);
        }
        iVar = Apply;
        return (com.byazt.fk.sp) iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.dna.h
    public com.byazt.fk.c createVideoCacheDir() {
        ?? ttVar;
        if (this.tt != null) {
            return this.tt.createVideoCacheDir();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        ?? Apply = this.c.apply(sparseArray);
        if (Apply != 0) {
            ttVar = Apply;
            ttVar = new com.byazt.fk.tt((Function) Apply);
        }
        ttVar = Apply;
        return (com.byazt.fk.c) ttVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.dna.h
    public com.byazt.fk.da createVideoPreload() {
        ?? tVar;
        if (this.tt != null) {
            return this.tt.createVideoPreload();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        ?? Apply = this.c.apply(sparseArray);
        if (Apply != 0) {
            tVar = Apply;
            tVar = new com.byazt.fk.t((Function) Apply);
        }
        tVar = Apply;
        return (com.byazt.fk.da) tVar;
    }

    @Override // com.byazt.dna.h
    public int getLiveSupportCode() {
        if (this.tt != null) {
            return this.tt.getLiveSupportCode();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.h
    public boolean isTTVideoOk() {
        if (this.tt != null) {
            return this.tt.isTTVideoOk();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.h
    public void openDebugLog(boolean z) {
        if (this.tt != null) {
            this.tt.openDebugLog(z);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, Boolean.valueOf(z));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.h
    public void preloadTTVideo(Context context, String str, int i, String[] strArr, long[] jArr, boolean z) {
        if (this.tt != null) {
            this.tt.preloadTTVideo(context, str, i, strArr, jArr, z);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, context);
        sparseArray.put(2, str);
        sparseArray.put(3, Integer.valueOf(i));
        sparseArray.put(4, strArr);
        sparseArray.put(5, jArr);
        sparseArray.put(6, Boolean.valueOf(z));
        this.c.apply(sparseArray);
    }
}
