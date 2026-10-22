package com.zj.adlib;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaMetadataRetriever;
import java.io.File;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class dn9 {
    public static void a(Context context, jo9.c cVar, String str, @Nullable Integer num, float f, int i) throws Exception {
        Integer num2;
        List<File> listN;
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file = new File(context.getCacheDir(), "kichiku_" + System.currentTimeMillis());
        file.mkdir();
        if (num == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            cVar.b(mediaMetadataRetriever);
            Integer numValueOf = Integer.valueOf(Integer.parseInt(mediaMetadataRetriever.extractMetadata(20)));
            mediaMetadataRetriever.release();
            num2 = numValueOf;
        } else {
            num2 = num;
        }
        int iD = np9.d(cVar);
        try {
            v61.t("切割视频+", new Object[0]);
            listN = np9.n(context, cVar, file.getAbsolutePath(), i, 500, Integer.valueOf(iD), f, 0);
        } catch (MediaCodec.CodecException e) {
            v61.g(e);
            listN = np9.n(context, cVar, file.getAbsolutePath(), i, 500, Integer.valueOf(iD), f, -1);
        }
        v61.t("切割视频-", new Object[0]);
        v61.t("合并视频+", new Object[0]);
        np9.b(listN, str, num2, 1);
        v61.t("合并视频-", new Object[0]);
        v61.f("鬼畜已完成,耗时:" + ((System.currentTimeMillis() - jCurrentTimeMillis) / 1000.0f) + "s", new Object[0]);
    }
}
