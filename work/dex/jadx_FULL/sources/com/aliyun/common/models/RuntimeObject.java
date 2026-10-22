package com.aliyun.common.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RuntimeObject extends TeaModel {

    @NameInMap("autoretry")
    @Validation(required = true)
    public boolean autoretry;

    @NameInMap("backoff_period")
    @Validation(required = true)
    public Integer backoffPeriod;

    @NameInMap("backoff_policy")
    @Validation(required = true)
    public String backoffPolicy;

    @NameInMap("connectTimeout")
    @Validation(required = true)
    public Integer connectTimeout;

    @NameInMap("httpProxy")
    @Validation(required = true)
    public String httpProxy;

    @NameInMap("httpsProxy")
    @Validation(required = true)
    public String httpsProxy;

    @NameInMap("ignoreSSL")
    @Validation(required = true)
    public boolean ignoreSSL;

    @NameInMap("max_attempts")
    @Validation(required = true)
    public Integer maxAttempts;

    @NameInMap("maxIdleConns")
    @Validation(required = true)
    public Integer maxIdleConns;

    @NameInMap("noProxy")
    @Validation(required = true)
    public String noProxy;

    @NameInMap("readTimeout")
    @Validation(required = true)
    public Integer readTimeout;

    public static RuntimeObject build(Map<String, ?> map) {
        try {
            return (RuntimeObject) TeaModel.build(map, new RuntimeObject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
