# 软件项目研发实践——实验2（构建首个Kotlin应用）

## 一、项目初始化（生成应用程序，创建虚拟设备）
- ![image1](https://github.com/Shawpromax/images/blob/main/2_1.jpg)
- ![image2](https://github.com/Shawpromax/images/blob/main/2_2.jpg)
- ![image3](https://github.com/Shawpromax/images/blob/main/2_3.jpg)

## 二、第一个界面的相关操作（布局修改fragment_first.xml，功能修改FirstFragment.kt）
- 修改背景色
```
    android:background="#FAD8D8"
```
- 1.TextView_first的相关布局代码如下
 ```    <TextView
        android:id="@+id/textview_first"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:fontFamily="sans-serif-condensed"
        android:text="0"
        android:textColor="#3F51B5"
        android:textSize="30sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.499" />
```
- 2.按钮toast的相关布局代码如下
```
    <Button
        android:id="@+id/toast_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="24dp"
        android:backgroundTint="#2196F3"
        android:text="@string/toast_button_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textview_first"
        app:layout_constraintVertical_bias="0.3" />
```
- 3.按钮count的相关布局代码如下
```
<Button
        android:id="@+id/count_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:backgroundTint="#2196F3"
        android:text="@string/count_button_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/random_button"
        app:layout_constraintStart_toEndOf="@+id/toast_button"
        app:layout_constraintTop_toBottomOf="@+id/textview_first"
        app:layout_constraintVertical_bias="0.3" />
```
- 4.给toast按钮添加一个toast消息
 ```
        // find the toast_button by its ID and set a click listener,TOAST按钮添加一个toast消息
        view.findViewById<Button>(R.id.toast_button).setOnClickListener {
        // create a Toast with some text, to appear for a short time
        val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_LONG)
        // show the Toast
        myToast.show()
 ```

- 5.给count按钮添加一个能够更新屏幕的数字的功能
 ```
        //使Count按钮更新屏幕的数字,此步骤向Count按钮添加事件响应，更新Textview的文本显示。
        view.findViewById<Button>(R.id.count_button).setOnClickListener {
            countMe(view)
        }
 ```
- //countMe()为自定义方法，以View为参数，每次点击增加数字1，具体代码为：
 ```
 private fun countMe(view: View) {
   // Get the text view
   val showCountTextView = view.findViewById<TextView>(R.id.textview_first)

   // Get the value of the text view.
   val countString = showCountTextView.text.toString()

   // Convert value to a number and increment it
   var count = countString.toInt()
   count++

   // Display the new value in the text view.
   showCountTextView.text = count.toString()
}
 ``` 
 - 6.第一个界面的效果展示如下
- ![image4](https://github.com/Shawpromax/images/blob/main/2_4.jpg)
- ![image5](https://github.com/Shawpromax/images/blob/main/2_5.jpg)
- ![image6](https://github.com/Shawpromax/images/blob/main/2_6.jpg)

## 三、第二个界面的相关操作（随机数,布局修改fragment_second.xml，功能修改SecondFragment.kt）
- 1.更新显示界面文本的TextView
```
    <TextView
        android:id="@+id/textview_header"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="24dp"
        android:layout_marginTop="28dp"
        android:layout_marginEnd="24dp"
        android:text="@string/random_heading"
        android:textColor="@android:color/black"
        android:textSize="24sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

- 2.向界面添加显示随机数的TextView
```
    <TextView
        android:id="@+id/textview_random"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="R"
        android:textColor="@android:color/white"
        android:textSize="72sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toTopOf="@+id/button_second"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textview_header"
        app:layout_constraintVertical_bias="0.45" />
```

- 3.更改界面的背景色和布局
```
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FAD8D8"
```

- 4.将按钮移动至界面的底部，完成所有布局
```
    <Button
        android:id="@+id/button_second"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/previous"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/textview_header"
        app:layout_constraintVertical_bias="0.973" />
```

- 5.检查导航图(本项目选择Android的Basic Activity类型进行创建，默认情况下自带两个Fragments，并使用Android的导航机制Navigation。导航将使用按钮在两个Fragment之间进行跳转，就第一个Fragment修改后的Random按钮和第二个Fragment的Previous按钮。)
- ![image7](https://github.com/Shawpromax/images/blob/main/2_8.jpg)
- ![image8](https://github.com/Shawpromax/images/blob/main/2_9.jpg)

- 6.启用SafeArgs(SafeArgs 是一个 gradle 插件，它可以帮助您在导航图中输入需要传递的数据信息，作用类似于Activity之间传递数据的Bundle)
- build.gradle(Project)新增代码如下
```
plugins {
    id 'com.android.application' version '7.1.3' apply false
    id 'com.android.library' version '7.1.3' apply false
    id 'org.jetbrains.kotlin.android' version '1.5.30' apply false
    **id 'androidx.navigation.safeargs.kotlin' version '2.5.0-alpha01' apply false**
}
```
- build.gradle(Module)新增代码如下
```
plugins {

    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    **id 'androidx.navigation.safeargs'**
}
```

- 7.FirstFragment添加代码，向SecondFragment发数据(FirstFragment.kt===>onViewCreated())
```
        binding.randomButton.setOnClickListener {
            //找到onViewCreated()方法，该方法在onCreateView方法之后被调用，可以实现组件的初始化。找到Random按钮的响应代码，注释掉原先的事件处理代码
            //实例化TextView，获取TextView中文本并转换为整数值
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
            val currentCount = showCountTextView.text.toString().toInt()
            //将currentCount作为参数传递给actionFirstFragmentToSecondFragment()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            //添加导航事件代码
            findNavController().navigate(action)
        }
```

- 8.添加SecondFragment的代码,接受传递过来的整型参数并进行处理(SecondFragment.kt===>onViewCreated())
```
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //onViewCreated()代码之前添加一行
        val args: SecondFragmentArgs by navArgs()
        //onViewCreated()中获取传递过来的参数列表，提取count数值，并在textview_header中显示
        val count = args.myArg
        val countText = getString(R.string.random_heading, count)
        view.findViewById<TextView>(R.id.textview_header).text = countText
        //根据count值生成随机数
        val random = java.util.Random()
        var randomNumber = 0
        if (count > 0) {
            randomNumber = random.nextInt(count + 1)
        }
        //textview_random中显示count值
        view.findViewById<TextView>(R.id.textview_random).text = randomNumber.toString()


        super.onViewCreated(view, savedInstanceState)
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
```

- 9.运行结果如下
- - ![image9](https://github.com/Shawpromax/images/blob/main/2_7.jpg)
  




