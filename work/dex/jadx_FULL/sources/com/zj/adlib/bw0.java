package com.zj.adlib;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class bw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public int f40850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public long f15651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ResourceReleaser<Bitmap> f15652a;
    public final int b;
    public final int c;

    public class a implements ResourceReleaser<Bitmap> {
        public a() {
        }

        @Override // com.facebook.common.references.ResourceReleaser
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Bitmap bitmap) {
            try {
                bw0.this.b(bitmap);
            } finally {
                bitmap.recycle();
            }
        }
    }

    public bw0(int i, int i2) {
        ax6.d(i > 0);
        ax6.d(i2 > 0);
        this.b = i;
        this.c = i2;
        this.f15652a = new a();
    }

    public List<rm1<Bitmap>> a(List<Bitmap> list) {
        int i = 0;
        while (i < list.size()) {
            try {
                if (!f(list.get(i))) {
                    throw new TooManyBitmapsException();
                }
                i++;
            } catch (Exception e) {
                if (list != null) {
                    for (Bitmap bitmap : list) {
                        int i2 = i - 1;
                        if (i > 0) {
                            b(bitmap);
                        }
                        bitmap.recycle();
                        i = i2;
                    }
                }
                throw i69.d(e);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Bitmap> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(rm1.J(it.next(), this.f15652a));
        }
        return arrayList;
    }

    public synchronized void b(Bitmap bitmap) {
        int iE = qw0.e(bitmap);
        ax6.e(this.f40850a > 0, "No bitmaps registered.");
        long j = iE;
        ax6.f(j <= this.f15651a, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(iE), Long.valueOf(this.f15651a));
        this.f15651a -= j;
        this.f40850a--;
    }

    public synchronized int c() {
        return this.f40850a;
    }

    public ResourceReleaser<Bitmap> d() {
        return this.f15652a;
    }

    public synchronized long e() {
        return this.f15651a;
    }

    public synchronized boolean f(Bitmap bitmap) {
        int iE = qw0.e(bitmap);
        int i = this.f40850a;
        if (i < this.b) {
            long j = this.f15651a;
            long j2 = iE;
            if (j + j2 <= this.c) {
                this.f40850a = i + 1;
                this.f15651a = j + j2;
                return true;
            }
        }
        return false;
    }
}
