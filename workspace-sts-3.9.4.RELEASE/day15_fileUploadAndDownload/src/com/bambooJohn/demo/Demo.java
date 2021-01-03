package com.bambooJohn.demo;

public class Demo {
	
	/**
	 * 文件上传&下载：
	 * 	文件上传
	 * 		* 准备：
	 * 			1. 导入commons-fileupload-1.3.1.jar和commons-io-2.5.jar两个jar文件
	 * 			2. form属性 method="post"
	 * 			3. enctype="multipart/form-data"
	 * 			4. <input type="file" name="fileupload">
	 * 		* 步骤：
	 * 			1. 创建工厂类：DiskFileItemFactory
	 * 			2. 创建解析器ServletFileUpload
	 * 			3. 使用解析器中parseRequest(request)方法，将request对象解析为List<FileItem>
	 * 			4. 迭代集合，找到文件类型为File的FileItem
	 * 			5. 使用FileItem中的write()方法，写到服务器。
	 * 	优化文件上传
	 * 		* 使用UUID优化同名无法上传问题
	 * 			* String uuid = UUID.randomUUID().toString().replace("-","")
	 * 		* 设置上传文件的大小
	 * 			* 设置单个文件的上传大小：upload.setFileSizeMax(2*1024);
	 * 			* 设置总文件的上传大小：upload.setSizeMax(2*1024);
	 */
	
}
