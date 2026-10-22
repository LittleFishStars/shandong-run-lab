package com.byazt.nc;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 91})
public abstract class sp implements Function<SparseArray<Object>, Object> {
    public abstract boolean isShow();

    public abstract void resetDislikeStatus();

    public abstract void setDislikeInteractionCallback(com.byazt.dhf.c cVar);

    public abstract void setDislikeSource(String str);

    public abstract void showDislikeDialog();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        pluginValueSetTt.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return new SparseArray();
        }
        switch (iIntValue) {
            case 240101:
                showDislikeDialog();
                return null;
            case 240102:
                setDislikeInteractionCallback(new com.byazt.dhf.c((Function) pluginValueSetTt.objectValue(0, Function.class)));
                return null;
            case 240103:
                setDislikeSource((String) pluginValueSetTt.objectValue(0, String.class));
                return null;
            case 240104:
                resetDislikeStatus();
                return null;
            case 240105:
                return Boolean.class.cast(Boolean.valueOf(isShow()));
            default:
                return null;
        }
    }
}
