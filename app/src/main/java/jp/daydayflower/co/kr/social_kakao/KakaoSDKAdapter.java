package jp.daydayflower.co.kr.social_kakao;
import android.content.Context;
import android.util.Log;

import com.kakao.auth.ApprovalType;
import com.kakao.auth.AuthType;
import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.ISessionConfig;
import com.kakao.auth.KakaoAdapter;

import jp.daydayflower.co.kr.social_kakao.GlobalApplication;

public class KakaoSDKAdapter extends KakaoAdapter {

    //로그인시 사용될, session의 옵션을 설정하기 위한 인터페이스
    @Override
    public ISessionConfig getSessionConfig() {
        return new ISessionConfig() {

            //로그인시 로그인 인증타입을 지정
            @Override
            public AuthType[] getAuthTypes() {
                // Auth Type
                // KAKAO_TALK  : 카카오톡 로그인 타입
                // KAKAO_STORY : 카카오스토리 로그인 타입
                // KAKAO_ACCOUNT : 웹뷰 다이얼로그를 통한 계정연결 타입
                // KAKAO_TALK_EXCLUDE_NATIVE_LOGIN : 카카오톡 로그인 타입과 함께 계정생성을 위한 버튼을 함께 제공
                // KAKAO_LOGIN_ALL : 모든 로그인 방식을 제공
                return new AuthType[] {AuthType.KAKAO_ACCOUNT};
            }

            @Override
            public boolean isUsingWebviewTimer() {
                return false;
            }

            // 로그인 시 토큰을 저장할 때의 암호화 여부를 지정합니다.
            @Override
            public boolean isSecureMode() {
                return false;
            }
            @Override
            public ApprovalType getApprovalType() {
                return ApprovalType.INDIVIDUAL;
            }
            @Override
            public boolean isSaveFormData() {
                return true;
            }
        };
    }
    @Override
    public IApplicationConfig getApplicationConfig() {
        return new IApplicationConfig() {
            @Override
            public Context getApplicationContext() {
                return GlobalApplication.getGlobalApplicationContext();
            }
        };
    }
}
