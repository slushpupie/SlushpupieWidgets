package com.slushpupie.widget;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NoticePreference extends DialogPreference {
	
	private static final String androidns = "http://schemas.android.com/apk/res/android";
	private Context mContext;
	private String mDialogMessage;
	private TextView mSplashText;

	public NoticePreference(Context context, AttributeSet attrs) {
		super(context, attrs);
	    
		mContext = context;
		
	    int res = attrs.getAttributeResourceValue(androidns, "dialogMessage", -1);
	    if (res == -1) {
	      mDialogMessage = attrs.getAttributeValue(androidns, "dialogMessage");
	    } else {
	      mDialogMessage = context.getText(res).toString();
	    }
	}

	@Override
	  protected View onCreateDialogView() {
	    LinearLayout.LayoutParams params;
	    LinearLayout layout = new LinearLayout(mContext);
	    layout.setOrientation(LinearLayout.VERTICAL);
	    layout.setPadding(6, 6, 6, 6);

	    mSplashText = new TextView(mContext);
	    if (mDialogMessage != null)
	      mSplashText.setText(mDialogMessage);
	    layout.addView(mSplashText);

	    return layout;
	  }

}
