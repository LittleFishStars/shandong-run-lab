package com.alibaba.ariver.resource.api.extension;

import androidx.annotation.Keep;
import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
@Keep
public interface PackageParsedPoint extends Extension {
    void onResourceParsed(AppModel appModel, ResourcePackage resourcePackage);
}
