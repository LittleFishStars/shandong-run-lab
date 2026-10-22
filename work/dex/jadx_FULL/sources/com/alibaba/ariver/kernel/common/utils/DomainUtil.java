package com.alibaba.ariver.kernel.common.utils;

import android.net.Uri;
import com.alibaba.fastjson.JSONArray;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DomainUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24277a = "DomainUtil";

    public static String getNewDomainSuffix(String str) {
        Uri url = UrlUtils.parseUrl(str);
        if (url == null) {
            return null;
        }
        return url.getScheme() + "://" + url.getHost();
    }

    public static boolean isInDomain(String str, List<String> list) {
        if (str != null && list != null) {
            try {
                if (!list.isEmpty()) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        if (PatternUtils.matchRegex(it.next(), str)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                RVLogger.e(f24277a, "exception detail.", th);
            }
        }
        return false;
    }

    public static boolean isSomeDomainInternal(String str, String str2) {
        if (str == null) {
            return false;
        }
        try {
            JSONArray array = JSONUtils.parseArray(str2);
            if (array != null) {
                for (int i = 0; i < array.size(); i++) {
                    if (PatternUtils.matchRegex(array.getString(i), str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            RVLogger.e(f24277a, "exception detail.", th);
        }
        return false;
    }
}
