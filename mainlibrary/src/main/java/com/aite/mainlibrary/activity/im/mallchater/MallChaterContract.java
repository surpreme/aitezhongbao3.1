package com.aite.mainlibrary.activity.im.mallchater;

import com.lzy.basemodule.mvp.BasePresenter;
import com.lzy.basemodule.mvp.BaseView;
import com.lzy.okgo.model.HttpParams;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MallChaterContract {
    interface View extends BaseView {
        void  onGetIMChatListSuccess(Object msg);
        
    }

    interface  Presenter extends BasePresenter<View> {
        void  onGetIMChatList(HttpParams httpParams);
        
    }
}
