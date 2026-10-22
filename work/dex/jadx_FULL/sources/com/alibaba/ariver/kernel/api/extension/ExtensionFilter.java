package com.alibaba.ariver.kernel.api.extension;

import com.alibaba.ariver.kernel.api.extension.Extension;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ExtensionFilter<T extends Extension> {
    List<T> filter(List<T> list);
}
