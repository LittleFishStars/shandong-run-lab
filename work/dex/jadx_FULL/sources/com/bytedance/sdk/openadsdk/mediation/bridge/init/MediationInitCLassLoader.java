package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import android.util.SparseArray;
import com.byazt.bog.a;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, 83, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 84, 1018})
public class MediationInitCLassLoader extends com.byazt.op.c {
    /* JADX WARN: Code duplicated, block: B:40:0x0087  */
    private <T> boolean c(ValueSet valueSet) {
        boolean z;
        Class<?> cls;
        boolean z2;
        MediationInitConfig mediationInitConfigCreate = MediationInitConfig.create(valueSet);
        try {
            try {
                z = true;
                if (!mediationInitConfigCreate.isCustom() || mediationInitConfigCreate.getCustomInitConfigValueSet() == null) {
                    String adapterManagerClassName = mediationInitConfigCreate.getAdapterManagerClassName();
                    String aDNName = mediationInitConfigCreate.getADNName();
                    Function<SparseArray<Object>, Object> adapterManager = (adapterManagerClassName == null || aDNName == null) ? false : AdnManagerConfig.initAdnManager(adapterManagerClassName, aDNName) ? AdnManagerConfig.getAdapterManager(aDNName) : null;
                    if (adapterManager != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 10000);
                        sparseArray.put(-99999985, Object.class);
                        c(adapterManager.apply(sparseArray), valueSet);
                        return true;
                    }
                    cls = Class.forName(mediationInitConfigCreate.getClassName());
                    z2 = false;
                } else {
                    try {
                        cls = Class.forName(mediationInitConfigCreate.getCustomInitConfigValueSet().stringValue(8536));
                        z2 = true;
                    } catch (ClassNotFoundException e) {
                        e = e;
                        a.c(e);
                        if (!z) {
                            a.n(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                        }
                        return false;
                    } catch (NoClassDefFoundError e2) {
                        e = e2;
                        a.c(e);
                        if (!z) {
                            a.n(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                        }
                        return false;
                    }
                }
                try {
                    c(cls.newInstance(), valueSet);
                    return true;
                } catch (ClassNotFoundException | NoClassDefFoundError e3) {
                    e = e3;
                    z = z2;
                    a.c(e);
                    if (!z) {
                        a.n(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                    }
                    return false;
                }
            } catch (Throwable th) {
                a.c(th);
                return false;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError e4) {
            e = e4;
            z = false;
        }
    }

    @Override // com.byazt.op.c
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8100) {
            return (T) Boolean.valueOf(c(valueSet));
        }
        return null;
    }

    @Override // com.byazt.op.c
    public SparseArray<Object> get() {
        return null;
    }

    private void c(Object obj, ValueSet valueSet) {
        if (obj instanceof Function) {
            Function function = (Function) obj;
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, TTAppContextHolder.getContext());
            sparseArray.put(8424, valueSet == null ? null : valueSet.sparseArray());
            sparseArray.put(-99999987, 8240);
            sparseArray.put(-99999985, Void.class);
            function.apply(sparseArray);
        }
    }
}
