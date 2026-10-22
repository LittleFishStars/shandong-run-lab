package com.alibaba.ariver.kernel.api.extension.resolver;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BoolIntersectionResolver implements ResultResolver<Boolean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
    public Boolean resolve(List<Boolean> list) {
        if (list == null) {
            return Boolean.FALSE;
        }
        for (Boolean bool : list) {
            if (bool == null) {
                return Boolean.FALSE;
            }
            if (!bool.booleanValue()) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
