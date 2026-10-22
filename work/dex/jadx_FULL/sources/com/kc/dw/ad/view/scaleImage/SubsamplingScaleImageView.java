package com.kc.dw.ad.view.scaleImage;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.kc.dw.ad.view.scaleImage.decoder.SkiaImageDecoder;
import com.kc.dw.ad.view.scaleImage.decoder.SkiaImageRegionDecoder;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.u15;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SubsamplingScaleImageView extends View {
    public static final List<Integer> u0 = Arrays.asList(0, 90, 180, 270, -1);
    public static final List<Integer> v0 = Arrays.asList(1, 2, 3);
    public static final List<Integer> w0 = Arrays.asList(2, 1);
    public static final List<Integer> x0 = Arrays.asList(1, 2, 3);
    public static final List<Integer> y0 = Arrays.asList(2, 1, 3, 4);
    public static Bitmap.Config z0;
    public PointF A;
    public PointF B;
    public Float C;
    public PointF D;
    public PointF E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public GestureDetector M;
    public GestureDetector N;
    public com.kc.dw.ad.view.scaleImage.decoder.d O;
    public final ReadWriteLock P;
    public com.kc.dw.ad.view.scaleImage.decoder.b<? extends com.kc.dw.ad.view.scaleImage.decoder.c> Q;
    public com.kc.dw.ad.view.scaleImage.decoder.b<? extends com.kc.dw.ad.view.scaleImage.decoder.d> R;
    public PointF S;
    public float T;
    public final float U;
    public float V;
    public boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f39195a;
    public PointF a0;
    public boolean b;
    public PointF b0;
    public boolean c;
    public PointF c0;
    public Uri d;
    public d d0;
    public int e;
    public boolean e0;
    public Map<Integer, List<k>> f;
    public boolean f0;
    public boolean g;
    public h g0;
    public int h;
    public i h0;
    public float i;
    public View.OnLongClickListener i0;
    public float j;
    public final Handler j0;
    public int k;
    public Paint k0;
    public int l;
    public Paint l0;
    public int m;
    public Paint m0;
    public int n;
    public Paint n0;
    public int o;
    public j o0;
    public Executor p;
    public Matrix p0;
    public boolean q;
    public RectF q0;
    public boolean r;
    public final float[] r0;
    public boolean s;
    public final float[] s0;
    public boolean t;
    public final float t0;
    public float u;
    public int v;
    public int w;
    public float x;
    public float y;
    public PointF z;

    @Keep
    public class a extends com.kc.dw.core.safe.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SubsamplingScaleImageView f39196a;

        public a(SubsamplingScaleImageView subsamplingScaleImageView) {
            this.f39196a = subsamplingScaleImageView;
        }
    }

    @Keep
    public class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f39197a;
        public final SubsamplingScaleImageView b;

        public b(SubsamplingScaleImageView subsamplingScaleImageView, Context context) {
            this.b = subsamplingScaleImageView;
            this.f39197a = context;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.b;
            if (!subsamplingScaleImageView.s || !subsamplingScaleImageView.e0 || subsamplingScaleImageView.z == null) {
                return onDoubleTapEvent(motionEvent);
            }
            subsamplingScaleImageView.setGestureDetector(this.f39197a);
            SubsamplingScaleImageView subsamplingScaleImageView2 = this.b;
            if (!subsamplingScaleImageView2.t) {
                subsamplingScaleImageView2.a(subsamplingScaleImageView2.b(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }
            subsamplingScaleImageView2.S = new PointF(motionEvent.getX(), motionEvent.getY());
            SubsamplingScaleImageView subsamplingScaleImageView3 = this.b;
            PointF pointF = subsamplingScaleImageView3.z;
            subsamplingScaleImageView3.A = new PointF(pointF.x, pointF.y);
            SubsamplingScaleImageView subsamplingScaleImageView4 = this.b;
            subsamplingScaleImageView4.y = subsamplingScaleImageView4.x;
            subsamplingScaleImageView4.K = true;
            this.b.I = true;
            SubsamplingScaleImageView subsamplingScaleImageView5 = this.b;
            subsamplingScaleImageView5.V = -1.0f;
            subsamplingScaleImageView5.b0 = subsamplingScaleImageView5.b(subsamplingScaleImageView5.S);
            this.b.c0 = new PointF(motionEvent.getX(), motionEvent.getY());
            SubsamplingScaleImageView subsamplingScaleImageView6 = this.b;
            PointF pointF2 = subsamplingScaleImageView6.b0;
            subsamplingScaleImageView6.a0 = new PointF(pointF2.x, pointF2.y);
            this.b.W = false;
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.b;
            if (subsamplingScaleImageView.r && subsamplingScaleImageView.e0 && subsamplingScaleImageView.z != null && motionEvent != null && motionEvent2 != null && ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && (Math.abs(f) > 500.0f || Math.abs(f2) > 500.0f))) {
                SubsamplingScaleImageView subsamplingScaleImageView2 = this.b;
                if (!subsamplingScaleImageView2.I) {
                    PointF pointF = subsamplingScaleImageView2.z;
                    PointF pointF2 = new PointF((f * 0.25f) + pointF.x, (f2 * 0.25f) + pointF.y);
                    float width = this.b.getWidth() / 2;
                    float f3 = pointF2.x;
                    SubsamplingScaleImageView subsamplingScaleImageView3 = this.b;
                    float f4 = (width - f3) / subsamplingScaleImageView3.x;
                    float height = subsamplingScaleImageView3.getHeight() / 2;
                    float f5 = pointF2.y;
                    SubsamplingScaleImageView subsamplingScaleImageView4 = this.b;
                    e eVar = new e(subsamplingScaleImageView4, new PointF(f4, (height - f5) / subsamplingScaleImageView4.x));
                    if (!SubsamplingScaleImageView.w0.contains(1)) {
                        throw new IllegalArgumentException("Unknown easing type: 1");
                    }
                    eVar.e = 1;
                    eVar.h = false;
                    eVar.f = 3;
                    eVar.a();
                    return true;
                }
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            this.b.performClick();
            return true;
        }
    }

    @Keep
    public class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SubsamplingScaleImageView f39198a;

        public c(SubsamplingScaleImageView subsamplingScaleImageView) {
            this.f39198a = subsamplingScaleImageView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            this.f39198a.performClick();
            return true;
        }
    }

    @Keep
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f39199a;
        public float b;
        public PointF c;
        public PointF d;
        public PointF e;
        public PointF f;
        public PointF g;
        public long h = 500;
        public boolean i = true;
        public int j = 2;
        public int k = 1;
        public long l = System.currentTimeMillis();
        public g m;
    }

    @Keep
    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f39200a;
        public final PointF b;
        public final PointF c;
        public long d;
        public int e;
        public int f;
        public boolean g;
        public boolean h;
        public final SubsamplingScaleImageView i;

        public e(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF) {
            this.i = subsamplingScaleImageView;
            this.d = 500L;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.f39200a = f;
            this.b = pointF;
            this.c = null;
        }

        public e(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, PointF pointF2) {
            this.i = subsamplingScaleImageView;
            this.d = 500L;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.f39200a = f;
            this.b = pointF;
            this.c = pointF2;
        }

        public e(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
            this.i = subsamplingScaleImageView;
            this.d = 500L;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.f39200a = subsamplingScaleImageView.x;
            this.b = pointF;
            this.c = null;
        }

        public void a() {
            PointF pointF;
            g gVar;
            d dVar = this.i.d0;
            if (dVar != null && (gVar = dVar.m) != null) {
                try {
                    gVar.c();
                } catch (Exception e) {
                    List<Integer> list = SubsamplingScaleImageView.u0;
                    Log.w("SubsamplingScaleImageView", "Error thrown by animation listener", e);
                }
            }
            int paddingLeft = this.i.getPaddingLeft();
            int width = ((this.i.getWidth() - this.i.getPaddingRight()) - this.i.getPaddingLeft()) / 2;
            int paddingTop = this.i.getPaddingTop();
            int height = ((this.i.getHeight() - this.i.getPaddingBottom()) - this.i.getPaddingTop()) / 2;
            SubsamplingScaleImageView subsamplingScaleImageView = this.i;
            float fMin = Math.min(subsamplingScaleImageView.i, Math.max(subsamplingScaleImageView.d(), this.f39200a));
            if (this.h) {
                SubsamplingScaleImageView subsamplingScaleImageView2 = this.i;
                PointF pointF2 = this.b;
                float f = pointF2.x;
                float f2 = pointF2.y;
                pointF = new PointF();
                PointF pointFA = subsamplingScaleImageView2.a(f, f2, fMin);
                pointF.set((((((subsamplingScaleImageView2.getWidth() - subsamplingScaleImageView2.getPaddingRight()) - subsamplingScaleImageView2.getPaddingLeft()) / 2) + subsamplingScaleImageView2.getPaddingLeft()) - pointFA.x) / fMin, (((((subsamplingScaleImageView2.getHeight() - subsamplingScaleImageView2.getPaddingBottom()) - subsamplingScaleImageView2.getPaddingTop()) / 2) + subsamplingScaleImageView2.getPaddingTop()) - pointFA.y) / fMin);
            } else {
                pointF = this.b;
            }
            this.i.d0 = new d();
            SubsamplingScaleImageView subsamplingScaleImageView3 = this.i;
            d dVar2 = subsamplingScaleImageView3.d0;
            dVar2.f39199a = subsamplingScaleImageView3.x;
            dVar2.b = fMin;
            dVar2.l = System.currentTimeMillis();
            SubsamplingScaleImageView subsamplingScaleImageView4 = this.i;
            d dVar3 = subsamplingScaleImageView4.d0;
            dVar3.e = pointF;
            dVar3.c = subsamplingScaleImageView4.getCenter();
            SubsamplingScaleImageView subsamplingScaleImageView5 = this.i;
            d dVar4 = subsamplingScaleImageView5.d0;
            dVar4.d = pointF;
            dVar4.f = subsamplingScaleImageView5.a(pointF);
            this.i.d0.g = new PointF(width + paddingLeft, height + paddingTop);
            d dVar5 = this.i.d0;
            dVar5.h = this.d;
            dVar5.i = this.g;
            d dVar6 = this.i.d0;
            dVar6.j = this.e;
            dVar6.k = this.f;
            dVar6.l = System.currentTimeMillis();
            d dVar7 = this.i.d0;
            dVar7.m = null;
            PointF pointF3 = this.c;
            if (pointF3 != null) {
                float f3 = pointF3.x;
                PointF pointF4 = dVar7.c;
                float f4 = f3 - (pointF4.x * fMin);
                float f5 = pointF3.y - (pointF4.y * fMin);
                PointF pointF5 = new PointF(f4, f5);
                this.i.a(true, new j(fMin, pointF5));
                d dVar8 = this.i.d0;
                PointF pointF6 = this.c;
                dVar8.g = new PointF((pointF5.x - f4) + pointF6.x, (pointF5.y - f5) + pointF6.y);
            }
            this.i.invalidate();
        }
    }

    @Keep
    public static class f extends AsyncTask<Void, Void, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f39201a;
        public final WeakReference<Context> b;
        public final WeakReference<com.kc.dw.ad.view.scaleImage.decoder.b<? extends com.kc.dw.ad.view.scaleImage.decoder.c>> c;
        public final Uri d;
        public final boolean e;
        public Bitmap f;
        public Exception g;

        public f(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.kc.dw.ad.view.scaleImage.decoder.b<? extends com.kc.dw.ad.view.scaleImage.decoder.c> bVar, Uri uri, boolean z) {
            this.f39201a = new WeakReference<>(subsamplingScaleImageView);
            this.b = new WeakReference<>(context);
            this.c = new WeakReference<>(bVar);
            this.d = uri;
            this.e = z;
        }

        @Override // android.os.AsyncTask
        public Integer doInBackground(Void[] voidArr) {
            try {
                String string = this.d.toString();
                Context context = this.b.get();
                com.kc.dw.ad.view.scaleImage.decoder.b<? extends com.kc.dw.ad.view.scaleImage.decoder.c> bVar = this.c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.f39201a.get();
                if (context != null && bVar != null && subsamplingScaleImageView != null) {
                    if (subsamplingScaleImageView.g) {
                        Log.d("SubsamplingScaleImageView", String.format("BitmapLoadTask.doInBackground", new Object[0]));
                    }
                    this.f = bVar.a().a(context, this.d);
                    return Integer.valueOf(SubsamplingScaleImageView.a(subsamplingScaleImageView, context, string));
                }
            } catch (Exception e) {
                List<Integer> list = SubsamplingScaleImageView.u0;
                Log.e("SubsamplingScaleImageView", "Failed to load bitmap", e);
                this.g = e;
            } catch (OutOfMemoryError e2) {
                List<Integer> list2 = SubsamplingScaleImageView.u0;
                Log.e("SubsamplingScaleImageView", "Failed to load bitmap - OutOfMemoryError", e2);
                this.g = new RuntimeException(e2);
            }
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Integer num) {
            h hVar;
            Integer num2 = num;
            SubsamplingScaleImageView subsamplingScaleImageView = this.f39201a.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap = this.f;
                if (bitmap != null && num2 != null) {
                    if (this.e) {
                        List<Integer> list = SubsamplingScaleImageView.u0;
                        subsamplingScaleImageView.a(bitmap);
                        return;
                    } else {
                        int iIntValue = num2.intValue();
                        List<Integer> list2 = SubsamplingScaleImageView.u0;
                        subsamplingScaleImageView.a(bitmap, iIntValue, false);
                        return;
                    }
                }
                Exception exc = this.g;
                if (exc == null || (hVar = subsamplingScaleImageView.g0) == null) {
                    return;
                }
                if (this.e) {
                    hVar.a(exc);
                } else {
                    hVar.c(exc);
                }
            }
        }
    }

    @Keep
    public interface g {
        void a();

        void b();

        void c();
    }

    @Keep
    public interface h {
        void a();

        void a(Exception exc);

        void b();

        void b(Exception exc);

        void c();

        void c(Exception exc);
    }

    @Keep
    public interface i {
        void a(float f, int i);

        void a(PointF pointF, int i);
    }

    @Keep
    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f39202a;
        public final PointF b;

        public j(float f, PointF pointF) {
            this.f39202a = f;
            this.b = pointF;
        }
    }

    @Keep
    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f39203a;
        public int b;
        public Bitmap c;
        public boolean d;
        public boolean e;
        public Rect f;
        public Rect g;
    }

    @Keep
    public static class l extends AsyncTask<Void, Void, Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f39204a;
        public final WeakReference<com.kc.dw.ad.view.scaleImage.decoder.d> b;
        public final WeakReference<k> c;
        public Exception d;

        public l(SubsamplingScaleImageView subsamplingScaleImageView, com.kc.dw.ad.view.scaleImage.decoder.d dVar, k kVar) {
            this.f39204a = new WeakReference<>(subsamplingScaleImageView);
            this.b = new WeakReference<>(dVar);
            this.c = new WeakReference<>(kVar);
            kVar.d = true;
        }

        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Void[] voidArr) {
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = this.f39204a.get();
                com.kc.dw.ad.view.scaleImage.decoder.d dVar = this.b.get();
                k kVar = this.c.get();
                if (dVar != null && kVar != null && subsamplingScaleImageView != null && dVar.a() && kVar.e) {
                    Rect rect = kVar.f39203a;
                    int i = kVar.b;
                    if (subsamplingScaleImageView.g) {
                        Log.d("SubsamplingScaleImageView", String.format("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", rect, Integer.valueOf(i)));
                    }
                    subsamplingScaleImageView.P.readLock().lock();
                    try {
                        if (dVar.a()) {
                            SubsamplingScaleImageView.a(subsamplingScaleImageView, kVar.f39203a, kVar.g);
                            return dVar.a(kVar.g, kVar.b);
                        }
                        kVar.d = false;
                    } finally {
                        subsamplingScaleImageView.P.readLock().unlock();
                    }
                } else if (kVar != null) {
                    kVar.d = false;
                }
            } catch (Exception e) {
                List<Integer> list = SubsamplingScaleImageView.u0;
                Log.e("SubsamplingScaleImageView", "Failed to decode tile", e);
                this.d = e;
            } catch (OutOfMemoryError e2) {
                List<Integer> list2 = SubsamplingScaleImageView.u0;
                Log.e("SubsamplingScaleImageView", "Failed to decode tile - OutOfMemoryError", e2);
                this.d = new RuntimeException(e2);
            }
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            h hVar;
            Bitmap bitmap2;
            Bitmap bitmap3 = bitmap;
            SubsamplingScaleImageView subsamplingScaleImageView = this.f39204a.get();
            k kVar = this.c.get();
            if (subsamplingScaleImageView == null || kVar == null) {
                return;
            }
            if (bitmap3 == null) {
                Exception exc = this.d;
                if (exc == null || (hVar = subsamplingScaleImageView.g0) == null) {
                    return;
                }
                hVar.b(exc);
                return;
            }
            kVar.c = bitmap3;
            kVar.d = false;
            List<Integer> list = SubsamplingScaleImageView.u0;
            synchronized (subsamplingScaleImageView) {
                if (subsamplingScaleImageView.g) {
                    Log.d("SubsamplingScaleImageView", String.format("onTileLoaded", new Object[0]));
                }
                subsamplingScaleImageView.b();
                subsamplingScaleImageView.a();
                if (subsamplingScaleImageView.c() && (bitmap2 = subsamplingScaleImageView.f39195a) != null) {
                    if (!subsamplingScaleImageView.c) {
                        bitmap2.recycle();
                    }
                    subsamplingScaleImageView.f39195a = null;
                    h hVar2 = subsamplingScaleImageView.g0;
                    if (hVar2 != null && subsamplingScaleImageView.c) {
                        hVar2.b();
                    }
                    subsamplingScaleImageView.b = false;
                    subsamplingScaleImageView.c = false;
                }
                subsamplingScaleImageView.invalidate();
            }
        }
    }

    @Keep
    public static class m extends AsyncTask<Void, Void, int[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f39205a;
        public final WeakReference<Context> b;
        public final WeakReference<com.kc.dw.ad.view.scaleImage.decoder.b<? extends com.kc.dw.ad.view.scaleImage.decoder.d>> c;
        public final Uri d;
        public com.kc.dw.ad.view.scaleImage.decoder.d e;
        public Exception f;

        public m(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.kc.dw.ad.view.scaleImage.decoder.b<? extends com.kc.dw.ad.view.scaleImage.decoder.d> bVar, Uri uri) {
            this.f39205a = new WeakReference<>(subsamplingScaleImageView);
            this.b = new WeakReference<>(context);
            this.c = new WeakReference<>(bVar);
            this.d = uri;
        }

        @Override // android.os.AsyncTask
        public int[] doInBackground(Void[] voidArr) {
            try {
                String string = this.d.toString();
                Context context = this.b.get();
                com.kc.dw.ad.view.scaleImage.decoder.b<? extends com.kc.dw.ad.view.scaleImage.decoder.d> bVar = this.c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.f39205a.get();
                if (context != null && bVar != null && subsamplingScaleImageView != null) {
                    if (subsamplingScaleImageView.g) {
                        Log.d("SubsamplingScaleImageView", String.format("TilesInitTask.doInBackground", new Object[0]));
                    }
                    com.kc.dw.ad.view.scaleImage.decoder.d dVarA = bVar.a();
                    this.e = dVarA;
                    Point pointA = dVarA.a(context, this.d);
                    return new int[]{pointA.x, pointA.y, SubsamplingScaleImageView.a(subsamplingScaleImageView, context, string)};
                }
            } catch (Exception e) {
                List<Integer> list = SubsamplingScaleImageView.u0;
                Log.e("SubsamplingScaleImageView", "Failed to initialise bitmap decoder", e);
                this.f = e;
            }
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(int[] iArr) {
            h hVar;
            int i;
            int i2;
            int i3;
            int[] iArr2 = iArr;
            SubsamplingScaleImageView subsamplingScaleImageView = this.f39205a.get();
            if (subsamplingScaleImageView != null) {
                com.kc.dw.ad.view.scaleImage.decoder.d dVar = this.e;
                if (dVar == null || iArr2 == null || iArr2.length != 3) {
                    Exception exc = this.f;
                    if (exc == null || (hVar = subsamplingScaleImageView.g0) == null) {
                        return;
                    }
                    hVar.c(exc);
                    return;
                }
                int i4 = iArr2[0];
                int i5 = iArr2[1];
                int i6 = iArr2[2];
                List<Integer> list = SubsamplingScaleImageView.u0;
                synchronized (subsamplingScaleImageView) {
                    int i7 = subsamplingScaleImageView.h;
                    if (subsamplingScaleImageView.g) {
                        Log.d("SubsamplingScaleImageView", String.format("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i7)));
                    }
                    int i8 = subsamplingScaleImageView.F;
                    if (i8 > 0 && (i3 = subsamplingScaleImageView.G) > 0 && (i8 != i4 || i3 != i5)) {
                        subsamplingScaleImageView.d(false);
                        Bitmap bitmap = subsamplingScaleImageView.f39195a;
                        if (bitmap != null) {
                            if (!subsamplingScaleImageView.c) {
                                bitmap.recycle();
                            }
                            subsamplingScaleImageView.f39195a = null;
                            h hVar2 = subsamplingScaleImageView.g0;
                            if (hVar2 != null && subsamplingScaleImageView.c) {
                                hVar2.b();
                            }
                            subsamplingScaleImageView.b = false;
                            subsamplingScaleImageView.c = false;
                        }
                    }
                    subsamplingScaleImageView.O = dVar;
                    subsamplingScaleImageView.F = i4;
                    subsamplingScaleImageView.G = i5;
                    subsamplingScaleImageView.H = i6;
                    subsamplingScaleImageView.b();
                    if (!subsamplingScaleImageView.a() && (i = subsamplingScaleImageView.n) > 0 && i != Integer.MAX_VALUE && (i2 = subsamplingScaleImageView.o) > 0 && i2 != Integer.MAX_VALUE && subsamplingScaleImageView.getWidth() > 0 && subsamplingScaleImageView.getHeight() > 0) {
                        subsamplingScaleImageView.a(new Point(subsamplingScaleImageView.n, subsamplingScaleImageView.o));
                    }
                    subsamplingScaleImageView.invalidate();
                    subsamplingScaleImageView.requestLayout();
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        int resourceId;
        String string;
        super(context, attributeSet);
        this.h = 0;
        this.i = 2.0f;
        this.j = d();
        this.k = -1;
        this.l = 1;
        this.m = 1;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
        this.p = AsyncTask.THREAD_POOL_EXECUTOR;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = true;
        this.u = 1.0f;
        this.v = 1;
        this.w = 500;
        this.P = new ReentrantReadWriteLock(true);
        this.Q = new com.kc.dw.ad.view.scaleImage.decoder.a(SkiaImageDecoder.class);
        this.R = new com.kc.dw.ad.view.scaleImage.decoder.a(SkiaImageRegionDecoder.class);
        this.r0 = new float[8];
        this.s0 = new float[8];
        this.t0 = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.j0 = new Handler(new a(this));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Ssd_SubsamplingScaleImageView);
            int i2 = R.styleable.Ssd_SubsamplingScaleImageView_ssd_assetName;
            if (typedArrayObtainStyledAttributes.hasValue(i2) && (string = typedArrayObtainStyledAttributes.getString(i2)) != null && string.length() > 0) {
                setImage(com.kc.dw.ad.view.scaleImage.a.a(string).a());
            }
            int i3 = R.styleable.Ssd_SubsamplingScaleImageView_ssd_src;
            if (typedArrayObtainStyledAttributes.hasValue(i3) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i3, 0)) > 0) {
                setImage(com.kc.dw.ad.view.scaleImage.a.a(resourceId).a());
            }
            int i4 = R.styleable.Ssd_SubsamplingScaleImageView_ssd_panEnabled;
            if (typedArrayObtainStyledAttributes.hasValue(i4)) {
                setPanEnabled(typedArrayObtainStyledAttributes.getBoolean(i4, true));
            }
            int i5 = R.styleable.Ssd_SubsamplingScaleImageView_ssd_zoomEnabled;
            if (typedArrayObtainStyledAttributes.hasValue(i5)) {
                setZoomEnabled(typedArrayObtainStyledAttributes.getBoolean(i5, true));
            }
            int i6 = R.styleable.Ssd_SubsamplingScaleImageView_ssd_quickScaleEnabled;
            if (typedArrayObtainStyledAttributes.hasValue(i6)) {
                setQuickScaleEnabled(typedArrayObtainStyledAttributes.getBoolean(i6, true));
            }
            int i7 = R.styleable.Ssd_SubsamplingScaleImageView_ssd_tileBackgroundColor;
            if (typedArrayObtainStyledAttributes.hasValue(i7)) {
                setTileBackgroundColor(typedArrayObtainStyledAttributes.getColor(i7, Color.argb(0, 0, 0, 0)));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.U = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    public static int a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, String str) {
        int i2 = 0;
        if (str.startsWith("content")) {
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = context.getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        int i3 = cursorQuery.getInt(0);
                        if (!u0.contains(Integer.valueOf(i3)) || i3 == -1) {
                            Log.w("SubsamplingScaleImageView", "Unsupported orientation: " + i3);
                        } else {
                            i2 = i3;
                        }
                    }
                    if (cursorQuery == null) {
                        return i2;
                    }
                } catch (Exception unused) {
                    Log.w("SubsamplingScaleImageView", "Could not get orientation of image from media store");
                    if (cursorQuery == null) {
                        return 0;
                    }
                }
                return i2;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        if (!str.startsWith("file:///") || str.startsWith(com.ipd.dsp.internal.n.a.d)) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(str.substring(7)).getAttributeInt("Orientation", 1);
            if (attributeInt != 1 && attributeInt != 0) {
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 3) {
                    return 180;
                }
                if (attributeInt == 8) {
                    return 270;
                }
                Log.w("SubsamplingScaleImageView", "Unsupported EXIF orientation: " + attributeInt);
                return 0;
            }
            return 0;
        } catch (Exception unused2) {
            Log.w("SubsamplingScaleImageView", "Could not get EXIF orientation of image");
            return 0;
        }
    }

    public static void a(SubsamplingScaleImageView subsamplingScaleImageView, Rect rect, Rect rect2) {
        if (subsamplingScaleImageView.getRequiredRotation() == 0) {
            rect2.set(rect);
            return;
        }
        if (subsamplingScaleImageView.getRequiredRotation() == 90) {
            int i2 = rect.top;
            int i3 = subsamplingScaleImageView.G;
            rect2.set(i2, i3 - rect.right, rect.bottom, i3 - rect.left);
        } else if (subsamplingScaleImageView.getRequiredRotation() != 180) {
            int i4 = subsamplingScaleImageView.F;
            rect2.set(i4 - rect.bottom, rect.left, i4 - rect.top, rect.right);
        } else {
            int i5 = subsamplingScaleImageView.F;
            int i6 = rect.right;
            int i7 = subsamplingScaleImageView.G;
            rect2.set(i5 - i6, i7 - rect.bottom, i5 - rect.left, i7 - rect.top);
        }
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return z0;
    }

    private int getRequiredRotation() {
        int i2 = this.h;
        return i2 == -1 ? this.H : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(Context context) {
        this.M = new GestureDetector(context, new b(this, context));
        this.N = new GestureDetector(context, new c(this));
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        z0 = config;
    }

    public final float a(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((f7 * f7) + (f6 * f6));
    }

    public final float a(int i2, long j2, float f2, float f3, long j3) {
        float f4;
        if (i2 == 1) {
            float f5 = j2 / j3;
            return ((f5 - 2.0f) * (-f3) * f5) + f2;
        }
        if (i2 != 2) {
            throw new IllegalStateException("Unexpected easing type: " + i2);
        }
        float f6 = j2 / (j3 / 2.0f);
        if (f6 < 1.0f) {
            f4 = (f3 / 2.0f) * f6 * f6;
        } else {
            float f7 = f6 - 1.0f;
            f4 = (((f7 - 2.0f) * f7) - 1.0f) * ((-f3) / 2.0f);
        }
        return f4 + f2;
    }

    public final int a(float f2) {
        int iRound;
        if (this.k > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= this.k / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int iG = (int) (g() * f2);
        int iF = (int) (f() * f2);
        if (iG == 0 || iF == 0) {
            return 32;
        }
        int i2 = 1;
        if (f() > iF || g() > iG) {
            iRound = Math.round(f() / iF);
            int iRound2 = Math.round(g() / iG);
            if (iRound >= iRound2) {
                iRound = iRound2;
            }
        } else {
            iRound = 1;
        }
        while (true) {
            int i3 = i2 * 2;
            if (i3 >= iRound) {
                return i2;
            }
            i2 = i3;
        }
    }

    public final int a(int i2) {
        return (int) (this.t0 * i2);
    }

    public final PointF a(float f2, float f3, float f4) {
        int paddingLeft = getPaddingLeft();
        int width = ((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2;
        int paddingTop = getPaddingTop();
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2;
        if (this.o0 == null) {
            this.o0 = new j(0.0f, new PointF(0.0f, 0.0f));
        }
        j jVar = this.o0;
        jVar.f39202a = f4;
        jVar.b.set((width + paddingLeft) - (f2 * f4), (height + paddingTop) - (f3 * f4));
        a(true, this.o0);
        return this.o0.b;
    }

    public final PointF a(PointF pointF) {
        float f2 = pointF.x;
        float f3 = pointF.y;
        PointF pointF2 = new PointF();
        if (this.z == null) {
            return null;
        }
        pointF2.set(b(f2), c(f3));
        return pointF2;
    }

    public final void a(float f2, PointF pointF, int i2) {
        i iVar = this.h0;
        if (iVar != null) {
            float f3 = this.x;
            if (f3 != f2) {
                iVar.a(f3, i2);
            }
        }
        if (this.h0 == null || this.z.equals(pointF)) {
            return;
        }
        this.h0.a(getCenter(), i2);
    }

    public final void a(Bitmap bitmap) {
        synchronized (this) {
            if (this.g) {
                Log.d("SubsamplingScaleImageView", String.format("onPreviewLoaded", new Object[0]));
            }
            if (this.f39195a == null && !this.f0) {
                this.f39195a = bitmap;
                this.b = true;
                if (b()) {
                    invalidate();
                    requestLayout();
                }
                return;
            }
            bitmap.recycle();
        }
    }

    public final void a(Bitmap bitmap, int i2, boolean z) {
        h hVar;
        synchronized (this) {
            if (this.g) {
                Log.d("SubsamplingScaleImageView", String.format("onImageLoaded", new Object[0]));
            }
            int i3 = this.F;
            if (i3 > 0 && this.G > 0 && (i3 != bitmap.getWidth() || this.G != bitmap.getHeight())) {
                d(false);
            }
            Bitmap bitmap2 = this.f39195a;
            if (bitmap2 != null && !this.c) {
                bitmap2.recycle();
            }
            if (this.f39195a != null && this.c && (hVar = this.g0) != null) {
                hVar.b();
            }
            this.b = false;
            this.c = z;
            this.f39195a = bitmap;
            this.F = bitmap.getWidth();
            this.G = bitmap.getHeight();
            this.H = i2;
            boolean zB = b();
            boolean zA = a();
            if (zB || zA) {
                invalidate();
                requestLayout();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Point point) {
        synchronized (this) {
            int i2 = point.x;
            int i3 = point.y;
            int i4 = 0;
            int i5 = 1;
            if (this.g) {
                Log.d("SubsamplingScaleImageView", String.format("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            j jVar = new j(0.0f, new PointF(0.0f, 0.0f));
            this.o0 = jVar;
            a(true, jVar);
            int iA = a(this.o0.f39202a);
            this.e = iA;
            if (iA > 1) {
                this.e = iA / 2;
            }
            if (this.e != 1 || g() >= point.x || f() >= point.y) {
                int i6 = point.x;
                int i7 = point.y;
                if (this.g) {
                    Log.d("SubsamplingScaleImageView", String.format("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(i6), Integer.valueOf(i7)));
                }
                this.f = new LinkedHashMap();
                int i8 = this.e;
                int i9 = 1;
                int i10 = 1;
                while (true) {
                    int iG = g() / i9;
                    int iF = f() / i10;
                    int i11 = iG / i8;
                    int i12 = iF / i8;
                    while (true) {
                        if (i11 + i9 + i5 <= point.x && (i11 <= ((double) getWidth()) * 1.25d || i8 >= this.e)) {
                            break;
                        }
                        int i13 = i4;
                        int i14 = i5;
                        i9++;
                        iG = g() / i9;
                        i11 = iG / i8;
                        i4 = i13;
                        i5 = i14;
                    }
                    while (true) {
                        if (i12 + i10 + i5 <= point.y && (i12 <= ((double) getHeight()) * 1.25d || i8 >= this.e)) {
                            break;
                        }
                        i10++;
                        iF = f() / i10;
                        i12 = iF / i8;
                        i4 = i4;
                        i5 = i5;
                    }
                    ArrayList arrayList = new ArrayList(i9 * i10);
                    int i15 = i4;
                    while (i15 < i9) {
                        int i16 = i4;
                        while (i16 < i10) {
                            k kVar = new k();
                            kVar.b = i8;
                            kVar.e = i8 == this.e ? i5 : i4;
                            kVar.f39203a = new Rect(i15 * iG, i16 * iF, i15 == i9 + (-1) ? g() : (i15 + 1) * iG, i16 == i10 + (-1) ? f() : (i16 + 1) * iF);
                            kVar.f = new Rect(0, 0, 0, 0);
                            kVar.g = new Rect(kVar.f39203a);
                            arrayList.add(kVar);
                            i16++;
                            i5 = 1;
                            i4 = 0;
                        }
                        i15++;
                        i5 = 1;
                        i4 = 0;
                    }
                    this.f.put(Integer.valueOf(i8), arrayList);
                    if (i8 == 1) {
                        break;
                    }
                    i8 /= 2;
                    i4 = 0;
                    i5 = 1;
                }
                Iterator<k> it = this.f.get(Integer.valueOf(this.e)).iterator();
                while (it.hasNext()) {
                    new l(this, this.O, it.next()).executeOnExecutor(this.p, new Void[0]);
                }
                b(true);
            } else {
                this.O.b();
                this.O = null;
                new f(this, getContext(), this.Q, this.d, false).executeOnExecutor(this.p, new Void[0]);
            }
        }
    }

    public final void a(PointF pointF, PointF pointF2) {
        float f2;
        if (!this.r) {
            PointF pointF3 = this.E;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                f2 = pointF3.y;
            } else {
                pointF.x = g() / 2;
                f2 = f() / 2;
            }
            pointF.y = f2;
        }
        float fMin = Math.min(this.i, this.u);
        float f3 = this.x;
        boolean z = ((double) f3) <= ((double) fMin) * 0.9d || f3 == this.j;
        if (!z) {
            fMin = d();
        }
        int i2 = this.v;
        if (i2 == 3) {
            this.d0 = null;
            this.C = Float.valueOf(fMin);
            this.D = pointF;
            this.E = pointF;
            invalidate();
        } else if (i2 == 2 || !z || !this.r) {
            e eVar = new e(this, fMin, pointF);
            eVar.g = false;
            eVar.d = this.w;
            eVar.f = 4;
            eVar.a();
        } else if (i2 == 1) {
            e eVar2 = new e(this, fMin, pointF, pointF2);
            eVar2.g = false;
            eVar2.d = this.w;
            eVar2.f = 4;
            eVar2.a();
        }
        invalidate();
    }

    public final void a(String str, Object... objArr) {
        if (this.g) {
            Log.d("SubsamplingScaleImageView", String.format(str, objArr));
        }
    }

    public final void a(boolean z) {
        boolean z2;
        if (this.z == null) {
            this.z = new PointF(0.0f, 0.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.o0 == null) {
            this.o0 = new j(0.0f, new PointF(0.0f, 0.0f));
        }
        j jVar = this.o0;
        jVar.f39202a = this.x;
        jVar.b.set(this.z);
        a(z, this.o0);
        j jVar2 = this.o0;
        this.x = jVar2.f39202a;
        this.z.set(jVar2.b);
        if (!z2 || this.m == 4) {
            return;
        }
        this.z.set(a(g() / 2, f() / 2, this.x));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0083  */
    /* JADX WARN: Code duplicated, block: B:28:0x009f  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e5  */
    public final void a(boolean z, j jVar) {
        float f2;
        float f3;
        int height;
        float paddingTop;
        float paddingLeft;
        float fMax;
        int iMax;
        float fMax2;
        if (this.l == 2 && this.e0) {
            z = false;
        }
        PointF pointF = jVar.b;
        float fMin = Math.min(this.i, Math.max(d(), jVar.f39202a));
        float fG = g() * fMin;
        float f4 = f() * fMin;
        if (this.l != 3 || !this.e0) {
            float f5 = pointF.x;
            if (z) {
                pointF.x = Math.max(f5, getWidth() - fG);
                f2 = pointF.y;
                height = getHeight();
            } else {
                pointF.x = Math.max(f5, -fG);
                f2 = pointF.y;
                f3 = -f4;
            }
            pointF.y = Math.max(f2, f3);
            paddingTop = 0.5f;
            if (getPaddingLeft() <= 0 || getPaddingRight() > 0) {
                paddingLeft = getPaddingLeft() / (getPaddingRight() + getPaddingLeft());
            } else {
                paddingLeft = 0.5f;
            }
            if (getPaddingTop() <= 0 || getPaddingBottom() > 0) {
                paddingTop = getPaddingTop() / (getPaddingBottom() + getPaddingTop());
            }
            if (this.l == 3 || !this.e0) {
                if (z) {
                    fMax = Math.max(0.0f, (getWidth() - fG) * paddingLeft);
                    fMax2 = Math.max(0.0f, (getHeight() - f4) * paddingTop);
                } else {
                    fMax = Math.max(0, getWidth());
                    iMax = Math.max(0, getHeight());
                }
                pointF.x = Math.min(pointF.x, fMax);
                pointF.y = Math.min(pointF.y, fMax2);
                jVar.f39202a = fMin;
            }
            fMax = Math.max(0, getWidth() / 2);
            iMax = Math.max(0, getHeight() / 2);
            fMax2 = iMax;
            pointF.x = Math.min(pointF.x, fMax);
            pointF.y = Math.min(pointF.y, fMax2);
            jVar.f39202a = fMin;
        }
        pointF.x = Math.max(pointF.x, (getWidth() / 2) - fG);
        f2 = pointF.y;
        height = getHeight() / 2;
        f3 = height - f4;
        pointF.y = Math.max(f2, f3);
        paddingTop = 0.5f;
        if (getPaddingLeft() <= 0) {
            paddingLeft = getPaddingLeft() / (getPaddingRight() + getPaddingLeft());
        } else {
            paddingLeft = getPaddingLeft() / (getPaddingRight() + getPaddingLeft());
        }
        if (getPaddingTop() <= 0) {
            paddingTop = getPaddingTop() / (getPaddingBottom() + getPaddingTop());
        } else {
            paddingTop = getPaddingTop() / (getPaddingBottom() + getPaddingTop());
        }
        if (this.l == 3) {
            if (z) {
                fMax = Math.max(0.0f, (getWidth() - fG) * paddingLeft);
                fMax2 = Math.max(0.0f, (getHeight() - f4) * paddingTop);
            } else {
                fMax = Math.max(0, getWidth());
                iMax = Math.max(0, getHeight());
                fMax2 = iMax;
            }
        } else if (z) {
            fMax = Math.max(0.0f, (getWidth() - fG) * paddingLeft);
            fMax2 = Math.max(0.0f, (getHeight() - f4) * paddingTop);
        } else {
            fMax = Math.max(0, getWidth());
            iMax = Math.max(0, getHeight());
            fMax2 = iMax;
        }
        pointF.x = Math.min(pointF.x, fMax);
        pointF.y = Math.min(pointF.y, fMax2);
        jVar.f39202a = fMin;
    }

    public final void a(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
        fArr[4] = f6;
        fArr[5] = f7;
        fArr[6] = f8;
        fArr[7] = f9;
    }

    public final boolean a() {
        boolean zC = c();
        if (!this.f0 && zC) {
            e();
            this.f0 = true;
            h hVar = this.g0;
            if (hVar != null) {
                hVar.c();
            }
        }
        return zC;
    }

    public final float b(float f2) {
        PointF pointF = this.z;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.x) + pointF.x;
    }

    public final PointF b(PointF pointF) {
        float f2 = pointF.x;
        float f3 = pointF.y;
        PointF pointF2 = new PointF();
        if (this.z == null) {
            return null;
        }
        pointF2.set(d(f2), e(f3));
        return pointF2;
    }

    public final void b(boolean z) {
        if (this.O == null || this.f == null) {
            return;
        }
        int iMin = Math.min(this.e, a(this.x));
        Iterator<Map.Entry<Integer, List<k>>> it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            for (k kVar : it.next().getValue()) {
                int i2 = kVar.b;
                if (i2 < iMin || (i2 > iMin && i2 != this.e)) {
                    kVar.e = false;
                    Bitmap bitmap = kVar.c;
                    if (bitmap != null) {
                        bitmap.recycle();
                        kVar.c = null;
                    }
                }
                int i3 = kVar.b;
                if (i3 == iMin) {
                    float fD = d(0.0f);
                    float fD2 = d(getWidth());
                    float fE = e(0.0f);
                    float fE2 = e(getHeight());
                    Rect rect = kVar.f39203a;
                    if (fD <= ((float) rect.right) && ((float) rect.left) <= fD2 && fE <= ((float) rect.bottom) && ((float) rect.top) <= fE2) {
                        kVar.e = true;
                        if (!kVar.d && kVar.c == null && z) {
                            new l(this, this.O, kVar).executeOnExecutor(this.p, new Void[0]);
                        }
                    } else if (kVar.b != this.e) {
                        kVar.e = false;
                        Bitmap bitmap2 = kVar.c;
                        if (bitmap2 != null) {
                            bitmap2.recycle();
                            kVar.c = null;
                        }
                    }
                } else if (i3 == this.e) {
                    kVar.e = true;
                }
            }
        }
    }

    public final boolean b() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.F > 0 && this.G > 0 && (this.f39195a != null || c());
        if (!this.e0 && z) {
            e();
            this.e0 = true;
            h hVar = this.g0;
            if (hVar != null) {
                hVar.a();
            }
        }
        return z;
    }

    public final float c(float f2) {
        PointF pointF = this.z;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.x) + pointF.y;
    }

    public final void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final boolean c() {
        boolean z = true;
        if (this.f39195a != null && !this.b) {
            return true;
        }
        Map<Integer, List<k>> map = this.f;
        if (map == null) {
            return false;
        }
        for (Map.Entry<Integer, List<k>> entry : map.entrySet()) {
            if (entry.getKey().intValue() == this.e) {
                for (k kVar : entry.getValue()) {
                    if (kVar.d || kVar.c == null) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    public final float d() {
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int i2 = this.m;
        if (i2 == 2 || i2 == 4) {
            return Math.max((getWidth() - paddingRight) / g(), (getHeight() - paddingTop) / f());
        }
        if (i2 == 3) {
            float f2 = this.j;
            if (f2 > 0.0f) {
                return f2;
            }
        }
        return Math.min((getWidth() - paddingRight) / g(), (getHeight() - paddingTop) / f());
    }

    public final float d(float f2) {
        PointF pointF = this.z;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.x) / this.x;
    }

    public final void d(boolean z) {
        h hVar;
        a("reset newImage=" + z, new Object[0]);
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = Float.valueOf(0.0f);
        this.D = null;
        this.E = null;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = 0;
        this.e = 0;
        this.S = null;
        this.T = 0.0f;
        this.V = 0.0f;
        this.W = false;
        this.b0 = null;
        this.a0 = null;
        this.c0 = null;
        this.d0 = null;
        this.o0 = null;
        this.p0 = null;
        this.q0 = null;
        if (z) {
            this.d = null;
            this.P.writeLock().lock();
            try {
                com.kc.dw.ad.view.scaleImage.decoder.d dVar = this.O;
                if (dVar != null) {
                    dVar.b();
                    this.O = null;
                }
                this.P.writeLock().unlock();
                Bitmap bitmap = this.f39195a;
                if (bitmap != null && !this.c) {
                    bitmap.recycle();
                }
                if (this.f39195a != null && this.c && (hVar = this.g0) != null) {
                    hVar.b();
                }
                this.F = 0;
                this.G = 0;
                this.H = 0;
                this.e0 = false;
                this.f0 = false;
                this.f39195a = null;
                this.b = false;
                this.c = false;
            } catch (Throwable th) {
                this.P.writeLock().unlock();
                throw th;
            }
        }
        Map<Integer, List<k>> map = this.f;
        if (map != null) {
            Iterator<Map.Entry<Integer, List<k>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                for (k kVar : it.next().getValue()) {
                    kVar.e = false;
                    Bitmap bitmap2 = kVar.c;
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                        kVar.c = null;
                    }
                }
            }
            this.f = null;
        }
        setGestureDetector(getContext());
    }

    public final float e(float f2) {
        PointF pointF = this.z;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.y) / this.x;
    }

    public final void e() {
        Float f2;
        if (getWidth() == 0 || getHeight() == 0 || this.F <= 0 || this.G <= 0) {
            return;
        }
        if (this.D != null && (f2 = this.C) != null) {
            this.x = f2.floatValue();
            if (this.z == null) {
                this.z = new PointF();
            }
            this.z.x = (getWidth() / 2) - (this.x * this.D.x);
            this.z.y = (getHeight() / 2) - (this.x * this.D.y);
            this.D = null;
            this.C = null;
            a(true);
            b(true);
        }
        a(false);
    }

    public final int f() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.F : this.G;
    }

    public final int g() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.G : this.F;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        float width = getWidth() / 2;
        float height = getHeight() / 2;
        PointF pointF = new PointF();
        if (this.z == null) {
            return null;
        }
        pointF.set(d(width), e(height));
        return pointF;
    }

    public float getMaxScale() {
        return this.i;
    }

    public final float getMinScale() {
        return d();
    }

    public final int getOrientation() {
        return this.h;
    }

    public final int getSHeight() {
        return this.G;
    }

    public final int getSWidth() {
        return this.F;
    }

    public final float getScale() {
        return this.x;
    }

    public final ImageViewState getState() {
        if (this.z == null || this.F <= 0 || this.G <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    /* JADX WARN: Code duplicated, block: B:121:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:46:0x0158  */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        int i3;
        float width;
        k kVar;
        boolean z;
        super.onDraw(canvas);
        if (this.k0 == null) {
            Paint paint = new Paint();
            this.k0 = paint;
            paint.setAntiAlias(true);
            this.k0.setFilterBitmap(true);
            this.k0.setDither(true);
        }
        if ((this.l0 == null || this.m0 == null) && this.g) {
            Paint paint2 = new Paint();
            this.l0 = paint2;
            paint2.setTextSize(a(12));
            this.l0.setColor(-65281);
            this.l0.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.m0 = paint3;
            paint3.setColor(-65281);
            this.m0.setStyle(Paint.Style.STROKE);
            this.m0.setStrokeWidth(a(1));
        }
        if (this.F == 0 || this.G == 0 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.f == null && this.O != null) {
            a(new Point(Math.min(canvas.getMaximumBitmapWidth(), this.n), Math.min(canvas.getMaximumBitmapHeight(), this.o)));
        }
        if (b()) {
            e();
            d dVar = this.d0;
            if (dVar != null && dVar.f != null) {
                float f2 = this.x;
                if (this.B == null) {
                    this.B = new PointF(0.0f, 0.0f);
                }
                this.B.set(this.z);
                long jCurrentTimeMillis = System.currentTimeMillis();
                d dVar2 = this.d0;
                long j2 = jCurrentTimeMillis - dVar2.l;
                long j3 = dVar2.h;
                boolean z2 = j2 > j3;
                long jMin = Math.min(j2, j3);
                d dVar3 = this.d0;
                int i4 = dVar3.j;
                float f3 = dVar3.f39199a;
                this.x = a(i4, jMin, f3, dVar3.b - f3, dVar3.h);
                d dVar4 = this.d0;
                int i5 = dVar4.j;
                float f4 = dVar4.f.x;
                float fA = a(i5, jMin, f4, dVar4.g.x - f4, dVar4.h);
                d dVar5 = this.d0;
                int i6 = dVar5.j;
                float f5 = dVar5.f.y;
                float fA2 = a(i6, jMin, f5, dVar5.g.y - f5, dVar5.h);
                this.z.x -= b(this.d0.d.x) - fA;
                this.z.y -= c(this.d0.d.y) - fA2;
                if (z2) {
                    z = true;
                } else {
                    d dVar6 = this.d0;
                    if (dVar6.f39199a == dVar6.b) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                a(z);
                a(f2, this.B, this.d0.k);
                b(z2);
                if (z2) {
                    g gVar = this.d0.m;
                    if (gVar != null) {
                        try {
                            gVar.a();
                        } catch (Exception e2) {
                            Log.w("SubsamplingScaleImageView", "Error thrown by animation listener", e2);
                        }
                    }
                    this.d0 = null;
                }
                invalidate();
            }
            int i7 = 15;
            int i8 = 35;
            int i9 = 180;
            if (this.f == null || !c()) {
                i2 = 35;
                i3 = 15;
                Bitmap bitmap = this.f39195a;
                if (bitmap != null && !bitmap.isRecycled()) {
                    float height = this.x;
                    if (this.b) {
                        width = height * (this.F / this.f39195a.getWidth());
                        height = this.x * (this.G / this.f39195a.getHeight());
                    } else {
                        width = height;
                    }
                    if (this.p0 == null) {
                        this.p0 = new Matrix();
                    }
                    this.p0.reset();
                    this.p0.postScale(width, height);
                    this.p0.postRotate(getRequiredRotation());
                    Matrix matrix = this.p0;
                    PointF pointF = this.z;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix2 = this.p0;
                        float f6 = this.x;
                        matrix2.postTranslate(this.F * f6, f6 * this.G);
                    } else if (getRequiredRotation() == 90) {
                        this.p0.postTranslate(this.x * this.G, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.p0.postTranslate(0.0f, this.x * this.F);
                    }
                    if (this.n0 != null) {
                        if (this.q0 == null) {
                            this.q0 = new RectF();
                        }
                        this.q0.set(0.0f, 0.0f, this.b ? this.f39195a.getWidth() : this.F, this.b ? this.f39195a.getHeight() : this.G);
                        this.p0.mapRect(this.q0);
                        canvas.drawRect(this.q0, this.n0);
                    }
                    canvas.drawBitmap(this.f39195a, this.p0, this.k0);
                }
            } else {
                int iMin = Math.min(this.e, a(this.x));
                boolean z3 = false;
                for (Map.Entry<Integer, List<k>> entry : this.f.entrySet()) {
                    if (entry.getKey().intValue() == iMin) {
                        for (k kVar2 : entry.getValue()) {
                            if (kVar2.e && (kVar2.d || kVar2.c == null)) {
                                z3 = true;
                            }
                        }
                    }
                }
                for (Map.Entry<Integer, List<k>> entry2 : this.f.entrySet()) {
                    if (entry2.getKey().intValue() == iMin || z3) {
                        for (k kVar3 : entry2.getValue()) {
                            Rect rect = kVar3.f39203a;
                            kVar3.f.set((int) b(rect.left), (int) c(rect.top), (int) b(rect.right), (int) c(rect.bottom));
                            boolean z4 = kVar3.d;
                            if (z4 || kVar3.c == null) {
                                i9 = i9;
                                kVar = kVar3;
                                if (z4 && this.g) {
                                    i8 = 35;
                                    canvas.drawText("LOADING", a(5) + kVar.f.left, a(35) + kVar.f.top, this.l0);
                                }
                                if (kVar.e || !this.g) {
                                    i7 = 15;
                                } else {
                                    StringBuilder sbA = com.kc.dw.activity.a.a("ISS ");
                                    sbA.append(kVar.b);
                                    sbA.append(" RECT ");
                                    sbA.append(kVar.f39203a.top);
                                    sbA.append(",");
                                    sbA.append(kVar.f39203a.left);
                                    sbA.append(",");
                                    sbA.append(kVar.f39203a.bottom);
                                    sbA.append(",");
                                    sbA.append(kVar.f39203a.right);
                                    canvas.drawText(sbA.toString(), a(5) + kVar.f.left, a(15) + kVar.f.top, this.l0);
                                    i7 = 15;
                                }
                            } else {
                                Paint paint4 = this.n0;
                                if (paint4 != null) {
                                    canvas.drawRect(kVar3.f, paint4);
                                }
                                if (this.p0 == null) {
                                    this.p0 = new Matrix();
                                }
                                this.p0.reset();
                                i9 = i9;
                                kVar = kVar3;
                                a(this.r0, 0.0f, 0.0f, kVar3.c.getWidth(), 0.0f, kVar3.c.getWidth(), kVar3.c.getHeight(), 0.0f, kVar3.c.getHeight());
                                if (getRequiredRotation() == 0) {
                                    float[] fArr = this.s0;
                                    Rect rect2 = kVar.f;
                                    float f7 = rect2.left;
                                    float f8 = rect2.top;
                                    float f9 = rect2.right;
                                    float f10 = rect2.bottom;
                                    a(fArr, f7, f8, f9, f8, f9, f10, f7, f10);
                                } else if (getRequiredRotation() == 90) {
                                    float[] fArr2 = this.s0;
                                    Rect rect3 = kVar.f;
                                    float f11 = rect3.right;
                                    float f12 = rect3.top;
                                    float f13 = rect3.bottom;
                                    float f14 = rect3.left;
                                    a(fArr2, f11, f12, f11, f13, f14, f13, f14, f12);
                                } else if (getRequiredRotation() == i9) {
                                    float[] fArr3 = this.s0;
                                    Rect rect4 = kVar.f;
                                    float f15 = rect4.right;
                                    float f16 = rect4.bottom;
                                    float f17 = rect4.left;
                                    float f18 = rect4.top;
                                    a(fArr3, f15, f16, f17, f16, f17, f18, f15, f18);
                                } else if (getRequiredRotation() == 270) {
                                    float[] fArr4 = this.s0;
                                    Rect rect5 = kVar.f;
                                    float f19 = rect5.left;
                                    float f20 = rect5.bottom;
                                    float f21 = rect5.top;
                                    float f22 = rect5.right;
                                    a(fArr4, f19, f20, f19, f21, f22, f21, f22, f20);
                                }
                                this.p0.setPolyToPoly(this.r0, 0, this.s0, 0, 4);
                                canvas.drawBitmap(kVar.c, this.p0, this.k0);
                                if (this.g) {
                                    canvas.drawRect(kVar.f, this.m0);
                                }
                            }
                            i8 = 35;
                            if (kVar.e) {
                                i7 = 15;
                            } else {
                                i7 = 15;
                            }
                        }
                    }
                }
                i2 = i8;
                i3 = i7;
            }
            if (this.g) {
                StringBuilder sbA2 = com.kc.dw.activity.a.a("Scale: ");
                Locale locale = Locale.ENGLISH;
                sbA2.append(String.format(locale, "%.2f", Float.valueOf(this.x)));
                sbA2.append(" (");
                sbA2.append(String.format(locale, "%.2f", Float.valueOf(d())));
                sbA2.append(" - ");
                sbA2.append(String.format(locale, "%.2f", Float.valueOf(this.i)));
                sbA2.append(")");
                canvas.drawText(sbA2.toString(), a(5), a(i3), this.l0);
                canvas.drawText("Translate: " + String.format(locale, "%.2f", Float.valueOf(this.z.x)) + u15.f19942b + String.format(locale, "%.2f", Float.valueOf(this.z.y)), a(5), a(30), this.l0);
                PointF center = getCenter();
                StringBuilder sbA3 = com.kc.dw.activity.a.a("Source center: ");
                sbA3.append(String.format(locale, "%.2f", Float.valueOf(center.x)));
                sbA3.append(u15.f19942b);
                sbA3.append(String.format(locale, "%.2f", Float.valueOf(center.y)));
                canvas.drawText(sbA3.toString(), a(5), a(45), this.l0);
                d dVar7 = this.d0;
                if (dVar7 != null) {
                    PointF pointFA = a(dVar7.c);
                    PointF pointFA2 = a(this.d0.e);
                    PointF pointFA3 = a(this.d0.d);
                    canvas.drawCircle(pointFA.x, pointFA.y, a(10), this.m0);
                    this.m0.setColor(-65536);
                    canvas.drawCircle(pointFA2.x, pointFA2.y, a(20), this.m0);
                    this.m0.setColor(-16776961);
                    canvas.drawCircle(pointFA3.x, pointFA3.y, a(25), this.m0);
                    this.m0.setColor(-16711681);
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, a(30), this.m0);
                }
                if (this.S != null) {
                    this.m0.setColor(-65536);
                    PointF pointF2 = this.S;
                    canvas.drawCircle(pointF2.x, pointF2.y, a(20), this.m0);
                }
                if (this.b0 != null) {
                    this.m0.setColor(-16776961);
                    canvas.drawCircle(b(this.b0.x), c(this.b0.y), a(i2), this.m0);
                }
                if (this.c0 != null && this.K) {
                    this.m0.setColor(-16711681);
                    PointF pointF3 = this.c0;
                    canvas.drawCircle(pointF3.x, pointF3.y, a(30), this.m0);
                }
                this.m0.setColor(-65281);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean z = mode != 1073741824;
        boolean z2 = mode2 != 1073741824;
        if (this.F > 0 && this.G > 0) {
            if (z && z2) {
                size = g();
                size2 = f();
            } else if (z2) {
                size2 = (int) ((((double) f()) / ((double) g())) * ((double) size));
            } else if (z) {
                size = (int) ((((double) g()) / ((double) f())) * ((double) size2));
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (this.g) {
            Log.d("SubsamplingScaleImageView", String.format("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        PointF center = getCenter();
        if (!this.e0 || center == null) {
            return;
        }
        this.d0 = null;
        this.C = Float.valueOf(this.x);
        this.D = center;
    }

    /* JADX WARN: Code duplicated, block: B:171:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:209:0x0495  */
    /* JADX WARN: Code duplicated, block: B:211:0x0499  */
    /* JADX WARN: Code duplicated, block: B:212:0x04da  */
    /* JADX WARN: Code duplicated, block: B:214:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:216:0x04e8  */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0091, code lost:
    
        if (r8 != 262) goto L175;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        PointF pointF;
        float height;
        float f2;
        float f3;
        PointF pointF2;
        float height2;
        float f4;
        float f5;
        GestureDetector gestureDetector;
        g gVar;
        d dVar = this.d0;
        if (dVar != null && !dVar.i) {
            c(true);
            return true;
        }
        if (dVar != null && (gVar = dVar.m) != null) {
            try {
                gVar.b();
            } catch (Exception e2) {
                Log.w("SubsamplingScaleImageView", "Error thrown by animation listener", e2);
            }
        }
        this.d0 = null;
        if (this.z == null) {
            GestureDetector gestureDetector2 = this.N;
            if (gestureDetector2 != null) {
                gestureDetector2.onTouchEvent(motionEvent);
            }
            return true;
        }
        if (!this.K && ((gestureDetector = this.M) == null || gestureDetector.onTouchEvent(motionEvent))) {
            this.I = false;
            this.J = false;
            this.L = 0;
            return true;
        }
        float f6 = 0.0f;
        if (this.A == null) {
            this.A = new PointF(0.0f, 0.0f);
        }
        if (this.B == null) {
            this.B = new PointF(0.0f, 0.0f);
        }
        if (this.S == null) {
            this.S = new PointF(0.0f, 0.0f);
        }
        float f7 = this.x;
        this.B.set(this.z);
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d0 = null;
            c(true);
            this.L = Math.max(this.L, pointerCount);
            if (pointerCount >= 2) {
                if (this.s) {
                    float fA = a(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                    this.y = this.x;
                    this.T = fA;
                    PointF pointF3 = this.A;
                    PointF pointF4 = this.z;
                    pointF3.set(pointF4.x, pointF4.y);
                    z = false;
                    this.S.set((motionEvent.getX(1) + motionEvent.getX(0)) / 2.0f, (motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f);
                } else {
                    z = false;
                    this.L = 0;
                }
                this.j0.removeMessages(1);
            } else {
                z = false;
                z = false;
                if (!this.K) {
                    PointF pointF5 = this.A;
                    PointF pointF6 = this.z;
                    pointF5.set(pointF6.x, pointF6.y);
                    this.S.set(motionEvent.getX(), motionEvent.getY());
                    this.j0.sendEmptyMessageDelayed(1, 600L);
                }
            }
            z2 = true;
        } else {
            if (action != 1) {
                if (action != 2) {
                    if (action != 5) {
                        if (action != 6) {
                            if (action != 261) {
                            }
                            z2 = true;
                        }
                    }
                    this.d0 = null;
                    c(true);
                    this.L = Math.max(this.L, pointerCount);
                    if (pointerCount >= 2) {
                        if (this.s) {
                            float fA2 = a(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                            this.y = this.x;
                            this.T = fA2;
                            PointF pointF7 = this.A;
                            PointF pointF8 = this.z;
                            pointF7.set(pointF8.x, pointF8.y);
                            z = false;
                            this.S.set((motionEvent.getX(1) + motionEvent.getX(0)) / 2.0f, (motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f);
                        } else {
                            z = false;
                            this.L = 0;
                        }
                        this.j0.removeMessages(1);
                    } else {
                        z = false;
                        z = false;
                        if (!this.K) {
                            PointF pointF9 = this.A;
                            PointF pointF10 = this.z;
                            pointF9.set(pointF10.x, pointF10.y);
                            this.S.set(motionEvent.getX(), motionEvent.getY());
                            this.j0.sendEmptyMessageDelayed(1, 600L);
                        }
                    }
                    z2 = true;
                } else {
                    if (this.L <= 0) {
                        z5 = false;
                    } else if (pointerCount >= 2) {
                        float fA3 = a(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                        float x = (motionEvent.getX(1) + motionEvent.getX(0)) / 2.0f;
                        float y = (motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f;
                        if (this.s) {
                            PointF pointF11 = this.S;
                            if (a(pointF11.x, x, pointF11.y, y) > 5.0f || Math.abs(fA3 - this.T) > 5.0f || this.J) {
                                this.I = true;
                                this.J = true;
                                double d2 = this.x;
                                float fMin = Math.min(this.i, (fA3 / this.T) * this.y);
                                this.x = fMin;
                                if (fMin <= d()) {
                                    this.T = fA3;
                                    this.y = d();
                                    this.S.set(x, y);
                                    this.A.set(this.z);
                                } else if (this.r) {
                                    PointF pointF12 = this.S;
                                    float f8 = pointF12.x;
                                    PointF pointF13 = this.A;
                                    float f9 = pointF13.x;
                                    float f10 = pointF12.y;
                                    float f11 = pointF13.y;
                                    float f12 = this.x / this.y;
                                    PointF pointF14 = this.z;
                                    pointF14.x = x - ((f8 - f9) * f12);
                                    pointF14.y = y - (f12 * (f10 - f11));
                                    if ((((double) f()) * d2 < getHeight() && this.x * f() >= getHeight()) || (d2 * ((double) g()) < getWidth() && this.x * g() >= getWidth())) {
                                        a(true);
                                        this.S.set(x, y);
                                        this.A.set(this.z);
                                        this.y = this.x;
                                        this.T = fA3;
                                    }
                                } else {
                                    if (this.E != null) {
                                        this.z.x = (getWidth() / 2) - (this.x * this.E.x);
                                        pointF2 = this.z;
                                        height2 = getHeight() / 2;
                                        f4 = this.x;
                                        f5 = this.E.y;
                                    } else {
                                        this.z.x = (getWidth() / 2) - (this.x * (g() / 2));
                                        pointF2 = this.z;
                                        height2 = getHeight() / 2;
                                        f4 = this.x;
                                        f5 = f() / 2;
                                    }
                                    pointF2.y = height2 - (f4 * f5);
                                }
                                a(true);
                                b(this.q);
                                z5 = true;
                            }
                        }
                        z5 = false;
                    } else {
                        if (this.K) {
                            float fAbs = (Math.abs(this.c0.y - motionEvent.getY()) * 2.0f) + this.U;
                            if (this.V == -1.0f) {
                                this.V = fAbs;
                            }
                            float y2 = motionEvent.getY();
                            PointF pointF15 = this.a0;
                            boolean z7 = y2 > pointF15.y;
                            pointF15.set(0.0f, motionEvent.getY());
                            float f13 = 1.0f;
                            float fAbs2 = Math.abs(1.0f - (fAbs / this.V)) * 0.5f;
                            if (fAbs2 > 0.03f || this.W) {
                                this.W = true;
                                if (this.V > 0.0f) {
                                    f13 = z7 ? 1.0f + fAbs2 : 1.0f - fAbs2;
                                }
                                double d3 = this.x;
                                float fMax = Math.max(d(), Math.min(this.i, this.x * f13));
                                this.x = fMax;
                                if (this.r) {
                                    PointF pointF16 = this.S;
                                    float f14 = pointF16.x;
                                    PointF pointF17 = this.A;
                                    float f15 = pointF17.x;
                                    float f16 = pointF16.y;
                                    float f17 = pointF17.y;
                                    float f18 = fMax / this.y;
                                    PointF pointF18 = this.z;
                                    pointF18.x = f14 - ((f14 - f15) * f18);
                                    pointF18.y = f16 - (f18 * (f16 - f17));
                                    if ((((double) f()) * d3 < getHeight() && this.x * f() >= getHeight()) || (d3 * ((double) g()) < getWidth() && this.x * g() >= getWidth())) {
                                        a(true);
                                        this.S.set(a(this.b0));
                                        this.A.set(this.z);
                                        this.y = this.x;
                                    }
                                } else {
                                    if (this.E != null) {
                                        this.z.x = (getWidth() / 2) - (this.x * this.E.x);
                                        pointF = this.z;
                                        height = getHeight() / 2;
                                        f2 = this.x;
                                        f3 = this.E.y;
                                    } else {
                                        this.z.x = (getWidth() / 2) - (this.x * (g() / 2));
                                        pointF = this.z;
                                        height = getHeight() / 2;
                                        f2 = this.x;
                                        f3 = f() / 2;
                                    }
                                    pointF.y = height - (f2 * f3);
                                }
                                f6 = fAbs;
                            } else {
                                f6 = fAbs;
                            }
                            this.V = f6;
                            a(true);
                        } else {
                            if (!this.I) {
                                float fAbs3 = Math.abs(motionEvent.getX() - this.S.x);
                                float fAbs4 = Math.abs(motionEvent.getY() - this.S.y);
                                float f19 = this.t0 * 5.0f;
                                if (fAbs3 > f19 || fAbs4 > f19 || this.J) {
                                    this.z.x = (motionEvent.getX() - this.S.x) + this.A.x;
                                    this.z.y = (motionEvent.getY() - this.S.y) + this.A.y;
                                    PointF pointF19 = this.z;
                                    float f20 = pointF19.x;
                                    float f21 = pointF19.y;
                                    a(true);
                                    PointF pointF20 = this.z;
                                    boolean z8 = f20 != pointF20.x;
                                    float f22 = pointF20.y;
                                    boolean z9 = f21 != f22;
                                    boolean z10 = z8 && fAbs3 > fAbs4 && !this.J;
                                    boolean z11 = z9 && fAbs4 > fAbs3 && !this.J;
                                    boolean z12 = f21 == f22 && fAbs4 > 3.0f * f19;
                                    if (z10 || z11 || (z8 && z9 && !z12 && !this.J)) {
                                        if (fAbs3 > f19 || fAbs4 > f19) {
                                            z6 = false;
                                            this.L = 0;
                                            this.j0.removeMessages(1);
                                            c(false);
                                        }
                                        if (!this.r) {
                                            PointF pointF21 = this.z;
                                            PointF pointF22 = this.A;
                                            pointF21.x = pointF22.x;
                                            pointF21.y = pointF22.y;
                                            c(z6);
                                        }
                                    } else {
                                        this.J = true;
                                    }
                                    z6 = false;
                                    if (!this.r) {
                                        PointF pointF23 = this.z;
                                        PointF pointF24 = this.A;
                                        pointF23.x = pointF24.x;
                                        pointF23.y = pointF24.y;
                                        c(z6);
                                    }
                                }
                            }
                            z5 = false;
                        }
                        b(this.q);
                        z5 = true;
                    }
                    if (z5) {
                        this.j0.removeMessages(1);
                        invalidate();
                        z2 = true;
                    }
                    z = false;
                }
                z2 = false;
                z = false;
            }
            this.j0.removeMessages(1);
            if (this.K) {
                this.K = false;
                if (!this.W) {
                    a(this.b0, this.S);
                }
            }
            if (this.L <= 0 || !((z4 = this.I) || this.J)) {
                z3 = false;
                z3 = false;
                if (pointerCount == 1) {
                    this.I = false;
                    this.J = false;
                    this.L = 0;
                }
            } else {
                if (z4 && pointerCount == 2) {
                    this.J = true;
                    PointF pointF25 = this.A;
                    PointF pointF26 = this.z;
                    pointF25.set(pointF26.x, pointF26.y);
                    if (motionEvent.getActionIndex() == 1) {
                        this.S.set(motionEvent.getX(0), motionEvent.getY(0));
                    } else {
                        this.S.set(motionEvent.getX(1), motionEvent.getY(1));
                    }
                }
                if (pointerCount < 3) {
                    z3 = false;
                    this.I = false;
                } else {
                    z3 = false;
                }
                if (pointerCount < 2) {
                    this.J = z3;
                    this.L = z3 ? 1 : 0;
                }
                b(true);
            }
            z = z3;
            z2 = true;
        }
        a(f7, this.B, 2);
        if (z2 || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return z;
    }

    public final void setBitmapDecoderClass(Class<? extends com.kc.dw.ad.view.scaleImage.decoder.c> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.Q = new com.kc.dw.ad.view.scaleImage.decoder.a(cls, null);
    }

    public final void setBitmapDecoderFactory(com.kc.dw.ad.view.scaleImage.decoder.b<? extends com.kc.dw.ad.view.scaleImage.decoder.c> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.Q = bVar;
    }

    public final void setDebug(boolean z) {
        this.g = z;
    }

    public final void setDoubleTapZoomDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setDoubleTapZoomDuration(int i2) {
        this.w = Math.max(0, i2);
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.u = f2;
    }

    public final void setDoubleTapZoomStyle(int i2) {
        if (v0.contains(Integer.valueOf(i2))) {
            this.v = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i2);
    }

    public void setEagerLoadingEnabled(boolean z) {
        this.q = z;
    }

    public void setExecutor(Executor executor) {
        if (executor == null) {
            throw new NullPointerException("Executor must not be null");
        }
        this.p = executor;
    }

    public final void setImage(com.kc.dw.ad.view.scaleImage.a aVar) {
        if (aVar == null) {
            throw new NullPointerException("imageSource must not be null");
        }
        d(true);
        Uri uri = aVar.f39206a;
        this.d = uri;
        if (uri == null && aVar.b != null) {
            StringBuilder sbA = com.kc.dw.activity.a.a("android.resource://");
            sbA.append(getContext().getPackageName());
            sbA.append(WVNativeCallbackUtil.SEPERATER);
            sbA.append(aVar.b);
            this.d = Uri.parse(sbA.toString());
        }
        if (aVar.c) {
            new m(this, getContext(), this.R, this.d).executeOnExecutor(this.p, new Void[0]);
        } else {
            new f(this, getContext(), this.Q, this.d, false).executeOnExecutor(this.p, new Void[0]);
        }
    }

    public final void setMaxScale(float f2) {
        this.i = f2;
    }

    public void setMaxTileSize(int i2) {
        this.n = i2;
        this.o = i2;
    }

    public final void setMaximumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setMinScale(float f2) {
        this.j = f2;
    }

    public final void setMinimumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setMinimumScaleType(int i2) {
        if (!y0.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid scale type: " + i2);
        }
        this.m = i2;
        if (this.e0) {
            a(true);
            invalidate();
        }
    }

    public void setMinimumTileDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.k = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i2);
        if (this.e0) {
            d(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(h hVar) {
        this.g0 = hVar;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.i0 = onLongClickListener;
    }

    public void setOnStateChangedListener(i iVar) {
        this.h0 = iVar;
    }

    public final void setOrientation(int i2) {
        if (!u0.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid orientation: " + i2);
        }
        this.h = i2;
        d(false);
        invalidate();
        requestLayout();
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        this.r = z;
        if (z || (pointF = this.z) == null) {
            return;
        }
        pointF.x = (getWidth() / 2) - (this.x * (g() / 2));
        this.z.y = (getHeight() / 2) - (this.x * (f() / 2));
        if (this.e0) {
            b(true);
            invalidate();
        }
    }

    public final void setPanLimit(int i2) {
        if (!x0.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid pan limit: " + i2);
        }
        this.l = i2;
        if (this.e0) {
            a(true);
            invalidate();
        }
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.t = z;
    }

    public final void setRegionDecoderClass(Class<? extends com.kc.dw.ad.view.scaleImage.decoder.d> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.R = new com.kc.dw.ad.view.scaleImage.decoder.a(cls, null);
    }

    public final void setRegionDecoderFactory(com.kc.dw.ad.view.scaleImage.decoder.b<? extends com.kc.dw.ad.view.scaleImage.decoder.d> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.R = bVar;
    }

    public final void setTileBackgroundColor(int i2) {
        if (Color.alpha(i2) == 0) {
            this.n0 = null;
        } else {
            Paint paint = new Paint();
            this.n0 = paint;
            paint.setStyle(Paint.Style.FILL);
            this.n0.setColor(i2);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z) {
        this.s = z;
    }
}
