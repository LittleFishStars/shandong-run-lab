package com.baidu.mshield.x0.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x0.d.h.b;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ReceiverWork extends BroadcastReceiver {

    public class a extends b {
        public final /* synthetic */ Context b;
        public final /* synthetic */ Intent c;

        public a(ReceiverWork receiverWork, Context context, Intent intent) {
            this.b = context;
            this.c = intent;
        }

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
            ReceiverWork.b(this.b, this.c);
            ReceiverWork.a(this.b, this.c);
        }
    }

    public static void a(Context context, Intent intent) {
        try {
            if (EngineImpl.isUnload || intent == null || !"com.baidu.mshield.x0.alarm.action".equals(intent.getAction())) {
                return;
            }
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
            long jB = ((long) com.baidu.mshield.x0.d.b.b(context)) * 60000;
            aVar.e(System.currentTimeMillis() + jB);
            com.baidu.mshield.x0.d.b.a(context, jB);
            List<com.baidu.mshield.x0.d.a> listA = com.baidu.mshield.x0.f.a.a(context).a();
            long jCurrentTimeMillis = System.currentTimeMillis() + 300000;
            for (com.baidu.mshield.x0.d.a aVar2 : listA) {
                com.baidu.mshield.b.c.a.b("rec t:" + d.a(aVar2.c, "yyyy-MM-dd HH:mm:ss") + " ac:" + aVar2.f26734a);
                if (jCurrentTimeMillis >= aVar2.c) {
                    com.baidu.mshield.x0.k.a.a(context, aVar2.f26734a);
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void b(Context context, Intent intent) {
        if (EngineImpl.isUnload) {
            return;
        }
        com.baidu.mshield.x0.k.a.a(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.mshield.x0.d.h.d.b().a(new a(this, context, intent));
    }
}
