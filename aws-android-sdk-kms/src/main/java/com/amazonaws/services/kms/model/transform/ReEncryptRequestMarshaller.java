/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.kms.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;

/**
 * Re Encrypt Request Marshaller
 */
public class ReEncryptRequestMarshaller implements Marshaller<Request<ReEncryptRequest>, ReEncryptRequest> {

    public Request<ReEncryptRequest> marshall(ReEncryptRequest reEncryptRequest) {
    if (reEncryptRequest == null) {
        throw new AmazonClientException("Invalid argument passed to marshall(...)");
    }

        Request<ReEncryptRequest> request = new DefaultRequest<ReEncryptRequest>(reEncryptRequest, "AWSKMS");
        String target = "TrentService.ReEncrypt";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);

            jsonWriter.beginObject();
            
            if (reEncryptRequest.getCiphertextBlob() != null) {
                jsonWriter.name("CiphertextBlob").value(reEncryptRequest.getCiphertextBlob());
            }
            if (reEncryptRequest.getSourceEncryptionContext() != null) {
                jsonWriter.name("SourceEncryptionContext");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> sourceEncryptionContextListValue : reEncryptRequest.getSourceEncryptionContext().entrySet()) {
                    if (sourceEncryptionContextListValue.getValue() != null) {
                        jsonWriter.name(sourceEncryptionContextListValue.getKey());

                        jsonWriter.value(sourceEncryptionContextListValue.getValue());
                    }
                }
                jsonWriter.endObject();
            }
            if (reEncryptRequest.getDestinationKeyId() != null) {
                jsonWriter.name("DestinationKeyId").value(reEncryptRequest.getDestinationKeyId());
            }
            if (reEncryptRequest.getDestinationEncryptionContext() != null) {
                jsonWriter.name("DestinationEncryptionContext");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> destinationEncryptionContextListValue : reEncryptRequest.getDestinationEncryptionContext().entrySet()) {
                    if (destinationEncryptionContextListValue.getValue() != null) {
                        jsonWriter.name(destinationEncryptionContextListValue.getKey());

                        jsonWriter.value(destinationEncryptionContextListValue.getValue());
                    }
                }
                jsonWriter.endObject();
            }

            com.amazonaws.internal.ListWithAutoConstructFlag<String> grantTokensList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(reEncryptRequest.getGrantTokens());
            if (grantTokensList != null && !(grantTokensList.isAutoConstruct() && grantTokensList.isEmpty())) {

                jsonWriter.name("GrantTokens");
                jsonWriter.beginArray();

                for (String grantTokensListValue : grantTokensList) {
                    if (grantTokensListValue != null) {
                        jsonWriter.value(grantTokensListValue);
                    }
                }
                jsonWriter.endArray();
            }

            jsonWriter.endObject();

            jsonWriter.close();
            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length", Integer.toString(content.length));
            request.addHeader("Content-Type", "application/x-amz-json-1.1");
        } catch(Throwable t) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
