package com.igexin.push.core.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.igexin.push.core.b.l;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.g.j;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b extends com.igexin.push.f.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38052a = 2;
    public static final int b = 8;
    public static final int c = 65557;
    private static final String d = "EXT-DownloadImgPlugin";
    private String n;
    private BaseActionBean o;
    private int p;
    private d q;
    private String r;

    public b(String str, String str2, String str3, BaseActionBean baseActionBean, int i, d dVar) {
        super(str);
        this.o = baseActionBean;
        this.n = str3;
        this.p = i;
        this.q = dVar;
        this.r = str2;
        this.l = false;
    }

    private void a(String str) {
        int i = this.p;
        if (i == 2) {
            ((l) this.o).D = str;
        } else {
            if (i != 8) {
                return;
            }
            ((l) this.o).E = str;
        }
    }

    private static void b() {
        File file = new File(j.f);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    @Override // com.igexin.push.f.a.d
    public final void a(Exception exc) {
        d dVar = this.q;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.igexin.push.f.a.d
    public final void a(byte[] bArr) {
        this.m = false;
        try {
            File file = new File(j.f);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = j.f + com.igexin.assist.util.a.a(this.r) + ".bin";
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (bitmapDecodeByteArray != null) {
                bitmapDecodeByteArray.compress(compressFormat, 100, fileOutputStream);
                fileOutputStream.close();
                bitmapDecodeByteArray.recycle();
                int i = this.p;
                if (i == 2) {
                    ((l) this.o).D = str;
                } else if (i == 8) {
                    ((l) this.o).E = str;
                }
                this.m = true;
            } else {
                fileOutputStream.close();
                this.m = false;
            }
            d dVar = this.q;
            if (dVar != null) {
                if (this.m) {
                    dVar.a(this.o);
                } else {
                    new Exception("no target existed or downloading bitmap failed!");
                    dVar.a();
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return c;
    }
}
