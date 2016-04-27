package org.web.tool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;


public class Spider {
	private static HttpClient httpClient =new HttpClient();
	 /**  * @param path  *            Ŀ����ҳ������  * @return ���ز���ֵ����ʾ�Ƿ���������Ŀ��ҳ��  * @throws Exception  *             ��ȡ��ҳ����д�뱾���ļ�����IO�쳣  */
	public static boolean downloadPage(String path) throws Exception {
		InputStream input = null;
		OutputStream output = null;
		GetMethod getMethod = new GetMethod(path);
		int statusCode = httpClient.executeMethod(getMethod);
		if (statusCode == HttpStatus.SC_OK) {
			System.out.println("hello");
			input = getMethod.getResponseBodyAsStream();
//			String filename = path.substring(path.lastIndexOf('/') + 1)     + ".html";
			String filename = "temp3.txt";
//			File file = new File(filename);
//			if(!file.exists()){
//				file.createNewFile();
//			}
			
			output = new FileOutputStream(filename);
			int tempByte = -1;
			while ((tempByte = input.read()) > 0) {
				output.write(tempByte);
//				System.out.print((char)tempByte);
			}
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
			return true;
		}
		return false;
	}
//	public static void main(String[] args) {
//		try {
//			Spider.downloadPage("https://list.lu.com/list/all");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
