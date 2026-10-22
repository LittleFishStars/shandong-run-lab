package com.fl.saas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.widget.ImageView;
import com.fl.saas.AbstractC1398a0;
import com.fl.saas.adx.util.DeviceUtil;

/* JADX INFO: renamed from: com.fl.saas.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1398a0 {
    public static Bitmap a(Context context, int i) {
        return BitmapFactory.decodeResource(context.getResources(), i);
    }

    public static Drawable a(Context context, Bitmap bitmap) {
        if (context == null || bitmap == null) {
            return null;
        }
        try {
            return new BitmapDrawable(context.getResources(), bitmap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Drawable drawable, final ImageView imageView) {
        final Bitmap bitmapA = a(imageView.getContext(), Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200);
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.fha
            @Override // java.lang.Runnable
            public final void run() {
                imageView.setImageBitmap(bitmapA);
            }
        });
    }

    public static Bitmap a(Context context, Boolean bool, Bitmap bitmap, int i) {
        try {
            int iMax = Math.max(1, i);
            if (bool.booleanValue()) {
                bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            }
            RenderScript renderScriptCreate = RenderScript.create(context);
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            int i2 = iMax / 25;
            int i3 = iMax % 25;
            for (int i4 = 0; i4 < i2; i4++) {
                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                scriptIntrinsicBlurCreate.setRadius(25.0f);
                scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
                allocationCreateFromBitmap.copyFrom(allocationCreateTyped);
            }
            if (i3 > 0) {
                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                scriptIntrinsicBlurCreate.setRadius(i3);
                scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            }
            allocationCreateTyped.copyTo(bitmap);
            renderScriptCreate.destroy();
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(final ImageView imageView, final Drawable drawable) {
        if (imageView != null && (drawable instanceof BitmapDrawable)) {
            c1.a().b(new Runnable() { // from class: com.zj.adlib.eha
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC1398a0.a(drawable, imageView);
                }
            });
        }
    }

    public static Bitmap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Paint paint = new Paint(1);
        paint.setTextSize(DeviceUtil.dip2px(12.0f));
        paint.setColor(-1);
        float fMeasureText = paint.measureText(str);
        float fDescent = paint.descent() - paint.ascent();
        int iDip2px = DeviceUtil.dip2px(2.0f);
        int i = iDip2px * 3;
        int iRound = Math.round((iDip2px * 2) + fDescent);
        int iRound2 = Math.round(fMeasureText + (iDip2px * 6));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iRound2, iRound, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint2 = new Paint();
        paint2.setColor(Color.parseColor("#70000000"));
        float f = iRound2;
        float f2 = iRound;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint2);
        canvas.drawText(str, i, ((f2 - fDescent) / 2.0f) - paint.ascent(), paint);
        return bitmapCreateBitmap;
    }
}
