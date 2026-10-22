package com.kwad.sdk.wrapper;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class i extends Resources {
    private final Resources aDN;

    public i(Resources resources, Resources resources2) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.aDN = resources2;
    }

    private static boolean aF(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("ksad_") || !"com.kwad.dy.sdk".equals(str2);
    }

    private static boolean gr(int i) {
        StringBuilder sb = new StringBuilder("0x");
        sb.append(Integer.toHexString(i));
        return !sb.toString().startsWith("0x60");
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getAnimation(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getAnimation id: 0x#" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getAnimation(i) : super.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public final boolean getBoolean(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getBoolean id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getBoolean(i) : super.getBoolean(i);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final int getColor(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getColor id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getColor(i) : super.getColor(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    @RequiresApi(api = 23)
    public final ColorStateList getColorStateList(int i, @Nullable Resources.Theme theme) {
        try {
            com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getColorStateList: 0x#" + Integer.toHexString(i));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("KSDY/KSResource", Log.getStackTraceString(e));
        }
        return gr(i) ? this.aDN.getColorStateList(i, theme) : super.getColorStateList(i, theme);
    }

    @Override // android.content.res.Resources
    public final float getDimension(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDimension id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getDimension(i) : super.getDimension(i);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDimensionPixelOffset id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getDimensionPixelOffset(i) : super.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDimensionPixelSize id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getDimensionPixelSize(i) : super.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Drawable getDrawable(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getDrawable(i) : super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @Nullable
    @Deprecated
    public final Drawable getDrawableForDensity(int i, int i2) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDrawableForDensity id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getDrawableForDensity(i, i2) : super.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    @RequiresApi(api = 29)
    public final float getFloat(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getFloat id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getFloat(i) : super.getFloat(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    @RequiresApi(api = 26)
    public final Typeface getFont(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getFont id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getFont(i) : super.getFont(i);
    }

    @Override // android.content.res.Resources
    public final float getFraction(int i, int i2, int i3) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getFraction id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getFraction(i, i2, i3) : super.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public final int getIdentifier(String str, String str2, String str3) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getIdentifier id: 0x# name:" + str + " :defPackage" + str3);
        return aF(str, str3) ? this.aDN.getIdentifier(str, str2, str3) : super.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final int[] getIntArray(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getIntArray id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getIntArray(i) : super.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public final int getInteger(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getInteger id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getInteger(i) : super.getInteger(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getLayout(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getLayout id: 0x#" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getLayout(i) : super.getLayout(i);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Movie getMovie(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getMovie(i) : super.getMovie(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i, int i2) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getQuantityString(i, i2) : super.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getQuantityText(int i, int i2) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getQuantityText id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getQuantityText(i, i2) : super.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public final String getResourceEntryName(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getResourceEntryName id: 0x#" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getResourceEntryName(i) : super.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourceName(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getResourceName id: 0x#" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getResourceName(i) : super.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourcePackageName(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getResourcePackageName id: 0x#" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getResourcePackageName(i) : super.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourceTypeName(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getResourceTypeName id: 0x#" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getResourceTypeName(i) : super.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getString(i) : super.getString(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String[] getStringArray(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getStringArray id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getStringArray(i) : super.getStringArray(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getText(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getText(i) : super.getText(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence[] getTextArray(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getTextArray id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getTextArray(i) : super.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public final void getValue(int i, TypedValue typedValue, boolean z) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(i));
        if (gr(i)) {
            this.aDN.getValue(i, typedValue, z);
        } else {
            super.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getValueForDensity id: 0x#" + Integer.toHexString(i));
        if (gr(i)) {
            this.aDN.getValueForDensity(i, i2, typedValue, z);
        } else {
            super.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getXml(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getXml id: 0x#" + Integer.toHexString(i));
        return gr(i) ? this.aDN.getXml(i) : super.getXml(i);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final TypedArray obtainTypedArray(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "obtainTypedArray id: #0x" + Integer.toHexString(i));
        return gr(i) ? this.aDN.obtainTypedArray(i) : super.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i));
        return gr(i) ? this.aDN.openRawResource(i) : super.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public final AssetFileDescriptor openRawResourceFd(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "openRawResourceFd id: 0x#" + Integer.toHexString(i));
        return gr(i) ? this.aDN.openRawResourceFd(i) : super.openRawResourceFd(i);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    @Override // android.content.res.Resources
    @RequiresApi(api = 23)
    public final int getColor(int i, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i));
        if (gr(i)) {
            return this.aDN.getColor(i, theme);
        }
        return super.getColor(i, theme);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        if (gr(i)) {
            return this.aDN.getDrawable(i);
        }
        return super.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    @Nullable
    @RequiresApi(api = 21)
    public final Drawable getDrawableForDensity(int i, int i2, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        if (gr(i)) {
            return this.aDN.getDrawableForDensity(i, i2, theme);
        }
        return super.getDrawableForDensity(i, i2, theme);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i, int i2, Object... objArr) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i));
        if (gr(i)) {
            return this.aDN.getQuantityString(i, i2, objArr);
        }
        return super.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i, Object... objArr) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i));
        if (gr(i)) {
            return this.aDN.getString(i, objArr);
        }
        return super.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i, CharSequence charSequence) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i));
        if (gr(i)) {
            return this.aDN.getText(i, charSequence);
        }
        return super.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public final void getValue(String str, TypedValue typedValue, boolean z) {
        int identifier = getIdentifier(str, TypedValues.Custom.S_STRING, null);
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(identifier));
        if (gr(identifier)) {
            this.aDN.getValue(str, typedValue, z);
        } else {
            super.getValue(str, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i, TypedValue typedValue) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i));
        if (gr(i)) {
            return this.aDN.openRawResource(i, typedValue);
        }
        return super.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final ColorStateList getColorStateList(int i) {
        try {
            com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getColorStateList: 0x#" + Integer.toHexString(i));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("KSDY/KSResource", Log.getStackTraceString(e));
        }
        if (gr(i)) {
            return this.aDN.getColorStateList(i);
        }
        return super.getColorStateList(i);
    }
}
