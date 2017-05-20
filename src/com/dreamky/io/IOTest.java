package com.dreamky.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest {

	public static void copyFile(String src, String tar) {

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(new File(src)));
			bos = new BufferedOutputStream(new FileOutputStream(new File(tar)));

			byte[] b = new byte[2];
			int len = 0;
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
				bos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

	}

	public static void printFromFile(String src) {

		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(new File(src)));
			byte[] b = new byte[8];
			int len = 0;
			while ((len = bis.read(b)) != -1) {
				System.out.print(new String(b));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

	public static void writeInFile(String tar, String content) {

		File file = new File(tar);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			byte[] bytes = content.getBytes();
			fos.write(bytes);
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		// writeInFile("test.txt", "测试");
		//printFromFile("test.txt");
		copyFile("test.txt", "target.txt");
	}

}
