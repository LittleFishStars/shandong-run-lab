package com.alibaba.triver.resource.debug;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.content.NormalResourcePackage;
import com.alibaba.ariver.resource.parser.PackageParseUtils;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.ParseFailedException;
import com.alibaba.ariver.resource.parser.a.f;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends NormalResourcePackage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ResourceContext f25161a;

    public b(String str, ResourceContext resourceContext) {
        super(str, resourceContext);
        this.f25161a = resourceContext;
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public Resource get(@NonNull ResourceQuery resourceQuery) {
        String string = this.f25161a.getStartParams().getString("onlineHost");
        if (resourceQuery.isNeedAutoCompleteHost() && !TextUtils.isEmpty(string)) {
            resourceQuery.pureUrl = FileUtils.combinePath(string, resourceQuery.pureUrl);
        }
        return super.get(resourceQuery);
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void parseContent(String str, String str2) {
        f fVar;
        String absolutePath;
        File[] fileArrListFiles = new File(str2).listFiles();
        int length = fileArrListFiles.length;
        int i = 0;
        while (true) {
            fVar = null;
            if (i >= length) {
                absolutePath = null;
                break;
            }
            File file = fileArrListFiles[i];
            if (file.getAbsolutePath().endsWith(".tar")) {
                absolutePath = file.getAbsolutePath();
                break;
            }
            i++;
        }
        if (TextUtils.isEmpty(absolutePath)) {
            getParseLock().countDown();
            onPrepareDone();
            return;
        }
        ParseContext parseContext = new ParseContext();
        parseContext.appId = appId();
        parseContext.onlineHost = ((AppModel) this.f25161a.getApp().getData(AppModel.class)).getAppInfoModel().getVhost();
        parseContext.packagePath = str2;
        HashMap map = new HashMap();
        try {
            f fVar2 = new f(new BufferedInputStream(new FileInputStream(absolutePath)));
            try {
                PackageParseUtils.readTarStreamIntoMemory(map, fVar2, parseContext);
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    add((Resource) map.get((String) it.next()));
                }
                IOUtils.closeQuietly(fVar2);
                getParseLock().countDown();
                onPrepareDone();
            } catch (Throwable th) {
                th = th;
                fVar = fVar2;
                try {
                    RVLogger.e("LocalDebugResource", "readTarIntoMemory exception!", th);
                    throw new ParseFailedException(7, "readIntoPackageException:" + th.getMessage());
                } catch (Throwable th2) {
                    IOUtils.closeQuietly(fVar);
                    getParseLock().countDown();
                    onPrepareDone();
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
