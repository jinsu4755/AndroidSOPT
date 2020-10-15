## 구현방법

기본적으로 로그인과 로그아웃의 기능은 필수과제2번을 따라 만들었다.

SharedPreference를 사용하여 안드로이드 내부에 사용자가 입력한 id/pw를 저장하는 

SaveSharedPreferences class를 작성하여 사용자의 id/pw를 prefs_data라는 파일에 저장시키고 id와 pw는 내부 맴버로 getter와 setter를 임의로 설정하여 저장하고 불러올 수 있도록 제작하였다.

또한 자동으로 로그인 처리를 위해서는 SharedPreference가 먼저 실행되어야한다 하여 Application을 상속받는 App 클래스로 companion object로 SaveSharedPreferences를 선언하고 생성시에 정의할 수 있도록 하였으며

manifests에 name으로 .App 등록하여 구현하였다.

일반적으로 바로 화면이 넘어가는 것으로 확인하여 로그인창에서 editText에 유저 정보가 입력되어있게 만들고 해당 창을 1초간 보여준후 화면이 넘어가도록 구현하였다.



## 새롭게 알게된점

SharedPreference를 이용하면 자체적으로 사용자가 입력한 정보를 저장할 수 있다는 것을 알았으며 이는 xml형태로 저장된다는 것을 알았다.

따라서 id/pw를 담을때 해당 정보가 유출될 것을 대비하여 암호화 하거나 처리하는 방법들이 존재함을 알고 공부해볼 예정이다.

AndroidManifest.xml에 `<application>` 내에 `android:name`으로 어플리케이션 프로세스가 시작될때, 다른 어떤 컴포넌트보다 먼저 실행하는 클래스를 설정할 수 있는 것을 알았다.

