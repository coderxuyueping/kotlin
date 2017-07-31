package com.xyp.tiange

import java.lang.Integer.parseInt

/**
 * User: xyp
 * main函数跟其他语言是一样的，入口函数
 * kotlin语法类似objective c
 * 注意：类名不要起main.kt
 */
fun main(args:Array<String>){
    printSum(5,5)
    println(sum(2,3))
    fun1()
    fun5()
    fun8()
    fun9()
    fun10()
}

/**
 * 函数，？代表可以为null，在java中如果是null的话编译不会报错但是运行会报错。
 * 但是在kotlin中可以为null不报错
 * 当null可能出现的时候，引用必须明确标记出可为null
 */
fun add(a: Int, b: Int):String?{
    var result: Int = a+b
    var temp: String
    if(result > 5){
        temp = "yes"
    }else{
        temp = "no"
    }
    return temp
}

/**
 *函数体可以为表达式，kotlin可以自动判断出他的返回类型
 */
fun sum(a: Int, b: Int) = a+b

/**
 * Unit代表返回无意义的值，他等同于后面不加返回值
 * 等同于printSum
 * 函数的形参可以带默认值
 */
fun printSumUnit(a: Int = 0, b: Int = 1):Unit{
    println(a+b)
}

public fun printSum(a: Int, b: Int){
    println(a+b)
}

fun fun1(){
    var a: Int = 1
    var b: Int//给定类型的局部变量
    var c = 1//给定值kotlin可以自动推算出为Int类型的变量
    var d = "d is $c"
    println("is $a ${ a+c }")//使用字符串模版
}

/**
 * Any是任意类型，类似Object
 * 做过类型判断就不再需要类型转换了
 */
fun fun2(obj: Any){
    if(obj is String)//is 类似于instance of
        println(obj)
}

fun fun3(a: Int,b: Int) = if(a>b) a else b

fun fun4(a: String, b: String){
    var c = parseInt(a)
    var d = parseInt(b)
    //有可能为null,不是int类型的string无法转换为int
    if(c != null && d != null)
        println(c*d)
    else
        println("a & b is not num")
}

fun fun5(){
    var a = listOf("a", "b", "c")
    //这个取得是下标，类似普通for
    for(b in a.indices)
        println("indices is $b,content is ${a[b]}")
    //这个取得 是值，类似增强for
    for(d in a)
        println(d)

    //判断集合是否包含“a”
    if("a" in a)
        println(true)
}

fun fun6(){
    var a = listOf("a", "b", "c")
    var index = 0
    while(index < a.size){
        println("index is $index,content is ${a[index]}")
        index ++
    }
}

/**
 * when 类似case分支,但是这里的可以为任意值，没有强调一定要int
 * 这里用了函数表达式
 */
fun fun7(obj: Any): String =
        when(obj){
            1           -> "one"
            "hello"     ->  "is string"
            is Long     ->  "is long"
            !is String  ->"is not string"
            else        -> "unknown"
        }

/**
 * 判断是否在xxx范围内
 */
fun funRange(){
    var x = 10;
    var y = 11;
    if(x in 1..y)
        println("$x in y")

    var a = listOf("a", "b")
    if(x !in 0..a.size)
        println("x not in list of a")
}

/**
 * step
 */
fun fun8(){
    //从1到10中每隔2步取值,闭区间，包含10
    for(x in 1..10 step 2){
        println(x)
    }
    //半开区间，不包含10
    for(x in 1 until 10)
        println(x)
    //降序
    for(x in 10 downTo 1 step 2)
        println(x)
}

fun fun9(){
    var a = listOf(1,2,-1,3)
    //过滤小于0的值
    var b = a.filter { x -> x>0 }
    println(b)
    //也可以这样写
    var d = a.filter { it>0 }
    println(d)

    var e = a.map { it*2 }
    println(e)

    //非空判断,就是如果a集合不为null，输出size
    println(a?.size)
    //lambda
    a.filter { it>0 }.map { it*2 }
}

/**
 * map 键值对
 */
fun fun10(){
    var a = mapOf("a" to 1, "b" to 2)
    for((k,v) in a)
        println("key is $k,value is $v")

    println(a["a"])

    var result = try{
        a["c"]
    }catch (e: Exception){

    }
}
