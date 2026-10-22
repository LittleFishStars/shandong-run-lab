package com.alipay.mobile.jsengine.v8;

import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class V8ScriptException extends V8RuntimeException {
    private final int endColumn;
    private final String fileName;
    private final String jsMessage;
    private final String jsStackTrace;
    private final int lineNumber;
    private final String sourceLine;
    private final int startColumn;

    public V8ScriptException(String str, int i, String str2, String str3, int i2, int i3, String str4, Throwable th) {
        this.fileName = str;
        this.lineNumber = i;
        this.jsMessage = str2;
        this.sourceLine = str3;
        this.startColumn = i2;
        this.endColumn = i3;
        this.jsStackTrace = str4;
        if (th != null) {
            initCause(th);
        }
    }

    private char[] createCharSequence(int i, char c) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = c;
        }
        return cArr;
    }

    private String createJSStackDetails() {
        if (this.jsStackTrace == null) {
            return "";
        }
        return "\n" + this.jsStackTrace;
    }

    private String createMessageDetails() {
        StringBuilder sb = new StringBuilder();
        String str = this.sourceLine;
        if (str != null && !str.isEmpty()) {
            sb.append('\n');
            sb.append(this.sourceLine);
            sb.append('\n');
            int i = this.startColumn;
            if (i >= 0) {
                sb.append(createCharSequence(i, ' '));
                sb.append(createCharSequence(this.endColumn - this.startColumn, '^'));
            }
        }
        return sb.toString();
    }

    private String createMessageLine() {
        return this.fileName + u15.f19942b + this.lineNumber + "[" + this.startColumn + "," + this.endColumn + "]: " + this.jsMessage;
    }

    public int getEndColumn() {
        return this.endColumn;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getJSMessage() {
        return this.jsMessage;
    }

    public String getJSStackTrace() {
        return this.jsStackTrace;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return createMessageLine();
    }

    public String getSourceLine() {
        return this.sourceLine;
    }

    public int getStartColumn() {
        return this.startColumn;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return createMessageLine() + createMessageDetails() + createJSStackDetails() + "\n" + getClass().getName();
    }
}
