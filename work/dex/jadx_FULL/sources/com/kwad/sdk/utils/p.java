package com.kwad.sdk.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class p {
    public static boolean a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence2)) {
                    ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
