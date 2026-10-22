package com.kc.aw;

import android.content.Context;
import android.os.Build;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _bg {
    public static Object _a;
    public static Object _b;

    public static Object _a(Class cls, String str) throws Exception {
        Method declaredMethod;
        while (true) {
            if (cls == null) {
                declaredMethod = null;
                break;
            }
            try {
                try {
                    declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
                    break;
                } catch (NoSuchMethodException unused) {
                    cls = cls.getSuperclass();
                }
            } catch (Exception e) {
                throw e;
            }
        }
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, new Object[0]);
        }
        throw new NoSuchMethodException("Function not found: " + str);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0060 A[Catch: Exception -> 0x007c, TryCatch #2 {Exception -> 0x007c, blocks: (B:27:0x004d, B:29:0x0053, B:34:0x0060, B:35:0x0067, B:36:0x007b, B:31:0x0058), top: B:53:0x004d, outer: #3, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0067 A[Catch: Exception -> 0x007c, TryCatch #2 {Exception -> 0x007c, blocks: (B:27:0x004d, B:29:0x0053, B:34:0x0060, B:35:0x0067, B:36:0x007b, B:31:0x0058), top: B:53:0x004d, outer: #3, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x005d A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:35:0x0067, please report this as an issue */
    public static Object _a(Object obj, int i) {
        Field declaredField;
        Class<?> cls;
        Field declaredField2;
        Object obj_a;
        String str;
        try {
            try {
                Class<?> cls2 = Class.forName("android.util.Singleton");
                while (true) {
                    if (cls2 == null) {
                        declaredField = null;
                        break;
                    }
                    try {
                        declaredField = cls2.getDeclaredField("mInstance");
                        break;
                    } catch (NoSuchFieldException unused) {
                        cls2 = cls2.getSuperclass();
                    }
                }
                if (declaredField == null) {
                    throw new NoSuchFieldException("Member not found: mInstance");
                }
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 == null) {
                    try {
                        if (i >= 29) {
                            str = "android.app.ActivityTaskManager";
                        } else {
                            if (i >= 26) {
                                str = "android.app.ActivityManager";
                            } else {
                                obj_a = _a(Class.forName("android.app.ActivityManagerNative"), "getDefault");
                            }
                            obj2 = obj_a;
                            if (obj2 != null) {
                                try {
                                    cls = Class.forName("android.util.Singleton");
                                    while (true) {
                                        if (cls != null) {
                                            declaredField2 = null;
                                            break;
                                        }
                                        try {
                                            declaredField2 = cls.getDeclaredField("mInstance");
                                            break;
                                        } catch (NoSuchFieldException unused2) {
                                            cls = cls.getSuperclass();
                                        }
                                    }
                                    if (declaredField2 != null) {
                                        throw new NoSuchFieldException("Member not found: mInstance");
                                    }
                                    declaredField2.setAccessible(true);
                                    declaredField2.set(obj, obj2);
                                } catch (Exception e) {
                                    try {
                                        throw e;
                                    } catch (Exception e2) {
                                        throw e2;
                                    }
                                }
                            }
                        }
                        obj_a = _a(Class.forName(str), "getService");
                        obj2 = obj_a;
                    } catch (Exception unused3) {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        cls = Class.forName("android.util.Singleton");
                        while (true) {
                            if (cls != null) {
                                declaredField2 = null;
                                break;
                            }
                            declaredField2 = cls.getDeclaredField("mInstance");
                            break;
                            break;
                        }
                        if (declaredField2 != null) {
                            throw new NoSuchFieldException("Member not found: mInstance");
                        }
                        declaredField2.setAccessible(true);
                        declaredField2.set(obj, obj2);
                    }
                }
                return obj2;
            } catch (Exception unused4) {
                return null;
            }
        } catch (Exception e3) {
            try {
                throw e3;
            } catch (Exception e4) {
                throw e4;
            }
        }
    }

    public static void _a(Context context) {
        String str;
        String str2;
        Object obj;
        Object obj_a;
        Class<?> cls;
        Field declaredField;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                str = "android.app.ActivityTaskManager";
                str2 = "IActivityTaskManagerSingleton";
            } else {
                str = "android.app.ActivityManager";
                str2 = "IActivityManagerSingleton";
            }
            Field declaredField2 = null;
            try {
                Class<?> cls2 = Class.forName(str);
                while (true) {
                    if (cls2 == null) {
                        declaredField = null;
                        break;
                    } else {
                        try {
                            declaredField = cls2.getDeclaredField(str2);
                            break;
                        } catch (NoSuchFieldException unused) {
                            cls2 = cls2.getSuperclass();
                        }
                    }
                }
                if (declaredField == null) {
                    throw new NoSuchFieldException("Member not found: " + str2);
                }
                declaredField.setAccessible(true);
                obj = declaredField.get(null);
                _b = obj;
                if (obj != null && (obj_a = _a(obj, i)) != null) {
                    _a = obj_a;
                    try {
                        cls = Class.forName(i >= 29 ? "android.app.IActivityTaskManager" : "android.app.IActivityManager");
                    } catch (Exception unused2) {
                        cls = null;
                    }
                    if (cls == null) {
                        return;
                    }
                    Object objNewProxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new _be(context, obj_a));
                    Object obj2 = _b;
                    try {
                        for (Class<?> cls3 = Class.forName("android.util.Singleton"); cls3 != null; cls3 = cls3.getSuperclass()) {
                            try {
                                declaredField2 = cls3.getDeclaredField("mInstance");
                                break;
                            } catch (NoSuchFieldException unused3) {
                            }
                        }
                        if (declaredField2 == null) {
                            throw new NoSuchFieldException("Member not found: mInstance");
                        }
                        declaredField2.setAccessible(true);
                        declaredField2.set(obj2, objNewProxyInstance);
                    } catch (Exception e) {
                        try {
                            throw e;
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                }
            } catch (Exception e3) {
                try {
                    throw e3;
                } catch (Exception unused4) {
                    obj = null;
                }
            }
        } catch (Exception unused5) {
        }
    }
}
