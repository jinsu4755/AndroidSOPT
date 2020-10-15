## 구현방법

Constraint Layout로 기본적으로 배치를 위해서 좌우 padding을 8dp씩 주었다.

ImageView 크기는 match_parent로 길이와 높이 둘다 맞추고

ConstraintDimentionRatio를 사용하여 1대1 비율로 맞추었다.

제목과 시간은 TextView로 구현하였다.

Guideline을 이용하여 내용 TextView를 가이드라인에 관계를 맞추고 match_parent를 주어 끝까지 가지않아도 개행 될 수 있도록 구현하였다.



## 새롭게 알게된 점

ConstraintDimentionRatio를 이용하면 View의 비율을 지정할 수 있다는 것을 알게되었다.

 Guideline을 이용하면 선언한 ViewGroup을 나누어 View를 배치할 수 있다.