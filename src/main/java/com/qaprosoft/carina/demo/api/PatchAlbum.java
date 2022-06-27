package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/albums/10", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/albums/_patch/rq.json")
@ResponseTemplatePath(path = "api/albums/_patch/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchAlbum extends AbstractApiMethodV2 {
    public PatchAlbum(){
        super("api/albums/_patch/rq.json", "api/albums/_patch/rs.json", "api/albums/albums.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }

}
