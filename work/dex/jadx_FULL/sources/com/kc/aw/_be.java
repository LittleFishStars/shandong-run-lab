package com.kc.aw;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.byazt.tk.AdBaseConstants;
import com.ipd.dsp.internal.n.a;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.utils.TextUtil;
import com.kuaishou.weapon.p0.t;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.yg3;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _be implements InvocationHandler {
    public final Context _a;
    public final Object _b;
    public final AtomicLong _c = new AtomicLong(0);

    public _be(Context context, Object obj) {
        this._a = context;
        this._b = obj;
    }

    public static _l6 _a(Context context, Uri uri) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            try {
                try {
                    String str = com.kc.aw.lib.utils._a._a(Base64.decode("+CkjPCHq8VuHjQKfnZ8ZvA==".getBytes("UTF-8"), 2), _nj._a()) + parcelFileDescriptorOpenFileDescriptor.getFd();
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0);
                    if (packageArchiveInfo == null) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Exception unused2) {
                        }
                        return null;
                    }
                    _l6 _l6Var = new _l6();
                    String str2 = packageArchiveInfo.packageName;
                    _l6Var._a = str2;
                    _l6Var._b = packageArchiveInfo.versionName;
                    try {
                        packageManager.getPackageInfo(str2, 0);
                        _l6Var._c = 2;
                    } catch (Exception unused3) {
                        _l6Var._c = 1;
                    }
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Exception unused4) {
                    }
                    return _l6Var;
                } catch (Exception unused5) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Exception unused6) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (Exception unused7) {
                    }
                }
                throw th;
            }
        } catch (Exception unused8) {
            parcelFileDescriptorOpenFileDescriptor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b7  */
    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Intent intent;
        Uri data;
        boolean z;
        boolean z2;
        boolean z3;
        ResolveInfo resolveInfoResolveActivity;
        ActivityInfo activityInfo;
        boolean z4;
        boolean z5;
        ComponentName component;
        String shortClassName;
        if (PerfId.startActivity.equals(method.getName())) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String string = null;
            boolean z6 = false;
            if (objArr != null) {
                int length = objArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        intent = null;
                        break;
                    }
                    Object obj2 = objArr[i];
                    if (obj2 instanceof Intent) {
                        intent = (Intent) obj2;
                        break;
                    }
                    i++;
                }
            } else {
                intent = null;
                break;
            }
            if ((intent == null || (component = intent.getComponent()) == null || (shortClassName = component.getShortClassName()) == null || !shortClassName.endsWith("PtgLaunchActivity")) ? false : true) {
                this._c.set(jCurrentTimeMillis);
            } else if (jCurrentTimeMillis - this._c.get() >= 500 && intent != null) {
                if (PtgAdSdk.getConfig()._A == 1) {
                    boolean zEquals = "android.intent.action.VIEW".equals(intent.getAction());
                    boolean zEquals2 = "android.intent.action.INSTALL_PACKAGE".equals(intent.getAction());
                    if (zEquals || zEquals2) {
                        boolean zEquals3 = AdBaseConstants.MIME_APK.equals(intent.getType());
                        Uri data2 = intent.getData();
                        if (data2 != null) {
                            String lowerCase = data2.toString().toLowerCase();
                            if (lowerCase.endsWith(".apk") || lowerCase.contains(".apk?")) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                        } else {
                            z4 = false;
                        }
                        if (zEquals3 || z4) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    } else {
                        z5 = false;
                    }
                    if (z5) {
                        com.kc.aw.lib.utils._d._b(new _bd(this, intent));
                    }
                }
                if (PtgAdSdk.getConfig()._B == 1) {
                    if ("android.intent.action.VIEW".equals(intent.getAction()) && (data = intent.getData()) != null) {
                        String scheme = data.getScheme();
                        if (!TextUtil.isEmpty(scheme)) {
                            if (!TextUtil.isEmpty(scheme)) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= 19) {
                                        z = false;
                                        break;
                                    }
                                    if (new String[]{"tel", "mailto", "sms", "geo", yg3.SOURCE_TYPE_SETTINGS, "data", "javascript", "blob", "about", "ftp", "ldap", "news", "gopher", "http", "https", "file", "content", a.c, "android_resource"}[i2].equalsIgnoreCase(scheme)) {
                                        z = true;
                                        break;
                                    }
                                    i2++;
                                }
                            } else {
                                z = false;
                                break;
                            }
                            if (!z) {
                                try {
                                    ComponentName component2 = intent.getComponent();
                                    String packageName = this._a.getPackageName();
                                    z2 = (component2 != null && packageName.equals(component2.getPackageName())) || !((resolveInfoResolveActivity = this._a.getPackageManager().resolveActivity(intent, 65536)) == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null || !packageName.equals(activityInfo.packageName));
                                } catch (Exception unused) {
                                }
                                if (!z2) {
                                    if (!TextUtil.isEmpty(scheme)) {
                                        List<String> list = PtgAdSdk.getConfig()._H;
                                        if (!TextUtil.isEmpty(list)) {
                                            Iterator<String> it = list.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    z3 = true;
                                                    break;
                                                }
                                                String next = it.next();
                                                if (next != null && scheme.startsWith(next)) {
                                                    z3 = false;
                                                    break;
                                                }
                                            }
                                        } else {
                                            z3 = false;
                                            break;
                                        }
                                    } else {
                                        z3 = false;
                                        break;
                                    }
                                    if (!z3) {
                                        if (!intent.hasCategory("android.intent.category.BROWSABLE")) {
                                            intent.hasCategory("android.intent.category.DEFAULT");
                                        }
                                        z6 = true;
                                    }
                                }
                            }
                        }
                    }
                    if (z6) {
                        Uri data3 = intent.getData();
                        if (data3 != null) {
                            try {
                                string = data3.toString();
                            } catch (Exception unused2) {
                            }
                        }
                        if (string != null) {
                            try {
                                _nr _nrVar = new _nr(_m4._a);
                                _nrVar._c = "idp";
                                _nq _nqVar_c = _nrVar._c();
                                try {
                                    synchronized (_nqVar_c._a) {
                                        _nqVar_c._a.put(t.q, string);
                                    }
                                } catch (Exception unused3) {
                                }
                                _nqVar_c._i(PtgAdSdk.getConfig()._a);
                                String str_a = _l0._a(PtgAdSdk.config._G, _nrVar);
                                if (TextUtil.isNotEmpty(str_a)) {
                                    _h1._a(str_a);
                                }
                            } catch (Exception unused4) {
                            }
                        }
                    }
                }
            }
        }
        return method.invoke(this._b, objArr);
    }
}
