package demo.lww.test.ucdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import demo.lww.test.ucdemo1.view.UCIndexView;

public class MainActivity extends AppCompatActivity {
    boolean flag = false;

    private UCIndexView mUCIndexView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc_index_view);
        mUCIndexView = (UCIndexView) findViewById(R.id.ucindexview);
    }


    public  void back(View view){
        if( !mUCIndexView.isPullRestoreEnable()) {
            mUCIndexView.onBackRestore();

        }
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
