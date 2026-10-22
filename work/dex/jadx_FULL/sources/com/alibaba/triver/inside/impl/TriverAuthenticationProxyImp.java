package com.alibaba.triver.inside.impl;

import android.net.Uri;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.permission.service.DefaultAuthenticationProxyImpl;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverAuthenticationProxyImp extends DefaultAuthenticationProxyImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f24991a;

    static {
        HashSet hashSet = new HashSet();
        f24991a = hashSet;
        hashSet.add("hybrid.miniapp.taobao.com");
        hashSet.add("68687029.h5app.alipay.com");
    }

    @Override // com.alibaba.ariver.permission.service.DefaultAuthenticationProxyImpl, com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult interceptUrlForTiny(String str, String str2, Page page, boolean z) {
        String host;
        Uri url = UrlUtils.parseUrl(str);
        return (url == null || (host = url.getHost()) == null || !f24991a.contains(host)) ? super.interceptUrlForTiny(str, str2, page, z) : ApiPermissionCheckResult.IGNORE;
    }
}
