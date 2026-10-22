package com.alibaba.ariver.kernel.api.extension.resolver;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BoolPositiveResolver implements ResultResolver<Boolean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
    public Boolean resolve(List<Boolean> list) {
        boolean z;
        if (list != null) {
            for (Boolean bool : list) {
                if (bool != null && bool.booleanValue()) {
                    z = true;
                }
            }
            z = false;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
