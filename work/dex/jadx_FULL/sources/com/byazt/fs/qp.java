package com.byazt.fs;

import android.graphics.Path;
import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_THREAD_PRIORITY})
public class qp {
    public static com.byazt.jx.z c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        com.byazt.kd.uj ujVar = null;
        String strNextString = null;
        com.byazt.kd.c cVarSp = null;
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        int iNextInt = 1;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "fillEnabled":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "c":
                    cVarSp = uj.sp(jsonReader, aVar);
                    break;
                case "o":
                    ujVar = uj.tt(jsonReader, aVar);
                    break;
                case "r":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "hd":
                    zNextBoolean2 = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (ujVar == null) {
            ujVar = new com.byazt.kd.uj(Collections.singletonList(new com.byazt.vc.c(100)));
        }
        return new com.byazt.jx.z(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, cVarSp, ujVar, zNextBoolean2);
    }
}
