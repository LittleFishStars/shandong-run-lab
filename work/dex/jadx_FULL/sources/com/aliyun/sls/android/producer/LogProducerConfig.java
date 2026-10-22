package com.aliyun.sls.android.producer;

import android.content.Context;
import android.text.TextUtils;
import com.aliyun.sls.android.producer.internal.HttpHeader;
import com.aliyun.sls.android.producer.internal.LogProducerHttpHeaderInjector;
import com.aliyun.sls.android.producer.utils.ProcessUtils;
import com.aliyun.sls.android.producer.utils.TimeUtils;
import com.aliyun.sls.android.producer.utils.Utils;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LogProducerConfig {
    private final long config;
    private final Context context;
    private boolean enablePersistent;
    private String endpoint;
    private String logstore;
    private String project;

    public enum CompressType {
        LZ4(1),
        ZSTD(2);

        final int type;

        CompressType(int type) {
            this.type = type;
        }
    }

    static {
        System.loadLibrary("sls_producer");
    }

    public LogProducerConfig() throws LogProducerException {
        this(Utils.getContext());
    }

    private String createNewPathIfInProcess(String path) throws Throwable {
        Context context = this.context;
        if (context == null || ProcessUtils.isMainProcess(context)) {
            return path;
        }
        String currentProcessName = ProcessUtils.getCurrentProcessName(this.context);
        if (TextUtils.isEmpty(currentProcessName)) {
            return path;
        }
        String str = File.separator;
        File file = new File(path.substring(0, path.lastIndexOf(str)), currentProcessName);
        String strSubstring = path.substring(path.lastIndexOf(str) + 1);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, strSubstring).getAbsolutePath();
    }

    private void createParentFolderIfNotExists(String path) {
        File file = new File(path.substring(0, path.lastIndexOf(File.separator)));
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private static native long create_log_producer_config();

    private static native void log_producer_config_add_tag(long config, String key, String value);

    private static native int log_producer_config_is_valid(long config);

    private static native void log_producer_config_reset_security_token(long config, String accessKeyID, String accessKeySecret, String securityToken);

    private static native void log_producer_config_set_access_id(long config, String accessKeyID);

    private static native void log_producer_config_set_access_key(long config, String accessKeySecret);

    private static native void log_producer_config_set_callback_from_sender_thread(long config, int num);

    private static native void log_producer_config_set_compress_type(long config, int num);

    private static native void log_producer_config_set_connect_timeout_sec(long config, int num);

    private static native void log_producer_config_set_destroy_flusher_wait_sec(long config, int num);

    private static native void log_producer_config_set_destroy_sender_wait_sec(long config, int num);

    private static native void log_producer_config_set_drop_delay_log(long config, int num);

    private static native void log_producer_config_set_drop_unauthorized_log(long config, int num);

    private static native void log_producer_config_set_endpoint(long config, String endpoint);

    private static native void log_producer_config_set_get_time_unix_func(LogProducerTimeUnixFunc func);

    private static native void log_producer_config_set_http_header_inject(long config, LogProducerHttpHeaderInjector injector);

    private static native void log_producer_config_set_logstore(long config, String logstore);

    private static native void log_producer_config_set_max_buffer_limit(long config, int num);

    private static native void log_producer_config_set_max_log_delay_time(long config, int num);

    private static native void log_producer_config_set_net_interface(long config, String net_interface);

    private static native void log_producer_config_set_ntp_time_offset(long config, int num);

    private static native void log_producer_config_set_packet_log_bytes(long config, int num);

    private static native void log_producer_config_set_packet_log_count(long config, int num);

    private static native void log_producer_config_set_packet_timeout(long config, int num);

    private static native void log_producer_config_set_persistent(long config, int num);

    private static native void log_producer_config_set_persistent_file_path(long config, String path);

    private static native void log_producer_config_set_persistent_force_flush(long config, int num);

    private static native void log_producer_config_set_persistent_max_file_count(long config, int num);

    private static native void log_producer_config_set_persistent_max_file_size(long config, int num);

    private static native void log_producer_config_set_persistent_max_log_count(long config, int num);

    private static native void log_producer_config_set_project(long config, String project);

    private static native void log_producer_config_set_send_thread_count(long config, int num);

    private static native void log_producer_config_set_send_timeout_sec(long config, int num);

    private static native void log_producer_config_set_source(long config, String source);

    private static native void log_producer_config_set_topic(long config, String topic);

    private static native void log_producer_config_set_using_http(long config, int num);

    private static native void log_producer_debug();

    private static native int log_producer_persistent_config_is_enabled(long config);

    public void addTag(String key, String value) {
        log_producer_config_add_tag(this.config, key, value);
    }

    public long getConfig() {
        return this.config;
    }

    public Context getContext() {
        return this.context;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getLogstore() {
        return this.logstore;
    }

    public String getProject() {
        return this.project;
    }

    public int isEnabled() {
        return log_producer_persistent_config_is_enabled(this.config);
    }

    public int isValid() {
        return log_producer_config_is_valid(this.config);
    }

    public void logProducerDebug() {
        log_producer_debug();
    }

    public void resetSecurityToken(String accessKeyID, String accessKeySecret, String securityToken) {
        log_producer_config_reset_security_token(this.config, accessKeyID, accessKeySecret, securityToken);
    }

    public void setAccessKeyId(String accessId) {
        log_producer_config_set_access_id(this.config, accessId);
    }

    public void setAccessKeySecret(String accessKeySecret) {
        log_producer_config_set_access_key(this.config, accessKeySecret);
    }

    public void setCallbackFromSenderThread(boolean z) {
        log_producer_config_set_callback_from_sender_thread(this.config, z ? 1 : 0);
    }

    @Deprecated
    public void setCompressType(int num) {
        log_producer_config_set_compress_type(this.config, num);
    }

    public void setConnectTimeoutSec(int num) {
        log_producer_config_set_connect_timeout_sec(this.config, num);
    }

    public void setDestroyFlusherWaitSec(int num) {
        log_producer_config_set_destroy_flusher_wait_sec(this.config, num);
    }

    public void setDestroySenderWaitSec(int num) {
        log_producer_config_set_destroy_sender_wait_sec(this.config, num);
    }

    public void setDropDelayLog(int num) {
        log_producer_config_set_drop_delay_log(this.config, num);
    }

    public void setDropUnauthorizedLog(int num) {
        log_producer_config_set_drop_unauthorized_log(this.config, num);
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        log_producer_config_set_endpoint(this.config, endpoint);
    }

    public void setGetTimeUnixFunc(LogProducerTimeUnixFunc func) {
        log_producer_config_set_get_time_unix_func(func);
    }

    public void setHttpHeaderInjector(LogProducerHttpHeaderInjector injector) {
        log_producer_config_set_http_header_inject(this.config, injector);
    }

    public void setLogstore(String logstore) {
        this.logstore = logstore;
        log_producer_config_set_logstore(this.config, logstore);
    }

    public void setMaxBufferLimit(int num) {
        log_producer_config_set_max_buffer_limit(this.config, num);
    }

    public void setMaxLogDelayTime(int num) {
        log_producer_config_set_max_log_delay_time(this.config, num);
    }

    public void setNetInterface(String netInterface) {
        log_producer_config_set_net_interface(this.config, netInterface);
    }

    public void setNtpTimeOffset(int num) {
        log_producer_config_set_ntp_time_offset(this.config, num);
    }

    public void setPacketLogBytes(int num) {
        log_producer_config_set_packet_log_bytes(this.config, num);
    }

    public void setPacketLogCount(int num) {
        log_producer_config_set_packet_log_count(this.config, num);
    }

    public void setPacketTimeout(int num) {
        log_producer_config_set_packet_timeout(this.config, num);
    }

    public void setPersistent(int num) {
        this.enablePersistent = 1 == num;
        log_producer_config_set_persistent(this.config, num);
        if (this.enablePersistent) {
            setSendThreadCount(1);
        }
    }

    public void setPersistentFilePath(String path) throws Throwable {
        if (TextUtils.isEmpty(path)) {
            return;
        }
        createParentFolderIfNotExists(path);
        log_producer_config_set_persistent_file_path(this.config, createNewPathIfInProcess(path));
    }

    public void setPersistentForceFlush(int num) {
        log_producer_config_set_persistent_force_flush(this.config, num);
    }

    public void setPersistentMaxFileCount(int num) {
        log_producer_config_set_persistent_max_file_count(this.config, num);
    }

    public void setPersistentMaxFileSize(int num) {
        log_producer_config_set_persistent_max_file_size(this.config, num);
    }

    public void setPersistentMaxLogCount(int num) {
        log_producer_config_set_persistent_max_log_count(this.config, num);
    }

    public void setProject(String project) {
        this.project = project;
        log_producer_config_set_project(this.config, project);
    }

    public void setSendThreadCount(int num) {
        if (this.enablePersistent && 1 != num) {
            num = 1;
        }
        log_producer_config_set_send_thread_count(this.config, num);
    }

    public void setSendTimeoutSec(int num) {
        log_producer_config_set_send_timeout_sec(this.config, num);
    }

    public void setSource(String source) {
        log_producer_config_set_source(this.config, source);
    }

    public void setTopic(String topic) {
        log_producer_config_set_topic(this.config, topic);
    }

    @Deprecated
    public void setUseWebtracking(boolean enable) {
    }

    public void setUsingHttp(int num) {
        log_producer_config_set_using_http(this.config, num);
    }

    public LogProducerConfig(String endpoint, String project, String logstore) throws LogProducerException {
        this(Utils.getContext(), endpoint, project, logstore);
    }

    public void setCompressType(CompressType type) {
        log_producer_config_set_compress_type(this.config, type.type);
    }

    public LogProducerConfig(String endpoint, String project, String logstore, String accessKeyId, String accessKeySecret) throws LogProducerException {
        this(endpoint, project, logstore, accessKeyId, accessKeySecret, (String) null);
    }

    public LogProducerConfig(String endpoint, String project, String logstore, String accessKeyId, String accessKeySecret, String securityToken) throws LogProducerException {
        this(Utils.getContext(), endpoint, project, logstore, accessKeyId, accessKeySecret, securityToken);
    }

    public LogProducerConfig(Context context) throws LogProducerException {
        this(context, null, null, null);
    }

    public LogProducerConfig(Context context, String endpoint, String project, String logstore) throws LogProducerException {
        this(context, endpoint, project, logstore, (String) null, (String) null);
    }

    public LogProducerConfig(Context context, String endpoint, String project, String logstore, String accessKeyId, String accessKeySecret) throws LogProducerException {
        this(context, endpoint, project, logstore, accessKeyId, accessKeySecret, null);
    }

    public LogProducerConfig(Context context, String endpoint, String project, String logstore, String accessKeyId, String accessKeySecret, String securityToken) throws LogProducerException {
        this.enablePersistent = false;
        this.context = context;
        long jCreate_log_producer_config = create_log_producer_config();
        this.config = jCreate_log_producer_config;
        if (jCreate_log_producer_config != 0) {
            setSource("Android");
            setPacketTimeout(3000);
            setPacketLogCount(1024);
            setPacketLogBytes(1048576);
            setSendThreadCount(1);
            setDropUnauthorizedLog(0);
            setDropDelayLog(0);
            setGetTimeUnixFunc(new LogProducerTimeUnixFunc() { // from class: com.aliyun.sls.android.producer.LogProducerConfig.1
                @Override // com.aliyun.sls.android.producer.LogProducerTimeUnixFunc
                public long getTimeUnix() {
                    return TimeUtils.getTimeInMillis();
                }
            });
            setHttpHeaderInjector(new LogProducerHttpHeaderInjector() { // from class: com.aliyun.sls.android.producer.LogProducerConfig.2
                @Override // com.aliyun.sls.android.producer.internal.LogProducerHttpHeaderInjector
                public String[] injectHeaders(String[] srcHeaders, int count) {
                    return HttpHeader.getHeadersWithUA(srcHeaders, new String[0]);
                }
            });
            setEndpoint(endpoint);
            setProject(project);
            setLogstore(logstore);
            setAccessKeyId(accessKeyId);
            setAccessKeySecret(accessKeySecret);
            if (TextUtils.isEmpty(securityToken)) {
                return;
            }
            resetSecurityToken(accessKeyId, accessKeySecret, securityToken);
            return;
        }
        throw new LogProducerException("Can not create log producer config");
    }
}
