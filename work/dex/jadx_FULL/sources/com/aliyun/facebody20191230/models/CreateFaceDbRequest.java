package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CreateFaceDbRequest extends TeaModel {

    @NameInMap("Name")
    public String name;

    public static CreateFaceDbRequest build(Map<String, ?> map) throws Exception {
        return (CreateFaceDbRequest) TeaModel.build(map, new CreateFaceDbRequest());
    }

    public String getName() {
        return this.name;
    }

    public CreateFaceDbRequest setName(String str) {
        this.name = str;
        return this;
    }
}
