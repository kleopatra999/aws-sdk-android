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
package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/**
 * <p>
 * Contains the response to a successful GetSessionToken request,
 * including temporary AWS credentials that can be used to make AWS
 * requests.
 * </p>
 */
public class GetSessionTokenResult implements Serializable {

    /**
     * The temporary security credentials, which include an access key ID, a
     * secret access key, and a security (or session) token. <p><b>Note:</b>
     * The size of the security token that STS APIs return is not fixed. We
     * strongly recommend that you make no assumptions about the maximum
     * size. As of this writing, the typical size is less than 4096 bytes,
     * but that can vary. Also, future updates to AWS might require larger
     * sizes.
     */
    private Credentials credentials;

    /**
     * The temporary security credentials, which include an access key ID, a
     * secret access key, and a security (or session) token. <p><b>Note:</b>
     * The size of the security token that STS APIs return is not fixed. We
     * strongly recommend that you make no assumptions about the maximum
     * size. As of this writing, the typical size is less than 4096 bytes,
     * but that can vary. Also, future updates to AWS might require larger
     * sizes.
     *
     * @return The temporary security credentials, which include an access key ID, a
     *         secret access key, and a security (or session) token. <p><b>Note:</b>
     *         The size of the security token that STS APIs return is not fixed. We
     *         strongly recommend that you make no assumptions about the maximum
     *         size. As of this writing, the typical size is less than 4096 bytes,
     *         but that can vary. Also, future updates to AWS might require larger
     *         sizes.
     */
    public Credentials getCredentials() {
        return credentials;
    }
    
    /**
     * The temporary security credentials, which include an access key ID, a
     * secret access key, and a security (or session) token. <p><b>Note:</b>
     * The size of the security token that STS APIs return is not fixed. We
     * strongly recommend that you make no assumptions about the maximum
     * size. As of this writing, the typical size is less than 4096 bytes,
     * but that can vary. Also, future updates to AWS might require larger
     * sizes.
     *
     * @param credentials The temporary security credentials, which include an access key ID, a
     *         secret access key, and a security (or session) token. <p><b>Note:</b>
     *         The size of the security token that STS APIs return is not fixed. We
     *         strongly recommend that you make no assumptions about the maximum
     *         size. As of this writing, the typical size is less than 4096 bytes,
     *         but that can vary. Also, future updates to AWS might require larger
     *         sizes.
     */
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
    
    /**
     * The temporary security credentials, which include an access key ID, a
     * secret access key, and a security (or session) token. <p><b>Note:</b>
     * The size of the security token that STS APIs return is not fixed. We
     * strongly recommend that you make no assumptions about the maximum
     * size. As of this writing, the typical size is less than 4096 bytes,
     * but that can vary. Also, future updates to AWS might require larger
     * sizes.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param credentials The temporary security credentials, which include an access key ID, a
     *         secret access key, and a security (or session) token. <p><b>Note:</b>
     *         The size of the security token that STS APIs return is not fixed. We
     *         strongly recommend that you make no assumptions about the maximum
     *         size. As of this writing, the typical size is less than 4096 bytes,
     *         but that can vary. Also, future updates to AWS might require larger
     *         sizes.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public GetSessionTokenResult withCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCredentials() != null) sb.append("Credentials: " + getCredentials() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getCredentials() == null) ? 0 : getCredentials().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof GetSessionTokenResult == false) return false;
        GetSessionTokenResult other = (GetSessionTokenResult)obj;
        
        if (other.getCredentials() == null ^ this.getCredentials() == null) return false;
        if (other.getCredentials() != null && other.getCredentials().equals(this.getCredentials()) == false) return false; 
        return true;
    }
    
}
    