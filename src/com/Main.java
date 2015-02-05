package com;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class Main extends Activity {
	    //定义一个图片显示控件
	    private ImageView imageView;
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        //图片资源
	        String url = "http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690";
	        //得到可用的图片
	        Bitmap bitmap = getHttpBitmap(url);
	        imageView = (ImageView)this.findViewById(R.id.imageViewId);
	        //显示
	        imageView.setImageBitmap(bitmap);
	        
	    }
	    /**
	     * 获取网落图片资源
	     * @param url
	     * @return
	     */
	    public static Bitmap getHttpBitmap(String url){
	        URL myFileURL;
	        Bitmap bitmap=null;
	        try{
	            myFileURL = new URL(url);
	            //获得连接
	            HttpURLConnection conn=(HttpURLConnection)myFileURL.openConnection();
	            //设置超时时间为6000毫秒，conn.setConnectionTiem(0);表示没有时间限制
	            conn.setConnectTimeout(6000);
	            //连接设置获得数据流
	            conn.setDoInput(true);
	            //不使用缓存
	            conn.setUseCaches(false);
	            //这句可有可无，没有影响
	            //conn.connect();
	            //得到数据流
	            InputStream is = conn.getInputStream();
	            //解析得到图片
	            bitmap = BitmapFactory.decodeStream(is);
	            //关闭数据流
	            is.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	         
	        return bitmap;
	         
	    }
	}
}
