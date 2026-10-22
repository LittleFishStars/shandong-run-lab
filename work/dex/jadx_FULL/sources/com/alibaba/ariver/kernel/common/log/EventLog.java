package com.alibaba.ariver.kernel.common.log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EventLog extends BaseAppLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24254a;
    private String b;

    public static class Builder extends BaseAppLog.Builder<Builder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f24255a;
        private String b;

        public Builder() {
            super(LogType.EVENT);
            this.f24255a = "";
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public BaseAppLog build() {
            return new EventLog(this);
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder getThis() {
            return this;
        }

        public Builder setData(String str) {
            this.f24255a = str;
            return getThis();
        }

        public Builder setEventName(String str) {
            this.b = str;
            return getThis();
        }
    }

    @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog
    public String toString() {
        return baseInfo() + " " + this.b + " " + this.f24254a;
    }

    private EventLog(Builder builder) {
        super(builder);
        this.f24254a = builder.f24255a;
        this.b = builder.b;
    }
}
