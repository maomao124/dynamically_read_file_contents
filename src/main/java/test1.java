import java.awt.*;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * Project name(项目名称)：动态读取文件内容
 * Package(包名): PACKAGE_NAME
 * Class(类名): test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/20
 * Time(创建时间)： 22:35
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test1
{
    public static void main(String[] args)
    {
        RandomAccessFile accessFile = null;
        RandomAccessFile accessFile1 = null;
        try
        {
            accessFile = new RandomAccessFile("test1.txt", "rw");
            accessFile1 = new RandomAccessFile("test1.txt", "r");
            System.out.println("当前写指针：" + accessFile.getFilePointer());
            accessFile.writeChar('a');
            accessFile.writeFloat(32.58f);
            accessFile.writeDouble(36987.123);
            accessFile.writeInt(258);
            long position = accessFile.getFilePointer();
            System.out.println("当前写指针：" + position);
            accessFile.writeUTF("hello,你好！！！");
            System.out.println("最后的写指针：" + accessFile.getFilePointer());
            System.out.println("当前写指针：" + accessFile1.getFilePointer());
            accessFile1.seek(position);
            System.out.println("现在写指针：" + accessFile1.getFilePointer());
            System.out.println("字符串（utf-8）：" + accessFile1.readUTF());
            System.out.println("现在写指针：" + accessFile1.getFilePointer());
            System.out.println("设置写指针为0");
            accessFile1.seek(0);
            System.out.println("现在写指针：" + accessFile1.getFilePointer());
            System.out.println("字符：" + accessFile1.readChar());
            System.out.println("现在写指针：" + accessFile1.getFilePointer());
            System.out.println("float:" + accessFile1.readFloat());
            System.out.println("现在写指针：" + accessFile1.getFilePointer());
            System.out.println("double:" + accessFile1.readDouble());
            System.out.println("现在写指针：" + accessFile1.getFilePointer());
            System.out.println("int:" + accessFile1.readInt());
            System.out.println("现在写指针：" + accessFile1.getFilePointer());
        }
        catch (FileNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件未找到！！");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (accessFile != null)
                {
                    accessFile.close();
                }
                if (accessFile1 != null)
                {
                    accessFile1.close();
                }
                System.out.println("文件流已关闭");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
