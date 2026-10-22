package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class ExtensionProcessor {
    private final GlideExtensionValidator extensionValidator;
    private final IndexerGenerator indexerGenerator;
    private final ProcessorUtil processorUtil;

    public ExtensionProcessor(ProcessingEnvironment processingEnvironment, ProcessorUtil processorUtil, IndexerGenerator indexerGenerator) {
        this.processorUtil = processorUtil;
        this.indexerGenerator = indexerGenerator;
        this.extensionValidator = new GlideExtensionValidator(processingEnvironment, processorUtil);
    }

    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(GlideExtension.class.getName());
    }

    public boolean processExtensions(RoundEnvironment roundEnvironment) {
        List<TypeElement> elementsFor = this.processorUtil.getElementsFor(GlideExtension.class, roundEnvironment);
        this.processorUtil.debugLog("Processing types : " + elementsFor);
        for (TypeElement typeElement : elementsFor) {
            this.extensionValidator.validateExtension(typeElement);
            this.processorUtil.debugLog("Processing elements: " + typeElement.getEnclosedElements());
        }
        if (elementsFor.isEmpty()) {
            return false;
        }
        this.processorUtil.writeIndexer(this.indexerGenerator.generate(elementsFor));
        return true;
    }
}
