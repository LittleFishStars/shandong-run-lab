package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.ExifInterface;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.androidquery.auth.AccountHandle;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.util.BitmapCache;
import com.androidquery.util.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class xv0 extends AbstractAjaxCallback<Bitmap, xv0> {
    public static int V = 20;
    public static int W = 20;
    public static int X = 2500;
    public static int Y = 160000;
    public static int Z = 1000000;
    public static final int a0 = 300;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static Map<String, Bitmap> f20733d = null;
    public static Map<String, Bitmap> e = null;
    public static Map<String, Bitmap> f = null;
    public static boolean n = false;
    public int R;
    public int S;
    public int T;
    public int U;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f20734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f20735a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Bitmap f20736b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public File f20737c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public WeakReference<ImageView> f20738c;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, WeakHashMap<ImageView, xv0>> f45902a = new HashMap<>();
    public static Bitmap c = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    public static Bitmap d = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    public boolean k = true;
    public float b = Float.MAX_VALUE;

    public xv0() {
        E0(Bitmap.class).b0(true).z(true).G0("");
    }

    public static int A1(int i, int i2) {
        int i3 = 1;
        for (int i4 = 0; i4 < 10 && i >= i2 * 2; i4++) {
            i /= 2;
            i3 *= 2;
        }
        return i3;
    }

    public static void C1(ImageView imageView, Bitmap bitmap, Bitmap bitmap2, int i, int i2, float f2, float f3, int i3) {
        Animation animationLoadAnimation;
        Drawable drawable;
        Drawable drawable2;
        Bitmap bitmapC1 = c1(imageView, bitmap, i);
        if (bitmapC1 == null) {
            imageView.setImageBitmap(null);
            return;
        }
        Drawable drawableR1 = r1(imageView, bitmapC1, f2, f3);
        if (Z0(i2, i3)) {
            if (bitmap2 == null) {
                animationLoadAnimation = new AlphaAnimation(0.0f, 1.0f);
                animationLoadAnimation.setInterpolator(new DecelerateInterpolator());
                animationLoadAnimation.setDuration(300L);
                drawable2 = drawableR1;
            } else {
                TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{r1(imageView, bitmap2, f2, f3), drawableR1});
                transitionDrawable.setCrossFadeEnabled(true);
                transitionDrawable.startTransition(300);
                drawable = transitionDrawable;
                animationLoadAnimation = null;
                drawable2 = drawable;
            }
        } else if (i2 > 0) {
            animationLoadAnimation = AnimationUtils.loadAnimation(imageView.getContext(), i2);
            drawable2 = drawableR1;
        } else {
            animationLoadAnimation = null;
            drawable2 = drawable;
        }
        imageView.setImageDrawable(drawable2);
        if (animationLoadAnimation == null) {
            imageView.setAnimation(null);
        } else {
            animationLoadAnimation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
            imageView.startAnimation(animationLoadAnimation);
        }
    }

    public static void D1(int i) {
        W = i;
        W0();
    }

    public static void E1(boolean z) {
        n = z;
    }

    public static void F1(int i) {
        V = i;
        W0();
    }

    public static void G1(int i) {
        Z = i;
        W0();
    }

    public static void H1(int i) {
        Y = i;
        W0();
    }

    public static void I1(int i) {
        X = i;
        W0();
    }

    public static void Q0(Activity activity, Context context, ImageView imageView, String str, Object obj, AccountHandle accountHandle, l74 l74Var, HttpHost httpHost, String str2) {
        R0(activity, context, imageView, str, l74Var.f17894a, l74Var.f17896b, l74Var.f17895b, l74Var.c, l74Var.f17893a, l74Var.d, l74Var.f43010a, l74Var.b, obj, accountHandle, l74Var.f17892a, l74Var.e, httpHost, str2);
    }

    public static void R0(Activity activity, Context context, ImageView imageView, String str, boolean z, boolean z2, int i, int i2, Bitmap bitmap, int i3, float f2, float f3, Object obj, AccountHandle accountHandle, int i4, int i5, HttpHost httpHost, String str2) {
        Bitmap bitmapS1 = z ? s1(str, i, i5) : null;
        if (bitmapS1 != null) {
            imageView.setTag(Constants.u, str);
            vp1.n(obj, str, false);
            C1(imageView, bitmapS1, bitmap, i2, i3, f2, f3, 4);
            return;
        }
        xv0 xv0Var = new xv0();
        xv0Var.G0(str).p1(imageView).b0(z).z(z2).J1(i).a1(i2).u1(bitmap).P0(i3).w1(f2).O0(f3).o0(obj).h(accountHandle).l0(i4).z1(i5).f0(str2);
        if (httpHost != null) {
            xv0Var.p0(httpHost.getHostName(), httpHost.getPort());
        }
        if (activity != null) {
            xv0Var.e(activity);
        } else {
            xv0Var.f(context);
        }
    }

    public static void W0() {
        e = null;
        f20733d = null;
        f = null;
    }

    public static Bitmap X0(String str, byte[] bArr, BitmapFactory.Options options, boolean z) throws Throwable {
        Bitmap bitmapDecodeByteArray;
        if (str != null) {
            bitmapDecodeByteArray = Y0(str, options, z);
        } else {
            bitmapDecodeByteArray = bArr != null ? BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options) : null;
        }
        if (bitmapDecodeByteArray == null && options != null && !options.inJustDecodeBounds) {
            gq.j("decode image failed", str);
        }
        return bitmapDecodeByteArray;
    }

    public static Bitmap Y0(String str, BitmapFactory.Options options, boolean z) throws Throwable {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        options.inInputShareable = true;
        options.inPurgeable = true;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileInputStream2.getFD(), null, options);
                    if (bitmapDecodeFileDescriptor != null && z) {
                        bitmapDecodeFileDescriptor = x1(str, bitmapDecodeFileDescriptor);
                    }
                    gq.f(fileInputStream2);
                    return bitmapDecodeFileDescriptor;
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    gq.Q(e);
                    gq.f(fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    gq.f(fileInputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean Z0(int i, int i2) {
        if (i != -3) {
            if (i != -2) {
                return i == -1;
            }
        } else if (i2 == 3) {
            return true;
        }
        return i2 == 1;
    }

    public static Bitmap c1(View view, Bitmap bitmap, int i) {
        if (bitmap != null && bitmap.getWidth() == 1 && bitmap.getHeight() == 1 && bitmap != c) {
            bitmap = null;
        }
        if (bitmap != null) {
            view.setVisibility(0);
        } else if (i == -2) {
            view.setVisibility(8);
        } else if (i == -1) {
            view.setVisibility(4);
        }
        return bitmap;
    }

    public static void clearTasks() {
        f45902a.clear();
    }

    public static Map<String, Bitmap> d1() {
        if (e == null) {
            e = Collections.synchronizedMap(new BitmapCache(W, Y, Z));
        }
        return e;
    }

    public static Bitmap e1() {
        return c;
    }

    public static Map<String, Bitmap> g1() {
        if (f == null) {
            f = Collections.synchronizedMap(new BitmapCache(100, Y, 250000));
        }
        return f;
    }

    public static String h1(String str, int i, int i2) {
        if (i > 0) {
            str = str + "#" + i;
        }
        if (i2 <= 0) {
            return str;
        }
        return str + "#" + i2;
    }

    public static Bitmap i1(Context context, int i) {
        String string = Integer.toString(i);
        Bitmap bitmapS1 = s1(string, 0, 0);
        if (bitmapS1 == null && (bitmapS1 = BitmapFactory.decodeResource(context.getResources(), i)) != null) {
            t1(string, 0, 0, bitmapS1, false);
        }
        return bitmapS1;
    }

    public static Bitmap j1(String str, int i) {
        return s1(str, i, 0);
    }

    public static Bitmap k1(String str, byte[] bArr, int i, boolean z, int i2) {
        return l1(str, bArr, i, z, i2, false);
    }

    public static Bitmap l1(String str, byte[] bArr, int i, boolean z, int i2, boolean z2) throws Throwable {
        BitmapFactory.Options options;
        Bitmap bitmapX0 = null;
        if (str == null && bArr == null) {
            return null;
        }
        if (i > 0) {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            X0(str, bArr, options2, z2);
            int iMax = options2.outWidth;
            if (!z) {
                iMax = Math.max(iMax, options2.outHeight);
            }
            int iA1 = A1(iMax, i);
            options = new BitmapFactory.Options();
            options.inSampleSize = iA1;
        } else {
            options = null;
        }
        try {
            bitmapX0 = X0(str, bArr, options, z2);
        } catch (OutOfMemoryError e2) {
            W0();
            gq.Q(e2);
        }
        return i2 > 0 ? n1(bitmapX0, i2) : bitmapX0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Matrix m1(int i) {
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return matrix;
            case 3:
                matrix.setRotate(180.0f);
                return matrix;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return matrix;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return matrix;
            case 6:
                matrix.setRotate(90.0f);
                return matrix;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return matrix;
            case 8:
                matrix.setRotate(-90.0f);
                return matrix;
            default:
                return matrix;
        }
    }

    public static Bitmap n1(Bitmap bitmap, int i) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f2 = i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public static Map<String, Bitmap> o1() {
        if (f20733d == null) {
            f20733d = Collections.synchronizedMap(new BitmapCache(V, X, 250000));
        }
        return f20733d;
    }

    public static boolean q1(String str) {
        return d1().containsKey(str) || o1().containsKey(str) || g1().containsKey(str);
    }

    public static Drawable r1(ImageView imageView, Bitmap bitmap, float f2, float f3) {
        return f2 > 0.0f ? new db7(imageView.getResources(), bitmap, imageView, f2, f3) : new BitmapDrawable(imageView.getResources(), bitmap);
    }

    public static Bitmap s1(String str, int i, int i2) {
        String strH1 = h1(str, i, i2);
        Bitmap bitmap = d1().get(strH1);
        if (bitmap == null) {
            bitmap = o1().get(strH1);
        }
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmap2 = g1().get(strH1);
        if (bitmap2 == null || AbstractAjaxCallback.getLastStatus() != 200) {
            return bitmap2;
        }
        f = null;
        return null;
    }

    public static void t1(String str, int i, int i2, Bitmap bitmap, boolean z) {
        Map<String, Bitmap> mapO1;
        if (bitmap == null) {
            return;
        }
        int width = bitmap.getWidth() * bitmap.getHeight();
        if (z) {
            mapO1 = g1();
        } else {
            mapO1 = width <= X ? o1() : d1();
        }
        if (i <= 0 && i2 <= 0) {
            mapO1.put(str, bitmap);
            return;
        }
        mapO1.put(h1(str, i, i2), bitmap);
        if (mapO1.containsKey(str)) {
            return;
        }
        mapO1.put(str, null);
    }

    public static Bitmap x1(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int attributeInt = 1;
        try {
            attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
        } catch (Exception e2) {
            gq.k(e2);
        }
        if (attributeInt <= 0) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m1(attributeInt), true);
        gq.j("before", bitmap.getWidth() + u15.f19942b + bitmap.getHeight());
        gq.j("after", bitmapCreateBitmap.getWidth() + u15.f19942b + bitmapCreateBitmap.getHeight());
        if (bitmap != bitmapCreateBitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public final void B1(String str, ImageView imageView, Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            imageView.setImageDrawable(null);
            return;
        }
        if (z) {
            imageView.setImageDrawable(r1(imageView, bitmap, this.f20734a, this.b));
            return;
        }
        c30 c30Var = ((AbstractAjaxCallback) this).f1166a;
        if (c30Var != null) {
            C1(imageView, bitmap, this.f20736b, this.S, this.T, this.f20734a, this.b, c30Var.o());
        }
    }

    public xv0 J1(int i) {
        this.R = i;
        return this;
    }

    @Override // com.androidquery.callback.AbstractAjaxCallback
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public Bitmap transform(String str, byte[] bArr, c30 c30Var) {
        File file = c30Var.getFile();
        Bitmap bitmapT0 = T0(file != null ? file.getAbsolutePath() : null, bArr);
        if (bitmapT0 == null) {
            int i = this.S;
            if (i > 0) {
                bitmapT0 = f1();
            } else if (i == -2 || i == -1) {
                bitmapT0 = d;
            } else if (i == -3) {
                bitmapT0 = this.f20736b;
            }
            if (c30Var.f() != 200) {
                this.l = true;
            }
        }
        return bitmapT0;
    }

    public final void N0(String str, ImageView imageView) {
        WeakHashMap<ImageView, xv0> weakHashMap = f45902a.get(str);
        if (weakHashMap != null) {
            weakHashMap.put(imageView, this);
        } else {
            if (!f45902a.containsKey(str)) {
                f45902a.put(str, null);
                return;
            }
            WeakHashMap<ImageView, xv0> weakHashMap2 = new WeakHashMap<>();
            weakHashMap2.put(imageView, this);
            f45902a.put(str, weakHashMap2);
        }
    }

    public xv0 O0(float f2) {
        this.b = f2;
        return this;
    }

    public xv0 P0(int i) {
        this.T = i;
        return this;
    }

    public xv0 S0(Bitmap bitmap) {
        this.f20735a = bitmap;
        return this;
    }

    public final Bitmap T0(String str, byte[] bArr) {
        return l1(str, bArr, this.R, this.k, this.U, this.m);
    }

    @Override // com.androidquery.callback.AbstractAjaxCallback
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public final void l(String str, Bitmap bitmap, c30 c30Var) {
        ImageView imageView = this.f20738c.get();
        WeakHashMap<ImageView, xv0> weakHashMapRemove = f45902a.remove(str);
        if (weakHashMapRemove == null || !weakHashMapRemove.containsKey(imageView)) {
            V0(this, str, imageView, bitmap, c30Var);
        }
        if (weakHashMapRemove != null) {
            for (ImageView imageView2 : weakHashMapRemove.keySet()) {
                xv0 xv0Var = weakHashMapRemove.get(imageView2);
                ((AbstractAjaxCallback) xv0Var).f1166a = c30Var;
                V0(xv0Var, str, imageView2, bitmap, c30Var);
            }
        }
    }

    public final void V0(xv0 xv0Var, String str, ImageView imageView, Bitmap bitmap, c30 c30Var) {
        if (imageView == null || xv0Var == null) {
            return;
        }
        if (str.equals(imageView.getTag(Constants.u))) {
            xv0Var.callback(str, imageView, bitmap, c30Var);
        }
        xv0Var.showProgress(false);
    }

    public xv0 a1(int i) {
        this.S = i;
        return this;
    }

    @Override // com.androidquery.callback.AbstractAjaxCallback
    public File accessFile(File file, String str) {
        File file2 = this.f20737c;
        return (file2 == null || !file2.exists()) ? super.accessFile(file, str) : this.f20737c;
    }

    public xv0 b1(File file) {
        this.f20737c = file;
        return this;
    }

    public void callback(String str, ImageView imageView, Bitmap bitmap, c30 c30Var) {
        B1(str, imageView, bitmap, false);
    }

    @Override // com.androidquery.callback.AbstractAjaxCallback
    public void f(Context context) {
        String strO = O();
        ImageView imageView = this.f20738c.get();
        if (strO == null) {
            showProgress(false);
            B1(strO, imageView, null, false);
            return;
        }
        Bitmap bitmapMemGet = memGet(strO);
        if (bitmapMemGet != null) {
            imageView.setTag(Constants.u, strO);
            c30 c30VarC = new c30().source(4).c();
            ((AbstractAjaxCallback) this).f1166a = c30VarC;
            l(strO, bitmapMemGet, c30VarC);
            return;
        }
        v1(strO, imageView);
        if (f45902a.containsKey(strO)) {
            showProgress(true);
            N0(strO, imageView);
        } else {
            N0(strO, imageView);
            super.f(imageView.getContext());
        }
    }

    public final Bitmap f1() {
        ImageView imageView = this.f20738c.get();
        if (imageView == null) {
            return null;
        }
        String string = Integer.toString(this.S);
        Bitmap bitmapMemGet = memGet(string);
        if (bitmapMemGet != null) {
            return bitmapMemGet;
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(imageView.getResources(), this.S);
        if (bitmapDecodeResource == null) {
            return bitmapDecodeResource;
        }
        memPut(string, bitmapDecodeResource);
        return bitmapDecodeResource;
    }

    @Override // com.androidquery.callback.AbstractAjaxCallback
    public boolean isStreamingContent() {
        return !n;
    }

    public xv0 p1(ImageView imageView) {
        this.f20738c = new WeakReference<>(imageView);
        return this;
    }

    public xv0 u1(Bitmap bitmap) {
        this.f20736b = bitmap;
        return this;
    }

    public final void v1(String str, ImageView imageView) {
        if (str.equals(imageView.getTag(Constants.u)) && this.f20736b == null) {
            return;
        }
        imageView.setTag(Constants.u, str);
        if (this.f20736b == null || cacheAvailable(imageView.getContext())) {
            B1(str, imageView, null, true);
        } else {
            B1(str, imageView, this.f20736b, true);
        }
    }

    public xv0 w1(float f2) {
        this.f20734a = f2;
        return this;
    }

    public xv0 y1(boolean z) {
        this.m = z;
        return this;
    }

    public xv0 z1(int i) {
        this.U = i;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.androidquery.callback.AbstractAjaxCallback
    public Bitmap fileGet(String str, File file, c30 c30Var) {
        return T0(file.getAbsolutePath(), null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.androidquery.callback.AbstractAjaxCallback
    public Bitmap memGet(String str) {
        Bitmap bitmap = this.f20735a;
        if (bitmap != null) {
            return bitmap;
        }
        if (((AbstractAjaxCallback) this).f1180b) {
            return s1(str, this.R, this.U);
        }
        return null;
    }

    @Override // com.androidquery.callback.AbstractAjaxCallback
    public void memPut(String str, Bitmap bitmap) {
        t1(str, this.R, this.U, bitmap, this.l);
    }

    @Override // com.androidquery.callback.AbstractAjaxCallback
    public void skip(String str, Bitmap bitmap, c30 c30Var) {
        f45902a.remove(str);
    }
}
