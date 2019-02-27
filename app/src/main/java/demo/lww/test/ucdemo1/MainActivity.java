package demo.lww.test.ucdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

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


        mPullToRefreshLayout.setOnRefreshListener(this);
    }


    public  void back(View view){
        if( !mUCIndexView.isPullRestoreEnable()) {
            mUCIndexView.onBackRestore();

        }
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {

    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {

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
