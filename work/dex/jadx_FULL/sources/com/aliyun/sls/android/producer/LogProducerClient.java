package com.aliyun.sls.android.producer;

import android.text.TextUtils;
import com.aliyun.sls.android.producer.utils.ThreadUtils;
import com.aliyun.sls.android.producer.utils.TimeUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LogProducerClient {
    private final long client;
    private final LogProducerConfig config;
    private boolean enable;
    private final long producer;

    public LogProducerClient(LogProducerConfig logProducerConfig) throws LogProducerException {
        this(logProducerConfig, null);
    }

    private static native long create_log_producer(long config, LogProducerCallback callback);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void destroy_log_producer(long producer);

    private static native long get_log_producer_client(long producer);

    private static native int log_producer_client_add_log_with_len(long config, long log_time, int pairCount, String[] keys, String[] values, int flush);

    private static native int log_producer_client_add_log_with_len_time_int32(long config, long log_time, int pairCount, byte[][] keys, byte[][] values);

    public LogProducerResult addLog(Log log) {
        return addLog(log, 0);
    }

    public LogProducerResult addLogRaw(byte[][] keys, byte[][] values) {
        if (!this.enable || this.client == 0 || keys == null || values == null) {
            return LogProducerResult.LOG_PRODUCER_INVALID;
        }
        return LogProducerResult.fromInt(log_producer_client_add_log_with_len_time_int32(this.client, new Log().getLogTime(), keys.length, keys, values));
    }

    public void destroyLogProducer() {
        if (this.enable) {
            this.enable = false;
            ThreadUtils.exec(new Runnable() { // from class: com.aliyun.sls.android.producer.LogProducerClient.1
                @Override // java.lang.Runnable
                public void run() {
                    LogProducerClient.destroy_log_producer(LogProducerClient.this.producer);
                }
            });
        }
    }

    public LogProducerClient(LogProducerConfig logProducerConfig, LogProducerCallback callback) throws LogProducerException {
        this.config = logProducerConfig;
        long jCreate_log_producer = create_log_producer(logProducerConfig.getConfig(), callback);
        this.producer = jCreate_log_producer;
        if (jCreate_log_producer == 0) {
            throw new LogProducerException("Can not create log producer");
        }
        long j = get_log_producer_client(jCreate_log_producer);
        this.client = j;
        if (j == 0) {
            throw new LogProducerException("Can not create log producer client");
        }
        String endpoint = logProducerConfig.getEndpoint();
        String project = logProducerConfig.getProject();
        if (!TextUtils.isEmpty(endpoint) && !TextUtils.isEmpty(project)) {
            TimeUtils.startUpdateServerTime(logProducerConfig.getContext(), endpoint, project);
        }
        this.enable = true;
    }

    public LogProducerResult addLog(Log log, int flush) {
        if (!this.enable || this.client == 0 || log == null) {
            return LogProducerResult.LOG_PRODUCER_INVALID;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(log.getContent());
        int size = linkedHashMap.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = "";
            if (str == null) {
                str = "";
            }
            strArr[i] = str;
            String str3 = (String) entry.getValue();
            if (str3 != null) {
                str2 = str3;
            }
            strArr2[i] = str2;
            i++;
        }
        return LogProducerResult.fromInt(log_producer_client_add_log_with_len(this.client, log.getLogTime(), size, strArr, strArr2, flush));
    }
}
