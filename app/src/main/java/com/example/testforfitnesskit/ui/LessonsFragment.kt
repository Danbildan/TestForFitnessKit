package com.example.testforfitnesskit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testforfitnesskit.R
import com.example.testforfitnesskit.ui.viewmodel.LessonsViewModel
import com.example.testforfitnesskit.utils.ErrorUtils
import kotlinx.android.synthetic.main.fragment_lessons.*
import java.lang.IllegalArgumentException

class LessonsFragment : Fragment(){
    private lateinit var viewModel: LessonsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lessons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipeRefreshLayout.setOnRefreshListener { viewModel.updateLessons() }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = LessonsViewAdapter()
        viewModel = (context as MainActivity).viewModel

        viewModel.error.observe(viewLifecycleOwner,
            Observer {if(it != ErrorUtils.NONE){
                showError(it)
            }

            })
        viewModel.lessons.observe(viewLifecycleOwner,
            Observer {
                (recyclerView.adapter as LessonsViewAdapter).add(it)
            })
        viewModel.loadingIsVisible.observe(
            viewLifecycleOwner,
            Observer {
                swipeRefreshLayout.isRefreshing = it
                if(it){
                    recyclerView.visibility = View.GONE
                }else{
                    recyclerView.visibility = View.VISIBLE
                }
            })
    }

    private fun showError(errorCode: String){

        val msg = getErrorMessage(errorCode)
        Toast.makeText(activity, msg, Toast.LENGTH_LONG ).show()
    }

    private fun getErrorMessage(errorCode: String) : String?{
        return when(errorCode){
            ErrorUtils.NETWORK_ERROR -> resources.getString(R.string.network_error)
            ErrorUtils.ANY_ERROR -> resources.getString(R.string.any_error)
            else -> throw IllegalArgumentException("no such error code")
        }
    }

}