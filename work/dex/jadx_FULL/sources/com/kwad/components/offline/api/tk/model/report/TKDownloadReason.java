package com.kwad.components.offline.api.tk.model.report;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface TKDownloadReason {
    public static final String KSAD_TK_JS_MD5 = "jsMD5";
    public static final String KSAD_TK_MD5 = "md5";
    public static final String KSAD_TK_NET = "net";
    public static final String KSAD_TK_UNZIP = "unzip";
}
