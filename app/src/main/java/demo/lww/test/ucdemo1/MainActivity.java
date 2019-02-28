package demo.lww.test.ucdemo1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import demo.lww.test.ucdemo1.view.UCIndexView;

public class MainActivity extends AppCompatActivity implements PullToRefreshLayout.OnRefreshListener {
    boolean flag = false;

    private UCIndexView mUCIndexView;
    private PullToRefreshLayout mPullToRefreshLayout;
    private PullableRecycleView mRecycleView;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc_index_view);
        mUCIndexView = (UCIndexView) findViewById(R.id.ucindexview);


        mPullToRefreshLayout = ((PullToRefreshLayout) findViewById(R.id.refresh_view));
        mRecycleView = ((PullableRecycleView) findViewById(R.id.trcycle_my_dynamic));
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLinearLayoutManager);

        mRecycleView.setAdapter(new MyAdapter(getData()));
        mPullToRefreshLayout.setOnRefreshListener(this);
    }



    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for(int i = 0; i < 20; i++) {
            data.add(i + temp);
        }

        return data;
    }

    public  void finsh(View view){
        if( !mUCIndexView.isPullRestoreEnable()) {
//            mUCIndexView.onBackRestore();
           mPullToRefreshLayout.setDispatchTouchEvent(true);
         }
    }




    public  void back(View view){
        if( !mUCIndexView.isPullRestoreEnable()) {
            mUCIndexView.onBackRestore();

        }
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                IS_LOAD_MORE=false;
                refreshOver();
            }
        },2000);

    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                IS_LOAD_MORE=true;
                refreshOver();
            }
        },2000);

    }
    private boolean IS_LOAD_MORE=true;
    public  void  refreshOver(){
        new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                // 千万别忘了告诉控件刷新完毕了哦！
                if(IS_LOAD_MORE==true){
                    mPullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
                }else{
                    mPullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
                }

            }
        }.sendEmptyMessageDelayed(0, 1000);
    }

    /*@Override
    public void onBackPressed() {

        if(flag == false && !mUCIndexView.isPullRestoreEnable()) {
            mUCIndexView.onBackRestore();
            flag = true;
        } else {
            super.onBackPressed();
        }
    }*/
}
