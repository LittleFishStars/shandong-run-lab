package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.AdResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.basic.ADNAdResponse;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class up implements sa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27841a;

    public up(Context context) {
        this.f27841a = context.getApplicationContext();
    }

    @Override // com.beizi.fusion.sa
    public void a(int i, InputStream inputStream) {
        AdResponseModel adResponseModelA;
        n1[] n1VarArr = new n1[1];
        try {
            String strA = p0.a(this.f27841a, p0.b(), "asnpAdPattern", "101,1001");
            adResponseModelA = a(new String(((id) dh.a().b(this.f27841a)).a(zd.b(inputStream), strA, id.a.NOT_APPEND, true), "UTF-8"), n1VarArr);
        } catch (IOException e) {
            om.a(e);
            n1VarArr[0] = n1.ERROR_RESPONSE_PARSE_FAILED;
            adResponseModelA = null;
        }
        a(adResponseModelA, n1VarArr);
    }

    public abstract void a(AdResponseModel adResponseModel, n1[] n1VarArr);

    public abstract void b(nc ncVar);

    @Override // com.beizi.fusion.sa
    public void a(nc ncVar) {
        b(ncVar);
    }

    private AdResponseModel a(String str, n1[] n1VarArr) {
        if (!TextUtils.isEmpty(str)) {
            ADNAdResponse aDNAdResponse = new ADNAdResponse(mg.c(str));
            if (aDNAdResponse.isResponseValid()) {
                AdResponseModel data = aDNAdResponse.getData();
                if (!data.hasParseException()) {
                    return data;
                }
                if (n1VarArr != null && n1VarArr.length > 0) {
                    n1VarArr[0] = n1.ERROR_RESPONSE_PARSE_FAILED;
                }
                return null;
            }
        }
        if (n1VarArr != null && n1VarArr.length > 0) {
            n1VarArr[0] = n1.ERROR_REQUEST_FAILED;
        }
        return null;
    }
}
