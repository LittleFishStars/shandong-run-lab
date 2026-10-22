package com.kwad.components.offline.api.core.api;

import com.kwad.sdk.commercial.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface ILoggerReporter {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Category {
        public static final String APM_LOG = "ad_client_apm_log";
        public static final String ERROR_LOG = "ad_client_error_log";
    }

    void reportEvent(d dVar);
}
