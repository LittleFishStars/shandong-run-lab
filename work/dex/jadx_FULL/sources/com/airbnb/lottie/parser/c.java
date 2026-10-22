package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.ariver.kernel.RVStartParams;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.zj.adlib.ap4;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements ValueParser<DocumentData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f23384a = new c();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final JsonReader.a f581a = JsonReader.a.a("t", "f", "s", "j", "tr", "lh", RVStartParams.KEY_LANDSCAPE_SHORT, AliyunLogKey.KEY_FILL_COLOR, "sc", "sw", "of");

    @Override // com.airbnb.lottie.parser.ValueParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DocumentData a(JsonReader jsonReader, float f) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.h();
        DocumentData.Justification justification2 = justification;
        String strV = null;
        String strV2 = null;
        float fQ = 0.0f;
        float fQ2 = 0.0f;
        float fQ3 = 0.0f;
        float fQ4 = 0.0f;
        int iR = 0;
        int iD = 0;
        int iD2 = 0;
        boolean zP = true;
        while (jsonReader.l()) {
            switch (jsonReader.F(f581a)) {
                case 0:
                    strV = jsonReader.v();
                    break;
                case 1:
                    strV2 = jsonReader.v();
                    break;
                case 2:
                    fQ = (float) jsonReader.q();
                    break;
                case 3:
                    int iR2 = jsonReader.r();
                    justification2 = DocumentData.Justification.CENTER;
                    if (iR2 <= justification2.ordinal() && iR2 >= 0) {
                        justification2 = DocumentData.Justification.values()[iR2];
                    }
                    break;
                case 4:
                    iR = jsonReader.r();
                    break;
                case 5:
                    fQ2 = (float) jsonReader.q();
                    break;
                case 6:
                    fQ3 = (float) jsonReader.q();
                    break;
                case 7:
                    iD = ap4.d(jsonReader);
                    break;
                case 8:
                    iD2 = ap4.d(jsonReader);
                    break;
                case 9:
                    fQ4 = (float) jsonReader.q();
                    break;
                case 10:
                    zP = jsonReader.p();
                    break;
                default:
                    jsonReader.H();
                    jsonReader.J();
                    break;
            }
        }
        jsonReader.k();
        return new DocumentData(strV, strV2, fQ, justification2, iR, fQ2, fQ3, iD, iD2, fQ4, zP);
    }
}
