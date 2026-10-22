package com.alibaba.ariver.kernel.api.extension.registry;

import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ExtensionRegistry {
    ActionMeta findActionMeta(@Nullable InstanceType instanceType, String str);

    @Nullable
    Collection<Class<? extends Extension>> findExtensions(@Nullable InstanceType instanceType, String str);

    @Nullable
    Collection<Class<? extends Extension>> findExtensions(String str);

    int getActionCount();

    Class<? extends Extension> getExtensionClass(String str);

    Class<? extends Scope> getScope(Class<? extends Extension> cls);

    Class<? extends Scope> getScope(String str);

    void register(ExtensionMetaInfo extensionMetaInfo);

    void register(Class<? extends Extension> cls);

    void register(Class<? extends Extension> cls, @Nullable Class<? extends Scope> cls2);

    void register(Class<? extends Extension> cls, @Nullable Class<? extends Scope> cls2, InstanceType instanceType);

    void unRegister(List<String> list);
}
