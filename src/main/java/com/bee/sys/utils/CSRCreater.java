package com.bee.sys.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.security.*;
import java.security.cert.CertificateException;


public class CSRCreater {
    public KeyPair kp = null;
    public String password = "";

    /**
     * @description: TODO
     * @auther: feng
     * @date: 2018/11/6 16:52
     * @param: [country国家, domain域名, email邮箱, organizationName公司名, location城市, state地区]
     * @return: java.lang.String
     * @throws: 
     **/
    public String generateCSR(String domain,String email,String organizationName,String location,String state) throws NoSuchAlgorithmException, InvalidKeyException, IOException, CertificateException, SignatureException {

        Security.addProvider(new BouncyCastleProvider());
        String strCSR = "";
        try {

                KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
                kpg.initialize(2048, new SecureRandom());
                this.kp = kpg.generateKeyPair();


                PublicKey publicKey = this.kp.getPublic();
                PrivateKey privateKey = this.kp.getPrivate();

                sun.security.pkcs10.PKCS10 pkcs10 = new sun.security.pkcs10.PKCS10(publicKey);
                //PKCS10 pkcs10 = new PKCS10(publicKey);
                Signature signature = Signature.getInstance("SHA1WithRSA");
                signature.initSign(privateKey);


                String DN = "CN=cn" + ",C=CN"+",city="+state +",province="+location +",domain="+domain+",email"+email;

                sun.security.x509.X500Name x500Name = new sun.security.x509.X500Name(DN);
                pkcs10.encodeAndSign(x500Name, signature);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                pkcs10.print(ps);


                String strPEMCSR = baos.toString();
                strCSR = strPEMCSR.replaceAll("\r", "");
                strCSR = strCSR.replace("\n","\\n" );
                return strCSR.substring(0, strCSR.length()-2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strCSR;
    }
}
