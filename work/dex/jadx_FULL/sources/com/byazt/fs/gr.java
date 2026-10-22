package com.byazt.fs;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class gr {
    public static com.byazt.jx.x c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.jx.x.c cVar = null;
        com.byazt.kd.x xVarN = null;
        com.byazt.kd.uj ujVarTt = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "o":
                    ujVarTt = uj.tt(jsonReader, aVar);
                    break;
                case "pt":
                    xVarN = uj.n(jsonReader, aVar);
                    break;
                case "inv":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.hashCode();
                    switch (strNextString) {
                        case "a":
                            cVar = com.byazt.jx.x.c.MASK_MODE_ADD;
                            break;
                        case "i":
                            aVar.c("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            cVar = com.byazt.jx.x.c.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            cVar = com.byazt.jx.x.c.MASK_MODE_NONE;
                            break;
                        case "s":
                            cVar = com.byazt.jx.x.c.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            com.byazt.kk.a.tt("Unknown mask mode " + strNextName + ". Defaulting to Add.");
                            cVar = com.byazt.jx.x.c.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.byazt.jx.x(cVar, xVarN, ujVarTt, zNextBoolean);
    }
}
