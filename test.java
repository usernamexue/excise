package com.orilore.gyx.afternoon;
import java.io.*;
import java.util.*;
public class test {
	public static void mian(String[] args){
		//字符流
		//InputStreamReader;
		//OutputStreamWeader;
		try {
			FileOutputStream fout = new FileOutputStream("");
			OutputStreamWriter writer = new OutputStreamWriter(fout,"UTF-8");
			writer.write("大家好！我是字符流！！！");
			writer.write("\n");
			writer.write("我很好");
			writer.flush();
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
/////////////////////////////////////
package com.orilore.gyx.afternoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class test2 {
	public static void mian(String[] args){
		try {
			FileInputStream finput = new FileInputStream("");
			InputStreamReader reader = new InputStreamReader(finput,"UTF-8");
			char[] a = new char[10];
			int readlength = 0;
//			String str = new String(a);
//			System.out.println(str);
			while((readlength=reader.read(a))!=-1){
				String str = new String(a,0,readlength);
				System.out.println(str);
			}
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
////////////////////////////////////
package com.orilore.gyx.afternoon;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class test3 {
    //两对字符流:OutputStreamWriter;InputStreamReader
	//       :BufferWriter; BufferReader
	//字节流四对:fileInputStream,fileOutputStream
	//        ObjectInputStream,ObjectOutputStream
	//        BufferInputStream,BufferOutputStream
	//        DateInputStream,DateOutputStream
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("欢迎来到写字板！");
		boolean flag = true;
		System.out.println("请输入你想保存的文件名称！");
		String filepath = s.next();
			File file = new File(filepath);
			BufferedWriter writer = null;
			if(!file.exists()){
				try {
					boolean isexist = file.createNewFile();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			while(flag){
				FileOutputStream fout;
					try {
						fout = new FileOutputStream(file,true);
						writer = new BufferedWriter(new OutputStreamWriter(fout));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("请输入一行文本！！");
					String str = s.next();
					try {
						writer.write(str);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						writer.newLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
	}
}
///////////////////////////////////
package com.orilore.gyx.afternoon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class test4 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		while(flag){
			System.out.println("请输入您要选择复制的文件");
			String inputdirname = s.next();
			File file = new File(inputdirname);
			if(file.exists()){
				if(file.isDirectory()){
					File[] files = file.listFiles();
					for(File f:files){
						if(f.isFile()){
							System.out.println(f.getName());
						}
					}
					System.out.println("请输入您要复制的文件名字");
					String cstr = s.next();
					boolean flag1 = true;
					String cdirname = null;
					while(flag1){
						System.out.println("请输入您要复制到哪个文件夹");
						cdirname = s.next();
						File checkfile = new File(cdirname);
						if(checkfile.exists()&&checkfile.isDirectory()){
							break;
						}else{
							System.out.println("输入有错误请重新输入");
							continue;
						}
					}
					try {
						FileInputStream finput = new FileInputStream(inputdirname+"/"+cstr);
						FileOutputStream fout  = new FileOutputStream(cdirname+"/"+cstr);
						//加快批量处理
						int read = 0;
						try {
							while((read=finput.read())!=-1){
								fout.write(read);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							fout.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							fout.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							finput.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("您是否继续YES继续");
						String userinput = s.next();
						if(!"yes".equalsIgnoreCase(userinput)){
							break;
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				else{
					System.out.println("对不起我要的是文件夹不是文件请重新输入");
					continue;
				}
				}
			else{
				System.out.println("您输入的文件夹不存在请重新输入");
				continue;
			}
		}
	}

}
/////////////////////////////
package com.orilore.gyx.afternoon;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test5 {
	public static void mian(String[] args){
		try {
			FileOutputStream fout = new FileOutputStream("");
			DataOutputStream dout = new DataOutputStream(fout);
			try {
				dout.writeUTF("hello java world!!");
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				dout.writeUTF("lisence");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				dout.writeLong(1567898);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dout.writeBoolean(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dout.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
///////////////////////////////////
package com.orilore.gyx.afternoon;

import java.io.DataInputStream;
import java.io.FileInputStream;
public class test6 {
	public static void main(String[] args){
		try {
			FileInputStream finput = new FileInputStream("");
			DataInputStream dinput = new DataInputStream(finput);
			String r = dinput.readUTF();
			System.out.println(r);
			dinput.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//////////////////////////////////
package com.orilore.gyx.afternoon;

import java.io.DataInputStream;
import java.io.FileInputStream;
public class test6 {
	public static void main(String[] args){
		try {
			FileInputStream finput = new FileInputStream("");
			DataInputStream dinput = new DataInputStream(finput);
			String r = dinput.readUTF();
			System.out.println(r);
			dinput.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//////////////////////////////////
package com.orilore.gyx.afternoon;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class test7 {
	public static void mian(String[] args){
		try {
			FileOutputStream fout = new FileOutputStream("");
			OutputStreamWriter writer = new OutputStreamWriter(fout,"UTF-8");
			BufferedWriter bwriter = new BufferedWriter(writer);
			bwriter.write("白日依山尽");
			bwriter.newLine();
			bwriter.write("黄河入海流");
			bwriter.newLine();
			bwriter.write("欲穷千里目");
			bwriter.newLine();
			bwriter.write("更上一层楼");
			bwriter.flush();
			bwriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
////////////////////////////////
package com.orilore.gyx.afternoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class test8 {
	public static void main(String[] args){
		try {
			FileInputStream finput = new FileInputStream("");
			InputStreamReader reader = new InputStreamReader(finput,"UTF-8");
			BufferedReader breader = new BufferedReader(reader);
			String strline = "";
			while((strline = breader.readLine())!=null){
				System.out.println(strline);
			}
			breader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
//////////////////////////////////
package com.orilore.gyx.book;
import java.io.*;
public class BufferedIO {
	public static void dump(InputStream src,OutputStream dest)
	throws IOException{
		try(InputStream  input = new BufferedInputStream(src);
			OutputStream output = new BufferedOutputStream(dest)){
			byte[] data = new byte[1024];
			int length;
			while((length= input.read(data))!=-1){
				output.write(data,0,length);
			}
		}
	}
}
///////////////////////////////////
package com.orilore.gyx.book;
import java.io.*;
public class Copy {
	public static void mian(String[] args)throws IOException{
		IO.dump(
				new FileInputStream(args[0]),
				new FileOutputStream(args[1])
				);
	}
}
///////////////////////////////////
package com.orilore.gyx.book;
import java.io.*;
import java.net.URL;
public class Download {
	public static void main(String[] args)throws IOException{
		URL url = new URL(args[0]);
		InputStream src = url.openStream();
		OutputStream dest = new FileOutputStream(args[1]);
		IO.dump(src, dest);
	}
}
///////////////////////////////
package com.orilore.gyx.book;
import java.io.*;
public class IO {
	public static void dump(InputStream src,OutputStream dest)
		throws IOException{
			try(InputStream input = src;OutputStream output = dest){
				byte[] data = new byte[1024];
				int length;
				while((length = input.read(data))!=-1){
					output.write(data,0,length);
			}
		}
	}
}
//////////////////////////
package com.orilore.gyx.book;
import java.io.*;
public class Member {

}
///////////////////////////
package com.orilore.gyx.book;
import java.io.*;
import java.util.*;
public class StandardIn {
	public static void main(String[] args)throws IOException{
		System.setIn(new FileInputStream(args[0]));
		try(Scanner scanner = new Scanner(System.in)){
			while(scanner.hasNextLine()){
				System.out.println(scanner.nextLine());
			}
		} 
	}
}
///////////////////////////////////
package com.orilore.gyx.book;
import java.io.*;
public class StandardOut {
	public static void main(String[] args)throws IOException{
		try(PrintStream printstream = new PrintStream(
				new FileOutputStream(args[0]))){
			System.setOut(printstream);
			System.out.println("hrlloword");
		}
	}
}
