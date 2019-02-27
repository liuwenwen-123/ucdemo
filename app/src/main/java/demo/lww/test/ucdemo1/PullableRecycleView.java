package demo.lww.test.ucdemo1;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;


/**
 * Created by Administrator on 2018/9/26 0026.
 */

public class PullableRecycleView extends RecyclerView implements Pullable {

    public PullableRecycleView(Context context) {
        super(context);
    }

    public PullableRecycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullableRecycleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown() {
 /*(((LinearLayoutManager) getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0 ||
  ((LinearLayoutManager) getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 1) &&
  (mHeaderView.getVisibleHeight() > 0 || distanceY > 0)*/




        LinearLayoutManager layoutManager = (LinearLayoutManager)getLayoutManager();

         if(layoutManager.getItemCount()==0){
             return  true;
         }else if(layoutManager.findFirstVisibleItemPosition() == 0 &&  layoutManager.findViewByPosition(0).getTop() >= 0){
             return  true;
         }else {
             return false;
         }

        /*if ((((LinearLayoutManager) getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0 ||
                ((LinearLayoutManager) getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 1)
                ) {
            // 没有item的时候也可以下拉刷新
            return true;
        }  else  if (layoutManager.findFirstVisibleItemPosition() == 0
                && layoutManager.findViewByPosition(0).getTop() >= 0) {
            // 滑到ListView的顶部了
            return true;
        }  else
            return false;*/
    }

    @Override
    public boolean canPullUp() {
        LinearLayoutManager layoutManager = (LinearLayoutManager)getLayoutManager();
        if (layoutManager.getItemCount() == 0) {
            // 没有item的时候也可以上拉加载
            return true;
        } else if (layoutManager.findLastVisibleItemPosition()  == (layoutManager.getItemCount() - 1)) {
            // 滑到底部了
            if (getChildAt(layoutManager.findLastVisibleItemPosition() - layoutManager.findFirstVisibleItemPosition()) != null
                    && getChildAt(
                    layoutManager.findLastVisibleItemPosition()
                            - layoutManager.findFirstVisibleItemPosition()).getBottom() <= getMeasuredHeight())
                return true;
        }
        return false;
    }
}