package com.alipay.mobile.jsengine.v8;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class V8 extends V8Object {
    private static volatile int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Map<Long, V8Value> f25359a;
    private Map<String, Object> g;
    private long h;
    private long i;
    private List<Releasable> j;
    private Map<Long, MethodDescriptor> k;
    private LinkedList<ReferenceHandler> l;
    private static Object e = new Object();
    private static V8Value m = new V8Object.Undefined();
    private static Object n = new Object();

    public class MethodDescriptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f25360a;
        Method b;
        JavaCallback c;
        JavaVoidCallback d;
        boolean e;

        private MethodDescriptor() {
        }
    }

    public V8() {
        this(null, null, null, null);
    }

    private native void _add(long j, long j2, String str, double d);

    private native void _add(long j, long j2, String str, int i);

    private native void _add(long j, long j2, String str, String str2);

    private native void _add(long j, long j2, String str, boolean z);

    private native void _addArrayBooleanItem(long j, long j2, boolean z);

    private native void _addArrayDoubleItem(long j, long j2, double d);

    private native void _addArrayIntItem(long j, long j2, int i);

    private native void _addArrayNullItem(long j, long j2);

    private native void _addArrayObjectItem(long j, long j2, long j3);

    private native void _addArrayStringItem(long j, long j2, String str);

    private native void _addArrayUndefinedItem(long j, long j2);

    private native void _addNull(long j, long j2, String str);

    private native void _addObject(long j, long j2, String str, long j3);

    private native void _addUndefined(long j, long j2, String str);

    private native Object _arrayGet(long j, int i, long j2, int i2);

    private native boolean _arrayGetBoolean(long j, long j2, int i);

    private native int _arrayGetBooleans(long j, long j2, int i, int i2, boolean[] zArr);

    private native boolean[] _arrayGetBooleans(long j, long j2, int i, int i2);

    private native byte _arrayGetByte(long j, long j2, int i);

    private native int _arrayGetBytes(long j, long j2, int i, int i2, byte[] bArr);

    private native byte[] _arrayGetBytes(long j, long j2, int i, int i2);

    private native double _arrayGetDouble(long j, long j2, int i);

    private native int _arrayGetDoubles(long j, long j2, int i, int i2, double[] dArr);

    private native double[] _arrayGetDoubles(long j, long j2, int i, int i2);

    private native int _arrayGetInteger(long j, long j2, int i);

    private native int _arrayGetIntegers(long j, long j2, int i, int i2, int[] iArr);

    private native int[] _arrayGetIntegers(long j, long j2, int i, int i2);

    private native int _arrayGetSize(long j, long j2);

    private native String _arrayGetString(long j, long j2, int i);

    private native int _arrayGetStrings(long j, long j2, int i, int i2, String[] strArr);

    private native String[] _arrayGetStrings(long j, long j2, int i, int i2);

    private static native void _cancelSerialization(long j);

    private native long _compileScript(long j, String str, String str2, int i);

    private native boolean _contains(long j, long j2, String str);

    private native long _createIsolate(String str, String str2, String[] strArr, Object obj);

    private native void _createTwin(long j, long j2, long j3);

    private native ByteBuffer _createV8ArrayBufferBackingStore(long j, long j2, int i);

    private native void _debugRegisterContext(long j, long j2, String str);

    private native Object _deserialize(long j, long j2);

    private native void _dispatchFrontendMessage(long j, String str);

    private native void _dispatchPluginEvent(long j, int i, String str, int i2);

    private native boolean _enableDebugAgent(long j, String str);

    private native void _enterContext(long j, long j2);

    private native boolean _equals(long j, long j2, long j3);

    private native boolean _executeBooleanFunction(long j, long j2, String str, long j3);

    private native boolean _executeBooleanScript(long j, String str, String str2, int i);

    private native double _executeDoubleFunction(long j, long j2, String str, long j3);

    private native double _executeDoubleScript(long j, String str, String str2, int i);

    private native Object _executeFunction(long j, int i, long j2, String str, long j3);

    private native Object _executeFunction(long j, long j2, long j3, long j4);

    private native int _executeIntegerFunction(long j, long j2, String str, long j3);

    private native int _executeIntegerScript(long j, String str, String str2, int i);

    private native Object _executeScript(long j, int i, String str, String str2, int i2);

    private native String _executeStringFunction(long j, long j2, String str, long j3);

    private native String _executeStringScript(long j, String str, String str2, int i);

    private native void _executeVoidFunction(long j, long j2, String str, long j3);

    private native void _executeVoidScript(long j, String str, String str2, int i);

    private native void _executeVoidScript2(long j, byte[] bArr, String str, int i);

    private native void _exitContext(long j, long j2);

    private native void _flushCodeCache(long j);

    private native Object _get(long j, int i, long j2, String str);

    private native int _getArrayType(long j, long j2);

    private native boolean _getBoolean(long j, long j2, String str);

    private native long _getBuildID();

    private native long _getContextGlobalHandle(long j, long j2);

    private native double _getDouble(long j, long j2, String str);

    private native long _getGlobalObject(long j);

    private native int _getInteger(long j, long j2, String str);

    private native String[] _getKeys(long j, long j2);

    private native String _getString(long j, long j2, String str);

    private native int _getType(long j, long j2);

    private native int _getType(long j, long j2, int i);

    private native int _getType(long j, long j2, int i, int i2);

    private native int _getType(long j, long j2, String str);

    private static native String _getVersion();

    private native int _identityHash(long j, long j2);

    private native long _initNewV8Array(long j);

    private native long _initNewV8ArrayBuffer(long j, int i);

    private native long _initNewV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i);

    private native long _initNewV8Context(long j, long j2);

    private native long[] _initNewV8Function(long j);

    private native long _initNewV8Object(long j);

    private native boolean _isWeak(long j, long j2);

    private native void _lowMemoryNotification(long j);

    private static native boolean _pumpMessageLoop(long j, boolean z);

    private native long _registerJavaMethod(long j, long j2, String str, boolean z);

    private native void _release(long j, long j2);

    private native void _releaseMethodDescriptor(long j, long j2);

    private native void _releaseRuntime(long j);

    private native void _runScript(long j, long j2);

    private native boolean _sameValue(long j, long j2, long j3);

    private native long _serialize(long j, long j2);

    private static native void _setFlags(String str);

    private native void _setPrototype(long j, long j2, long j3);

    private native void _setWeak(long j, long j2);

    private native boolean _strictEquals(long j, long j2, long j3);

    private native void _terminateExecution(long j);

    private native String _toString(long j, long j2);

    private void b() {
        Iterator<Long> it = this.k.keySet().iterator();
        while (it.hasNext()) {
            releaseMethodDescriptor(this.i, it.next().longValue());
        }
    }

    private void c() {
        List<Releasable> list = this.j;
        if (list != null) {
            Iterator<Releasable> it = list.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.j.clear();
            this.j = null;
        }
    }

    public static void cancelSerialization(long j) {
        _cancelSerialization(j);
    }

    public static V8 createV8Runtime() {
        return createV8Runtime(null, null, null, null);
    }

    private void d(V8Value v8Value) {
        Iterator<ReferenceHandler> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().v8HandleCreated(v8Value);
        }
    }

    private void e(V8Value v8Value) {
        Iterator<ReferenceHandler> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().v8HandleDisposed(v8Value);
        }
    }

    public static int getActiveRuntimes() {
        return f;
    }

    public static String getSCMRevision() {
        return "Unknown revision ID";
    }

    public static V8Value getUndefined() {
        return m;
    }

    public static String getV8Version() {
        return _getVersion();
    }

    public static void setFlags(String str) {
        _setFlags(str);
    }

    public void a(V8Value v8Value) {
        if (v8Value == null || v8Value.isUndefined()) {
            return;
        }
        V8 runtime = v8Value.getRuntime();
        if (runtime == null || runtime.isReleased() || runtime != this) {
            throw new Error("Invalid target runtime");
        }
    }

    public void add(long j, long j2, String str, int i) {
        _add(j, j2, str, i);
    }

    public void addArrayBooleanItem(long j, long j2, boolean z) {
        _addArrayBooleanItem(j, j2, z);
    }

    public void addArrayDoubleItem(long j, long j2, double d) {
        _addArrayDoubleItem(j, j2, d);
    }

    public void addArrayIntItem(long j, long j2, int i) {
        _addArrayIntItem(j, j2, i);
    }

    public void addArrayNullItem(long j, long j2) {
        _addArrayNullItem(j, j2);
    }

    public void addArrayObjectItem(long j, long j2, long j3) {
        _addArrayObjectItem(j, j2, j3);
    }

    public void addArrayStringItem(long j, long j2, String str) {
        if (str == null) {
            _addArrayNullItem(j, j2);
        } else {
            _addArrayStringItem(j, j2, str);
        }
    }

    public void addArrayUndefinedItem(long j, long j2) {
        _addArrayUndefinedItem(j, j2);
    }

    public void addNull(long j, long j2, String str) {
        _addNull(j, j2, str);
    }

    public void addObject(long j, long j2, String str, long j3) {
        _addObject(j, j2, str, j3);
    }

    public void addReferenceHandler(ReferenceHandler referenceHandler) {
        this.l.add(0, referenceHandler);
    }

    public void addUndefined(long j, long j2, String str) {
        _addUndefined(j, j2, str);
    }

    public Object arrayGet(long j, int i, long j2, int i2) {
        return _arrayGet(j, i, j2, i2);
    }

    public boolean arrayGetBoolean(long j, long j2, int i) {
        return _arrayGetBoolean(j, j2, i);
    }

    public boolean[] arrayGetBooleans(long j, long j2, int i, int i2) {
        return _arrayGetBooleans(j, j2, i, i2);
    }

    public byte arrayGetByte(long j, long j2, int i) {
        return _arrayGetByte(j, j2, i);
    }

    public byte[] arrayGetBytes(long j, long j2, int i, int i2) {
        return _arrayGetBytes(j, j2, i, i2);
    }

    public double arrayGetDouble(long j, long j2, int i) {
        return _arrayGetDouble(j, j2, i);
    }

    public double[] arrayGetDoubles(long j, long j2, int i, int i2) {
        return _arrayGetDoubles(j, j2, i, i2);
    }

    public int arrayGetInteger(long j, long j2, int i) {
        return _arrayGetInteger(j, j2, i);
    }

    public int[] arrayGetIntegers(long j, long j2, int i, int i2) {
        return _arrayGetIntegers(j, j2, i, i2);
    }

    public int arrayGetSize(long j, long j2) {
        return _arrayGetSize(j, j2);
    }

    public String arrayGetString(long j, long j2, int i) {
        return _arrayGetString(j, j2, i);
    }

    public String[] arrayGetStrings(long j, long j2, int i, int i2) {
        return _arrayGetStrings(j, j2, i, i2);
    }

    public Object callObjectJavaMethod(long j, V8Object v8Object, V8Array v8Array) {
        MethodDescriptor methodDescriptor = this.k.get(Long.valueOf(j));
        JavaCallback javaCallback = methodDescriptor.c;
        if (javaCallback != null) {
            return a(javaCallback.invoke(v8Object, v8Array));
        }
        boolean zIsVarArgs = methodDescriptor.b.isVarArgs();
        Object[] objArrA = a(v8Object, methodDescriptor, v8Array, zIsVarArgs);
        a(objArrA);
        try {
            try {
                try {
                    try {
                        Object objA = a(methodDescriptor.b.invoke(methodDescriptor.f25360a, objArrA));
                        a(objArrA, zIsVarArgs);
                        return objA;
                    } catch (InvocationTargetException e2) {
                        throw e2.getTargetException();
                    }
                } catch (IllegalAccessException e3) {
                    throw e3;
                }
            } catch (IllegalArgumentException e4) {
                throw e4;
            }
        } catch (Throwable th) {
            a(objArrA, zIsVarArgs);
            throw th;
        }
    }

    public void callVoidJavaMethod(long j, V8Object v8Object, V8Array v8Array) {
        MethodDescriptor methodDescriptor = this.k.get(Long.valueOf(j));
        JavaVoidCallback javaVoidCallback = methodDescriptor.d;
        if (javaVoidCallback != null) {
            javaVoidCallback.invoke(v8Object, v8Array);
            return;
        }
        boolean zIsVarArgs = methodDescriptor.b.isVarArgs();
        Object[] objArrA = a(v8Object, methodDescriptor, v8Array, zIsVarArgs);
        a(objArrA);
        try {
            try {
                methodDescriptor.b.invoke(methodDescriptor.f25360a, objArrA);
                a(objArrA, zIsVarArgs);
            } catch (IllegalAccessException e2) {
                throw e2;
            } catch (IllegalArgumentException e3) {
                throw e3;
            } catch (InvocationTargetException e4) {
                throw e4.getTargetException();
            }
        } catch (Throwable th) {
            a(objArrA, zIsVarArgs);
            throw th;
        }
    }

    public long compileScript(String str, String str2, int i) {
        return _compileScript(this.i, str, str2, i);
    }

    public boolean contains(long j, long j2, String str) {
        return _contains(j, j2, str);
    }

    public void createTwin(V8Value v8Value, V8Value v8Value2) {
        a();
        createTwin(this.i, v8Value.getHandle(), v8Value2.getHandle());
    }

    public ByteBuffer createV8ArrayBufferBackingStore(long j, long j2, int i) {
        return _createV8ArrayBufferBackingStore(j, j2, i);
    }

    public void debugRegisterContext(long j, String str) {
        _debugRegisterContext(getV8RuntimePtr(), j, str);
    }

    public V8Value deserialize(long j) {
        Object obj_deserialize = _deserialize(this.i, j);
        if (obj_deserialize instanceof V8Value) {
            return (V8Value) obj_deserialize;
        }
        return null;
    }

    public void dispatchFrontendMessage(long j, String str) {
        _dispatchFrontendMessage(j, str);
    }

    public void dispatchPluginEvent(int i, String str, int i2) {
        _dispatchPluginEvent(this.i, i, str, i2);
    }

    public void disposeMethodID(long j) {
        this.k.remove(Long.valueOf(j));
    }

    public boolean enableDebugAgent(String str) {
        return _enableDebugAgent(getV8RuntimePtr(), str);
    }

    public void enterContext(long j, long j2) {
        _enterContext(j, j2);
    }

    public boolean equals(long j, long j2, long j3) {
        return _equals(j, j2, j3);
    }

    public V8Array executeArrayScript(String str) {
        return executeArrayScript(str, null, 0);
    }

    public boolean executeBooleanFunction(long j, long j2, String str, long j3) {
        return _executeBooleanFunction(j, j2, str, j3);
    }

    public boolean executeBooleanScript(String str) {
        return executeBooleanScript(str, null, 0);
    }

    public double executeDoubleFunction(long j, long j2, String str, long j3) {
        return _executeDoubleFunction(j, j2, str, j3);
    }

    public double executeDoubleScript(String str) {
        return executeDoubleScript(str, null, 0);
    }

    public Object executeFunction(long j, int i, long j2, String str, long j3) {
        return _executeFunction(j, i, j2, str, j3);
    }

    public int executeIntegerFunction(long j, long j2, String str, long j3) {
        return _executeIntegerFunction(j, j2, str, j3);
    }

    public int executeIntegerScript(String str) {
        return executeIntegerScript(str, null, 0);
    }

    public V8Object executeObjectScript(String str) {
        return executeObjectScript(str, null, 0);
    }

    public Object executeScript(String str) {
        return executeScript(str, null, 0);
    }

    public String executeStringFunction(long j, long j2, String str, long j3) {
        return _executeStringFunction(j, j2, str, j3);
    }

    public String executeStringScript(String str) {
        return executeStringScript(str, null, 0);
    }

    public void executeVoidFunction(long j, long j2, String str, long j3) {
        _executeVoidFunction(j, j2, str, j3);
    }

    public void executeVoidScript(String str) {
        executeVoidScript(str, (String) null, 0);
    }

    public void exitContext(long j, long j2) {
        _exitContext(j, j2);
    }

    public void flushCodeCache() {
        _flushCodeCache(getV8RuntimePtr());
    }

    public Object get(long j, int i, long j2, String str) {
        return _get(j, i, j2, str);
    }

    public int getArrayType(long j, long j2) {
        return _getArrayType(j, j2);
    }

    public boolean getBoolean(long j, long j2, String str) {
        return _getBoolean(j, j2, str);
    }

    public long getBuildID() {
        return _getBuildID();
    }

    public long getContextGlobalHandle(long j, long j2) {
        return _getContextGlobalHandle(j, j2);
    }

    public Object getData(String str) {
        Map<String, Object> map = this.g;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public double getDouble(long j, long j2, String str) {
        return _getDouble(j, j2, str);
    }

    public int getInteger(long j, long j2, String str) {
        return _getInteger(j, j2, str);
    }

    public String[] getKeys(long j, long j2) {
        return _getKeys(j, j2);
    }

    public long getObjectReferenceCount() {
        return this.h - ((long) this.f25359a.size());
    }

    public String getString(long j, long j2, String str) {
        return _getString(j, j2, str);
    }

    public int getType(long j, long j2) {
        return _getType(j, j2);
    }

    public long getV8RuntimePtr() {
        return this.i;
    }

    public int identityHash(long j, long j2) {
        return _identityHash(j, j2);
    }

    public long initNewV8Array(long j) {
        return _initNewV8Array(j);
    }

    public long initNewV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i) {
        return _initNewV8ArrayBuffer(j, byteBuffer, i);
    }

    public long initNewV8Context(long j, long j2) {
        return _initNewV8Context(j, j2);
    }

    public long[] initNewV8Function(long j) {
        a();
        return _initNewV8Function(j);
    }

    public long initNewV8Object(long j) {
        return _initNewV8Object(j);
    }

    public boolean isWeak(long j, long j2) {
        return _isWeak(j, j2);
    }

    public void lowMemoryNotification() {
        a();
        lowMemoryNotification(getV8RuntimePtr());
    }

    public boolean pumpMessageLoop(boolean z) {
        return _pumpMessageLoop(this.i, z);
    }

    public long registerJavaMethod(long j, long j2, String str, boolean z) {
        return _registerJavaMethod(j, j2, str, z);
    }

    public void registerResource(Releasable releasable) {
        a();
        if (this.j == null) {
            this.j = new ArrayList();
        }
        this.j.add(releasable);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value, com.alipay.mobile.jsengine.v8.Releasable
    public void release() {
        release(true);
    }

    public void releaseMethodDescriptor(long j, long j2) {
        _releaseMethodDescriptor(j, j2);
    }

    public void removeReferenceHandler(ReferenceHandler referenceHandler) {
        this.l.remove(referenceHandler);
    }

    public void runScript(long j) {
        _runScript(this.i, j);
    }

    public boolean sameValue(long j, long j2, long j3) {
        return _sameValue(j, j2, j3);
    }

    public long serialize(long j) {
        return _serialize(this.i, j);
    }

    public synchronized void setData(String str, Object obj) {
        if (this.g == null) {
            this.g = new HashMap();
        }
        this.g.put(str, obj);
    }

    public void setPrototype(long j, long j2, long j3) {
        _setPrototype(j, j2, j3);
    }

    public void setWeak(long j, long j2) {
        _setWeak(j, j2);
    }

    public boolean strictEquals(long j, long j2, long j3) {
        return _strictEquals(j, j2, j3);
    }

    public void terminateExecution() {
        terminateExecution(this.i);
    }

    public String toString(long j, long j2) {
        return _toString(j, j2);
    }

    public void weakReferenceReleased(long j) {
        V8Value v8Value = this.f25359a.get(Long.valueOf(j));
        if (v8Value != null) {
            this.f25359a.remove(Long.valueOf(j));
            try {
                v8Value.release();
            } catch (Exception unused) {
            }
        }
    }

    public V8(String str, String str2, String[] strArr) {
        this(str, str2, strArr, null);
    }

    public static V8 createV8Runtime(String str) {
        return createV8Runtime(str, null, null, null);
    }

    public void add(long j, long j2, String str, boolean z) {
        _add(j, j2, str, z);
    }

    public int arrayGetBooleans(long j, long j2, int i, int i2, boolean[] zArr) {
        return _arrayGetBooleans(j, j2, i, i2, zArr);
    }

    public int arrayGetBytes(long j, long j2, int i, int i2, byte[] bArr) {
        return _arrayGetBytes(j, j2, i, i2, bArr);
    }

    public int arrayGetDoubles(long j, long j2, int i, int i2, double[] dArr) {
        return _arrayGetDoubles(j, j2, i, i2, dArr);
    }

    public int arrayGetIntegers(long j, long j2, int i, int i2, int[] iArr) {
        return _arrayGetIntegers(j, j2, i, i2, iArr);
    }

    public int arrayGetStrings(long j, long j2, int i, int i2, String[] strArr) {
        return _arrayGetStrings(j, j2, i, i2, strArr);
    }

    public V8Array executeArrayScript(String str, String str2, int i) {
        a();
        Object objExecuteScript = executeScript(str, str2, i);
        if (objExecuteScript instanceof V8Array) {
            return (V8Array) objExecuteScript;
        }
        throw new V8ResultUndefined();
    }

    public boolean executeBooleanScript(String str, String str2, int i) {
        a();
        a(str);
        return executeBooleanScript(this.i, str, str2, i);
    }

    public double executeDoubleScript(String str, String str2, int i) {
        a();
        a(str);
        return executeDoubleScript(this.i, str, str2, i);
    }

    public Object executeFunction(long j, long j2, long j3, long j4) {
        return _executeFunction(j, j2, j3, j4);
    }

    public int executeIntegerScript(String str, String str2, int i) {
        a();
        a(str);
        return executeIntegerScript(this.i, str, str2, i);
    }

    public V8Object executeObjectScript(String str, String str2, int i) {
        a();
        Object objExecuteScript = executeScript(str, str2, i);
        if (objExecuteScript instanceof V8Object) {
            return (V8Object) objExecuteScript;
        }
        throw new V8ResultUndefined();
    }

    public Object executeScript(String str, String str2, int i) {
        a();
        a(str);
        return executeScript(getV8RuntimePtr(), 0, str, str2, i);
    }

    public String executeStringScript(String str, String str2, int i) {
        a();
        a(str);
        return executeStringScript(this.i, str, str2, i);
    }

    public void executeVoidScript(byte[] bArr) {
        executeVoidScript(bArr, (String) null, 0);
    }

    public int getType(long j, long j2, String str) {
        return _getType(j, j2, str);
    }

    public long initNewV8ArrayBuffer(long j, int i) {
        return _initNewV8ArrayBuffer(j, i);
    }

    public void release(boolean z) {
        if (isReleased()) {
            return;
        }
        a();
        c();
        b();
        synchronized (e) {
            f--;
        }
        _releaseRuntime(this.i);
        this.i = 0L;
        this.d = true;
        if (!z || getObjectReferenceCount() <= 0) {
            return;
        }
        throw new IllegalStateException(this.h + " Object(s) still exist in runtime");
    }

    public void terminateExecution(long j) {
        _terminateExecution(j);
    }

    public V8(String str, String str2, String[] strArr, Object obj) {
        super(null);
        this.f25359a = new HashMap();
        this.g = null;
        this.h = 0L;
        this.i = 0L;
        this.j = null;
        this.k = new HashMap();
        this.l = new LinkedList<>();
        this.d = false;
        this.i = _createIsolate(str, str2, strArr, obj);
        a();
        this.c = _getGlobalObject(this.i);
    }

    public static V8 createV8Runtime(String str, String str2, String[] strArr, Object obj) {
        V8 v8 = new V8(str, str2, strArr, obj);
        synchronized (e) {
            f++;
        }
        return v8;
    }

    public void add(long j, long j2, String str, double d) {
        _add(j, j2, str, d);
    }

    public void createTwin(long j, long j2, long j3) {
        _createTwin(j, j2, j3);
    }

    public void executeVoidScript(String str, String str2, int i) {
        a();
        a(str);
        executeVoidScript(this.i, str, str2, i);
    }

    public int getType(long j, long j2, int i) {
        return _getType(j, j2, i);
    }

    public void lowMemoryNotification(long j) {
        _lowMemoryNotification(j);
    }

    public void add(long j, long j2, String str, String str2) {
        if (str2 == null) {
            _addNull(j, j2, str);
        } else {
            _add(j, j2, str, str2);
        }
    }

    public void b(V8Value v8Value) {
        this.h++;
        if (this.l.isEmpty()) {
            return;
        }
        d(v8Value);
    }

    public int getType(long j, long j2, int i, int i2) {
        return _getType(j, j2, i, i2);
    }

    public void a() {
        if (isReleased()) {
            throw new Error("Runtime disposed error");
        }
    }

    public boolean executeBooleanScript(long j, String str, String str2, int i) {
        return _executeBooleanScript(j, str, str2, i);
    }

    public double executeDoubleScript(long j, String str, String str2, int i) {
        return _executeDoubleScript(j, str, str2, i);
    }

    public int executeIntegerScript(long j, String str, String str2, int i) {
        return _executeIntegerScript(j, str, str2, i);
    }

    public Object executeScript(long j, int i, String str, String str2, int i2) {
        return _executeScript(j, i, str, str2, i2);
    }

    public String executeStringScript(long j, String str, String str2, int i) {
        return _executeStringScript(j, str, str2, i);
    }

    public void c(V8Value v8Value) {
        if (!this.l.isEmpty()) {
            e(v8Value);
        }
        this.h--;
    }

    public void executeVoidScript(byte[] bArr, String str, int i) {
        a();
        _executeVoidScript2(this.i, bArr, str, i);
    }

    public static void a(String str) {
        if (str == null) {
            throw new NullPointerException("Script is null");
        }
    }

    public void a(Object obj, Method method, long j, String str, boolean z) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.f25360a = obj;
        methodDescriptor.b = method;
        methodDescriptor.e = z;
        this.k.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j, str, a(method))), methodDescriptor);
    }

    public void executeVoidScript(long j, String str, String str2, int i) {
        _executeVoidScript(j, str, str2, i);
    }

    public void a(JavaVoidCallback javaVoidCallback, long j, String str) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.d = javaVoidCallback;
        this.k.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j, str, true)), methodDescriptor);
    }

    public void release(long j, long j2) {
        _release(j, j2);
    }

    public void a(JavaCallback javaCallback, long j, String str) {
        a(javaCallback, registerJavaMethod(getV8RuntimePtr(), j, str, false));
    }

    public void a(JavaCallback javaCallback, long j) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.c = javaCallback;
        this.k.put(Long.valueOf(j), methodDescriptor);
    }

    private boolean a(Method method) {
        return method.getReturnType().equals(Void.TYPE);
    }

    private Object a(Class<?> cls) {
        if (cls.equals(V8Object.class)) {
            return new V8Object.Undefined();
        }
        if (cls.equals(V8Array.class)) {
            return new V8Array.Undefined();
        }
        return n;
    }

    private Object a(Object obj) {
        if (obj == null) {
            return obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Boolean) || (obj instanceof String)) {
            return obj;
        }
        if (obj instanceof V8Value) {
            if (((V8Value) obj).isReleased()) {
                throw new V8RuntimeException("V8Value already released");
            }
            return obj;
        }
        throw new V8RuntimeException("Unknown return type: " + obj.getClass());
    }

    private void a(Object[] objArr) {
        for (Object obj : objArr) {
            if (obj == n) {
                throw new IllegalArgumentException("argument type mismatch");
            }
        }
    }

    private void a(Object[] objArr, boolean z) {
        if (z && objArr.length > 0 && (objArr[objArr.length - 1] instanceof Object[])) {
            for (Object obj : (Object[]) objArr[objArr.length - 1]) {
                if (obj instanceof V8Value) {
                    ((V8Value) obj).release();
                }
            }
        }
        for (Object obj2 : objArr) {
            if (obj2 instanceof V8Value) {
                ((V8Value) obj2).release();
            }
        }
    }

    private Object[] a(V8Object v8Object, MethodDescriptor methodDescriptor, V8Array v8Array, boolean z) {
        int length = methodDescriptor.b.getParameterTypes().length;
        int i = z ? length - 1 : length;
        Object[] objArrA = a(new Object[length], methodDescriptor.b.getParameterTypes(), v8Object, methodDescriptor.e);
        ArrayList arrayList = new ArrayList();
        a(v8Array, i, objArrA, arrayList, methodDescriptor.e);
        if (z) {
            Object objA = a(methodDescriptor.b.getParameterTypes(), arrayList.size());
            System.arraycopy(arrayList.toArray(), 0, objA, 0, arrayList.size());
            objArrA[i] = objA;
        }
        return objArrA;
    }

    private Object a(Class<?>[] clsArr, int i) {
        Class<?> componentType = clsArr[clsArr.length - 1];
        if (componentType.isArray()) {
            componentType = componentType.getComponentType();
        }
        return Array.newInstance(componentType, i);
    }

    private void a(V8Array v8Array, int i, Object[] objArr, List<Object> list, boolean z) {
        for (int i2 = z ? 1 : 0; i2 < v8Array.length() + (z ? 1 : 0); i2++) {
            if (i2 >= i) {
                list.add(a(v8Array, i2 - (z ? 1 : 0)));
            } else {
                objArr[i2] = a(v8Array, i2 - (z ? 1 : 0));
            }
        }
    }

    private Object[] a(Object[] objArr, Class<?>[] clsArr, V8Object v8Object, boolean z) {
        int i = 0;
        if (z) {
            objArr[0] = v8Object;
            i = 1;
        }
        while (i < objArr.length) {
            objArr[i] = a(clsArr[i]);
            i++;
        }
        return objArr;
    }

    private Object a(V8Array v8Array, int i) {
        try {
            int type = v8Array.getType(i);
            if (type == 10) {
                return v8Array.get(i);
            }
            if (type != 99) {
                switch (type) {
                    case 1:
                        return Integer.valueOf(v8Array.getInteger(i));
                    case 2:
                        return Double.valueOf(v8Array.getDouble(i));
                    case 3:
                        return Boolean.valueOf(v8Array.getBoolean(i));
                    case 4:
                        return v8Array.getString(i);
                    case 5:
                    case 8:
                        return v8Array.getArray(i);
                    case 6:
                        return v8Array.getObject(i);
                    case 7:
                        return v8Array.getObject(i);
                    default:
                        return null;
                }
            }
            return getUndefined();
        } catch (V8ResultUndefined unused) {
            return null;
        }
    }
}
