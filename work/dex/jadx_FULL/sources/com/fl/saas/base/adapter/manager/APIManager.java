package com.fl.saas.base.adapter.manager;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.type.AdvertiserID;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ReflectUtils;
import com.fl.saas.common.util.SPILoader;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class APIManager<T> {
    private static final List<Integer> ADVS = ReflectUtils.getStaticFinalValues(AdvertiserID.class, Integer.TYPE);
    private String TAG = CommConstant.getObjTag(this);
    private final Map<Integer, Constructor<T>> adapters = new HashMap();

    public APIManager(Class<T> cls) {
        registerAdapter(cls);
    }

    private Constructor<T> register(int i, Class<T> cls) throws NoSuchMethodException {
        Constructor<T> constructor = cls.getConstructor(new Class[0]);
        this.adapters.put(Integer.valueOf(i), constructor);
        return constructor;
    }

    private void register(Class<T> cls) {
        int iCustom;
        try {
            Advertiser advertiser = (Advertiser) cls.getAnnotation(Advertiser.class);
            if (advertiser == null) {
                return;
            }
            int iValue = advertiser.value();
            for (Class<?> cls2 : advertiser.keyClass()) {
                if (cls2 != Object.class) {
                    LogcatUtil.d(cls2.toString());
                }
            }
            if (iValue == -1 && (iCustom = advertiser.custom()) != -1) {
                iValue = iCustom;
            }
            register(iValue, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerAdapter(Class<T> cls) {
        Iterator<String> it = SPILoader.loadSPINames(cls.getClassLoader(), registerClass()).iterator();
        while (it.hasNext()) {
            try {
                Class<?> cls2 = Class.forName(it.next());
                if (cls.isAssignableFrom(cls2)) {
                    register(cls2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Constructor<T> registerCustom(int i, String str) {
        try {
            return register(i, Class.forName(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public T loadAdapter(int i, @Nullable String str) {
        Constructor<T> constructorRegisterCustom = this.adapters.get(Integer.valueOf(i));
        if (constructorRegisterCustom == null && !TextUtils.isEmpty(str)) {
            constructorRegisterCustom = registerCustom(i, str);
        }
        if (constructorRegisterCustom == null && TextUtils.isEmpty(str) && !ADVS.contains(Integer.valueOf(i))) {
            constructorRegisterCustom = this.adapters.get(5);
        }
        if (constructorRegisterCustom != null) {
            try {
                return constructorRegisterCustom.newInstance(new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LogcatUtil.e(this.TAG, String.format(Locale.getDefault(), "loadAdapter is empty, advId: %d,customName: %s", Integer.valueOf(i), str));
        return null;
    }

    public abstract Class<?> registerClass();
}
