package com.aliyun.svideosdk.common.impl;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {
    private static int g = 17;
    private static int h = -17;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f25647a;
    private final int b;
    private com.aliyun.svideosdk.common.b.e.a<String> c;
    private volatile boolean d;
    private a e;
    private String f;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String strA;
            super.handleMessage(message);
            if (message.what != g.this.f25647a) {
                if (message.what == g.this.b) {
                    g.this.c.a();
                    com.aliyun.common.utils.g.c(new File(g.this.f));
                    g.this.e = null;
                    return;
                }
                return;
            }
            Bitmap bitmap = (Bitmap) message.obj;
            if (bitmap.isRecycled()) {
                return;
            }
            String string = message.getData().getString("time_key");
            if (!g.this.d && !TextUtils.isEmpty(string) && (strA = g.this.c.a(String.valueOf(string), bitmap)) != null && string != null) {
                g.this.c.a(string, strA);
            }
            bitmap.recycle();
        }
    }

    public g(String str, Looper looper) {
        int i = g;
        g = i + 1;
        this.f25647a = i;
        int i2 = h;
        h = i2 - 1;
        this.b = i2;
        this.c = null;
        this.d = false;
        this.f = str;
        this.c = new com.aliyun.svideosdk.common.b.e.a<>(str);
        a();
        this.e = new a(looper);
    }

    private void a() {
        File[] fileArrListFiles;
        File file = new File(this.f);
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            try {
                this.c.a(file2.getName(), file2.getAbsolutePath());
            } catch (Exception unused) {
            }
        }
    }

    public Bitmap a(String str) {
        com.aliyun.svideosdk.common.b.e.a<String> aVar = this.c;
        if (aVar != null) {
            return aVar.b(str);
        }
        return null;
    }

    public void a(Bitmap bitmap, String str) {
        if (bitmap == null) {
            return;
        }
        if (!this.d && this.c.a(str)) {
            bitmap.recycle();
            return;
        }
        if (this.e != null) {
            Bundle bundle = new Bundle();
            bundle.putString("time_key", str);
            Message messageObtainMessage = this.e.obtainMessage(this.f25647a);
            messageObtainMessage.obj = bitmap;
            messageObtainMessage.setData(bundle);
            this.e.sendMessage(messageObtainMessage);
        }
    }

    public void b() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.sendEmptyMessage(this.b);
        }
        this.d = true;
    }
}
