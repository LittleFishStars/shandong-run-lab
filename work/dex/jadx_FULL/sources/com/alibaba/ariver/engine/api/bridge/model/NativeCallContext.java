package com.alibaba.ariver.engine.api.bridge.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NativeCallContext<T extends Node> implements Parcelable {
    public static final String CALL_MODE_ASYNC = "async";
    public static final String CALL_MODE_SYNC = "sync";
    public static final String CALL_MODE_UNKNOWN = "unknown";
    public static final String DOMAIN_APP = "app";
    public static final String DOMAIN_APPX = "appx";
    public static final String FROM_WORKER = "fromWorker";
    private final StatData b;
    private Render c;
    private String d;
    private JSONObject e;
    private T f;
    private String g;
    private String h;

    @Nullable
    private String i;

    @Nullable
    private String j;

    @Nullable
    private String k;

    @Nullable
    private String l;
    private String m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicLong f24050a = new AtomicLong(Process.myPid());
    public static final Parcelable.Creator<NativeCallContext> CREATOR = new Parcelable.Creator<NativeCallContext>() { // from class: com.alibaba.ariver.engine.api.bridge.model.NativeCallContext.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NativeCallContext createFromParcel(Parcel parcel) {
            return new NativeCallContext(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NativeCallContext[] newArray(int i) {
            return new NativeCallContext[i];
        }
    };

    public static class Builder {
        public boolean dispatcherOnWorkerThread;
        public String name;
        public Node node;
        public String originalData;
        public JSONObject params;
        public Render render;
        public String source;
        public StatData statData;
        public String id = "native_" + System.currentTimeMillis();
        public String callMode = "unknown";

        private Builder a(StatData statData) {
            this.statData = statData;
            return this;
        }

        public NativeCallContext build() {
            return new NativeCallContext(this);
        }

        public Builder callMode(String str) {
            this.callMode = str;
            return this;
        }

        public Builder dispatcherOnWorkerThread(boolean z) {
            this.dispatcherOnWorkerThread = z;
            return this;
        }

        public Builder generateLegacyNativeId() {
            this.id = "native_" + System.currentTimeMillis();
            return this;
        }

        public Builder id(String str) {
            this.id = str;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder node(Node node) {
            this.node = node;
            return this;
        }

        public Builder originalData(String str) {
            this.originalData = str;
            return this;
        }

        public Builder params(JSONObject jSONObject) {
            this.params = jSONObject;
            return this;
        }

        public Builder render(Render render) {
            this.render = render;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }
    }

    public static class StatData implements Parcelable {
        public static final Parcelable.Creator<StatData> CREATOR = new Parcelable.Creator<StatData>() { // from class: com.alibaba.ariver.engine.api.bridge.model.NativeCallContext.StatData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public StatData createFromParcel(Parcel parcel) {
                return new StatData(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public StatData[] newArray(int i) {
                return new StatData[i];
            }
        };
        public long callbackTimeStamp;
        public long executeTimeStamp;
        public long triggerTimeStamp;

        public StatData() {
        }

        public void copyData(StatData statData) {
            if (statData == null) {
                return;
            }
            this.triggerTimeStamp = statData.triggerTimeStamp;
            this.executeTimeStamp = statData.executeTimeStamp;
            this.callbackTimeStamp = statData.callbackTimeStamp;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String print() {
            return "total(" + (this.callbackTimeStamp - this.triggerTimeStamp) + ")|dispatch(" + (this.executeTimeStamp - this.triggerTimeStamp) + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.triggerTimeStamp);
            parcel.writeLong(this.executeTimeStamp);
            parcel.writeLong(this.callbackTimeStamp);
        }

        public StatData(Parcel parcel) {
            this.triggerTimeStamp = parcel.readLong();
            this.executeTimeStamp = parcel.readLong();
            this.callbackTimeStamp = parcel.readLong();
        }
    }

    public static long generateUniqueId() {
        return System.currentTimeMillis() + f24050a.addAndGet(1L);
    }

    public static Builder newBuilder(String str) {
        return new Builder().name(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getAppxDomain() {
        return this.j;
    }

    public String getCallMode() {
        return this.m;
    }

    @Nullable
    public String getContextId() {
        return this.k;
    }

    public String getId() {
        return this.g;
    }

    public String getName() {
        return this.d;
    }

    public T getNode() {
        return this.f;
    }

    @Nullable
    public String getOriginalData() {
        return this.l;
    }

    public JSONObject getParams() {
        return this.e;
    }

    @Nullable
    public String getPluginId() {
        return this.i;
    }

    public Render getRender() {
        return this.c;
    }

    public String getSource() {
        return this.h;
    }

    public StatData getStatData() {
        return this.b;
    }

    public void setAppxDomain(@Nullable String str) {
        this.j = str;
    }

    public void setCallMode(String str) {
        this.m = str;
    }

    public void setContextId(@Nullable String str) {
        this.k = str;
    }

    public void setId(String str) {
        this.g = str;
    }

    public void setName(String str) {
        this.d = str;
    }

    public void setNode(T t) {
        this.f = t;
    }

    public void setOriginalData(@Nullable String str) {
        this.l = str;
    }

    public void setParams(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    public void setPluginId(@Nullable String str) {
        this.i = str;
    }

    public void setRender(Render render) {
        this.c = render;
    }

    public void setSource(String str) {
        this.h = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NativeCallContext{name=");
        sb.append(this.d);
        sb.append(", params=");
        sb.append(this.e);
        sb.append(", id=");
        sb.append(this.g);
        if (this.i != null) {
            sb.append(", pluginId=");
            sb.append(this.i);
        }
        sb.append(", callMode=");
        sb.append(this.m);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.d);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        byte[] bArrMarshallJSONObject = JSONUtils.marshallJSONObject(this.e);
        int length = bArrMarshallJSONObject == null ? 0 : bArrMarshallJSONObject.length;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(bArrMarshallJSONObject, 0, length);
        }
        parcel.writeParcelable(this.f, 0);
        parcel.writeString(this.i);
        parcel.writeString(this.k);
        parcel.writeString(this.m);
    }

    public NativeCallContext() {
        this.b = new StatData();
    }

    private NativeCallContext(Builder builder) {
        StatData statData = new StatData();
        this.b = statData;
        this.c = builder.render;
        this.d = builder.name;
        JSONObject jSONObject = builder.params;
        this.e = jSONObject;
        this.f = (T) builder.node;
        this.g = builder.id;
        this.h = builder.source;
        this.l = builder.originalData;
        String string = JSONUtils.getString(jSONObject, "__appxDomain");
        if (!TextUtils.isEmpty(string) && FROM_WORKER.equalsIgnoreCase(this.h)) {
            if (!DOMAIN_APP.equalsIgnoreCase(string) && !DOMAIN_APPX.equalsIgnoreCase(string)) {
                this.i = string;
            }
            this.j = string;
        }
        this.k = JSONUtils.getString(this.e, "contextId");
        statData.copyData(builder.statData);
        this.m = builder.callMode;
    }

    public NativeCallContext(Parcel parcel) {
        this.b = new StatData();
        this.d = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        int i = parcel.readInt();
        if (i > 0) {
            byte[] bArr = new byte[i];
            parcel.readByteArray(bArr);
            this.e = JSONUtils.unmarshallJSONObject(bArr);
        }
        this.f = (T) parcel.readParcelable(NativeCallContext.class.getClassLoader());
        this.i = parcel.readString();
        this.k = parcel.readString();
        this.m = parcel.readString();
    }
}
