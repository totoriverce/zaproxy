/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2011 mawoki@ymail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.parosproxy.paros.security;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/** @deprecated use (@link CachedSslCertificateServiceImpl} instead. */
@Deprecated
public final class CachedSslCertifificateServiceImpl implements SslCertificateService {

    private static final SslCertificateService singleton =
            CachedSslCertificateServiceImpl.getService();

    @Override
    @Deprecated
    public KeyStore createCertForHost(String hostname)
            throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException,
                    KeyStoreException, SignatureException, NoSuchProviderException,
                    InvalidKeyException, IOException {
        return singleton.createCertForHost(hostname);
    }

    @Override
    @Deprecated
    public synchronized KeyStore createCertForHost(CertData certData)
            throws NoSuchAlgorithmException, InvalidKeyException, CertificateException,
                    NoSuchProviderException, SignatureException, KeyStoreException, IOException,
                    UnrecoverableKeyException {
        return singleton.createCertForHost(certData);
    }

    /** @return the current {@link SslCertificateService} */
    @Deprecated
    public static SslCertificateService getService() {
        return singleton;
    }

    @Override
    @Deprecated
    public synchronized void initializeRootCA(KeyStore keystore)
            throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException {
        singleton.initializeRootCA(keystore);
    }
}
