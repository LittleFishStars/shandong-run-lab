package com.aliyun.svideosdk.common.impl;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.aliyun.svideosdk.common.AliyunIThumbnailFetcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected e f25632a = new e();
    protected int b = 0;
    protected ConcurrentHashMap<Long, List<C0219a>> c = new ConcurrentHashMap<>();
    protected List<Bitmap> d = Collections.synchronizedList(new ArrayList());
    protected Set<List<Long>> e = new HashSet();
    Handler f = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.aliyun.svideosdk.common.impl.a$a, reason: collision with other inner class name */
    public class C0219a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f25633a;
        AliyunIThumbnailFetcher.OnThumbnailCompletion b;
        long c;

        public C0219a(a aVar, long j, AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion, long j2) {
            this.f25633a = j;
            this.b = onThumbnailCompletion;
            this.c = j2;
        }
    }

    public abstract int a(int i, int i2, int i3, int i4, int i5);

    public int a(long j) {
        for (List<Long> list : this.e) {
            if (list.contains(Long.valueOf(j))) {
                return list.indexOf(Long.valueOf(j));
            }
        }
        return -1;
    }

    public abstract int a(long j, List<Long> list, AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion, long j2);

    public abstract int a(String str);

    public e a() {
        return this.f25632a;
    }

    public String a(long j, int i, int i2) {
        return j + LoginConstants.UNDER_LINE + i + LoginConstants.UNDER_LINE + i2;
    }

    public List<C0219a> a(Long l) {
        List<C0219a> listRemove;
        synchronized (this.c) {
            listRemove = this.c.remove(l);
        }
        return listRemove;
    }

    public void a(Long l, C0219a c0219a) {
        synchronized (this.c) {
            List<C0219a> arrayList = this.c.get(l);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.c.put(l, arrayList);
            }
            arrayList.add(c0219a);
        }
    }

    public void a(long[] jArr) {
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        this.e.add(arrayList);
    }

    public boolean b() {
        return this.b >= 2;
    }

    public boolean c() {
        return this.b >= 3;
    }

    public int d() {
        for (Bitmap bitmap : this.d) {
            try {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            } catch (Throwable th) {
                Log.e("AliYunLog", "Recycle bitmap[" + bitmap + "] failed!", th);
            }
        }
        this.d.clear();
        this.e.clear();
        synchronized (this.c) {
            this.c.clear();
        }
        return 0;
    }

    public abstract int e();
}
