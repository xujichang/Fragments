package me.xujichang.lib.fragments.util;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import me.xujichang.lib.common.base.ListStatus;

/**
 * @author xujichang on 2020/5/13.
 */
public class FragmentUtil {

    public static <T, VH extends RecyclerView.ViewHolder> void bindList(Fragment pFragment, final PagedListAdapter<T, VH> pAdapter, LiveData<PagedList<T>> pObjects, LiveData<ListStatus> pStatusLiveData) {
        pObjects
                .observe(pFragment, new Observer<PagedList<T>>() {
                    @Override
                    public void onChanged(PagedList<T> pTS) {
                        pAdapter.submitList(pTS);
                    }
                });
        pStatusLiveData
                .observe(pFragment, new Observer<ListStatus>() {
                    @Override
                    public void onChanged(ListStatus pStatus) {

                    }
                });
    }
}