package com.byazt.bdw;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.byazt.uq.i;
import com.byazt.uq.sl;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_UMID_NO_NETWORK_INIT, 20})
public class c {
    public static Map<String, Integer> c = new HashMap();
    public LinkedHashMap<String, Integer> tt;

    static {
        List<String> listC = sl.c();
        if (listC == null || listC.size() <= 0) {
            return;
        }
        Iterator<String> it = listC.iterator();
        while (it.hasNext()) {
            c.put(it.next(), 0);
        }
    }

    public c() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        this.tt = linkedHashMap;
        linkedHashMap.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    private AssetManager tt(AssetManager assetManager, String str, boolean z) {
        String str2 = "addAssetPath";
        String str3 = z ? "addAssetPathAsSharedLibrary" : "addAssetPath";
        if (i.nu() && !z && str.startsWith("/product/overlay/")) {
            str3 = "addOverlayPath";
        }
        Method accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, str3, String.class);
        if (accessibleMethod == null && z) {
            accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, "addAssetPath", String.class);
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
        } else {
            str2 = str3;
        }
        if (accessibleMethod != null) {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i < 0) {
                    break;
                }
                try {
                    int iIntValue = ((Integer) accessibleMethod.invoke(assetManager, str)).intValue();
                    if (iIntValue != 0) {
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + iIntValue + ", path = " + str);
                        break;
                    }
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = " + iIntValue + " " + str);
                } catch (Exception e) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + z + ", methodName = " + str2, e);
                }
                i = i2;
            }
        } else {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = " + z + " methodName:" + str2);
        }
        return assetManager;
    }

    private AssetManager ve(AssetManager assetManager, String str, boolean z) {
        int i = 3;
        Throwable th = null;
        int i2 = 3;
        loop0: while (true) {
            int i3 = i2 - 1;
            if (i2 >= 0) {
                try {
                    synchronized (assetManager) {
                        int iIntValue = 0;
                        for (int i4 = 0; i4 < i; i4++) {
                            try {
                                if (i.uj()) {
                                    iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str}, new Class[]{String.class})).intValue();
                                } else if (i.sl()) {
                                    iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str, Boolean.valueOf(z)}, new Class[]{String.class, Boolean.TYPE})).intValue();
                                }
                                if (iIntValue != 0) {
                                    break loop0;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        if (iIntValue == 0) {
                            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.appendAssetPathSafely() failed, cookie = " + iIntValue + " " + str);
                        } else {
                            Object field = FieldUtils.readField(assetManager, "mStringBlocks");
                            int length = field != null ? Array.getLength(field) : 0;
                            int iIntValue2 = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                            Object objNewInstance = Array.newInstance(field.getClass().getComponentType(), iIntValue2);
                            for (int i5 = 0; i5 < iIntValue2; i5++) {
                                if (i5 < length) {
                                    Array.set(objNewInstance, i5, Array.get(field, i5));
                                } else {
                                    Array.set(objNewInstance, i5, MethodUtils.invokeConstructor(field.getClass().getComponentType(), new Object[]{Long.valueOf(((Long) MethodUtils.invokeMethod(assetManager, "getNativeStringBlock", new Object[]{Integer.valueOf(i5)}, new Class[]{Integer.TYPE})).longValue()), Boolean.TRUE}, new Class[]{Long.TYPE, Boolean.TYPE}));
                                }
                            }
                            FieldUtils.writeField(assetManager, "mStringBlocks", objNewInstance);
                            ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = ".concat(String.valueOf(str)));
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    i2 = i3;
                    i = 3;
                }
            }
            if (th != null) {
                if (!i.gt()) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
                }
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
            }
            return assetManager;
        }
    }

    public AssetManager c(AssetManager assetManager, String str, boolean z) {
        AssetManager assetManagerC;
        if (str.endsWith(".frro")) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager skip frro. ".concat(str));
            return assetManager;
        }
        if (!i.c()) {
            assetManagerC = c(assetManager, str);
        } else if (i.a()) {
            assetManagerC = ve(assetManager, str, z);
            if (!sl.c(assetManagerC, str)) {
                assetManagerC = tt(assetManager, str, z);
            }
        } else {
            assetManagerC = tt(assetManager, str, z);
        }
        synchronized (this.tt) {
            this.tt.put(str, 0);
        }
        return assetManagerC;
    }

    private AssetManager c(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        List<String> listC = sl.c(assetManager);
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (String str2 : listC) {
            if (!c.containsKey(str2) && !this.tt.containsKey(str2) && !str2.equals(str)) {
                arrayList.add(str2);
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager, runtimeAdditionalAssets path = ".concat(String.valueOf(str)));
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager = ".concat(String.valueOf(assetManager2)));
            synchronized (this.tt) {
                for (Map.Entry<String, Integer> entry : this.tt.entrySet()) {
                    if (!c.containsKey(entry.getKey())) {
                        sb.append(entry.getKey());
                        tt(assetManager2, entry.getKey(), false);
                    }
                }
            }
            if (!sb.toString().contains(Zeus.getAppApplication().getApplicationInfo().sourceDir)) {
                tt(assetManager2, Zeus.getAppApplication().getApplicationInfo().sourceDir, false);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager lost host path : " + c.containsKey(Zeus.getAppApplication().getApplicationInfo().sourceDir));
            }
            sb.append(str);
            tt(assetManager2, str, false);
            if (!arrayList.isEmpty()) {
                for (String str3 : arrayList) {
                    sb.append(str3);
                    tt(assetManager2, str3, false);
                }
            }
            if (i.n() && !sb.toString().toLowerCase().contains("webview")) {
                try {
                    Resources resources = Zeus.getAppApplication().getResources();
                    String str4 = Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", TypedValues.Custom.S_STRING, "android")), 0).getApplicationInfo().sourceDir;
                    if (!TextUtils.isEmpty(str4)) {
                        tt(assetManager2, str4, false);
                    }
                } catch (Exception e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager appendAsset webview failed.", e);
                }
            }
            assetManager = assetManager2;
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager failed.", e2);
            tt(assetManager, str, false);
        }
        try {
            MethodUtils.invokeMethod(assetManager, "ensureStringBlocks", new Object[0]);
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks");
        } catch (Exception e3) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks failed.", e3);
        }
        return assetManager;
    }
}
