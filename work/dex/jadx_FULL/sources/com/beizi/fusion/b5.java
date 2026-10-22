package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.ResponseInfo;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class b5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f27092a;

    public static AdSpacesBean a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ResponseInfo responseInfo = ResponseInfo.getInstance(context);
            if (!responseInfo.isInit()) {
                responseInfo.init();
            }
            Manager manager = responseInfo.getManager();
            if (manager != null) {
                List<AdSpacesBean> adSpaces = manager.getAdSpaces();
                if (adSpaces != null && adSpaces.size() > 0) {
                    for (int i = 0; i < adSpaces.size(); i++) {
                        AdSpacesBean adSpacesBean = adSpaces.get(i);
                        if (str.equals(adSpacesBean.getSpaceId())) {
                            return adSpacesBean;
                        }
                    }
                }
                a(2);
                return null;
            }
            a(1);
        }
        return null;
    }

    public static int a() {
        int i = f27092a;
        a(0);
        return i;
    }

    public static void a(int i) {
        f27092a = i;
    }
}
