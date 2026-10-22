package com.alibaba.ariver.kernel.common.log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ApiLog extends BaseAppLog {
    public static final String API_LOG_STATE_ERROR = "error";
    public static final String API_LOG_STATE_START = "start";
    public static final String API_LOG_STATE_SUCCESS = "success";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24245a;
    private String b;
    private Integer c;

    public static class Builder extends BaseAppLog.Builder<Builder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f24246a;
        private String b;
        private Integer c;

        public Builder() {
            super(LogType.API);
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public BaseAppLog build() {
            return new ApiLog(this);
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder getThis() {
            return this;
        }

        public Builder setApiName(String str) {
            this.f24246a = str;
            return getThis();
        }

        public Builder setData(String str) {
            this.b = str;
            return getThis();
        }

        public Builder setErrCode(int i) {
            this.c = Integer.valueOf(i);
            return getThis();
        }
    }

    public String getData() {
        return this.f24245a;
    }

    @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog
    public String toString() {
        String strBaseInfo = baseInfo();
        String state = getState();
        state.hashCode();
        switch (state) {
            case "success":
            case "start":
                return strBaseInfo + " " + this.b + " " + this.f24245a;
            case "error":
                return strBaseInfo + "(" + this.c.toString() + ") " + this.b + " " + this.f24245a;
            default:
                return super.toString();
        }
    }

    private ApiLog(Builder builder) {
        super(builder);
        this.f24245a = builder.b;
        this.b = builder.f24246a;
        this.c = builder.c;
    }
}
