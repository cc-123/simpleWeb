package org.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

public class random {
	private String yzms;

	public String getYzms() {
		return yzms;
	}

	public void setYzms(String yzms) {
		this.yzms = yzms;
	}

	public String findRandom() {
		// 验证码字符个数
		int codeCount = 4;
		char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
				'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
				'7', '8', '9' };

		// 创建一个随机数生成器类
		Random random = new Random();
		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();

		for (int i = 0; i < codeCount; i++) {
			// 得到随机产生的验证码数字。
			String strRand = String.valueOf(codeSequence[random.nextInt(36)]);
			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
		}
		//转换为字符串
		yzms = randomCode.toString();
		return "success";
	}

}
