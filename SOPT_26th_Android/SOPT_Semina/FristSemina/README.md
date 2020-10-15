# 1차 세미나

[공식문서](https://developer.android.com/training/basics/firstapp/building-ui.html)

## View 계층 구조 이해하기

![img](https://k.kakaocdn.net/dn/bsxSgs/btqDxK69oIk/0QU8GgqxivZBwhqwhUMzTK/img.png)



### ViewGroup

View의 부모라고 생각할 수 있으며 ViewGroup내부에 ViewGroup이 들어간 수 있다.

주로 Layout(ConstrainLayout, LinearLayout, RelativeLayout, ...  등)이 ViewGroup이라고 할 수 잇다.



### View

View는 ViewGroup의 자식으로 내부에 들어가는 다양한 위젯을 말한다.

View에는 주로 TextView, EditText, Button, ImageView, RadioButton ... 등이 View라고 할 수 있다.

