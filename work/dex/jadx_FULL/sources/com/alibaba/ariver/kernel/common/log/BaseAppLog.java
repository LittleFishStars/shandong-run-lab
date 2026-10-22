package com.alibaba.ariver.kernel.common.log;

import android.text.TextUtils;
import com.zj.adlib.c49;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BaseAppLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24250a = AppLogger.getBizType();
    private LogType b;
    private String c;
    private String d;
    private String e;

    public static abstract class Builder<T extends Builder<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f24251a;
        private String b = c49.f40900a;
        private String c;
        private LogType d;

        public Builder(LogType logType) {
            this.d = logType;
        }

        public abstract BaseAppLog build();

        public abstract T getThis();

        public T setGroupId(String str) {
            this.b = str;
            return (T) getThis();
        }

        public T setParentId(String str) {
            this.f24251a = str;
            return (T) getThis();
        }

        public T setState(String str) {
            this.c = str;
            return (T) getThis();
        }
    }

    public BaseAppLog(Builder builder) {
        this.b = builder.d;
        this.c = builder.f24251a;
        this.d = builder.b;
        this.e = builder.c;
    }

    public String baseInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f24250a);
        sb.append(", ");
        sb.append(this.b.getTypeSting());
        sb.append(", ");
        sb.append(this.c);
        sb.append(", ");
        sb.append(this.d);
        sb.append(",");
        if (!TextUtils.isEmpty(this.e)) {
            sb.append(" ");
            sb.append(this.e);
        }
        return sb.toString();
    }

    public String getBizType() {
        return this.f24250a;
    }

    public String getGroupId() {
        return this.d;
    }

    public LogType getLogType() {
        return this.b;
    }

    public String getParentId() {
        return this.c;
    }

    public String getState() {
        return this.e;
    }

    public String toString() {
        return baseInfo();
    }
}
