package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class w7 {
    public static View a(int i, View view, View view2, String str) {
        if (view != null) {
            return a(i, view2, view, str, true);
        }
        return null;
    }

    private static int b(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getResources().getDisplayMetrics().widthPixels;
        }
        return 1080;
    }

    private static int c(Context context) {
        if (!(context instanceof Activity)) {
            return 0;
        }
        Resources resources = ((Activity) context).getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier(com.gyf.immersionbar.b.f6802a, "dimen", "android"));
        kh.c("BeiZisAd", "Status height:" + dimensionPixelSize);
        return dimensionPixelSize;
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0351  */
    /* JADX WARN: Code duplicated, block: B:71:0x0354  */
    /* JADX WARN: Code duplicated, block: B:73:0x035c  */
    /* JADX WARN: Code duplicated, block: B:74:0x035f  */
    /* JADX WARN: Code duplicated, block: B:76:0x0362  */
    /* JADX WARN: Code duplicated, block: B:78:0x0368  */
    /* JADX WARN: Code duplicated, block: B:81:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:83:0x03be  */
    /* JADX WARN: Instruction removed from duplicated block: B:81:0x03a2, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:83:0x03be, please report this as an issue */
    public static View a(int i, View view, View view2, String str, boolean z) {
        int iMax;
        CharSequence charSequence;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int iMax2;
        int i7;
        int i8;
        View rootView;
        byte b;
        if (view == null || view2 == null) {
            return null;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        double d = ((double) i) / 100.0d;
        kh.c("BeiZisAd", "width = " + width + ",height = " + height);
        Rect rect = new Rect();
        view2.getHitRect(rect);
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int i9 = iArr[0];
        int i10 = iArr[1];
        kh.c("BeiZisAd", "delegateLeft = " + i9 + ",delegateTop = " + i10);
        int iB = b(view2.getContext());
        int iA = a(view2.getContext()) + c(view2.getContext());
        kh.c("BeiZisAd", "screenWidth = " + iB + ",screenHeight = " + iA);
        str.getClass();
        String str2 = "RIGHT";
        byte b2 = -1;
        switch (str.hashCode()) {
            case -1196746574:
                if (str.equals("BOTTOMLEFT")) {
                    b2 = 0;
                }
                break;
            case -421184836:
                if (str.equals("TOPLEFT")) {
                    b2 = 1;
                }
                break;
            case -166167065:
                if (str.equals("TOPRIGHT")) {
                    b2 = 2;
                }
                break;
            case 83253:
                if (str.equals("TOP")) {
                    b = 3;
                    b2 = b;
                }
                break;
            case 2332679:
                if (str.equals("LEFT")) {
                    b = 4;
                    b2 = b;
                }
                break;
            case 77974012:
                if (str.equals("RIGHT")) {
                    b = 5;
                    b2 = b;
                }
                break;
            case 1561222833:
                if (str.equals("BOTTOMRIGHT")) {
                    b = 6;
                    b2 = b;
                }
                break;
            case 1965067819:
                if (str.equals("BOTTOM")) {
                    b = 7;
                    b2 = b;
                }
                break;
            case 1984282709:
                if (str.equals("CENTER")) {
                    b = 8;
                    b2 = b;
                }
                break;
        }
        switch (b2) {
            case 0:
                str2 = "RIGHT";
                width = width;
                double dSqrt = Math.sqrt(d) - 1.0d;
                int i11 = (int) (((double) width) * dSqrt);
                int iMax3 = Math.max(0, i10);
                iMax = Math.max(0, i9 - i11);
                charSequence = "LEFT";
                i2 = 0;
                i3 = (int) (dSqrt * ((double) height));
                i4 = i11;
                i5 = iMax3;
                i6 = 0;
                break;
            case 1:
                double dSqrt2 = Math.sqrt(d) - 1.0d;
                int i12 = (int) (((double) width) * dSqrt2);
                int i13 = (int) (dSqrt2 * ((double) height));
                i6 = 0;
                iMax2 = Math.max(0, i10 - i13);
                iMax = Math.max(0, i9 - i12);
                i3 = 0;
                charSequence = "LEFT";
                i2 = i13;
                i4 = i12;
                i5 = iMax2;
                break;
            case 2:
                double dSqrt3 = Math.sqrt(d) - 1.0d;
                int i14 = (int) (((double) width) * dSqrt3);
                int i15 = (int) (dSqrt3 * ((double) height));
                iMax2 = Math.max(0, i10 - i15);
                iMax = Math.max(0, i9);
                i3 = 0;
                charSequence = "LEFT";
                i2 = i15;
                i4 = 0;
                i6 = i14;
                i5 = iMax2;
                break;
            case 3:
                str2 = "RIGHT";
                i6 = 0;
                int i16 = (int) ((d - 1.0d) * ((double) height));
                int iMax4 = Math.max(0, i10 - i16);
                iMax = Math.max(0, i9);
                width = width;
                charSequence = "LEFT";
                i5 = iMax4;
                i2 = i16;
                i4 = 0;
                i3 = 0;
                break;
            case 4:
                i6 = 0;
                i4 = (int) ((d - 1.0d) * ((double) width));
                int iMax5 = Math.max(0, i10);
                iMax = Math.max(0, i9 - i4);
                i2 = 0;
                charSequence = "LEFT";
                i5 = iMax5;
                i3 = i2;
                break;
            case 5:
                str2 = "RIGHT";
                int i17 = (int) ((d - 1.0d) * ((double) width));
                int iMax6 = Math.max(0, i10);
                iMax = Math.max(0, i9);
                i2 = 0;
                width = width;
                charSequence = "LEFT";
                i5 = iMax6;
                i3 = 0;
                i6 = i17;
                i4 = 0;
                break;
            case 6:
                str2 = "RIGHT";
                double dSqrt4 = Math.sqrt(d) - 1.0d;
                int i18 = (int) (((double) width) * dSqrt4);
                int i19 = (int) (dSqrt4 * ((double) height));
                int iMax7 = Math.max(0, i10);
                width = width;
                iMax = Math.max(0, i9);
                charSequence = "LEFT";
                i5 = iMax7;
                i3 = i19;
                i2 = 0;
                i6 = i18;
                i4 = 0;
                break;
            case 7:
                str2 = "RIGHT";
                int i20 = (int) ((d - 1.0d) * ((double) height));
                i2 = 0;
                int iMax8 = Math.max(0, i10);
                iMax = Math.max(0, i9);
                width = width;
                charSequence = "LEFT";
                i5 = iMax8;
                i3 = i20;
                i4 = 0;
                i6 = 0;
                break;
            case 8:
                double dSqrt5 = Math.sqrt(d) - 1.0d;
                int i21 = (int) ((((double) width) * dSqrt5) / 2.0d);
                i2 = (int) ((dSqrt5 * ((double) height)) / 2.0d);
                kh.c("BeiZisAd", "expandTop = " + i2);
                int iMax9 = Math.max(0, i10 - i2);
                iMax = Math.max(0, i9 - i21);
                kh.c("BeiZisAd", "marginTop = " + iMax9 + ",marginLeft = " + iMax);
                i5 = iMax9;
                charSequence = "LEFT";
                i4 = i21;
                i6 = i4;
                i3 = i2;
                break;
            default:
                charSequence = "LEFT";
                str2 = "RIGHT";
                width = width;
                i4 = 0;
                i2 = 0;
                i6 = 0;
                i3 = 0;
                i5 = 0;
                iMax = 0;
                break;
        }
        kh.c("BeiZisAd", "area = " + i + ",expandLeft = " + i4 + ",expandTop = " + i2 + ",expandRight = " + i6 + ",expandBottom = " + i3);
        StringBuilder sb = new StringBuilder();
        sb.append("delegateArea old = ");
        sb.append(rect);
        kh.c("BeiZisAd", sb.toString());
        int iMax10 = Math.max(iMax, 0);
        int iMin = Math.min(0, iB);
        int iMax11 = Math.max(i5, 0);
        int iMin2 = Math.min(0, iA);
        rect.left = rect.left - i4;
        rect.top = rect.top - i2;
        rect.right = rect.right + i6;
        rect.bottom += i3;
        kh.c("BeiZisAd", "delegateArea new = " + rect);
        FrameLayout frameLayout = new FrameLayout(view2.getContext());
        int iMin3 = rect.right - rect.left;
        int iMin4 = rect.bottom - rect.top;
        if (!str.contains("TOP")) {
            if (str.contains("BOTTOM")) {
                i7 = iA - i10;
            } else {
                i7 = 0;
            }
            if (str.contains(charSequence)) {
                i8 = i9 + width;
            } else if (str.contains(str2)) {
                i8 = iB - i9;
            } else {
                i8 = 0;
            }
            if (i7 != 0) {
                iMin4 = Math.min(iMin4, i7);
            }
            if (i8 != 0) {
                iMin3 = Math.min(iMin3, i8);
            }
            kh.c("BeiZisAd", "fHeight = " + iMin4 + ",remainHeight = " + i7 + ",fWidth = " + iMin3 + ",remainWidth = " + i8);
            frameLayout.setBackgroundColor(0);
            if (view instanceof ViewGroup) {
                rootView = view.getRootView();
                kh.c("BeiZisAd", "rootView = " + rootView);
                if (rootView instanceof ViewGroup) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iMin3, iMin4);
                    kh.c("BeiZisAd", "marginLeft = " + iMax10 + ",marginTop = " + iMax11 + ",marginRight = " + iMin + ",marginBottom = " + iMin2);
                    layoutParams.setMargins(iMax10, iMax11, iMin, iMin2);
                    ((ViewGroup) rootView).addView(frameLayout, layoutParams);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("fWidth = ");
                    sb2.append(iMin3);
                    sb2.append(",fHeight = ");
                    sb2.append(iMin4);
                    kh.c("BeiZisAd", sb2.toString());
                }
            }
            return frameLayout;
        }
        i7 = i10 + height;
        if (str.contains(charSequence)) {
            i8 = i9 + width;
        } else if (str.contains(str2)) {
            i8 = iB - i9;
        } else {
            i8 = 0;
        }
        if (i7 != 0) {
            iMin4 = Math.min(iMin4, i7);
        }
        if (i8 != 0) {
            iMin3 = Math.min(iMin3, i8);
        }
        kh.c("BeiZisAd", "fHeight = " + iMin4 + ",remainHeight = " + i7 + ",fWidth = " + iMin3 + ",remainWidth = " + i8);
        frameLayout.setBackgroundColor(0);
        if (view instanceof ViewGroup) {
            rootView = view.getRootView();
            kh.c("BeiZisAd", "rootView = " + rootView);
            if (rootView instanceof ViewGroup) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iMin3, iMin4);
                kh.c("BeiZisAd", "marginLeft = " + iMax10 + ",marginTop = " + iMax11 + ",marginRight = " + iMin + ",marginBottom = " + iMin2);
                layoutParams2.setMargins(iMax10, iMax11, iMin, iMin2);
                ((ViewGroup) rootView).addView(frameLayout, layoutParams2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("fWidth = ");
                sb3.append(iMin3);
                sb3.append(",fHeight = ");
                sb3.append(iMin4);
                kh.c("BeiZisAd", sb3.toString());
            }
        }
        return frameLayout;
    }

    private static int a(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getResources().getDisplayMetrics().heightPixels;
        }
        return 1920;
    }
}
