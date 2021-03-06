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
package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/**
 * <p>
 * Represents the authentication response.
 * </p>
 */
public class AuthenticateResult implements Serializable {

    /**
     * The result of the authentication response.
     */
    private AuthenticationResultType authenticationResult;

    /**
     * The authorization state of the authentication response.
     */
    private String authState;

    /**
     * The code delivery details of the authentication response.
     */
    private CodeDeliveryDetailsType codeDeliveryDetails;

    /**
     * The result of the authentication response.
     *
     * @return The result of the authentication response.
     */
    public AuthenticationResultType getAuthenticationResult() {
        return authenticationResult;
    }
    
    /**
     * The result of the authentication response.
     *
     * @param authenticationResult The result of the authentication response.
     */
    public void setAuthenticationResult(AuthenticationResultType authenticationResult) {
        this.authenticationResult = authenticationResult;
    }
    
    /**
     * The result of the authentication response.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param authenticationResult The result of the authentication response.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public AuthenticateResult withAuthenticationResult(AuthenticationResultType authenticationResult) {
        this.authenticationResult = authenticationResult;
        return this;
    }

    /**
     * The authorization state of the authentication response.
     *
     * @return The authorization state of the authentication response.
     */
    public String getAuthState() {
        return authState;
    }
    
    /**
     * The authorization state of the authentication response.
     *
     * @param authState The authorization state of the authentication response.
     */
    public void setAuthState(String authState) {
        this.authState = authState;
    }
    
    /**
     * The authorization state of the authentication response.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param authState The authorization state of the authentication response.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public AuthenticateResult withAuthState(String authState) {
        this.authState = authState;
        return this;
    }

    /**
     * The code delivery details of the authentication response.
     *
     * @return The code delivery details of the authentication response.
     */
    public CodeDeliveryDetailsType getCodeDeliveryDetails() {
        return codeDeliveryDetails;
    }
    
    /**
     * The code delivery details of the authentication response.
     *
     * @param codeDeliveryDetails The code delivery details of the authentication response.
     */
    public void setCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetails) {
        this.codeDeliveryDetails = codeDeliveryDetails;
    }
    
    /**
     * The code delivery details of the authentication response.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param codeDeliveryDetails The code delivery details of the authentication response.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public AuthenticateResult withCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetails) {
        this.codeDeliveryDetails = codeDeliveryDetails;
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
        if (getAuthenticationResult() != null) sb.append("AuthenticationResult: " + getAuthenticationResult() + ",");
        if (getAuthState() != null) sb.append("AuthState: " + getAuthState() + ",");
        if (getCodeDeliveryDetails() != null) sb.append("CodeDeliveryDetails: " + getCodeDeliveryDetails() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getAuthenticationResult() == null) ? 0 : getAuthenticationResult().hashCode()); 
        hashCode = prime * hashCode + ((getAuthState() == null) ? 0 : getAuthState().hashCode()); 
        hashCode = prime * hashCode + ((getCodeDeliveryDetails() == null) ? 0 : getCodeDeliveryDetails().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof AuthenticateResult == false) return false;
        AuthenticateResult other = (AuthenticateResult)obj;
        
        if (other.getAuthenticationResult() == null ^ this.getAuthenticationResult() == null) return false;
        if (other.getAuthenticationResult() != null && other.getAuthenticationResult().equals(this.getAuthenticationResult()) == false) return false; 
        if (other.getAuthState() == null ^ this.getAuthState() == null) return false;
        if (other.getAuthState() != null && other.getAuthState().equals(this.getAuthState()) == false) return false; 
        if (other.getCodeDeliveryDetails() == null ^ this.getCodeDeliveryDetails() == null) return false;
        if (other.getCodeDeliveryDetails() != null && other.getCodeDeliveryDetails().equals(this.getCodeDeliveryDetails()) == false) return false; 
        return true;
    }
    
}
    