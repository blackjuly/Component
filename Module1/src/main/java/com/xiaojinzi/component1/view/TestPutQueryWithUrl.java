package com.xiaojinzi.component1.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.xiaojinzi.base.ModuleConfig;
import com.xiaojinzi.base.view.BaseAct;
import com.xiaojinzi.component.anno.ParameterAnno;
import com.xiaojinzi.component.anno.RouterAnno;
import com.xiaojinzi.component.support.ParameterSupport;
import com.xiaojinzi.component1.R;

/**
 * 测试putQuery在使用了 url 之后,貌似之前是 url 使用了,putQuery 就会没有用了
 * 测试的时候这个界面需要每一个值都是有的
 */
@RouterAnno(
        host = ModuleConfig.Module1.NAME,
        path = ModuleConfig.Module1.TEST_PUT_QUERY_WITH_URL
)
public class TestPutQueryWithUrl extends BaseAct {

    @ParameterAnno("nameFromUrl")
    String nameFromUrl;
    @ParameterAnno("nameFromPutQuery")
    String nameFromPutQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component1_test_put_query_with_url_act);
        ParameterSupport.inject(this);
    }

    @Override
    protected boolean isReturn() {
        return true;
    }

    @Override
    protected void returnData() {
        if (check()) {
            setResult(RESULT_OK, null);
        } else {
            setResult(RESULT_ERROR, null);
        }
        finish();
    }

    private boolean check() {
        boolean result = true;
        if (TextUtils.isEmpty(nameFromUrl)) {
            result = false;
        }
        if (TextUtils.isEmpty(nameFromPutQuery)) {
            result = false;
        }
        return result;
    }

}
