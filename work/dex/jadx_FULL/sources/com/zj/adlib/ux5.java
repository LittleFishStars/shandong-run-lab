package com.zj.adlib;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alipay.sdk.m.y.l;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J,\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005¨\u0006\u000b"}, d2 = {"Lcom/zj/adlib/ux5;", "", "", RequestParameters.SUBRESOURCE_REFERER, "a", "", "", "maps", "b", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nNetUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetUtils.kt\ncom/huachenjie/common/cache_webview/utils/NetUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1855#2,2:44\n*S KotlinDebug\n*F\n+ 1 NetUtils.kt\ncom/huachenjie/common/cache_webview/utils/NetUtils\n*L\n32#1:44,2\n*E\n"})
public final class ux5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ux5 f45244a = new ux5();

    @Nullable
    public final String a(@Nullable String referer) {
        String str = "";
        if (TextUtils.isEmpty(referer)) {
            return "";
        }
        try {
            URL url = new URL(referer);
            int port = url.getPort();
            String protocol = url.getProtocol();
            String host = url.getHost();
            if (port != -1) {
                str = u15.f19942b + port;
            }
            return protocol + "://" + host + str;
        } catch (Exception unused) {
            return referer;
        }
    }

    @NotNull
    public final Map<String, String> b(@NotNull Map<String, ? extends List<String>> maps) {
        Intrinsics.checkNotNullParameter(maps, "maps");
        StringBuilder sb = new StringBuilder();
        HashMap map = new HashMap();
        for (Map.Entry<String, ? extends List<String>> entry : maps.entrySet()) {
            StringsKt.clear(sb);
            Iterator<T> it = entry.getValue().iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append(l.b);
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            String key = entry.getKey();
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
            map.put(key, string);
        }
        return map;
    }
}
