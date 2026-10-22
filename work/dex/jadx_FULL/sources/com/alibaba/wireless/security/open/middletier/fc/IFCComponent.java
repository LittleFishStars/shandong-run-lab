package com.alibaba.wireless.security.open.middletier.fc;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IFCComponent {
    String getFCPluginVersion() throws SecException;

    void setUp(Context context, HashMap map) throws SecException;
}
