package com.kwad.sdk.crash.model.message;

import com.alibaba.android.arouter.utils.Consts;
import com.zj.adlib.u15;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class FastUnwindBackTraceElement implements Serializable {
    private static final long serialVersionUID = -6763898640806477065L;
    public String costInfo;
    public String formatString;
    public long lastUpdateTime;
    public String tag;
    public String threadInfo;
    public int unwindFailReason;
    public long updateTime;
    public String declaringClass = "";
    public String methodName = "";
    public String fileName = "";
    public int lineNumber = 0;
    public String artMethod = "";
    public String pc = "";
    public String buildId = "";
    public boolean isNative = false;
    public boolean isIgnore = false;
    public boolean hasUnwind = true;

    public FastUnwindBackTraceElement(String str) {
        this.formatString = str;
    }

    public static FastUnwindBackTraceElement obtainFastUnwindBackTraceElement(Object obj) {
        FastUnwindBackTraceElement fastUnwindBackTraceElement = new FastUnwindBackTraceElement("");
        if (obj instanceof FastUnwindBackTraceElement) {
            fastUnwindBackTraceElement.updateTraceInfo((FastUnwindBackTraceElement) obj);
        } else if (obj instanceof StackTraceElement) {
            fastUnwindBackTraceElement.updateTraceInfo((StackTraceElement) obj);
        }
        return fastUnwindBackTraceElement;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FastUnwindBackTraceElement)) {
            return false;
        }
        FastUnwindBackTraceElement fastUnwindBackTraceElement = (FastUnwindBackTraceElement) obj;
        if (this.isNative) {
            return fastUnwindBackTraceElement.pc.equals(this.pc);
        }
        String str = fastUnwindBackTraceElement.artMethod;
        return str != null && str.equals(this.artMethod) && fastUnwindBackTraceElement.pc.equals(this.pc);
    }

    public final int hashCode() {
        return this.isNative ? this.pc.hashCode() : (this.artMethod.hashCode() * 31) + this.pc.hashCode();
    }

    public final boolean isEmpty() {
        if (this.isNative) {
            String str = this.pc;
            return str == null || str.isEmpty() || this.pc.equals("0");
        }
        String str2 = this.artMethod;
        return str2 == null || str2.isEmpty() || this.artMethod.equals("0");
    }

    public final String toString() {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (!this.hasUnwind) {
            if (this.isNative) {
                sb = new StringBuilder("native:");
            } else {
                sb = new StringBuilder();
                sb.append(this.artMethod);
                sb.append(u15.f19942b);
            }
            sb.append(this.pc);
            return sb.toString();
        }
        String str = this.formatString;
        if (str != null && !str.isEmpty()) {
            return this.formatString;
        }
        sb2.append(this.declaringClass);
        sb2.append(Consts.DOT);
        sb2.append(this.methodName);
        int i = this.lineNumber;
        if (i == -2) {
            sb2.append("(Native Method)");
        } else if (this.fileName != null) {
            if (i >= 0) {
                sb2.append("(");
                sb2.append(this.fileName);
                sb2.append(u15.f19942b);
                sb2.append(this.lineNumber);
                sb2.append(")");
            } else {
                sb2.append("(");
                sb2.append(this.fileName);
                sb2.append(")");
            }
        } else if (i >= 0) {
            sb2.append("(Unknown Source:");
            sb2.append(this.lineNumber);
            sb2.append(")");
        } else {
            sb2.append("(Unknown Source)");
        }
        return sb2.toString();
    }

    public final String toTraceString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.updateTime);
        sb.append(this.tag);
        String str = this.formatString;
        if (str != null && !str.isEmpty()) {
            sb.append(this.formatString);
            sb.append(this.threadInfo);
            sb.append(this.costInfo);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.declaringClass);
        sb2.append(Consts.DOT);
        sb2.append(this.methodName);
        int i = this.lineNumber;
        if (i == -2) {
            sb2.append("(Native Method)");
        } else if (this.fileName != null) {
            if (i >= 0) {
                sb2.append("(");
                sb2.append(this.fileName);
                sb2.append(u15.f19942b);
                sb2.append(this.lineNumber);
                sb2.append(")");
            } else {
                sb2.append("(");
                sb2.append(this.fileName);
                sb2.append(")");
            }
        } else if (i >= 0) {
            sb2.append("(Unknown Source:");
            sb2.append(this.lineNumber);
            sb2.append(")");
        } else {
            sb2.append("(Unknown Source)");
        }
        this.formatString = sb2.toString();
        sb.append((CharSequence) sb2);
        sb.append(this.threadInfo);
        sb.append(this.costInfo);
        return sb.toString();
    }

    public final void updateTraceInfo(FastUnwindBackTraceElement fastUnwindBackTraceElement) {
        this.artMethod = fastUnwindBackTraceElement.artMethod;
        this.pc = fastUnwindBackTraceElement.pc;
        this.declaringClass = fastUnwindBackTraceElement.declaringClass;
        this.methodName = fastUnwindBackTraceElement.methodName;
        this.fileName = fastUnwindBackTraceElement.fileName;
        this.lineNumber = fastUnwindBackTraceElement.lineNumber;
        this.formatString = fastUnwindBackTraceElement.formatString;
        this.buildId = fastUnwindBackTraceElement.buildId;
        this.isNative = fastUnwindBackTraceElement.isNative;
        this.hasUnwind = fastUnwindBackTraceElement.hasUnwind;
        this.isIgnore = fastUnwindBackTraceElement.isIgnore;
        this.unwindFailReason = fastUnwindBackTraceElement.unwindFailReason;
    }

    public final void updateTraceInfo(StackTraceElement stackTraceElement) {
        this.declaringClass = stackTraceElement.getClassName();
        this.methodName = stackTraceElement.getMethodName();
        this.fileName = stackTraceElement.getFileName();
        this.lineNumber = stackTraceElement.getLineNumber();
        this.hasUnwind = true;
    }
}
