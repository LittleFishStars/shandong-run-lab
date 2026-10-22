package com.alibaba.ariver.kernel.common.log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WorkerLog extends BaseAppLog {
    public static final String WORKER_LOG_STATE_ERROR = "error";
    public static final String WORKER_LOG_STATE_START = "start";
    public static final String WORKER_LOG_STATE_SUCCESS = "success";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24258a;
    private String b;
    private String c;
    private Integer d;

    public static class Builder extends BaseAppLog.Builder<Builder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f24259a;
        private String b;
        private String c;
        private Integer d;

        public Builder() {
            super(LogType.WORKER);
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public BaseAppLog build() {
            return new WorkerLog(this);
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder getThis() {
            return this;
        }

        public Builder setAppId(String str) {
            this.f24259a = str;
            return getThis();
        }

        public Builder setDesc(String str) {
            this.c = str;
            return getThis();
        }

        public Builder setErrCode(int i) {
            this.d = Integer.valueOf(i);
            return getThis();
        }

        public Builder setTag(String str) {
            this.b = str;
            return getThis();
        }
    }

    public String getData() {
        return this.c;
    }

    @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog
    public String toString() {
        String str;
        String state = getState();
        state.hashCode();
        switch (state) {
            case "success":
            case "start":
                str = String.format("%s %s %s", baseInfo(), this.f24258a, this.b);
                if (this.c != null) {
                    return str + " " + this.c;
                }
                break;
            case "error":
                str = String.format("%s %s(%s) %s", baseInfo(), this.f24258a, String.valueOf(this.d), this.b);
                if (this.c != null) {
                    return str + " " + this.c;
                }
                break;
            default:
                return super.toString();
        }
        return str;
    }

    private WorkerLog(Builder builder) {
        super(builder);
        this.f24258a = builder.f24259a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
    }
}
