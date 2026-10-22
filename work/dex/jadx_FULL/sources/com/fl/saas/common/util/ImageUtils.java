package com.fl.saas.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ImageUtils {
    public static BitmapDrawable bitmapDrawableToRoundCorner(BitmapDrawable bitmapDrawable, int i) {
        return new BitmapDrawable(bitmapToRoundCorner(bitmapDrawable.getBitmap(), i));
    }

    public static byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Drawable bitmapToDrawable(Resources resources, Bitmap bitmap) {
        return new BitmapDrawable(resources, bitmap);
    }

    public static Drawable bitmapToDrawable(Resources resources, Bitmap bitmap, int i, int i2) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmap);
        bitmapDrawable.setBounds(0, 0, i, i2);
        return bitmapDrawable;
    }

    public static Drawable bitmapToDrawable(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    public static InputStream bitmapToInputStream(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public static Bitmap bitmapToRoundCorner(Bitmap bitmap, int i) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public static Bitmap byteArrayToBitmap(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    public static Drawable byteArrayToDrawable(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = 2;
        return new BitmapDrawable(BitmapFactory.decodeStream(byteArrayInputStream, null, options));
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        float f;
        float f2;
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        if (i4 > i3) {
            f = i3;
            f2 = i2;
        } else {
            f = i4;
            f2 = i;
        }
        return Math.round(f / f2);
    }

    public static Bitmap compressImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 80;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > 100) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            i -= 10;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeStream(byteArrayInputStream, null, null);
    }

    private static int computeInitialSampleSize(BitmapFactory.Options options, int i, int i2) {
        int iMin;
        double d = options.outWidth;
        double d2 = options.outHeight;
        int iCeil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        if (i == -1) {
            iMin = 128;
        } else {
            double d3 = i;
            iMin = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (iMin < iCeil) {
            return iCeil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? iCeil : iMin;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        int iComputeInitialSampleSize = computeInitialSampleSize(options, i, i2);
        if (iComputeInitialSampleSize > 8) {
            return 8 * ((iComputeInitialSampleSize + 7) / 8);
        }
        int i3 = 1;
        while (i3 < iComputeInitialSampleSize) {
            i3 <<= 1;
        }
        return i3;
    }

    public static Bitmap convertMipmapToBitmap(Context context, int i) {
        return BitmapFactory.decodeResource(context.getResources(), i);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static byte[] drawableToByteArray(Drawable drawable) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static InputStream drawableToInputStream(Drawable drawable) {
        return bitmapToInputStream(drawableToBitmap(drawable));
    }

    public static Drawable drawableToRoundCorner(Drawable drawable, int i) {
        return bitmapToDrawable(bitmapToRoundCorner(drawableToBitmap(drawable), i));
    }

    public static Drawable filtToDrawable(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(new File(str));
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(fileInputStream2, null);
                fileInputStream2.close();
                return drawableCreateFromStream;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                fileInputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap getAssetsBitmap(Context context, String str) {
        InputStream inputStreamOpen;
        try {
            inputStreamOpen = context.getAssets().open(str);
        } catch (IOException e) {
            e.printStackTrace();
            inputStreamOpen = null;
        }
        return BitmapFactory.decodeStream(inputStreamOpen);
    }

    private static BitmapFactory.Options getBitmapOption(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inSampleSize = i;
        return options;
    }

    public static Drawable getDrawableFromBitmap(Context context, Bitmap bitmap) {
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

    public static Bitmap getResourceBitmap(Context context, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeStream(context.getResources().openRawResource(i), null, options);
    }

    public static Drawable getResourceDrawable(Context context, int i) {
        return context.getResources().getDrawable(i);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    public static Bitmap getimage(String str) {
        float f;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i = 0;
        options.inJustDecodeBounds = false;
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (i2 > i3) {
            float f2 = i2;
            if (f2 > 1080.0f) {
                i = (int) (f2 / 1080.0f);
            } else if (i2 < i3) {
                f = i3;
                if (f > 1920.0f) {
                    i = (int) (f / 1920.0f);
                }
            }
        } else if (i2 < i3) {
            f = i3;
            if (f > 1920.0f) {
                i = (int) (f / 1920.0f);
            }
        }
        options.inSampleSize = i > 0 ? i : 1;
        return compressImage(BitmapFactory.decodeFile(str, options));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setBlurImage$1(Drawable drawable, final ImageView imageView) {
        final Bitmap bitmapRsBlur = rsBlur(imageView.getContext(), Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200);
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.e84
            @Override // java.lang.Runnable
            public final void run() {
                imageView.setImageBitmap(bitmapRsBlur);
            }
        });
    }

    public static Bitmap rsBlur(Context context, Boolean bool, Bitmap bitmap, int i) {
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

    public static boolean saveBitmap2file(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream;
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        try {
            fileOutputStream = new FileOutputStream("/sdcard/" + str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileOutputStream = null;
        }
        return bitmap.compress(compressFormat, 100, fileOutputStream);
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, float f) {
        if (bitmap == null) {
            throw new IllegalArgumentException("bitmap 为null");
        }
        if (f == 0.0f) {
            f = 1.0f;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap scaleBitmapMaxSize(Bitmap bitmap, float f) {
        return scaleBitmapMaxSize(bitmap, f, f);
    }

    public static Bitmap scaleBitmapMaxSize(Bitmap bitmap, float f, float f2) {
        if (bitmap == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        float f3 = width;
        float height = bitmap.getHeight();
        float fMin = Math.min(Math.min(1.0f, f2 / height), Math.min(1.0f, f / f3));
        return Bitmap.createScaledBitmap(bitmap, Math.round(f3 * fMin), Math.round(height * fMin), true);
    }

    public static Bitmap scaledBitmap(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == height) {
            height = i;
        } else if (height > width) {
            height = (height * i) / width;
        } else {
            if (height < width) {
                width = (width * i) / height;
                height = i;
            }
            i = width;
        }
        return Bitmap.createScaledBitmap(bitmap, i, height, true);
    }

    public static Bitmap scaledBitmap(Bitmap bitmap, int i, int i2) {
        return Bitmap.createScaledBitmap(bitmap, i, i2, true);
    }

    public static Drawable scaledBitmap(Drawable drawable, float f) {
        return bitmapToDrawable(scaleBitmap(drawableToBitmap(drawable), f));
    }

    public static Drawable scaledDrawable(Drawable drawable, int i, int i2) {
        return bitmapToDrawable(scaledBitmap(drawableToBitmap(drawable), i, i2));
    }

    public static void setBlurImage(final ImageView imageView, final Drawable drawable) {
        if (imageView != null && (drawable instanceof BitmapDrawable)) {
            ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.d84
                @Override // java.lang.Runnable
                public final void run() {
                    ImageUtils.lambda$setBlurImage$1(drawable, imageView);
                }
            });
        }
    }

    public static void setCenterCropBackground(View view, Bitmap bitmap) {
        float width;
        int width2;
        if (bitmap == null || view == null || bitmap.getHeight() == 0 || bitmap.getWidth() == 0) {
            return;
        }
        if (bitmap.getWidth() / bitmap.getHeight() > view.getWidth() / view.getHeight()) {
            width = view.getHeight();
            width2 = bitmap.getHeight();
        } else {
            width = view.getWidth();
            width2 = bitmap.getWidth();
        }
        float f = width / width2;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap2).drawBitmap(bitmapCreateBitmap, (view.getWidth() - bitmapCreateBitmap.getWidth()) / 2.0f, (view.getHeight() - bitmapCreateBitmap.getHeight()) / 2.0f, (Paint) null);
        view.setBackground(new BitmapDrawable(view.getResources(), bitmapCreateBitmap2));
    }

    @Nullable
    public static Bitmap textToAdLogo(String str) {
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
        int iRound2 = Math.round(fMeasureText + (i * 2));
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
