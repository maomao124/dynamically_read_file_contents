import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：动态读取文件内容
 * Package(包名): PACKAGE_NAME
 * Class(类名): RandomAccessFile
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/20
 * Time(创建时间)： 22:12
 * Version(版本): 1.0
 * Description(描述)： 所谓动态读取是指从文件的任意位置开始访问文件，而不是必须从文件开始位置读取到文件末尾。
 * 动态读取需要用到 Java 中的 RandomAccessFile 类。
 * RandomAccessFile 是 Java 输入/输出流体系中功能最丰富的文件内容访问类，它提供了众多的方法来访问文件内容，它既可以读取文件内容，
 * 也可以向文件输出数据。由于 RandomAccessFile 可以从任意位置访问文件，所以在只需要访问文件部分内容的情况下，使用 RandonAccessFile 类是一个很好的选择。
 * RandomAccessFile 对象包含了一个记录指针，用以标识当前读写处的位置，当程序新创建一个 RandomAccessFile 对象时，
 * 该对象的文件记录指针位于文件头（也就是 0 处），当读/写了 n 个字节后，文件记录指针将会向后移动 n 个字节。
 * 除此之外，RandonAccessFile 可以自由移动该记录指针，既可以向前移动，也可以向后移动。
 * RandomAccessFile 类的常用方法
 * 方法名及返回值类型	         说明
 * boolean readBoolean()	从文件中读取一个 boolean 值
 * byte readByte()	        从文件中读取一个带符号位的字节
 * char readChar()	        从文件中读取一个字符
 * int readlnt()	        从文件中读取一个带符号位的整数
 * long readLong()	        从文件中读取一个带符号位的 long 值
 * String readLine()	    从文件中读取下一行文本
 * void seek(long pos)	    指定从文件起始位置开始的指针偏移量
 * void writeBoolean(boolean v)	以字节的形式向文件中写入一个 boolean 值
 * void writeByte(int v)	以单字节的形式向文件中写入一个 byte 值
 * void writeChar(int v)	以双字节的形式向文件中写入一个 char 值
 * void writelnt(int v)	    以4字节的形式向文件中写入一个整数
 * writeLong(long v)	    以8字节的形式向文件中写入一个 long 值
 * void writeBytes(String s)	以字节序列的形式向文件中写入一个字符串
 * void skipBytes(int n)	以当前文件指针位置为起始点，跳过 n 字节
 * RandomAccessFile 类的构造方法有如下两种重载形式。
 * RandomAccessFile(File file, String mode)：访问参数 file 指定的文件，访问形式由参数 mode 指定，
 * mode 参数有两个常用的可选值 r 和 rw，其中 r 表示只读，rw 表示读写。
 * RandomAccessFile(String name, String mode)：访问参数 name 指定的文件，mode 参数的含义同上。
 */

@SuppressWarnings("all")
public class RandomAccessFile_test
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File("test.txt"); // 指定文件路径
            if (file.exists())
            { // 判断文件是否存在
                file.delete();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            String str1 = "晴天，阴天，多云，小雨，大风，中雨，小雪，雷阵雨";    // 要写入的字符串
            String str2 = new String(str1.getBytes("gbk"), StandardCharsets.ISO_8859_1);    // 编码转换
            raf.writeBytes(str2);    //写入文件
            System.out.println("当前文件指针的位置：" + raf.getFilePointer());
            raf.seek(6); // 移动文件指针
            System.out.println("从文件头跳过6个字节，现在文件内容如下：");
            byte[] buffer = new byte[2];
            int len = 0;
            while ((len = raf.read(buffer, 0, 2)) != -1)
            {
                System.out.print(new String(buffer, 0, len)); // 输出文件内容
            }
        }
        catch (IOException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.print(e.getMessage());
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }

    }
}
