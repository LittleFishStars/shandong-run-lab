package com.bumptech.glide.annotation.compiler;

import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.repackaged.com.squareup.javapoet.AnnotationSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ClassName;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.zj.adlib.c49;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class IndexerGenerator {
    private final ProcessorUtil processorUtil;

    public IndexerGenerator(ProcessorUtil processorUtil) {
        this.processorUtil = processorUtil;
    }

    private static String getAnnotationValue(Class<? extends Annotation> cls) {
        if (cls == GlideModule.class) {
            return "modules";
        }
        if (cls == GlideExtension.class) {
            return "extensions";
        }
        throw new IllegalArgumentException("Unrecognized annotation: " + cls);
    }

    public TypeSpec generate(List<TypeElement> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TypeElement typeElement : list) {
            if (this.processorUtil.isExtension(typeElement)) {
                arrayList2.add(typeElement);
            } else {
                if (!this.processorUtil.isLibraryGlideModule(typeElement)) {
                    throw new IllegalArgumentException("Unrecognized type: " + typeElement);
                }
                arrayList.add(typeElement);
            }
        }
        if (arrayList.isEmpty() || arrayList2.isEmpty()) {
            return !arrayList.isEmpty() ? generate(list, GlideModule.class) : generate(list, GlideExtension.class);
        }
        throw new IllegalArgumentException("Given both modules and extensions, expected one or the other. Modules: " + arrayList + " Extensions: " + arrayList2);
    }

    private TypeSpec generate(List<TypeElement> list, Class<? extends Annotation> cls) {
        AnnotationSpec.Builder builder = AnnotationSpec.builder((Class<?>) Index.class);
        String annotationValue = getAnnotationValue(cls);
        Iterator<TypeElement> it = list.iterator();
        while (it.hasNext()) {
            builder.addMember(annotationValue, "$S", ClassName.get(it.next()).toString());
        }
        StringBuilder sb = new StringBuilder("GlideIndexer_" + cls.getSimpleName() + LoginConstants.UNDER_LINE);
        Iterator<TypeElement> it2 = list.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next().getQualifiedName().toString().replace(Consts.DOT, LoginConstants.UNDER_LINE));
            sb.append(LoginConstants.UNDER_LINE);
        }
        String string = new StringBuilder(sb.substring(0, sb.length() - 1)).toString();
        if (string.length() >= 242) {
            string = "GlideIndexer_" + UUID.nameUUIDFromBytes(string.getBytes()).toString().replace(c49.f40900a, LoginConstants.UNDER_LINE);
        }
        return TypeSpec.classBuilder(string).addAnnotation(builder.build()).addModifiers(Modifier.PUBLIC).build();
    }
}
