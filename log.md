Android系统和Windows系统一样既有内部存储也有外部存储，当需要存储一些数据时既可以选择内部存储、也可以选择外部存储，当用户登录成功，会将用户名和密码保存在本地，使用的就是内部存储。

(1)内部存储：当点击登录后会获取输入框中的用户名和密码，创建文件输出流对象，将用户和密码以字节数组的形式写入文件
info.txt中，结束后关闭文件输出流；如果本地存在info.txt(意味着这并不是第一次登录)，创建文件输入流对象，把字节流
转换成字符流，读取txt文件里的用户名和密码再将用户名和密码设置到输入框中。

(2)外部存储：首先需要注意的是想要对SD卡进行读写需要开启对SD卡的读写权限。获取输入的用户名和密码后，如果SD卡为已
挂载状态，创建输出流并把用户名密码写入info.txt，否则提示SD卡不可用；如果SD卡正常挂载，并且存在info.txt,读取
txt文件里的用户名和密码再将用户名和密码设置到输入框中。

(3)SharedPreferences：使用SharedPreferences储存用户名和密码是直接处理xml文件的，不需要做字符串分割，存储效率
会比内部存储和外部存储高。获取输入框中的用户名和密码，创建SharedPreferences对象，设置访问权限为私有，获得
SharedPreferences编辑器，以键值对的形式将用户名和密码保存到SharedPreferences中，提交用户名和密码。如果本地
已经保存了用户名和密码，创建SharedPreferences对象，获得保存在SharedPreferences中的用户名和密码，并显示在输
入框中。

(3)SQLite：Android中直接集成了SQLite数据库，使用起来非常方便。新建一个Db文件，用于创建数据库和更新数据库，
创建user表，字段分别为自增id，username，password。点击登录后调用sqliteinsert方法，获取输入框中的用户名和
密码，以键值对的形式往user存储数据；如果数据库里有用户名和密码，读取数据显示到输入框中。
