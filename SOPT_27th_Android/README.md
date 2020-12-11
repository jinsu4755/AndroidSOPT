# ✅SOPT_27 Android

> 각 주차마다 branch를 만들어 기록하고있습니다.
>
> Master에서는 가장 마지막의 과제 정보를 담고있습니다. 이전 과제 정보는 branch를 변경하시면 볼 수 있습니다.

| 주차 | 과제 내용        | 과제 README 링크                                             |
| ---- | ---------------- | ------------------------------------------------------------ |
| 1    | 필수,성장1,성장2 | [1차 세미나 과제 README](https://github.com/jinsu4755/AndroidSOPT/blob/week1(MVVM)-login%2CsignUp%2CAutoLogin/SOPT_27th_Android/README.md) |
| 2    |                  |                                                              |
| 3    |                  |                                                              |
| 4    |                  |                                                              |
| 6    |                  |                                                              |



## 1️⃣2020/12/10 2차 세미나 과제

### ◾ Preview

<img src="./README/week2/week2.gif" style="zoom: 50%;" />

---

### ◾ Feature

- SignUp
- Login
  - AutoLogin
- Home
  - List Layout
  - Grid Layout

---

### ◾ How?

심화 스터디에서 학습한 MVVM을 사용하며 객체지향 생활체조 원칙을 지키기 위해서 노력했습니다.



#### ◾ [필수]  로그인 이후 RecyclerView

🥕 : 어뎁터에 데이터를 넣는 것을 외부에서 행하지 않고 최대한 어뎁터를 recyclerView에 보여주기 위한 데이터의 일급 컬랙션으로 사용하기를 의도하였습니다.

```kotlin
private val data: MutableList<PortfolioDomain> = mutableListOf()
```

기본적으로 data를 MutableList로 선언하며 외부에서 접근이 불가능합니다.

```kotlin
    fun addAllData(list: List<PortfolioDomain>) {
        data.addAll(list)
        notifyDataSetChanged()
    }
```

외부에서 해당 data를 가져갈일도 없고 밖에서 setting하는 경우는 몇 없기에 확장성을 고려해 모든 데이터를 넣는 메소드를 제작 하였습니다.



```kotlin
inner class ViewHolder(
        private val binding: ItemPortfolioBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(customData: PortfolioDomain) {
            binding.portfolio = customData
            itemView.setOnClickListener{clickDetail(customData.html_url)}
        }

        private fun clickDetail(url:String) {
            onDetailClickListener?.invoke(url)
        }

    }
```

ViewHolder는 Adapter의 inner class로 작성하여 외부로부터 클릭 이벤트를 주입받습니다.

```kotlin
    private var onDetailClickListener: ((url:String) -> Unit)? = null

    fun addOnDetailClickListener(listener: (url:String) -> Unit) {
        this.onDetailClickListener = listener
    }
```

리스너는 url이라는 String값을 사용하는 함수를 받으며 Fragment에서 해당 url을 이용하여 webView를 띄워주는 행동을 하는 메소드를 주입받아 실행됩니다.

#### ◾ [성장1] 

🥕 : 상단 택스트 버튼을 활용하여 Grid와 List Layout를 전환 할 수 있도록 하였습니다.

```xml
        <TextView
            android:id="@+id/portfolio_layout_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:onClick="@{()->MainViewModel.onLayoutTypeClick()}"
            android:paddingHorizontal="32dp"
            android:paddingVertical="8dp"
            android:text="@{MainViewModel.layoutType}"
            android:textColor="@color/button_click_yellow_to_white"
            android:textSize="16dp"
            android:textStyle="bold"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            />
```

```kotlin
class MainViewModel : ViewModel() {
    private val _layoutType = MutableLiveData(LIST_LAYOUT)
    val layoutType: LiveData<String>
        get() = _layoutType

    fun onLayoutTypeClick() {
        if (_layoutType.value == LIST_LAYOUT) {
            _layoutType.value = GRID_LAYOUT
            return
        }
        _layoutType.value = LIST_LAYOUT
    }


    companion object {
        const val LIST_LAYOUT = "LIST"
        const val GRID_LAYOUT = "GRID"
    }
}
```






