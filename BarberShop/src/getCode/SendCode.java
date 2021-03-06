package getCode;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class SendCode {
	// 发送验证码的请求路径URL
	private static final String SERVER_URL = "https://api.netease.im/sms/sendcode.action";
	// 网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
	private static final String APP_KEY = "59789e26fecddc8096d567e99486c294";
	// 网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
	private static final String APP_SECRET = "00479f036cbb";
	// 随机数
	private static final String NONCE = "123456";
	// 短信模板ID
	private static final String TEMPLATEID = "3110045";
	// 手机号
	// 验证码长度，范围4～10，默认为4
	private static final String CODELEN = "6";

	public static String getCode(String MOBILE) throws Exception {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(SERVER_URL);
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		/*
		 * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
		 */
		String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);

		// 设置请求的header
		httpPost.addHeader("AppKey", APP_KEY);
		httpPost.addHeader("Nonce", NONCE);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		// 设置请求的的参数，requestBody参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		/*
		 * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档” 2.参数格式是jsonArray的格式，例如
		 * "['13888888888','13666666666']" 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
		 */
		nvps.add(new BasicNameValuePair("templateid", TEMPLATEID));
		nvps.add(new BasicNameValuePair("mobile", MOBILE));
		nvps.add(new BasicNameValuePair("codeLen", CODELEN));

		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		/*
		 * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500 2.具体的code有问题的可以参考官网的Code状态表
		 */
		String responseEntity = EntityUtils.toString(response.getEntity(),"UTF-8");
		String obj = JSON.parseObject(responseEntity).getString("obj");
		return obj;
	}

}

class CheckSumBuilder {
	// 计算并获取CheckSum
	public static String getCheckSum(String appSecret, String nonce, String curTime) {
		return encode("sha1", appSecret + nonce + curTime);
	}

	// 计算并获取md5值
	public static String getMD5(String requestBody) {
		return encode("md5", requestBody);
	}

	private static String encode(String algorithm, String value) {
		if (value == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(value.getBytes());
			return getFormattedText(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;
		StringBuilder buf = new StringBuilder(len * 2);
		for (int j = 0; j < len; j++) {
			buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
		}
		return buf.toString();
	}

	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };
}
