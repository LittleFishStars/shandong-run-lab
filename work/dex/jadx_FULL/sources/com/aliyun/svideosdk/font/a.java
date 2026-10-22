package com.aliyun.svideosdk.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import android.util.LruCache;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f25769a = new Object();
    private static final LruCache<String, Typeface> b = new LruCache<>(8);
    private static final ReentrantReadWriteLock c = new ReentrantReadWriteLock();

    private static int a(int i, boolean z) {
        int i2 = i > 500 ? 1 : 0;
        return z ? i2 | 2 : i2;
    }

    public static Typeface a(Context context, String str, int i, boolean z) {
        Typeface typefaceB;
        if (str != null) {
            try {
                if (!str.isEmpty() && (typefaceB = b(context, str, i, z)) != null) {
                    return typefaceB;
                }
            } catch (Exception e) {
                Log.e("AliyunFontUtil", "" + e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
        return (Build.VERSION.SDK_INT < 28 || a()) ? Typeface.create(str, a(i, z)) : Typeface.create(Typeface.DEFAULT, i, z);
    }

    public static TextPaint a(Typeface typeface, float f, int i, boolean z, float f2) {
        try {
            TextPaint textPaint = new TextPaint();
            textPaint.setHinting(0);
            textPaint.setTypeface(typeface);
            textPaint.setTextSize(f);
            textPaint.setElegantTextHeight(true);
            if (i > 500 && !typeface.isBold()) {
                textPaint.setFakeBoldText(true);
            }
            if (z && !typeface.isItalic()) {
                textPaint.setTextSkewX(-0.25f);
            }
            if (f2 != 0.0f) {
                textPaint.setLetterSpacing(f2);
            }
            return textPaint;
        } catch (Exception e) {
            Log.e("AliyunFontUtil", "" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private static boolean a() {
        String str = Build.MANUFACTURER;
        if (str.equals("OnePlus")) {
            String str2 = Build.MODEL;
            return str2.equals("IN2010") || str2.equals("A5010") || str2.equals("A6000");
        }
        if (!str.equals("OPPO")) {
            return str.equalsIgnoreCase("Xiaomi") && Build.VERSION.SDK_INT >= 30;
        }
        String str3 = Build.MODEL;
        return str3.equals("PBCM30") || str3.equals("PCGM00") || str3.equals("A92s");
    }

    public static Typeface b(Context context, String str, int i, boolean z) {
        Typeface typefaceCreate;
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = c;
            reentrantReadWriteLock.readLock().lock();
            LruCache<String, Typeface> lruCache = b;
            Typeface typefaceCreateFromFile = lruCache.get(str);
            reentrantReadWriteLock.readLock().unlock();
            if (typefaceCreateFromFile == null) {
                typefaceCreateFromFile = (context == null || !str.startsWith("assets:/")) ? Typeface.createFromFile(str) : Typeface.createFromAsset(context.getAssets(), str.substring(8));
                if (typefaceCreateFromFile != null) {
                    reentrantReadWriteLock.writeLock().lock();
                    lruCache.put(str, typefaceCreateFromFile);
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            if (Build.VERSION.SDK_INT >= 28 && !a()) {
                return Typeface.create(typefaceCreateFromFile, i, z);
            }
            int iA = a(i, z);
            synchronized (f25769a) {
                typefaceCreate = Typeface.create(typefaceCreateFromFile, iA);
            }
            return typefaceCreate;
        } catch (Exception e) {
            Log.e("AliyunFontUtil", "fontPath:" + str + ",msg:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
