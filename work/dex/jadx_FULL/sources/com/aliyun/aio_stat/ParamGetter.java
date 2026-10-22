package com.aliyun.aio_stat;

import androidx.annotation.Keep;
import androidx.annotation.RestrictTo;
import com.zj.adlib.c49;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ParamGetter {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25550a;

        static {
            int[] iArr = new int[b.values().length];
            f25550a = iArr;
            try {
                iArr[b.cpu_usage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25550a[b.network_type.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        event_id,
        stm,
        stat_log_id,
        stat_log_seq,
        stat_log_priority,
        session_id,
        terminal_type,
        device_model,
        os_name,
        os_version,
        uuid,
        application_id,
        application_name,
        application_version,
        cpu_processor,
        cpu_info,
        gpu_info,
        opengl_version,
        device_brand,
        device_manufacturer,
        device_feature,
        cpu_usage,
        mem_usage,
        mem_total,
        electric_usage,
        network_type,
        android_sdk_version,
        install_uuid,
        stat_log_ver,
        time_zone
    }

    @Keep
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace(c49.f40900a, "");
    }

    @Keep
    public static String getParamValue(int i) {
        int i2 = a.f25550a[b.values()[i].ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? "" : com.aliyun.aio_stat.b.a().b();
        }
        return String.valueOf(com.aliyun.aio_stat.a.d().e());
    }
}
