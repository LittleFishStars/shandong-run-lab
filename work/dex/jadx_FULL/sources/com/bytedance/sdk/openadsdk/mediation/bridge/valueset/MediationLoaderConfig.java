package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.op.tt;
import com.byazt.rl.ve;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, 83, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, AVMDLDataLoader.KeyIsIsTestSpeedVersion, 2106})
public class MediationLoaderConfig {
    private ValueSet c;

    private MediationLoaderConfig(ValueSet valueSet) {
        if (valueSet != null) {
            SparseArray sparseArray = (SparseArray) valueSet.objectValue(8424, SparseArray.class);
            ValueSet valueSetTt = (sparseArray == null || sparseArray.size() <= 0) ? null : ve.c((SparseArray<Object>) sparseArray).tt();
            if (valueSetTt != null) {
                this.c = valueSetTt;
            } else {
                this.c = valueSet;
            }
        }
    }

    private boolean c() {
        ValueSet valueSet = this.c;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public static MediationLoaderConfig create(ValueSet valueSet) {
        return new MediationLoaderConfig(valueSet);
    }

    public String getADNName() {
        return c() ? this.c.stringValue(8003) : "";
    }

    public ValueSet getAdSlotValueSet() {
        if (c()) {
            return ve.c((SparseArray<Object>) this.c.objectValue(8548, SparseArray.class)).tt();
        }
        return null;
    }

    public int getAdType() {
        if (c()) {
            return this.c.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
        }
        return 0;
    }

    public String getClassName() {
        return c() ? this.c.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public Context getContext() {
        if (c()) {
            return (Context) this.c.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class);
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> getGMCustomAdLoader() {
        if (c()) {
            return tt.covertToFunction(this.c.objectValue(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, Object.class));
        }
        return null;
    }

    public int getManagerLoaderType() {
        if (c()) {
            return this.c.intValue(8561);
        }
        return 0;
    }

    public ValueSet getMediationCustomServiceConfigValue() {
        if (c()) {
            return ve.c((SparseArray<Object>) this.c.objectValue(8546, SparseArray.class)).tt();
        }
        return null;
    }
}
