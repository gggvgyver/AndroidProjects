package com.hks.kotlin_grammer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main1()
        main2()
        main3()
        main4() // 명시적 형변환 cf) 묵시적 형변환 지원불가
        main5() // 배열 cf) 한번선언후 변경 불가

        var a: Int = main6(1, 2, 3) // 리턴값을 발생하는 함수 호출
        Log.d("확인", "$a")

        var d: Int = main6a(1, 2, 3) // 리턴값을 발생하는 함수 호출 다른표현
        Log.d("확인", "$d")

        main7()
        main8(200000) // when 조건문 테스트 cf) 먼저 부합되는 조건만 실행됨
        main8(12L)

        main9a() // 반복연산자 cf) 전위
        Log.d("확인", "----------------------------------------------------")
        main9b() // 반복연산자 cf) 후위
        Log.d("확인", "----------------------------------------------------")

        main10() // 반복연산자 for cf) in: 범위 step: 간격
        main11() // downTo: 감소
        main12() // 문자도 사용가능

        Log.d("확인", "---------------break---------------------------")
        main13a() // break
        Log.d("확인", "---------------continue------------------------")
        main13b() //continue

        main14a()
        Log.d("확인", "---------------loop 사용 유무------------------------")
        main14b() // 일반 break 사용했을떄
        Log.d("확인", "---------------loop 사용 유무------------------------")
        main14c() // loop@ ~ @loop 를 사용해서 break continue 지정

        Log.d("확인", "---------------클래스 사용------------------------")
        var b = Person1("홍길이", 1999)
        var c = Person1("홍길삼", 1998)
        b.introduce()
        c.introduce()
        Log.d("확인", "---------------클래스 사용 기본생성자 init--------------------")
        // 클래스의 생성자는 인스턴스의 속성을 초기화, 인스턴스 생성시 구문을 수행행  init
        var e = Person2("홍길삼", 1998)
        var f = Person2("홍길사", 1998)
        Log.d("확인", "------클래스 사용 보조생성자 constructor-------------")
        // 보조생성자 테스트를 위해 연도없이 이름만으로 인스턴스 생성
        var g = Person3("황별이")
        var h = Person3("황별삼")
        var i = Person3("황별사")

        Log.d("확인", "------원래클래스 와 상속받은 클래스 비교-------------")
        var j = Animal("별이", 6, "개")
        var k = Dog("별이", 6)

        j.introduce()
        k.introduce()
        k.bark()

        Log.d("확인", "------오버라이딩 테스트-------------")
        // 수퍼클래스에서 open이 붙은 함수는 서브클래스에서 'override'를 붙여 재구현 가능
        var t = Tiger()
        t.eat()

        Log.d("확인", "------추상함수 테스트-------------")
        //추상함수는 단독으로 인스턴스를 만들수 없다.  즉 상속을 받아 사용가능
        var r = Rabbit()
        r.eat()
        r.sniff()
        Log.d("확인", "------인터페이스 테스트-------------")
        // 코틀린에서 인터페이스는 속성과 추상함수 그리고 일반함수를 가질수있다
        // 다만 추상함수는 생성자를 가질수 있지만 인터페이스는 생성자를 가질수 없다
        // 구현부에서 open, abstract 같은 키워드가 없어도 서브클래스에서 구현 및 재정의 가능
        // 오버라이딩이란 이미 구현이 끝난 함수의 기능을 서브클래스에서 변경해야 할때
        var dog2 = Dog2()
        dog2.eat()
        dog2.run()
        // 자바와 달린 코틀린에서는 폴더구조와 패키지명(논리적)을 일치시키지 않아도 됨
        Log.d("확인", "------고차함수 테스트-------------")
        hf2(::hf1)
        Log.d("확인", "------람다함수 테스트-------------")
        // 람다함수는 그자체가 고차함수
        val lamda: (String) -> Unit = {str -> Log.d("확인", "$str 람다함수")}
        hf2(lamda)
        Log.d("확인", "------스코프함수 테스트-------------")
        // 함수형 언어의 특징을 좀더 편리하게 사용할 수 있도록 기본 제공하는 함수
        // apply, run, with, also, let  코드의 가독성을 향상시키는 장점이 있음

        var price = 5000

        var book = Book("별이의 코틀린", 10000).apply {
            name = "[초특가]" + name
            discount()
        }

        book.run {
            Log.d("확인", "상품명: $name, 가격: $price")
        }

        book.let {
            Log.d("확인", "상품명: ${it.name}, 가격: ${it.price}")
        }

        Log.d("확인", "------오브젝트 테스트-------------")
        // 생성자 없이 객체를 직접 만듦
        // Singleton Pattern : 클래스의 인스턴스를 단 하나만 만들어 사용
        Log.d("확인", "${Counter.count}")
        Counter.countUp()
        Counter.countUp()
        Log.d("확인", "${Counter.count}")
        Counter.clear()
        Log.d("확인", "${Counter.count}")

        // 클래스내에 오브젝트 -> companion object
        Log.d("확인", "------컴페니언 오브젝트 테스트-------------")
        var food_a = FoodPoll("짜장")
        var food_b = FoodPoll("짬뽕")

        food_a.vote()
        food_a.vote()

        food_b.vote()
        food_b.vote()
        food_b.vote()

        Log.d("확인", "${food_a.name}: ${food_a.count}")
        Log.d("확인", "${food_b.name}: ${food_b.count}")
        Log.d("확인", "총계: ${FoodPoll.total}")

        Log.d("확인", "------옵저버 패턴 테스트-------------")
        // 함수로 직접요청하지 않았지만 시스템 혹은 루틴에 의해서 발생하게 되는 동작을
        // 이벤트라(key입력) 부르며 이벤트 발생시 처리 2개의 클래스가 필요
        // 1. 이벤트 수신
        // 2. 이벤트의 발생 및 전달
        // 이벤트를 넘겨주는 행위를 call back
        // class EventPrinter----------interface EventListener--------------class Counter
        EventPrinter().start()
        Log.d("확인", "------다형성 테스트-------------")
        var drink_a = Drink()
        drink_a.drink()

        var drink_b: Drink = Cola()
        drink_b.drink() // 오버라이드된 함수를 실행
        // drink_b.washdishes()  참조할수 없음
        if(drink_b is Cola) { // 다운캐스팅
            drink_b.washDishes()
        }
        Log.d("확인", "------다운캐스팅 테스트-------------")
        var drink_c = drink_b as Cola
        drink_c.washDishes()
        drink_b.washDishes()
        Log.d("확인", "------제너릭 테스트-------------")
        UsingGeneric(A()).doShouting()
        UsingGeneric(B()).doShouting()
        UsingGeneric(C()).doShouting()
        // 제너릭사용 주 목적은 캐스팅을 방지해서 성능을 높일 수 있다
        doShouting(B())
        Log.d("확인", "------리스트 테스트-------------")
        list_test()
        Log.d("확인", "------문자열 테스트1-------------")
        stringTest1()
        Log.d("확인", "------문자열 테스트2-------------")
        // 문자열이 공백인지 확인하는 함수  true or false 반환
        // 1. isNullOrEmpty()
        // 2. isNullOrBlank()
        stringTest2()
        Log.d("확인", "---null값을 처리하는 방법? 동일한지 확인-------------")
        // ?.   null safe operator
        // ?:   elvis operator
        // !!.  non-null assertion operator
        //nullConfirm1()
        //nullConfirm2()
        Log.d("확인", "---내용과 객체의 동일성 확인-------------")
        // 내용의 동일성: a == b           다른 메모리 주소에 있어도 내용이 같다면
        // 객체의 동일성: a === b
        var pa = Product("콜라", 1000)
        var pb = Product("콜라", 1000)
        var pc = pa
        var pd = Product("사이다", 1000)

        Log.d("확인", "${pa == pb}")
        Log.d("확인", "${pa === pb}")
        Log.d("확인", "---객체의 동일성 확인-------------")
        Log.d("확인", "${pa == pc}")
        Log.d("확인", "${pa === pc}")
        Log.d("확인", "---객체의 동일성 확인-------------")
        Log.d("확인", "${pa == pd}")
        Log.d("확인", "${pa === pd}")

        Log.d("확인", "---오보로딩(오버라이딩과 틀림)------------")
        read(7)
        read("별이야 넌 맨날 자냐?")
        Log.d("확인", "---오보로딩 기본값 할당------------")
        deliveryItem("짬뽕")
        deliveryItem("책", 3)
        deliveryItem("노트북", 30, "학교")

        deliveryItem("선물", destination = "친구집")

        Log.d("확인", "---갯수가 지정되지 않은 파라미터 vararg 테스트------------")
        sum(1, 2, 3, 4)
        Log.d("확인", "---infix 테스트------------")
        Log.d("확인", "${6 multiply 4}")
        Log.d("확인", "${6.multiply(4)}")
///////////////////////////////////////////////////////////////////////////////////////////////////
    }

    fun main1() {
        var a: Int = 777  // 타입추론기능으로 var a = 777 사용해도 무방
        Log.d("확인", "$a")
    }

    fun main2() {
        var a: Int? = null
        Log.d("확인", "$a")
    }

    fun main3() {
        var a: Boolean = false
        Log.d("확인", "$a")
    }

    fun main4() {
        var b: Int = 54321
        var a: Long = b.toLong()

        Log.d("확인", "$a")
    }

    fun main5() {
        var a = arrayOf(1, 2, 3, 4, 5)
        var nullArr = arrayOfNulls<Int>(5)
        nullArr[3] = 3

        for(i in nullArr)
        Log.d("확인", "$i")
    }

    fun main6(a: Int, b: Int, c:Int): Int {
        return a + b + c
    }

    fun main6a(a: Int, b: Int, c:Int): Int = a + b + c

    fun main7() {
        var a = 11
        if(a > 10) {
            Log.d("확인", "참")
        } else {
            Log.d("확인", "거짓")
        }
    }

    fun main8(a: Any) {
        when(a) {
            1 -> Log.d("확인", "Int형")
            "별이" -> Log.d("확인", "문자형")
            is Long -> Log.d("확인", "Long형")
            !is String -> Log.d("확인", "문자형이 아님")
            else -> Log.d("확인", "어떤조건에도 만족하지 않음")
        }
    }

    fun main9a() {
        var a = 1
        while (a < 10) {
            ++a
            Log.d("확인", "$a")
        }
    }

    fun main9b() {
        var a = 1
        while (a < 10) {
            a++
            Log.d("확인", "$a")
        }
    }

    fun main10() {
        for(i in 0..9) Log.d("확인", "$i")
    }

    fun main11() {
        for(i in 9 downTo 0 step 2) Log.d("확인", "$i")
    }

    fun main12() {
        for(i in 'a'..'f') Log.d("확인", "$i")
    }

    fun main13a() {
        for(i in 1..10) {
            if(i == 3) break
            Log.d("확인", "$i")
        }
    }

    fun main13b() {
        for(i in 1..10) {
            if(i == 3) continue
            Log.d("확인", "$i")
        }
    }

    fun main14a() {
        for(i in 1..5) {
            for(k in 1..5) {
                Log.d("확인", "i: $i  k: $k")
            }
        }
    }

    fun main14b() {
        for(i in 1..5) {
            for(k in 1..5) {
                if(i == 2 && k == 3) break
                Log.d("확인", "i: $i  k: $k")
            }
        }
    }

    fun main14c() {
        loop@for(i in 1..5) {
            for(k in 1..5) {
                if(i == 2 && k == 3) break@loop
                Log.d("확인", "i: $i  k: $k")
            }
        }
    }
}

class Person1 (var name: String, var birthYear: Int) {
    fun introduce() {
        Log.d("확인", "${birthYear}년생 ${name} 입니다")
    }
}

class Person2 (var name: String, var birthYear: Int) {
    init {
        Log.d("확인", "${this.birthYear}년생 ${this.name} 입니다")
    }
}

class Person3 (var name: String, var birthYear: Int) {
    init {
        Log.d("확인", "${this.birthYear}년생 ${this.name} 입니다")
    }

    constructor(name: String): this(name, 1997) {
        Log.d("확인", "보조생성자 constructor 가 생성됨")
    }
}

// open 키워드가 있어야 자식에게 상속가능
open class Animal (var name: String, var age: Int, var type: String) {
    fun introduce() {
        Log.d("확인", "저는 $type $name 이고, $age 살 입니다.")
    }
}

class Dog (name: String, age: Int) : Animal (name, age, "개") {
    fun bark() {
        Log.d("확인", "멍멍")
    }
}

// 오버라이딩 테스트
open class Animal2 {
    open fun eat() {
        Log.d("확인", "음식을 먹습니다")
    }
}

class Tiger : Animal2() {
    override fun eat() {
        Log.d("확인", "고기를 먹습니다")
    }
}

abstract class Animal3() {
    abstract fun eat()
    fun sniff() {
        Log.d("확인", "킁킁")
    }
}

class Rabbit : Animal3() {
    override fun eat() {
        Log.d("확인", "당근을 먹습니다")
    }
}

interface Runner {
    fun run() // 키워드 abstract 생략
}

interface Eater {
    fun eat() { // 키워드 oben 생략
        Log.d("확인", "음식을 먹습니다")
    }
}

class Dog2 : Runner, Eater {
    override fun run() {
        Log.d("확인", "우다다다 뜁니다")
    }

    override fun eat() {
        Log.d("확인", "허겁지겁 먹습니다")
    }
}

fun hf1 (str: String) {
    Log.d("확인", "$str 함수 hf1")
}

fun hf2 (function: (String)->Unit) {
    function("hf2가 호출한")
}

class Book (var name: String, var price: Int) {
    fun discount() {
        price -= 2000
    }
}

object Counter {
    var count = 0

    fun countUp() {
        count++
    }
    fun clear() {
        count = 0
    }
}

class FoodPoll (var name: String) {
    companion object {
        var total = 0
    }

    var count = 0

    fun vote() {
        total++
        count++
    }
}

interface EventListener {
    fun onEvent(count: Int)
}

class EventCounter (var listener: EventListener) {
    fun count() {
        for(i in 1..100) {
            if(i % 5 ==0 ) listener.onEvent(i)
        }
    }
}

class EventPrinter: EventListener {
    override fun onEvent(count: Int) {
        Log.d("확인", "${count}")
    }
    fun start() {
        val counter = EventCounter(this)
        counter.count()
    }
}

////////////////////////////다형성 테스트////////////////////////////////
open class Drink {
    var name = "음료"

    open fun drink() {
        Log.d("확인", "$name 을 마십니다")
    }
}

class Cola: Drink() {
    var type = "콜라"

    override fun drink() {
        Log.d("확인", "$name 중에 $type 을 마십니다.")
    }

    fun washDishes() {
        Log.d("확인", "$type 로 설거지를 합니다.")
    }
}
////////////////////////////제너릭 테스트////////////////////////////////
open class A {
    open fun shout() {
        Log.d("확인", "A가 소리 칩니다")
    }
}

class B: A() {
    override fun shout() {
        Log.d("확인", "B가 소리 칩니다")
    }
}

class C: A() {
    override fun shout() {
        Log.d("확인", "C가 소리 칩니다")
    }
}

class UsingGeneric<T: A> (val t: T) {
    fun doShouting() {
        t.shout()
    }
}


fun <T: A> doShouting(t: T) {
    t.shout()
}

////////////////////////////리스트 테스트////////////////////////////////
fun list_test() {
    val a = listOf("사과", "딸기", "배")
    Log.d("확인", "${a[1]}")

    for(fruits in a) {
        Log.d("확인", "$fruits :")
    }

    Log.d("확인", "-----------------------------------")

    val b = mutableListOf(6, 3, 1)
    Log.d("확인", "$b")

    b.add(4)
    Log.d("확인", "$b")

    b.add(2, 8)
    Log.d("확인", "$b")

    b.removeAt(1)
    Log.d("확인", "$b")

    b.shuffle()
    Log.d("확인", "$b")

    b.sort()
    Log.d("확인", "$b")
}
////////////////////////////문자열 테스트1////////////////////////////////
fun stringTest1() {
    val test1 = "Test.Kotlin.String"
    Log.d("확인", "${test1.length}")
    Log.d("확인", "${test1.toLowerCase()}")
    Log.d("확인", "${test1.toUpperCase()}")

    val test2 = test1.split(".")
    Log.d("확인", "$test2")

    Log.d("확인", "${test2.joinToString()}")
    Log.d("확인", "${test2.joinToString("-")}")

    Log.d("확인", "${test1.substring(5..10)}")
}
////////////////////////////문자열 테스트2////////////////////////////////
fun stringTest2() {
    val nullString: String? = null
    val emptyString = ""
    val blankString = " "
    val normalString = "A"

    Log.d("확인", "${nullString.isNullOrEmpty()}")
    Log.d("확인", "${emptyString.isNullOrEmpty()}")
    Log.d("확인", "${blankString.isNullOrEmpty()}")
    Log.d("확인", "${normalString.isNullOrEmpty()}")
    Log.d("확인", "--------------------------------------------")
    Log.d("확인", "${nullString.isNullOrBlank()}")
    Log.d("확인", "${emptyString.isNullOrBlank()}")
    Log.d("확인", "${blankString.isNullOrBlank()}")
    Log.d("확인", "${normalString.isNullOrBlank()}")
}
////////////////////////////null값을 처리하는 방법1////////////////////////////////
fun nullConfirm1() {
    var a: String? = null
    Log.d("확인", "${a?.toUpperCase()}")
    Log.d("확인", "${a?:"default".toUpperCase()}")
    Log.d("확인", "${a!!.toUpperCase()}")
}
////////////////////////////null값을 처리하는 방법2////////////////////////////////
fun nullConfirm2() {
    var a: String? = "Kotlin Exam"

    a?.run {
        Log.d("확인", "${a.toUpperCase()}")
        Log.d("확인", "${a.toLowerCase()}")
    }
}
////////////////////////////내용의 동일성 확인////////////////////////////////
class Product(val name: String, val price: Int) {
    override fun equals(other: Any?): Boolean {
        if(other is Product) {
            return other.name == name && other.price == price
        } else {
            return false
        }
    }
}
////////////////////////////오버로딩 확인////////////////////////////////
fun read(x: Int) {
    Log.d("확인", "숫자 $x 입니다")
}
fun read(x: String) {
    Log.d("확인", "$x ")
}
////////////////////////////오버로딩 기본값 확인////////////////////////////////
fun deliveryItem(name: String, count: Int = 1, destination: String = "집") {
    Log.d("확인", "$name , $count 개를 $destination 에 배달하였습니다.")
}
////////////////////////////vararg 테스트////////////////////////////////
fun sum(vararg numbers: Int) {
    var sum = 0

    for(n in numbers) {
        sum += n
    }

    Log.d("확인", "총합: $sum")
}
////////////////////////////infix 테스트////////////////////////////////
infix fun Int.multiply(x: Int): Int = this * x
