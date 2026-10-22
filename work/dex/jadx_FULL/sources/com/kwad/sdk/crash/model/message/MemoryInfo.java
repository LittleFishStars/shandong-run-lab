package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class MemoryInfo implements b, Serializable {
    private static final long serialVersionUID = -4944913077323984734L;
    public int mAvailableMB;
    public int mFdCount;
    public int mJavaHeapLimitMB;
    public int mJavaHeapMB;
    public int mPssMB;
    public int mRssMB;
    public int mThreadsCount;
    public int mTotalMB;
    public int mVssMB;
    public List<String> mFds = new ArrayList();
    public List<ThreadInfo> mJavaThreads = new ArrayList();
    public List<ThreadInfo> mNativeThreads = new ArrayList();
    public List<ThreadInfo> mAllThreads = new ArrayList();

    public MemoryInfo() {
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mTotalMB = jSONObject.optInt("mTotalMB");
        this.mAvailableMB = jSONObject.optInt("mAvailableMB");
        this.mJavaHeapLimitMB = jSONObject.optInt("mJavaHeapLimitMB");
        this.mJavaHeapMB = jSONObject.optInt("mJavaHeapMB");
        this.mVssMB = jSONObject.optInt("mVssMB");
        this.mRssMB = jSONObject.optInt("mRssMB");
        this.mPssMB = jSONObject.optInt("mPssMB");
        this.mThreadsCount = jSONObject.optInt("mThreadsCount");
        this.mFdCount = jSONObject.optInt("mFdCount");
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("mFds");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (strOptString != null && !strOptString.isEmpty()) {
                        this.mFds.add(strOptString);
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("mJavaThreads");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null) {
                        ThreadInfo threadInfo = new ThreadInfo();
                        threadInfo.parseJson(jSONObjectOptJSONObject);
                        this.mJavaThreads.add(threadInfo);
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("mNativeThreads");
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray3.optJSONObject(i3);
                    if (jSONObjectOptJSONObject2 != null) {
                        ThreadInfo threadInfo2 = new ThreadInfo();
                        threadInfo2.parseJson(jSONObjectOptJSONObject2);
                        this.mNativeThreads.add(threadInfo2);
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("mAllThreads");
            if (jSONArrayOptJSONArray4 == null || jSONArrayOptJSONArray4.length() <= 0) {
                return;
            }
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray4.optJSONObject(i4);
                if (jSONObjectOptJSONObject3 != null) {
                    ThreadInfo threadInfo3 = new ThreadInfo();
                    threadInfo3.parseJson(jSONObjectOptJSONObject3);
                    this.mAllThreads.add(threadInfo3);
                }
            }
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "mTotalMB", this.mTotalMB);
        ac.putValue(jSONObject, "mAvailableMB", this.mAvailableMB);
        ac.putValue(jSONObject, "mJavaHeapLimitMB", this.mJavaHeapLimitMB);
        ac.putValue(jSONObject, "mJavaHeapMB", this.mJavaHeapMB);
        ac.putValue(jSONObject, "mVssMB", this.mVssMB);
        ac.putValue(jSONObject, "mRssMB", this.mRssMB);
        ac.putValue(jSONObject, "mPssMB", this.mPssMB);
        ac.putValue(jSONObject, "mThreadsCount", this.mThreadsCount);
        ac.putValue(jSONObject, "mFdCount", this.mFdCount);
        ac.putValue(jSONObject, "mFds", this.mFds);
        ac.putValue(jSONObject, "mJavaThreads", this.mJavaThreads);
        ac.putValue(jSONObject, "mNativeThreads", this.mNativeThreads);
        ac.putValue(jSONObject, "mAllThreads", this.mAllThreads);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t总RAM容量: ");
        sb.append(this.mTotalMB);
        sb.append(" (MB)\n\t剩余RAM容量: ");
        sb.append(this.mAvailableMB);
        sb.append(" (MB)\n\t本进程Java堆上限: ");
        sb.append(this.mJavaHeapLimitMB);
        sb.append(" (MB)\n\t本进程Java堆已使用: ");
        sb.append(this.mJavaHeapMB);
        sb.append(" (MB)\n\t虚拟地址空间已使用Vss: ");
        sb.append(this.mVssMB);
        sb.append(" (MB)\n\t实际空间使用量(包含共享库) Rss: ");
        sb.append(this.mRssMB);
        sb.append(" (MB)\n\t实际空间使用量(共享库已经均摊)(高内存杀进程的依据）Pss: ");
        sb.append(this.mPssMB);
        sb.append(" (MB)\n\t打开文件描述符数: ");
        sb.append(this.mFdCount);
        sb.append("\n");
        if (this.mFds.size() > 0) {
            sb.append("\t文件描述符详情: \n");
            for (String str : this.mFds) {
                sb.append("\t");
                sb.append(str);
                sb.append("\n");
            }
        }
        sb.append("\t正在运行线程数: ");
        sb.append(this.mThreadsCount);
        sb.append("\tJava: ");
        sb.append(this.mJavaThreads.size());
        sb.append("\tNative: ");
        sb.append(this.mThreadsCount - this.mJavaThreads.size());
        sb.append("\n\n");
        if (this.mAllThreads.size() > 0) {
            sb.append("\t全部线程名: \n");
            for (ThreadInfo threadInfo : this.mAllThreads) {
                sb.append("\t");
                sb.append(threadInfo.mName);
                sb.append("\n");
            }
        }
        if (this.mJavaThreads.size() > 0) {
            sb.append("Java线程堆栈: \n");
            for (ThreadInfo threadInfo2 : this.mJavaThreads) {
                sb.append(threadInfo2.mName);
                sb.append("\n");
                sb.append(threadInfo2.mTrace.replace("#", "\n"));
                sb.append("\n");
            }
        }
        if (this.mNativeThreads.size() > 0) {
            sb.append("\tNative线程堆栈: \n");
            for (ThreadInfo threadInfo3 : this.mNativeThreads) {
                sb.append("\t");
                sb.append(threadInfo3.mName);
                sb.append("\t(tid=");
                sb.append(threadInfo3.mTid);
                sb.append(", index=");
                sb.append(threadInfo3.mIndex);
                sb.append("):\n");
                sb.append(threadInfo3.mTrace);
            }
        }
        return sb.substring(0);
    }

    public MemoryInfo(String str) {
        try {
            if (TextUtils.isEmpty(str) || "Unknown".equals(str)) {
                return;
            }
            parseJson(new JSONObject(str));
        } catch (JSONException e) {
            c.printStackTraceOnly(e);
        }
    }
}
