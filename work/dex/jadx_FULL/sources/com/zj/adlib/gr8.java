package com.zj.adlib;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0003\u0010\u0010R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0006\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/zj/adlib/gr8;", "", "", "a", "Ljava/lang/String;", "BEGIN_TIME", "b", "END_TIME", "c", "STEPS", "d", "MODE", "e", "AUTHORITY", "Landroid/net/Uri;", "Landroid/net/Uri;", "()Landroid/net/Uri;", "CONTENT_URI", "", "[Ljava/lang/String;", "()[Ljava/lang/String;", "PROJECTION", "<init>", "()V", "step_release"}, k = 1, mv = {1, 8, 0})
public final class gr8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Uri CONTENT_URI;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final gr8 f16854a = new gr8();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String BEGIN_TIME = "_begin_time";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String[] PROJECTION;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String END_TIME = "_end_time";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String STEPS = "_steps";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static final String MODE = "_mode";

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public static final String AUTHORITY = "com.miui.providers.steps";

    static {
        Uri uri = Uri.parse("content://com.miui.providers.steps/item");
        Intrinsics.checkNotNullExpressionValue(uri, "parse(\"content://\" + AUTHORITY + \"/item\")");
        CONTENT_URI = uri;
        PROJECTION = new String[]{"SUM(_steps) as total_steps"};
    }

    @NotNull
    public final Uri a() {
        return CONTENT_URI;
    }

    @NotNull
    public final String[] b() {
        return PROJECTION;
    }
}
