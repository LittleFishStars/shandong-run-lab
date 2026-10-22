package com.byazt.gn;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.byazt.jzl.a;
import com.byazt.jzl.tt;
import com.byazt.tq.ve;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1634, 20})
public class c extends MediaDataSource {
    public static final ConcurrentHashMap<String, c> c = new ConcurrentHashMap<>();
    public final a n;
    public final ve tt;
    public final Context uj;
    public long ve = -2147483648L;

    public c(Context context, tt ttVar, a aVar) {
        this.uj = context;
        this.n = aVar;
        this.tt = new com.byazt.tq.tt(context, ttVar, aVar);
    }

    public a c() {
        return this.n;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.byazt.lt.tt.c("SdkMediaDataSource", "close: ", this.n.getUrl());
        ve veVar = this.tt;
        if (veVar != null) {
            veVar.tt();
        }
        c.remove(this.n.getFileNameKey());
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        if (this.ve == -2147483648L) {
            if (this.uj == null || TextUtils.isEmpty(this.n.getUrl())) {
                return -1L;
            }
            this.ve = this.tt.ve();
            com.byazt.lt.tt.c("SdkMediaDataSource", "getSize: " + this.ve);
        }
        return this.ve;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        return this.tt.c(j, bArr, i, i2);
    }

    public static c c(Context context, tt ttVar, a aVar) {
        c cVar = new c(context, ttVar, aVar);
        c.put(aVar.getFileNameKey(), cVar);
        return cVar;
    }
}
