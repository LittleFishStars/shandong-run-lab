package com.zj.adlib;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class a62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f40455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u52 f15155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z52 f15156a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f40456a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public y52 f15157a;
    }

    public static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f40457a = 100;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public a62 f15158a;

        public b(a62 danMuProducer) {
            this.f15158a = danMuProducer;
            obtainMessage(1).sendToTarget();
        }

        public void a() {
            a62 a62Var = this.f15158a;
            if (a62Var != null) {
                if (a62Var.f15156a != null) {
                    this.f15158a.f15156a.b();
                }
                this.f15158a = null;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            ArrayList<y52> arrayListC;
            a62 a62Var;
            super.handleMessage(msg);
            int i = msg.what;
            if (i != 1) {
                if (i == 2 && (a62Var = this.f15158a) != null) {
                    Object obj = msg.obj;
                    if (obj instanceof a) {
                        a aVar = (a) obj;
                        a62Var.f15156a.a(aVar.f40456a, aVar.f15157a);
                        return;
                    }
                    return;
                }
                return;
            }
            a62 a62Var2 = this.f15158a;
            if (a62Var2 == null || a62Var2.f15155a == null) {
                return;
            }
            if (this.f15158a.f15156a != null && (arrayListC = this.f15158a.f15156a.c(this.f15158a.f15155a.e())) != null) {
                this.f15158a.f15155a.l(arrayListC);
            }
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.what = 1;
            sendMessageDelayed(messageObtainMessage, 100L);
        }
    }

    public a62(z52 danMuProducedPool, u52 danMuSharedPool) {
        this.f15155a = danMuSharedPool;
        this.f15156a = danMuProducedPool;
    }

    public void c(List<y52> danMuViews) {
        this.f15156a.f(danMuViews);
    }

    public void d(int index, y52 danMuView) {
        if (this.f40455a != null) {
            a aVar = new a();
            aVar.f40456a = index;
            aVar.f15157a = danMuView;
            Message messageObtainMessage = this.f40455a.obtainMessage();
            messageObtainMessage.obj = aVar;
            messageObtainMessage.what = 2;
            this.f40455a.sendMessage(messageObtainMessage);
        }
    }

    public void e() {
        this.f15155a = null;
        b bVar = this.f40455a;
        if (bVar != null) {
            bVar.removeMessages(1);
            this.f40455a.a();
        }
    }

    public void f() {
        this.f40455a = new b(this);
    }
}
