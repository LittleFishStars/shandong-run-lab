package com.alibaba.ariver.kernel.api.remote;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RemoteCallArgs implements Parcelable {
    private int b;
    private String c;
    private Node d;
    private long e;
    private String f;
    private Object[] g;
    private String h;
    private String i;
    private String[] j;
    private Parcelable k;
    private Map<String, Object> l;
    private int m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f24216a = new AtomicInteger(0);
    public static final Parcelable.Creator<RemoteCallArgs> CREATOR = new Parcelable.Creator<RemoteCallArgs>() { // from class: com.alibaba.ariver.kernel.api.remote.RemoteCallArgs.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteCallArgs createFromParcel(Parcel parcel) {
            return new RemoteCallArgs(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteCallArgs[] newArray(int i) {
            return new RemoteCallArgs[i];
        }
    };

    public RemoteCallArgs(Node node, Extension extension, Method method, Object[] objArr, Parcelable parcelable) {
        this(node != null ? node.getNodeId() : 0L, extension.getClass().getName(), method, objArr);
        this.d = node;
        this.k = parcelable;
    }

    public void addExtraData(String str, Object obj) {
        if (this.l == null) {
            this.l = new HashMap();
        }
        this.l.put(str, obj);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.h;
    }

    public String[] getArgTypes() {
        return this.j;
    }

    public Object[] getArgs() {
        return this.g;
    }

    public String getClassName() {
        return this.f;
    }

    public Parcelable getData() {
        return this.k;
    }

    public Object getExtraData(String str) {
        Map<String, Object> map = this.l;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public String getMethodName() {
        return this.i;
    }

    public Node getNode() {
        return this.d;
    }

    public long getNodeId() {
        return this.e;
    }

    public int getPid() {
        return this.b;
    }

    public int getRemoteSignature() {
        return this.m;
    }

    public String getSourceProcessName() {
        return this.c;
    }

    public String toString() {
        return "RemoteCallArgs{pid=" + this.b + ", node=" + this.d + ", sourceProcessName=" + this.c + ", className=" + this.f + ", method=" + this.i + ", arg=" + this.g + ", argTypes=" + Arrays.toString(this.j) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeLong(this.e);
        parcel.writeParcelable(this.d, 0);
        parcel.writeString(this.f);
        parcel.writeString(this.i);
        parcel.writeString(this.h);
        parcel.writeInt(this.m);
        Object[] objArr = this.g;
        int length = objArr == null ? 0 : objArr.length;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeStringArray(this.j);
            parcel.writeArray(this.g);
        }
        parcel.writeParcelable(this.k, 0);
        if (this.l == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeMap(this.l);
        }
    }

    private RemoteCallArgs(long j, String str, Method method, Object[] objArr) {
        this.m = f24216a.incrementAndGet();
        this.c = ProcessUtils.getProcessName();
        this.b = Process.myPid();
        this.e = j;
        this.f = str;
        this.i = method.getName();
        ActionFilter actionFilter = (ActionFilter) method.getAnnotation(ActionFilter.class);
        if (actionFilter != null) {
            String strValue = actionFilter.value();
            this.h = strValue;
            if (strValue.length() <= 0) {
                this.h = method.getName();
            }
        }
        this.g = objArr;
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length <= 0) {
            return;
        }
        this.j = new String[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            this.j[i] = parameterTypes[i].getName();
        }
    }

    public RemoteCallArgs(Parcel parcel) {
        try {
            this.b = parcel.readInt();
            this.c = parcel.readString();
            this.e = parcel.readLong();
            this.d = (Node) parcel.readParcelable(Node.class.getClassLoader());
            this.f = parcel.readString();
            this.i = parcel.readString();
            this.h = parcel.readString();
            this.m = parcel.readInt();
            int i = parcel.readInt();
            if (i > 0) {
                String[] strArr = new String[i];
                this.j = strArr;
                parcel.readStringArray(strArr);
                this.g = parcel.readArray(getClass().getClassLoader());
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.j;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    if (strArr2[i2].equals(JSONObject.class.getName())) {
                        Object[] objArr = this.g;
                        if (objArr[i2] instanceof Map) {
                            objArr[i2] = new JSONObject((Map<String, Object>) this.g[i2]);
                        }
                    }
                    i2++;
                }
            }
            this.k = parcel.readParcelable(RemoteCallArgs.class.getClassLoader());
            if (parcel.readByte() == 1) {
                HashMap map = new HashMap();
                this.l = map;
                parcel.readMap(map, RemoteCallArgs.class.getClassLoader());
            }
        } catch (Throwable th) {
            RVLogger.e("AriverKernel", "Deserialize RemoteCallArgs error!", th);
            throw th;
        }
    }
}
