package demo.lww.test.ucdemo1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> list;


    public MyAdapter(ArrayList<String> data) {
        this.list = data;
    }



    public void addList(List<String> items) {
        this.list.addAll(items);notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
          return  viewHolder;

    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
// 绑定数据
      holder.mTv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
          return list == null ? 0 : list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }

}
