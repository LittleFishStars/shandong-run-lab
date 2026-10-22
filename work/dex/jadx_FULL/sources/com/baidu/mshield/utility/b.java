package com.baidu.mshield.utility;

import android.content.Context;
import android.os.Message;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Lock f26723a = new ReentrantLock();
    public static b b = null;
    public com.baidu.mshield.rp.f.a c;

    public b(Context context) {
        this.c = new com.baidu.mshield.rp.f.a(context);
    }

    public static b a(Context context) {
        b bVar = b;
        if (bVar != null) {
            return bVar;
        }
        try {
            f26723a.lock();
            if (b == null) {
                b = new b(context);
            }
            return b;
        } finally {
            f26723a.unlock();
        }
    }

    public void b() {
        this.c.e();
    }

    public void c() {
        Message message = new Message();
        message.what = 6;
        this.c.a(message);
    }

    public void d() {
        Message message = new Message();
        message.what = 2;
        this.c.a(message);
    }

    public void e() {
        Message message = new Message();
        message.what = 8;
        this.c.a(message);
    }

    public void a(boolean z) {
        this.c.a(z);
    }

    public void a(com.baidu.mshield.rp.d.a aVar) {
        Message message = new Message();
        message.what = 1;
        message.obj = aVar;
        this.c.a(message);
    }

    public void a(com.baidu.mshield.rp.b.a aVar) {
        Message message = new Message();
        message.what = 3;
        message.obj = aVar;
        this.c.a(message);
    }

    public void a(String str) {
        Message message = new Message();
        message.what = 11;
        message.obj = str;
        this.c.a(message);
    }

    public void a() {
        Message message = new Message();
        message.what = 9;
        this.c.a(message);
    }
}
