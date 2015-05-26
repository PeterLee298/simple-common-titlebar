package com.ltc.commontitle.sample.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.ltc.share.wechat.WeixinUtil;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

	private static final String TAG = "WXEntryActivity";

	private IWXAPI wxApi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		wxApi = WeixinUtil.getWXApi(this);
		Intent ait = getIntent();
		if (null == ait) {
			finish();
			return;
		}
		wxApi.handleIntent(getIntent(), this);
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);

		setIntent(intent);
		wxApi.handleIntent(intent, this);
	}

	@Override
	public void onReq(BaseReq arg0) {

	}

	@Override
	public void onResp(BaseResp resp) {
		switch (resp.getType()) {
			case ConstantsAPI.COMMAND_SENDAUTH:
				handleWXLoginResp(resp);
				break;
			case ConstantsAPI.COMMAND_SENDMESSAGE_TO_WX:
				//发出分享时设定的此值，作为判定是分享回调的依据
				if (TextUtils.isEmpty(resp.transaction)) break;
				switch (resp.errCode) {
					case BaseResp.ErrCode.ERR_OK: // 分享成功
						Log.e("aaaaaaaaaaaaa", "ERR_OK");
						break;

					case BaseResp.ErrCode.ERR_USER_CANCEL: // 分享取消
						Log.e("aaaaaaaaaaaaa", "ERR_USER_CANCEL");
						break;

					case BaseResp.ErrCode.ERR_AUTH_DENIED: // 分享拒绝
						Log.e("aaaaaaaaaaaaa", "ERR_AUTH_DENIED");
						break;

					default:
				}
				break;
			default:
				break;
		}

		finish();
	}

	private void handleWXLoginResp(BaseResp resp) {
//		SendAuth.Resp sResp = (SendAuth.Resp) resp;
//
//		Bundle pBundle = new Bundle();
//		pBundle.putInt("type", sResp.getType());
//		pBundle.putString("code", sResp.code);
//		pBundle.putString("state", sResp.state);
//		pBundle.putInt("errCode", sResp.errCode);
//
//		Intent pIntent = new Intent(Configuration.BROADCAST_FROM_WXLOGIN);
//		pIntent.putExtras(pBundle);
//		sendBroadcast(pIntent, Configuration.SLEF_BROADCAST_PERMISSION);
	}
}
