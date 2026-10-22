package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\f"}, d2 = {"Lcom/zj/adlib/yy5;", "", "Landroid/content/Context;", "context", "", "c", "b", "a", "", "d", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class yy5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final yy5 f46141a = new yy5();

    @JvmStatic
    public static final boolean a(@Nullable Context context) {
        return c(context) && !b(context);
    }

    @JvmStatic
    public static final boolean b(@Nullable Context context) {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    @JvmStatic
    public static final boolean c(@Nullable Context context) {
        return NfcAdapter.getDefaultAdapter(context) != null;
    }

    @JvmStatic
    public static final void d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            context.startActivity(new Intent("android.settings.NFC_SETTINGS").addFlags(268435456));
        } catch (Exception unused) {
            context.startActivity(new Intent("android.settings.SETTINGS").addFlags(268435456));
        }
    }
}
