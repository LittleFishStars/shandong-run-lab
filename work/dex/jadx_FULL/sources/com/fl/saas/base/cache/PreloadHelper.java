package com.fl.saas.base.cache;

import android.app.Activity;
import android.content.Context;
import com.fl.saas.api.AdParams;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.base.manager.MixNativeManager;
import com.fl.saas.base.manager.api.ManagerAPI;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.PreAdPlace;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class PreloadHelper {
    private static WeakReference<Context> contextRef = null;
    private static int index = 0;
    private static boolean isRequest = false;
    private static PreloadHelper sInstance;
    private List<PreAdPlace> adPlaces;

    public static PreloadHelper getInstance() {
        if (sInstance == null) {
            synchronized (PreloadHelper.class) {
                sInstance = new PreloadHelper();
                contextRef = new WeakReference<>(DeviceUtil.getContext());
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: next, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$requestAd$1(List<PreAdPlace> list) {
        int i = index + 1;
        index = i;
        if (i < list.size()) {
            requestAd(list);
        }
    }

    private void requestAd(final List<PreAdPlace> list) {
        AdPlace adPlace;
        WeakReference<Context> weakReference;
        BaseBuilder<?> baseBuilderCreateDefaultBuilder;
        PreAdPlace preAdPlace = list.get(index);
        if (preAdPlace != null && (adPlace = preAdPlace.getAdPlace()) != null && (weakReference = contextRef) != null && weakReference.get() != null) {
            Context context = contextRef.get();
            int position = preAdPlace.getPosition();
            if (position == 10) {
                String str = adPlace.place_id;
                String reqID = DeviceUtil.getReqID(str);
                AdPlace adPlaceCloneObject = adPlace.cloneObject(reqID);
                ConfigHelper.getInstance().sdkTrafficReq(reqID, str, adPlace.group_id, adPlace.test_id, adPlace.track_id, true, 0L);
                new MixNativeManager(context, new AdParams.Builder(adPlace.place_id).build(), null).preload(adPlaceCloneObject, new PreloadDoneCallback() { // from class: com.zj.adlib.nx6
                    @Override // com.fl.saas.base.interfaces.PreloadDoneCallback
                    public final void preloadDone() {
                        this.f43627a.lambda$requestAd$0(list);
                    }
                });
            } else {
                AdType adTypeFromPosition = AdType.fromPosition(position);
                if (adTypeFromPosition != null) {
                    String str2 = adPlace.place_id;
                    String reqID2 = DeviceUtil.getReqID(str2);
                    AdPlace adPlaceCloneObject2 = adPlace.cloneObject(reqID2);
                    ConfigHelper.getInstance().sdkTrafficReq(reqID2, str2, adPlace.group_id, adPlace.test_id, adPlace.track_id, true, 0L);
                    ManagerAPI managerAPI = (ManagerAPI) adTypeFromPosition.createManager();
                    if (managerAPI != null && context != null && (baseBuilderCreateDefaultBuilder = adTypeFromPosition.createDefaultBuilder(context)) != null) {
                        managerAPI.preload(baseBuilderCreateDefaultBuilder, adPlaceCloneObject2, new PreloadDoneCallback() { // from class: com.zj.adlib.ox6
                            @Override // com.fl.saas.base.interfaces.PreloadDoneCallback
                            public final void preloadDone() {
                                this.f43851a.lambda$requestAd$1(list);
                            }
                        });
                        return;
                    }
                }
            }
        }
        lambda$requestAd$1(list);
    }

    public void addAdPlace(List<PreAdPlace> list) {
        this.adPlaces = list;
        AdCacheManager.getInstance().addAdPlace(this.adPlaces);
    }

    public Context getContext() {
        WeakReference<Context> weakReference = contextRef;
        if (weakReference != null && weakReference.get() != null) {
            Context context = contextRef.get();
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                return context;
            }
        }
        return DeviceUtil.getContext();
    }

    public synchronized void requestPreloadAd() {
        List<PreAdPlace> list = this.adPlaces;
        if (list != null && !list.isEmpty()) {
            if (isRequest) {
                LogcatUtil.d("YdSDK-Cache", "PreloadAd has been requested");
                return;
            }
            LogcatUtil.d("YdSDK-Cache", "Start PreloadAd");
            isRequest = true;
            index = 0;
            requestAd(this.adPlaces);
            return;
        }
        LogcatUtil.d("YdSDK-Cache", "PreloadAd place is null");
    }

    public void setPreLoadContext(Context context) {
        if (context != null) {
            contextRef = new WeakReference<>(context);
        }
    }
}
