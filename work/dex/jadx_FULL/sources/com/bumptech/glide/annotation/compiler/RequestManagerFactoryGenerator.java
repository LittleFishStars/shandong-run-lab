package com.bumptech.glide.annotation.compiler;

import com.alibaba.alibclinkpartner.smartlink.constants.ALPUserTrackConstant;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ClassName;
import com.bumptech.glide.repackaged.com.squareup.javapoet.MethodSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ParameterSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class RequestManagerFactoryGenerator {
    private static final ClassName CONTEXT_CLASS_NAME = ClassName.get("android.content", "Context", new String[0]);
    private final TypeElement glideType;
    private final TypeElement lifecycleType;
    private final ProcessorUtil processorUtil;
    private final ClassName requestManagerClassName;
    private final TypeElement requestManagerFactoryInterface;
    private final TypeElement requestManagerTreeNodeType;

    public RequestManagerFactoryGenerator(ProcessingEnvironment processingEnvironment, ProcessorUtil processorUtil) {
        this.processorUtil = processorUtil;
        Elements elementUtils = processingEnvironment.getElementUtils();
        this.glideType = elementUtils.getTypeElement("com.bumptech.glide.Glide");
        this.lifecycleType = elementUtils.getTypeElement("com.bumptech.glide.manager.Lifecycle");
        this.requestManagerTreeNodeType = elementUtils.getTypeElement("com.bumptech.glide.manager.RequestManagerTreeNode");
        this.requestManagerFactoryInterface = elementUtils.getTypeElement("com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory");
        this.requestManagerClassName = ClassName.get(elementUtils.getTypeElement("com.bumptech.glide.RequestManager"));
    }

    public TypeSpec generate(String str, TypeSpec typeSpec) {
        return TypeSpec.classBuilder("GeneratedRequestManagerFactory").addModifiers(Modifier.FINAL).addSuperinterface(ClassName.get(this.requestManagerFactoryInterface)).addJavadoc("Generated code, do not modify\n", new Object[0]).addMethod(MethodSpec.methodBuilder(ALPUserTrackConstant.METHOD_BUILD).addModifiers(Modifier.PUBLIC).addAnnotation(Override.class).addAnnotation(this.processorUtil.nonNull()).returns(this.requestManagerClassName).addParameter(ParameterSpec.builder(ClassName.get(this.glideType), "glide", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addParameter(ParameterSpec.builder(ClassName.get(this.lifecycleType), RequestParameters.SUBRESOURCE_LIFECYCLE, new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addParameter(ParameterSpec.builder(ClassName.get(this.requestManagerTreeNodeType), "treeNode", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addParameter(ParameterSpec.builder(CONTEXT_CLASS_NAME, "context", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addStatement("return new $T(glide, lifecycle, treeNode, context)", ClassName.get(str, typeSpec.name, new String[0])).build()).build();
    }
}
