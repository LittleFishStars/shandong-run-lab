package com.fl.saas.base.bidding;

import androidx.annotation.NonNull;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.annotation.BiddingHandler;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.util.SPILoader;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class BiddingManager {
    private static final Map<Integer, Constructor<? extends Bidding>> biddingMap = new HashMap();
    private static final Map<Integer, Constructor<? extends Bidding>> handleMap = new HashMap();
    private static final Map<Integer, Map<AdType, Constructor<? extends Bidding>>> adapterBidding = new HashMap();

    public static final class Holder {
        private static final BiddingManager INSTANCE = new BiddingManager();

        private Holder() {
        }
    }

    private BiddingManager() {
        registerBiddingHandle();
    }

    private int getAdvId(@NonNull Advertiser advertiser) {
        int iValue = advertiser.value();
        return iValue == -1 ? advertiser.custom() : iValue;
    }

    public static BiddingManager getInstance() {
        return Holder.INSTANCE;
    }

    private void registerAdapterTypeBidding(Class<? extends Bidding> cls) throws NoSuchMethodException {
        Advertiser advertiser = (Advertiser) cls.getAnnotation(Advertiser.class);
        if (advertiser == null) {
            return;
        }
        int advId = getAdvId(advertiser);
        Constructor<? extends Bidding> constructor = cls.getConstructor(new Class[0]);
        Map<Integer, Map<AdType, Constructor<? extends Bidding>>> map = adapterBidding;
        Map<AdType, Constructor<? extends Bidding>> map2 = map.get(Integer.valueOf(advId));
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(Integer.valueOf(advId), map2);
        }
        map2.put(AdType.getType(cls), constructor);
    }

    private void registerBidding(Class<? extends Bidding> cls) throws NoSuchMethodException {
        int advId;
        BiddingHandler biddingHandler = (BiddingHandler) cls.getAnnotation(BiddingHandler.class);
        if (biddingHandler == null) {
            return;
        }
        int iValue = biddingHandler.value();
        Constructor<? extends Bidding> constructor = cls.getConstructor(new Class[0]);
        biddingMap.put(Integer.valueOf(iValue), constructor);
        Class<? extends AdapterAPI>[] clsArrExtend = biddingHandler.extend();
        if (clsArrExtend == null || clsArrExtend.length == 0) {
            return;
        }
        for (Class<? extends AdapterAPI> cls2 : clsArrExtend) {
            Advertiser advertiser = (Advertiser) cls2.getAnnotation(Advertiser.class);
            if (advertiser != null && (advId = getAdvId(advertiser)) > 0) {
                biddingMap.put(Integer.valueOf(advId), constructor);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void registerBiddingHandle() {
        try {
            Iterator<String> it = SPILoader.loadSPINames(getClass().getClassLoader(), Bidding.class).iterator();
            while (it.hasNext()) {
                Class<?> cls = Class.forName(it.next());
                if (Bidding.class.isAssignableFrom(cls)) {
                    if (AdapterAPI.class.isAssignableFrom(cls)) {
                        registerAdapterTypeBidding(cls);
                    } else if (MixNativeHandler.class.isAssignableFrom(cls)) {
                        registerMixNativeTypeBidding(cls);
                    } else {
                        registerBidding(cls);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerMixNativeTypeBidding(Class<? extends Bidding> cls) throws NoSuchMethodException {
        Advertiser advertiser = (Advertiser) cls.getAnnotation(Advertiser.class);
        if (advertiser == null) {
            return;
        }
        int advId = getAdvId(advertiser);
        handleMap.put(Integer.valueOf(advId), cls.getConstructor(new Class[0]));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0031  */
    /* JADX WARN: Code duplicated, block: B:8:0x0025  */
    public Bidding loadBiddingHandle(AdType adType, int i) {
        Map<Integer, Map<AdType, Constructor<? extends Bidding>>> map;
        Constructor<? extends Bidding> constructor;
        Constructor<? extends Bidding> constructor2 = biddingMap.get(Integer.valueOf(i));
        if (constructor2 == null) {
            if (adType == null) {
                Map<Integer, Constructor<? extends Bidding>> map2 = handleMap;
                if (map2.containsKey(Integer.valueOf(i))) {
                    constructor = map2.get(Integer.valueOf(i));
                } else {
                    map = adapterBidding;
                    if (map.containsKey(Integer.valueOf(i))) {
                        constructor = map.get(Integer.valueOf(i)).get(adType);
                    }
                }
                constructor2 = constructor;
            } else {
                map = adapterBidding;
                if (map.containsKey(Integer.valueOf(i))) {
                    constructor = map.get(Integer.valueOf(i)).get(adType);
                    constructor2 = constructor;
                }
            }
        }
        if (constructor2 != null) {
            try {
                return constructor2.newInstance(new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
