package com.alibaba.wireless.security.open.middletier;

import com.alibaba.wireless.security.open.SecException;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IUnifiedSecurityComponent {
    HashMap<String, String> getSecurityFactors(HashMap<String, Object> map) throws SecException;

    void init(HashMap<String, Object> map) throws SecException;
}
