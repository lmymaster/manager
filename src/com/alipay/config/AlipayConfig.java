package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016093000632477";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCpULdXURio8hkn7HWuNwA54FwEU7lHQ/5P+APKxIiJGibEkTBHBsO16RyLwCv0038j0fYeiSFoTieTUvCfQtSSDj75hs3S9ZqmIAUYyprmfoyNJGLgYnG3RFsg6OgO3jZe2zfMN35t7uUatfwwqaqeXiz5XKw8nsPfgB/9vKhp01LsNar/9dvK6z8/F8lxNqIpzoCF+TxD57VDZ/SopUsULiEJtlxSs3PtvhftlfT1rYscDZLyyQNM6JDrXTbuInugQCIL+HNDp+f8fiwrKNsp0TrHyzNmMP+EacGEzxYR/9bXmXg89Myz8gcLbCvl5Me1kUW0lRD6K9Y+NfLnBkzDAgMBAAECggEALZioFyKmwnCYJ7E9K9JyBCQQg7XMUo3UAdMnqkZtAocBY7Q5zRbcQ7PoVRZGgCMovQvA/Q4u6fkKHVmbpTgJKOAfQ3FzIlmz8QL0fG2rc2EnFqdy3TyFpTYKWH2AaOicucTNbPiQ2qgYGK5joPNAGHACKpEzbQvQcfL+KoXQ0NaA62xQmQG/t8I7xfppEDwxVFoDN4aRtkfcY15oujb97OfpDHBrHUDw4EJ2zePvGQMEMlbpLr9knJckk5SR/lT5NXWfMsHhAklOCFiE+0mVxm/DVkfuv3IYn+zau0+vFnfqTvcqwA8e1K+Qr1vitPG5rLEzv/aozX2ZG9pEDolzKQKBgQDYA3ISE0O96rcPk6PVioUVtgpd827rJx4ejaKrjZIXCnKyPe2l04HQA/YDN8QENa/knx1TkqdM6K+HunbwwipN7/VpPpv1XvIR63BhaKfcVcYbIeZEK6puCPcFGH+3zfjf2Al9Bg7EMw5R7JxERPYySbQeqyFgZESrOXIPzTvOjwKBgQDIqFCK9072yrGLuvh/3Z/JR1FRtMLIGYeutm0jCRBUSMYJYtGNjcVMzq5ggjNIvQ8j86V7GQxp731Sx30w6KMrwNDMFqPJnzn5B2ZmFTfUuEIovfgCG9XO+AowPmGF1VbGZL4vH/QTYpUoO9QYhxeYVK/CfEDs6PQGfQG88NX4jQKBgEDjsBWb8eKQKpOkTzfrl5TxDWYxpWVAZ/zXoUEVkwgW3GOM1OHWio1ZU0KeMuTs17y+y4l6aYVh9LC6I9apDRpCdh86bpEkB2W4qxan4J0AqzUlVs2trFHHoaTHOj6VwihD9n23HyJzD98uS7b6XFa460G3OJyDIlmpNQloJoojAoGAGpQ4/v9dRVF6DSE6E23e4YGB4wnHl0vSbjEZ6b8km5V8LfgZ+98gmFj0PjJg6qyoWcHHVLPvsgSYHCPykEzweDY1MiN5lJZzzmnNhY4f9BxoHw9yz4yyWJUAfH1224xzzxm/G2znHr47NbYfFRSn6nSlR2TAEOGWmVlrpoRcQ20CgYAPcBhPoWAAmWIBfsKVOZ+pnW9HL6DSwu6D1bJV/K3/MorieBmZ59780lT2L9g271mfUuzbO17kbsPohcLSHF6B68CjEOt2zel9H9P5TsLPBus3/dC07ORbvrgwST+UDRWxc9Od2Ry2qMvnDlTb4wMrVMvPMycsyii1YSezZmLIPg==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqh2pXi8kdQDJlHQUEvkkARGhcem2+mPXSPK6lcCzY6DU+JBl3X6LRx3FNQu3vh9y8NEkUYaCEKvHQzNwcRiyGm34AjkrsLnoS0uJmlED1jlMkU7zR4Cto+55e2AOGWYULJfIUd9d5p5VXuW43pYtv8fEydBsBkrEoFEGQvh9EdODLajX+i1qxvI4rhi93HULUS/pt36i/iI6ZMlu+W6I1mGaiIi+7LbssuNlNWakVnNNw5l1MbZe3tE6UyY/sX2ishs/ZhfwXIIfGRdoqcK6ughAqRKcSEfK9zjyKfBVJZ+tP12vQBw9VIpdJlptqiztP7yYizRGST3ODsW3Pu41GwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipaytest/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipaytest/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "E:\\计算机\\支付宝开放平台-沙箱环境操作\\logpay";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

