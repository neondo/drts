package com.neon.rtp.uitl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Arrays;

/**
 * @author Neon
 * @date 2020/12/12 0012 23:11
 */
public class FileUtil{

    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    public static InputStream getInputStream(String path) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(path));
        } catch(FileNotFoundException e) {
            LOG.error("", e);
            throw new OperateException("文件读取失败");
        }
        return fileInputStream;
    }

    public static OutputStream getOutputStream(String path) {
        FileOutputStream os;
        try {
            os = new FileOutputStream(new File(path));
        } catch(FileNotFoundException e) {
            LOG.error("", e);
            throw new OperateException("文件读取失败");
        }
        return os;
    }

    public static void write(String path, IRun<BufferedWriter> run) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            run.run(bw);
            close(bw);
        } catch(IOException e) {
            e.printStackTrace();
            throw new OperateException(path + ",文件写入失败");
        }
    }

    public static void read(String path, IRun<String> run) {
        try {
            FileReader in = new FileReader(path);
            BufferedReader br = new BufferedReader(in);
            br.lines().forEach(run::run);
            close(br);
        } catch(IOException e) {
            e.printStackTrace();
            throw new OperateException(path + ",文件写入失败");
        }
    }

    public static void writeLine(Writer bw, String o) {
        try {
            bw.write(o);
        } catch(IOException e) {
            throw new OperateException("写入异常");
        }
    }

    public static void writeNewLine(Writer bw) {
        try {
            bw.write("\n");
        } catch(IOException e) {
            throw new OperateException("写入异常");
        }
    }

    public interface IRun<T>{

        void run(T b);
    }

    public static void close(Closeable... stream) {
        if(stream == null)
            return;
        Arrays.stream(stream).forEachOrdered(closeable->{
            try {
                closeable.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        });
    }
}
