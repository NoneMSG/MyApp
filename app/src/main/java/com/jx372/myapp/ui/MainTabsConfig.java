package com.jx372.myapp.ui;

import android.os.Bundle;

import com.jx372.myapp.R;
import com.jx372.myapp.ui.tabs.Tabs1Fragment;
import com.jx372.myapp.ui.tabs.Tabs2Fragment;
import com.jx372.myapp.ui.tabs.Tabs3Fragment;
import com.jx372.myapp.ui.user.UserListFragment;

public final class MainTabsConfig {

    private static final TabInfo[] TABINFOS = {
       new TabInfo( "탭1", R.drawable.ic_online, R.drawable.ic_online_selected, UserListFragment.class, null ),
       new TabInfo( "탭2", R.drawable.ic_chat, R.drawable.ic_chat_selected, Tabs1Fragment.class, null ),
       new TabInfo( "탭3", R.drawable.ic_profile, R.drawable.ic_profile_selected, Tabs2Fragment.class, null ),
       new TabInfo( "탭4", R.drawable.ic_more, R.drawable.ic_more_selected, Tabs3Fragment.class, null )
    };

    public static final class TABINDEX {
       	public static final int USERLIST = 0;
       	public static final int CHANNELLIST = 1;
       	public static final int SETTINGS = 2;
       	
       	public static final int FIRST = 0;
       	public static final int LAST = TABINFOS.length;
    };
    
    public static final int COUNT_TABS() {
    	return TABINFOS.length;
    }
    
    public static final TabInfo TABINFO( int index ) {
    	return ( index < 0 || index >= COUNT_TABS() )  ? null : TABINFOS[ index ];
    }
    
    public static final class TabInfo {
		public final String tag;
		public final int drawableNormal;
		public final int drawableSelected;
        public final Class<?> klass;
        public final Bundle bundle;
        TabInfo( String tag, int drawableNormal, int drawableSelected, Class<?> klass, Bundle bundle ) {
            this.tag = tag;
            this.drawableNormal = drawableNormal;
            this.drawableSelected = drawableSelected;
            this.klass = klass;
            this.bundle = bundle;
        }
    }
}