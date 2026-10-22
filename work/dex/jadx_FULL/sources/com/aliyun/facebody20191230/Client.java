package com.aliyun.facebody20191230;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.facebody20191230.models.AddFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.AddFaceEntityRequest;
import com.aliyun.facebody20191230.models.AddFaceEntityResponse;
import com.aliyun.facebody20191230.models.AddFaceImageTemplateAdvanceRequest;
import com.aliyun.facebody20191230.models.AddFaceImageTemplateRequest;
import com.aliyun.facebody20191230.models.AddFaceImageTemplateResponse;
import com.aliyun.facebody20191230.models.AddFaceRequest;
import com.aliyun.facebody20191230.models.AddFaceResponse;
import com.aliyun.facebody20191230.models.BatchAddFacesAdvanceRequest;
import com.aliyun.facebody20191230.models.BatchAddFacesRequest;
import com.aliyun.facebody20191230.models.BatchAddFacesResponse;
import com.aliyun.facebody20191230.models.BatchAddFacesShrinkRequest;
import com.aliyun.facebody20191230.models.BeautifyBodyAdvanceRequest;
import com.aliyun.facebody20191230.models.BeautifyBodyRequest;
import com.aliyun.facebody20191230.models.BeautifyBodyResponse;
import com.aliyun.facebody20191230.models.BeautifyBodyShrinkRequest;
import com.aliyun.facebody20191230.models.BlurFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.BlurFaceRequest;
import com.aliyun.facebody20191230.models.BlurFaceResponse;
import com.aliyun.facebody20191230.models.BodyPostureAdvanceRequest;
import com.aliyun.facebody20191230.models.BodyPostureRequest;
import com.aliyun.facebody20191230.models.BodyPostureResponse;
import com.aliyun.facebody20191230.models.CompareFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.CompareFaceRequest;
import com.aliyun.facebody20191230.models.CompareFaceResponse;
import com.aliyun.facebody20191230.models.CompareFaceWithMaskAdvanceRequest;
import com.aliyun.facebody20191230.models.CompareFaceWithMaskRequest;
import com.aliyun.facebody20191230.models.CompareFaceWithMaskResponse;
import com.aliyun.facebody20191230.models.CreateFaceDbRequest;
import com.aliyun.facebody20191230.models.CreateFaceDbResponse;
import com.aliyun.facebody20191230.models.DeepfakeFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.DeepfakeFaceRequest;
import com.aliyun.facebody20191230.models.DeepfakeFaceResponse;
import com.aliyun.facebody20191230.models.DeleteFaceDbRequest;
import com.aliyun.facebody20191230.models.DeleteFaceDbResponse;
import com.aliyun.facebody20191230.models.DeleteFaceEntityRequest;
import com.aliyun.facebody20191230.models.DeleteFaceEntityResponse;
import com.aliyun.facebody20191230.models.DeleteFaceImageTemplateRequest;
import com.aliyun.facebody20191230.models.DeleteFaceImageTemplateResponse;
import com.aliyun.facebody20191230.models.DeleteFaceRequest;
import com.aliyun.facebody20191230.models.DeleteFaceResponse;
import com.aliyun.facebody20191230.models.DetectBodyCountAdvanceRequest;
import com.aliyun.facebody20191230.models.DetectBodyCountRequest;
import com.aliyun.facebody20191230.models.DetectBodyCountResponse;
import com.aliyun.facebody20191230.models.DetectCelebrityAdvanceRequest;
import com.aliyun.facebody20191230.models.DetectCelebrityRequest;
import com.aliyun.facebody20191230.models.DetectCelebrityResponse;
import com.aliyun.facebody20191230.models.DetectChefCapAdvanceRequest;
import com.aliyun.facebody20191230.models.DetectChefCapRequest;
import com.aliyun.facebody20191230.models.DetectChefCapResponse;
import com.aliyun.facebody20191230.models.DetectFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.DetectFaceRequest;
import com.aliyun.facebody20191230.models.DetectFaceResponse;
import com.aliyun.facebody20191230.models.DetectInfraredLivingFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.DetectInfraredLivingFaceRequest;
import com.aliyun.facebody20191230.models.DetectInfraredLivingFaceResponse;
import com.aliyun.facebody20191230.models.DetectLivingFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.DetectLivingFaceRequest;
import com.aliyun.facebody20191230.models.DetectLivingFaceResponse;
import com.aliyun.facebody20191230.models.DetectPedestrianAdvanceRequest;
import com.aliyun.facebody20191230.models.DetectPedestrianIntrusionAdvanceRequest;
import com.aliyun.facebody20191230.models.DetectPedestrianIntrusionRequest;
import com.aliyun.facebody20191230.models.DetectPedestrianIntrusionResponse;
import com.aliyun.facebody20191230.models.DetectPedestrianIntrusionShrinkRequest;
import com.aliyun.facebody20191230.models.DetectPedestrianRequest;
import com.aliyun.facebody20191230.models.DetectPedestrianResponse;
import com.aliyun.facebody20191230.models.DetectVideoLivingFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.DetectVideoLivingFaceRequest;
import com.aliyun.facebody20191230.models.DetectVideoLivingFaceResponse;
import com.aliyun.facebody20191230.models.EnhanceFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.EnhanceFaceRequest;
import com.aliyun.facebody20191230.models.EnhanceFaceResponse;
import com.aliyun.facebody20191230.models.ExtractFingerPrintAdvanceRequest;
import com.aliyun.facebody20191230.models.ExtractFingerPrintRequest;
import com.aliyun.facebody20191230.models.ExtractFingerPrintResponse;
import com.aliyun.facebody20191230.models.ExtractPedestrianFeatureAttrAdvanceRequest;
import com.aliyun.facebody20191230.models.ExtractPedestrianFeatureAttrRequest;
import com.aliyun.facebody20191230.models.ExtractPedestrianFeatureAttrResponse;
import com.aliyun.facebody20191230.models.FaceBeautyAdvanceRequest;
import com.aliyun.facebody20191230.models.FaceBeautyRequest;
import com.aliyun.facebody20191230.models.FaceBeautyResponse;
import com.aliyun.facebody20191230.models.FaceFilterAdvanceRequest;
import com.aliyun.facebody20191230.models.FaceFilterRequest;
import com.aliyun.facebody20191230.models.FaceFilterResponse;
import com.aliyun.facebody20191230.models.FaceMakeupAdvanceRequest;
import com.aliyun.facebody20191230.models.FaceMakeupRequest;
import com.aliyun.facebody20191230.models.FaceMakeupResponse;
import com.aliyun.facebody20191230.models.FaceTidyupAdvanceRequest;
import com.aliyun.facebody20191230.models.FaceTidyupRequest;
import com.aliyun.facebody20191230.models.FaceTidyupResponse;
import com.aliyun.facebody20191230.models.GenRealPersonVerificationTokenRequest;
import com.aliyun.facebody20191230.models.GenRealPersonVerificationTokenResponse;
import com.aliyun.facebody20191230.models.GenerateHumanAnimeStyleAdvanceRequest;
import com.aliyun.facebody20191230.models.GenerateHumanAnimeStyleRequest;
import com.aliyun.facebody20191230.models.GenerateHumanAnimeStyleResponse;
import com.aliyun.facebody20191230.models.GenerateHumanSketchStyleAdvanceRequest;
import com.aliyun.facebody20191230.models.GenerateHumanSketchStyleRequest;
import com.aliyun.facebody20191230.models.GenerateHumanSketchStyleResponse;
import com.aliyun.facebody20191230.models.GetFaceEntityRequest;
import com.aliyun.facebody20191230.models.GetFaceEntityResponse;
import com.aliyun.facebody20191230.models.GetRealPersonVerificationResultRequest;
import com.aliyun.facebody20191230.models.GetRealPersonVerificationResultResponse;
import com.aliyun.facebody20191230.models.HandPostureAdvanceRequest;
import com.aliyun.facebody20191230.models.HandPostureRequest;
import com.aliyun.facebody20191230.models.HandPostureResponse;
import com.aliyun.facebody20191230.models.LiquifyFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.LiquifyFaceRequest;
import com.aliyun.facebody20191230.models.LiquifyFaceResponse;
import com.aliyun.facebody20191230.models.ListFaceDbsRequest;
import com.aliyun.facebody20191230.models.ListFaceDbsResponse;
import com.aliyun.facebody20191230.models.ListFaceEntitiesRequest;
import com.aliyun.facebody20191230.models.ListFaceEntitiesResponse;
import com.aliyun.facebody20191230.models.MergeImageFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.MergeImageFaceRequest;
import com.aliyun.facebody20191230.models.MergeImageFaceResponse;
import com.aliyun.facebody20191230.models.MonitorExaminationAdvanceRequest;
import com.aliyun.facebody20191230.models.MonitorExaminationRequest;
import com.aliyun.facebody20191230.models.MonitorExaminationResponse;
import com.aliyun.facebody20191230.models.PedestrianDetectAttributeAdvanceRequest;
import com.aliyun.facebody20191230.models.PedestrianDetectAttributeRequest;
import com.aliyun.facebody20191230.models.PedestrianDetectAttributeResponse;
import com.aliyun.facebody20191230.models.QueryFaceImageTemplateRequest;
import com.aliyun.facebody20191230.models.QueryFaceImageTemplateResponse;
import com.aliyun.facebody20191230.models.RecognizeActionAdvanceRequest;
import com.aliyun.facebody20191230.models.RecognizeActionRequest;
import com.aliyun.facebody20191230.models.RecognizeActionResponse;
import com.aliyun.facebody20191230.models.RecognizeExpressionAdvanceRequest;
import com.aliyun.facebody20191230.models.RecognizeExpressionRequest;
import com.aliyun.facebody20191230.models.RecognizeExpressionResponse;
import com.aliyun.facebody20191230.models.RecognizeFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.RecognizeFaceRequest;
import com.aliyun.facebody20191230.models.RecognizeFaceResponse;
import com.aliyun.facebody20191230.models.RecognizeHandGestureAdvanceRequest;
import com.aliyun.facebody20191230.models.RecognizeHandGestureRequest;
import com.aliyun.facebody20191230.models.RecognizeHandGestureResponse;
import com.aliyun.facebody20191230.models.RecognizePublicFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.RecognizePublicFaceRequest;
import com.aliyun.facebody20191230.models.RecognizePublicFaceResponse;
import com.aliyun.facebody20191230.models.RetouchBodyAdvanceRequest;
import com.aliyun.facebody20191230.models.RetouchBodyRequest;
import com.aliyun.facebody20191230.models.RetouchBodyResponse;
import com.aliyun.facebody20191230.models.RetouchSkinAdvanceRequest;
import com.aliyun.facebody20191230.models.RetouchSkinRequest;
import com.aliyun.facebody20191230.models.RetouchSkinResponse;
import com.aliyun.facebody20191230.models.SearchFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.SearchFaceRequest;
import com.aliyun.facebody20191230.models.SearchFaceResponse;
import com.aliyun.facebody20191230.models.UpdateFaceEntityRequest;
import com.aliyun.facebody20191230.models.UpdateFaceEntityResponse;
import com.aliyun.facebody20191230.models.VerifyFaceMaskAdvanceRequest;
import com.aliyun.facebody20191230.models.VerifyFaceMaskRequest;
import com.aliyun.facebody20191230.models.VerifyFaceMaskResponse;
import com.aliyun.fileform.models.FileField;
import com.aliyun.openplatform20191219.models.AuthorizeFileUploadRequest;
import com.aliyun.openplatform20191219.models.AuthorizeFileUploadResponse;
import com.aliyun.openplatform20191219.models.AuthorizeFileUploadResponseBody;
import com.aliyun.oss.models.PostObjectRequest;
import com.aliyun.tea.TeaConverter;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.TeaPair;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teaopenapi.models.OpenApiRequest;
import com.aliyun.teaopenapi.models.Params;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.google.common.net.b;
import com.huachenjie.mine.page.dressing_table.signature.SignatureFragment;
import com.zj.adlib.ze1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Client extends com.aliyun.teaopenapi.Client {
    public Client(Config config) throws Exception {
        super(config);
        this._endpointRule = "regional";
        checkConfig(config);
        this._endpoint = getEndpoint("facebody", this._regionId, this._endpointRule, this._network, this._suffix, this._endpointMap, this._endpoint);
    }

    public AddFaceResponse addFace(AddFaceRequest addFaceRequest) throws Exception {
        return addFaceWithOptions(addFaceRequest, new RuntimeOptions());
    }

    public AddFaceResponse addFaceAdvance(AddFaceAdvanceRequest addFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        AddFaceRequest addFaceRequest = new AddFaceRequest();
        com.aliyun.openapiutil.Client.convert(addFaceAdvanceRequest, addFaceRequest);
        if (!Common.isUnset(addFaceAdvanceRequest.imageUrlObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", addFaceAdvanceRequest.imageUrlObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            addFaceRequest.imageUrl = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return addFaceWithOptions(addFaceRequest, runtimeOptions);
    }

    public AddFaceEntityResponse addFaceEntity(AddFaceEntityRequest addFaceEntityRequest) throws Exception {
        return addFaceEntityWithOptions(addFaceEntityRequest, new RuntimeOptions());
    }

    public AddFaceEntityResponse addFaceEntityWithOptions(AddFaceEntityRequest addFaceEntityRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(addFaceEntityRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(addFaceEntityRequest.dbName)) {
            map.put("DbName", addFaceEntityRequest.dbName);
        }
        if (!Common.isUnset(addFaceEntityRequest.entityId)) {
            map.put("EntityId", addFaceEntityRequest.entityId);
        }
        if (!Common.isUnset(addFaceEntityRequest.labels)) {
            map.put("Labels", addFaceEntityRequest.labels);
        }
        return (AddFaceEntityResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "AddFaceEntity"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new AddFaceEntityResponse());
    }

    public AddFaceImageTemplateResponse addFaceImageTemplate(AddFaceImageTemplateRequest addFaceImageTemplateRequest) throws Exception {
        return addFaceImageTemplateWithOptions(addFaceImageTemplateRequest, new RuntimeOptions());
    }

    public AddFaceImageTemplateResponse addFaceImageTemplateAdvance(AddFaceImageTemplateAdvanceRequest addFaceImageTemplateAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        AddFaceImageTemplateRequest addFaceImageTemplateRequest = new AddFaceImageTemplateRequest();
        com.aliyun.openapiutil.Client.convert(addFaceImageTemplateAdvanceRequest, addFaceImageTemplateRequest);
        if (!Common.isUnset(addFaceImageTemplateAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", addFaceImageTemplateAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            addFaceImageTemplateRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return addFaceImageTemplateWithOptions(addFaceImageTemplateRequest, runtimeOptions);
    }

    public AddFaceImageTemplateResponse addFaceImageTemplateWithOptions(AddFaceImageTemplateRequest addFaceImageTemplateRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(addFaceImageTemplateRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(addFaceImageTemplateRequest.imageURL)) {
            map.put("ImageURL", addFaceImageTemplateRequest.imageURL);
        }
        return (AddFaceImageTemplateResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "AddFaceImageTemplate"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new AddFaceImageTemplateResponse());
    }

    public AddFaceResponse addFaceWithOptions(AddFaceRequest addFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(addFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(addFaceRequest.dbName)) {
            map.put("DbName", addFaceRequest.dbName);
        }
        if (!Common.isUnset(addFaceRequest.entityId)) {
            map.put("EntityId", addFaceRequest.entityId);
        }
        if (!Common.isUnset(addFaceRequest.extraData)) {
            map.put("ExtraData", addFaceRequest.extraData);
        }
        if (!Common.isUnset(addFaceRequest.imageUrl)) {
            map.put("ImageUrl", addFaceRequest.imageUrl);
        }
        if (!Common.isUnset(addFaceRequest.qualityScoreThreshold)) {
            map.put("QualityScoreThreshold", addFaceRequest.qualityScoreThreshold);
        }
        if (!Common.isUnset(addFaceRequest.similarityScoreThresholdBetweenEntity)) {
            map.put("SimilarityScoreThresholdBetweenEntity", addFaceRequest.similarityScoreThresholdBetweenEntity);
        }
        if (!Common.isUnset(addFaceRequest.similarityScoreThresholdInEntity)) {
            map.put("SimilarityScoreThresholdInEntity", addFaceRequest.similarityScoreThresholdInEntity);
        }
        return (AddFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "AddFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new AddFaceResponse());
    }

    public BatchAddFacesResponse batchAddFaces(BatchAddFacesRequest batchAddFacesRequest) throws Exception {
        return batchAddFacesWithOptions(batchAddFacesRequest, new RuntimeOptions());
    }

    public BatchAddFacesResponse batchAddFacesAdvance(BatchAddFacesAdvanceRequest batchAddFacesAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        TeaPair teaPair = new TeaPair("accessKeyId", accessKeyId);
        boolean z2 = false;
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(teaPair, new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        BatchAddFacesRequest batchAddFacesRequest = new BatchAddFacesRequest();
        com.aliyun.openapiutil.Client.convert(batchAddFacesAdvanceRequest, batchAddFacesRequest);
        if (!Common.isUnset(batchAddFacesAdvanceRequest.faces)) {
            Integer numLtoi = 0;
            Iterator<BatchAddFacesAdvanceRequest.BatchAddFacesAdvanceRequestFaces> it = batchAddFacesAdvanceRequest.faces.iterator();
            while (it.hasNext()) {
                BatchAddFacesAdvanceRequest.BatchAddFacesAdvanceRequestFaces next = it.next();
                if (Common.isUnset(next.imageURLObject)) {
                    z = z2;
                } else {
                    AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
                    AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
                    configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
                    configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
                    z = false;
                    new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", next.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
                    batchAddFacesRequest.faces.get(numLtoi.intValue()).imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
                    numLtoi = com.aliyun.darabonbanumber.Client.ltoi(com.aliyun.darabonbanumber.Client.add(com.aliyun.darabonbanumber.Client.itol(numLtoi), com.aliyun.darabonbanumber.Client.itol(1)));
                }
                it = it;
                z2 = z;
                configBuild = configBuild;
            }
        }
        return batchAddFacesWithOptions(batchAddFacesRequest, runtimeOptions);
    }

    public BatchAddFacesResponse batchAddFacesWithOptions(BatchAddFacesRequest batchAddFacesRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(batchAddFacesRequest);
        BatchAddFacesShrinkRequest batchAddFacesShrinkRequest = new BatchAddFacesShrinkRequest();
        com.aliyun.openapiutil.Client.convert(batchAddFacesRequest, batchAddFacesShrinkRequest);
        if (!Common.isUnset(batchAddFacesRequest.faces)) {
            batchAddFacesShrinkRequest.facesShrink = com.aliyun.openapiutil.Client.arrayToStringWithSpecifiedStyle(batchAddFacesRequest.faces, "Faces", "json");
        }
        HashMap map = new HashMap();
        if (!Common.isUnset(batchAddFacesShrinkRequest.dbName)) {
            map.put("DbName", batchAddFacesShrinkRequest.dbName);
        }
        if (!Common.isUnset(batchAddFacesShrinkRequest.entityId)) {
            map.put("EntityId", batchAddFacesShrinkRequest.entityId);
        }
        if (!Common.isUnset(batchAddFacesShrinkRequest.facesShrink)) {
            map.put("Faces", batchAddFacesShrinkRequest.facesShrink);
        }
        if (!Common.isUnset(batchAddFacesShrinkRequest.qualityScoreThreshold)) {
            map.put("QualityScoreThreshold", batchAddFacesShrinkRequest.qualityScoreThreshold);
        }
        if (!Common.isUnset(batchAddFacesShrinkRequest.similarityScoreThresholdBetweenEntity)) {
            map.put("SimilarityScoreThresholdBetweenEntity", batchAddFacesShrinkRequest.similarityScoreThresholdBetweenEntity);
        }
        if (!Common.isUnset(batchAddFacesShrinkRequest.similarityScoreThresholdInEntity)) {
            map.put("SimilarityScoreThresholdInEntity", batchAddFacesShrinkRequest.similarityScoreThresholdInEntity);
        }
        return (BatchAddFacesResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "BatchAddFaces"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new BatchAddFacesResponse());
    }

    public BeautifyBodyResponse beautifyBody(BeautifyBodyRequest beautifyBodyRequest) throws Exception {
        return beautifyBodyWithOptions(beautifyBodyRequest, new RuntimeOptions());
    }

    public BeautifyBodyResponse beautifyBodyAdvance(BeautifyBodyAdvanceRequest beautifyBodyAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        BeautifyBodyRequest beautifyBodyRequest = new BeautifyBodyRequest();
        com.aliyun.openapiutil.Client.convert(beautifyBodyAdvanceRequest, beautifyBodyRequest);
        if (!Common.isUnset(beautifyBodyAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", beautifyBodyAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            beautifyBodyRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return beautifyBodyWithOptions(beautifyBodyRequest, runtimeOptions);
    }

    public BeautifyBodyResponse beautifyBodyWithOptions(BeautifyBodyRequest beautifyBodyRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(beautifyBodyRequest);
        BeautifyBodyShrinkRequest beautifyBodyShrinkRequest = new BeautifyBodyShrinkRequest();
        com.aliyun.openapiutil.Client.convert(beautifyBodyRequest, beautifyBodyShrinkRequest);
        if (!Common.isUnset(beautifyBodyRequest.ageRange)) {
            beautifyBodyShrinkRequest.ageRangeShrink = com.aliyun.openapiutil.Client.arrayToStringWithSpecifiedStyle(beautifyBodyRequest.ageRange, "AgeRange", "json");
        }
        if (!Common.isUnset(beautifyBodyRequest.bodyBoxes)) {
            beautifyBodyShrinkRequest.bodyBoxesShrink = com.aliyun.openapiutil.Client.arrayToStringWithSpecifiedStyle(beautifyBodyRequest.bodyBoxes, "BodyBoxes", "json");
        }
        if (!Common.isUnset(beautifyBodyRequest.faceList)) {
            beautifyBodyShrinkRequest.faceListShrink = com.aliyun.openapiutil.Client.arrayToStringWithSpecifiedStyle(beautifyBodyRequest.faceList, "FaceList", "json");
        }
        if (!Common.isUnset(beautifyBodyRequest.poseList)) {
            beautifyBodyShrinkRequest.poseListShrink = com.aliyun.openapiutil.Client.arrayToStringWithSpecifiedStyle(beautifyBodyRequest.poseList, "PoseList", "json");
        }
        HashMap map = new HashMap();
        if (!Common.isUnset(beautifyBodyShrinkRequest.ageRangeShrink)) {
            map.put("AgeRange", beautifyBodyShrinkRequest.ageRangeShrink);
        }
        if (!Common.isUnset(beautifyBodyShrinkRequest.bodyBoxesShrink)) {
            map.put("BodyBoxes", beautifyBodyShrinkRequest.bodyBoxesShrink);
        }
        if (!Common.isUnset(beautifyBodyShrinkRequest.custom)) {
            map.put(TypedValues.Custom.NAME, beautifyBodyShrinkRequest.custom);
        }
        if (!Common.isUnset(beautifyBodyShrinkRequest.faceListShrink)) {
            map.put("FaceList", beautifyBodyShrinkRequest.faceListShrink);
        }
        if (!Common.isUnset(beautifyBodyShrinkRequest.femaleLiquifyDegree)) {
            map.put("FemaleLiquifyDegree", beautifyBodyShrinkRequest.femaleLiquifyDegree);
        }
        if (!Common.isUnset(beautifyBodyShrinkRequest.imageURL)) {
            map.put("ImageURL", beautifyBodyShrinkRequest.imageURL);
        }
        if (!Common.isUnset(beautifyBodyShrinkRequest.isPregnant)) {
            map.put("IsPregnant", beautifyBodyShrinkRequest.isPregnant);
        }
        if (!Common.isUnset(beautifyBodyShrinkRequest.lengthenDegree)) {
            map.put("LengthenDegree", beautifyBodyShrinkRequest.lengthenDegree);
        }
        if (!Common.isUnset(beautifyBodyShrinkRequest.maleLiquifyDegree)) {
            map.put("MaleLiquifyDegree", beautifyBodyShrinkRequest.maleLiquifyDegree);
        }
        if (!Common.isUnset(beautifyBodyShrinkRequest.originalHeight)) {
            map.put("OriginalHeight", beautifyBodyShrinkRequest.originalHeight);
        }
        if (!Common.isUnset(beautifyBodyShrinkRequest.originalWidth)) {
            map.put("OriginalWidth", beautifyBodyShrinkRequest.originalWidth);
        }
        if (!Common.isUnset(beautifyBodyShrinkRequest.poseListShrink)) {
            map.put("PoseList", beautifyBodyShrinkRequest.poseListShrink);
        }
        return (BeautifyBodyResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "BeautifyBody"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new BeautifyBodyResponse());
    }

    public BlurFaceResponse blurFace(BlurFaceRequest blurFaceRequest) throws Exception {
        return blurFaceWithOptions(blurFaceRequest, new RuntimeOptions());
    }

    public BlurFaceResponse blurFaceAdvance(BlurFaceAdvanceRequest blurFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        BlurFaceRequest blurFaceRequest = new BlurFaceRequest();
        com.aliyun.openapiutil.Client.convert(blurFaceAdvanceRequest, blurFaceRequest);
        if (!Common.isUnset(blurFaceAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", blurFaceAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            blurFaceRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return blurFaceWithOptions(blurFaceRequest, runtimeOptions);
    }

    public BlurFaceResponse blurFaceWithOptions(BlurFaceRequest blurFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(blurFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(blurFaceRequest.imageURL)) {
            map.put("ImageURL", blurFaceRequest.imageURL);
        }
        return (BlurFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "BlurFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new BlurFaceResponse());
    }

    public BodyPostureResponse bodyPosture(BodyPostureRequest bodyPostureRequest) throws Exception {
        return bodyPostureWithOptions(bodyPostureRequest, new RuntimeOptions());
    }

    public BodyPostureResponse bodyPostureAdvance(BodyPostureAdvanceRequest bodyPostureAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        BodyPostureRequest bodyPostureRequest = new BodyPostureRequest();
        com.aliyun.openapiutil.Client.convert(bodyPostureAdvanceRequest, bodyPostureRequest);
        if (!Common.isUnset(bodyPostureAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", bodyPostureAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            bodyPostureRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return bodyPostureWithOptions(bodyPostureRequest, runtimeOptions);
    }

    public BodyPostureResponse bodyPostureWithOptions(BodyPostureRequest bodyPostureRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(bodyPostureRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(bodyPostureRequest.imageURL)) {
            map.put("ImageURL", bodyPostureRequest.imageURL);
        }
        return (BodyPostureResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "BodyPosture"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new BodyPostureResponse());
    }

    public CompareFaceResponse compareFace(CompareFaceRequest compareFaceRequest) throws Exception {
        return compareFaceWithOptions(compareFaceRequest, new RuntimeOptions());
    }

    public CompareFaceResponse compareFaceAdvance(CompareFaceAdvanceRequest compareFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        CompareFaceRequest compareFaceRequest;
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2;
        Client client;
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client2 = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions3 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions3);
        CompareFaceRequest compareFaceRequest2 = new CompareFaceRequest();
        com.aliyun.openapiutil.Client.convert(compareFaceAdvanceRequest, compareFaceRequest2);
        if (Common.isUnset(compareFaceAdvanceRequest.imageURLAObject)) {
            compareFaceRequest = compareFaceRequest2;
            runtimeOptions2 = runtimeOptions3;
        } else {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client2.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            runtimeOptions2 = runtimeOptions3;
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", compareFaceAdvanceRequest.imageURLAObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            compareFaceRequest = compareFaceRequest2;
            compareFaceRequest.imageURLA = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        if (Common.isUnset(compareFaceAdvanceRequest.imageURLBObject)) {
            client = this;
        } else {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions2 = client2.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody2 = authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody2.accessKeyId;
            client = this;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody2.endpoint, authorizeFileUploadResponseBody2.useAccelerate.booleanValue(), client._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.objectKey), new TeaPair("content", compareFaceAdvanceRequest.imageURLBObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            compareFaceRequest.imageURLB = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.objectKey + "";
        }
        return client.compareFaceWithOptions(compareFaceRequest, runtimeOptions);
    }

    public CompareFaceWithMaskResponse compareFaceWithMask(CompareFaceWithMaskRequest compareFaceWithMaskRequest) throws Exception {
        return compareFaceWithMaskWithOptions(compareFaceWithMaskRequest, new RuntimeOptions());
    }

    public CompareFaceWithMaskResponse compareFaceWithMaskAdvance(CompareFaceWithMaskAdvanceRequest compareFaceWithMaskAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        CompareFaceWithMaskRequest compareFaceWithMaskRequest;
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2;
        Client client;
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client2 = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions3 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions3);
        CompareFaceWithMaskRequest compareFaceWithMaskRequest2 = new CompareFaceWithMaskRequest();
        com.aliyun.openapiutil.Client.convert(compareFaceWithMaskAdvanceRequest, compareFaceWithMaskRequest2);
        if (Common.isUnset(compareFaceWithMaskAdvanceRequest.imageURLAObject)) {
            compareFaceWithMaskRequest = compareFaceWithMaskRequest2;
            runtimeOptions2 = runtimeOptions3;
        } else {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client2.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            runtimeOptions2 = runtimeOptions3;
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", compareFaceWithMaskAdvanceRequest.imageURLAObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            compareFaceWithMaskRequest = compareFaceWithMaskRequest2;
            compareFaceWithMaskRequest.imageURLA = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        if (Common.isUnset(compareFaceWithMaskAdvanceRequest.imageURLBObject)) {
            client = this;
        } else {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions2 = client2.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody2 = authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody2.accessKeyId;
            client = this;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody2.endpoint, authorizeFileUploadResponseBody2.useAccelerate.booleanValue(), client._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.objectKey), new TeaPair("content", compareFaceWithMaskAdvanceRequest.imageURLBObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            compareFaceWithMaskRequest.imageURLB = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.objectKey + "";
        }
        return client.compareFaceWithMaskWithOptions(compareFaceWithMaskRequest, runtimeOptions);
    }

    public CompareFaceWithMaskResponse compareFaceWithMaskWithOptions(CompareFaceWithMaskRequest compareFaceWithMaskRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(compareFaceWithMaskRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(compareFaceWithMaskRequest.imageURLA)) {
            map.put("ImageURLA", compareFaceWithMaskRequest.imageURLA);
        }
        if (!Common.isUnset(compareFaceWithMaskRequest.imageURLB)) {
            map.put("ImageURLB", compareFaceWithMaskRequest.imageURLB);
        }
        if (!Common.isUnset(compareFaceWithMaskRequest.qualityScoreThreshold)) {
            map.put("QualityScoreThreshold", compareFaceWithMaskRequest.qualityScoreThreshold);
        }
        return (CompareFaceWithMaskResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "CompareFaceWithMask"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new CompareFaceWithMaskResponse());
    }

    public CompareFaceResponse compareFaceWithOptions(CompareFaceRequest compareFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(compareFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(compareFaceRequest.imageDataA)) {
            map.put("ImageDataA", compareFaceRequest.imageDataA);
        }
        if (!Common.isUnset(compareFaceRequest.imageDataB)) {
            map.put("ImageDataB", compareFaceRequest.imageDataB);
        }
        if (!Common.isUnset(compareFaceRequest.imageURLA)) {
            map.put("ImageURLA", compareFaceRequest.imageURLA);
        }
        if (!Common.isUnset(compareFaceRequest.imageURLB)) {
            map.put("ImageURLB", compareFaceRequest.imageURLB);
        }
        if (!Common.isUnset(compareFaceRequest.qualityScoreThreshold)) {
            map.put("QualityScoreThreshold", compareFaceRequest.qualityScoreThreshold);
        }
        return (CompareFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "CompareFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new CompareFaceResponse());
    }

    public CreateFaceDbResponse createFaceDb(CreateFaceDbRequest createFaceDbRequest) throws Exception {
        return createFaceDbWithOptions(createFaceDbRequest, new RuntimeOptions());
    }

    public CreateFaceDbResponse createFaceDbWithOptions(CreateFaceDbRequest createFaceDbRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(createFaceDbRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(createFaceDbRequest.name)) {
            map.put("Name", createFaceDbRequest.name);
        }
        return (CreateFaceDbResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "CreateFaceDb"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new CreateFaceDbResponse());
    }

    public DeepfakeFaceResponse deepfakeFace(DeepfakeFaceRequest deepfakeFaceRequest) throws Exception {
        return deepfakeFaceWithOptions(deepfakeFaceRequest, new RuntimeOptions());
    }

    public DeepfakeFaceResponse deepfakeFaceAdvance(DeepfakeFaceAdvanceRequest deepfakeFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        TeaPair teaPair = new TeaPair("accessKeyId", accessKeyId);
        boolean z2 = false;
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(teaPair, new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        DeepfakeFaceRequest deepfakeFaceRequest = new DeepfakeFaceRequest();
        com.aliyun.openapiutil.Client.convert(deepfakeFaceAdvanceRequest, deepfakeFaceRequest);
        if (!Common.isUnset(deepfakeFaceAdvanceRequest.tasks)) {
            Integer numLtoi = 0;
            Iterator<DeepfakeFaceAdvanceRequest.DeepfakeFaceAdvanceRequestTasks> it = deepfakeFaceAdvanceRequest.tasks.iterator();
            while (it.hasNext()) {
                DeepfakeFaceAdvanceRequest.DeepfakeFaceAdvanceRequestTasks next = it.next();
                if (Common.isUnset(next.imageURLObject)) {
                    z = z2;
                } else {
                    AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
                    AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
                    configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
                    configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
                    z = false;
                    new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", next.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
                    deepfakeFaceRequest.tasks.get(numLtoi.intValue()).imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
                    numLtoi = com.aliyun.darabonbanumber.Client.ltoi(com.aliyun.darabonbanumber.Client.add(com.aliyun.darabonbanumber.Client.itol(numLtoi), com.aliyun.darabonbanumber.Client.itol(1)));
                }
                it = it;
                z2 = z;
                configBuild = configBuild;
            }
        }
        return deepfakeFaceWithOptions(deepfakeFaceRequest, runtimeOptions);
    }

    public DeepfakeFaceResponse deepfakeFaceWithOptions(DeepfakeFaceRequest deepfakeFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(deepfakeFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(deepfakeFaceRequest.tasks)) {
            map.put("Tasks", deepfakeFaceRequest.tasks);
        }
        return (DeepfakeFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DeepfakeFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DeepfakeFaceResponse());
    }

    public DeleteFaceResponse deleteFace(DeleteFaceRequest deleteFaceRequest) throws Exception {
        return deleteFaceWithOptions(deleteFaceRequest, new RuntimeOptions());
    }

    public DeleteFaceDbResponse deleteFaceDb(DeleteFaceDbRequest deleteFaceDbRequest) throws Exception {
        return deleteFaceDbWithOptions(deleteFaceDbRequest, new RuntimeOptions());
    }

    public DeleteFaceDbResponse deleteFaceDbWithOptions(DeleteFaceDbRequest deleteFaceDbRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(deleteFaceDbRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(deleteFaceDbRequest.name)) {
            map.put("Name", deleteFaceDbRequest.name);
        }
        return (DeleteFaceDbResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DeleteFaceDb"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DeleteFaceDbResponse());
    }

    public DeleteFaceEntityResponse deleteFaceEntity(DeleteFaceEntityRequest deleteFaceEntityRequest) throws Exception {
        return deleteFaceEntityWithOptions(deleteFaceEntityRequest, new RuntimeOptions());
    }

    public DeleteFaceEntityResponse deleteFaceEntityWithOptions(DeleteFaceEntityRequest deleteFaceEntityRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(deleteFaceEntityRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(deleteFaceEntityRequest.dbName)) {
            map.put("DbName", deleteFaceEntityRequest.dbName);
        }
        if (!Common.isUnset(deleteFaceEntityRequest.entityId)) {
            map.put("EntityId", deleteFaceEntityRequest.entityId);
        }
        return (DeleteFaceEntityResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DeleteFaceEntity"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DeleteFaceEntityResponse());
    }

    public DeleteFaceImageTemplateResponse deleteFaceImageTemplate(DeleteFaceImageTemplateRequest deleteFaceImageTemplateRequest) throws Exception {
        return deleteFaceImageTemplateWithOptions(deleteFaceImageTemplateRequest, new RuntimeOptions());
    }

    public DeleteFaceImageTemplateResponse deleteFaceImageTemplateWithOptions(DeleteFaceImageTemplateRequest deleteFaceImageTemplateRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(deleteFaceImageTemplateRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(deleteFaceImageTemplateRequest.templateId)) {
            map.put("TemplateId", deleteFaceImageTemplateRequest.templateId);
        }
        return (DeleteFaceImageTemplateResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DeleteFaceImageTemplate"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DeleteFaceImageTemplateResponse());
    }

    public DeleteFaceResponse deleteFaceWithOptions(DeleteFaceRequest deleteFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(deleteFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(deleteFaceRequest.dbName)) {
            map.put("DbName", deleteFaceRequest.dbName);
        }
        if (!Common.isUnset(deleteFaceRequest.faceId)) {
            map.put("FaceId", deleteFaceRequest.faceId);
        }
        return (DeleteFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DeleteFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DeleteFaceResponse());
    }

    public DetectBodyCountResponse detectBodyCount(DetectBodyCountRequest detectBodyCountRequest) throws Exception {
        return detectBodyCountWithOptions(detectBodyCountRequest, new RuntimeOptions());
    }

    public DetectBodyCountResponse detectBodyCountAdvance(DetectBodyCountAdvanceRequest detectBodyCountAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        DetectBodyCountRequest detectBodyCountRequest = new DetectBodyCountRequest();
        com.aliyun.openapiutil.Client.convert(detectBodyCountAdvanceRequest, detectBodyCountRequest);
        if (!Common.isUnset(detectBodyCountAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", detectBodyCountAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            detectBodyCountRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return detectBodyCountWithOptions(detectBodyCountRequest, runtimeOptions);
    }

    public DetectBodyCountResponse detectBodyCountWithOptions(DetectBodyCountRequest detectBodyCountRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(detectBodyCountRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(detectBodyCountRequest.imageURL)) {
            map.put("ImageURL", detectBodyCountRequest.imageURL);
        }
        return (DetectBodyCountResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DetectBodyCount"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DetectBodyCountResponse());
    }

    public DetectCelebrityResponse detectCelebrity(DetectCelebrityRequest detectCelebrityRequest) throws Exception {
        return detectCelebrityWithOptions(detectCelebrityRequest, new RuntimeOptions());
    }

    public DetectCelebrityResponse detectCelebrityAdvance(DetectCelebrityAdvanceRequest detectCelebrityAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        DetectCelebrityRequest detectCelebrityRequest = new DetectCelebrityRequest();
        com.aliyun.openapiutil.Client.convert(detectCelebrityAdvanceRequest, detectCelebrityRequest);
        if (!Common.isUnset(detectCelebrityAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", detectCelebrityAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            detectCelebrityRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return detectCelebrityWithOptions(detectCelebrityRequest, runtimeOptions);
    }

    public DetectCelebrityResponse detectCelebrityWithOptions(DetectCelebrityRequest detectCelebrityRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(detectCelebrityRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(detectCelebrityRequest.imageURL)) {
            map.put("ImageURL", detectCelebrityRequest.imageURL);
        }
        return (DetectCelebrityResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DetectCelebrity"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DetectCelebrityResponse());
    }

    public DetectChefCapResponse detectChefCap(DetectChefCapRequest detectChefCapRequest) throws Exception {
        return detectChefCapWithOptions(detectChefCapRequest, new RuntimeOptions());
    }

    public DetectChefCapResponse detectChefCapAdvance(DetectChefCapAdvanceRequest detectChefCapAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        DetectChefCapRequest detectChefCapRequest = new DetectChefCapRequest();
        com.aliyun.openapiutil.Client.convert(detectChefCapAdvanceRequest, detectChefCapRequest);
        if (!Common.isUnset(detectChefCapAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", detectChefCapAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            detectChefCapRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return detectChefCapWithOptions(detectChefCapRequest, runtimeOptions);
    }

    public DetectChefCapResponse detectChefCapWithOptions(DetectChefCapRequest detectChefCapRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(detectChefCapRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(detectChefCapRequest.imageURL)) {
            map.put("ImageURL", detectChefCapRequest.imageURL);
        }
        return (DetectChefCapResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DetectChefCap"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DetectChefCapResponse());
    }

    public DetectFaceResponse detectFace(DetectFaceRequest detectFaceRequest) throws Exception {
        return detectFaceWithOptions(detectFaceRequest, new RuntimeOptions());
    }

    public DetectFaceResponse detectFaceAdvance(DetectFaceAdvanceRequest detectFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        DetectFaceRequest detectFaceRequest = new DetectFaceRequest();
        com.aliyun.openapiutil.Client.convert(detectFaceAdvanceRequest, detectFaceRequest);
        if (!Common.isUnset(detectFaceAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", detectFaceAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            detectFaceRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return detectFaceWithOptions(detectFaceRequest, runtimeOptions);
    }

    public DetectFaceResponse detectFaceWithOptions(DetectFaceRequest detectFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(detectFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(detectFaceRequest.imageURL)) {
            map.put("ImageURL", detectFaceRequest.imageURL);
        }
        if (!Common.isUnset(detectFaceRequest.landmark)) {
            map.put("Landmark", detectFaceRequest.landmark);
        }
        if (!Common.isUnset(detectFaceRequest.maxFaceNumber)) {
            map.put("MaxFaceNumber", detectFaceRequest.maxFaceNumber);
        }
        if (!Common.isUnset(detectFaceRequest.pose)) {
            map.put("Pose", detectFaceRequest.pose);
        }
        if (!Common.isUnset(detectFaceRequest.quality)) {
            map.put("Quality", detectFaceRequest.quality);
        }
        return (DetectFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DetectFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DetectFaceResponse());
    }

    public DetectInfraredLivingFaceResponse detectInfraredLivingFace(DetectInfraredLivingFaceRequest detectInfraredLivingFaceRequest) throws Exception {
        return detectInfraredLivingFaceWithOptions(detectInfraredLivingFaceRequest, new RuntimeOptions());
    }

    public DetectInfraredLivingFaceResponse detectInfraredLivingFaceAdvance(DetectInfraredLivingFaceAdvanceRequest detectInfraredLivingFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        TeaPair teaPair = new TeaPair("accessKeyId", accessKeyId);
        boolean z2 = false;
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(teaPair, new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        DetectInfraredLivingFaceRequest detectInfraredLivingFaceRequest = new DetectInfraredLivingFaceRequest();
        com.aliyun.openapiutil.Client.convert(detectInfraredLivingFaceAdvanceRequest, detectInfraredLivingFaceRequest);
        if (!Common.isUnset(detectInfraredLivingFaceAdvanceRequest.tasks)) {
            Integer numLtoi = 0;
            Iterator<DetectInfraredLivingFaceAdvanceRequest.DetectInfraredLivingFaceAdvanceRequestTasks> it = detectInfraredLivingFaceAdvanceRequest.tasks.iterator();
            while (it.hasNext()) {
                DetectInfraredLivingFaceAdvanceRequest.DetectInfraredLivingFaceAdvanceRequestTasks next = it.next();
                if (Common.isUnset(next.imageURLObject)) {
                    z = z2;
                } else {
                    AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
                    AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
                    configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
                    configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
                    z = false;
                    new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", next.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
                    detectInfraredLivingFaceRequest.tasks.get(numLtoi.intValue()).imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
                    numLtoi = com.aliyun.darabonbanumber.Client.ltoi(com.aliyun.darabonbanumber.Client.add(com.aliyun.darabonbanumber.Client.itol(numLtoi), com.aliyun.darabonbanumber.Client.itol(1)));
                }
                it = it;
                z2 = z;
                configBuild = configBuild;
            }
        }
        return detectInfraredLivingFaceWithOptions(detectInfraredLivingFaceRequest, runtimeOptions);
    }

    public DetectInfraredLivingFaceResponse detectInfraredLivingFaceWithOptions(DetectInfraredLivingFaceRequest detectInfraredLivingFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(detectInfraredLivingFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(detectInfraredLivingFaceRequest.tasks)) {
            map.put("Tasks", detectInfraredLivingFaceRequest.tasks);
        }
        return (DetectInfraredLivingFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DetectInfraredLivingFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DetectInfraredLivingFaceResponse());
    }

    public DetectLivingFaceResponse detectLivingFace(DetectLivingFaceRequest detectLivingFaceRequest) throws Exception {
        return detectLivingFaceWithOptions(detectLivingFaceRequest, new RuntimeOptions());
    }

    public DetectLivingFaceResponse detectLivingFaceAdvance(DetectLivingFaceAdvanceRequest detectLivingFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        TeaPair teaPair = new TeaPair("accessKeyId", accessKeyId);
        boolean z2 = false;
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(teaPair, new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        DetectLivingFaceRequest detectLivingFaceRequest = new DetectLivingFaceRequest();
        com.aliyun.openapiutil.Client.convert(detectLivingFaceAdvanceRequest, detectLivingFaceRequest);
        if (!Common.isUnset(detectLivingFaceAdvanceRequest.tasks)) {
            Integer numLtoi = 0;
            Iterator<DetectLivingFaceAdvanceRequest.DetectLivingFaceAdvanceRequestTasks> it = detectLivingFaceAdvanceRequest.tasks.iterator();
            while (it.hasNext()) {
                DetectLivingFaceAdvanceRequest.DetectLivingFaceAdvanceRequestTasks next = it.next();
                if (Common.isUnset(next.imageURLObject)) {
                    z = z2;
                } else {
                    AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
                    AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
                    configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
                    configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
                    z = false;
                    new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", next.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
                    detectLivingFaceRequest.tasks.get(numLtoi.intValue()).imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
                    numLtoi = com.aliyun.darabonbanumber.Client.ltoi(com.aliyun.darabonbanumber.Client.add(com.aliyun.darabonbanumber.Client.itol(numLtoi), com.aliyun.darabonbanumber.Client.itol(1)));
                }
                it = it;
                z2 = z;
                configBuild = configBuild;
            }
        }
        return detectLivingFaceWithOptions(detectLivingFaceRequest, runtimeOptions);
    }

    public DetectLivingFaceResponse detectLivingFaceWithOptions(DetectLivingFaceRequest detectLivingFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(detectLivingFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(detectLivingFaceRequest.tasks)) {
            map.put("Tasks", detectLivingFaceRequest.tasks);
        }
        return (DetectLivingFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DetectLivingFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DetectLivingFaceResponse());
    }

    public DetectPedestrianResponse detectPedestrian(DetectPedestrianRequest detectPedestrianRequest) throws Exception {
        return detectPedestrianWithOptions(detectPedestrianRequest, new RuntimeOptions());
    }

    public DetectPedestrianResponse detectPedestrianAdvance(DetectPedestrianAdvanceRequest detectPedestrianAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        DetectPedestrianRequest detectPedestrianRequest = new DetectPedestrianRequest();
        com.aliyun.openapiutil.Client.convert(detectPedestrianAdvanceRequest, detectPedestrianRequest);
        if (!Common.isUnset(detectPedestrianAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", detectPedestrianAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            detectPedestrianRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return detectPedestrianWithOptions(detectPedestrianRequest, runtimeOptions);
    }

    public DetectPedestrianIntrusionResponse detectPedestrianIntrusion(DetectPedestrianIntrusionRequest detectPedestrianIntrusionRequest) throws Exception {
        return detectPedestrianIntrusionWithOptions(detectPedestrianIntrusionRequest, new RuntimeOptions());
    }

    public DetectPedestrianIntrusionResponse detectPedestrianIntrusionAdvance(DetectPedestrianIntrusionAdvanceRequest detectPedestrianIntrusionAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        DetectPedestrianIntrusionRequest detectPedestrianIntrusionRequest = new DetectPedestrianIntrusionRequest();
        com.aliyun.openapiutil.Client.convert(detectPedestrianIntrusionAdvanceRequest, detectPedestrianIntrusionRequest);
        if (!Common.isUnset(detectPedestrianIntrusionAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", detectPedestrianIntrusionAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            detectPedestrianIntrusionRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return detectPedestrianIntrusionWithOptions(detectPedestrianIntrusionRequest, runtimeOptions);
    }

    public DetectPedestrianIntrusionResponse detectPedestrianIntrusionWithOptions(DetectPedestrianIntrusionRequest detectPedestrianIntrusionRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(detectPedestrianIntrusionRequest);
        DetectPedestrianIntrusionShrinkRequest detectPedestrianIntrusionShrinkRequest = new DetectPedestrianIntrusionShrinkRequest();
        com.aliyun.openapiutil.Client.convert(detectPedestrianIntrusionRequest, detectPedestrianIntrusionShrinkRequest);
        if (!Common.isUnset(detectPedestrianIntrusionRequest.detectRegion)) {
            detectPedestrianIntrusionShrinkRequest.detectRegionShrink = com.aliyun.openapiutil.Client.arrayToStringWithSpecifiedStyle(detectPedestrianIntrusionRequest.detectRegion, "DetectRegion", "json");
        }
        HashMap map = new HashMap();
        if (!Common.isUnset(detectPedestrianIntrusionShrinkRequest.detectRegionShrink)) {
            map.put("DetectRegion", detectPedestrianIntrusionShrinkRequest.detectRegionShrink);
        }
        if (!Common.isUnset(detectPedestrianIntrusionShrinkRequest.imageURL)) {
            map.put("ImageURL", detectPedestrianIntrusionShrinkRequest.imageURL);
        }
        if (!Common.isUnset(detectPedestrianIntrusionShrinkRequest.regionType)) {
            map.put("RegionType", detectPedestrianIntrusionShrinkRequest.regionType);
        }
        return (DetectPedestrianIntrusionResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DetectPedestrianIntrusion"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DetectPedestrianIntrusionResponse());
    }

    public DetectPedestrianResponse detectPedestrianWithOptions(DetectPedestrianRequest detectPedestrianRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(detectPedestrianRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(detectPedestrianRequest.imageURL)) {
            map.put("ImageURL", detectPedestrianRequest.imageURL);
        }
        return (DetectPedestrianResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DetectPedestrian"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DetectPedestrianResponse());
    }

    public DetectVideoLivingFaceResponse detectVideoLivingFace(DetectVideoLivingFaceRequest detectVideoLivingFaceRequest) throws Exception {
        return detectVideoLivingFaceWithOptions(detectVideoLivingFaceRequest, new RuntimeOptions());
    }

    public DetectVideoLivingFaceResponse detectVideoLivingFaceAdvance(DetectVideoLivingFaceAdvanceRequest detectVideoLivingFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        DetectVideoLivingFaceRequest detectVideoLivingFaceRequest = new DetectVideoLivingFaceRequest();
        com.aliyun.openapiutil.Client.convert(detectVideoLivingFaceAdvanceRequest, detectVideoLivingFaceRequest);
        if (!Common.isUnset(detectVideoLivingFaceAdvanceRequest.videoUrlObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", detectVideoLivingFaceAdvanceRequest.videoUrlObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            detectVideoLivingFaceRequest.videoUrl = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return detectVideoLivingFaceWithOptions(detectVideoLivingFaceRequest, runtimeOptions);
    }

    public DetectVideoLivingFaceResponse detectVideoLivingFaceWithOptions(DetectVideoLivingFaceRequest detectVideoLivingFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(detectVideoLivingFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(detectVideoLivingFaceRequest.videoUrl)) {
            map.put("VideoUrl", detectVideoLivingFaceRequest.videoUrl);
        }
        return (DetectVideoLivingFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "DetectVideoLivingFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new DetectVideoLivingFaceResponse());
    }

    public EnhanceFaceResponse enhanceFace(EnhanceFaceRequest enhanceFaceRequest) throws Exception {
        return enhanceFaceWithOptions(enhanceFaceRequest, new RuntimeOptions());
    }

    public EnhanceFaceResponse enhanceFaceAdvance(EnhanceFaceAdvanceRequest enhanceFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        EnhanceFaceRequest enhanceFaceRequest = new EnhanceFaceRequest();
        com.aliyun.openapiutil.Client.convert(enhanceFaceAdvanceRequest, enhanceFaceRequest);
        if (!Common.isUnset(enhanceFaceAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", enhanceFaceAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            enhanceFaceRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return enhanceFaceWithOptions(enhanceFaceRequest, runtimeOptions);
    }

    public EnhanceFaceResponse enhanceFaceWithOptions(EnhanceFaceRequest enhanceFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(enhanceFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(enhanceFaceRequest.imageURL)) {
            map.put("ImageURL", enhanceFaceRequest.imageURL);
        }
        return (EnhanceFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "EnhanceFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new EnhanceFaceResponse());
    }

    public ExtractFingerPrintResponse extractFingerPrint(ExtractFingerPrintRequest extractFingerPrintRequest) throws Exception {
        return extractFingerPrintWithOptions(extractFingerPrintRequest, new RuntimeOptions());
    }

    public ExtractFingerPrintResponse extractFingerPrintAdvance(ExtractFingerPrintAdvanceRequest extractFingerPrintAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        ExtractFingerPrintRequest extractFingerPrintRequest = new ExtractFingerPrintRequest();
        com.aliyun.openapiutil.Client.convert(extractFingerPrintAdvanceRequest, extractFingerPrintRequest);
        if (!Common.isUnset(extractFingerPrintAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", extractFingerPrintAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            extractFingerPrintRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return extractFingerPrintWithOptions(extractFingerPrintRequest, runtimeOptions);
    }

    public ExtractFingerPrintResponse extractFingerPrintWithOptions(ExtractFingerPrintRequest extractFingerPrintRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(extractFingerPrintRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(extractFingerPrintRequest.imageData)) {
            map.put("ImageData", extractFingerPrintRequest.imageData);
        }
        if (!Common.isUnset(extractFingerPrintRequest.imageURL)) {
            map.put("ImageURL", extractFingerPrintRequest.imageURL);
        }
        return (ExtractFingerPrintResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "ExtractFingerPrint"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new ExtractFingerPrintResponse());
    }

    public ExtractPedestrianFeatureAttrResponse extractPedestrianFeatureAttr(ExtractPedestrianFeatureAttrRequest extractPedestrianFeatureAttrRequest) throws Exception {
        return extractPedestrianFeatureAttrWithOptions(extractPedestrianFeatureAttrRequest, new RuntimeOptions());
    }

    public ExtractPedestrianFeatureAttrResponse extractPedestrianFeatureAttrAdvance(ExtractPedestrianFeatureAttrAdvanceRequest extractPedestrianFeatureAttrAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        ExtractPedestrianFeatureAttrRequest extractPedestrianFeatureAttrRequest = new ExtractPedestrianFeatureAttrRequest();
        com.aliyun.openapiutil.Client.convert(extractPedestrianFeatureAttrAdvanceRequest, extractPedestrianFeatureAttrRequest);
        if (!Common.isUnset(extractPedestrianFeatureAttrAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", extractPedestrianFeatureAttrAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            extractPedestrianFeatureAttrRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return extractPedestrianFeatureAttrWithOptions(extractPedestrianFeatureAttrRequest, runtimeOptions);
    }

    public ExtractPedestrianFeatureAttrResponse extractPedestrianFeatureAttrWithOptions(ExtractPedestrianFeatureAttrRequest extractPedestrianFeatureAttrRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(extractPedestrianFeatureAttrRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(extractPedestrianFeatureAttrRequest.imageURL)) {
            map.put("ImageURL", extractPedestrianFeatureAttrRequest.imageURL);
        }
        if (!Common.isUnset(extractPedestrianFeatureAttrRequest.mode)) {
            map.put("Mode", extractPedestrianFeatureAttrRequest.mode);
        }
        if (!Common.isUnset(extractPedestrianFeatureAttrRequest.serviceVersion)) {
            map.put("ServiceVersion", extractPedestrianFeatureAttrRequest.serviceVersion);
        }
        return (ExtractPedestrianFeatureAttrResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "ExtractPedestrianFeatureAttr"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new ExtractPedestrianFeatureAttrResponse());
    }

    public FaceBeautyResponse faceBeauty(FaceBeautyRequest faceBeautyRequest) throws Exception {
        return faceBeautyWithOptions(faceBeautyRequest, new RuntimeOptions());
    }

    public FaceBeautyResponse faceBeautyAdvance(FaceBeautyAdvanceRequest faceBeautyAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        FaceBeautyRequest faceBeautyRequest = new FaceBeautyRequest();
        com.aliyun.openapiutil.Client.convert(faceBeautyAdvanceRequest, faceBeautyRequest);
        if (!Common.isUnset(faceBeautyAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", faceBeautyAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            faceBeautyRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return faceBeautyWithOptions(faceBeautyRequest, runtimeOptions);
    }

    public FaceBeautyResponse faceBeautyWithOptions(FaceBeautyRequest faceBeautyRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(faceBeautyRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(faceBeautyRequest.imageURL)) {
            map.put("ImageURL", faceBeautyRequest.imageURL);
        }
        if (!Common.isUnset(faceBeautyRequest.sharp)) {
            map.put("Sharp", faceBeautyRequest.sharp);
        }
        if (!Common.isUnset(faceBeautyRequest.smooth)) {
            map.put("Smooth", faceBeautyRequest.smooth);
        }
        if (!Common.isUnset(faceBeautyRequest.white)) {
            map.put("White", faceBeautyRequest.white);
        }
        return (FaceBeautyResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "FaceBeauty"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new FaceBeautyResponse());
    }

    public FaceFilterResponse faceFilter(FaceFilterRequest faceFilterRequest) throws Exception {
        return faceFilterWithOptions(faceFilterRequest, new RuntimeOptions());
    }

    public FaceFilterResponse faceFilterAdvance(FaceFilterAdvanceRequest faceFilterAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        FaceFilterRequest faceFilterRequest = new FaceFilterRequest();
        com.aliyun.openapiutil.Client.convert(faceFilterAdvanceRequest, faceFilterRequest);
        if (!Common.isUnset(faceFilterAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", faceFilterAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            faceFilterRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return faceFilterWithOptions(faceFilterRequest, runtimeOptions);
    }

    public FaceFilterResponse faceFilterWithOptions(FaceFilterRequest faceFilterRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(faceFilterRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(faceFilterRequest.imageURL)) {
            map.put("ImageURL", faceFilterRequest.imageURL);
        }
        if (!Common.isUnset(faceFilterRequest.resourceType)) {
            map.put("ResourceType", faceFilterRequest.resourceType);
        }
        if (!Common.isUnset(faceFilterRequest.strength)) {
            map.put("Strength", faceFilterRequest.strength);
        }
        return (FaceFilterResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "FaceFilter"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new FaceFilterResponse());
    }

    public FaceMakeupResponse faceMakeup(FaceMakeupRequest faceMakeupRequest) throws Exception {
        return faceMakeupWithOptions(faceMakeupRequest, new RuntimeOptions());
    }

    public FaceMakeupResponse faceMakeupAdvance(FaceMakeupAdvanceRequest faceMakeupAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        FaceMakeupRequest faceMakeupRequest = new FaceMakeupRequest();
        com.aliyun.openapiutil.Client.convert(faceMakeupAdvanceRequest, faceMakeupRequest);
        if (!Common.isUnset(faceMakeupAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", faceMakeupAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            faceMakeupRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return faceMakeupWithOptions(faceMakeupRequest, runtimeOptions);
    }

    public FaceMakeupResponse faceMakeupWithOptions(FaceMakeupRequest faceMakeupRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(faceMakeupRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(faceMakeupRequest.imageURL)) {
            map.put("ImageURL", faceMakeupRequest.imageURL);
        }
        if (!Common.isUnset(faceMakeupRequest.makeupType)) {
            map.put("MakeupType", faceMakeupRequest.makeupType);
        }
        if (!Common.isUnset(faceMakeupRequest.resourceType)) {
            map.put("ResourceType", faceMakeupRequest.resourceType);
        }
        if (!Common.isUnset(faceMakeupRequest.strength)) {
            map.put("Strength", faceMakeupRequest.strength);
        }
        return (FaceMakeupResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "FaceMakeup"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new FaceMakeupResponse());
    }

    public FaceTidyupResponse faceTidyup(FaceTidyupRequest faceTidyupRequest) throws Exception {
        return faceTidyupWithOptions(faceTidyupRequest, new RuntimeOptions());
    }

    public FaceTidyupResponse faceTidyupAdvance(FaceTidyupAdvanceRequest faceTidyupAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        FaceTidyupRequest faceTidyupRequest = new FaceTidyupRequest();
        com.aliyun.openapiutil.Client.convert(faceTidyupAdvanceRequest, faceTidyupRequest);
        if (!Common.isUnset(faceTidyupAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", faceTidyupAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            faceTidyupRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return faceTidyupWithOptions(faceTidyupRequest, runtimeOptions);
    }

    public FaceTidyupResponse faceTidyupWithOptions(FaceTidyupRequest faceTidyupRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(faceTidyupRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(faceTidyupRequest.imageURL)) {
            map.put("ImageURL", faceTidyupRequest.imageURL);
        }
        if (!Common.isUnset(faceTidyupRequest.shapeType)) {
            map.put("ShapeType", faceTidyupRequest.shapeType);
        }
        if (!Common.isUnset(faceTidyupRequest.strength)) {
            map.put("Strength", faceTidyupRequest.strength);
        }
        return (FaceTidyupResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "FaceTidyup"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new FaceTidyupResponse());
    }

    public GenRealPersonVerificationTokenResponse genRealPersonVerificationToken(GenRealPersonVerificationTokenRequest genRealPersonVerificationTokenRequest) throws Exception {
        return genRealPersonVerificationTokenWithOptions(genRealPersonVerificationTokenRequest, new RuntimeOptions());
    }

    public GenRealPersonVerificationTokenResponse genRealPersonVerificationTokenWithOptions(GenRealPersonVerificationTokenRequest genRealPersonVerificationTokenRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(genRealPersonVerificationTokenRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(genRealPersonVerificationTokenRequest.certificateName)) {
            map.put("CertificateName", genRealPersonVerificationTokenRequest.certificateName);
        }
        if (!Common.isUnset(genRealPersonVerificationTokenRequest.certificateNumber)) {
            map.put("CertificateNumber", genRealPersonVerificationTokenRequest.certificateNumber);
        }
        if (!Common.isUnset(genRealPersonVerificationTokenRequest.metaInfo)) {
            map.put("MetaInfo", genRealPersonVerificationTokenRequest.metaInfo);
        }
        return (GenRealPersonVerificationTokenResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "GenRealPersonVerificationToken"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new GenRealPersonVerificationTokenResponse());
    }

    public GenerateHumanAnimeStyleResponse generateHumanAnimeStyle(GenerateHumanAnimeStyleRequest generateHumanAnimeStyleRequest) throws Exception {
        return generateHumanAnimeStyleWithOptions(generateHumanAnimeStyleRequest, new RuntimeOptions());
    }

    public GenerateHumanAnimeStyleResponse generateHumanAnimeStyleAdvance(GenerateHumanAnimeStyleAdvanceRequest generateHumanAnimeStyleAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        GenerateHumanAnimeStyleRequest generateHumanAnimeStyleRequest = new GenerateHumanAnimeStyleRequest();
        com.aliyun.openapiutil.Client.convert(generateHumanAnimeStyleAdvanceRequest, generateHumanAnimeStyleRequest);
        if (!Common.isUnset(generateHumanAnimeStyleAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", generateHumanAnimeStyleAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            generateHumanAnimeStyleRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return generateHumanAnimeStyleWithOptions(generateHumanAnimeStyleRequest, runtimeOptions);
    }

    public GenerateHumanAnimeStyleResponse generateHumanAnimeStyleWithOptions(GenerateHumanAnimeStyleRequest generateHumanAnimeStyleRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(generateHumanAnimeStyleRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(generateHumanAnimeStyleRequest.algoType)) {
            map.put("AlgoType", generateHumanAnimeStyleRequest.algoType);
        }
        if (!Common.isUnset(generateHumanAnimeStyleRequest.imageURL)) {
            map.put("ImageURL", generateHumanAnimeStyleRequest.imageURL);
        }
        return (GenerateHumanAnimeStyleResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "GenerateHumanAnimeStyle"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("query", com.aliyun.openapiutil.Client.query(map)))), runtimeOptions), new GenerateHumanAnimeStyleResponse());
    }

    public GenerateHumanSketchStyleResponse generateHumanSketchStyle(GenerateHumanSketchStyleRequest generateHumanSketchStyleRequest) throws Exception {
        return generateHumanSketchStyleWithOptions(generateHumanSketchStyleRequest, new RuntimeOptions());
    }

    public GenerateHumanSketchStyleResponse generateHumanSketchStyleAdvance(GenerateHumanSketchStyleAdvanceRequest generateHumanSketchStyleAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        GenerateHumanSketchStyleRequest generateHumanSketchStyleRequest = new GenerateHumanSketchStyleRequest();
        com.aliyun.openapiutil.Client.convert(generateHumanSketchStyleAdvanceRequest, generateHumanSketchStyleRequest);
        if (!Common.isUnset(generateHumanSketchStyleAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", generateHumanSketchStyleAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            generateHumanSketchStyleRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return generateHumanSketchStyleWithOptions(generateHumanSketchStyleRequest, runtimeOptions);
    }

    public GenerateHumanSketchStyleResponse generateHumanSketchStyleWithOptions(GenerateHumanSketchStyleRequest generateHumanSketchStyleRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(generateHumanSketchStyleRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(generateHumanSketchStyleRequest.imageURL)) {
            map.put("ImageURL", generateHumanSketchStyleRequest.imageURL);
        }
        if (!Common.isUnset(generateHumanSketchStyleRequest.returnType)) {
            map.put("ReturnType", generateHumanSketchStyleRequest.returnType);
        }
        return (GenerateHumanSketchStyleResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "GenerateHumanSketchStyle"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new GenerateHumanSketchStyleResponse());
    }

    public String getEndpoint(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6) throws Exception {
        if (Common.empty(str6)) {
            return (Common.isUnset(map) || Common.empty(map.get(str2))) ? com.aliyun.endpointutil.Client.getEndpointRules(str, str2, str3, str4, str5) : map.get(str2);
        }
        return str6;
    }

    public GetFaceEntityResponse getFaceEntity(GetFaceEntityRequest getFaceEntityRequest) throws Exception {
        return getFaceEntityWithOptions(getFaceEntityRequest, new RuntimeOptions());
    }

    public GetFaceEntityResponse getFaceEntityWithOptions(GetFaceEntityRequest getFaceEntityRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(getFaceEntityRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(getFaceEntityRequest.dbName)) {
            map.put("DbName", getFaceEntityRequest.dbName);
        }
        if (!Common.isUnset(getFaceEntityRequest.entityId)) {
            map.put("EntityId", getFaceEntityRequest.entityId);
        }
        return (GetFaceEntityResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "GetFaceEntity"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new GetFaceEntityResponse());
    }

    public GetRealPersonVerificationResultResponse getRealPersonVerificationResult(GetRealPersonVerificationResultRequest getRealPersonVerificationResultRequest) throws Exception {
        return getRealPersonVerificationResultWithOptions(getRealPersonVerificationResultRequest, new RuntimeOptions());
    }

    public GetRealPersonVerificationResultResponse getRealPersonVerificationResultWithOptions(GetRealPersonVerificationResultRequest getRealPersonVerificationResultRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(getRealPersonVerificationResultRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(getRealPersonVerificationResultRequest.verificationToken)) {
            map.put("VerificationToken", getRealPersonVerificationResultRequest.verificationToken);
        }
        return (GetRealPersonVerificationResultResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "GetRealPersonVerificationResult"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new GetRealPersonVerificationResultResponse());
    }

    public HandPostureResponse handPosture(HandPostureRequest handPostureRequest) throws Exception {
        return handPostureWithOptions(handPostureRequest, new RuntimeOptions());
    }

    public HandPostureResponse handPostureAdvance(HandPostureAdvanceRequest handPostureAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        HandPostureRequest handPostureRequest = new HandPostureRequest();
        com.aliyun.openapiutil.Client.convert(handPostureAdvanceRequest, handPostureRequest);
        if (!Common.isUnset(handPostureAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", handPostureAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            handPostureRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return handPostureWithOptions(handPostureRequest, runtimeOptions);
    }

    public HandPostureResponse handPostureWithOptions(HandPostureRequest handPostureRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(handPostureRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(handPostureRequest.imageURL)) {
            map.put("ImageURL", handPostureRequest.imageURL);
        }
        return (HandPostureResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "HandPosture"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new HandPostureResponse());
    }

    public LiquifyFaceResponse liquifyFace(LiquifyFaceRequest liquifyFaceRequest) throws Exception {
        return liquifyFaceWithOptions(liquifyFaceRequest, new RuntimeOptions());
    }

    public LiquifyFaceResponse liquifyFaceAdvance(LiquifyFaceAdvanceRequest liquifyFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        LiquifyFaceRequest liquifyFaceRequest = new LiquifyFaceRequest();
        com.aliyun.openapiutil.Client.convert(liquifyFaceAdvanceRequest, liquifyFaceRequest);
        if (!Common.isUnset(liquifyFaceAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", liquifyFaceAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            liquifyFaceRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return liquifyFaceWithOptions(liquifyFaceRequest, runtimeOptions);
    }

    public LiquifyFaceResponse liquifyFaceWithOptions(LiquifyFaceRequest liquifyFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(liquifyFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(liquifyFaceRequest.imageURL)) {
            map.put("ImageURL", liquifyFaceRequest.imageURL);
        }
        if (!Common.isUnset(liquifyFaceRequest.slimDegree)) {
            map.put("SlimDegree", liquifyFaceRequest.slimDegree);
        }
        return (LiquifyFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "LiquifyFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new LiquifyFaceResponse());
    }

    public ListFaceDbsResponse listFaceDbs(ListFaceDbsRequest listFaceDbsRequest) throws Exception {
        return listFaceDbsWithOptions(listFaceDbsRequest, new RuntimeOptions());
    }

    public ListFaceDbsResponse listFaceDbsWithOptions(ListFaceDbsRequest listFaceDbsRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(listFaceDbsRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(listFaceDbsRequest.limit)) {
            map.put("Limit", listFaceDbsRequest.limit);
        }
        if (!Common.isUnset(listFaceDbsRequest.offset)) {
            map.put("Offset", listFaceDbsRequest.offset);
        }
        return (ListFaceDbsResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "ListFaceDbs"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new ListFaceDbsResponse());
    }

    public ListFaceEntitiesResponse listFaceEntities(ListFaceEntitiesRequest listFaceEntitiesRequest) throws Exception {
        return listFaceEntitiesWithOptions(listFaceEntitiesRequest, new RuntimeOptions());
    }

    public ListFaceEntitiesResponse listFaceEntitiesWithOptions(ListFaceEntitiesRequest listFaceEntitiesRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(listFaceEntitiesRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(listFaceEntitiesRequest.dbName)) {
            map.put("DbName", listFaceEntitiesRequest.dbName);
        }
        if (!Common.isUnset(listFaceEntitiesRequest.entityIdPrefix)) {
            map.put("EntityIdPrefix", listFaceEntitiesRequest.entityIdPrefix);
        }
        if (!Common.isUnset(listFaceEntitiesRequest.labels)) {
            map.put("Labels", listFaceEntitiesRequest.labels);
        }
        if (!Common.isUnset(listFaceEntitiesRequest.limit)) {
            map.put("Limit", listFaceEntitiesRequest.limit);
        }
        if (!Common.isUnset(listFaceEntitiesRequest.offset)) {
            map.put("Offset", listFaceEntitiesRequest.offset);
        }
        if (!Common.isUnset(listFaceEntitiesRequest.order)) {
            map.put("Order", listFaceEntitiesRequest.order);
        }
        if (!Common.isUnset(listFaceEntitiesRequest.token)) {
            map.put("Token", listFaceEntitiesRequest.token);
        }
        return (ListFaceEntitiesResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "ListFaceEntities"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new ListFaceEntitiesResponse());
    }

    public MergeImageFaceResponse mergeImageFace(MergeImageFaceRequest mergeImageFaceRequest) throws Exception {
        return mergeImageFaceWithOptions(mergeImageFaceRequest, new RuntimeOptions());
    }

    public MergeImageFaceResponse mergeImageFaceAdvance(MergeImageFaceAdvanceRequest mergeImageFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        MergeImageFaceRequest mergeImageFaceRequest = new MergeImageFaceRequest();
        com.aliyun.openapiutil.Client.convert(mergeImageFaceAdvanceRequest, mergeImageFaceRequest);
        if (!Common.isUnset(mergeImageFaceAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", mergeImageFaceAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            mergeImageFaceRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return mergeImageFaceWithOptions(mergeImageFaceRequest, runtimeOptions);
    }

    public MergeImageFaceResponse mergeImageFaceWithOptions(MergeImageFaceRequest mergeImageFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(mergeImageFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(mergeImageFaceRequest.addWatermark)) {
            map.put("AddWatermark", mergeImageFaceRequest.addWatermark);
        }
        if (!Common.isUnset(mergeImageFaceRequest.imageURL)) {
            map.put("ImageURL", mergeImageFaceRequest.imageURL);
        }
        if (!Common.isUnset(mergeImageFaceRequest.mergeInfos)) {
            map.put("MergeInfos", mergeImageFaceRequest.mergeInfos);
        }
        if (!Common.isUnset(mergeImageFaceRequest.modelVersion)) {
            map.put("ModelVersion", mergeImageFaceRequest.modelVersion);
        }
        if (!Common.isUnset(mergeImageFaceRequest.templateId)) {
            map.put("TemplateId", mergeImageFaceRequest.templateId);
        }
        if (!Common.isUnset(mergeImageFaceRequest.watermarkType)) {
            map.put("WatermarkType", mergeImageFaceRequest.watermarkType);
        }
        return (MergeImageFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "MergeImageFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new MergeImageFaceResponse());
    }

    public MonitorExaminationResponse monitorExamination(MonitorExaminationRequest monitorExaminationRequest) throws Exception {
        return monitorExaminationWithOptions(monitorExaminationRequest, new RuntimeOptions());
    }

    public MonitorExaminationResponse monitorExaminationAdvance(MonitorExaminationAdvanceRequest monitorExaminationAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        MonitorExaminationRequest monitorExaminationRequest = new MonitorExaminationRequest();
        com.aliyun.openapiutil.Client.convert(monitorExaminationAdvanceRequest, monitorExaminationRequest);
        if (!Common.isUnset(monitorExaminationAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", monitorExaminationAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            monitorExaminationRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return monitorExaminationWithOptions(monitorExaminationRequest, runtimeOptions);
    }

    public MonitorExaminationResponse monitorExaminationWithOptions(MonitorExaminationRequest monitorExaminationRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(monitorExaminationRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(monitorExaminationRequest.imageURL)) {
            map.put("ImageURL", monitorExaminationRequest.imageURL);
        }
        if (!Common.isUnset(monitorExaminationRequest.type)) {
            map.put("Type", monitorExaminationRequest.type);
        }
        return (MonitorExaminationResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "MonitorExamination"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new MonitorExaminationResponse());
    }

    public PedestrianDetectAttributeResponse pedestrianDetectAttribute(PedestrianDetectAttributeRequest pedestrianDetectAttributeRequest) throws Exception {
        return pedestrianDetectAttributeWithOptions(pedestrianDetectAttributeRequest, new RuntimeOptions());
    }

    public PedestrianDetectAttributeResponse pedestrianDetectAttributeAdvance(PedestrianDetectAttributeAdvanceRequest pedestrianDetectAttributeAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        PedestrianDetectAttributeRequest pedestrianDetectAttributeRequest = new PedestrianDetectAttributeRequest();
        com.aliyun.openapiutil.Client.convert(pedestrianDetectAttributeAdvanceRequest, pedestrianDetectAttributeRequest);
        if (!Common.isUnset(pedestrianDetectAttributeAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", pedestrianDetectAttributeAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            pedestrianDetectAttributeRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return pedestrianDetectAttributeWithOptions(pedestrianDetectAttributeRequest, runtimeOptions);
    }

    public PedestrianDetectAttributeResponse pedestrianDetectAttributeWithOptions(PedestrianDetectAttributeRequest pedestrianDetectAttributeRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(pedestrianDetectAttributeRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(pedestrianDetectAttributeRequest.imageURL)) {
            map.put("ImageURL", pedestrianDetectAttributeRequest.imageURL);
        }
        return (PedestrianDetectAttributeResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "PedestrianDetectAttribute"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new PedestrianDetectAttributeResponse());
    }

    public QueryFaceImageTemplateResponse queryFaceImageTemplate(QueryFaceImageTemplateRequest queryFaceImageTemplateRequest) throws Exception {
        return queryFaceImageTemplateWithOptions(queryFaceImageTemplateRequest, new RuntimeOptions());
    }

    public QueryFaceImageTemplateResponse queryFaceImageTemplateWithOptions(QueryFaceImageTemplateRequest queryFaceImageTemplateRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(queryFaceImageTemplateRequest);
        return (QueryFaceImageTemplateResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "QueryFaceImageTemplate"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "GET"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("query", com.aliyun.openapiutil.Client.query(com.aliyun.openapiutil.Client.query(Common.toMap(queryFaceImageTemplateRequest)))))), runtimeOptions), new QueryFaceImageTemplateResponse());
    }

    public RecognizeActionResponse recognizeAction(RecognizeActionRequest recognizeActionRequest) throws Exception {
        return recognizeActionWithOptions(recognizeActionRequest, new RuntimeOptions());
    }

    public RecognizeActionResponse recognizeActionAdvance(RecognizeActionAdvanceRequest recognizeActionAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        RecognizeActionRequest recognizeActionRequest;
        Client client;
        RecognizeActionRequest recognizeActionRequest2;
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2;
        Client client2 = this;
        RuntimeOptions runtimeOptions3 = runtimeOptions;
        String accessKeyId = client2._credential.getAccessKeyId();
        String accessKeySecret = client2._credential.getAccessKeySecret();
        String securityToken = client2._credential.getSecurityToken();
        String type = client2._credential.getType();
        String str = client2._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client3 = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", client2._protocol), new TeaPair("regionId", client2._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", client2._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", client2._protocol), new TeaPair("regionId", client2._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions4 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions3, runtimeOptions4);
        RecognizeActionRequest recognizeActionRequest3 = new RecognizeActionRequest();
        com.aliyun.openapiutil.Client.convert(recognizeActionAdvanceRequest, recognizeActionRequest3);
        String str2 = "file";
        RecognizeActionRequest recognizeActionRequest4 = recognizeActionRequest3;
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions5 = runtimeOptions4;
        if (!Common.isUnset(recognizeActionAdvanceRequest.URLList)) {
            Integer numLtoi = 0;
            Iterator<RecognizeActionAdvanceRequest.RecognizeActionAdvanceRequestURLList> it = recognizeActionAdvanceRequest.URLList.iterator();
            while (it.hasNext()) {
                Iterator<RecognizeActionAdvanceRequest.RecognizeActionAdvanceRequestURLList> it2 = it;
                RecognizeActionAdvanceRequest.RecognizeActionAdvanceRequestURLList next = it.next();
                if (Common.isUnset(next.URLObject)) {
                    recognizeActionRequest2 = recognizeActionRequest4;
                    runtimeOptions2 = runtimeOptions5;
                } else {
                    AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client3.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions3);
                    AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
                    configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
                    configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), client2._endpointType);
                    runtimeOptions2 = runtimeOptions5;
                    new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair(str2, FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", next.URLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
                    recognizeActionRequest2 = recognizeActionRequest4;
                    recognizeActionRequest2.URLList.get(numLtoi.intValue()).URL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
                    numLtoi = com.aliyun.darabonbanumber.Client.ltoi(com.aliyun.darabonbanumber.Client.add(com.aliyun.darabonbanumber.Client.itol(numLtoi), com.aliyun.darabonbanumber.Client.itol(1)));
                }
                runtimeOptions3 = runtimeOptions;
                recognizeActionRequest4 = recognizeActionRequest2;
                runtimeOptions5 = runtimeOptions2;
                authorizeFileUploadRequestBuild = authorizeFileUploadRequestBuild;
                it = it2;
                client3 = client3;
                str2 = str2;
                client2 = this;
            }
        }
        AuthorizeFileUploadRequest authorizeFileUploadRequest = authorizeFileUploadRequestBuild;
        com.aliyun.openplatform20191219.Client client4 = client3;
        String str3 = str2;
        RecognizeActionRequest recognizeActionRequest5 = recognizeActionRequest4;
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions6 = runtimeOptions5;
        if (Common.isUnset(recognizeActionAdvanceRequest.videoUrlObject)) {
            recognizeActionRequest = recognizeActionRequest5;
            client = this;
        } else {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions2 = client4.authorizeFileUploadWithOptions(authorizeFileUploadRequest, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody2 = authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody2.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody2.endpoint, authorizeFileUploadResponseBody2.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.objectKey), new TeaPair(str3, FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.objectKey), new TeaPair("content", recognizeActionAdvanceRequest.videoUrlObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions6);
            recognizeActionRequest = recognizeActionRequest5;
            recognizeActionRequest.videoUrl = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.objectKey + "";
            client = this;
        }
        return client.recognizeActionWithOptions(recognizeActionRequest, runtimeOptions);
    }

    public RecognizeActionResponse recognizeActionWithOptions(RecognizeActionRequest recognizeActionRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(recognizeActionRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(recognizeActionRequest.type)) {
            map.put("Type", recognizeActionRequest.type);
        }
        if (!Common.isUnset(recognizeActionRequest.URLList)) {
            map.put("URLList", recognizeActionRequest.URLList);
        }
        if (!Common.isUnset(recognizeActionRequest.videoData)) {
            map.put("VideoData", recognizeActionRequest.videoData);
        }
        if (!Common.isUnset(recognizeActionRequest.videoUrl)) {
            map.put("VideoUrl", recognizeActionRequest.videoUrl);
        }
        return (RecognizeActionResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "RecognizeAction"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new RecognizeActionResponse());
    }

    public RecognizeExpressionResponse recognizeExpression(RecognizeExpressionRequest recognizeExpressionRequest) throws Exception {
        return recognizeExpressionWithOptions(recognizeExpressionRequest, new RuntimeOptions());
    }

    public RecognizeExpressionResponse recognizeExpressionAdvance(RecognizeExpressionAdvanceRequest recognizeExpressionAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        RecognizeExpressionRequest recognizeExpressionRequest = new RecognizeExpressionRequest();
        com.aliyun.openapiutil.Client.convert(recognizeExpressionAdvanceRequest, recognizeExpressionRequest);
        if (!Common.isUnset(recognizeExpressionAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", recognizeExpressionAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            recognizeExpressionRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return recognizeExpressionWithOptions(recognizeExpressionRequest, runtimeOptions);
    }

    public RecognizeExpressionResponse recognizeExpressionWithOptions(RecognizeExpressionRequest recognizeExpressionRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(recognizeExpressionRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(recognizeExpressionRequest.imageURL)) {
            map.put("ImageURL", recognizeExpressionRequest.imageURL);
        }
        return (RecognizeExpressionResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "RecognizeExpression"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new RecognizeExpressionResponse());
    }

    public RecognizeFaceResponse recognizeFace(RecognizeFaceRequest recognizeFaceRequest) throws Exception {
        return recognizeFaceWithOptions(recognizeFaceRequest, new RuntimeOptions());
    }

    public RecognizeFaceResponse recognizeFaceAdvance(RecognizeFaceAdvanceRequest recognizeFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        RecognizeFaceRequest recognizeFaceRequest = new RecognizeFaceRequest();
        com.aliyun.openapiutil.Client.convert(recognizeFaceAdvanceRequest, recognizeFaceRequest);
        if (!Common.isUnset(recognizeFaceAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", recognizeFaceAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            recognizeFaceRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return recognizeFaceWithOptions(recognizeFaceRequest, runtimeOptions);
    }

    public RecognizeFaceResponse recognizeFaceWithOptions(RecognizeFaceRequest recognizeFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(recognizeFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(recognizeFaceRequest.age)) {
            map.put(b.X, recognizeFaceRequest.age);
        }
        if (!Common.isUnset(recognizeFaceRequest.beauty)) {
            map.put("Beauty", recognizeFaceRequest.beauty);
        }
        if (!Common.isUnset(recognizeFaceRequest.expression)) {
            map.put("Expression", recognizeFaceRequest.expression);
        }
        if (!Common.isUnset(recognizeFaceRequest.gender)) {
            map.put("Gender", recognizeFaceRequest.gender);
        }
        if (!Common.isUnset(recognizeFaceRequest.glass)) {
            map.put("Glass", recognizeFaceRequest.glass);
        }
        if (!Common.isUnset(recognizeFaceRequest.hat)) {
            map.put("Hat", recognizeFaceRequest.hat);
        }
        if (!Common.isUnset(recognizeFaceRequest.imageURL)) {
            map.put("ImageURL", recognizeFaceRequest.imageURL);
        }
        if (!Common.isUnset(recognizeFaceRequest.mask)) {
            map.put("Mask", recognizeFaceRequest.mask);
        }
        if (!Common.isUnset(recognizeFaceRequest.maxFaceNumber)) {
            map.put("MaxFaceNumber", recognizeFaceRequest.maxFaceNumber);
        }
        if (!Common.isUnset(recognizeFaceRequest.quality)) {
            map.put("Quality", recognizeFaceRequest.quality);
        }
        return (RecognizeFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "RecognizeFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new RecognizeFaceResponse());
    }

    public RecognizeHandGestureResponse recognizeHandGesture(RecognizeHandGestureRequest recognizeHandGestureRequest) throws Exception {
        return recognizeHandGestureWithOptions(recognizeHandGestureRequest, new RuntimeOptions());
    }

    public RecognizeHandGestureResponse recognizeHandGestureAdvance(RecognizeHandGestureAdvanceRequest recognizeHandGestureAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        RecognizeHandGestureRequest recognizeHandGestureRequest = new RecognizeHandGestureRequest();
        com.aliyun.openapiutil.Client.convert(recognizeHandGestureAdvanceRequest, recognizeHandGestureRequest);
        if (!Common.isUnset(recognizeHandGestureAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", recognizeHandGestureAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            recognizeHandGestureRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return recognizeHandGestureWithOptions(recognizeHandGestureRequest, runtimeOptions);
    }

    public RecognizeHandGestureResponse recognizeHandGestureWithOptions(RecognizeHandGestureRequest recognizeHandGestureRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(recognizeHandGestureRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(recognizeHandGestureRequest.appId)) {
            map.put("AppId", recognizeHandGestureRequest.appId);
        }
        if (!Common.isUnset(recognizeHandGestureRequest.gestureType)) {
            map.put("GestureType", recognizeHandGestureRequest.gestureType);
        }
        if (!Common.isUnset(recognizeHandGestureRequest.imageURL)) {
            map.put("ImageURL", recognizeHandGestureRequest.imageURL);
        }
        return (RecognizeHandGestureResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "RecognizeHandGesture"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new RecognizeHandGestureResponse());
    }

    public RecognizePublicFaceResponse recognizePublicFace(RecognizePublicFaceRequest recognizePublicFaceRequest) throws Exception {
        return recognizePublicFaceWithOptions(recognizePublicFaceRequest, new RuntimeOptions());
    }

    public RecognizePublicFaceResponse recognizePublicFaceAdvance(RecognizePublicFaceAdvanceRequest recognizePublicFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        boolean z;
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        TeaPair teaPair = new TeaPair("accessKeyId", accessKeyId);
        boolean z2 = false;
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(teaPair, new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        RecognizePublicFaceRequest recognizePublicFaceRequest = new RecognizePublicFaceRequest();
        com.aliyun.openapiutil.Client.convert(recognizePublicFaceAdvanceRequest, recognizePublicFaceRequest);
        if (!Common.isUnset(recognizePublicFaceAdvanceRequest.task)) {
            Integer numLtoi = 0;
            Iterator<RecognizePublicFaceAdvanceRequest.RecognizePublicFaceAdvanceRequestTask> it = recognizePublicFaceAdvanceRequest.task.iterator();
            while (it.hasNext()) {
                RecognizePublicFaceAdvanceRequest.RecognizePublicFaceAdvanceRequestTask next = it.next();
                if (Common.isUnset(next.imageURLObject)) {
                    z = z2;
                } else {
                    AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
                    AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
                    configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
                    configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
                    z = false;
                    new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", next.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
                    recognizePublicFaceRequest.task.get(numLtoi.intValue()).imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
                    numLtoi = com.aliyun.darabonbanumber.Client.ltoi(com.aliyun.darabonbanumber.Client.add(com.aliyun.darabonbanumber.Client.itol(numLtoi), com.aliyun.darabonbanumber.Client.itol(1)));
                }
                it = it;
                z2 = z;
                configBuild = configBuild;
            }
        }
        return recognizePublicFaceWithOptions(recognizePublicFaceRequest, runtimeOptions);
    }

    public RecognizePublicFaceResponse recognizePublicFaceWithOptions(RecognizePublicFaceRequest recognizePublicFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(recognizePublicFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(recognizePublicFaceRequest.task)) {
            map.put("Task", recognizePublicFaceRequest.task);
        }
        return (RecognizePublicFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "RecognizePublicFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new RecognizePublicFaceResponse());
    }

    public RetouchBodyResponse retouchBody(RetouchBodyRequest retouchBodyRequest) throws Exception {
        return retouchBodyWithOptions(retouchBodyRequest, new RuntimeOptions());
    }

    public RetouchBodyResponse retouchBodyAdvance(RetouchBodyAdvanceRequest retouchBodyAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        RetouchBodyRequest retouchBodyRequest = new RetouchBodyRequest();
        com.aliyun.openapiutil.Client.convert(retouchBodyAdvanceRequest, retouchBodyRequest);
        if (!Common.isUnset(retouchBodyAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", retouchBodyAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            retouchBodyRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return retouchBodyWithOptions(retouchBodyRequest, runtimeOptions);
    }

    public RetouchBodyResponse retouchBodyWithOptions(RetouchBodyRequest retouchBodyRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(retouchBodyRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(retouchBodyRequest.imageURL)) {
            map.put("ImageURL", retouchBodyRequest.imageURL);
        }
        if (!Common.isUnset(retouchBodyRequest.lengthenDegree)) {
            map.put("LengthenDegree", retouchBodyRequest.lengthenDegree);
        }
        if (!Common.isUnset(retouchBodyRequest.slimDegree)) {
            map.put("SlimDegree", retouchBodyRequest.slimDegree);
        }
        return (RetouchBodyResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "RetouchBody"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new RetouchBodyResponse());
    }

    public RetouchSkinResponse retouchSkin(RetouchSkinRequest retouchSkinRequest) throws Exception {
        return retouchSkinWithOptions(retouchSkinRequest, new RuntimeOptions());
    }

    public RetouchSkinResponse retouchSkinAdvance(RetouchSkinAdvanceRequest retouchSkinAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        RetouchSkinRequest retouchSkinRequest = new RetouchSkinRequest();
        com.aliyun.openapiutil.Client.convert(retouchSkinAdvanceRequest, retouchSkinRequest);
        if (!Common.isUnset(retouchSkinAdvanceRequest.imageURLObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", retouchSkinAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            retouchSkinRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return retouchSkinWithOptions(retouchSkinRequest, runtimeOptions);
    }

    public RetouchSkinResponse retouchSkinWithOptions(RetouchSkinRequest retouchSkinRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(retouchSkinRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(retouchSkinRequest.imageURL)) {
            map.put("ImageURL", retouchSkinRequest.imageURL);
        }
        if (!Common.isUnset(retouchSkinRequest.retouchDegree)) {
            map.put("RetouchDegree", retouchSkinRequest.retouchDegree);
        }
        if (!Common.isUnset(retouchSkinRequest.whiteningDegree)) {
            map.put("WhiteningDegree", retouchSkinRequest.whiteningDegree);
        }
        return (RetouchSkinResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "RetouchSkin"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new RetouchSkinResponse());
    }

    public SearchFaceResponse searchFace(SearchFaceRequest searchFaceRequest) throws Exception {
        return searchFaceWithOptions(searchFaceRequest, new RuntimeOptions());
    }

    public SearchFaceResponse searchFaceAdvance(SearchFaceAdvanceRequest searchFaceAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions2);
        SearchFaceRequest searchFaceRequest = new SearchFaceRequest();
        com.aliyun.openapiutil.Client.convert(searchFaceAdvanceRequest, searchFaceRequest);
        if (!Common.isUnset(searchFaceAdvanceRequest.imageUrlObject)) {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", searchFaceAdvanceRequest.imageUrlObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            searchFaceRequest.imageUrl = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        return searchFaceWithOptions(searchFaceRequest, runtimeOptions);
    }

    public SearchFaceResponse searchFaceWithOptions(SearchFaceRequest searchFaceRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(searchFaceRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(searchFaceRequest.dbName)) {
            map.put("DbName", searchFaceRequest.dbName);
        }
        if (!Common.isUnset(searchFaceRequest.dbNames)) {
            map.put("DbNames", searchFaceRequest.dbNames);
        }
        if (!Common.isUnset(searchFaceRequest.imageUrl)) {
            map.put("ImageUrl", searchFaceRequest.imageUrl);
        }
        if (!Common.isUnset(searchFaceRequest.limit)) {
            map.put("Limit", searchFaceRequest.limit);
        }
        if (!Common.isUnset(searchFaceRequest.maxFaceNum)) {
            map.put("MaxFaceNum", searchFaceRequest.maxFaceNum);
        }
        if (!Common.isUnset(searchFaceRequest.qualityScoreThreshold)) {
            map.put("QualityScoreThreshold", searchFaceRequest.qualityScoreThreshold);
        }
        return (SearchFaceResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "SearchFace"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new SearchFaceResponse());
    }

    public UpdateFaceEntityResponse updateFaceEntity(UpdateFaceEntityRequest updateFaceEntityRequest) throws Exception {
        return updateFaceEntityWithOptions(updateFaceEntityRequest, new RuntimeOptions());
    }

    public UpdateFaceEntityResponse updateFaceEntityWithOptions(UpdateFaceEntityRequest updateFaceEntityRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(updateFaceEntityRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(updateFaceEntityRequest.dbName)) {
            map.put("DbName", updateFaceEntityRequest.dbName);
        }
        if (!Common.isUnset(updateFaceEntityRequest.entityId)) {
            map.put("EntityId", updateFaceEntityRequest.entityId);
        }
        if (!Common.isUnset(updateFaceEntityRequest.labels)) {
            map.put("Labels", updateFaceEntityRequest.labels);
        }
        return (UpdateFaceEntityResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "UpdateFaceEntity"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new UpdateFaceEntityResponse());
    }

    public VerifyFaceMaskResponse verifyFaceMask(VerifyFaceMaskRequest verifyFaceMaskRequest) throws Exception {
        return verifyFaceMaskWithOptions(verifyFaceMaskRequest, new RuntimeOptions());
    }

    public VerifyFaceMaskResponse verifyFaceMaskAdvance(VerifyFaceMaskAdvanceRequest verifyFaceMaskAdvanceRequest, RuntimeOptions runtimeOptions) throws Exception {
        VerifyFaceMaskRequest verifyFaceMaskRequest;
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions2;
        Client client;
        String accessKeyId = this._credential.getAccessKeyId();
        String accessKeySecret = this._credential.getAccessKeySecret();
        String securityToken = this._credential.getSecurityToken();
        String type = this._credential.getType();
        String str = this._openPlatformEndpoint;
        if (Common.isUnset(str)) {
            str = "openplatform.aliyuncs.com";
        }
        if (Common.isUnset(type)) {
            type = AuthConstant.ACCESS_KEY;
        }
        com.aliyun.openplatform20191219.Client client2 = new com.aliyun.openplatform20191219.Client(Config.build(TeaConverter.buildMap(new TeaPair("accessKeyId", accessKeyId), new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("securityToken", securityToken), new TeaPair("type", type), new TeaPair("endpoint", str), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId))));
        AuthorizeFileUploadRequest authorizeFileUploadRequestBuild = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(new TeaPair(ze1.n, "facebody"), new TeaPair("regionId", this._regionId)));
        new AuthorizeFileUploadResponse();
        com.aliyun.oss.models.Config configBuild = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(new TeaPair("accessKeySecret", accessKeySecret), new TeaPair("type", AuthConstant.ACCESS_KEY), new TeaPair("protocol", this._protocol), new TeaPair("regionId", this._regionId)));
        new FileField();
        new PostObjectRequest.PostObjectRequestHeader();
        new PostObjectRequest();
        com.aliyun.ossutil.models.RuntimeOptions runtimeOptions3 = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(runtimeOptions, runtimeOptions3);
        VerifyFaceMaskRequest verifyFaceMaskRequest2 = new VerifyFaceMaskRequest();
        com.aliyun.openapiutil.Client.convert(verifyFaceMaskAdvanceRequest, verifyFaceMaskRequest2);
        if (Common.isUnset(verifyFaceMaskAdvanceRequest.imageURLObject)) {
            verifyFaceMaskRequest = verifyFaceMaskRequest2;
            runtimeOptions2 = runtimeOptions3;
        } else {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions = client2.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody = authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody.accessKeyId;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody.endpoint, authorizeFileUploadResponseBody.useAccelerate.booleanValue(), this._endpointType);
            runtimeOptions2 = runtimeOptions3;
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey), new TeaPair("content", verifyFaceMaskAdvanceRequest.imageURLObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            verifyFaceMaskRequest = verifyFaceMaskRequest2;
            verifyFaceMaskRequest.imageURL = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions.body.objectKey + "";
        }
        if (Common.isUnset(verifyFaceMaskAdvanceRequest.refUrlObject)) {
            client = this;
        } else {
            AuthorizeFileUploadResponse authorizeFileUploadResponseAuthorizeFileUploadWithOptions2 = client2.authorizeFileUploadWithOptions(authorizeFileUploadRequestBuild, runtimeOptions);
            AuthorizeFileUploadResponseBody authorizeFileUploadResponseBody2 = authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body;
            configBuild.accessKeyId = authorizeFileUploadResponseBody2.accessKeyId;
            client = this;
            configBuild.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authorizeFileUploadResponseBody2.endpoint, authorizeFileUploadResponseBody2.useAccelerate.booleanValue(), client._endpointType);
            new com.aliyun.oss.Client(configBuild).postObject(PostObjectRequest.build(TeaConverter.buildMap(new TeaPair("bucketName", authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.bucket), new TeaPair("header", PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(new TeaPair("accessKeyId", authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.accessKeyId), new TeaPair(AuthConstant.INI_POLICY, authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.encodedPolicy), new TeaPair(SignatureFragment.SIGNATURE, authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.signature), new TeaPair(CachedContentIndex.a.e, authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.objectKey), new TeaPair("file", FileField.build(TeaConverter.buildMap(new TeaPair("filename", authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.objectKey), new TeaPair("content", verifyFaceMaskAdvanceRequest.refUrlObject), new TeaPair("contentType", "")))), new TeaPair("successActionStatus", "201")))))), runtimeOptions2);
            verifyFaceMaskRequest.refUrl = "http://" + authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.bucket + Consts.DOT + authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.endpoint + WVNativeCallbackUtil.SEPERATER + authorizeFileUploadResponseAuthorizeFileUploadWithOptions2.body.objectKey + "";
        }
        return client.verifyFaceMaskWithOptions(verifyFaceMaskRequest, runtimeOptions);
    }

    public VerifyFaceMaskResponse verifyFaceMaskWithOptions(VerifyFaceMaskRequest verifyFaceMaskRequest, RuntimeOptions runtimeOptions) throws Exception {
        Common.validateModel(verifyFaceMaskRequest);
        HashMap map = new HashMap();
        if (!Common.isUnset(verifyFaceMaskRequest.imageData)) {
            map.put("ImageData", verifyFaceMaskRequest.imageData);
        }
        if (!Common.isUnset(verifyFaceMaskRequest.imageURL)) {
            map.put("ImageURL", verifyFaceMaskRequest.imageURL);
        }
        if (!Common.isUnset(verifyFaceMaskRequest.refData)) {
            map.put("RefData", verifyFaceMaskRequest.refData);
        }
        if (!Common.isUnset(verifyFaceMaskRequest.refUrl)) {
            map.put("RefUrl", verifyFaceMaskRequest.refUrl);
        }
        return (VerifyFaceMaskResponse) TeaModel.toModel(callApi(Params.build(TeaConverter.buildMap(new TeaPair("action", "VerifyFaceMask"), new TeaPair("version", "2019-12-30"), new TeaPair("protocol", "HTTPS"), new TeaPair("pathname", WVNativeCallbackUtil.SEPERATER), new TeaPair("method", "POST"), new TeaPair("authType", "AK"), new TeaPair("style", "RPC"), new TeaPair("reqBodyType", "formData"), new TeaPair("bodyType", "json"))), OpenApiRequest.build(TeaConverter.buildMap(new TeaPair("body", com.aliyun.openapiutil.Client.parseToMap(map)))), runtimeOptions), new VerifyFaceMaskResponse());
    }
}
