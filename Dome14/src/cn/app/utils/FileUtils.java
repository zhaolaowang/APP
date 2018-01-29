package cn.app.utils;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import cn.app.pojo.AppInfo;
import cn.app.pojo.AppVersion;

public class FileUtils {

	/**
	 * 上传文件并且返回app的路径
	 * 
	 * @param appinfo
	 * @param multipart
	 * @param request
	 * @return
	 */
	public static AppInfo setAppFilePath(AppInfo appinfo,
			MultipartFile multipart, HttpServletRequest request) {
		String logoPicPath = null;
		String logoLocPath = null;
		String path = request.getSession().getServletContext()
				.getRealPath("statics" + File.separator + "uploadfiles");// 定义存储的位置
		// 判断文件是否为空
		if (multipart != null && !multipart.isEmpty()) {
			String oldFileName = multipart.getOriginalFilename();// 原文件名
			String prefix = FilenameUtils.getExtension(oldFileName); // 获取源文件名的后缀
			int filesize = 5000000; // 定义一个文件大小 500 kb
			if (multipart.getSize() > filesize) {
				request.setAttribute("fileUploadError", "上传的文件大小不得超过  50 kb");
				return null;
			} else if (prefix.equalsIgnoreCase("jpg")
					|| prefix.equalsIgnoreCase("png")
					|| prefix.equalsIgnoreCase("jpeg")
					|| prefix.equalsIgnoreCase("pneg")) {
				File targetFile = new File(path, oldFileName); // 新建文件//
																// （1.路径，2.文件名）
				if (!targetFile.exists()) {
					targetFile.mkdirs(); // 新建文件
					try {
						multipart.transferTo(targetFile);
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute("fileUploadError", "上传失败！");
						return null;
					}
					logoLocPath = path + File.separator + oldFileName; // d:////
					logoPicPath = request.getContextPath()
							+ "/statics/uploadfiles/" + oldFileName;
				}
			}
		} else {
			request.setAttribute("fileUploadError", "上传的文件格式不正确");
			return null;
		}
		appinfo.setLogoLocPath(logoLocPath);
		appinfo.setLogoPicPath(logoPicPath);
		return appinfo;
	}

	/**
	 * 填充app版本的路径
	 * 
	 * @param appVersion
	 * @param multipart
	 * @param request
	 * @return
	 */
	public static AppVersion setAppVersionApkPath(AppVersion appVersion,
			MultipartFile multipart, HttpServletRequest request) {
		String downloadLink = null;
		String apkLocPath = null;
		String oldFileName = null;
		String path = request.getSession().getServletContext()
				.getRealPath("statics" + File.separator + "uploadfiles");// 定义存储的位置
		if (multipart != null && !multipart.isEmpty()) {
			oldFileName = multipart.getOriginalFilename();// 原文件名
			String prefix = FilenameUtils.getExtension(oldFileName); // 获取源文件名的后缀
			int filesize = 500000000; // 定义一个文件大小 500 MB
			if (multipart.getSize() > filesize) {
				request.setAttribute("fileUploadError", "上传的文件大小不得超过  500 MB");
				return null;
			} else if (prefix.equalsIgnoreCase("apk")) {
				File targetFile = new File(path, oldFileName); // 新建文件 //
																// （1.路径，2.文件名）
				if (!targetFile.exists()) {
					targetFile.mkdirs(); // 新建文件
					try {
						multipart.transferTo(targetFile);
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute("fileUploadError", "上传失败！");
						return null;
					}
					apkLocPath = path + File.separator + oldFileName; // d:////
					downloadLink = request.getContextPath()
							+ "/statics/uploadfiles/" + oldFileName;
				}
			}
		} else {
			request.setAttribute("fileUploadError", "上传的文件格式不正确");
			return null;
		}
		appVersion.setApkFileName(oldFileName);
		appVersion.setApkLocPath(apkLocPath);
		appVersion.setDownloadLink(downloadLink);
		return appVersion;
	}
}
