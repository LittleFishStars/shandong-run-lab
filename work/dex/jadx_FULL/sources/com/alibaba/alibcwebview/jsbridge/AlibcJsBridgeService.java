package com.alibaba.alibcwebview.jsbridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class AlibcJsBridgeService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<AlibcJSAPIAuthCheck> f23721a = Collections.synchronizedList(new ArrayList());

    public interface AlibcJSAPIAuthCheck {
        boolean a();
    }

    public static List<AlibcJSAPIAuthCheck> a() {
        return f23721a;
    }
}
