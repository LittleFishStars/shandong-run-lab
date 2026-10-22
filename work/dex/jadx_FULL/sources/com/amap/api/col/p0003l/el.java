package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.zj.adlib.a7b;
import com.zj.adlib.p4b;
import com.zj.adlib.pwa;
import com.zj.adlib.qwb;
import com.zj.adlib.twa;
import com.zj.adlib.ywa;
import com.zj.adlib.zwa;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class el extends View {
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f25931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f825a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f826a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f828a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Bitmap f829b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f830b;
    public Bitmap c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f831c;
    public Bitmap d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f832d;
    public Bitmap e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f833e;
    public Bitmap f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f834f;
    public Bitmap g;

    public class a extends it {
        public a() {
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            el.this.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME, 0);
            el.this.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME, 1);
            if ("".equals(pwa.b(el.this.f825a, "amap_web_logo", "md5_day", ""))) {
                if (el.this.c == null || el.this.d == null) {
                    pwa.c(el.this.f825a, "amap_web_logo", "md5_day", "0b718b5f291b09d2b62be725dfb977b3");
                    pwa.c(el.this.f825a, "amap_web_logo", "md5_night", "4b1405462a5c910de0e0723ffd96c018");
                    return;
                }
                pwa.c(el.this.f825a, "amap_web_logo", "md5_day", p4b.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME));
                String strA = p4b.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME);
                if (!"".equals(strA)) {
                    pwa.c(el.this.f825a, "amap_web_logo", "md5_night", strA);
                }
                el.this.d(true);
            }
        }
    }

    public el(Context context) {
        InputStream inputStream;
        super(context);
        this.f827a = new Paint();
        this.f828a = false;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 10;
        this.O = 0;
        this.P = 0;
        this.Q = 10;
        this.R = 8;
        this.f830b = false;
        this.f831c = false;
        this.f832d = true;
        this.f25931a = 0.0f;
        this.b = 0.0f;
        this.f833e = true;
        this.f834f = false;
        InputStream inputStreamOpen = null;
        try {
            this.f825a = context.getApplicationContext();
            InputStream inputStreamOpen2 = twa.b(context).open("ap.data");
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen2);
                this.f = bitmapDecodeStream;
                this.f826a = zwa.m(bitmapDecodeStream, qwb.f44317a);
                inputStreamOpen2.close();
                inputStreamOpen = twa.b(context).open("ap1.data");
                Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(inputStreamOpen);
                this.g = bitmapDecodeStream2;
                this.f829b = zwa.m(bitmapDecodeStream2, qwb.f44317a);
                inputStreamOpen.close();
                this.L = this.f829b.getWidth();
                this.K = this.f829b.getHeight();
                this.f827a.setAntiAlias(true);
                this.f827a.setColor(-16777216);
                this.f827a.setStyle(Paint.Style.STROKE);
                AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME = context.getFilesDir() + "/icon_web_day.data";
                AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME = context.getFilesDir() + "/icon_web_night.data";
                ywa.a().b(new a());
                try {
                    inputStreamOpen2.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    inputStreamOpen.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStreamOpen;
                inputStreamOpen = inputStreamOpen2;
                try {
                    a7b.m(th, "WaterMarkerView", "create");
                } finally {
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
        }
    }

    public final float d(int i) {
        float f;
        if (!this.f832d) {
            return 0.0f;
        }
        if (i == 0) {
            return this.f25931a;
        }
        if (i == 1) {
            f = this.f25931a;
        } else {
            if (i != 2) {
                return 0.0f;
            }
            f = this.b;
        }
        return 1.0f - f;
    }

    public final Bitmap e() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (this.f834f && (bitmap3 = this.e) != null) {
            return bitmap3;
        }
        if (this.f828a) {
            return (!this.f831c || (bitmap2 = this.d) == null) ? this.f829b : bitmap2;
        }
        return (!this.f831c || (bitmap = this.c) == null) ? this.f826a : bitmap;
    }

    public final void f() {
        int i = this.P;
        if (i == 0) {
            h();
        } else if (i == 2) {
            g();
        }
        this.N = this.Q;
        int height = (getHeight() - this.R) - this.K;
        this.O = height;
        if (this.N < 0) {
            this.N = 0;
        }
        if (height < 0) {
            this.O = 0;
        }
    }

    public final void g() {
        if (this.f833e) {
            this.Q = (int) (getWidth() * this.f25931a);
        } else {
            this.Q = (int) ((getWidth() * this.f25931a) - this.L);
        }
        this.R = (int) (getHeight() * this.b);
    }

    public final void h() {
        int i = this.M;
        if (i == 1) {
            this.Q = (getWidth() - this.L) / 2;
        } else if (i == 2) {
            this.Q = (getWidth() - this.L) - 10;
        } else {
            this.Q = 10;
        }
        this.R = 8;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        try {
            if (!this.f832d || getWidth() == 0 || getHeight() == 0 || this.f829b == null) {
                return;
            }
            if (!this.f830b) {
                f();
                this.f830b = true;
            }
            canvas.drawBitmap(e(), this.N, this.O, this.f827a);
        } catch (Throwable th) {
            a7b.m(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            Bitmap bitmap = this.f826a;
            if (bitmap != null) {
                zwa.B(bitmap);
                this.f826a = null;
            }
            Bitmap bitmap2 = this.f829b;
            if (bitmap2 != null) {
                zwa.B(bitmap2);
                this.f829b = null;
            }
            this.f826a = null;
            this.f829b = null;
            Bitmap bitmap3 = this.f;
            if (bitmap3 != null) {
                zwa.B(bitmap3);
                this.f = null;
            }
            Bitmap bitmap4 = this.g;
            if (bitmap4 != null) {
                zwa.B(bitmap4);
                this.g = null;
            }
            Bitmap bitmap5 = this.c;
            if (bitmap5 != null) {
                zwa.B(bitmap5);
            }
            this.c = null;
            Bitmap bitmap6 = this.d;
            if (bitmap6 != null) {
                zwa.B(bitmap6);
            }
            this.d = null;
            Bitmap bitmap7 = this.e;
            if (bitmap7 != null) {
                bitmap7.recycle();
            }
            this.f827a = null;
        } catch (Throwable th) {
            a7b.m(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public final Point b() {
        return new Point(this.N, this.O - 2);
    }

    public final void c(int i) {
        this.P = 1;
        this.Q = i;
        c();
    }

    public final void b(int i) {
        this.P = 1;
        this.R = i;
        c();
    }

    public final void c() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        f();
        postInvalidate();
    }

    public final void d(boolean z) {
        if (this.f832d && this.f831c != z) {
            this.f831c = z;
            if (z) {
                if (this.f828a) {
                    Bitmap bitmap = this.d;
                    if (bitmap != null) {
                        this.L = bitmap.getWidth();
                        this.K = this.d.getHeight();
                        return;
                    }
                    return;
                }
                Bitmap bitmap2 = this.c;
                if (bitmap2 != null) {
                    this.L = bitmap2.getWidth();
                    this.K = this.c.getHeight();
                    return;
                }
                return;
            }
            this.L = this.f826a.getWidth();
            this.K = this.f826a.getHeight();
        }
    }

    public final void b(boolean z) {
        if (this.f832d) {
            this.f834f = z;
            if (z) {
                Bitmap bitmap = this.e;
                if (bitmap != null) {
                    this.L = bitmap.getWidth();
                    this.K = this.e.getHeight();
                    return;
                }
                return;
            }
            this.L = this.f826a.getWidth();
            this.K = this.f826a.getHeight();
        }
    }

    public final void c(boolean z) {
        this.f832d = z;
    }

    public final boolean d() {
        return this.f828a;
    }

    public final void a(boolean z) {
        if (this.f832d) {
            try {
                this.f828a = z;
                if (z) {
                    this.f827a.setColor(-1);
                } else {
                    this.f827a.setColor(-16777216);
                }
            } catch (Throwable th) {
                a7b.m(th, "WaterMarkerView", "changeBitmap");
                th.printStackTrace();
            }
        }
    }

    public final void a(int i) {
        this.P = 0;
        this.M = i;
        c();
    }

    public final void a(int i, float f) {
        if (this.f832d) {
            this.P = 2;
            float fMax = Math.max(0.0f, Math.min(f, 1.0f));
            if (i == 0) {
                this.f25931a = fMax;
                this.f833e = true;
            } else if (i == 1) {
                this.f25931a = 1.0f - fMax;
                this.f833e = false;
            } else if (i == 2) {
                this.b = 1.0f - fMax;
            }
            c();
        }
    }

    public final void a(String str, int i) {
        try {
            if (this.f832d && new File(str).exists()) {
                if (i == 0) {
                    Bitmap bitmap = this.c;
                    Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
                    this.f = bitmapDecodeFile;
                    this.c = zwa.m(bitmapDecodeFile, qwb.f44317a);
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    zwa.B(bitmap);
                    return;
                }
                if (i == 1) {
                    Bitmap bitmap2 = this.d;
                    Bitmap bitmapDecodeFile2 = BitmapFactory.decodeFile(str);
                    this.f = bitmapDecodeFile2;
                    this.d = zwa.m(bitmapDecodeFile2, qwb.f44317a);
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    zwa.B(bitmap2);
                }
            }
        } catch (Throwable th) {
            a7b.m(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
    }
}
