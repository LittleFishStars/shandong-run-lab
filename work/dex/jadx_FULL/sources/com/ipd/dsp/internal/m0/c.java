package com.ipd.dsp.internal.m0;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends IOException {
    public static final c f = new a();

    public class a extends c {
        public a() {
            super(null);
        }

        @Override // java.lang.Throwable
        public void printStackTrace() {
            throw new IllegalAccessError("Stack is ignored for signal");
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public c() {
        super("Interrupted");
    }
}
