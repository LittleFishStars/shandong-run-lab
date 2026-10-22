package com.alibaba.ariver.kernel.common.log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PageLog extends BaseAppLog {
    public static final String PAGE_LOG_STATE_FAIL = "fail";
    public static final String PAGE_LOG_STATE_FINISH = "finish";
    public static final String PAGE_LOG_STATE_START = "start";
    public static final String PAGE_LOG_TAGS = "tags";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24256a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private PageSource g;
    private String h;

    public static class Builder extends BaseAppLog.Builder<Builder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f24257a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private PageSource g;
        private String h;

        public Builder() {
            super(LogType.PAGE);
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public BaseAppLog build() {
            return new PageLog(this);
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder getThis() {
            return this;
        }

        public Builder setAppStartSessionToken(String str) {
            this.f = str;
            return getThis();
        }

        public Builder setErrMsg(String str) {
            this.f24257a = str;
            return getThis();
        }

        public Builder setPageSource(PageSource pageSource) {
            this.g = pageSource;
            return getThis();
        }

        public Builder setRefer(String str) {
            this.c = str;
            return getThis();
        }

        public Builder setTitle(String str) {
            this.d = str;
            return getThis();
        }

        public Builder setToken(String str) {
            this.e = str;
            return getThis();
        }

        public Builder setUrl(String str) {
            this.b = str;
            return getThis();
        }

        public Builder setWarningMsg(String str) {
            this.h = str;
            return getThis();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x003c  */
    @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog
    public String toString() {
        byte b;
        String strBaseInfo = baseInfo();
        switch (getState()) {
            case "finish":
                b = 1;
                break;
            case "fail":
                b = 3;
                break;
            case "tags":
                b = 2;
                break;
            case "start":
                b = 0;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            if (this.g == null) {
                return strBaseInfo + " " + this.f24256a + ", " + this.e;
            }
            return strBaseInfo + " " + this.f24256a + ", source:" + this.g.sourceType.getRaw() + " from " + this.g.sourceDesc + ", " + this.e + ", " + this.f + ", " + this.g.sourcePageAppLogToken;
        }
        if (b == 1) {
            return strBaseInfo + " " + this.f24256a + ", " + this.d + " " + this.c;
        }
        if (b != 2) {
            return strBaseInfo + " " + this.f24256a + ", " + this.b;
        }
        return strBaseInfo + " error:" + this.b + " warning:" + this.h + " title:" + this.d;
    }

    private PageLog(Builder builder) {
        super(builder);
        this.f24256a = builder.b;
        this.b = builder.f24257a;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.g = builder.g;
        this.f = builder.f;
        this.h = builder.h;
    }
}
