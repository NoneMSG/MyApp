package com.jx372.myapp.ui.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jx372.myapp.R;
import com.jx372.myapp.core.domain.User;
import com.jx372.myapp.core.network.SafeAsyncTask;
import com.jx372.myapp.core.provider.UserProvider;

import java.util.List;

/**
 * Created by bit-user on 2017-08-12.
 */

public class UserListFragment extends ListFragment {
    private UserListArrayAdapter userListArrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        userListArrayAdapter = new UserListArrayAdapter( getActivity() );
        setListAdapter( userListArrayAdapter );
        return inflater.inflate( R.layout.fragment_user_list, container, false );
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new FetchUserListAyncTask().execute();
    }

    private class FetchUserListAyncTask extends SafeAsyncTask<List<User>>{
        @Override
        public List<User> call() throws Exception {
            List<User> list = new UserProvider().fetchUserList();
            return list;
        }

        @Override
        protected void onException(Exception e) throws RuntimeException {
            System.out.println( e );
        }

        @Override
        protected void onSuccess(List<User> users) throws Exception {
            userListArrayAdapter.add( users );
            getView().findViewById( R.id.progress ).setVisibility( View.GONE );
        }
    }
}
