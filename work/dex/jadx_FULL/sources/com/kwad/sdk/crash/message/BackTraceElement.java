package com.kwad.sdk.crash.message;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.a.a;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class BackTraceElement extends a implements Serializable {
    private static final long serialVersionUID = 631048314192081635L;
    public String mFileName;
    public int mIndex;
    public String mLine;
    public long mLineNumber;
    public String mMethodName;
    public boolean mNeedClustering;

    public BackTraceElement() {
        this.mLine = "";
        this.mMethodName = "";
        this.mFileName = "";
        this.mLineNumber = 0L;
        this.mNeedClustering = true;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getLine() {
        return this.mLine;
    }

    public long getLineNumber() {
        return this.mLineNumber;
    }

    public String getMethodName() {
        return this.mMethodName;
    }

    public boolean isNeedClustering() {
        return this.mNeedClustering;
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public void setLine(String str) {
        this.mLine = str;
    }

    public void setLineNumber(long j) {
        this.mLineNumber = j;
    }

    public void setMethodName(String str) {
        this.mMethodName = str;
    }

    public void setNeedClustering(boolean z) {
        this.mNeedClustering = z;
    }

    public BackTraceElement(String str, int i) {
        this.mMethodName = "";
        this.mFileName = "";
        this.mLineNumber = 0L;
        this.mNeedClustering = true;
        this.mLine = str;
        this.mIndex = i;
    }
}
