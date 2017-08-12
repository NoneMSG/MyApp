package com.jx372.myapp.ui.user;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jx372.myapp.R;
import com.jx372.myapp.core.domain.User;

import java.util.List;

/**
 * Created by bit-user on 2017-08-12.
 */

public class UserListArrayAdapter extends ArrayAdapter<User> {
    private LayoutInflater layoutInflater;

    public UserListArrayAdapter(@NonNull Context context) {
        super(context, R.layout.row_user_list );
        layoutInflater = LayoutInflater.from( context );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if( view == null ) {
            view = layoutInflater.inflate( R.layout.row_user_list, parent, false );
        }

        User user = getItem( position );
        ((TextView)view.findViewById( R.id.name )).setText( user.getName() );

        return view;
    }

    public void add(List<User> list ){
        if( list == null ) {
            return;
        }

        for( User user : list ){
            add( user );
        }
    }
}
