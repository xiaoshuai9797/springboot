package com.pctc.oss;

import java.io.File;
import java.util.Date;

/**
6.调用测试，OSSUploadUtil工具类对外只提供了几个方法：
OSSUploadUtil.uploadFile(File file, String fileType) //单文件上传，type:文件后缀名
OSSUploadUtil.updateFile(File file, String fileType, String oldUrl)//更新文件:只更新内容，不更新文件名和文件地址。
OSSUploadUtil.replaceFile(File file, String fileType, String oldUrl)//替换文件，删除源文件并上传新文件，文件名和地址也改变
OSSUploadUtil.deleteFile(List<String> fileUrls) //删除多文件，根据问价url来自定获取其中的bucket和文件名，用于bucket和文件名可能存在不同的，循环调用deleteFile方法
OSSUploadUtil.deleteFile(String fileUrl) //删除单文件
OSSUploadUtil.deleteFiles(List<String> fileUrls) //删除多文件，根据配置直接取删除多个文件，bucket和文件地址从配置中获取，用于多文件bucket和文件名都相同的
 *
 */


public class TestOss {

	public static void main(String[] args) {


		//System.out.println(OSSUploadUtil.uploadFile(new File("d:/d1.jpg"),"jpg"));

		//System.out.println(OSSUploadUtil.uploadFile(new File("d:/111.docx"),"docx"));

		//System.out.println(OSSUploadUtil.replaceFile(new File("d:/hello.txt"),"txt","http://pkdpkd.oss-cn-hangzhou.aliyuncs.com/pkd/2CA32F11954E4D55BC5429B63C499334.docx"));

		//System.out.println(OSSUploadUtil.deleteFile("http://pkdpkd.oss-cn-hangzhou.aliyuncs.com/pkd/DF8F394605A14E40B2E1F1698D14EFEA.txt"));

		OSSUploadUtil.getFileObject("xs/9161553FAEEE45D8979D853BA7E31068.jpg","e:/beijing.jpg");

		//System.out.println(OSSUploadUtil.getUrl("xs/9161553FAEEE45D8979D853BA7E31068.jpg", new Date(System.currentTimeMillis()+1000*60)));


	}

}
