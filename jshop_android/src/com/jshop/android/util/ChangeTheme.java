package com.jshop.android.util;


import com.jshop.android.index.R;

import android.app.Activity;
import android.content.Intent;


public class ChangeTheme {
	private static int sTheme;
	
	public final static int THEME_DEFAULT = 0;
	public final static int THEME_Grey = 1;
	public final static int THEME_Orange = 2;
	
	public static void changeToTheme(Activity activity,int theme)
	{
		sTheme = theme;
		activity.finish();
		activity.startActivity(new Intent(activity,activity.getClass()));
	}
	
	public static void onActivityCreateSetTheme(Activity activity)
	{
		switch(sTheme)
		{	
			default:
			case THEME_DEFAULT:
				activity.setTheme(R.style.Theme_Blue);
				break;
			case THEME_Grey:
				activity.setTheme(R.style.Theme_Grey);
				break;
			case THEME_Orange:
				activity.setTheme(R.style.Theme_Orange);
				break;			
		}
	}
}
