## IDEA搭建《算法》第四版的开发环境

网上的很多做法是用eclipse导入的，还要很多关于algs4.jar的配置，其实不管用eclipse导入还是用IDEA导入，最主要的问题就是文件的重定想，其实只要项目中的程序可以运行（不用再命令行运行），可以通过下面的的配置让程序读入文件作为输入。（我的IDEA是2019.2版本的，好像有的老版本不支持这个功能）。

![IDEA重定向文件输入](http://thinkfree.club/idea%E6%96%87%E4%BB%B6%E9%87%8D%E5%AE%9A%E5%90%91%E8%BE%93%E5%85%A5.png)



---

### 还看到这样的解决办法

遇到了一样的问题。我是在学习algorithm 4 edition上的代码并测试，然后想找改动书上源代码不大的方式，因为命令行跑起来还是有一点麻烦的（Intellij IDEA真是太好用了）。最后找到了一个方法：文件路径放在测试的参数里，然后在测试代码前加一个把文件读到标准输入流的操作。

```java
FileInputStream input;
try {
    input = new FileInputStream(args[0]);
    System.setIn(input);
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
```

