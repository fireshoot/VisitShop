package com.bdqn.visitshop.activity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.bdqn.visitshop.MainActivity;
import com.bdqn.visitshop.R;

import org.litepal.tablemanager.Connector;

public class LoginActivity extends AppCompatActivity {

    private EditText mEtName;
    private EditText mEtPassword;
    private TextInputLayout mEtName_design;
    private TextInputLayout mEtPassword_design;
    private Button mBtnLogin;
    private String mUserName;
    private String mPassWord;
    private RelativeLayout mRelLoading;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        SQLiteDatabase db = Connector.getDatabase();
        if (checkLogin()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        } else {
            initStatusBarColor();
            bindViews();
            initListener();
        }
    }

    private boolean checkLogin() {
        //获取数据库用户

        return false;
    }

    /**
     * 初始化控件
     */
    private void bindViews() {
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mEtName_design = (TextInputLayout) findViewById(R.id.et_name_design);
        mEtPassword_design = (TextInputLayout) findViewById(R.id.et_password_design);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mRelLoading = (RelativeLayout) findViewById(R.id.loading);

        mEtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mEtName_design.setErrorEnabled(false);
            }
        });
        mEtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mEtPassword_design.setErrorEnabled(false);
            }
        });
    }

    /**
     * 初始化监听器
     */
    private void initListener() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    /**
     * 登录
     */
    private void login() {
        if (checkData()) {
            mRelLoading.setVisibility(View.VISIBLE);
            //发送登录请求，网络验证
        }
    }

    /**
     * 检查登录数据是否合法
     */
    private boolean checkData() {
        mUserName = mEtName.getText().toString().trim();
        mPassWord = mEtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(mUserName.trim())) {
            mEtName_design.setError("用户名不能为空");
            return false;
        }
        if (mUserName.trim().length() < 0 || mUserName.trim().length() > 6) {
            mEtName_design.setError("请输入6位数以内的用户名");
            return false;
        }
        if (TextUtils.isEmpty(mPassWord)) {
            mEtPassword_design.setError("密码不能为空");
            return false;
        }
        return true;
    }

    /**
     * 初始化状态栏颜色透明，和背景色一致
     */
    private void initStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

}
