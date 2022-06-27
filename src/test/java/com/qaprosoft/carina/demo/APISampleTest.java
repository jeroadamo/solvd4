/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.api.DeleteAlbum;
import com.qaprosoft.carina.demo.api.GetAlbum;
import com.qaprosoft.carina.demo.api.PatchAlbum;
import com.qaprosoft.carina.demo.api.PostAlbum;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APISampleTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Test()
    public void testCreateAlbum() throws Exception {
        PostAlbum api = new PostAlbum();
        AtomicInteger counter = new AtomicInteger(0);
        api.callAPIWithRetry().withLogStrategy(APIMethodPoller.LogStrategy.ALL).peek(rs -> counter.getAndIncrement()).until(rs -> counter.get() == 4).pollEvery(1, ChronoUnit.SECONDS).stopAfter(10, ChronoUnit.SECONDS).execute();
        api.validateResponse();
    }
    @Test()
    public void testGetAlbum() {
        GetAlbum getAlbum = new GetAlbum();
        getAlbum.callAPIExpectSuccess();
        getAlbum.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAlbum.validateResponseAgainstSchema("api/albums/_get/rs.schema");
    }
    @Test()
    @TestPriority(Priority.P1)
    public void testDeleteAlbum() {
        DeleteAlbum deleteAlbum = new DeleteAlbum();
        deleteAlbum.callAPIExpectSuccess();
        deleteAlbum.validateResponse();
    }

    @Test
    public void patchAlbum(){
        PatchAlbum patchAlbum = new PatchAlbum();
        patchAlbum.callAPIExpectSuccess();
        patchAlbum.validateResponse();
    }
}
