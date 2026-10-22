package com.byazt.jg;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 2152, 13})
public class tt implements c, Function {
    public volatile Function c;
    public volatile c tt;

    public tt(c cVar) {
        this.tt = cVar;
    }

    public tt(Function function) {
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

    @Override // com.byazt.jg.c
    public void changeLogLevel(int i) {
        if (this.tt != null) {
            this.tt.changeLogLevel(i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void d(String str, String str2) {
        if (this.tt != null) {
            this.tt.d(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void destroy() {
        if (this.tt != null) {
            this.tt.destroy();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void e(String str, String str2) {
        if (this.tt != null) {
            this.tt.e(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void e(String str, String str2, Throwable th) {
        if (this.tt != null) {
            this.tt.e(str, str2, th);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, th);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void e(String str, Throwable th) {
        if (this.tt != null) {
            this.tt.e(str, th);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, str);
        sparseArray.put(2, th);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void execCloudManagerSafely() {
        if (this.tt != null) {
            this.tt.execCloudManagerSafely();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void fetchCommand() {
        if (this.tt != null) {
            this.tt.fetchCommand();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void i(String str, String str2) {
        if (this.tt != null) {
            this.tt.i(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void initCLog(Context context, JSONObject jSONObject) {
        if (this.tt != null) {
            this.tt.initCLog(context, jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, jSONObject);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void initCloudMessageManager(Context context, String str, String str2) {
        if (this.tt != null) {
            this.tt.initCloudMessageManager(context, str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, context);
        sparseArray.put(2, str);
        sparseArray.put(3, str2);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void setOuterExecutorService(ScheduledExecutorService scheduledExecutorService) {
        if (this.tt != null) {
            this.tt.setOuterExecutorService(scheduledExecutorService);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, scheduledExecutorService);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void setUploadHost(String str) {
        if (this.tt != null) {
            this.tt.setUploadHost(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void v(String str, String str2) {
        if (this.tt != null) {
            this.tt.v(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void w(String str, String str2) {
        if (this.tt != null) {
            this.tt.w(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void w(String str, String str2, Throwable th) {
        if (this.tt != null) {
            this.tt.w(str, str2, th);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, th);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.jg.c
    public void w(String str, Throwable th) {
        if (this.tt != null) {
            this.tt.w(str, th);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, str);
        sparseArray.put(2, th);
        this.c.apply(sparseArray);
    }
}
