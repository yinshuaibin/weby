package com.y.utils;

import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.ssl.SSLContexts;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.net.HttpURLConnection;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author yinshuaibin
 * @date 2020/6/18 9:20
 */
public class HttpsClientRequestFactory extends SimpleClientHttpRequestFactory {

    @Override
    protected void prepareConnection(HttpURLConnection connection, String httpMethod) {
        connection.setConnectTimeout(6000);
        connection.setReadTimeout(6000);
        try {
            if (!(connection instanceof HttpsURLConnection)) {
                //throw new RuntimeException("An instance of HttpsURLConnection is expected");
                super.prepareConnection(connection, httpMethod);
            }
            if (connection instanceof HttpsURLConnection) {
                KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
                // 信任任何链接
                TrustStrategy anyTrustStrategy = new TrustStrategy() {
                    @Override
                    public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                        return true;
                    }
                };
                SSLContext ctx = SSLContexts.custom().loadTrustMaterial(trustStore, anyTrustStrategy).build();
                ((HttpsURLConnection) connection).setSSLSocketFactory(ctx.getSocketFactory());
                HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;
                httpsConnection.setHostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String s, SSLSession sslSession) {
                        return true;
                    }
                });
                super.prepareConnection(httpsConnection, httpMethod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
