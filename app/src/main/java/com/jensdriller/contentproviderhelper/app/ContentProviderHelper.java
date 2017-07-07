package com.jensdriller.contentproviderhelper.app;

import android.app.Application;
import android.content.Context;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.jensdriller.contentproviderhelper.R;

public class ContentProviderHelper extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
	}

	public static int getUserTheme(Context context) {
		String themeKey = context.getString(R.string.preferences_key_theme);
		String themeDefault = context.getString(R.string.preferences_default_theme);
		String themeDark = context.getString(R.string.preferences_theme_dark);
		String themeLight = context.getString(R.string.preferences_theme_light);

		String theme = PreferenceManager.getDefaultSharedPreferences(context).getString(themeKey, themeDefault);
		if (theme.equals(themeDark)) {
			return R.style.Theme_AppCompat;
		} else if (theme.equals(themeLight)) {
			return R.style.Theme_AppCompat_Light;
		} else {
			return R.style.Theme_AppCompat_Light_DarkActionBar;
		}
	}

	public static void handleException(Context context, Exception e, boolean sendReport) {
		e.printStackTrace();
		Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
	}
}
