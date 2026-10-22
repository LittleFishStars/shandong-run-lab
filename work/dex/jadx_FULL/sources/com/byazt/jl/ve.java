package com.byazt.jl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.byazt.nr.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 157, 54})
public class ve extends x<com.byazt.on.c, com.byazt.on.tt> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f28700a = true;
    public final byte c;
    public List<n> n;
    public final byte tt;
    public List<n> uj;
    public byte[] ve;
    public static final byte[] z = {-119, 80, 78, 71, 13, 10, com.google.common.base.a.D, 10};
    public static final byte[] m = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
    public static final ThreadLocal<CRC32> nu = new ThreadLocal<>();

    public ve(com.byazt.on.c cVar, a aVar) {
        super(cVar);
        this.uj = new ArrayList();
        this.n = new ArrayList();
        this.c = aVar.yp;
        this.tt = aVar.u;
        int i = aVar.sl * 1000;
        short s = aVar.t;
        int i2 = i / (s == 0 ? (short) 100 : s);
        this.t = i2;
        if (i2 < 10) {
            this.t = 100;
        }
        this.x = aVar.ve;
        this.i = aVar.x;
        this.da = aVar.i;
        this.sl = aVar.da;
    }

    private CRC32 c() {
        ThreadLocal<CRC32> threadLocal = nu;
        CRC32 crc32 = threadLocal.get();
        if (crc32 != null) {
            return crc32;
        }
        CRC32 crc33 = new CRC32();
        threadLocal.set(crc33);
        return crc33;
    }

    private int c(com.byazt.on.tt ttVar) throws IOException {
        int i;
        Iterator<n> it = this.n.iterator();
        int i2 = 33;
        while (it.hasNext()) {
            i2 += it.next().uj + 12;
        }
        for (n nVar : this.uj) {
            if (nVar instanceof da) {
                i = nVar.uj + 12;
            } else if (nVar instanceof sp) {
                i = nVar.uj + 8;
            }
            i2 += i;
        }
        int length = i2 + m.length;
        ttVar.ve(length);
        ttVar.c(z);
        ttVar.tt(13);
        int iC = ttVar.c();
        ttVar.c(t.c);
        ttVar.tt(this.x);
        ttVar.tt(this.i);
        ttVar.c(this.ve);
        CRC32 crc32C = c();
        crc32C.reset();
        crc32C.update(ttVar.tt(), iC, 17);
        ttVar.tt((int) crc32C.getValue());
        for (n nVar2 : this.n) {
            if (!(nVar2 instanceof sl)) {
                ((com.byazt.on.c) this.sp).d_();
                ((com.byazt.on.c) this.sp).c(nVar2.sp);
                ((com.byazt.on.c) this.sp).c(ttVar.tt(), ttVar.c(), nVar2.uj + 12);
                ttVar.uj(nVar2.uj + 12);
            }
        }
        for (n nVar3 : this.uj) {
            if (nVar3 instanceof da) {
                ((com.byazt.on.c) this.sp).d_();
                ((com.byazt.on.c) this.sp).c(nVar3.sp);
                ((com.byazt.on.c) this.sp).c(ttVar.tt(), ttVar.c(), nVar3.uj + 12);
                ttVar.uj(nVar3.uj + 12);
            } else if (nVar3 instanceof sp) {
                ttVar.tt(nVar3.uj - 4);
                int iC2 = ttVar.c();
                ttVar.c(da.c);
                ((com.byazt.on.c) this.sp).d_();
                ((com.byazt.on.c) this.sp).c(nVar3.sp + 4 + 4 + 4);
                ((com.byazt.on.c) this.sp).c(ttVar.tt(), ttVar.c(), nVar3.uj - 4);
                ttVar.uj(nVar3.uj - 4);
                crc32C.reset();
                crc32C.update(ttVar.tt(), iC2, nVar3.uj);
                ttVar.tt((int) crc32C.getValue());
            }
        }
        ttVar.c(m);
        return length;
    }

    @Override // com.byazt.jl.x
    public Bitmap c(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.byazt.on.tt ttVar) {
        Bitmap bitmapDecodeByteArray;
        try {
            int iC = c(ttVar);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            options.inMutable = true;
            options.inBitmap = bitmap;
            byte[] bArrTt = ttVar.tt();
            try {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrTt, 0, iC, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrTt, 0, iC, options2);
            }
            if (!f28700a && bitmapDecodeByteArray == null) {
                throw new AssertionError();
            }
            Rect rect = this.u;
            rect.left = 0;
            rect.top = 0;
            rect.right = bitmapDecodeByteArray.getWidth();
            this.u.bottom = bitmapDecodeByteArray.getHeight();
            Rect rect2 = this.yp;
            int i2 = this.da;
            float f = i;
            rect2.left = (int) (i2 / f);
            rect2.top = (int) (this.sl / f);
            rect2.right = (int) ((i2 / f) + bitmapDecodeByteArray.getWidth());
            this.yp.bottom = (int) ((this.sl / f) + bitmapDecodeByteArray.getHeight());
            canvas.drawBitmap(bitmapDecodeByteArray, this.u, this.yp, paint);
            return bitmapDecodeByteArray;
        } catch (IOException e) {
            m.c(e);
            return null;
        }
    }
}
