# itemDecoration, clipToPadding

>더욱 자세한 내용은 블로그에 별도 작성하였습니다.
>
>https://antilog.tistory.com/48 -> ItemDecoration
>
>https://antilog.tistory.com/49 -> clipToPadding

**ItemDecoration 이란?**

  해당 추상 클래스를 이용하여 항목, 하이라이트, 시작적 그룹화 경계 사이에 구분선을 그리는데 유용하게 사용할 수 있습니다. 



ListView에는 자체적으로 구분선을 그리는 기능이 있으나

```xml
<ListView
android:id="@+id/lv_main"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:divider="@android:color/black"
android:dividerHeight="4dp"/>
```

RecyclerView의 경우는 ItemDecoration을 사용해야한다.



일반적으로 아래와같이 사용할 수 있다.

```kotlin
val decoration = DividerItemDecoration(applicationContext, VERTICAL)
rv_main.addItemDecoration(decoration)
```

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fdfu062%2FbtqDRxNjbkw%2FnLXaH4VYHoIp19rdiVzkF0%2Fimg.gif)

**clipToPadding**

스크롤 가능한 뷰에서 해당 옵션을 사용할 수 있으며

만약 RecyclerView에 상단과 하단에 Padding이 주어진경우 아래와 같이 padding공간 아래서부터 스크롤이 된다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FX2Jlh%2FbtqDRMXMB0n%2FlKL1meV5hNSLZv6dfDkKo0%2Fimg.gif)

하지만 

```xml
android:clipToPadding="false"
```

옵션을 주면

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FFRn4m%2FbtqDRwt5snM%2F100shGEJ4b48ILoxBgFL3K%2Fimg.gif)

다음과 같이 해당 padding은 시작시 적용되고 스크롤시는 무시되는 모습을 볼 수 있다.