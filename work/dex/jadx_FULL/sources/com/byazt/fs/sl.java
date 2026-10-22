package com.byazt.fs;

import android.util.JsonReader;
import com.amap.api.col.p0003l.ef;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 158})
public class sl {
    public com.byazt.kd.c c;
    public com.byazt.kd.tt n;
    public com.byazt.kd.tt tt;
    public com.byazt.kd.tt uj;
    public com.byazt.kd.tt ve;

    private void tt(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("v")) {
                strNextString.hashCode();
                switch (strNextString) {
                    case "Distance":
                        this.uj = uj.c(jsonReader, aVar);
                        break;
                    case "Opacity":
                        this.tt = uj.c(jsonReader, aVar, false);
                        break;
                    case "Direction":
                        this.ve = uj.c(jsonReader, aVar, false);
                        break;
                    case "Shadow Color":
                        this.c = uj.sp(jsonReader, aVar);
                        break;
                    case "Softness":
                        this.n = uj.c(jsonReader, aVar);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    public da c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        com.byazt.kd.tt ttVar;
        com.byazt.kd.tt ttVar2;
        com.byazt.kd.tt ttVar3;
        com.byazt.kd.tt ttVar4;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(ef.f25915a)) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    tt(jsonReader, aVar);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        com.byazt.kd.c cVar = this.c;
        if (cVar == null || (ttVar = this.tt) == null || (ttVar2 = this.ve) == null || (ttVar3 = this.uj) == null || (ttVar4 = this.n) == null) {
            return null;
        }
        return new da(cVar, ttVar, ttVar2, ttVar3, ttVar4);
    }
}
