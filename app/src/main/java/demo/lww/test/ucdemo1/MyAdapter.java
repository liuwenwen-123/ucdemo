package demo.lww.test.ucdemo1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> list;

    public void addList(List<String> items) {
        this.list.addAll(items);notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

          return  null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class MenuItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView newsType;
        public MenuItemViewHolder(View v) {
            super(v);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
