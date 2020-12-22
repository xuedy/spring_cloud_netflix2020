package com.xue.example.springcloudoauthserver8085.controller;

/**
 * JWT :json web tokens
 * 由
 * head：
 * {
 *   "alg": "HS256",//签名算法  HS256 RS256 ES256
 *   "typ": "JWT" //类型自定义
 * }
 * 书籍 https
 * 【数字签名 防止伪造的机制】 举例  签名=加密（摘要（原始数据））
 * 【摘要、指紋 hash值，SHA1 SHA256 MD5 原始数据 ===MD5（原始数据）】
 * 【加密  对称加密（同一把钥匙），非对称加密（公钥和私钥）】
 *
 *  HS256 对称加密算法
 *  RS256  ES256 非对称加密
 * payload：
 * 要传输的内容，json或字符串
 * Claims
 * {
 *   "sub": "1234567890",//主题
 *   "name": "John Doe", //名称
 *   "admin": true,
 *   "iat": 1516239022  //时间戳
 * }
 * signature ：
 * 签名
 * 三部分组成
 * signature=HS256（base64（header）+.+base64(payload),secret_key）
 * jwt ： base64（header）+.+base64(payload)+.signature
 * 示例见 jwt.io
 */
public class JWTController {
    //TODO
}
