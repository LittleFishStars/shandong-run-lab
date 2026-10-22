package com.alibaba.wireless.security.open;

import android.content.Context;
import com.alibaba.wireless.security.open.dynamicdataencrypt.DynamicDataEncryptComp;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.dynamicdatastore.DynamicDataStoreComp;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.middletier.IUnifiedSecurityComponent;
import com.alibaba.wireless.security.open.middletier.UnifiedSecurityComp;
import com.alibaba.wireless.security.open.middletier.fc.FCComponent;
import com.alibaba.wireless.security.open.middletier.fc.IFCComponent;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import com.alibaba.wireless.security.open.securitybody.SecurityBodyComp;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.StaticDataEncryptComp;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alibaba.wireless.security.open.staticdatastore.StaticDataStoreComp;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SecurityGuardManager {
    private static SecurityGuardManager sInstance;
    private static final Map<Class<?>, Object> componentCacheMap = new ConcurrentHashMap();
    private static boolean sInited = false;
    private static final Object lock = new Object();
    private static final Object interfaceLock = new Object();
    private static com.hzchengdun.securityguard.open.SecurityGuardManager guardManager = null;
    private static String mAuthCode = "";

    private SecurityGuardManager() {
    }

    public static SecurityGuardManager getInitializer(String str) throws SecException {
        if (!sInited) {
            synchronized (lock) {
                if (!sInited) {
                    if (sInstance == null) {
                        sInstance = new SecurityGuardManager();
                    }
                    mAuthCode = str;
                    sInited = true;
                }
            }
        }
        return sInstance;
    }

    public static SecurityGuardManager getInstance(Context context, String str, File file) throws SecException {
        if (!sInited) {
            synchronized (lock) {
                if (!sInited) {
                    if (sInstance == null) {
                        sInstance = new SecurityGuardManager();
                    }
                    try {
                        com.hzchengdun.securityguard.open.SecurityGuardManager securityGuardManager = com.hzchengdun.securityguard.open.SecurityGuardManager.getInstance(context, str, file);
                        guardManager = securityGuardManager;
                        if (securityGuardManager != null) {
                            sInited = true;
                        }
                    } catch (com.hzchengdun.securityguard.open.SecException e) {
                        throw new SecException(e.getErrorCode());
                    }
                }
            }
        }
        return sInstance;
    }

    public IDynamicDataEncryptComponent getDynamicDataEncryptComp() throws SecException {
        try {
            return (IDynamicDataEncryptComponent) getInterface(IDynamicDataEncryptComponent.class);
        } catch (SecException e) {
            throw new SecException(e.getErrorCode());
        }
    }

    public IDynamicDataStoreComponent getDynamicDataStoreComp() throws SecException {
        try {
            return (IDynamicDataStoreComponent) getInterface(IDynamicDataStoreComponent.class);
        } catch (SecException e) {
            throw new SecException(e.getErrorCode());
        }
    }

    public <T> T getInterface(Class<T> cls) throws SecException {
        Map<Class<?>, Object> map = componentCacheMap;
        Object securityBodyComp = map.get(cls);
        if (securityBodyComp == null) {
            synchronized (interfaceLock) {
                try {
                    if (securityBodyComp == null) {
                        if (cls == IUnifiedSecurityComponent.class) {
                            securityBodyComp = new UnifiedSecurityComp(guardManager);
                            map.put(cls, securityBodyComp);
                        } else if (cls == IStaticDataStoreComponent.class) {
                            securityBodyComp = new StaticDataStoreComp(guardManager);
                            map.put(cls, securityBodyComp);
                        } else if (cls == IStaticDataEncryptComponent.class) {
                            securityBodyComp = new StaticDataEncryptComp(guardManager);
                            map.put(cls, securityBodyComp);
                        } else if (cls == IDynamicDataEncryptComponent.class) {
                            securityBodyComp = new DynamicDataEncryptComp(guardManager);
                            map.put(cls, securityBodyComp);
                        } else if (cls == IDynamicDataStoreComponent.class) {
                            securityBodyComp = new DynamicDataStoreComp(guardManager);
                            map.put(cls, securityBodyComp);
                        } else if (cls == IFCComponent.class) {
                            securityBodyComp = new FCComponent();
                            map.put(cls, securityBodyComp);
                        } else {
                            if (cls != ISecurityBodyComponent.class) {
                                throw new SecException(141);
                            }
                            securityBodyComp = new SecurityBodyComp();
                            map.put(cls, securityBodyComp);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return cls.cast(securityBodyComp);
    }

    public IStaticDataEncryptComponent getStaticDataEncryptComp() throws SecException {
        try {
            return (IStaticDataEncryptComponent) getInterface(IStaticDataEncryptComponent.class);
        } catch (SecException e) {
            throw new SecException(e.getErrorCode());
        }
    }

    public IStaticDataStoreComponent getStaticDataStoreComp() throws SecException {
        try {
            return (IStaticDataStoreComponent) getInterface(IStaticDataStoreComponent.class);
        } catch (SecException e) {
            throw new SecException(e.getErrorCode());
        }
    }

    public int initialize(Context context) throws SecException {
        try {
            com.hzchengdun.securityguard.open.SecurityGuardManager securityGuardManager = com.hzchengdun.securityguard.open.SecurityGuardManager.getInstance(context, mAuthCode);
            guardManager = securityGuardManager;
            if (securityGuardManager != null) {
                sInited = true;
            }
            return sInited ? 1 : 0;
        } catch (com.hzchengdun.securityguard.open.SecException e) {
            throw new SecException(e.getErrorCode());
        }
    }

    public static SecurityGuardManager getInstance(Context context, String str) throws SecException {
        return getInstance(context, str, null);
    }

    public static SecurityGuardManager getInstance(Context context) throws SecException {
        return getInstance(context, null);
    }
}
