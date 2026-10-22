package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class LibraryModuleProcessor {
    private final IndexerGenerator indexerGenerator;
    private final ProcessorUtil processorUtil;

    public LibraryModuleProcessor(ProcessorUtil processorUtil, IndexerGenerator indexerGenerator) {
        this.processorUtil = processorUtil;
        this.indexerGenerator = indexerGenerator;
    }

    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(GlideModule.class.getName());
    }

    public boolean processModules(RoundEnvironment roundEnvironment) {
        ArrayList arrayList = new ArrayList();
        for (TypeElement typeElement : this.processorUtil.getElementsFor(GlideModule.class, roundEnvironment)) {
            if (!this.processorUtil.isAppGlideModule(typeElement)) {
                if (!this.processorUtil.isLibraryGlideModule(typeElement)) {
                    throw new IllegalStateException("@GlideModule can only be applied to LibraryGlideModule and AppGlideModule implementations, not: " + typeElement);
                }
                arrayList.add(typeElement);
            }
        }
        this.processorUtil.debugLog("got child modules: " + arrayList);
        if (arrayList.isEmpty()) {
            return false;
        }
        this.processorUtil.writeIndexer(this.indexerGenerator.generate(arrayList));
        this.processorUtil.debugLog("Wrote an Indexer this round, skipping the app module to ensure all indexers are found");
        return true;
    }
}
