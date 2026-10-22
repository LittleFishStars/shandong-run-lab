package com.byazt.ji;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.byazt.pm.sl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 222, 42})
public class i extends tt implements com.byazt.cd.i.c {
    public int sl;
    public boolean t;
    public Handler u;

    public i(Context context) {
        super(context);
        this.sl = 500;
        this.u = new com.byazt.cd.i(Looper.getMainLooper(), this);
    }

    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        Object obj = this.n.get("delay");
        if (obj == null) {
            this.sl = 500;
        } else {
            this.sl = com.byazt.cd.ve.c(String.valueOf(obj), 500);
        }
        return c(this.tt, motionEvent);
    }

    private boolean c(com.byazt.xj.ve veVar, MotionEvent motionEvent) {
        sl slVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.u.sendEmptyMessageDelayed(1102, this.sl);
        } else {
            if (action == 1) {
                if (this.t && (slVar = this.c) != null) {
                    slVar.c(this.tt, this.f28697a, this.ve.tt(), this.ve);
                    this.t = false;
                    Handler handler = this.u;
                    if (handler != null) {
                        handler.removeMessages(1102);
                    }
                    return true;
                }
                Handler handler2 = this.u;
                if (handler2 != null) {
                    handler2.removeMessages(1102);
                }
                this.t = false;
                return false;
            }
            if (action == 3) {
                Handler handler3 = this.u;
                if (handler3 != null) {
                    handler3.removeMessages(1102);
                }
                this.t = false;
            }
        }
        return true;
    }

    @Override // com.byazt.cd.i.c
    public void c(Message message) {
        if (message.what != 1102) {
            return;
        }
        this.t = true;
        Handler handler = this.u;
        if (handler != null) {
            handler.removeMessages(1102);
        }
    }
}
