package com.example.drawlayout_qq;

import com.nineoldandroids.view.ViewHelper;

import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements DrawerListener{
	
	private DrawerLayout draw;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        draw=(DrawerLayout)findViewById(R.id.draw);
        draw.setDrawerListener(this);
        //���ó����������ViewΪ͸����
        draw.setScrimColor(Color.TRANSPARENT);
        
        draw.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.END);
    }

    public void click(View v){
    	draw.openDrawer(Gravity.END);
    	draw.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, Gravity.END);
    }

	@Override
	public void onDrawerClosed(View arg0) {
		// TODO Auto-generated method stub
		draw.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.END);
	}

	@Override
	public void onDrawerOpened(View arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDrawerSlide(View arg0, float arg1) {
		// TODO Auto-generated method stub
		//�������ͼ�еĵ�һ��
		Log.e("arg1==", arg1+"");
		View mContent=draw.getChildAt(0);
		//��û����ĳ���
		View mMenu=arg0;
		
		float scale=1-arg1;
		//��û�������Ŀ��
		int mMenuwidth=mMenu.getMeasuredWidth();
		
		float leftScale=0.8f+scale*0.2f;
		
		
		//����ҳ����������
		ViewHelper.setScaleX(mContent, leftScale);
		ViewHelper.setScaleY(mContent, leftScale);
		
		//��������������
		ViewHelper.setScaleX(mMenu, 0.7f+0.3f*arg1);
		ViewHelper.setScaleY(mMenu, 0.7f+0.3f*arg1);
		
		if(arg0.getTag().equals("Left")){
			ViewHelper.setTranslationX(mContent, mMenuwidth*arg1);
		}else{
			ViewHelper.setTranslationX(mContent, -mMenuwidth*arg1);
		}
		
		
	}

	@Override
	public void onDrawerStateChanged(int arg0) {
		// TODO Auto-generated method stub
	}

    
}
