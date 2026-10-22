package com.byazt.dna;

import android.os.Handler;
import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, 577})
public class pf implements qp, Function {
    public volatile Function c;
    public volatile qp tt;

    public pf(qp qpVar) {
        this.tt = qpVar;
    }

    public pf(Function function) {
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

    @Override // com.byazt.dna.qp
    public void executeFastTask(Runnable runnable) {
        if (this.tt != null) {
            this.tt.executeFastTask(runnable);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, runnable);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public void executeFastTask(Runnable runnable, int i) {
        if (this.tt != null) {
            this.tt.executeFastTask(runnable, i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, runnable);
        sparseArray.put(2, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public void executeNormalTask(Runnable runnable) {
        if (this.tt != null) {
            this.tt.executeNormalTask(runnable);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, runnable);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public ExecutorService getAIDLExecutor() {
        if (this.tt != null) {
            return this.tt.getAIDLExecutor();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (ExecutorService) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public Handler getCsjMainHandler() {
        if (this.tt != null) {
            return this.tt.getCsjMainHandler();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (Handler) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public ExecutorService getFastExecutor() {
        if (this.tt != null) {
            return this.tt.getFastExecutor();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (ExecutorService) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public Handler getIOHandler() {
        if (this.tt != null) {
            return this.tt.getIOHandler();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (Handler) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public ExecutorService getIoExecutor() {
        if (this.tt != null) {
            return this.tt.getIoExecutor();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (ExecutorService) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public Handler getMainHandler() {
        if (this.tt != null) {
            return this.tt.getMainHandler();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (Handler) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public ExecutorService getNormalExecutor() {
        if (this.tt != null) {
            return this.tt.getNormalExecutor();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (ExecutorService) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public ScheduledExecutorService getScheduledThreadPool() {
        if (this.tt != null) {
            return this.tt.getScheduledThreadPool();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (ScheduledExecutorService) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public ExecutorService newCachedThreadPool(int i, int i2) {
        if (this.tt != null) {
            return this.tt.newCachedThreadPool(i, i2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        return (ExecutorService) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public Handler obtainHandler(qp.c cVar, String str) {
        if (this.tt != null) {
            return this.tt.obtainHandler(cVar, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        if (cVar != null) {
            cVar = new nb(cVar);
        }
        sparseArray.put(1, cVar);
        sparseArray.put(2, str);
        return (Handler) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public Handler obtainHandler(String str) {
        if (this.tt != null) {
            return this.tt.obtainHandler(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, str);
        return (Handler) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public void postIOTask(Runnable runnable) {
        if (this.tt != null) {
            this.tt.postIOTask(runnable);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        sparseArray.put(1, runnable);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public void recycleHandler(Handler handler) {
        if (this.tt != null) {
            this.tt.recycleHandler(handler);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, handler);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.qp
    public void updateSettings(JSONObject jSONObject) {
        if (this.tt != null) {
            this.tt.updateSettings(jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, jSONObject);
        this.c.apply(sparseArray);
    }
}
