package com.alibaba.fastjson.support.jaxrs;

import com.hzchengdun.securityguard.SecExceptionCode;
import javax.annotation.Priority;
import javax.ws.rs.core.FeatureContext;
import org.glassfish.jersey.internal.spi.AutoDiscoverable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Priority(SecExceptionCode.SEC_ERROR_GENERIC_AVMP_UNKNOWN_ERROR)
public class FastJsonAutoDiscoverable implements AutoDiscoverable {
    public static final String FASTJSON_AUTO_DISCOVERABLE = "fastjson.auto.discoverable";
    public static volatile boolean autoDiscover = true;

    static {
        try {
            autoDiscover = Boolean.parseBoolean(System.getProperty(FASTJSON_AUTO_DISCOVERABLE, String.valueOf(autoDiscover)));
        } catch (Throwable unused) {
        }
    }

    public void configure(FeatureContext featureContext) {
        if (featureContext.getConfiguration().isRegistered(FastJsonFeature.class) || !autoDiscover) {
            return;
        }
        featureContext.register(FastJsonFeature.class);
    }
}
