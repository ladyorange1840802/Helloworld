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
        //设置除抽屉以外的View为透明的
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
		//获得主视图中的第一个
		Log.e("arg1==", arg1+"");
		View mContent=draw.getChildAt(0);
		//获得滑出的抽屉
		View mMenu=arg0;
		
		float scale=1-arg1;
		//获得滑出抽屉的宽度
		int mMenuwidth=mMenu.getMeasuredWidth();
		
		float leftScale=0.8f+scale*0.2f;
		
		
		//给主页面设置缩放
		ViewHelper.setScaleX(mContent, leftScale);
		ViewHelper.setScaleY(mContent, leftScale);
		
		//给抽屉设置缩放
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
