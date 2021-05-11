package com.example.httpgetreequest;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Http extends AppCompatActivity {
    public void GTE() {
        try {
            //实例化一个URL对象
            URL url = new URL("https://www.baidu.com/");
            try {
                //获取HttpURLConnection实例
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                //设置和请求相关的属性
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(6000);
                //获取响应码并获取响应数据
                if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                    //实例化一个响应流
                    InputStream in = conn.getInputStream();
                    //实例化一个数组
                    byte[] b = new byte[1024];
                    //int一个长度
                    int len = 0;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    //将字节数组里面的内容写入缓存流
                    while((len = in.read(b))>-1){
                        //参数一：待写入的数组   参数二：起点    参数三：长度
                        baos.write(b,0,len);
                    }
                    //在控制台上显示出获取的数据
                    String msg = new String(baos.toByteArray());
                    Log.e("TAG",msg+"==========");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
