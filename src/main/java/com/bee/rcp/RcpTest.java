package com.bee.rcp;

import com.alibaba.com.caucho.hessian.io.Hessian2Input;
import com.alibaba.com.caucho.hessian.io.Hessian2Output;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Auther: renchengpeng
 * @Date: 2018/12/11 18:02
 * @Description:
 */
public class RcpTest {

  /*  @Autowired
    private QiniuService qiniuService;

    public String encodeImageToBase64(String imageUrl) throws Exception {
        String imageId = "";
        try { // 判断是否上传图片
            String file_ture_name = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            imageId = FileUpload.fileReNameByContentType("image/png", file_ture_name);
            URL url = new URL(imageUrl);
            DataInputStream inputStream = new DataInputStream(url.openStream());
            byte[] buffer = new byte[1024];
            int len;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((len = inputStream.read(buffer)) > 0) {
                bos.write(buffer, 0, len);
            }
            byte b[] = bos.toByteArray();
            QiniuDto dto = new QiniuDto();
            dto.setFileByte(b);
            dto.setBucketname("testfenghui");
            dto.setFileName("vip/cardPic/" + imageId);
            qiniuService.qiniuUpload(dto);
            bos.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageId;
    }*/

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output ho = new Hessian2Output(os);
        byte[] cc = null;
        try {
            if(obj==null) throw new NullPointerException();
            ho.writeObject(obj);
            ho.flushBuffer();
            cc=os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ho.close();
        }
        return cc;

    }

    public static Object deserialize(byte[] by) throws IOException{
        try {
            if(by==null) throw new NullPointerException();
            ByteArrayInputStream is = new ByteArrayInputStream(by);
            Hessian2Input hi = new Hessian2Input(is);
            return hi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    @Test
    public void mains() throws Exception {

      /*  String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        Map<String, String> signParam = new HashMap<>(16);
        signParam.put("timestamp", timestamp);
        signParam.put("random", timestamp);
        signParam.put("TOKEN", timestamp);
        signParam.put("orderId", redeemJrnNo);
        signParam.put("orderDt", new SimpleDateFormat("yyyyMMdd").format(info.getPayTime()));
        String mapSign = SignUtils.createSign(signParam);
        signParam.put("sign", mapSign);
        String resStr = HttpUtils.postHttps("https://devfc.qiyeos.com/agentPay/queryyoyiAgentPay", signParam);
        Map<String, Object> map = JSON.parseObject(resStr);
        System.out.println(resStr);*/

        /*String str = "1**_ngjdfg877s(没法看dg";
        String ss = str.replaceAll("([a-zA-Z]+)", "$1***");
        System.out.println(ss);*/
        /*Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String s = matcher.group();

            System.out.println(s);
            String s1 = new StringBuffer(s).reverse().toString();
            str = str.replaceFirst(matcher.group(), s1);
        }*/
        /*System.out.println(str);*/
     /*   String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        Map<String, String> signParam = new HashMap<>(16);
        signParam.put("timestamp", timestamp);
        signParam.put("random", timestamp);
        signParam.put("TOKEN", timestamp);
        signParam.put("orderNo", "XP20181222000001");
        String mapSign = SignUtils.createSign(signParam);
        signParam.put("sign", mapSign);
        String resStr = HttpUtils.postHttps("https://devfc.qiyeos.com/agentPay/queryPaymaxAgentPay", signParam);
        System.out.println("招商返回信息》》》》》》》》》》》" + JSON.toJSONString(resStr));
        Map<String, Object> map = JSON.parseObject(resStr);
       *//* for (int i =0; i<100; i++) {
            List<Integer> str = new ArrayList<>(10000000 * i);
            str.add(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            str.forEach(s->{
                System.out.println(".." + s);
                    }
            );
        }*/
    }
}
