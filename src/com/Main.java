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
	    //����һ��ͼƬ��ʾ�ؼ�
	    private ImageView imageView;
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        //ͼƬ��Դ
	        String url = "http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690";
	        //�õ����õ�ͼƬ
	        Bitmap bitmap = getHttpBitmap(url);
	        imageView = (ImageView)this.findViewById(R.id.imageViewId);
	        //��ʾ
	        imageView.setImageBitmap(bitmap);
	        
	    }
	    /**
	     * ��ȡ����ͼƬ��Դ
	     * @param url
	     * @return
	     */
	    public static Bitmap getHttpBitmap(String url){
	        URL myFileURL;
	        Bitmap bitmap=null;
	        try{
	            myFileURL = new URL(url);
	            //�������
	            HttpURLConnection conn=(HttpURLConnection)myFileURL.openConnection();
	            //���ó�ʱʱ��Ϊ6000���룬conn.setConnectionTiem(0);��ʾû��ʱ������
	            conn.setConnectTimeout(6000);
	            //�������û��������
	            conn.setDoInput(true);
	            //��ʹ�û���
	            conn.setUseCaches(false);
	            //�����п��ޣ�û��Ӱ��
	            //conn.connect();
	            //�õ�������
	            InputStream is = conn.getInputStream();
	            //�����õ�ͼƬ
	            bitmap = BitmapFactory.decodeStream(is);
	            //�ر�������
	            is.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	         
	        return bitmap;
	         
	    }
	}
}
