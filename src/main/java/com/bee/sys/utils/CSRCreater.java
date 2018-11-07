package com.bee.sys.utils;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.bee.framework.i.bp.core.CoreException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.*;


public class CSRCreater {
    private static  final Logger log = LoggerFactory.getLogger(CSRCreater.class);
    /**
     * @description: dn主要包含cn(通用名，即域名)、o(组织)、ou(部门)、c(国家)、s(省份)、L(城市)，不过最好把e(邮箱)加上
     * @auther: feng
     * @date: 2018/11/6 16:52
     * @param: [country国家, domain域名, email邮箱, organizationName公司名, location城市, state地区,department 部门]
     * @return: java.lang.String
     * @throws: 
     **/
    public static String generateCSR(String domain,String email,String organizationName,String location,String state,String department) throws CoreException{

        Security.addProvider(new BouncyCastleProvider());
        String strCSR = "";
        KeyPair kp = null;
        try {

                KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
                kpg.initialize(2048, new SecureRandom());
                kp = kpg.generateKeyPair();

                PublicKey publicKey = kp.getPublic();
                PrivateKey privateKey = kp.getPrivate();

                sun.security.pkcs10.PKCS10 pkcs10 = new sun.security.pkcs10.PKCS10(publicKey);
                Signature signature = Signature.getInstance("SHA256WithRSA");
                signature.initSign(privateKey);



                StringBuffer srb = new StringBuffer();
                srb.append("CN="+domain).append(",");
                srb.append("c=CN").append(",");
                srb.append("o="+organizationName).append(",");
                srb.append("l="+location).append(",");
                srb.append("s="+state).append(",");
                srb.append("ou="+department);
                //srb.append(",M="+email);

                sun.security.x509.X500Name x500Name = new sun.security.x509.X500Name(srb.toString());
                pkcs10.encodeAndSign(x500Name, signature);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                pkcs10.print(ps);


                String strPEMCSR = baos.toString();
                strCSR = strPEMCSR.replaceAll("\r", "");
                strCSR = strCSR.replace("\n","\\n" );
                return strCSR.substring(0, strCSR.length()-2);
        } catch (Exception e) {
            log.error("生成证书请求文件失败",e);
            throw new CoreException("生成证书请求文件失败",e);
        }
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(CSRCreater.generateCSR("www.baidu.com", "35@qq.com", "sdf", "lsdfjl", "bj","研发部"));
        } catch (CoreException e) {
            e.printStackTrace();
        }

    }
}
