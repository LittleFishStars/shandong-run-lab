package com.zj.adlib;

import android.text.TextUtils;
import com.acse.ottn.p3;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.fl.saas.common.util.FileTypeUtils;
import java.util.HashSet;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\f\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\r\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002R$\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/zj/adlib/s91;", "", "", "extension", "", "c", "b", y6b.f, "", "d", "Ljava/util/HashSet;", p3.h, "a", "f", "e", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "statics", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCacheExtensionConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheExtensionConfig.kt\ncom/huachenjie/common/cache_webview/config/CacheExtensionConfig\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1#2:87\n*E\n"})
public final class s91 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final String f19553a = "sdLocalResource://";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final HashSet<String> statics;

    @NotNull
    public static final HashSet<String> b = SetsKt.hashSetOf(new String[]{"html", "htm", "js", "ico", "css", "png", "jpg", AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG, FileTypeUtils.FILE_TYPE_GIF, FileTypeUtils.FILE_TYPE_BMP, "ttf", "woff", "woff2", "otf", "eot", "svg", AliyunVodHttpCommon.Format.FORMAT_XML, "swf", "txt", "text", "conf", "webp"});

    public s91() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(b);
        this.statics = hashSet;
    }

    public final void a(HashSet<String> set, String extension) {
        if (TextUtils.isEmpty(extension)) {
            return;
        }
        String strReplace$default = StringsKt.replace$default(extension, Consts.DOT, "", false, 4, (Object) null);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = strReplace$default.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        set.add(StringsKt.trim(lowerCase).toString());
    }

    @NotNull
    public final s91 b(@NotNull String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        a(this.statics, extension);
        return this;
    }

    public final boolean c(@NotNull String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        if (TextUtils.isEmpty(extension)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = extension.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return this.statics.contains(StringsKt.trim(lowerCase).toString());
    }

    public final void d() {
        e();
    }

    public final void e() {
        this.statics.clear();
    }

    public final void f(HashSet<String> set, String extension) {
        if (TextUtils.isEmpty(extension)) {
            return;
        }
        String strReplace$default = StringsKt.replace$default(extension, Consts.DOT, "", false, 4, (Object) null);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = strReplace$default.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        set.remove(StringsKt.trim(lowerCase).toString());
    }

    @NotNull
    public final s91 g(@NotNull String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        f(this.statics, extension);
        return this;
    }
}
