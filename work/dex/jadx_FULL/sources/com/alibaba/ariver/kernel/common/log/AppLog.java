package com.alibaba.ariver.kernel.common.log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppLog extends BaseAppLog {
    public static final String APP_LOG_APPEARANCE_FINISH = "appearance finish";
    public static final String APP_LOG_APPEARANCE_START = "appearance start";
    public static final String APP_LOG_ASYNC_UPDATE_FAIL = "async update fail";
    public static final String APP_LOG_ASYNC_UPDATE_FINISH = "async update finish";
    public static final String APP_LOG_ASYNC_UPDATE_START = "async update start";
    public static final String APP_LOG_CONTAINER_AWAKE = "container awake";
    public static final String APP_LOG_CONTAINER_FINISH = "container finish";
    public static final String APP_LOG_CONTAINER_START = "container start";
    public static final String APP_LOG_DECIDE_FAIL = "decide fail";
    public static final String APP_LOG_DECIDE_FINISH = "decide finish";
    public static final String APP_LOG_DECIDE_START = "decide start";
    public static final String APP_LOG_DOWNGRADE = "prepare downgrade";
    public static final String APP_LOG_PREPARE = "prepare ";
    public static final String APP_LOG_PREPARE_FAIL = "prepare fail";
    public static final String APP_LOG_PREPARE_FINISH = "prepare finish";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24247a;
    private String b;

    public static class Builder extends BaseAppLog.Builder<Builder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f24248a;
        private String b;

        public Builder() {
            super(LogType.APP);
            this.f24248a = "";
            this.b = "";
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public BaseAppLog build() {
            return new AppLog(this);
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder getThis() {
            return this;
        }

        public Builder setAppId(String str) {
            this.b = str;
            return getThis();
        }

        public Builder setDesc(String str) {
            this.f24248a = str;
            return getThis();
        }
    }

    @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog
    public String toString() {
        return baseInfo() + " " + this.f24247a + ", " + this.b;
    }

    private AppLog(Builder builder) {
        super(builder);
        this.f24247a = builder.b;
        this.b = builder.f24248a;
    }
}
