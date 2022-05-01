package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }
//===================================
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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



        //=================================================================================
        // find the toast_button by its ID and set a click listener,TOAST按钮添加一个toast消息
        view.findViewById<Button>(R.id.toast_button).setOnClickListener {
        // create a Toast with some text, to appear for a short time
        val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_LONG)
        // show the Toast
        myToast.show()
        }



        //=================================================================================
        //使Count按钮更新屏幕的数字,此步骤向Count按钮添加事件响应，更新Textview的文本显示。
        view.findViewById<Button>(R.id.count_button).setOnClickListener {
            countMe(view)
        }

    }
        //countMe()为自定义方法，以View为参数，每次点击增加数字1,点击count按钮时调用
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}